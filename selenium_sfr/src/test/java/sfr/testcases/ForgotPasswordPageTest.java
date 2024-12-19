package sfr.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sfr.base.TestBase;
import sfr.pages.ForgotPasswordPage;

public class ForgotPasswordPageTest extends TestBase{
	
	ForgotPasswordPage forgotPasswordPage;
	
	public ForgotPasswordPageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		forgotPasswordPage = new ForgotPasswordPage();
	}
	
	@Test(priority = 1)
	public void forgotPasswordLinkTest() {
		boolean link = forgotPasswordPage.validateForgotPasswordLink();
		Assert.assertTrue(link);
	}
	
	@Test(priority = 2)
	public void forgotEmailResetTest() {
		boolean isResetMsgShown = forgotPasswordPage.forgotEmailReset(prop.getProperty("username"));
		Assert.assertTrue(isResetMsgShown);
	}
	
	@Test(priority = 3)
	public void ResetConfirmTest() {
		boolean isConfirmBtnShown = forgotPasswordPage.validateResetConfirm();
		Assert.assertTrue(isConfirmBtnShown);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
