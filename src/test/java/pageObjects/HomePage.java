package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
	public HomePage(WebDriver driver)   //Intiating the constructor
	{
		super(driver);
	}
	
	
	
	//locators
	

     @FindBy(xpath="//ul[@class='list-inline']//li[@class='dropdown']") WebElement myAccount;
     @FindBy(xpath="//a[normalize-space()='Register']")  WebElement register;

     @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement login;
     
     
     //ActionMethods
     
     public void clickMyAccount() 
     {
    	 myAccount.click();     ///Method to click the my account button
     }
     
     
     
     public void clickMyRegister() 
     {
    	 
    	 register.click();
     }

     	public void clickLogin12()
	{
		login.click();
	}



	
}
