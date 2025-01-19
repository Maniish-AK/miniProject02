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

public class AddContactTest {
	
	WebDriver driver;
	
	@BeforeTest
    public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		HomePage hp = new HomePage(driver);
        hp.openUrl("https://thinking-tester-contact-list.herokuapp.com/");
        LoginPage lp = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(lp.emailField));
        lp.enterEmail("maniishguvi@gmail.com");
        lp.enterPassword("Maniish@0212");
        lp.clickLoginSubmit();
    }
	
	@Test (priority=1)
    public void testAddContactWithAllFields() throws InterruptedException {
		ContactListPage clp = new ContactListPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(clp.addNewContactButton));
		clp.clickAddContact();
		AddContactPage acp = new AddContactPage(driver);
		wait.until(ExpectedConditions.visibilityOf(acp.firstNameField));
        acp.enterContactDetails("David", "Brown", "1996-07-25", "davidbrown@gmail.com", "0987612345", "654", "Cedar Drive", "Austin", "Texas", "73301", "United States");
        wait.until(ExpectedConditions.visibilityOf(acp.submitButton));
        acp.clickSubmit();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("contactList"), "Contact addition failed!");
    }
	
	@Test (priority=2)
    public void testAddContactWithMissingFields() throws InterruptedException {
		ContactListPage clp = new ContactListPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(clp.addNewContactButton));
		clp.clickAddContact();
		AddContactPage acp = new AddContactPage(driver);
		wait.until(ExpectedConditions.visibilityOf(acp.firstNameField));
        acp.enterContactDetails("Michael", "Johnson", "1996-07-25", "davidbrown@gmail.com", "", "", "", "Austin", "Texas", "", "United States");
        wait.until(ExpectedConditions.visibilityOf(acp.submitButton));
        acp.clickSubmit();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("contactList"), "Contact addition failed!");
    }
	
	@Test (priority=3)
    public void testAddContactWithDuplicateDetails() throws InterruptedException {
		ContactListPage clp = new ContactListPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(clp.addNewContactButton));
		clp.clickAddContact();
		AddContactPage acp = new AddContactPage(driver);
		wait.until(ExpectedConditions.visibilityOf(acp.firstNameField));
        acp.enterContactDetails("David", "Brown", "1996-07-25", "davidbrown@gmail.com", "0987612345", "654", "Cedar Drive", "Austin", "Texas", "73301", "United States");
        wait.until(ExpectedConditions.visibilityOf(acp.submitButton));
        acp.clickSubmit();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("contactList"), "Contact addition failed!");
    }
	
	@Test (priority=4)
    public void testAddContactWithInvalidDateFormat() {
		ContactListPage clp = new ContactListPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(clp.addNewContactButton));
		clp.clickAddContact();
		AddContactPage acp = new AddContactPage(driver);
		wait.until(ExpectedConditions.visibilityOf(acp.firstNameField));
        acp.enterContactDetails("David", "Brown", "30-11-1996", "davidbrown@gmail.com", "0987612345", "654", "Cedar Drive", "Austin", "Texas", "73301", "United States");
        wait.until(ExpectedConditions.visibilityOf(acp.submitButton));
        acp.clickSubmit();
        wait.until(ExpectedConditions.visibilityOf(acp.errorMessage));
        acp.isErrorMessageDisplayed();
        String errorMessage = acp.errorMessage.getText();
        Assert.assertTrue(errorMessage.contains("Birthdate is invalid"), "Valid Birthdate passed!");
    }
	
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
