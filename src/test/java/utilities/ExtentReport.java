package utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.BaseClass;

public class ExtentReport implements ITestListener
{

		public ExtentSparkReporter sparkReporter; //UI of the report
		public ExtentReports extent;  //populate the common info on the report
		public ExtentTest test;  //Create test case entries in the report and update status of the test methods.

		
		 public void onStart(ITestContext context)
		 {
		   
			 sparkReporter = new ExtentSparkReporter("C:\\Users\\gopik\\eclipse-workspace\\FrameWorkDemo\\reports\\myreport.html");  //Specify the path of the screenshot needs to be stored
			 
			 sparkReporter.config().setDocumentTitle("My First Automation report"); //Title of the report
			 sparkReporter.config().setTheme(Theme.DARK); //Set the theme of the page
			 
			 extent=new ExtentReports();
			 extent.attachReporter(sparkReporter);
			 
			 extent.setSystemInfo("Computer Name", "Localhost");
			 extent.setSystemInfo(" Environment", "QA");
			 extent.setSystemInfo(" Executed by", "Naveen K ");
			 extent.setSystemInfo(" OS", "Windows");
			 extent.setSystemInfo("Browser Name", "Chrome");

		}
		 
		 public void onTestSuccess(ITestResult result) 
		 {
			  test = extent.createTest(result.getName());   //create a new entry in the report
			  test.log(Status.PASS, "Test case passed is "+result.getName());  //Update the status 
			
			 
		  }
		 
		 
		 
		 
		 
		 public void onTestFailure(ITestResult result) 
		 {
			  test = extent.createTest(result.getName());
			  test.log(Status.FAIL, "Test case failed is "+result.getName());
			  test.log(Status.FAIL, "Test case failed cause is  "+result.getThrowable());
			  
			  try {
				String imgpath= new BaseClass().capturescrenshot(result.getName());
				  test.addScreenCaptureFromPath(imgpath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		  }
		 
		 
		 

		 public void onTestSkipped(ITestResult result) 
		 {

			  test = extent.createTest(result.getName());
			  test.log(Status.SKIP, "Test case skipped is "+result.getName());
			 
		 }
		 
		 public void onFinish(ITestContext context)
		 {
			   extent.flush(); //upating the entire details in the report
	     }
		 
		 
	}


