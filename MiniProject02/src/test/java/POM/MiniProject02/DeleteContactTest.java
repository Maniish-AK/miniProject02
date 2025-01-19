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

public class DeleteContactTest {
	
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
    public void testDeleteSingleContact() throws InterruptedException {
		ContactListPage clp = new ContactListPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(clp.noofContacts));
        int initialContactCount = clp.getNumberOfContacts();
        System.out.println(initialContactCount);
        wait.until(ExpectedConditions.visibilityOf(clp.addNewContactButton));
        wait.until(ExpectedConditions.visibilityOf(clp.firstContact));
        clp.selectFirstContact();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("contactDetails"), "Failed to redirect to contact details page!");
        ContactDetailsPage cdp = new ContactDetailsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(cdp.deleteContactButton));
        cdp.clickDeleteContact();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfAllElements(clp.noofContacts));
        Assert.assertEquals(clp.getNumberOfContacts(), initialContactCount - 1, "Contact deletion failed!");
    }
	
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
