package POM.MiniProject02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactListPage {
	
	WebDriver driver;
	
	@FindBy(id = "add-contact")
	public WebElement addNewContactButton;

    @FindBy(className = "contactTableBodyRow")
    public List<WebElement> noofContacts;
    
    @FindBy(xpath = "(//tr[@class='contactTableBodyRow'])[1]")
    public WebElement firstContact;

    @FindBy(id = "logout")
    public WebElement logoutButton;
    
    public ContactListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickAddContact() {
    	addNewContactButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }
    
    public void selectFirstContact() {
    	firstContact.click();
    }
    
    public int getNumberOfContacts() {
        return noofContacts.size();
    }
    
    public boolean isAddNewContactButtonVisible() {
        return addNewContactButton.isDisplayed();
    }
    
    public boolean isLogoutButtonVisible() {
        return logoutButton.isDisplayed();
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

}
