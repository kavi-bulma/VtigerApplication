package createContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseClassUtilities.BaseClassUtilities;
import com.comcast.crm.fileUtilities.FileUtilities;
import com.comcast.crm.javaUtilities.JavaUtilities;
import com.comcast.crm.objectRepo.contactModule.*;
import com.comcast.webDriverUtilities.WebDriverUtilities;
import com.comcast.crm.objectRepo.HomePage;

@Listeners(com.comcast.crm.listenerUtility.ListenerUtilityImplementationClass.class)
public class CreateContactTest extends BaseClassUtilities {

	SoftAssert sa = new SoftAssert();
	JavaUtilities jutil = new JavaUtilities();
	FileUtilities fileUtil = new FileUtilities();
	WebDriverUtilities webUtil = new WebDriverUtilities();

	@Test
	public void createContactWithOrg() throws EncryptedDocumentException, IOException {

		/** Place the cursor and click on "Contact" Link **/
		HomePage hp = new HomePage(driver);
		hp.contactPage_link.click();

		// Navigate to create new -Contact page by click on "+" image
		ContactPage cp = new ContactPage(driver);
		cp.createcontact_button.click();

		/** Create Contacct with mandatory fields **/
		CreateNewContactPage crtNewContactP = new CreateNewContactPage(driver);
		String fnameTitle = fileUtil.accessDataFromExcel("contactInfo", 1, 0);
		String fname = fileUtil.accessDataFromExcel("contactInfo", 1, 1) + "_" + jutil.getRandomNumber(100);
		String lname = fileUtil.accessDataFromExcel("contactInfo", 1, 1);
		webUtil.selectDropdownByvisibleText(crtNewContactP.fName_title, fnameTitle);
		crtNewContactP.fName.sendKeys(fname);
		crtNewContactP.lName.sendKeys(lname);
		crtNewContactP.save_button.click();

		/** Verify the ContactInformation **/
		ContactInformationPage contactInfoP = new ContactInformationPage(driver);
		String contactInfor = contactInfoP.contact_information.getText();
		boolean res = contactInfor.contains(fname);
		sa.assertEquals(res, true);
		System.out.println("create contact is done");
	}

	@Test
	public void createContact() throws EncryptedDocumentException, IOException, InterruptedException {

		/** Place the cursor and click on "Contact" Link **/
		HomePage hp = new HomePage(driver);
		hp.contactPage_link.click();

		// Navigate to create new -Contact page by click on "+" image
		ContactPage cp = new ContactPage(driver);
		cp.createcontact_button.click();

		/** Create Contacct with mandatory fields **/
		CreateNewContactPage crtNewContactP = new CreateNewContactPage(driver);
		String fnameTitle = fileUtil.accessDataFromExcel("contactInfo", 1, 0);
		String fname = fileUtil.accessDataFromExcel("contactInfo", 1, 1) + "_" + jutil.getRandomNumber(100);
		String lname = fileUtil.accessDataFromExcel("contactInfo", 1, 2);
		webUtil.selectDropdownByvisibleText(crtNewContactP.fName_title, fnameTitle);
		crtNewContactP.fName.sendKeys(fname);
		crtNewContactP.lName.sendKeys(lname);
		crtNewContactP.createcontactWithSupportdate();
		crtNewContactP.save_button.click();

		// select support start and end date

		/** Verify the ContactInformation **/
		ContactInformationPage contactInfoP = new ContactInformationPage(driver);
		String contactInfor = contactInfoP.contact_information.getText();
		boolean res = contactInfor.contains(fname);
		sa.assertEquals(res, true);
	}

}
