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
import com.verizon.cao.selenium.admin.pages.AddRolesPage;
import com.verizon.cao.selenium.admin.pages.AdminCommonPages;
import com.verizon.cao.selenium.admin.pages.AdminHomePage;
import com.verizon.cao.selenium.admin.pages.EditBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageMetaDataPage;
import com.verizon.cao.selenium.admin.pages.ManageRolesPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_205  extends SetupBase implements Admin,Common {

	private CommonFunctions commonFunctions;
	private String  baseurl ;
	private AdminHomePage adminHomePage;
	private ManageBusinessGroupsPage manageBusinessGroupsPage;
	private static WebElement element;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_205.html", true,DisplayOrder.OLDEST_FIRST);
	private static ExtentTest test; 
	public EW_205() throws Exception {
		super();
	}

	@Test
	public void ManageRolesTest() throws Exception
	{
		test = ext_report.startTest("ManageRolesTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		Thread.sleep(5000);
		AdminHomePage.Left_NavLinks(driver, "Manage Roles").click();
		boolean b = CommonFunctions.verifyElementPresentWebdriver(attributeName_xpath, btnAddNew_Business_Groups, btnAddNew_Business_Groups, driver);
		if(b == false)
		{

			driver.navigate().refresh();
			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage Roles").click();
			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnManageRoles_AddChild,"Add Child Role button", driver, ext_report, test);
		element = ManageRolesPage.Add_btn(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Add", ext_report, test);
		element = ManageRolesPage.AddChild_btn(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "AddChild", ext_report, test);
		element = ManageRolesPage.Edit_btn(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Edit Role", ext_report, test);
		Thread.sleep(10000);
		element = ManageRolesPage.Add_btn(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Add", ext_report, test);
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnAddRole, "Add Role", driver, ext_report, test);
		AddRolesData();		
	}
	
	
	private static void AddRolesData() throws Exception
	{
		element = AddRolesPage.RoleName_txt(driver);
		CommonFunctions.SendKeysWithoutClear(driver, element, "Role1", ext_report, test);
		element = AddRolesPage.RoleDesc_txt(driver);
		CommonFunctions.SendKeysWithoutClear(driver, element, "Role1", ext_report, test);
		element = AddRolesPage.RoleNotes_txt(driver);
		CommonFunctions.SendKeysWithoutClear(driver, element, "Add role", ext_report, test);
		element = AddRolesPage.Status_list(driver);
		CommonFunctions.SelDropDown(lstManageRoles_Status, "Active", driver);
		element = AddRolesPage.Content_Types_list(driver, "Alerts");
		CommonFunctions.clickElementWebDriver(driver, element, "Clicking on Alerts", ext_report, test);
		AddRolesPage.BusinessGroupDefault_chkBox(driver).click();
		String objPath = chkWorkFlow_starts+"EDITOR(All)'and @disabled]";
		System.out.println("Onject path"  +objPath);
		CommonFunctions.WaitForElementNotVisible(driver, objPath);
		 AddRolesPage.ReviewDate_Workflow(driver, "EDITOR(All)").click();
		 element = AddRolesPage.DeafultWorkFlow_List(driver,"EDITOR(All)");
		CommonFunctions.VerifyElementPresent(driver, element, "EDITOR(All)", ext_report, test);
		AddRolesPage.AvailableGroups_chkBox(driver).click();
		element = AddRolesPage.AddRole_btn(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Add Role", ext_report, test);
	}

	@BeforeMethod
	public  void setUp()throws Exception {
		
		Log.startTestCase("EW_205");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_205");
		ext_report.config().reportHeadline("-EW_205"); 
		baseurl = super.getTestBaseUrl();
		driver.manage().deleteAllCookies();
		
		
	}
	@AfterMethod
	public void LogOut() 
	{
		ext_report.endTest(test);
		ext_report.flush(); 	
	}
}