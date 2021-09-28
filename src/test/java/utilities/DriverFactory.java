package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverFactory {

    //protected static WebDriver driver = null;
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {

        if (browser.equalsIgnoreCase("chrome"))
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

            tlDriver.set(new ChromeDriver(options));

        } else if (browser.equalsIgnoreCase("firefox")) {

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

            tlDriver.set(new FirefoxDriver(options));

        }
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
