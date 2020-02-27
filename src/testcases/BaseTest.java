package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    public JavascriptExecutor js;

    @BeforeTest
    public void setup () {
        //Install chromeDriver
//      WebDriverManager.chromedriver().version("72.0").setup();
      WebDriverManager.firefoxdriver().version("73.0").setup();

//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        //Create a Chrome driver.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-gpu");

//        driver = new ChromeDriver(options);
        driver = new FirefoxDriver();
        //instantiate javascript executor
        js = (JavascriptExecutor) driver;
        //clean up
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterTest
    public void teardown () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public String randomEmail() {
        String randomMail = "test" + (int)(Math.random() * 5000 + 1) + "@yopmail.com";
        return randomMail;
    }
}
