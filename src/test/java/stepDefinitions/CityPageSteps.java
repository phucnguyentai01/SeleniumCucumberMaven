package stepDefinitions;

import pageObjects.CityPage;
import utilities.PropertiesReader;
import utilities.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CityPageSteps extends DriverFactory {

    private final WebDriver driver = Hooks.driver;
    private final WebDriverWait wait;

    public CityPageSteps() throws Exception
    {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    @Then("^Navigated to the city weather page$")
    public void cityPage()
    {
        CityPage cityPage = new CityPage(driver, wait);
        Assert.assertTrue(cityPage.cityPageIsDisplayed());
    }

    @And("^Verify the current date$")
    public void verifyCurrentDate()
    {
        CityPage cityPage = new CityPage(driver, wait);

        // Create object and define the format
        DateFormat dateFormat = new SimpleDateFormat("MMM dd");
        // Get current date
        Date date = new Date();

        Assert.assertTrue(cityPage.elementCurrentTime().contains(dateFormat.format(date)));
    }

    @And("^Verify city name \"(.*)\"$")
    public void verifyCityName(String cityName)
    {
        CityPage cityPage = new CityPage(driver, wait);
        Assert.assertEquals(cityPage.elementCityName().trim(), cityName);
    }

    @And("^Verify temperature with fahrenheit/celsius degree format$")
    public void verifyTempDegree()
    {
        CityPage cityPage = new CityPage(driver, wait);
        cityPage.click_DF();
        Assert.assertTrue(cityPage.elementCurrentTemp().contains("°F"));
        cityPage.click_DC();
        Assert.assertTrue(cityPage.elementCurrentTemp().contains("°C"));
    }

    @And("^Verify forecast chart and day list$")
    public void verifyCityWeather()
    {
        CityPage cityPage = new CityPage(driver, wait);
        Assert.assertTrue(cityPage.HourlyForecast_Exists());
        Assert.assertTrue(cityPage.HourlyForecast_Chart_Exists());
        Assert.assertTrue(cityPage.EightDayForecast_Exists());
        Assert.assertTrue(cityPage.EightDayForecast_DayList_Exists());
    }

    @And("^Verify weather items$")
    public void verifyWeatherItems()
    {
        CityPage cityPage = new CityPage(driver, wait);
        Assert.assertTrue(cityPage.elementWeatherItems().contains("Humidity:"));
        Assert.assertTrue(cityPage.elementWeatherItems().contains("Visibility:"));
        Assert.assertTrue(cityPage.elementWeatherItems().contains("Dew point:"));
    }
}