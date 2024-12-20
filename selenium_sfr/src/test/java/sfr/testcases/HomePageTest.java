package sfr.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sfr.base.TestBase;
import sfr.pages.HomePage;
import sfr.pages.LoginPage;
import sfr.pages.UserAddPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	UserAddPage userAddPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void HomePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "IT Routing Requests | Secure File Routing Portal");
	}

	@Test
	public void UsersPageTitleTest() {
		String userTitle = homePage.validateUsersPageTitle();
		Assert.assertEquals(userTitle, "IT Users | Secure File Routing Portal");
	}

	/*@Test
	public void UserAddPageTest() {
		String addUserHeading = 
	}*/

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
