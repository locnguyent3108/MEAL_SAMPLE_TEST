package testcases;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DeleteUserInUserList extends BaseTest {
    @Test
    public void deleteUserInForm() {
        String userDeleted = "test";
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDefaultAccount();

        dashBoardPage.navigateUserDashboard()
                .searchUser(userDeleted)
                .selectFirstUser()
                .deleteAccount()
                .isAccountDeleted();
    }
}
