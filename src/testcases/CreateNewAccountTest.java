package testcases;

import pages.DashboardPage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends BaseTest {

    //create user with valid information
    @Test (groups = {"CreateEditDeleteFlow"})
    public void createUserWithValidInformationTest() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDefaultAccount();

        dashBoardPage.navigateUserDashboard()
                .addNewUser()
                .setFirstName("test")
                .setLastName("MealSuite")
                .setEmail(randomEmail())
                .selectLanguage("French")
                .selectSystem("THS")
                .submitForm()
        .verifyAccountCreateSuccess();
    }

    //create with empty value
    @Test
    public void createUserWithEmptyAllField() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDefaultAccount();

        dashBoardPage.navigateUserDashboard()
                .addNewUser()
                .clickSave()
        .verifyAccountIsEmpty();
    }

    @Test
    public void createUserWithInvalidInformation() {

    }
}
