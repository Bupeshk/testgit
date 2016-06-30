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
import com.verizon.cao.selenium.admin.pages.AdminCommonPages;
import com.verizon.cao.selenium.admin.pages.AdminHomePage;
import com.verizon.cao.selenium.admin.pages.EditBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageGlobalReviewersPage;
import com.verizon.cao.selenium.admin.pages.ManageMetaDataPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_198 extends SetupBase implements Admin,Common {

	private String  baseurl ;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_198.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test;
	private WebElement element; 
	public EW_198() throws Exception {
		super();
	}

	@Test
	public void ManageGlobalReviewers() throws Exception
	{

		test = ext_report.startTest("ManageGlobalReviewersTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		String objectPath= lnkLeftNav_starts+"Manage Global Reviewers"+lnkLeftNav_ends;
		System.out.println("objectPath"  + objectPath);
		Thread.sleep(5000);

		AdminHomePage.Left_NavLinks(driver, "Manage Global Reviewers").click();
		boolean b = CommonFunctions.verifyElementPresentWebdriver(attributeName_xpath, lstBusinessGroups, lstBusinessGroups, driver);
		if(b == false)
		{

			driver.navigate().refresh();

			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage Global Reviewers").click();	

			Thread.sleep(10000);
		}

		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, lstBusinessGroups,"lstBusinessGroups", driver,ext_report, test);
		CommonFunctions.SelDropDown(lstBusinessGroups, "Verizon Enterprise Solutions", driver);
		element = ManageGlobalReviewersPage.ShowUsers_btn(driver);
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnGlobalReviewer_ShowUsers, "Show Users", driver, ext_report, test);
		//CommonFunctions.VerifyElementPresent(driver, element,"Show Users" , ext_report, test);
		//Thread.sleep(10000);
		ManageGlobalReviewersPage.AddUser_Button(driver).click();
		CommonFunctions.getTableHeaders("GlobalReviewers",driver,ext_report, test);
		CommonFunctions.existsElement(driver, txtGlobalReviwer_FirstName, ext_report, test);
		CommonFunctions.existsElement(driver, txtGlobalReviewer_Middle, ext_report, test);
		CommonFunctions.existsElement(driver, txtGlobalReviewer_LastName, ext_report, test);
		CommonFunctions.existsElement(driver, txtGlobalReviewer_EnterpriseID, ext_report, test);
		ManageGlobalReviewersPage.LastName_txt(driver).sendKeys("Stumpf");
		ManageGlobalReviewersPage.ShowUsers_btn(driver).click();
		ManageGlobalReviewersPage.Users_Found_lbl(driver).isDisplayed();
		CommonFunctions.getTableData(driver, tableManageGlobalReviewers, ext_report, test);
	}

	@BeforeMethod
	public  void setUp()throws Exception {
		//super.environmentSetUp();
		Log.startTestCase("EW_198");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_198");
		ext_report.config().reportHeadline("-EW_198"); 
		baseurl = super.getTestBaseUrl();
		driver.manage().deleteAllCookies();
		//adminHomePage = new AdminHomePage(driver);
		System.out.println("inside before class"  +baseurl);

	}
	@AfterMethod
	public void LogOut() 
	{
		ext_report.endTest(test);
		ext_report.flush(); 	
	}
}