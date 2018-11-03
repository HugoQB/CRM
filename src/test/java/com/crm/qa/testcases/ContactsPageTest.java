package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
//	String dataPath = " C:\\Users\\git\\Selenium\\CRM\\src\\main\\java\\com\\crm\\qa\\data\\practicaSeleniumData.xlsx";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		util = new TestUtil();
		homePage = loginPage.validateLogin(prop.getProperty("username"),
				prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateContacstPageMessage() {
		
		Assert.assertTrue(contactsPage.validateUserLabelContatcsPage(), "message is not apearing");
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = util.getTestData(prop.getProperty("sheetName"), prop.getProperty("dataPath"));
		return data;
	}
	
	@Test(priority=2, dataProvider="getTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company) {
		contactsPage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
