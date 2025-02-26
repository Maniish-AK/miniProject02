package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class AddContactPage extends ProjectSpecificationMethods {

	@FindBy(id = "firstName")
	WebElement firstNameField;

	@FindBy(id = "lastName")
	WebElement lastNameField;

	@FindBy(id = "birthdate")
	WebElement birthdateField;

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "phone")
	WebElement phoneField;

	@FindBy(id = "street1")
	WebElement streetAdd1Field;

	@FindBy(id = "street2")
	WebElement streetAdd2Field;

	@FindBy(id = "city")
	WebElement cityField;

	@FindBy(id = "stateProvince")
	WebElement stateProvinceField;

	@FindBy(id = "postalCode")
	WebElement postalCodeField;

	@FindBy(id = "country")
	WebElement countryField;

	@FindBy(id = "error")
	WebElement errorMessage;

	@FindBy(id = "submit")
	WebElement submitButton;

	@FindBy(id = "cancel")
	WebElement cancelButton;

	public AddContactPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AddContactPage enterFirstName(String firstname) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(firstNameField));
		firstNameField.sendKeys(firstname);
		return this;
	}

	public AddContactPage enterLastName(String lastname) {

		lastNameField.sendKeys(lastname);
		return this;
	}

	public AddContactPage enterBirthdate(String birthdate) {

		birthdateField.sendKeys(birthdate);
		return this;
	}

	public AddContactPage enterInvalidBirthdate() {

		birthdateField.sendKeys("30-11-1996");
		return this;
	}

	public AddContactPage enterEmail(String addemail) {

		emailField.sendKeys(addemail);
		return this;
	}

	public AddContactPage enterPhone(String phone) {

		phoneField.sendKeys(phone);
		return this;
	}

	public AddContactPage enterstreetAdd1(String streetadd1) {

		streetAdd1Field.sendKeys(streetadd1);
		return this;
	}

	public AddContactPage enterstreetAdd2(String streetadd2) {

		streetAdd2Field.sendKeys(streetadd2);
		return this;
	}

	public AddContactPage enterCity(String city) {

		cityField.sendKeys(city);
		return this;
	}

	public AddContactPage enterStateProvince(String stateprovince) {

		stateProvinceField.sendKeys(stateprovince);
		return this;
	}

	public AddContactPage enterPostalCode(String postalcode) {

		postalCodeField.sendKeys(postalcode);
		return this;
	}

	public AddContactPage enterCountry(String country) {

		countryField.sendKeys(country);
		return this;
	}

	public ContactListPage clickSubmit() {

		submitButton.click();
		return new ContactListPage(driver);
	}

	public AddContactPage clickSubmitForInvalid() {

		submitButton.click();
		return this;
	}

	public AddContactPage validateErrorMesaageForBirthdate() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		String errorMessageDisplayed = errorMessage.getText();
		System.out.println(errorMessageDisplayed);
		return this;
	}

}
