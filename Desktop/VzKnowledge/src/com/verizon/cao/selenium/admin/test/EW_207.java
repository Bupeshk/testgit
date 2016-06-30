package com.verizon.cao.selenium.admin.test;


import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.verizon.cao.selenium.admin.pages.AddMetaDataPage;
import com.verizon.cao.selenium.admin.pages.AdminHomePage;
import com.verizon.cao.selenium.admin.pages.ManageGlobalReviewersPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_207 extends SetupBase implements Admin,Common {

	private String  baseurl ;
	private AddMetaDataPage addMetaDataPage;
	private WebElement element;
	CommonFunctions commonFunctions;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_207.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test; 
	public EW_207() throws Exception {
		super();
	}


	public void ManageSuperAdmin() throws Exception
	{
		test = ext_report.startTest("ManageSuperAdminTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		AdminHomePage.Left_NavLinks(driver, "Manage Super Admin").click();
		boolean b = CommonFunctions.existsElement(driver, btnSuperAdmin_AddUser, ext_report, test);
		if(b == false)
		{

			driver.navigate().refresh();

			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage Super Admin").click();	

			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnSuperAdmin_AddUser,"btnSuperAdmin_AddUser", driver, ext_report, test);
		//select business group from drop down
		//CommonFunctions.SelDropDown(lstBusinessGroups, "Verizon Enterprise Solutions", driver);
		Thread.sleep(10000);
		//CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnAddUser,"btnAddUser", driver, ext_report, test);
		CommonFunctions.getTableHeaders("SuperAdmin",driver, ext_report, test);
		ManageGlobalReviewersPage.AddUser_Button(driver).click();
		//CommonFunctions.getTableHeaders("SuperAdmin",driver, ext_report, test);
		CommonFunctions.existsElement(driver, txtGlobalReviwer_FirstName, ext_report, test);
		CommonFunctions.existsElement(driver, txtGlobalReviewer_Middle, ext_report, test);
		CommonFunctions.existsElement(driver, txtGlobalReviewer_LastName, ext_report, test);
		CommonFunctions.existsElement(driver, txtGlobalReviewer_EnterpriseID, ext_report, test);
		ManageGlobalReviewersPage.GlobalReviewers_OptionEID(driver).click();
		ManageGlobalReviewersPage.EnterpriseID_txt(driver).sendKeys(ApplicationConstants.SuperAdmin_EID);
		ManageGlobalReviewersPage.ShowUsers_btn(driver).click();
		ManageGlobalReviewersPage.Users_Found_lbl(driver).isDisplayed();
		element = ManageGlobalReviewersPage.lblFullName_Of_Users_Found(driver,"("+ApplicationConstants.SuperAdmin_EID+")");
		CommonFunctions.VerifyElementPresent(driver, element,"no of users", ext_report, test);
		//CommonFunctions.getTableData(driver, objectpath, ext_report, test);

	}


	@BeforeMethod
	public  void setUp()throws Exception {
		//super.environmentSetUp();
		Log.startTestCase("EW_207");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_207");
		ext_report.config().reportHeadline("-EW_207"); 
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
		commonFunctions.VzLogout(driver);
	}


}