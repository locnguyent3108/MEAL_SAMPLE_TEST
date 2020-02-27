package testcases;

import pages.DashboardPage;
import pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.priority;

public class CreateNewAccountSuccessTest extends BaseTest {

    //create user with valid information
    @Test
    public void createUserWithValidInformationTest() {
        String email = randomEmail();
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDefaultAccount();

        dashBoardPage.navigateUserDashboard()
                .addNewUser()
                .setFirstName("test")
                .setLastName("MealSuite")
                .setEmail(email)
                .selectLanguage("French")
                .selectSystem("THS")
                .submitForm()
        .verifyAccountCreateSuccess();
    }
}
