package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class ContactDetailsPage extends ProjectSpecificationMethods {

	@FindBy(id = "edit-contact")
	WebElement editContactButton;

    @FindBy(id = "delete")
    WebElement deleteContactButton;
    
    @FindBy(id = "return")
    WebElement returnToContactListButton;

    @FindBy(id = "logout")
    WebElement logoutButton;
    
    @FindBy(id = "firstName")
	WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;
    
    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "phone")
    WebElement phoneField;
	
	public ContactDetailsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public EditContactPage clickEditConatctButton() {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(editContactButton));
		editContactButton.click();
		return new EditContactPage(driver);
	}
	
	public HomePage clickLogoutButton() {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(logoutButton));
		logoutButton.click();
		return new HomePage(driver);
	}
	
	public ContactListPage clickDeleteContactButton() {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(deleteContactButton));
		deleteContactButton.click();
		driver.switchTo().alert().accept();
		return new ContactListPage(driver);
	}
	

}
