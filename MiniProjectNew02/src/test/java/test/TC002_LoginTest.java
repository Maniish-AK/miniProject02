package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC002_LoginTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetName="LoginAndAdd";
		
	}
	
	@Test(dataProvider = "excelRead")
	public void loginTest(String email, String password) {
		
		HomePage hp = new HomePage(driver);
		hp.enterInvalidEmail()
		.enterPassword(password)
		.clickLoginSubmitForInvalid()
		.getLoginErrorMessage()
		.enterEmail(email)
		.enterPassword(password)
		.clickLoginSubmit()
		.isAddNewContactButtonVisible();
	}

}
