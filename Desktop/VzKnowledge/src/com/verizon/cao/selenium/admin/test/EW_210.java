package com.verizon.cao.selenium.admin.test;


import java.util.List;

import org.openqa.selenium.Alert;
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
import com.verizon.cao.selenium.admin.pages.ManageWorkFlowGroupsPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_210 extends SetupBase implements Admin,Common {

	private String  baseurl ;
	private String[] values;
	private String[] datas;
	private WebElement element;
	CommonFunctions commonFunctions;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_210.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test; 
	public EW_210() throws Exception {
		super();
	}

	@Test
	public void ManageWorkFlowGroupsTest() throws Exception
	{
		test = ext_report.startTest("ManageWorkFlowGroupsTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		String objectPath= lnkLeftNav_starts+"Manage Workflow Groups"+lnkLeftNav_ends;
		System.out.println("objectPath"  + objectPath);
		Thread.sleep(5000);

		AdminHomePage.Left_NavLinks(driver, "Manage Workflow Groups").click();
		boolean b = CommonFunctions.existsElement(driver, btnAddWork_Flow_Groups, ext_report, test);
		if(b == false)
		{

			driver.navigate().refresh();

			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage Workflow Groups").click();	

			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnAddWork_Flow_Groups,"btnAddWork_Flow_Groups", driver, ext_report, test);
		Thread.sleep(10000);
		CommonFunctions.getTableHeaders("WorkFlowGroups",driver, ext_report, test);
		if(ApplicationConstants.Actions_links.contains(","))
		{
			values = ApplicationConstants.Actions_links.split(",");
			for(int i= 0;i<values.length;i++)
			{
				System.out.println(values[i]+"<---->values["+i+"]");
				element = ManageWorkFlowGroupsPage.Actions_lnk(driver,values[i]);
				CommonFunctions.VerifyElementPresent(driver, element, "Action Links", ext_report, test);

			}
		}
		AdminCommonPages.Action_Links(driver, ApplicationConstants.FlowGroupName,ApplicationConstants.MakeInActive).click();
		Thread.sleep(3000);
		CommonFunctions.alertAccept(driver);
		Thread.sleep(2000);
		//driver.navigate().refresh();
		AddWorkFlowGroup();
		AdminCommonPages.Action_Links(driver, ApplicationConstants.FlowGroupName,ApplicationConstants.MakeActive).click();
		Thread.sleep(3000);
		CommonFunctions.alertAccept(driver);
	}


	public void AddWorkFlowGroup() throws Exception
	{

		ManageWorkFlowGroupsPage.AddWorkFlowGroups_btn(driver).click();
		if (ApplicationConstants.AddNewGroupDetails.contains(":"))
		{
			datas = ApplicationConstants.AddNewGroupDetails.split(":");
			ManageWorkFlowGroupsPage.txtWorkFlowGroup_Name(driver).sendKeys(datas[0]);
			ManageWorkFlowGroupsPage.WorkFlowGroupDesc_txt(driver).sendKeys(datas[1]);
			driver.findElement(By.xpath("//span[@id='ddcl-selStatus']")).click();
			ManageWorkFlowGroupsPage.GroupStatus_list(driver, datas[2]).click();
			//element = ManageWorkFlowGroupsPage.AvailableRoles_opt(driver, datas[3]);
			//String availableRoles = optAvailableRoles_Editor_starts+datas[3]+optAvailableRoles_Editor_ends;
			//String availableRoles = "//span[text()='"+datas[3]+"']";
			String availableRoles = "//span[@id='sysRoleDiv']//input[@id = 'sysrole_17']";
			CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, availableRoles, "Available Roles", driver, ext_report, test);
			driver.findElement(By.xpath(availableRoles)).click();
			String availableUser = lstAvailableUsers+"//option[text() ='Das, Udayanand X']";
			CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, availableUser, "availableUser", driver, ext_report, test);
			driver.findElement(By.xpath(availableUser)).click();
			//CommonFunctions.SelDropDown(lstAvailableUsers, "Das, Udayanand X", driver);
			element = ManageWorkFlowGroupsPage.AvailableUsersAdd_btn(driver);
			CommonFunctions.clickElementWebDriver(driver, element, "Available users", ext_report, test);
		}
		ManageWorkFlowGroupsPage.AddGroup_btn(driver).click();
		Thread.sleep(3000);
	}









	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("ManageWorkFlowGroupsTest");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_210");
		ext_report.config().reportHeadline("-EW_210"); 
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