package POM.MiniProject02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
	WebDriver driver;
	
	@FindBy (id = "firstName")
	public WebElement firstNameField;

    @FindBy(id = "lastName")
    public static WebElement lastNameField;

    @FindBy(id = "email")
    public static WebElement emailField;
    
    @FindBy(id = "password")
    public static WebElement passwordField;
    
    @FindBy(id = "submit")
    public static WebElement signupSubmitButton;
    
    @FindBy(id = "cancel")
    public static WebElement signupCancelButton;
    
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterFirstName(String firstName) {
    	firstNameField.sendKeys(firstName);
    }
    
    public void enterLastName(String lastName) {
    	lastNameField.sendKeys(lastName);
    }
    
    public void enterEmail(String email) {
    	emailField.sendKeys(email);
    }
    
    public void enterPassword(String password) {
    	passwordField.sendKeys(password);
    }

    public void clickSignupSubmit() {
    	signupSubmitButton.click();
    }
    
    public void clickSignupCancel() {
    	signupCancelButton.click();
    }

    public boolean isFirstNameFieldVisible() {
        return firstNameField.isDisplayed();
    }
    
    public boolean isLastnameFieldVisible() {
        return lastNameField.isDisplayed();
    }
    
    public boolean isSignupSubmitButtonVisible() {
        return signupSubmitButton.isDisplayed();
    }

}
