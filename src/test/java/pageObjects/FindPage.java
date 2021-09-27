package pageObjects;

import utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FindPage extends BaseClass {

    public FindPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='headline first-child text-color' and . = 'Weather in your city']")
    @CacheLookup
    private WebElement element_HeadLine;

    @FindBy(id = "search_str")
    @CacheLookup
    private WebElement input_SearchBox;

    @FindBy(xpath = "//*[@id='searchform']//button[@class='btn btn-color']")
    @CacheLookup
    private WebElement button_Search;

    @FindBy(xpath = "//*[@id='forecast_list_ul']//a[contains(@href,'city/')]")
    @CacheLookup
    private List<WebElement> list_CityName;

    @FindBy(xpath = "//*[@id='forecast_list_ul']//span[@class='badge badge-info']")
    @CacheLookup
    private WebElement element_CityTemp;

    @FindBy(xpath = "//*[@id='forecast_list_ul']")
    @CacheLookup
    private WebElement element_NoSearchResult;

    public boolean findPageIsDisplayed()
    {
        WaitUntilElementVisible(element_HeadLine);
        element_HeadLine.isDisplayed();
        WaitUntilElementVisible(input_SearchBox);
        input_SearchBox.isDisplayed();
        WaitUntilElementVisible(button_Search);
        button_Search.isDisplayed();
        return true;
    }

    public boolean noSearchResults()
    {
        WaitUntilElementVisible(element_NoSearchResult);
        return element_NoSearchResult.getText().contains("Not found");
    }

    public boolean cityTempExists()
    {
        WaitUntilElementVisible(element_CityTemp);
        return element_CityTemp.isDisplayed();
    }

    public boolean isListContainsCityName(String cityName)
    {
        return list_CityName.stream().anyMatch(e->e.getText().trim().equals(cityName));
    }

    public int noOfSearchResults()
    {
        return list_CityName.size();
    }

    public void clickCityName(String cityName)
    {
        for (WebElement cn:list_CityName)
        {
            if(cn.getText().contains(cityName))
            {
                cn.click();
                return;
            }
        }
    }
}