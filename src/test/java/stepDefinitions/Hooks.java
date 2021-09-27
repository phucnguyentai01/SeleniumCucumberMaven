package stepDefinitions;

import utilities.PropertiesReader;
import utilities.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import java.util.concurrent.TimeUnit;

public class Hooks extends DriverFactory {

    @Before
    public void openBrowser() throws Exception
    {
        WebDriver driver = getDriver();
        PropertiesReader propertiesReader = new PropertiesReader();
        driver.manage().timeouts().implicitlyWait(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(PropertiesReader.getValue("url"));
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if(scenario.isFailed())
        {
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
    }
}
