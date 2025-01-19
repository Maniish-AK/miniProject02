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

public class EditContactTest {
	
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
	
	@Test
    public void testRedirectToContactDetailsPage() throws InterruptedException {
		ContactListPage clp = new ContactListPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(clp.addNewContactButton));
        wait.until(ExpectedConditions.visibilityOf(clp.firstContact));
        clp.selectFirstContact();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("contactDetails"), "Failed to redirect to contact details page!");
        ContactDetailsPage cdp = new ContactDetailsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(cdp.editContactButton));
        cdp.clickEditContact();
    }
	
	@Test(dependsOnMethods = "testRedirectToContactDetailsPage")
    public void testEditContactDetails() throws InterruptedException {
		ContactDetailsPage cdp = new ContactDetailsPage(driver);
		EditContactPage ecp = new EditContactPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ecp.firstNameField));
        Thread.sleep(3000);
        ecp.clearLastName();
        ecp.clearEmail();
        ecp.clearPhone();
        Thread.sleep(3000);
		ecp.editLastName("Aupdated");
		ecp.editEmail("jamesupdated@gmail.com");
		ecp.editPhone("1111111111");
        ecp.clickSubmit();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(cdp.firstNameField));
        Thread.sleep(3000);
        Assert.assertEquals(cdp.getLastName(), "Aupdated", "Name not updated correctly!");
        Assert.assertEquals(cdp.getEmail(), "jamesupdated@gmail.com", "Email not updated correctly!");
        Assert.assertEquals(cdp.getPhone(), "1111111111", "Phone number not updated correctly!");
    }
	
	@Test(dependsOnMethods = "testEditContactDetails")
    public void testFieldChangesAreIndependent() throws InterruptedException {
		ContactDetailsPage cdp = new ContactDetailsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cdp.editContactButton));
        cdp.clickEditContact();
		EditContactPage ecp = new EditContactPage(driver);
        wait.until(ExpectedConditions.visibilityOf(ecp.firstNameField));
        Thread.sleep(3000);
        ecp.clearLastName();
        ecp.clearEmail();
        Thread.sleep(3000);
		ecp.editLastName("Bond");
		ecp.editEmail("jamesbond@gmail.com");
        ecp.clickSubmit();
        wait.until(ExpectedConditions.visibilityOf(cdp.firstNameField));
        Thread.sleep(3000);
        Assert.assertEquals(cdp.getLastName(), "Bond", "Name not updated correctly!");
        Thread.sleep(3000);
        Assert.assertEquals(cdp.getEmail(), "jamesbond@gmail.com", "Email not updated correctly!");
        Thread.sleep(3000);
        Assert.assertEquals(cdp.getPhone(), "1111111111", "Phone number not updated correctly!");
    }
	
	@Test(dependsOnMethods = "testFieldChangesAreIndependent")
    public void testSaveEmptyFields() throws InterruptedException {
		ContactDetailsPage cdp = new ContactDetailsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cdp.editContactButton));
        cdp.clickEditContact();
		EditContactPage ecp = new EditContactPage(driver);
        wait.until(ExpectedConditions.visibilityOf(ecp.firstNameField));
        Thread.sleep(3000);
        ecp.clearEmail();
        ecp.clickSubmit();
        wait.until(ExpectedConditions.visibilityOf(cdp.firstNameField));
        Thread.sleep(3000);
        Assert.assertEquals(cdp.getEmail(), "", "Empty name should be allowed!");
    }
	
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
