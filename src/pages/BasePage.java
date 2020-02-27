package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static utils.TestUtil.IMPLICIT_WAIT_TIMEOUT;

public class BasePage {
    public WebDriver driver;
    public String url = "http://qa.rebuild.mealsuite.com";

    public WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage(WebDriverWait wait, WebDriver driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, IMPLICIT_WAIT_TIMEOUT);
    }

    //Wait Wrapper Method
    public void loading(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForNextStep() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    //select option in dropdown by text
    public void selectOption(By elementBy,String option) {
        Select dropdown = new Select(driver.findElement(elementBy));
        dropdown.selectByVisibleText(option);
    }
    //unselect option in dropdown by text
    public void unselectOption(By elementBy, String option) {
        Select dropdown = new Select(driver.findElement(elementBy));
        dropdown.deselectByVisibleText(option);
    }
    //Click Method
    public void click (By elementBy) {
        driver.findElement(elementBy).click();
    }

    public void click (WebElement element) {
        element.click();
    }

    public void writeText (By elementBy, String text) {
        WebElement textBox = driver.findElement(elementBy);
        textBox.clear();
        textBox.sendKeys(text);

    }

    //Read Text
    public String readText (By elementBy) {
        return driver.findElement(elementBy).getText();
    }
    //Navigate
    public void navigate (String elementBy) {
        driver.get(url + elementBy);
    }

    // get list of element
    public List<WebElement> getElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }

    //get single element
    public WebElement getElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element;
    }

    //********Assertion***********
    public void assertEquals (By elementBy, String expectedText) {
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    public void observesElementOnScreen(By locator, String expectedText){
        Boolean result = false;
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            String actualText = element.getText();
            if(actualText.equals(expectedText)) {
                result = true;
            }
        }
        Assert.assertTrue(result);
    }

    public void observesTextOnScreen(By elementBy) {
        WebElement validateMessage = driver.findElement(elementBy);
        Assert.assertTrue(validateMessage.isDisplayed());
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}
