package testcases;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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

    @BeforeClass
    public void setup () {
        //Install chromeDriver
//      WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();
        //instantiate javascript executor
        js = (JavascriptExecutor) driver;
        //Maximize Window
        driver.manage().window().maximize();

        //clean up
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }

    public String randomEmail() {
        String randomMail = "test" + (int)(Math.random() * 5000 + 1) + "@yopmail.com";
        return randomMail;
    }
}
