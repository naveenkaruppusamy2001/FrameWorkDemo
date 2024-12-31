package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage

{
	public loginPage(WebDriver driver)   //Intiating the constructor
	{
		super(driver);
	}
	
	
	//locators
	
    @FindBy(xpath="//input[@id='input-email']") WebElement eMailAddress;
    @FindBy(xpath="//input[@id='input-password']")  WebElement password;
    @FindBy(xpath="//input[@value='Login']")  WebElement login;
    
    
    
    //Actions methods
    
    public void enterEmail(String email)
    {
    	eMailAddress.sendKeys(email);
    }
    
    public void enterpassword(String pass)
    {
    	password.sendKeys(pass);
    }
    
    public void clickLoginbutton1() 
    {
    	login.click();
    }
}
