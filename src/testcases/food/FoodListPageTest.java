package testcases.food;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.FoodPage;
import pages.LoginPage;
import testcases.BaseTest;
import utils.UserLevelAccount;

public class FoodListPageTest extends BaseTest {
    @Test
    public void foodAddEditTest() {
        String foodName = "Straw, Plastic";
        String foodName2 = "Sandwich, Bacon";
        UserLevelAccount userDB = UserLevelAccount.DATABASE_MANAGE;
        UserLevelAccount userSys = UserLevelAccount.SYSTEM_MANAGE;
        UserLevelAccount userCorp = UserLevelAccount.COOPERATE_MANAGE;
        UserLevelAccount userFac = UserLevelAccount.FACILITY_MANAGE;
        DashboardPage dashBoardPage = new DashboardPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        FoodPage foodPage = new FoodPage(driver);

/**Step 1: login DB level and go to Food listing.
    Expection: display same as design
 */        loginPage.goToLoginPage()
                .loginToDashBoard(userDB);
        dashBoardPage.navigateFoodItemPage();

/**Step 4: click check-circle icon
    Expection: icon turn to green*/
            foodPage.publishFoodItem(foodName)

/**Step 5: click check-circle icon
 Expectation: icon turn to grey*/
                    .unpublishedFoodItem(foodName)
                    .logOut();

/**Step 6: Login with child account
 Expectation: unable to view unpublished items at parent level
 Step 7: search for the food you've unpublished
 Expectation: Unable to find unpublished food                */
        loginPage.loginToDashBoard(userCorp);
        dashBoardPage.navigateFoodItemPage();
        foodPage.searchUnpublished(foodName)
        .isSearchResultEmpty();

/**Step 8: unpublish a food in current account the login with parent account
 Expectation: Unable to view Unpublished items at Parent level   */
        foodPage.searchFood(foodName2)
                .unpublishedFoodItem(foodName2)
                .logOut();
        loginPage.loginToDashBoard(userSys)
                .navigateFoodItemPage();
        foodPage.selectLevel()
                .searchFood(foodName2)
        .isSearchUnpublishEmpty();
        foodPage.logOut();

/** Step 9, 10, 11: wait for Retest. Currently can't login to menu, report pages
 */

/** Step 13: click viwew button
 Expectation: Customize view options include available columns
 */
        loginPage.loginToDashBoard(userFac)
                .navigateFoodItemPage();
//        foodPage.

    }


}
