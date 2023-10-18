package NewsValidation.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
	
	 private static WebDriver driver;
	    
	    public static void setBrowser(String browserName) {
	        if (driver == null) {
	            switch (browserName.toLowerCase()) {
	                case "chrome":
	                    System.setProperty("webdriver.chrome.driver", "/src/main/resources/drivers/chromedriver.exe");
	                    driver = new ChromeDriver();
	                    break;
	                case "firefox":
	                    System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
	                    driver = new FirefoxDriver();
	                    break;
	                case "edge":
	                    System.setProperty("webdriver.edge.driver", "path/to/msedgedriver");
	                    driver = new EdgeDriver();
	                    break;
	                case "ie":
	                    System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer.exe");
	                    driver = new InternetExplorerDriver();
	                    break;
	                case "safari":
	                    driver = new SafariDriver();
	                    break;
	                default:
	                    throw new IllegalArgumentException("Unsupported browser: " + browserName);
	            }
	        }
	    }

	    public static WebDriver getDriver() {
	        if (driver == null) {
	            throw new IllegalStateException("WebDriver instance has not been initialized. Call setBrowser() first.");
	        }
	        return driver;
	    }
	    
	    public static void quitWebDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }

}
