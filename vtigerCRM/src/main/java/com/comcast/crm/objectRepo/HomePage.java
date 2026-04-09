package com.comcast.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, HomePage.this);
	}
	
	@FindBy(xpath = "//a[text()='Calendar']")
	public WebElement calendar_link;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']//a[text()='Organizations']")
	public WebElement orgPage_link;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']//a[text()='Contacts']")
	public WebElement contactPage_link;
	
	@FindBy(xpath = "//a[text()='Products']")
	public WebElement prodPage_link;
	
	@FindBy(xpath = "//td[@class='small' and @valign='bottom'][1]")
	public WebElement signOutImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	public WebElement signOut;
	
	@FindBy(xpath = "//a[text()='Products']")
	public WebElement logout;
	
	public void signout() throws InterruptedException{
		Actions action=new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(signOutImg).perform();
		Thread.sleep(2000);
	   signOut.click();
	}
	
	

}
