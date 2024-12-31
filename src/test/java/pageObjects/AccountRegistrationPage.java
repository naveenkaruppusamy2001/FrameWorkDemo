package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		
		super(driver);
		
	}
	
	
	
	//locators
	

    @FindBy(xpath="//input[@id='input-firstname']")  WebElement firstName;
    @FindBy(xpath="//input[@id='input-lastname']")  WebElement lastName;
    @FindBy(xpath="//input[@id='input-email']") WebElement eMail;
    @FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
    @FindBy(xpath="//input[@id='input-password']") WebElement password;
    @FindBy(xpath="//input[@id='input-confirm']")  WebElement passwordConfirm;
    @FindBy(xpath="//input[@name='agree']")  WebElement agree;
    @FindBy(xpath="//input[@value='Continue']") WebElement btcontinue;
    

    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement yourAccountHasBeenCreatedtxt;
    
    //ActionMethods
    
    public void txtenterfname(String Fname)
    {
    	firstName.sendKeys(Fname);
    }
    
    
    public void txtenterlname(String Lname)
    {
    	lastName.sendKeys(Lname);
    }

   public void txtenteremail(String Email)
    {
    	eMail.sendKeys(Email);
    	
    }
    
   public  void txtenterPhone(String Phone)
    {
    	telephone.sendKeys(Phone);
    	
    }
    
  public  void txtenterPassword(String Password)
    {
    	password.sendKeys(Password);
    	
    }
    
    public void txtenterCPassword(String CPassword)
    {
    	passwordConfirm.sendKeys(CPassword);
    	
    }
    
    public void ckbAgree()
    {
    	agree.click();
    	
    }
    
    public void btnContinue()
    {
    	btcontinue.click();
    	
    }
    
    public String accountCreated() 
    {
    	try {
			return( yourAccountHasBeenCreatedtxt.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return("exception");
		}
    	
    }
    
    
    
    
    
    
}

