package testcases;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class EditUserTest extends BaseTest{


    @Test (groups = "CreateEditDeleteFlow")
    public void editUserWithNewInformation() {
        String newFirstName = "Testing";
        String newLastName = "Edited";
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDefaultAccount();

        dashBoardPage.navigateUserDashboard()
                .selectFirstUser()
                .setFirstName(newFirstName)
                .setLastName(newLastName)
                .submitForm()
        .isFirstLastNameUpdated(newFirstName, newLastName);

    }

    public void editUserWithWrongEmail() {

    }
}
