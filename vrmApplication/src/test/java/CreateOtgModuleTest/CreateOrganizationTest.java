package CreateOtgModuleTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.comcast.crm.baseClassUtilities.BaseClassUtilities;
import com.comcast.crm.fileUtilities.FileUtilities;
import com.comcast.crm.javaUtilities.JavaUtilities;
import com.comcast.crm.objectRepo.HomePage;
import com.comcast.crm.objectRepo.organizationModule.*;
import com.comcast.webDriverUtilities.WebDriverUtilities;

public class CreateOrganizationTest extends BaseClassUtilities {
	SoftAssert sa = new SoftAssert();
	JavaUtilities jutil = new JavaUtilities();
	FileUtilities fileUtil = new FileUtilities();
	WebDriverUtilities webUtil = new WebDriverUtilities();

	@Test
	void createOrg() throws EncryptedDocumentException, IOException, InterruptedException {

		// Create object for homepage and then click on orgLink
		HomePage hp = new HomePage(driver);
		hp.orgPage_link.click();

		// Create obj for Organization page and click on + icon to create new org
		OrganizationPage orgP = new OrganizationPage(driver);
		orgP.createOrg_button.click();

		// Create fileutil obj to generate random_no & attach it with
		// orgname(tekPyramid_12)
		FileUtilities fileUtil = new FileUtilities();
		String orgName = fileUtil.accessDataFromExcel("orgInfo", 1, 1) + "_" + jutil.getRandomNumber(100);

		// Create obj for crtneworgpage and type org name
		CreatingNewOrganizationPage crtOrgP = new CreatingNewOrganizationPage(driver);
		crtOrgP.org_name.sendKeys(orgName);

		// click on save button
		crtOrgP.save_button.click();

		// Create obj for infopage and verify orginfo displayed or not
		OrganizationInformationPage infoPage = new OrganizationInformationPage(driver);
		System.out.println(infoPage.org_information.getText());
		boolean res = infoPage.org_information.getText().contains(orgName);
		sa.assertEquals(res, true);
		Thread.sleep(2000);
		System.out.println("test case--1 completed");
	}

	@Test
	void createOrgWithPhone() throws EncryptedDocumentException, IOException, InterruptedException {

		// Create object for homepage and then click on orgLink
		HomePage hp = new HomePage(driver);
		hp.orgPage_link.click();

		// Create obj for Organization page and click on + icon to create new org
		OrganizationPage orgP = new OrganizationPage(driver);
		orgP.createOrg_button.click();

		// Create fileutil obj to generate random_no & attach it with
		// orgname(tekPyramid_12)
		FileUtilities fileUtil = new FileUtilities();
		String orgName = fileUtil.accessDataFromExcel("orgInfo", 1, 0) + "_" + jutil.getRandomNumber(100);
		String phone_num = fileUtil.accessDataFromExcel("orgInfo", 1, 1);

		// Create obj for crtneworgpage and type org name and phone number
		CreatingNewOrganizationPage crtOrgP = new CreatingNewOrganizationPage(driver);
		crtOrgP.org_name.sendKeys(orgName);
		crtOrgP.phone_num.sendKeys(phone_num);
		crtOrgP.save_button.click();

		// Create obj for infopage and verify orginfo displayed or not
		OrganizationInformationPage infoPage = new OrganizationInformationPage(driver);
		boolean res = infoPage.org_information.getText().contains(orgName);
		sa.assertEquals(res, true);
		Thread.sleep(2000);
		System.out.println("test case--2 completed");
	}

	@Test
	void createOrgWithIndustryandType() throws EncryptedDocumentException, IOException, InterruptedException {

		// Create object for homepage and then click on orgLink
		HomePage hp = new HomePage(driver);
		hp.orgPage_link.click();

		// Create obj for Organization page and click on + icon to create new org
		OrganizationPage orgP = new OrganizationPage(driver);
		orgP.createOrg_button.click();

		// Create fileutil obj to generate random_no & attach it with
		// orgname(tekPyramid_12)
		String orgName = fileUtil.accessDataFromExcel("orgInfo", 1, 0) + "__" + jutil.getRandomNumber(100);
		String phone_num = fileUtil.accessDataFromExcel("orgInfo", 1, 1);
		String industry_value = fileUtil.accessDataFromExcel("orgInfo", 1, 2);
		String type_value = fileUtil.accessDataFromExcel("orgInfo", 1, 3);
		System.out.println(industry_value);
		System.out.println(type_value);
		System.out.println(orgName);
		System.out.println(phone_num);

		// Create obj for crtneworgpage and type org name
		CreatingNewOrganizationPage crtOrgP = new CreatingNewOrganizationPage(driver);
		crtOrgP.org_name.sendKeys(orgName);
		crtOrgP.phone_num.sendKeys(phone_num);
		webUtil.selectDropdownByvisibleText(crtOrgP.select_industry_drop, industry_value);
		webUtil.selectDropdownByvisibleText(crtOrgP.account_type, type_value);

		crtOrgP.save_button.click();

		// Create obj for infopage and verify orginfo displayed or not
		OrganizationInformationPage infoPage = new OrganizationInformationPage(driver);
		System.out.println(infoPage.org_information.getText());
		boolean res = infoPage.org_information.getText().contains(orgName);
		sa.assertEquals(res, true);
		Thread.sleep(2000);
		System.out.println("test case--3 completed");
	}

}
