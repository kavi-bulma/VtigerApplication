package com.comcast.crm.baseClassUtilities;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.comcast.crm.fileUtilities.FileUtilities;
import com.comcast.crm.objectRepo.HomePage;
import com.comcast.crm.objectRepo.LoginPage;
import com.comcast.webDriverUtilities.WebDriverUtilities;

public class BaseClassUtilities {

	FileUtilities fileUtil = new FileUtilities();
	
	public WebDriver driver=null;
	public static WebDriver sdriver;
	String browser;
	String url;
	String username;
	String password;
	

	@BeforeClass
	public void launchBrowser() throws IOException {
		browser = fileUtil.accessDatafromProperty("browser");
		System.out.println("beforeClass");
		 if (browser.equalsIgnoreCase("chrome")) {
	            driver = new ChromeDriver();
	        } 
	        else if (browser.equalsIgnoreCase("edge")) {
	            driver = new EdgeDriver();
	        } 
	        else if (browser.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();
	        } 
	        else if (browser.equalsIgnoreCase("safari")) {
	            driver = new SafariDriver();
	        }
		sdriver=driver;
		
	}

	@BeforeMethod
	public void loginToApplication() throws IOException {
		driver.get(fileUtil.accessDatafromProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage lp = new LoginPage(driver);
		
		username = fileUtil.accessDatafromProperty("username");
		password = fileUtil.accessDatafromProperty("password");
		lp.login(username, password);
		System.out.println("logged in successfully");
	}
	
	@AfterMethod
	public void logoutFromApplication() throws IOException, InterruptedException {
    HomePage hp=new HomePage(driver);
    hp.signout();
    
}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
