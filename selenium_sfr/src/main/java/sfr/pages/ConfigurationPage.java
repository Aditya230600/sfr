package sfr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sfr.base.TestBase;

public class ConfigurationPage extends TestBase {

    @FindBy(xpath = "//*[@id='Configuration']")
    WebElement configurationLink;
    
    @FindBy(xpath = "//*[@id='Additional Settings']")
    WebElement additionalSettingsLink;

    public ConfigurationPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnConfiguration() {
        configurationLink.click();
    }

    public void clickOnAdditionalSettings() {
        additionalSettingsLink.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
