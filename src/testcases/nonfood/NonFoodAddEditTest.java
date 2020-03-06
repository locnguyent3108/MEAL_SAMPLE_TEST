package testcases.nonfood;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NonFoodItemPage;
import testcases.BaseTest;

public class NonFoodAddEditTest  extends BaseTest {
    @Test
    @Epic("Non-Food Add/Edit")
    @Feature("Feature: Add edit food")
    public void nonFoodAddEditTest() {
        String nonFoodItem = "Straw, Plastic";
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        NonFoodItemPage nonFoodItemPage = new NonFoodItemPage(driver);
//Step 1: DBUser login to Non-Food items
        loginPage.goToLoginPage()
                        .loginWithDataBaseAccount();

        dashBoardPage
                        .navigateNonFoodItemPage();
//Step 2,3,4: click check-circle icon to publish a Non-food item.
        nonFoodItemPage
                        .ClickPublishButton(nonFoodItem)
//Step 5: click check-circle icon to unpbulish a Non-Food item.
                        .ClickPublishButton(nonFoodItem)
                        .logOut();

//Step 6: log in ass child account,
        loginPage
                        .loginWithFacilityAccount();
        dashBoardPage
                        .navigateNonFoodItemPage();
        nonFoodItemPage
                .isNonFoodItemUnDisplayed(nonFoodItem)

//Step 7: Search for the non-food you've unublished
                        .searchUnpublished(nonFoodItem)
                .isSearchResultEmpty();

//Step 8: Unpublish a non-food in account you are currently logge in as.
    }
}