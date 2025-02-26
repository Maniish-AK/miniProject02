package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods {

	@FindBy(id = "signup")
	WebElement signUpButton;

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "submit")
	WebElement loginSubmitButton;

	@FindBy(id = "error")
	WebElement loginErrorMessage;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage enterInvalidEmail() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(emailField));
		emailField.sendKeys("maniishguvi@com");
		return this;
	}

	public HomePage enterEmail(String email) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(emailField));
		emailField.clear();
		emailField.sendKeys(email);
		return this;
	}

	public HomePage enterPassword(String password) {

		passwordField.clear();
		passwordField.sendKeys(password);
		return this;
	}

	public HomePage clickLoginSubmitForInvalid() {

		if (loginSubmitButton.isDisplayed()) {
			loginSubmitButton.click();
		}
		return this;

	}
	
	public ContactListPage clickLoginSubmit() {

		if (loginSubmitButton.isDisplayed()) {
			loginSubmitButton.click();
		}
		return new ContactListPage(driver);

	}

	public HomePage getLoginErrorMessage() {

		String errorMessage = loginErrorMessage.getText();
		System.out.println(errorMessage);
		return this;
	}

	public AddUserPage clickSignUp() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signUpButton));
		signUpButton.click();
		return new AddUserPage(driver);

	}

}
