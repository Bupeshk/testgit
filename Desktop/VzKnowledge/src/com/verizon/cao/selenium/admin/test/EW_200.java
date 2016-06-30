package com.verizon.cao.selenium.admin.test;


import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.verizon.cao.selenium.admin.pages.AddMetaDataPage;
import com.verizon.cao.selenium.admin.pages.AdminHomePage;
import com.verizon.cao.selenium.admin.pages.ManageMetaDataPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_200  extends SetupBase implements Admin,Common {

	private CommonFunctions commonFunctions;
	private String  baseurl ;
	private AdminHomePage adminHomePage;
	
	private AddMetaDataPage addMetaDataPage;
	private WebElement element;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_200.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test; 
	public EW_200() throws Exception {
		super();
	}

	@Test
	public void SelectMetaTypes() throws Exception
	{
		test = ext_report.startTest("ManageMetaDataTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		String objectPath= lnkLeftNav_starts+"Manage Metadata"+lnkLeftNav_ends;
		System.out.println("objectPath"  + objectPath);
		Thread.sleep(5000);
		
		AdminHomePage.Left_NavLinks(driver, "Manage Metadata").click();
		
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, lstContentType,"Meta type", driver, ext_report, test);
		//Thread.sleep(5000);
		CommonFunctions.SelDropDown(lstContentType,"Alerts",driver);
		//
		Thread.sleep(1000);
		CommonFunctions.SelDropDown(lstContentType,"Calendar",driver);
		//CommonFunctions.DivLoading(driver);
		Thread.sleep(500);
		CommonFunctions.SelDropDown(lstContentType,"Alerts",driver);
		CommonFunctions.DivLoading(driver);
		CommonFunctions.SelDropDown(lstMetaType,"Alert Type",driver);
		Thread.sleep(10000);
		ManageMetaDataPage.MetaData_RadioBtn(driver, "Internal").click();
		Thread.sleep(2000);
		
		ManageMetaDataPage.ManageMetaData_Buttons(driver, "Add").click();
		Thread.sleep(3000);
		AddMetaDataPage.MetaDataValue_txt(driver).sendKeys("Test54");
		AddMetaDataPage.MetaDataDesc_txt(driver).sendKeys("For Test");
		AddMetaDataPage.EndUserRoles_Opt(driver, "Collections").click();
		AddMetaDataPage.MetaData_btn_Add_Cancel(driver, "Add Metadata").click();
		CommonFunctions.writeConsole("Added meta data");
		CommonFunctions.alertAccept(driver);
		
		

	}

	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("ManageMetaDataTest");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_200");
		ext_report.config().reportHeadline("-EW_200"); 
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