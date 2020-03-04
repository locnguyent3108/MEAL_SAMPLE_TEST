package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ActionsBuilder;

import java.util.List;

public class NonFoodItemPage  extends BasePage {
    //*********Constructor**********
    public NonFoodItemPage(WebDriver driver) {
        super(driver);
    }
    public NonFoodItemPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }
    //*********Page Variables*******
    //*********Web Elements*********
    private By logOutButton = By.xpath("//a[contains(text(),'Logout')]");
    private By publishedButton = By.xpath("//a[@class='green px-2']//i[@class='fas fa-check-circle']");
    private By unPublishButton = By.xpath("//a[@class='text-dark px-2']//i[@class='fas fa-check-circle']");
    private By nonFoodItemColumn = By.xpath("//a[contains(@href,'/edit')]");
    //*********Page Methods*********
    String getRowByLookUpName = "//tr[td[a[contains(text(),'%s')]]]/td";
    String getPublishButtonByLookupName = "//tr[td[a[contains(text(),'%s')]]]//a[1]";
    @Step("Hover to Check circle")
    public NonFoodItemPage hoverCheckCircle() {
        ActionsBuilder hoverToItem = new ActionsBuilder(driver);
        WebElement source = getElement(publishedButton);
        hoverToItem.hover(source);
        return this;
    }

    @Step("Publish non-Food item")
    public NonFoodItemPage publishNonFoodItem(String nonFoodName) {
        String nonFoodItem = String.format(getRowByLookUpName,nonFoodName);
        List<WebElement> getRowOfNonFood = getElements(By.xpath(nonFoodItem));
        for( WebElement element : getRowOfNonFood) {
            if(element.getAttribute("title").equals("UnPublished")){
                try {
                    click(element);
                } catch (NotFoundException e) {
                    System.out.println("there is no unpublished item: " + e);
                }
            }
        }
        return this;
    }

    @Step("UnPublish non-Food item")
    public NonFoodItemPage ClickPublishButton(String nonFoodName) {
        String nonFoodItem = String.format(getPublishButtonByLookupName,nonFoodName);
        List<WebElement> elements = getElements(By.xpath(nonFoodItem));
        for (WebElement element : elements) {
            String tooltipText = element.getAttribute("title");
            if (tooltipText.equals( "Published")) {
               click(element);
            }
        }
            System.out.println("this item is unpublished already");
        return this;
    }

    public Boolean isUnpublish(String nonFoodName) {
        String nonFoodItem = String.format(getPublishButtonByLookupName,nonFoodName);

        String tooltipText = getElement(By.xpath(nonFoodItem)).getAttribute("title");
        if (tooltipText == "UnPublished")
            return true;
        return false;
    }

    public void isWhereUsedButtonDisplayed() {

    }

    public void isDeleteButtonDisplayed() {

    }


    public LoginPage logOut() {
        click(logOutButton);
        return new LoginPage(driver, wait);
    }

    public NonFoodItemPage isNonFoodItemDisplayed(String nonFoodItem) {
        List<WebElement> nonFoodName = getElements(nonFoodItemColumn);
        for (WebElement nonFoodNameElement : nonFoodName) {
            if (nonFoodNameElement.getText().equals(nonFoodItem))
                Assert.assertTrue(nonFoodNameElement.isDisplayed());
        }
        return this;
    }

    public NonFoodItemPage isNonFoodItemUnDisplayed(String nonFoodItem) {
        List<WebElement> nonFoodName = getElements(nonFoodItemColumn);

        for (WebElement nonFoodNameElement : nonFoodName) {
            if (nonFoodNameElement.getText().equals(nonFoodItem)) {
                System.out.println(nonFoodItem + " displayed");
            } else{
                Assert.assertTrue(true);
            }
        }

        return this;
    }
}
