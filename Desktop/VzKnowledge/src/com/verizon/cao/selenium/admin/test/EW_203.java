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
import com.verizon.cao.selenium.admin.pages.ManagePropertiesPage;
import com.verizon.cao.selenium.admin.pages.ManageQueryGroupsPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_203 extends SetupBase implements Admin,Common {

	private String  baseurl ;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_203.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test;
	private WebElement element; 
	public EW_203() throws Exception {
		super();
	}

	@Test
	public void ManageProperties() throws Exception
	{
		test = ext_report.startTest("ManagePropertiesTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		String objectPath= lnkLeftNav_starts+"Manage Properties"+lnkLeftNav_ends;
		AdminHomePage.Left_NavLinks(driver, "Manage Properties").click();
		boolean b = CommonFunctions.existsElement(driver, btnAddProperty, ext_report, test);
		if(b == false)
		{

			driver.navigate().refresh();

			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage Properties").click();	

			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnAddProperty,"btnAddProperty", driver, ext_report, test);
		//CommonFunctions.SelDropDown(lstBusinessGroups, "Verizon Enterprise Solutions", driver);
		Thread.sleep(10000);
		CommonFunctions.getTableHeaders("Properties",driver, ext_report, test);
		element = ManagePropertiesPage.btnProperty(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Add Property", ext_report, test);
		
		/*Add Property*/
		AddPropertyData();
		
		/*Accept Alert */
		CommonFunctions.alertAccept(driver);
	}

	
	private void AddPropertyData(){
		
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, txtPropertyDesc, "property Desc", driver, ext_report, test);
		element = ManagePropertiesPage.PropertyName_txt(driver);
		CommonFunctions.SendKeysWithoutClear(driver, element,ApplicationConstants.Properties_Name, ext_report, test);
		element = ManagePropertiesPage.PropertyValue_txt(driver);	
		CommonFunctions.SendKeysWithoutClear(driver, element,ApplicationConstants.Properties_Value, ext_report, test);
		element = ManagePropertiesPage.PropertyDesc_txt(driver);
		CommonFunctions.SendKeysWithoutClear(driver, element,ApplicationConstants.Properties_Desc, ext_report, test);
		element = ManagePropertiesPage.btnAddProperty_ManageProperties(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "Add Property", ext_report, test);
		
	}

	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("EW_203");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_203");
		ext_report.config().reportHeadline("-EW_203"); 
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