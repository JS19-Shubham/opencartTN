package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account link...");
		
		hp.clickRegister();
		logger.info("Clicked on Register link...");
		
		AccountRegistrationPage regPage= new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Details...");
		regPage.setFirstName(randomeString().toUpperCase());
		regPage.setLastName(randomeString().toUpperCase());
		regPage.setEMail(randomeString()+"@gmail.com");		// Randomly generate the EMail
		regPage.setTelePhone(randomeNumber());
		
		String password= randomeAlphaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		logger.info("Validating Expected Message...");
		String cnfmMsg= regPage.getConfirmationMsg();
		if(cnfmMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			logger.info("Test passed...");
		}
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(cnfmMsg, "Your Account Has Been Created!!!");
		}
		catch (Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		
	}
	
	
}
