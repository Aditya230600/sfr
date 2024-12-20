package sfr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfr.base.TestBase;

public class HomePage extends TestBase{
	
	// Page Factory - object repository
		@FindBy(xpath = "//span[contains(text()='Users')]")
		WebElement usersTab;

		@FindBy(xpath = "//button[@id = 'Add User']")
		WebElement addUserBtn;

		@FindBy(xpath = "//h1[@id = 'Add User']")
		WebElement addUserHeading;

		public HomePage() {
			PageFactory.initElements(driver, this);
		}

		// Actions
		public String validateHomePageTitle() {
			return driver.getTitle();
		}

		public String validateUsersPageTitle() {
			usersTab.click();
			return driver.getTitle();
		}

		public UserAddPage navigateToUserAdd() {
			addUserBtn.click();
			addUserHeading.click();
			return new UserAddPage();
		}
	
}
