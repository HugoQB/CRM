package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Hugo Quezada')]")
	WebElement usernameLbl;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return  driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName() {
		util = new TestUtil();
		util.switchToFrame("mainpanel");
		return usernameLbl.isDisplayed();
	}
	
	public ContactsPage clickOnContactsPage() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public TasksPage clickOnTasksPage() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public DealsPage clickOnDealsPage() {
		dealsLink.click();
		return new DealsPage();
	}
}
