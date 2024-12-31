package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.loginPage;
import pageObjects.myaccountsPage;
import testbase.BaseClass;

public class TC_OpenCart_002 extends BaseClass
{
	@Test(groups="sanity")
	public void verifylogin()
	{
		
		try {
			logger.info("****************Execution started*************************************");
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin12();
			
			loginPage lp=new loginPage(driver);
			lp.enterEmail(p.getProperty("email"));
			lp.enterpassword(p.getProperty("password"));
			lp.clickLoginbutton1();
			
			
			
			myaccountsPage mcc=new myaccountsPage(driver);
			boolean disp = mcc.ismyaccountsexists();
			
			Assert.assertEquals(disp, true);
		} catch (Exception e) {
		
			logger.error("Testcase Failed");
			logger.debug("Error");
			Assert.assertEquals(false, true);
		}
		
		
	}

}
