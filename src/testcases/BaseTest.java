package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public JavascriptExecutor js;

    @BeforeClass
    public void setup () {
        //Install chromeDriver
        WebDriverManager.chromedriver().setup();

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
        String email = "testMealsuite";
//        int randomNumber = round(Math.)
        return email;
    }
}
