package POM.MiniProject02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy (id = "signup")
	public WebElement signUpButton;
	
	@FindBy (id = "submit")
	public static WebElement submitButton;
	

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignUp() {
        signUpButton.click();
    }

    public void clickLogin() {
    	submitButton.click();
    }

    public boolean isSignUpButtonVisible() {
        return signUpButton.isDisplayed();
    }

    public boolean isLoginButtonVisible() {
        return submitButton.isDisplayed();
    }
    
    public WebDriver getDriver() {
		return this.driver;
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}

}
