package POM.MiniProject02;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeTest
    public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		HomePage hp = new HomePage(driver);
        hp.openUrl("https://thinking-tester-contact-list.herokuapp.com/");
    }
	
	@Test (priority=1)
    public void testLoginFunctionalityWithValidCredentials() {
		LoginPage lp = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(lp.emailField));
        lp.enterEmail("maniishguvi@gmail.com");
        lp.enterPassword("Maniish@0212");
        lp.clickLoginSubmit();

        ContactListPage clp = new ContactListPage(driver);
        wait.until(ExpectedConditions.visibilityOf(clp.logoutButton));
        Assert.assertTrue(clp.isLogoutButtonVisible(), "User not logged in successfully.");
        clp.clickLogout();
    }
	
	@Test (priority=2)
    public void testLoginFunctionalityWithInvalidCredentials() {
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(lp.emailField));
        lp.enterEmail("maniishguviinvalid@gmail.com");
        lp.enterPassword("Maniishinvalid@0212");
        lp.clickLoginSubmit();
        wait.until(ExpectedConditions.visibilityOf(lp.loginErrorMessage));
        String errorMessage = lp.getLoginErrorMessage();
        if(errorMessage.contains("Incorrect username or password")) {
        	System.out.println("Invalid Credentials Used");
        }
        Assert.assertTrue(lp.isLoginErrorMessageVisible(), "User should use invalid credentials to Login.");
    }
	
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
