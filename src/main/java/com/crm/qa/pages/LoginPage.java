package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement username;	
	@FindBy(name="password")
	WebElement password;	
	@FindBy(xpath="//input[@value='Login']")	
	WebElement loginBtn;	
	@FindBy(xpath="//font[contains(text(),'Sign Up')]")
	WebElement signUpBtn;	
	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement featuresBtn;
	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	WebElement pricingBtn;
	@FindBy(xpath="//a[contains(text(),'Customers')]")
	WebElement customersBtn; 
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement contactBtn;
	@FindBy(xpath="//img[@alt='free crm logo']") 
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage validateLogin(String un, String pwd)  {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.submit();
		
		return new HomePage();
	}

}
