package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
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
    private By systemDropdownField = By.xpath("//select[@data-none-selected-text='None']");
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
    private By deleteButton = By.xpath("//div[@class='btn btn-red']");
    private By deleteButtonPopUp = By.xpath("//button[@class='btn btn-confirm btn-confirm-delete-ok']");
    private By countUserText = By.xpath("//span[@class='model-count']");
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
    public UserDashboardPage addNewUser() {
        click(addUserButton);
        hardWait();
        clickClose();
        hardWait();
        click(addUserButton);
        return this;
    }

    //Click close button inside Addnew section
    public UserDashboardPage clickClose() {
        click(closeButtonBy);
        waitForNextStep();
        return this;
    }

    //give text for Title field
    public UserDashboardPage setUserTitle(String title) {
        writeText(userTitleFieldBy, title);
        return this;
    }

    //give text for first name
    public UserDashboardPage setFirstName( String firstName) {
        waitElementReady(firstNameFieldBy);
        writeText(firstNameFieldBy, firstName);

        return this;
    }

    //give text for last name
    public UserDashboardPage setLastName(String lastName) {
        writeText(lastnameFieldBy, lastName);
        hardWait();
        return this;
    }

    //give text for username
    public UserDashboardPage setUserName(String usernameText) {
        cleanText(usernameFieldBy);
        writeText(usernameFieldBy, usernameText);
        return this;
    }

    //multiple select language: english - french
    // here is multiple dropdown, this function just for single select, fix later
    public UserDashboardPage selectLanguage(String languageSelect) {
        hardWait();
        if (languageSelect.equals(EN)) {
            selectOption(languageDropdownField,EN);
        } else {
            selectOption(languageDropdownField,FR);
        }
        return this;
    }

    //set email address
    public UserDashboardPage setEmail(String emailTextInput) {
        emailText = emailTextInput;
        writeText(emailFieldBy, emailText);
        hardWait();
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
        waitForNextStep();
        click(closeButtonBy);
        hardWait();
        return this;
    }

    //click save button
    public UserDashboardPage clickSave() {
        click(saveButtonBy);
        waitForNextStep();
        return this;
    }

    //search user in dashboard
    public UserDashboardPage searchUser (String emailText) {
        writeText(userSearchField, emailText);
        click(userSearchButton);
        return this;
    }

    //get list user by username in user dashboard
    public List<WebElement> getListUserName() {
        List<WebElement> listUserName = getElements(userNameData);
        return listUserName;
    }

    //get list first name of user by firstName in user dashboard
    public List<WebElement> getListFirstName() {
        List<WebElement> listFirstName = getElements(firstNameData);
        return listFirstName;
    }

    //get list last name of user by lastname in user dashboard
    public List<WebElement> getListLastName() {
        List<WebElement> listLastName = getElements(lastNameData);
        return listLastName;
    }

    //select on top user and click on it
    public UserDashboardPage selectFirstUser() {
        hardWait();
        List<WebElement> listUser = getListUserName();
        click(listUser.get(0));
        return this;
    }

    //delete account by using delete button in Add new section
    public UserDashboardPage deleteAccount() {
        hardWait();
        click(deleteButton);
        waitElementReady(deleteButtonPopUp);
        click(deleteButtonPopUp);
        return this;
    }

    //
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
        Assert.assertEquals(updatedLastName, expectedLastName);
    }

    public void isAccountDeleted() {
        String totalUserAfterDelete = getCountingUsers();
        WebElement alertText = getElement(successPopup);
        String alertTextRaw = alertText.getAttribute("innerHTML");
        Assert.assertTrue(alertTextRaw.contains("User was deleted successfully"));
        hardWait();
        if(!totalUserAfterDelete.equals(totalUser)){
            Assert.assertTrue(true);
        }
    }
}
