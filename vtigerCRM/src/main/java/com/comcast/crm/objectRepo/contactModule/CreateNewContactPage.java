package com.comcast.crm.objectRepo.contactModule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='salutationtype']")
	public WebElement fName_title;

	@FindBy(name = "firstname")
	public WebElement fName;

	@FindBy(name = "lastname")
	public WebElement lName;

	@FindBy(xpath = "//input[@name='button' and @value='  Save  ']")
	public WebElement save_button;

	@FindBy(name = "support_start_date")
	public WebElement support_start_date;
	
	@FindBy(name = "support_end_date")
	public WebElement support_end_date;
	
	public void createcontactWithSupportdate() {
		
		Date dateObj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actualdate = sim.format(dateObj);
		System.out.println("actual Date : " +actualdate);
		
		Calendar cal = Calendar.getInstance();
	    cal.setTime(dateObj);
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String dateRequirs=sim.format(cal.getTime());
		System.out.println("Required Date : " +dateRequirs);
		
		
		
		
		support_start_date.clear();
		support_start_date.sendKeys(actualdate);
		support_end_date.clear();
		support_end_date.sendKeys(dateRequirs);
	}

}
