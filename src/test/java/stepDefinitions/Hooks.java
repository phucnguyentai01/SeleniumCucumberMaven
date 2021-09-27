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

public class Hooks {

    private DriverFactory driverFactory;
    private WebDriver driver;

    @Before
    public void openBrowser() throws Exception
    {
        PropertiesReader propertiesReader = new PropertiesReader();

        String browserName = System.getProperty("browserName");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
        driver.manage().timeouts().implicitlyWait(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(PropertiesReader.getValue("url"));
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
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
