package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class BaseTest {
    public WebDriver driver;
    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public JavascriptExecutor js;

    @BeforeClass
    public void setup () {
        //Install chromeDriver
        //Create a Chrome driver.
//            driver = getChromeDriverInstance(driver);
        //Create a Firefox driver
        driver = getFirefoxDriverInstance(driver);

        //instantiate javascript executor
        js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);

        //clean up
        tdriver.set(driver);
    }

    @AfterClass
    public void teardown () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public String randomEmail() {
        String randomMail = "test" + (int)(Math.random() * 5000 + 1) + "@yopmail.com";
        return randomMail;
    }

    public WebDriver getChromeDriverInstance(WebDriver chromeDriverInstance) {
        WebDriverManager.chromedriver().version("72.0").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");
        chromeDriverInstance = new ChromeDriver();

        return chromeDriverInstance;
    }

    public WebDriver getFirefoxDriverInstance(WebDriver firefoxDriverInstance) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
//        options.setHeadless(true);
        options.addArguments("--disable-gpu");
//        options.addArguments("--headless");
        firefoxDriverInstance = new FirefoxDriver(options);
        return firefoxDriverInstance;
    }
}
