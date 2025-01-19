package POM.MiniProject02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactPage {
	
	WebDriver driver;
	
	@FindBy(id = "firstName")
	public WebElement firstNameField;

    @FindBy(id = "lastName")
    public static WebElement lastNameField;
    
    @FindBy(id = "birthdate")
    public static WebElement birthdateField;

    @FindBy(id = "email")
    public static WebElement emailField;

    @FindBy(id = "phone")
    public static WebElement phoneField;
    
    @FindBy(id = "street1")
    public static WebElement streetAdd1Field;

    @FindBy(id = "street2")
    public static WebElement streetAdd2Field;
    
    @FindBy(id = "city")
    public static WebElement cityField;

    @FindBy(id = "stateProvince")
    public static WebElement stateProvinceField;

    @FindBy(id = "postalCode")
    public static WebElement postalCodeField;
    
    @FindBy(id = "country")
    public static WebElement countryField;
    
    @FindBy(id = "error")
    public WebElement errorMessage;

    @FindBy(id = "submit")
    public WebElement submitButton;
    
    @FindBy(id = "cancel")
    public static WebElement cancelButton;
    
    public AddContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }
    
    public void enterBirthdate(String birthdate) {
        birthdateField.sendKeys(birthdate);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }
    
    public void enterstreetAdd1(String streetAdd1) {
    	streetAdd1Field.sendKeys(streetAdd1);
    }

    public void enterstreetAdd2(String streetAdd2) {
    	streetAdd2Field.sendKeys(streetAdd2);
    }

    public void enterCity(String city) {
    	cityField.sendKeys(city);
    }

    public void enterStateProvince(String stateProvince) {
    	stateProvinceField.sendKeys(stateProvince);
    }

    public void enterPostalCode(String postalCode) {
    	postalCodeField.sendKeys(postalCode);
    }
    
    public void enterCountry(String country) {
    	countryField.sendKeys(country);
    }

    public void clickSubmit() {
    	submitButton.click();
    }
    
    public void clickCancel() {
    	cancelButton.click();
    }
    
    public void enterContactDetails(String firstName, String lastName, String birthdate, String email, String phone, String streetAdd1, String streetAdd2, String city, String stateProvince, String postalCode, String country) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        birthdateField.sendKeys(birthdate);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
        streetAdd1Field.sendKeys(streetAdd1);
        streetAdd2Field.sendKeys(streetAdd2);
        cityField.sendKeys(city);
        stateProvinceField.sendKeys(stateProvince);
        postalCodeField.sendKeys(postalCode);
        countryField.sendKeys(country);
    }
    
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
    
    public void clearAllFields() {
        firstNameField.clear();
        lastNameField.clear();
        birthdateField.clear();
        emailField.clear();
        phoneField.clear();
        birthdateField.clear();
        streetAdd1Field.clear();
        streetAdd2Field.clear();
        cityField.clear();
        stateProvinceField.clear();
        postalCodeField.clear();
        countryField.clear();
    }
    
    public boolean isFirstNameFieldVisible() {
        return firstNameField.isDisplayed();
    }
    
    public boolean isSubmitButtonVisible() {
        return submitButton.isDisplayed();
    }

}
