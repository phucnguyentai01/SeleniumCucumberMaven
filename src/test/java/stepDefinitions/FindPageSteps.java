package stepDefinitions;

import pageObjects.FindPage;
import utilities.PropertiesReader;
import utilities.DriverFactory;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindPageSteps extends DriverFactory {

    private final WebDriver driver = Hooks.driver;
    private final WebDriverWait wait;


    public FindPageSteps() throws Exception
    {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }


    @And("^Navigated to the finding result page$")
    public void findPage()
    {
        FindPage findPage = new FindPage(driver, wait);
        Assert.assertTrue(findPage.findPageIsDisplayed());
    }

    @And("^Verify the city name \"(.*)\" and temperature$")
    public void verifyCityNameTemp(String cityName)
    {
        FindPage findPage = new FindPage(driver, wait);
        findPage.findPageIsDisplayed();
        Assert.assertTrue(findPage.noOfSearchResults() > 0);
        Assert.assertTrue(findPage.isListContainsCityName(cityName));
        Assert.assertTrue(findPage.cityTempExists());
    }

    @And("^Verify city not found$")
    public void verifyCityNotFound()
    {
        FindPage findPage = new FindPage(driver, wait);
        Assert.assertTrue(findPage.noSearchResults());
    }

    @And("^Click on the link of \"(.*)\" in the result list$")
    public void clickCityLink(String cityName)
    {
        FindPage findPage = new FindPage(driver, wait);
        findPage.clickCityName(cityName);
    }
}