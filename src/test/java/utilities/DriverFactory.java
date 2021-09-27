package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverFactory {

    protected static WebDriver driver = null;

    public org.openqa.selenium.WebDriver getDriver() {
        if (null != driver)
        {
            return driver;
        }

        String browserName = System.getProperty("browserName");

        if (browserName.equalsIgnoreCase("chrome"))
        {
            /* Chrome */
            if (System.getProperty("os.name").contains("Mac")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver_mac/chromedriver");
            } else if (System.getProperty("os.name").contains("Window")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver_win/chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver"); // used for Jenkins Linux
            }

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1280x800");
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("--disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model

            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {

            /* Firefox */
            if (System.getProperty("os.name").contains("Mac")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver_mac/geckodriver");
            } else if (System.getProperty("os.name").contains("Window")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver_win/geckodriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", "/usr/bin/geckodriver"); // used for Jenkins Linux
            }

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1280x800");
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("--disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model

            driver = new FirefoxDriver(options);

        }
        return driver;
    }

    /**
     * Quit Driver: tearDownClass() will handle closing the driver
     */
    public static void quitDriver() {
        if (null != driver) {
            driver.quit();
        }
    }
}
