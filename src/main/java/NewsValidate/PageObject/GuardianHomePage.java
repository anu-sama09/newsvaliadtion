package NewsValidate.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuardianHomePage {
	
private final WebDriver driver;
    
    public GuardianHomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void navigateToNewsSection() {
        driver.get("https://www.theguardian.com/tone/news");
    }
    
    public String getFirstNewsArticleTitle() {
        return driver.findElement(By.cssSelector(".fc-item__title")).getText();
    }

}
