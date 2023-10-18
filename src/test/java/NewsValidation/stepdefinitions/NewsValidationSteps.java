package NewsValidation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import NewsValidate.PageObject.GoogleSearchPage;
import NewsValidate.PageObject.GuardianHomePage;
import NewsValidation.Utils.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewsValidationSteps{
	
	private WebDriver driver;
    private GuardianHomePage guardianHomePage;
    private GoogleSearchPage googleSearchPage;

    @Given("I open The Guardian website")
    public void iOpenTheGuardianWebsite() {
        driver = WebDriverFactory.getDriver();
        guardianHomePage = new GuardianHomePage(driver);
        guardianHomePage.navigateToNewsSection();
    }

    @When("I retrieve the title of the first news article")
    public void iRetrieveTheTitleOfTheFirstNewsArticle() {
        String guardianNewsTitle = guardianHomePage.getFirstNewsArticleTitle();
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.searchFor(guardianNewsTitle);
    }

    @Then("I should see at least 2 search results")
    public void iShouldSeeAtLeast2SearchResults() {
        int searchResultsCount = googleSearchPage.getSearchResultsCount();
        Assert.assertTrue(searchResultsCount >= 2, "Expected at least 2 search results, but found " + searchResultsCount);
        driver.quit();
    }

    @Then("I want to print the name of first two sites with available results")
    public void checkWebResultName() {
    	googleSearchPage.printWebsiteName();
        driver.quit();
    }

    
}
