package pageObjects;

import utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CityPage extends BaseClass {

    public CityPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    private final String headerMainMenu = "//*[@id='weather-widget']";

    @FindBy(id = "widget-map")
    @CacheLookup
    private WebElement element_MapWidget;

    @FindBy(xpath = headerMainMenu + "//h3[@class='mobile-padding' and . = 'Hourly forecast']")
    @CacheLookup
    private WebElement element_HourlyForecast;

    @FindBy(xpath = headerMainMenu + "//div[@class='chart-container']")
    @CacheLookup
    private WebElement element_HourlyForecast_Chart;

    @FindBy(xpath = headerMainMenu + "//h3[. = '8-day forecast']")
    @CacheLookup
    private WebElement element_8DayForecast;

    @FindBy(xpath = headerMainMenu + "//ul[@class='day-list']")
    @CacheLookup
    private WebElement element_8DayForecast_DayList;

    @FindBy(xpath = headerMainMenu + "//div[@class='option' and contains(.,'Imperial')]")
    @CacheLookup
    private WebElement swatch_DegreeF;

    @FindBy(xpath = headerMainMenu + "//div[@class='option' and contains(.,'Metric')]")
    @CacheLookup
    private WebElement swatch_DegreeC;

    @FindBy(xpath = headerMainMenu + "//span[@class='orange-text']")
    @CacheLookup
    private WebElement element_CurrentTime;

    @FindBy(xpath = headerMainMenu + "//h2[contains(@style,'margin-top')]")
    @CacheLookup
    private WebElement element_CityName;

    @FindBy(xpath = headerMainMenu + "//span[@class='heading']")
    @CacheLookup
    private WebElement element_CurrentTemp;

    @FindBy(xpath = headerMainMenu + "//ul[contains(@class,'weather-items')]")
    @CacheLookup
    private WebElement element_WeatherItems;

    public boolean cityPageIsDisplayed()
    {
        WaitUntilElementVisible(element_MapWidget);
        element_MapWidget.isDisplayed();
        return true;
    }

    public void click_DF()
    {
        WaitUntilElementClickable(swatch_DegreeF);
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
        swatch_DegreeF.click();
    }

    public void click_DC()
    {
        WaitUntilElementClickable(swatch_DegreeC);
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
        swatch_DegreeC.click();
    }

    public String elementCurrentTime()
    {
        WaitUntilElementVisible(element_CurrentTime);
        return element_CurrentTime.getText();
    }

    public String elementCityName()
    {
        WaitUntilElementVisible(element_CityName);
        return element_CityName.getText();
    }

    public String elementCurrentTemp()
    {
        WaitUntilElementVisible(element_CurrentTemp);
        return element_CurrentTemp.getText();
    }

    public String elementWeatherItems()
    {
        WaitUntilElementVisible(element_WeatherItems);
        return element_WeatherItems.getText();
    }

    public boolean HourlyForecast_Exists()
    {
        WaitUntilElementVisible(element_HourlyForecast);
        return element_HourlyForecast.isDisplayed();
    }

    public boolean HourlyForecast_Chart_Exists()
    {
        WaitUntilElementVisible(element_HourlyForecast_Chart);
        return element_HourlyForecast_Chart.isDisplayed();
    }

    public boolean EightDayForecast_Exists()
    {
        WaitUntilElementVisible(element_8DayForecast);
        return  element_8DayForecast.isDisplayed();
    }

    public boolean EightDayForecast_DayList_Exists()
    {
        WaitUntilElementVisible(element_8DayForecast_DayList);
        return  element_8DayForecast_DayList.isDisplayed();
    }
}