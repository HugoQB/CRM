package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.base.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage ;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {	
		String title = loginPage.getTitle();
		Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void loginPageValidateLogoTest() {
		Assert.assertTrue(loginPage.validateLogo());
	}
	
	@Test(priority=3)
	public void loginPageValidateLoginTest() {
		homePage = loginPage.validateLogin(prop.getProperty("username"),
				prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
