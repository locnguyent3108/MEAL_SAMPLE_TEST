package testcases.createUserTest;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import testcases.BaseTest;

public class CreateNewAccountSuccessTest extends BaseTest {

    //create user with valid information
    @Test (priority = 0, description="Create new user with valid information.")
    public void createUserWithValidInformationTest() {
        String email = randomEmail();
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDataBaseAccount();

        dashBoardPage.navigateUserDashboard()
                .addNewUser()
                .setFirstName("test")
                .setLastName("MealSuite")
                .setEmail(email)
                .selectLanguage("French")
                .selectSystem("Unidine")
                .submitForm()
        .isAccountCreateSuccess();
    }
}
