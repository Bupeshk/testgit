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
import com.verizon.cao.selenium.admin.pages.ManageQueryGroupsPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_204 extends SetupBase implements Admin,Common {

	private String  baseurl ;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_204.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test;
	private WebElement element; 
	public EW_204() throws Exception {
		super();
	}

	@Test
	public void ManageQueryGroupsTest() throws Exception
	{
		test = ext_report.startTest("ManageQueryGroupsTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		Thread.sleep(5000);
		AdminHomePage.Left_NavLinks(driver, "Manage Query Groups").click();
		boolean b = CommonFunctions.existsElement(driver, btnManageQueryGroup, ext_report, test);
		if(b == false)
		{

			driver.navigate().refresh();

			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage Query Groups").click();	

			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnManageQueryGroup,"btnManageQueryGroup", driver, ext_report, test);
		CommonFunctions.getTableHeaders("QueryGroups",driver, ext_report, test);
		
		/*Add Manage Groups button - click*/
		element = ManageQueryGroupsPage.btnManageQueryGroup(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Add Manage Groups", ext_report, test);
		
		/*Add Query Gorup*/
		addQueryGroup();
		
		/*Accept Alert*/
		CommonFunctions.alertAccept(driver);
	
	}
	
	private void addQueryGroup() throws Exception
	{
		element = ManageQueryGroupsPage.QueryGroupName_txt(driver);
		CommonFunctions.SendKeysWithoutClear(driver, element,ApplicationConstants.QueryGroups_Name, ext_report, test);
		element = ManageQueryGroupsPage.QueryGroupDesc_txt(driver)			;	
		CommonFunctions.SendKeysWithoutClear(driver, element,ApplicationConstants.QueryGroups_Desc, ext_report, test);
		element = ManageQueryGroupsPage.QueryGroupQuery_txt(driver);
		CommonFunctions.SendKeysWithoutClear(driver, element,ApplicationConstants.QueryGroups_Query, ext_report, test);
		CommonFunctions.SelDropDown(lstQueryGroup_Status, ApplicationConstants.QueryGroups_Status, driver);
		element = ManageQueryGroupsPage.AddQueryGroup_btn(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Add Query Gorup", ext_report, test);
		
	}
	

	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("EW_204");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_204");
		ext_report.config().reportHeadline("-EW_204"); 
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