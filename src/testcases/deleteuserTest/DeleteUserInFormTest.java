package testcases.deleteuserTest;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import testcases.BaseTest;

public class DeleteUserInFormTest extends BaseTest {

    @Test (priority = 0, description="Delete user in add new form")
    @Description("DEL_ACC_01: `verify user can be deleted in form")
    public void deleteUserInForm() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDataBaseAccount();

        dashBoardPage.navigateUserDashboard()
                     .selectFirstUser()
                     .deleteAccount()
        .isAccountDeleted();
    }

}
