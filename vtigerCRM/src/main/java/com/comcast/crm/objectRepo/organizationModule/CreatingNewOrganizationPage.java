package com.comcast.crm.objectRepo.organizationModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name = "accountname")
	public WebElement org_name;
	@FindBy(name = "phone")
	public WebElement phone_num;
	@FindBy(name = "industry")
	public WebElement select_industry_drop;
	@FindBy(name = "accounttype")
	public WebElement account_type;
	
	@FindBy(xpath = "//input[@name='button' and @value='  Save  ']")
	public WebElement save_button;
	
	
}
