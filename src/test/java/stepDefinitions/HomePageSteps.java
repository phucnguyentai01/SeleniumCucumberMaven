package stepDefinitions;

import org.junit.Assert;
import pageObjects.HomePage;
import utilities.PropertiesReader;
import utilities.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSteps extends DriverFactory {

    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait;

    public HomePageSteps() throws Exception
    {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    @Given("^I launch the Homepage$")
    public void loginPage()
    {
        HomePage homePage = new HomePage(driver, wait);
        Assert.assertTrue(homePage.homePageIsDisplayed());
    }

    @When("^I search the city by \"(.*)\"$")
    public void searchCity(String cityName)
    {
        HomePage homePage = new HomePage(driver, wait);
        homePage.fillSearchBox(cityName);
    }
}