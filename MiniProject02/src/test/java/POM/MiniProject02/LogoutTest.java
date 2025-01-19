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

public class LogoutTest {
	
	WebDriver driver;
	
	@BeforeTest
    public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		HomePage hp = new HomePage(driver);
        hp.openUrl("https://thinking-tester-contact-list.herokuapp.com/");
    }
	
	@Test (priority=1)
    public void testLogoutButtonVisible() {
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
    public void testLogoutRedirectsToLoginPage() {
		HomePage hp = new HomePage(driver);
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
        wait.until(ExpectedConditions.visibilityOf(hp.signUpButton));
        Assert.assertTrue(hp.isSignUpButtonVisible(), "User not redirected to login page after logout.");
    }
	
	@AfterTest
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }

}
