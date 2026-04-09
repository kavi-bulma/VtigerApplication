package com.comcast.crm.objectRepo;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.baseClassUtilities.BaseClassUtilities;
import com.comcast.crm.fileUtilities.FileUtilities;

public class LoginPage  {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name = "user_name")
	WebElement user_name;
	@FindBy(name = "user_password")
	WebElement user_password;
	@FindBy(id = "submitButton")
	WebElement submitButton;
	
	public void login(String username,String password){
		user_name.sendKeys(username);
		user_password.sendKeys(password);
		submitButton.click();
	}

}
