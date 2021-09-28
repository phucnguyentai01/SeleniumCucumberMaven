package pageObjects;

import utilities.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='first-level-nav']//img[contains(@src,'logo_white_cropped.png')]")
    @CacheLookup
    private WebElement element_Logo;

    @FindBy(xpath = "//*[@id='desktop-menu']//input[@type='text' and @placeholder='Weather in your city']")
    @CacheLookup
    private WebElement input_SearchBox;

    public boolean homePageIsDisplayed()
    {
        WaitUntilElementVisible(element_Logo);
        element_Logo.isDisplayed();
        WaitUntilElementVisible(input_SearchBox);
        input_SearchBox.isDisplayed();
        return true;
    }

    public void fillSearchBox(String keyword)
    {
        WaitUntilElementVisible(input_SearchBox);
        input_SearchBox.isEnabled();
        input_SearchBox.clear();
        input_SearchBox.sendKeys(keyword);
        input_SearchBox.sendKeys(Keys.ENTER);
    }

//    This is an issue found on Search button. Instead, we send Enter key to process
//    public void clickSearchButton()
//    {
//        WaitUntilElementVisible(button_Search);
//        button_Search.isEnabled();
//        button_Search.click();
//    }
}