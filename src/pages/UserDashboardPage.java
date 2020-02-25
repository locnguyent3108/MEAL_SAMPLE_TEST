package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDashboardPage extends BasePage{
    //*********Constructor*********
    public UserDashboardPage(WebDriver driver) {
        super(driver);
    }

    public UserDashboardPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    //*********WebElements*********
    By addUserButton = By.xpath("//div[@class='top-actions']//button[@class='btn btn-green']");
    By userTitleFieldBy = By.xpath("//input[@id='user_title']");
    By firstNameFieldBy = By.xpath("//input[@id='user_first_name']");
    By lastnameFieldBy = By.xpath("//input[@id='user_last_name']");
    By emailFieldBy = By.xpath("//input[@id='user_email']");
    By usernameFieldBy = By.xpath("//input[@id='user_username']");
    By languageDropdownField = By.xpath("//button[@title='Nothing selected' or @title='English']/preceding-sibling::select");

    //*********Page Variable*********
    String en = "Enlish";
    String fr = "French";

    //*********Page Methods*********

    /**
     *  function below will  create new user
     *  this user display on top of the user dashboard
     * @return user dashboard page instance
     */
    //click add new button
    public UserDashboardPage addNewUser() {
        click(addUserButton);
        return this;
    }

    //give text for Title field
    public UserDashboardPage setUserTitle(String title) {
        writeText(userTitleFieldBy, title);
        return this;
    }

    //give text for first name
    public UserDashboardPage setFirstNameLastName(String firstName, String lastName) {
        writeText(firstNameFieldBy, firstName);
        writeText(lastnameFieldBy, lastName);
        return this;
    }

    //select language: english - french
    public UserDashboardPage selectLanguage(String languageSelect) {
        if (languageSelect.equals(en)) {
            selectOption(languageDropdownField,en);
        } else {
            selectOption(languageDropdownField,fr);
        }
        return this;
    }

    //set email address
    public UserDashboardPage setEmail(String emailText) {
        writeText(emailFieldBy, emailText);
        return this;
    }

    //set

}
