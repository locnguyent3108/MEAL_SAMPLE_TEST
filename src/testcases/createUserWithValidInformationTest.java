package testcases;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class createUserWithValidInformationTest extends BaseTest {
    @Test
    public void createUserWithEmptyAllField() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDefaultAccount();

        dashBoardPage.navigateUserDashboard()
                .addNewUser()
                .clickSave()
                .isAccountEmpty();
    }
}
