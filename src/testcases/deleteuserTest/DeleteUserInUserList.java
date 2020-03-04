package testcases.deleteuserTest;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import testcases.BaseTest;

public class DeleteUserInUserList extends BaseTest {
    @Test (priority = 0, description="Delete user in dashboard")
    @Description("DEL_ACC_02: user can click on delete button and first user deleted")
    public void deleteUserInForm() {
        String userDeleted = "test";
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDataBaseAccount();

        dashBoardPage.navigateUserDashboard()
                .deleteAccountInUserList()
        .isAccountDeleted();
    }
}
