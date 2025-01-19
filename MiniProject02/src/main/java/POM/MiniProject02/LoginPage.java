package POM.MiniProject02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy (id = "email")
	public WebElement emailField;

    @FindBy(id = "password")
    public static WebElement passwordField;

    @FindBy(id = "submit")
    public static WebElement loginSubmitButton;
    
    @FindBy(id = "error")
    public WebElement loginErrorMessage;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginSubmit() {
        loginSubmitButton.click();
    }

    public boolean isLoginSubmitButtonVisible() {
        return loginSubmitButton.isDisplayed();
    }
    
    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }
    
    public boolean isLoginErrorMessageVisible() {
        return loginErrorMessage.isDisplayed();
    }

}
