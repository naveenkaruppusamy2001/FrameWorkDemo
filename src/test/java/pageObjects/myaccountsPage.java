package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myaccountsPage extends BasePage
{

	public myaccountsPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	//locators
	

     @FindBy(xpath="//h2[normalize-space()='My Account']")  WebElement myAccount;
     
     
     //ActionMethods
     
     public boolean ismyaccountsexists() 
     {
    	 boolean display = myAccount.isDisplayed();
    	 return display;
     }
}

