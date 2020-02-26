package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtil;


public class UserDashboardPage extends BasePage{
    //*********Constructor*********
    public UserDashboardPage(WebDriver driver) {
        super(driver);
    }

    public UserDashboardPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    //*********WebElements*********
    private By addUserButton = By.xpath("//div[@class='top-actions']//button[@class='btn btn-green']");
    private By userTitleFieldBy = By.xpath("//input[@id='user_title']");
    private By firstNameFieldBy = By.xpath("//input[@id='user_first_name']");
    private By lastnameFieldBy = By.xpath("//input[@id='user_last_name']");
    private By emailFieldBy = By.xpath("//input[@id='user_email']");
    private By usernameFieldBy = By.xpath("//input[@id='user_username']");
    private By languageDropdownField = By.xpath("//button[@title='Nothing selected' or @title='English']/preceding-sibling::select");
    private By systemDropdownField = By.xpath("//select[@data-none-selected-text='None']");
    private By saveButtonBy = By.xpath("//button[@id='user-form-submit']");
    private By userSearchField = By.xpath("//input[@id='user-search-text']");
    private By userSearchButton = By.xpath("//button[@id='user-search-button']");
    private By userTableBy = By.xpath("//tbody[@class='user-table-body']//a");
    private By closeButtonBy = By.xpath("//div[@id='modal-content']//button[@class='close']");
    private By successPopup = By.xpath("//div[@class='flash success text-center']");
    private By titleText = By.xpath("//a[@class='text-white']");

    //*********Page Variable*********
    static final String EN = "Enlish";
    static final String FR = "French";

    //System text variables
    static final String THS = "THS";
    static final String UNIDINE = "Unidine";
    static final String MEAL_SUITE = "MealSuite";
    static final String SYSTEM_ACOUNT = "System Account 1";
    String emailText;
    //*********Page Methods*********
    /**
     *  function below will  create new user
     *  this user display on top of the user dashboard
     * @return user dashboard page instance
     */
    //click add new button
    public UserDashboardPage addNewUser() {
        click(addUserButton);
        loading(titleText);
        click(closeButtonBy);
        waitForNextStep();
        click(addUserButton);

        return this;
    }

    //give text for Title field
    public UserDashboardPage setUserTitle(String title) {
        writeText(userTitleFieldBy, title);
        return this;
    }

    //give text for first name
    public UserDashboardPage setFirstName( String firstName) {
        writeText(firstNameFieldBy, firstName);
        waitForNextStep();
        return this;
    }

    public UserDashboardPage setLastName(String lastName) {
        writeText(lastnameFieldBy, lastName);
        waitForNextStep();
        return this;
    }

    //give text for username
    public UserDashboardPage setUserName(String usernameText) {
        writeText(usernameFieldBy, usernameText);
        return this;
    }

    //multiple select language: english - french
    // here is multiple dropdown, this function just for single select, fix later
    public UserDashboardPage selectLanguage(String languageSelect) {
        if (languageSelect.equals(EN)) {
            selectOption(languageDropdownField,EN);
        } else {
            selectOption(languageDropdownField,FR);
        }
        waitForNextStep();
        return this;
    }

    //set email address
    public UserDashboardPage setEmail(String emailTextInput) {
        emailText = emailTextInput;
        writeText(emailFieldBy, emailText);
        waitForNextStep();
        return this;
    }

    //multiple select system: THS - Unidine - MealSuite - System Account
    public UserDashboardPage selectSystem(String systemSelect) {
        switch (systemSelect) {
            case "THS":
                selectOption(systemDropdownField,THS);
                break;
            case "Unidine":
                selectOption(systemDropdownField,UNIDINE);
                break;
            case "MealSuite":
                selectOption(systemDropdownField,MEAL_SUITE);
                break;
            case "System Account 1":
                selectOption(systemDropdownField,SYSTEM_ACOUNT);
                break;
        }
        return this;
    }

    //submit register form
    public UserDashboardPage submitForm()  {
        click(saveButtonBy);
        loading(successPopup);
        click(closeButtonBy);
        return this;
    }

    //search user in dashboard
    public UserDashboardPage searchUser (String emailText) {
        writeText(userSearchField, emailText);
        click(userSearchButton);
        return this;
    }

    //*********Verify methods*********
    public UserDashboardPage verifyAccountCreateSuccess() {

        assertExists(userTableBy, emailText);
        return this;
    }
}
