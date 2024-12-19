package sfr.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfr.base.TestBase;

public class ForgotPasswordPage extends TestBase{
	
	//PageFactory - Object repository
	@FindBy(id = "Forgot Password?")
	WebElement forgotPassLink;
	
	@FindBy(xpath = "//h2[contains(@id, 'Forgot Password?')]")
	WebElement forgotPassText;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement forgotEmail;
	
	@FindBy(xpath = "//button[normalize-space(@id) = 'Reset Password']")
	WebElement resetBtn;
	
	@FindBy(id = "We have emailed your Password Reset Link.")
	WebElement resetMsg;
	
	@FindBy(xpath = "//button[normalize-space(@id) = 'OK']")
	WebElement resetConfirm;
	
	@FindBy(id = "Secure File Routing Portal")
	WebElement loginConfirm;
	
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Page Actions:
	public boolean validateForgotPasswordLink() {
		forgotPassLink.click();
		return forgotPassText.isDisplayed();
	}
	
	public boolean forgotEmailReset(String ea) {
		forgotEmail.sendKeys(ea);
		try {
	        Thread.sleep(5000);
	        resetBtn.click();// Wait for 5 seconds
	    } catch (InterruptedException e) {
	        e.printStackTrace();  // Log the error or rethrow as needed
	    }

		
		return resetMsg.isDisplayed();
	}
	
	public boolean validateResetConfirm() {
		/*forgotPassLink.click();
		forgotEmail.sendKeys(ea);
		resetBtn.click();
		resetConfirm.click();*/
		return resetConfirm.isDisplayed();
	}
	

}
