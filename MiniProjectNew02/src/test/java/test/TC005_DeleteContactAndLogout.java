package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC005_DeleteContactAndLogout extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetName="LoginAndAdd";
		
	}
	
	@Test(dataProvider = "excelRead")
	public void deleteContact(String email, String password) {
		
		HomePage hp = new HomePage(driver);
		hp.enterEmail(email)
		.enterPassword(password)
		.clickLoginSubmit()
		.clickFirstContact()
		.clickDeleteContactButton()
		.clickLogout();
	}

}
