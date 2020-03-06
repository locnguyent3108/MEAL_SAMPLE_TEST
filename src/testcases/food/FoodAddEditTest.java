package testcases.food;

import pages.DashboardPage;
import pages.FoodPage;
import pages.LoginPage;
import testcases.BaseTest;
import utils.UserLevelAccount;
import org.testng.annotations.Test;
public class FoodAddEditTest extends BaseTest {


    @Test (priority = 0, description="")
    public void foodAddEditTEst() {
        String foodName = "Strawberry";
        String foodName2 = "Sandwich, Bacon";
        UserLevelAccount userDB = UserLevelAccount.DATABASE_MANAGE;
        UserLevelAccount userSys = UserLevelAccount.SYSTEM_MANAGE;
        UserLevelAccount userCorp = UserLevelAccount.COOPERATE_MANAGE;
        UserLevelAccount userFac = UserLevelAccount.FACILITY_MANAGE;
        DashboardPage dashBoardPage = new DashboardPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        FoodPage foodPage = new FoodPage(driver);

//Step 1: Log in as a Database User.
//        Go to Recipes > Food Listing.
//        Click on Lookup Name of a Food.
//  Expectation: Food Add/Edit modal opens as a side panel with 4 accordion sections.
        loginPage.goToLoginPage()
                 .loginToDashBoard(userDB);
        dashBoardPage.navigateFoodItemPage();
        foodPage.selectFood(foodName)
            .isDisplayFoodModal();

//Step 2: Type 40+ characters into the Food Lookup Name text box.
//  Expectation: Food Lookup Name is limited to 40 characters.
        foodPage.setFoodNameWithLength(60)
                .isLimited40Characters();

//Step 3: Type 30+ characters into the Food Display Name text box.
//  Expectation: Food Display Name is limited to 30 characters
        foodPage.setFoodDisplayWithLength(50)
                .isLimited30Characters()
//Step 4: Type 150+ characters into the Description text field.
//  Expectation: Description is limited to 150 characters.
                .setDescriptionWithLength(170)
                .isLimited150Characters();
//Step 5:
    }
}
