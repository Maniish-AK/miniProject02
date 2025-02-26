package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class ContactListPage extends ProjectSpecificationMethods {

	@FindBy(id = "add-contact")
	WebElement addNewContactButton;

	@FindBy(className = "contactTableBodyRow")
	List<WebElement> noofContacts;

	@FindBy(xpath = "(//tr[@class='contactTableBodyRow'])[1]")
	WebElement firstContact;

	@FindBy(id = "logout")
	WebElement logoutButton;

	public ContactListPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ContactListPage isAddNewContactButtonVisible() {

		addNewContactButton.isDisplayed();
		return this;
	}

	public HomePage clickLogout() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(firstContact));
		logoutButton.click();
		return new HomePage(driver);
	}
	
	public AddContactPage clickAddNewContactButton() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addNewContactButton));
		addNewContactButton.click();
		return new AddContactPage(driver);
	}
	
	public ContactListPage isContactGridVisible() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(firstContact));
		firstContact.isDisplayed();
		return this;
	}
	
	
	public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<>();
        for (WebElement row : noofContacts) {
            WebElement nameElement = row.findElement(By.xpath(".//td[2]"));
          //table[@id='myTable']//tr//td[2]
//            contactNames.add(nameElement.getText());
            contactNames.add(nameElement.getText().trim());
        }
        return contactNames;
    }
    
    public boolean areContactsSortedAlphabetically() {
        List<String> contactNames = getAllContactNames();
        List<String> sortedContactNames = new ArrayList<>(contactNames);
//        Collections.sort(sortedContactNames, String.CASE_INSENSITIVE_ORDER);
//        Collections.sort(sortedContactNames, (name1, name2) -> {
//            String lastName1 = name1.substring(name1.lastIndexOf(" ") + 1).toLowerCase();
//            String lastName2 = name2.substring(name2.lastIndexOf(" ") + 1).toLowerCase();
//            return lastName1.compareTo(lastName2);
//        });
        System.out.println("Original Contact Names: " + contactNames);
        System.out.println("Sorted Contact Names: " + sortedContactNames);
        return contactNames.equals(sortedContactNames);
    }
    
    public ContactDetailsPage clickFirstContact() {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(firstContact));
		firstContact.click();
		return new ContactDetailsPage(driver);
	}

}
