package POM.MiniProject02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage {
	
	WebDriver driver;
	
	@FindBy(id = "edit-contact")
	public WebElement editContactButton;

    @FindBy(id = "delete")
    public WebElement deleteContactButton;
    
    @FindBy(id = "return")
    public static WebElement returnToContactListButton;

    @FindBy(id = "logout")
    public static WebElement logoutButton;
    
    @FindBy(id = "firstName")
	public WebElement firstNameField;

    @FindBy(id = "lastName")
    public static WebElement lastNameField;
    
    @FindBy(id = "email")
    public static WebElement emailField;

    @FindBy(id = "phone")
    public static WebElement phoneField;
    
    public ContactDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickEditContact() {
    	editContactButton.click();
    }
    
    public void clickDeleteContact() {
    	deleteContactButton.click();
    }
    
    public void clickReturnToContactList() {
    	returnToContactListButton.click();
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
    
    public boolean isFirstNameFieldVisible() {
        return firstNameField.isDisplayed();
    }

}
