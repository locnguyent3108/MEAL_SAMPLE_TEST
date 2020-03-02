package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Map;


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
    private By languageDropdownButton = By.xpath("//button[@title='Nothing selected' or @title='English']");
    private By systemDropdownField = By.xpath("//select[@data-none-selected-text='None']");
    private By systemDropdownButton = By.xpath("//select[@data-none-selected-text='None']/following-sibling::button");
    private By saveButtonBy = By.xpath("//button[@id='user-form-submit']");
    private By userSearchField = By.xpath("//input[@id='user-search-text']");
    private By userSearchButton = By.xpath("//button[@id='user-search-button']");
    private By userTableBy = By.xpath("//tbody[@class='user-table-body']//a");
    private By closeButtonBy = By.xpath("//div[@id='modal-content']//button[@class='close']");
    private By successPopup = By.xpath("//div[@class='flash success text-center']");
    private By titleText = By.xpath("//a[@class='text-white']");
    private By validationError = By.xpath("//li[contains(text(),'Please complete all mandatory fields.')]");
    private By idLabel = By.xpath("//th[@title='Click to Sort by Id']");
    private By idData = By.xpath("//tr//td[2]");
    private By userNameLabel = By.xpath("//th[contains(text(),'Username')]");
    private By userNameData = By.xpath("//tr//td[3]/a");
    private By firstNameLabel = By.xpath("//th[contains(text(),'First Name')]");
    private By firstNameData = By.xpath("//tr//td[4]");
    private By lastNameLabel = By.xpath("//th[@data-field-name = 'last_name']");
    private By lastNameData = By.xpath("//tr//td[5]");
    private By deleteButtonInForm = By.xpath("//div[@class='btn btn-red']");
    private By deleteButtonPopUp = By.xpath("//button[@class='btn btn-confirm btn-confirm-delete-ok']");
    private By countUserText = By.xpath("//span[@class='model-count']");
    private By deleteButton = By.xpath("//i[@class='fas fa-times-circle']");
    private By unSelectColumns = By.xpath("//div[@id='unselected-columns-container']");
    private By AssignAccess = By.xpath("//li[@id='selectable_column_assigned_access']");
    //*********Page Variable*********
    static final String EN = "Enlish";
    static final String FR = "French";
    String totalUser;
    //System text variables
    static final String THS = "THS";
    static final String UNIDINE = "Unidine";
    static final String MEAL_SUITE = "MealSuite";
    static final String SYSTEM_ACOUNT = "System Account 1";
    String emailText;

    //Store table data by collumn
    private Map<WebElement, List<WebElement>> userTable;
    //*********Page Methods*********
    //click add new button
    @Step("click add new button")
    public UserDashboardPage addNewUser() {
        click(addUserButton);
        hardWait();
        clickClose();
        hardWait();
        click(addUserButton);
        return this;
    }

    //Click close button inside Addnew section
    @Step("close form create new user")
    public UserDashboardPage clickClose() {
        click(closeButtonBy);
        waitForNextStep();
        return this;
    }

    //give text for Title field
    @Step("set Title")
    public UserDashboardPage setUserTitle(String title) {
        writeText(userTitleFieldBy, title);
        return this;
    }

    //give text for first name
    @Step("set first name {0}")
    public UserDashboardPage setFirstName( String firstName) {
        waitElementReady(firstNameFieldBy);
        hardWait();
        cleanText(firstNameFieldBy);
        writeText(firstNameFieldBy, firstName);
        return this;
    }

    //give text for last name
    @Step("set Last name {0}")
    public UserDashboardPage setLastName(String lastName) {
        cleanText(lastnameFieldBy);
        writeText(lastnameFieldBy, lastName);
        hardWait();
        return this;
    }

    //give text for username
    @Step("set Username: {0}")
    public UserDashboardPage setUserName(String usernameText) {
        cleanText(usernameFieldBy);
        writeText(usernameFieldBy, usernameText);
        return this;
    }

    //multiple select language: english - french
    // here is multiple dropdown, this function just for single select, fix later
    @Step("Select language {0}")
    public UserDashboardPage selectLanguage(String languageSelect) {
        hardWait();
        String languageOptionField = "//a[@class='dropdown-item']/span[text()='%s']";
        click(languageDropdownButton);
        if (languageSelect.equals(EN)) {
            String enLanguage = String.format(languageOptionField,"English");
            click(getElement(By.xpath(enLanguage)));
        } else {
            String FrLanguage = String.format(languageOptionField,"French");
            click(getElement(By.xpath(FrLanguage)));        }
        return this;
    }

    //set email address
    @Step("Input email: {0}")
    public UserDashboardPage setEmail(String emailTextInput) {
        emailText = emailTextInput;
        writeText(emailFieldBy, emailText);
        hardWait();
        return this;
    }

    //multiple select system: THS - Unidine - MealSuite - System Account
    @Step("select system for user: {0}")
    public UserDashboardPage selectSystem(String systemSelect) {
        click(systemDropdownButton);
        if ("THS".equals(systemSelect)) {
            By ths = By.xpath("//span[contains(text(),'THS')]");
            click(ths);
        } else if ("Unidine".equals(systemSelect)) {
            By unidine = By.xpath("//span[contains(text(),'Unidine')]");
            click(unidine);
        } else if ("MealSuite".equals(systemSelect)) {
            By mealSuite = By.xpath("//span[contains(text(),'MealSuite')]");
            click(mealSuite);
        } else if ("System Account 1".equals(systemSelect)) {
            By systemAccount = By.xpath("//span[contains(text(),'System Account 1')]");
            click(systemAccount);
        }
        return this;
    }

    //submit register form
    @Step("click save and close form")
    public UserDashboardPage submitForm()  {
        click(saveButtonBy);
        waitForNextStep();
        click(closeButtonBy);
        hardWait();
        return this;
    }

    //click save button
    @Step("click save")
    public UserDashboardPage clickSave() {
        click(saveButtonBy);
        waitForNextStep();
        return this;
    }

    //search user in dashboard
    @Step("search user {0} in user dashboard")
    public UserDashboardPage searchUser (String emailText) {
        writeText(userSearchField, emailText);
        click(userSearchButton);
        return this;
    }

    //get list user by username in user dashboard
    @Step("call list user name")
    public List<WebElement> getListUserName() {
        List<WebElement> listUserName = getElements(userNameData);
        return listUserName;
    }

    //get list first name of user by firstName in user dashboard
    @Step("call list first name")
    public List<WebElement> getListFirstName() {
        List<WebElement> listFirstName = getElements(firstNameData);
        return listFirstName;
    }

    //get list last name of user by lastname in user dashboard
    @Step("call list last name")
    public List<WebElement> getListLastName() {
        List<WebElement> listLastName = getElements(lastNameData);
        return listLastName;
    }

    //select on top user and click on it
    @Step("select first user")
    public UserDashboardPage selectFirstUser() {
        hardWait();
        List<WebElement> listUser = getListUserName();
        click(listUser.get(0));
        return this;
    }

    //delete account by using delete button in Add new section
    @Step("delete selected user")
    public UserDashboardPage deleteAccount() {
        hardWait();
        click(deleteButtonInForm);
        waitElementReady(deleteButtonPopUp);
        click(deleteButtonPopUp);
        return this;
    }

    //delete account by using delete button in user list
    @Step("remove first user in list")
    public UserDashboardPage deleteAccountInUserList() {
        List<WebElement> deleteButtons = getElements(deleteButton);
        click(deleteButtons.get(0));
        waitElementReady(deleteButtonPopUp);
        click(deleteButtonPopUp);
        return this;
    }
    //
    @Step("get User in list")
    public String getCountingUsers() {
        WebElement countUser = getElement(countUserText);
        totalUser = countUser.getText();
        return totalUser;
    }

    //*********Verify methods*********
    public UserDashboardPage isAccountCreateSuccess() {
        observesElementOnScreen(userTableBy, emailText);
        return this;
    }

    public UserDashboardPage isAccountEmpty() {
        waitForNextStep();
        observesTextOnScreen(validationError);
        return this;
    }

    public UserDashboardPage isDisplayOnSelectedCollumns() {
        WebElement unselectedBox = getElement(unSelectColumns);
        WebElement check = unselectedBox.findElement(AssignAccess);
        return this;
    }

    //TODO
//    public UserDashboardPage getUserTable() {
//        userTable = new HashMap<WebElement, List<WebElement>>();
//        userTable.put(getElement(idLabel),getElements(idData));
//        userTable.put(getElement(userNameLabel),getElements(userNameData));
//        Map.Entry<WebElement, List<WebElement>> entry = userTable.entrySet().iterator().next();
//        List = entry.getKey();
//        for (int i = 0; i < 10 ; i++) {
//            for(Map.Entry<WebElement, List<WebElement>> a : userTable.entrySet()) {
//                WebElement key = a.getKey();
//                System.out.println(key.getText());
//                for(WebElement element : a.getValue()) {
//                    System.out.println(element.getText());
//                }
//            }
//        }
//
//        return userTable;
//    }

    public void isFirstLastNameUpdated(String expectedFirstName, String expectedLastName) {
        refresh();
        waitForNextStep();
        List<WebElement> listFirstName = getListFirstName();
        String updatedFirstName = listFirstName.get(0).getText();
        List<WebElement> listLastName = getListLastName();
        String updatedLastName = listLastName.get(0).getText();
        Assert.assertEquals(updatedFirstName, expectedFirstName);
    }

    public void isAccountDeleted() {
        String totalUserAfterDelete = getCountingUsers();
        WebElement alertText = getElement(successPopup);
        String alertTextRaw = alertText.getAttribute("innerHTML");
        Assert.assertTrue(alertTextRaw.contains("User was deleted successfully"));
        hardWait();

    }
}
