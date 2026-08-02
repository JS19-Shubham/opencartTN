package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {
	
	WebDriver driver;
	
	public AccountRegistrationPage (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_FirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_LastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_Telephone;
	

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_ConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chk_Policy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_Continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msg_Confirmation;
	
	
	
	public void setFirstName(String fname)
	{
		txt_FirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txt_LastName.sendKeys(lname);
	}
	
	public void setEMail(String email)
	{
		txt_Email.sendKeys(email);
	}
	
	public void setTelePhone(String tel)
	{
		txt_Telephone.sendKeys(tel);
	}
	
	public void setPassword(String pkey)
	{
		txt_Password.sendKeys(pkey);
	}
	
	public void setConfirmPassword(String pkey)
	{
		txt_ConfirmPassword.sendKeys(pkey);
	}
	
	public void setPrivacyPolicy()
	{
		chk_Policy.click();
	}
	
	public void clickContinue()
	{
		// Approach 1
		btn_Continue.click();
		
		// Approach 2
		//btn_Continue.submit();
		
		// Approach 3
		//Actions act= new Actions(driver);
		//act.moveToElement(btn_Continue).click().perform();
		
		// Approach 4
		//JavascriptExecutor jse= (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click();", btn_Continue);
		
		// Approach 5
		//btn_Continue.sendKeys(Keys.RETURN);
		
		// Approach 6
		//WebDriverWait myWait= new WebDriverWait(driver, Duration.ofSeconds(10));
		//myWait.until(ExpectedConditions.elementToBeClickable(btn_Continue)).click();
		
	}
	
	public String getConfirmationMsg() {
		try
		{
			return (msg_Confirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}

}
