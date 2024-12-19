package sfr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfr.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - Object repository 
	@FindBy(xpath = "//input[@type='text']")
	WebElement username;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(id = "Login")
	WebElement loginBtn;	
	
	@FindBy(xpath = "//img[contains(@id, 'App Logo')]")
	WebElement nylLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateNYLImage() {
		return nylLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

}
