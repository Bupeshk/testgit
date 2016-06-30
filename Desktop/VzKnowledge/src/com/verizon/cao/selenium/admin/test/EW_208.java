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
import com.verizon.cao.selenium.admin.pages.ManageUserGroupsPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_208 extends SetupBase implements Admin,Common {

	private String  baseurl ;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_208.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test;
	CommonFunctions commonFunctions;
	private WebElement element; 
	public EW_208() throws Exception {
		super();
	}

	@Test
	public void ManageUsersGroups() throws Exception
	{
		test = ext_report.startTest("ManageQueryGroupsTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		Thread.sleep(5000);
		AdminHomePage.Left_NavLinks(driver, "Manage User Groups").click();
		Thread.sleep(1000);
		boolean b = CommonFunctions.existsElement(driver, btnAddUserGroups, ext_report, test);
		if(b == false)
		{
			driver.navigate().refresh();
			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage User Groups").click();	
			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnAddUserGroups,"btnAddUserGroups", driver, ext_report, test);
		Thread.sleep(10000);
		CommonFunctions.getTableHeaders("UserGroups",driver, ext_report, test);
		AdminCommonPages.Action_Links(driver, ApplicationConstants.QueryGroups_GroupName,ApplicationConstants.QueryGroups_MakeInActive).click();
		Thread.sleep(3000);
		CommonFunctions.alertAccept(driver);
		Thread.sleep(2000);
		//driver.navigate().refresh();
		//AddWorkFlowGroup();
		AdminCommonPages.Action_Links(driver,ApplicationConstants.QueryGroups_GroupName,ApplicationConstants.QueryGroups_MakeActive).click();
		Thread.sleep(3000);
		CommonFunctions.alertAccept(driver);
//		for(int i =0;i<3;i++)
//		{
//			String[] actionLink = ApplicationConstants.UsersGroups_Actions.split(",");
//		
//		element = ManageUserGroupsPage.makeActive_InActive_link(driver, ApplicationConstants.UsersGroups_Name, actionLink[i]);
//		if(element.getText().equalsIgnoreCase(actionLink[i]))
//		CommonFunctions.VerifyElementPresent(driver, element, actionLink[i], ext_report, test);
//		
//		}
		CommonFunctions.getTableDataLinks(driver, tableUsers, ext_report, test);
		

	}

	@BeforeMethod
	public void setUp()throws Exception {
		Log.startTestCase("EW_208");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_208");
		ext_report.config().reportHeadline("-EW_208"); 
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