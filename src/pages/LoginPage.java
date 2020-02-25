package pages;


import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public DashboardPage loginWithDefaultAccount() {
        setUserName("FullAcDataB-Super");
        setPassword("Password123!");
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

}
