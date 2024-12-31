package testCases;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testbase.BaseClass;

public class TC_OpenCart_001 extends BaseClass
{

	
	@Test(groups="sanity")
	
	public void verifyRegistration()
	{
		
		try {
			logger.info("**************Started verifyRegistration*************************");
			
			HomePage hp=new HomePage(driver);  ///Created a object for the homepage class
			hp.clickMyAccount();
			hp.clickMyRegister();
			
			logger.info("**************Clicked register *************************");
			
			AccountRegistrationPage ar=new AccountRegistrationPage(driver);   //Created the object for the AccountRegistration class
			ar.txtenterfname("Nave2en");
			ar.txtenterlname("Karuppwus4ay");
			ar.txtenteremail(randomAlphabts()+"@gmail.com");
			ar.txtenterPhone(randomnumber());
			String password = alphanumberic();
			ar.txtenterPassword(password);
			ar.txtenterCPassword(password);
			ar.ckbAgree();
			ar.btnContinue();
			
			Assert.assertEquals(ar.accountCreated(), "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test failed");
			logger.debug("Debugger");
			Assert.fail();
		}
		
		
	
	}
	
	
	
	
}
