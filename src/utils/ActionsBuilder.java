package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class ActionsBuilder extends BasePage {
    //Constructor
    public ActionsBuilder(WebDriver driver) {
        super(driver);
    }
    public ActionsBuilder(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    //Action variables
    WebDriver driver;
    Actions builder = new Actions(driver);

    public void dragAndDrop (WebElement source, WebElement target) {
        Action moveAction = builder
                .dragAndDrop(source, target)
                .build();
        moveAction.perform();
    }

    public void hover(WebElement element){
        Action hoverAction = builder
                .moveToElement(element)
                .build();
        hoverAction.perform();
    }
}
