package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

// If Data is Valid --> Login Success --> Test Pass --> Logout
// If Data is Valid --> Login Fail --> Test Fail

// If Data is Invalid --> Login Fail --> Test Pass
// If Data is Invalid --> Login Success --> Test Fail --> Logout

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")	// Getting data provider from different class
	public void verify_loginDDT(String email, String pkey, String expres) 
	{
		logger.info("***** Starting TC003_LoginDDT *****");
		try
		{
		// HomePage
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		// Login Page
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pkey);
		lp.clickLogin();
		
		// MyAccount
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetPage= macc.isMyAccountPageExists();
		
		
		// If Data is Valid --> Login Success --> Test Pass --> Logout
		// 						Login Fail --> Test Fail
		
		if(expres.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		// If Data is Invalid --> Login Success --> Test Fail --> Logout
		//						  Login Fail --> Test Pass
		
		if(expres.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC003_LoginDDT *****");
		
	}
	

}
