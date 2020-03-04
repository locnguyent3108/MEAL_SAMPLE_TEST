package testcases;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.TestListener;

@Listeners({TestListener.class})
public class EditUserTest extends BaseTest{


    @Test
    @Epic("EP0001")
    @Feature("Feature: Edit account")
    @Story("Story: Edit user with valid information.")
    @Description("EDIT_ACC_01: edit first name of account")
    public void editUserWithNewInformation() {
        String newFirstName = "Testing";
        String newLastName = "Edited";
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = new DashboardPage(driver);
        loginPage.goToLoginPage()
                .loginWithDataBaseAccount();

        dashBoardPage.navigateUserDashboard()
                .selectFirstUser()
                .setFirstName(newFirstName)
                //.setLastName(newLastName)
                .submitForm()
        .isFirstLastNameUpdated(newFirstName, newLastName);
    }
}
