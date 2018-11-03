package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Hugo Quezada')]")
	@CacheLookup
	WebElement userLbl;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactBtn;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Save' and @type='submit']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		util = new TestUtil();
	}
	
	public boolean validateUserLabelContatcsPage() {
		util.switchToFrame("mainpanel");
		return userLbl.isDisplayed();
	}
	
	public void clickOnNewContactLink() {
		util.switchToFrame("mainpanel");
		Actions a = new Actions(driver);
		a.moveToElement(contactsLink).build().perform();;
		newContactBtn.click();
	}
	
	public void createNewContact(String title, String first_name,String last_name, String company) {
		Select selTitle = new Select(driver.findElement(By.name("title")));
		selTitle.selectByVisibleText(title);
		firstName.sendKeys(first_name);
		lastName.sendKeys(last_name);
		this.company.sendKeys(company);
		saveBtn.click();
	}
	
}
