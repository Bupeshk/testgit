package com.verizon.cao.selenium.admin.test;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.verizon.cao.selenium.admin.pages.AddMetaDataPage;
import com.verizon.cao.selenium.admin.pages.AddProfileSettingsPage;
import com.verizon.cao.selenium.admin.pages.AddRolesPage;
import com.verizon.cao.selenium.admin.pages.AdminCommonPages;
import com.verizon.cao.selenium.admin.pages.AdminHomePage;
import com.verizon.cao.selenium.admin.pages.EditBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageGlobalReviewersPage;
import com.verizon.cao.selenium.admin.pages.ManageMetaDataPage;
import com.verizon.cao.selenium.admin.pages.ManageProfileSettingsPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_202 extends SetupBase implements Admin,Common {

	private String  baseurl ;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_202.html", true,DisplayOrder.OLDEST_FIRST);
	private static WebElement element;
	private static ExtentTest test; 
	CommonFunctions commonFunctions;
	public EW_202() throws Exception {
		super();
	}

	@Test
	public void ManageGlobalReviewers() throws Exception
	{
		test = ext_report.startTest("ManageProfileSettingsTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		
		CommonFunctions.writeConsole(driver.getTitle());
		AdminHomePage.Left_NavLinks(driver, "Manage Profile Settings").click();
		boolean b = CommonFunctions.existsElement(driver, btnAddNewProfileSettings, ext_report, test);
		if(b == false)
		{
			driver.navigate().refresh();
			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage Profile Settings").click();	
			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnAddNewProfileSettings,"btnAddNewProfileSettings", driver, ext_report, test);
		Thread.sleep(10000);
		CommonFunctions.getTableHeaders("ProfileSettings",driver, ext_report, test);
		ManageProfileSettingsPage.btnAddNewProfileSettings(driver).click();
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, txtProfileSettingsName,"Profile settings name", driver, ext_report, test);
		AddProfileSettingsData();
		CommonFunctions.alertAccept(driver);
		CommonFunctions.scrollingByCoordinatesofAPage(driver,0,600);
		ManageProfileSettingsPageVerification();
				
		
		
	}

	private static void AddProfileSettingsData() throws Exception
	{
		
		element = AddProfileSettingsPage.txtProfileSettingsName(driver);
		CommonFunctions.SendKeysWithoutClear(driver, element, "new Profile settings", ext_report, test);
		element = AddProfileSettingsPage.txtProfileSettingsDisplayName(driver);
		CommonFunctions.SendKeysWithoutClear(driver, element, "new Profile settings", ext_report, test);
		element = AddProfileSettingsPage.txtValue(driver);
		CommonFunctions.SendKeysWithoutClear(driver, element, "5", ext_report, test);
		element = AddProfileSettingsPage.btnAddProfileSetting(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Clicking on Profile Settings Page", ext_report, test);
	}
	
	private static void ManageProfileSettingsPageVerification() throws Exception
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='ddcl-glosscat']")).click();
		element = ManageProfileSettingsPage.lnkContentType_ProfileSettings(driver, "Alerts");
		CommonFunctions.clickElementWebDriver(driver, element, "Clicking on Alerts", ext_report, test);
		String objPath = chkWorkFlow_starts+"EDITOR(All)'and @disabled]";
		System.out.println("Onject path"  +objPath);
		element = driver.findElement(By.xpath(objPath));
		CommonFunctions.VerifyElementPresent(driver, element, "element verification", ext_report, test);
		//CommonFunctions.WaitForElementNotVisible(driver, objPath);
		ManageProfileSettingsPage.btnWorkFlowEdit(driver).click();
		element = ManageProfileSettingsPage.chkContentWorkFlow(driver, "EDITOR(All)");
		CommonFunctions.VerifyElementPresent(driver, element, "EDITOR(All)", ext_report, test);
		CommonFunctions.scrollingToBottomOfPage(driver);
		element = ManageProfileSettingsPage.chkSecondaryAuthors(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Secondary authors check box is clickable", ext_report, test);
		CommonFunctions.SelDropDown(lstUserGroups, "stake dev", driver);
		element = ManageProfileSettingsPage.btnUserGroups_Add(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Add user groups", ext_report, test);
		element = ManageProfileSettingsPage.lstSelUserGroups(driver);
		CommonFunctions.existsElement(driver, lstSelUserGroups+"//option[text() = '"+"stake dev"+"']", ext_report, test);
		
	}

	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("EW_202");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_202");
		ext_report.config().reportHeadline("-EW_202"); 
		baseurl = super.getTestBaseUrl();
		driver.manage().deleteAllCookies();
		System.out.println("inside before class"  +baseurl);

	}
	
	@AfterMethod
	public void LogOut() 
	{
		ext_report.endTest(test);
		ext_report.flush(); 	
		commonFunctions.VzLogout(driver);
	}
}