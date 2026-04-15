package com.comcast.crm.objectRepo.contactModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, ContactPage.this );
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
	public WebElement createcontact_button;
	
	//select[@name='salutationtype']
	
}
