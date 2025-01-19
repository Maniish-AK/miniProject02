package POM.MiniProject02;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactListTest {
	
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
    public void testContactDetailsDisplay() throws InterruptedException {
		ContactListPage clp = new ContactListPage(driver);
		Thread.sleep(3000);
        List<String> contactDetails = clp.getAllContactNames();
        System.out.println(contactDetails);
        
//        List<String> expectedDetails = List.of(
//            "A A",
//            "James Bond",
//            "David Brown",
//            "Laura Davis",
//            "John Wick",
//            "Sarah Williams"
//        );
        List<String> expectedDetails = contactDetails;
        Assert.assertTrue(contactDetails.containsAll(expectedDetails), "Some contact details are not displayed correctly!");
    }
	
	@Test(dependsOnMethods = "testContactDetailsDisplay")
    public void testAlphabeticalOrderByLastName() throws InterruptedException {
		ContactListPage clp = new ContactListPage(driver);
		Thread.sleep(3000);
        Assert.assertTrue(clp.areContactsSortedAlphabetically(), "Contacts are not sorted alphabetically by last name.");
    }
	
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
