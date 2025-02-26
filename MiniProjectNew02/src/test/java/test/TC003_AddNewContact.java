package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC003_AddNewContact extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetName="LoginAndAdd";
		
	}
	
	@Test(priority=1, dataProvider = "excelRead")
	public void addNewContactWithMissingFields(String email, String password, String firstname, String lastname, String birthdate, String addemail, String phone, String streetadd1, String streetadd2, String city, String stateprovince, String postalcode, String country) {
		
		HomePage hp = new HomePage(driver);
		hp.enterEmail(email)
		.enterPassword(password)
		.clickLoginSubmit()
		.isAddNewContactButtonVisible()
		.clickAddNewContactButton()
		.enterFirstName(firstname)
		.enterLastName(lastname)
		.enterBirthdate(birthdate)
		.enterEmail(addemail)
//		.enterPhone()
//		.enterstreetAdd1()
//		.enterstreetAdd2()
		.enterCity(city)
		.enterStateProvince(stateprovince)
//		.enterPostalCode()
		.enterCountry(country)
		.clickSubmit()
		.isContactGridVisible();
	}
	
	@Test(priority=2, dataProvider = "excelRead")
	public void addNewContactWithAllFields(String email, String password, String firstname, String lastname, String birthdate, String addemail, String phone, String streetadd1, String streetadd2, String city, String stateprovince, String postalcode, String country) {
		
		HomePage hp = new HomePage(driver);
		hp.enterEmail(email)
		.enterPassword(password)
		.clickLoginSubmit()
		.isAddNewContactButtonVisible()
		.clickAddNewContactButton()
		.enterFirstName(firstname)
		.enterLastName(lastname)
		.enterBirthdate(birthdate)
		.enterEmail(addemail)
		.enterPhone(phone)
		.enterstreetAdd1(streetadd1)
		.enterstreetAdd2(streetadd2)
		.enterCity(city)
		.enterStateProvince(stateprovince)
		.enterPostalCode(postalcode)
		.enterCountry(country)
		.clickSubmit()
		.isContactGridVisible();
	}
	
	@Test(priority=3, dataProvider = "excelRead")
	public void addNewContactWithDuplicateValues(String email, String password, String firstname, String lastname, String birthdate, String addemail, String phone, String streetadd1, String streetadd2, String city, String stateprovince, String postalcode, String country) {
		
		HomePage hp = new HomePage(driver);
		hp.enterEmail(email)
		.enterPassword(password)
		.clickLoginSubmit()
		.isAddNewContactButtonVisible()
		.clickAddNewContactButton()
		.enterFirstName(firstname)
		.enterLastName(lastname)
		.enterBirthdate(birthdate)
		.enterEmail(addemail)
		.enterPhone(phone)
		.enterstreetAdd1(streetadd1)
		.enterstreetAdd2(streetadd2)
		.enterCity(city)
		.enterStateProvince(stateprovince)
		.enterPostalCode(postalcode)
		.enterCountry(country)
		.clickSubmit()
		.isContactGridVisible();
	}
	
	@Test(priority=4, dataProvider = "excelRead")
	public void addNewContactWithInvalidDateFormat(String email, String password, String firstname, String lastname, String birthdate, String addemail, String phone, String streetadd1, String streetadd2, String city, String stateprovince, String postalcode, String country) {
		
		HomePage hp = new HomePage(driver);
		hp.enterEmail(email)
		.enterPassword(password)
		.clickLoginSubmit()
		.isAddNewContactButtonVisible()
		.clickAddNewContactButton()
		.enterFirstName(firstname)
		.enterLastName(lastname)
		.enterInvalidBirthdate()
		.enterEmail(addemail)
		.enterPhone(phone)
		.enterstreetAdd1(streetadd1)
		.enterstreetAdd2(streetadd2)
		.enterCity(city)
		.enterStateProvince(stateprovince)
		.enterPostalCode(postalcode)
		.enterCountry(country)
		.clickSubmitForInvalid()
		.validateErrorMesaageForBirthdate();
		
	}

}
