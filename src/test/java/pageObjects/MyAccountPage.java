package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")		// MyAccount Page Heading
	WebElement txtHeading;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")		// Added in step 6
	WebElement lnk_Logout;
	
	public boolean isMyAccountPageExists()
	{
		try
		{
			return (txtHeading.isDisplayed());
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		lnk_Logout.click();
	}

}
