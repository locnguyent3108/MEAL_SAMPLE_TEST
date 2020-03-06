package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class FoodPage extends BasePage{
    //*********Constructor**********
    public FoodPage(WebDriver driver) {
        super(driver);
    }
    public FoodPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);

    }

    //*********Page Variables*******
    String publishButtonByFoodName = "//tr[td[a[contains(text(),'%s')]]]/td[last()]/a[1]";
    String getPublishButtonByLookupName = "//tr[td[a[contains(text(),'%s')]]]//a[1]";
    String anotherSections = "//a[contains(text(),'%s')]";
    //*********Web Elements*********
    private By logOutButton = By.xpath("//a[contains(text(),'Logout')]");
    private By foodItemColumn = By.xpath("//a[contains(@href,'/edit')]");
    private By FoodSearch = By.xpath("//input[@id='food-search-text']");
    private By searchResultEmpty = By.xpath("//div[@id='recipes']//h3[@class='p-4 gray']");
    private By filterButton = By.xpath("//div[@class='p-4 filters']/a");
    private By publishToggle = By.xpath("//div[@class='toggle btn btn-default']//label[@class='btn btn-default toggle-on']");
    private By applyFilter = By.xpath("//button[@id='food-filtration-button']");
    private By switchId = By.xpath("//div[@class='top-bar d-flex justify-content-between']//li[3]//a[1]");
    private By selectTestCorp = By.xpath("//div[contains(text(),'Test Corporation 1 (ID: 3)')]");
    private By unpublished = By.xpath("//a[@class='text-dark px-2']");
    private By listFoodItem = By.xpath("//a[contains(@href,'/edit')]");

    //-------------------FOOD ADD/EDIT MODAL-----------------------------------------------
    private By foodInformation = By.xpath("//div[@id='food-form-tab']//a[@class='text-white'][contains(text(),'Prepared Food Information')]");
    private By foodNameTextField = By.xpath("//input[@id='food_name']");
    private By deleteButton = By.xpath("//div[@class='btn btn-red']");
    private By publishButton = By.xpath("//button[@id='prepared-food-form-publish']");
    private By saveButton = By.xpath("//button[@id='prepared-food-form-submit']");
    private By nameTextField = By.xpath("//input[@id='food_name']");
    private By displayNameTextField = By.xpath("//input[@id='food_display_name']");
    private By foodCategoryDropdown = By.xpath("//div[@class='col-6 col-md-3']//div[@class='dropdown bootstrap-select show-tick select form-control mandatory']//button[@class='btn dropdown-toggle btn-light bs-placeholder']");
    private By tagDropdown = By.xpath("//div[@class='row mb-2 border-bottom']//div[@class='input-group']");
    private By foodDescriptionTextField = By.xpath("//input[@id='prepared_food_description']");
    private By densityTextField = By.xpath("//input[@id='prepared_food_portion_sizes_attributes_0_display_quantity']");
    private By PortionSizeTextField = By.xpath("//input[@id='prepared_food_portion_sizes_attributes_0_display_quantity']");
    private By PrepepDropdown = By.xpath("//label[@for='prepared_food_food_densities_attributes_0_pre_prep_method_ids']");
    private By ediblePortion = By.xpath("//label[contains(text(),'Edible Portion')]/following-sibling::div");
    private By storageType = By.xpath("//label[contains(text(),'Storage Type')]/following-sibling::div");
    private By stockItemCategory = By.xpath("//label[contains(text(),'Stock Item Category')]/following-sibling::div");
    private By storageLocation = By.xpath("//label[contains(text(),'Storage Locations')]/following-sibling::div");
    //*********Page Methods*********

    public FoodPage publishFoodItem(String foodName) {
        hardWait();
        filterToViewUnpublishFood();
        String foodNameFormat = String.format(publishButtonByFoodName, foodName);
        click(getElement(By.xpath(foodNameFormat)));
        return this;
    }

    public FoodPage unpublishedFoodItem (String foodName) {
        hardWait();
        String foodNameFormat = String.format(publishButtonByFoodName, foodName);
        click(getElement(By.xpath(foodNameFormat)));
        return this;
    }

    public LoginPage logOut() {
        click(logOutButton);
        return new LoginPage(driver, wait);
    }

    public void isUnpublishFoodDisplay(String foodName) {
        List<WebElement> nonFoodName = getElements(foodItemColumn);

        for (WebElement FoodNameElement : nonFoodName) {
            if (FoodNameElement.getText().equals(foodName)) {
                System.out.println(foodName + " displayed");
            } else{
                Assert.assertTrue(true);
            }
        }
    }

    public FoodPage searchUnpublished(String foodName) {
        hardWait();
        return searchFood(foodName);
    }

    public void isSearchResultEmpty() {
        Assert.assertEquals(getElement(searchResultEmpty).getText(),"No results matched your search criteria.");
    }

    public void isSearchUnpublishEmpty() {
        Assert.assertEquals(getElements(unpublished).size(),1);
    }

    public FoodPage filterToViewUnpublishFood() {
        hardWait();
        click(filterButton);
        click(applyFilter);
        return this;
    }

    public FoodPage searchFood(String foodName) {
        WebElement searchTextBox = getElement(FoodSearch);
        cleanText(FoodSearch);
        writeText(FoodSearch, foodName);
        searchTextBox.sendKeys(Keys.ENTER);
        return this;
    }

    public FoodPage selectLevel() {
        click(switchId);
        hardWait();
        click(selectTestCorp);
        return this;
    }

    @Step("Select food: {0}")
    public FoodPage selectFood(String foodName) {
        List<WebElement> listFood = getElements(listFoodItem);
        for (WebElement foodElement : listFood) {
            if(foodElement.getText().equals(foodName))
                click(foodElement);
        }
        return this;
    }
    @Step("type 40+ characters into food name text box")
    public FoodPage setFoodNameWithLength(int n){
        writeText(foodNameTextField,getAlphaNumericString(n));
        return this;
    }

    @Step("type 30+ characters into food display text box")
    public FoodPage setFoodDisplayWithLength(int n){
        writeText(displayNameTextField,getAlphaNumericString(n));
        return this;
    }

    @Step("type 150+ characters into the Description text field.")
    public FoodPage setDescriptionWithLength(int n) {
        writeText(foodDescriptionTextField,getAlphaNumericString(n));
        return this;
    }
    public FoodPage setDescriptionWithLength(int n) {
        writeText(densityTextField,"getAlpha Numeric String");
        return this;
    }

    @Step("Type characters into the Density text field.")

    public FoodPage isLimited150Characters() {
        String actualText = getElement(foodDescriptionTextField).getAttribute("value");
        Assert.assertEquals(actualText.length(),150);
        return this;
    }

    public FoodPage isLimited30Characters() {
        String actualText = getElement(displayNameTextField).getAttribute("value");
        Assert.assertEquals(actualText.length(),30);
        return this;
    }

    public FoodPage isLimited40Characters() {
        String actualText = getElement(foodNameTextField).getAttribute("value");
        Assert.assertEquals(actualText.length(),40);
        return this;
    }

    public void isDisplayFoodModal() {
        List<WebElement> addEditModal = new ArrayList<>();
        addEditModal.add(getElement(foodInformation));
        addEditModal.add(getElement(deleteButton));
        addEditModal.add(getElement(publishButton));
        addEditModal.add(getElement(saveButton));
        addEditModal.add(getElement(nameTextField));
        addEditModal.add(getElement(displayNameTextField));
        addEditModal.add(getElement(foodCategoryDropdown));
        addEditModal.add(getElement(tagDropdown));
        addEditModal.add(getElement(foodDescriptionTextField));
        addEditModal.add(getElement(densityTextField));
        addEditModal.add(getElement(PortionSizeTextField));
        addEditModal.add(getElement(PrepepDropdown));
        addEditModal.add(getElement(ediblePortion));
        addEditModal.add(getElement(storageType));
        addEditModal.add(getElement(stockItemCategory));
        addEditModal.add(getElement(storageLocation));
        for (WebElement item : addEditModal) {
            Assert.assertTrue(item.isDisplayed());
        }
    }

}
