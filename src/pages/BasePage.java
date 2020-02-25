package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

    public class BasePage {
        public WebDriver driver;
        public String url = "http://qa.rebuild.mealsuite.com";

        public WebDriverWait wait;

        public BasePage(WebDriver driver) {
            this.driver = driver;
        }

        public BasePage(WebDriverWait wait, WebDriver driver) {
            this.wait = wait;
            this.driver = driver;
        }

        //Wait Wrapper Method

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

        public void writeText (By elementBy, String text) {
            WebElement textBox = driver.findElement(elementBy);
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

        //Assert
        public void assertEquals (By elementBy, String expectedText) {
            Assert.assertEquals(readText(elementBy), expectedText);
        }
}
