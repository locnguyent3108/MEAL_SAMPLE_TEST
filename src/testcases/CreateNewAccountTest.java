package testcases;

import pages.DashboardPage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends BaseTest {

    @Test
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
}