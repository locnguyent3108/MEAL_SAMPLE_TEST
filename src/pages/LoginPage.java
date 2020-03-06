package pages;


import io.qameta.allure.Step;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.UserLevelAccount;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage (WebDriver driver, WebDriverWait wait) {
        super(wait, driver);
    }
    public LoginPage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String pageUrl = "/users/login";
    final String pageLoadedText = "You need to sign in or sign up before continuing";


    //*********Web Elements*********
    private By userNameTextBoxBy = By.id("user_username");
    private By passwordTextBoxBy = By.id("user_password");
    private By loginButtonBy = By.name("commit");
    private By forgotYourPasswordBy = By.xpath("//a[contains(text(),'Forgot your password?')]");
    //*********Verify section*********
    /**
     * Verify that the page loaded completely.
     *
     * @return the loginPage class instance.
     */
    public LoginPage verifyPageLoaded() {
        wait.until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                return webDriver.getPageSource().contains("pageLoadedText");
            }
        });
        return this;
    }


    //*********Page Methods*********
    //Go to Homepage
    public LoginPage goToLoginPage (){
        driver.get(url);
        return this;
    }

    /**
     * login with default credential
     */
    public DashboardPage loginWithDataBaseAccount() {
        UserLevelAccount userDatabase = UserLevelAccount.DATABASE_USER_MANAGE;
        setUserName(userDatabase.getUserName());
            setPassword(userDatabase.getPassword());

        click(loginButtonBy);
        return new DashboardPage(wait, driver);
    }

    /**
     * set username to user name field
     * @return LoginPage instance
     */
    public LoginPage setUserName(String userName) {
        writeText(userNameTextBoxBy, userName);
        return this;
    }

    /**
     * set username to user name field
     * @return LoginPage instance
     */
    public LoginPage setPassword(String password) {
        writeText(passwordTextBoxBy, password);
        return this;
    }

    /**
     * Click on Forgot Your Password Link.
     * @return the loginPage class instance.
     */
    public LoginPage clickForgotYourPasswordLink() {
        click(forgotYourPasswordBy);
        return this;
    }

    public DashboardPage loginWithFacilityAccount() {
        UserLevelAccount userFacility = UserLevelAccount.FACILITY_USER_MANAGE;
        setUserName(userFacility.getUserName());
        setPassword(userFacility.getPassword());
        click(loginButtonBy);
        return new DashboardPage(wait, driver);
    }

    @Step("Login with {0}: ")
    public DashboardPage loginToDashBoard(UserLevelAccount user) {
        setUserName(user.getUserName());
        setPassword(user.getPassword());
        click(loginButtonBy);
        return new DashboardPage(wait, driver);
    }
}
