package testcases;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DeleteUserInFormTest extends BaseTest{

    @Test
    public void deleteUserInForm() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDefaultAccount();

        dashBoardPage.navigateUserDashboard()
                     .selectFirstUser()
                     .deleteAccount()
        .isAccountDeleted();
    }

}
