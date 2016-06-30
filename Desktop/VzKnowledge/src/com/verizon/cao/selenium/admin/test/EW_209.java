package com.verizon.cao.selenium.admin.test;


import java.awt.AWTException;
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
import com.verizon.cao.selenium.admin.pages.AdminCommonPages;
import com.verizon.cao.selenium.admin.pages.AdminHomePage;
import com.verizon.cao.selenium.admin.pages.EditBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageGlobalReviewersPage;
import com.verizon.cao.selenium.admin.pages.ManageMetaDataPage;
import com.verizon.cao.selenium.admin.pages.ManageUsersPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_209 extends SetupBase implements Admin,Common {

	private String  baseurl ;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_209.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test;
	private WebElement element; 
	CommonFunctions commonFunctions;
	public EW_209() throws Exception {
		super();
	}

	@Test
	public void ManageGlobalReviewers() throws Exception
	{
		test = ext_report.startTest("EW_209");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		String objectPath= lnkLeftNav_starts+"Manage Users"+lnkLeftNav_ends;
		System.out.println("objectPath"  + objectPath);
		Thread.sleep(5000);

		AdminHomePage.Left_NavLinks(driver, "Manage Users").click();
		boolean b = CommonFunctions.verifyElementPresentWebdriver(attributeName_xpath, lstBusinessGroups, lstBusinessGroups, driver);
		if(b == false)
		{

			driver.navigate().refresh();

			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage Users").click();	

			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnAddUsers,"btnAddUsers", driver, ext_report, test);
		Thread.sleep(10000);
		CommonFunctions.getTableHeaders("ManageUsers",driver, ext_report, test);
		VerifyManageUserPageElements();
		CommonFunctions.getTableData(driver, tableUsers, ext_report, test);
		FindUsers();
		//add user functionality
		AddUsers();
		//Export Users to Excel File
		ExportUsersToExcel();
		//Download Template
		DownloadTemplate();
	
	}
	
	private void VerifyManageUserPageElements()
	{
		element = ManageUsersPage.AddUsers_btn(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Add User", ext_report, test);
		element = ManageUsersPage.ExportUsers_btn(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Export Users to Excel", ext_report, test);
		element = ManageUsersPage.SearchUser_txt(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Search Users Textbox", ext_report, test);
		element = ManageUsersPage.Find_btn(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Find Users", ext_report, test);
		element = ManageUsersPage.btnDownloadTemplate(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Download Template", ext_report, test);
		element = ManageUsersPage.btnBrowseFile(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Browse", ext_report, test);
		element = ManageUsersPage.btnUpload(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Upload", ext_report, test);
		element = ManageUsersPage.btnBrowseFile(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Browse", ext_report, test);
		element = ManageUsersPage.lstSystemRole(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "System Role", ext_report, test);
		element = ManageUsersPage.lstCustomRole(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Custom Role", ext_report, test);
		element = ManageUsersPage.btnFindUser(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Find Role", ext_report, test);
		
	}
	
	private void FindUsers()
	{
		element = ManageUsersPage.SearchUser_txt(driver);
		CommonFunctions.SendKeysWithoutClear(driver, element, "Adams", ext_report, test);
		element = ManageUsersPage.Find_btn(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Find", ext_report, test);
		
	}


	private void AddUsers() throws InterruptedException
	{
		element = ManageUsersPage.AddUsers_btn(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Add User", ext_report, test);
		Thread.sleep(2000);
		ManageGlobalReviewersPage.GlobalReviewers_Option1(driver).click();
		ManageGlobalReviewersPage.FirstName_txt(driver).sendKeys("Meenakshi");
		ManageGlobalReviewersPage.ShowUsers_btn(driver).click();
		driver.findElement(By.xpath("//td[contains(text(),'Chelliah')]//preceding-sibling::td//input[@name = 'selUsers']")).click();
		CommonFunctions.scrollingToBottomOfPage(driver);
		Thread.sleep(1000);
		
		/*AdminRoles*/
		element = ManageUsersPage.Admin_Author_Roles_chkList(driver, "Report Admin");
		CommonFunctions.clickElementWebDriver(driver, element, "AdminRole", ext_report, test);
		Thread.sleep(1000);
		
		/*AuthorRole*/
		element = ManageUsersPage.Admin_Author_Roles_chkList(driver, "Alert Author");
		CommonFunctions.clickElementWebDriver(driver, element, "Author Role", ext_report, test);
		Thread.sleep(1000);
		
		/*Sub-Author Role*/
		element = EditBusinessGroupsPage.PlusTree_Btn(driver, "Alert Author");
		CommonFunctions.clickElementWebDriver(driver, element, "Plus Sign", ext_report, test);
		Thread.sleep(1500);
		element = ManageUsersPage.Admin_Author_Roles_chkList(driver, "All");
		CommonFunctions.clickElementWebDriver(driver, element, "Author Sub Role", ext_report, test);
		Thread.sleep(1000);
		
		/*Click on Add User button*/
		commonFunctions.clkElement(driver, btnAddUser, "Add User", ext_report, test);
		Thread.sleep(2000);
	}
	
	private void ExportUsersToExcel() throws AWTException, InterruptedException
	{
		element = ManageUsersPage.ExportUsers_btn(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Export Users to Excel", ext_report, test);
		Thread.sleep(2000);
		CommonFunctions.ExportFile(driver, ext_report, test);
		Thread.sleep(1000);
		
	}
	
	private void DownloadTemplate() throws InterruptedException, AWTException
	{
		element = ManageUsersPage.btnDownloadTemplate(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Download Template", ext_report, test);
		Thread.sleep(2000);
		CommonFunctions.ExportFile(driver, ext_report, test);
		
	}
	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("ProfileReportPageTest");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_209");
		ext_report.config().reportHeadline("-EW_209"); 
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