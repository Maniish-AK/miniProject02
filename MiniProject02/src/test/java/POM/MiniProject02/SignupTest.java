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

public class SignupTest {
	
	WebDriver driver;
	
	@BeforeTest
    public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		HomePage hp = new HomePage(driver);
        hp.openUrl("https://thinking-tester-contact-list.herokuapp.com/");
    }
	
	@Test (priority=1)
    public void testSignUpButtonVisibility() {
		HomePage hp = new HomePage(driver);
        Assert.assertTrue(hp.isSignUpButtonVisible(), "Sign Up button should be visible");
    }

    @Test (priority=2)
    public void testSignUpButtonClick() {
    	HomePage hp = new HomePage(driver);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(hp.signUpButton));
    	hp.clickSignUp();
        // Verify the page redirects to the Add User Page
        Assert.assertTrue(driver.getCurrentUrl().contains("/addUser"), "Page did not redirect to Add User Page");
    }
    
    @Test (priority=3)
    public void testSignUpFunctionality() throws InterruptedException {
        SignupPage sp = new SignupPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sp.firstNameField));
        sp.enterFirstName("testguvi");
        sp.enterLastName("user2");
        sp.enterEmail("testguviuser2@gmail.com");
        sp.enterPassword("guvi123");
        sp.clickSignupSubmit();
        ContactListPage clp = new ContactListPage(driver);
        wait.until(ExpectedConditions.visibilityOf(clp.addNewContactButton));
        Assert.assertTrue(clp.isAddNewContactButtonVisible(), "User not Signed Up successfully");
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
