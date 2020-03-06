package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
    //*********Constructor*********
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    //*********Page variables*********
    String userDashboardUrl = "/users";
    String nonFoodItemURL = "/non_food_items";
    String foodItemURL = "/foods";

    //*********Web Elements*********
    By mainMenubutton = By.xpath("//a[@id='trigger']/i");

    //*********Page Methods*********

    /**
     * click to main menu on top left screen
     * @return dashboard page instance
     */
    public DashboardPage clickMainMenu() {
        click(mainMenubutton);
        return this;
    }

    /**
     * navigate to Users page
     * @return User page
     */
    public UserDashboardPage navigateUserDashboard() {
        navigate(userDashboardUrl);
        return new UserDashboardPage(this.wait, this.driver);
    }

    public NonFoodItemPage navigateNonFoodItemPage() {
        navigate(nonFoodItemURL);
        return new NonFoodItemPage(this.wait, this.driver);
    }

    public FoodPage navigateFoodItemPage() {
        navigate(foodItemURL);
        return new FoodPage(this.wait, this.driver);

    }
}
