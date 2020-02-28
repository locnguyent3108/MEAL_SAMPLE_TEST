package testcases.deleteuserTest;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import testcases.BaseTest;

public class DeleteUserInUserList extends BaseTest {
    @Test
    public void deleteUserInForm() {
        String userDeleted = "test";
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDefaultAccount();

        dashBoardPage.navigateUserDashboard()
                .deleteAccountInUserList()
        .isAccountDeleted();
    }
}
