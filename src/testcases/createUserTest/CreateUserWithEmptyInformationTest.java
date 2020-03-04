package testcases.createUserTest;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import testcases.BaseTest;

public class CreateUserWithEmptyInformationTest extends BaseTest {
    @Test (priority = 0, description="Create new user with empty information.")
    @Description("CRE_ACC_02: create new account and leave blank all information email")
    public void createUserWithEmptyAllField() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDataBaseAccount();

        dashBoardPage.navigateUserDashboard()
                .addNewUser()
                .clickSave()
                .isAccountEmpty();
    }
}
