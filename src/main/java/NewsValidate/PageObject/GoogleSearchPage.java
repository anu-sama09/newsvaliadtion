package NewsValidate.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
	
private final WebDriver driver;
    
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void searchFor(String query) {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys(query);
        driver.findElement(By.name("q")).submit();
    }
    
    public int getSearchResultsCount() {
        return driver.findElements(By.cssSelector("h3")).size();
    }

    public void printWebsiteName() {
    	String siteOne = driver.findElement(By.xpath("(//h3//parent::a)[1]")).getAttribute("href");
    	String siteTwo = driver.findElement(By.xpath("(//h3//parent::a)[2]")).getAttribute("href");
    	System.out.println(siteOne);    	
    	System.out.println(siteTwo); 
    }
    
}
