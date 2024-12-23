package sfr.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sfr.base.TestBase;
import sfr.pages.ConfigurationPage;
import sfr.pages.HomePage;
import sfr.pages.LoginPage;

public class ConfigurationTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ConfigurationPage configurationPage;

    public ConfigurationTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        configurationPage = new ConfigurationPage();
    }

    @Test(priority = 1)
    public void verifyAdditionalSettingsPageUrl() throws InterruptedException {
        configurationPage.clickOnConfiguration();
        Thread.sleep(2000);
        configurationPage.clickOnAdditionalSettings();
        Thread.sleep(2000);
        String currentUrl = configurationPage.getCurrentUrl();
        String expectedUrl = "https://qa-nyl-sfr.xeninc.us/#it-configuration---additional?otherSettings=true";
        Assert.assertEquals(currentUrl, expectedUrl, "URL did not match the expected URL");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
