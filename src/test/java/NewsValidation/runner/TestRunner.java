package NewsValidation.runner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import NewsValidation.Utils.WebDriverFactory;
import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/featureFile/newsValidation.feature",
glue = "stepdefinitions")
public class TestRunner {
	
	@BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        WebDriverFactory.setBrowser(browser);
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactory.quitWebDriver();
    }

}
