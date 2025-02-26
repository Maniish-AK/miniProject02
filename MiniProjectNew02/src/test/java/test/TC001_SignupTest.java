package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC001_SignupTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetName="Signup";
		
	}
	
	@Test(dataProvider = "excelRead")
	public void signupTest(String firstName, String lastName, String email, String password) {
		
		HomePage hp = new HomePage(driver);
		hp.clickSignUp()
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterEmail(email)
		.enterPassword(password)
		.clickSignupSubmit()
		.isAddNewContactButtonVisible()
		.clickLogout();
	}

}
