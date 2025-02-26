package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC004_EditContact extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetName="EditInfo";
		
	}
	
	@Test(priority=1, dataProvider = "excelRead")
	public void editContact(String email, String password, String lastname, String editemail, String phone) {
		
		HomePage hp = new HomePage(driver);
		hp.enterEmail(email)
		.enterPassword(password)
		.clickLoginSubmit()
		.clickFirstContact()
		.clickEditConatctButton()
		.reEnterLastName(lastname)
		.reEnterEmail(editemail)
		.reEnterPhone(phone)
		.clickSubmit()
		.clickLogoutButton();
	}
	
	@Test(priority=2, dataProvider = "excelRead")
	public void editContactAndWitEmptyField(String email, String password) {
		
		HomePage hp = new HomePage(driver);
		hp.enterEmail(email)
		.enterPassword(password)
		.clickLoginSubmit()
		.clickFirstContact()
		.clickEditConatctButton()
		.clearEmail()
		.clickSubmit()
		.clickLogoutButton();
	}

}
