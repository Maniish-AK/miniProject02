package POM.MiniProject02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditContactPage {
	
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

    @FindBy(id = "submit")
    public static WebElement submitButton;
    
    @FindBy(id = "cancel")
    public static WebElement cancelButton;
    
    public EditContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void editFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void editLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }
    
    public void editBirthdate(String birthdate) {
        birthdateField.sendKeys(birthdate);
    }

    public void editEmail(String email) {
        emailField.sendKeys(email);
    }

    public void editPhone(String phone) {
        phoneField.sendKeys(phone);
    }
    
    public void editStreetAdd1(String streetAdd1) {
    	streetAdd1Field.sendKeys(streetAdd1);
    }

    public void editStreetAdd2(String streetAdd2) {
    	streetAdd2Field.sendKeys(streetAdd2);
    }

    public void editCity(String city) {
    	cityField.sendKeys(city);
    }

    public void editStateProvince(String stateProvince) {
    	stateProvinceField.sendKeys(stateProvince);
    }

    public void editPostalCode(String postalCode) {
    	postalCodeField.sendKeys(postalCode);
    }
    
    public void editCountry(String country) {
    	countryField.sendKeys(country);
    }

    public void clickSubmit() {
    	submitButton.click();
    }
    
    public void clickCancel() {
    	cancelButton.click();
    }
    
    public boolean isFirstNameFieldVisible() {
        return firstNameField.isDisplayed();
    }
    
    public boolean isSubmitButtonVisible() {
        return submitButton.isDisplayed();
    }
    
    public String getLastName() {
        return lastNameField.getText();
    }
    
    public String getEmail() {
        return emailField.getText();
    }
    
    public String getPhone() {
        return phoneField.getText();
    }
    
    public void clearLastName() {
        lastNameField.clear();;
    }
    
    public void clearEmail() {
        emailField.clear();
    }
    
    public void clearPhone() {
        phoneField.clear();
    }

}
