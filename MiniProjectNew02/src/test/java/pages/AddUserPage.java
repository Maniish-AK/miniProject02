package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class AddUserPage extends ProjectSpecificationMethods {

	@FindBy (id = "firstName")
	WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;
    
    @FindBy(id = "password")
    WebElement passwordField;
    
    @FindBy(id = "submit")
    WebElement signupSubmitButton;
    
    @FindBy(id = "cancel")
    WebElement signupCancelButton;
	
	public AddUserPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public AddUserPage enterFirstName(String firstName) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
		firstNameField.sendKeys(firstName);
    	return this;
    }
    
    public AddUserPage enterLastName(String lastName) {
    	
    	lastNameField.sendKeys(lastName);
    	return this;
    }
    
    public AddUserPage enterEmail(String email) {
    	
    	emailField.sendKeys(email);
    	return this;
    }
    
    public AddUserPage enterPassword(String password) {
    	
    	passwordField.sendKeys(password);
    	return this;
    }

    public ContactListPage clickSignupSubmit() {
    	
    	signupSubmitButton.click();
    	return new ContactListPage(driver);
    }
    
    public AddUserPage clickSignupCancel() {
    	
    	signupCancelButton.click();
    	return this;
    }
	
	

}
