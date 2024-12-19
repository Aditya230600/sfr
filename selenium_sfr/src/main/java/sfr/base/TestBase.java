package sfr.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import sfr.utils.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try { 
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\sfr\\config\\config.properties");
			prop.load(ip);
		    }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file.");
        }
    }
    
    // Method to initialize the WebDriver
    public static void initialization() {
        String browserName = prop.getProperty("browser");
        
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup(); 
            driver = new ChromeDriver();   
        } else {
          throw new RuntimeException("Browser not supported: " + browserName);
        }

        // Additional WebDriver settings
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies(); 
        
        // Page load timeouts
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_LOAD));
        // Load the URL from properties file
        driver.get(prop.getProperty("app_url"));    		
	}

}
