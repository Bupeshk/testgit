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
import com.verizon.cao.selenium.admin.pages.ManagePresetRolesPage;
import com.verizon.cao.selenium.admin.pages.ManageWorkFlowGroupsPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_201 extends SetupBase implements Admin,Common {

	private String  baseurl ;
	private WebElement element;
	private String[] values;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_201.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test; 
	public EW_201() throws Exception {
		super();
	}

	@Test
	public void ManagePresetRoles() throws Exception
	{
		test = ext_report.startTest("ManagePresetRolesTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		String objectPath= lnkLeftNav_starts+"Manage Preset Roles"+lnkLeftNav_ends;
		System.out.println("objectPath"  + objectPath);
		Thread.sleep(5000);

		AdminHomePage.Left_NavLinks(driver, "Manage Preset Roles").click();
		boolean b = CommonFunctions.verifyElementPresentWebdriver(attributeName_xpath, btnAddPresetRole, btnAddPresetRole, driver);
		if(b == false)
		{

			driver.navigate().refresh();

			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage Preset Roles").click();	

			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnAddPresetRole,"btnAddPresetRole", driver, ext_report, test);
		Thread.sleep(10000);
		CommonFunctions.getTableHeaders("PresetRoles",driver, ext_report, test);
		if(ApplicationConstants.Preset_Action_links.contains(","))
		{
			values = ApplicationConstants.Preset_Action_links.split(",");
			for(int i= 0;i<values.length;i++)
			{
				element = ManageWorkFlowGroupsPage.Actions_lnk(driver,values[i]);
				CommonFunctions.VerifyElementPresent(driver, element, "table headers", ext_report, test);

			}
		}

		AddPresetRoleData();
		CommonFunctions.alertAccept(driver);
		//VerifyPresetRoleData();
		CommonFunctions.FindTextInTable(driver,tableUsers, ext_report, test);

	}

	public void AddPresetRoleData()
	{

		//AdminCommonPages.Action_Links(driver, c, Action)
		element = ManagePresetRolesPage.btnAddPresetRole(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "add preset role", ext_report, test);
		element = ManagePresetRolesPage.txtPresetRoleName(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Preset RoleName", ext_report, test);
		CommonFunctions.SendKeysWithoutClear(driver, element, ApplicationConstants.PresetRole_Name, ext_report, test);
		element = ManagePresetRolesPage.txtPresetRoleDescription(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Preset RoleDesc", ext_report, test);
		CommonFunctions.SendKeysWithoutClear(driver, element, ApplicationConstants.PresetRole_Desc, ext_report, test);
		element = ManagePresetRolesPage.chkMetaData_Role_Region(driver, ApplicationConstants.PresetRole_Metadata);
		CommonFunctions.clickElementWebDriver(driver, element, "Role", ext_report, test);
		element = ManagePresetRolesPage.lnkMetaDataRegion(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Region", ext_report, test);
		element = ManagePresetRolesPage.chkMetaData_Role_Region(driver, ApplicationConstants.PresetRegion_Metadata);
		CommonFunctions.clickElementWebDriver(driver, element, "Rol", ext_report, test);
		element = ManagePresetRolesPage.btnAddPresetRole_Edit(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "add preset role", ext_report, test);
	}

	
	

	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("EW_201");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_201");
		ext_report.config().reportHeadline("-EW_201"); 
		baseurl = super.getTestBaseUrl();
		driver.manage().deleteAllCookies();
		System.out.println("inside before class"  +baseurl);

	}

	@AfterMethod
	public void LogOut() 
	{
		ext_report.endTest(test);
		ext_report.flush(); 	
	}
}