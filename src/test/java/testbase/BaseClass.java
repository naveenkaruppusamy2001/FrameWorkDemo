package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public static  WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups="sanity")
	@Parameters("browser")
	public void setup(String br) throws IOException
	
	{
		
		
		FileReader file =new FileReader("C:\\Users\\gopik\\eclipse-workspace\\FrameWorkDemo\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());  //to log the loggers used this 
		
		
		switch (br.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser");
			return;
		}
		      
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass(groups="sanity")
	public void tearDown() 
	{
		driver.close();
	}
	
	public String randomAlphabts()
	{
		@SuppressWarnings("deprecation")
		String randomAlphabetic = RandomStringUtils.randomAlphabetic(5);
		return randomAlphabetic;
		
	}
	public String randomnumber()
	{
		@SuppressWarnings("deprecation")
		String randomnumeric = RandomStringUtils.randomNumeric(10);
		return randomnumeric;
		
	}
	
	public String alphanumberic()
	{
		@SuppressWarnings({ "deprecation", "deprecation" })
		String randomAlphabeti = RandomStringUtils.randomAlphabetic(5);
		String randomnumeri = RandomStringUtils.randomNumeric(4);
		String pass=(randomAlphabeti+"@"+randomnumeri);
		return pass;
		
		
	}
	
	public String capturescrenshot(String tname) 
	{
		
		String timeStamp =new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
		File sourcefile=takesscreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath=System.getProperty("user.dir")+"\\screenshots\\"+"tname"+"_"+timeStamp+".png";
		File targetFile=new File(targetfilepath);
		
		sourcefile.renameTo(targetFile);
		
		return targetfilepath;
	}

}
