package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class EditContactPage extends ProjectSpecificationMethods {

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

    @FindBy(id = "submit")
    WebElement submitButton;
    
    @FindBy(id = "cancel")
    WebElement cancelButton;
	
	public EditContactPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public EditContactPage reEnterLastName(String lastname) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(lastNameField));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lastNameField.clear();
		lastNameField.sendKeys(lastname);
		return this;
	}

	public EditContactPage reEnterEmail(String editemail) {

		emailField.clear();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emailField.sendKeys(editemail);
		return this;
	}

	public EditContactPage reEnterPhone(String phone) {

		phoneField.clear();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phoneField.sendKeys(phone);
		return this;
	}
	
	public ContactDetailsPage clickSubmit() {

		submitButton.click();
		return new ContactDetailsPage(driver);
	}
	
	public EditContactPage clearEmail() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(emailField));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emailField.clear();
		return this;
	}
	
	

}
