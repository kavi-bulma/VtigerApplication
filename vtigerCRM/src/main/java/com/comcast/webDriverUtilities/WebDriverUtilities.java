package com.comcast.webDriverUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.baseClassUtilities.BaseClassUtilities;

public class WebDriverUtilities extends BaseClassUtilities {

	
	Select sel;
	Actions act;
	WebDriverWait w;
	JavascriptExecutor js;

	

	// *****************************browser
	// management************************************
	public void getApplication(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void minimizeWindow() {
		driver.manage().window().minimize();
	}

	public void getFullWindow() {
		driver.manage().window().fullscreen();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void navigateToUrl(String url) {
		driver.navigate().to(url);
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	// *****************************handling
	// Waits**************************************
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	// *****************************explicit
	// waits*****************************************
	public void elementToBeClickable(WebElement element, int seconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		w.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void elementToBeSelected(WebElement element, int seconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		w.until(ExpectedConditions.elementToBeSelected(element));
	}

	public void frameToBeAvailableAndSwitchToIt(WebElement element, int seconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public void invisibilityOf(WebElement element, int seconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		w.until(ExpectedConditions.invisibilityOf(element));
	}

	public void alertIsPresent(WebElement element, int seconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		w.until(ExpectedConditions.alertIsPresent());
	}

	// ***************************AlertHAndling********************************
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public void getTextAlert() {
		driver.switchTo().alert().getText();
	}

	public void sendKeysToAlertTextbox(String keys) {
		driver.switchTo().alert().sendKeys(keys);
	}

	// ****************************FrameHandling*******************************
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);

	}

	public void switchToFrameIndex(int frame_index) {
		driver.switchTo().frame(frame_index);
	}

	public void switchToFrameName(String frame_name) {
		driver.switchTo().frame(frame_name);
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void switchTodefaultContent() {
		driver.switchTo().defaultContent();
	}

	// ***************************SwitchToWindow***********************************
	public void switchToWindow(String partialTitle) {
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);
			if (driver.getTitle().contains(partialTitle)) {
				break;
			}
		}
	}

	// ********************javaScriptExcecuter****************************
	public void scrollIntoView(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToElement(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.ScrollTo(0,document.body.scrollHeight");
	}

	public void scrollBy(int x, int y) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y);"); // scroll down and up
	}

	public void clickUsingJS(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/* Scroll page , Click using JS, Scroll to element */

	// ********************Select Dropdown*********************************
	public void selectDropdownByvisibleText(WebElement Locator, String visible_text) {
		sel = new Select(Locator);
		sel.selectByVisibleText(visible_text);
	}

	public void selectDropdownByIndex(WebElement Locator, int index) {
		sel = new Select(Locator);
		sel.selectByIndex(index);
	}

	public void selectDropdownByIndex(WebElement Locator, String value) {
		sel = new Select(Locator);
		sel.selectByValue(value);
	}

	public void deselectDropdownByIndex(WebElement Locator, int index) {
		sel = new Select(Locator);
		sel.deselectByIndex(index);
	}

	public void deselectDropdownByIndex(WebElement Locator, String value) {
		sel = new Select(Locator);
		sel.deselectByValue(value);
	}

	public void deselectAllDropdown(WebElement Locator) {
		sel = new Select(Locator);
		sel.deselectAll();
	}

	public void getAllSelectedOptions(WebElement Locator) {
		sel = new Select(Locator);
		List<WebElement> optns = sel.getAllSelectedOptions();
		for (WebElement optn : optns) {
			String optn_name = optn.getText();
			System.out.println(optn_name);
		}
	}

	public String getFirstSelectedOption(WebElement Locator) {
		sel = new Select(Locator);
		WebElement optn = sel.getFirstSelectedOption();
		String getFirstSelOptn = optn.getText();
		return getFirstSelOptn;
	}

	public void getOptions(WebElement Locator) {
		sel = new Select(Locator);
		List<WebElement> optns = sel.getOptions();
		for (WebElement optn : optns) {
			String optn_name = optn.getText();
			System.out.println(optn_name);
		}
	}

	// ******************************PerformActionsOnWebElement******************************
	public void mouseOver(WebElement ele) {
		act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

	public void doubleClick(WebElement element) {
		act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}

	public void contextClick(WebElement element) {
		act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public void clickAndHold(WebElement element) {
		act = new Actions(driver);
		act.clickAndHold(element).build().perform();
	}

	public void dragAndDrop(WebElement from, WebElement to) {
		act = new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
	}

	public void dragAndDrop(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void release(WebElement element) {
		act = new Actions(driver);
		act.release(element).build().perform();
	}

	public void sendKeysAction(WebElement element, String value) {
		act = new Actions(driver);
		act.sendKeys(element, value).perform();
	}

	// *****************************takeScreenShotOfWebPage*********************************
	public void takeScreenShotOfWebPage(String filename) throws IOException {
		TakesScreenshot scrn_shot = (TakesScreenshot) driver;
		File temp = scrn_shot.getScreenshotAs(OutputType.FILE);
		File permanent_Loc = new File(
				"C:\\Users\\mchet\\OneDrive\\Desktop\\vtigerapplication\\spicejet\\screenshots/" + filename + ".png");
		FileHandler.copy(temp, permanent_Loc);
	}

	// *****************************takeScreenShotOfWebElement*********************************
	public void takeScreenShotOfWebElement(WebElement element) throws IOException {
		String timestamp = LocalDateTime.now().toString().replace(":", "-");
		File temp = element.getScreenshotAs(OutputType.FILE);
		File permanent_Loc = new File(
				"C:\\Users\\mchet\\OneDrive\\Desktop\\vtigerapplication\\spicejet\\screenshots/" + timestamp + ".png");
		FileHandler.copy(temp, permanent_Loc);
	}

}
