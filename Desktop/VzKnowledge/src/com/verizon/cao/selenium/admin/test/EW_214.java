package com.verizon.cao.selenium.admin.test;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import com.verizon.cao.selenium.admin.pages.BrokenLinkReportPage;
import com.verizon.cao.selenium.admin.pages.ContentReadReportsPage;
import com.verizon.cao.selenium.admin.pages.EditBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageMetaDataPage;
import com.verizon.cao.selenium.admin.pages.ReportsPage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ReportsPageTest;
import com.verizon.cao.selenium.common.AdminUtils;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_214  extends SetupBase implements Admin,Common {

	private CommonFunctions commonFunctions;
	private String  baseurl ;
	private AdminHomePage adminHomePage;

	private ManageBusinessGroupsPage manageBusinessGroupsPage;
	private WebElement element;
	private WebDriverWait wait,wait1,wait2;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_214.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test; 

	public EW_214() throws Exception {
		super();
	}

	@Test
	public void BrokenLinkReportsPageTest() throws Exception
	{
		test = ext_report.startTest("EW_214");
		ReportsPageTest reportsPageTest = new ReportsPageTest();
		reportsPageTest.ReportsPageTest();
		Thread.sleep(2000);
		ReportsPage.ReportTabs(driver, "Broken Link Report").click();
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, txtCreatedDate_Between, "created date between", driver, ext_report, test);
		driver.findElement(By.xpath(imgBusinessGroup)).click();
		wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lblPleaseWait)));
		Thread.sleep(2000);
		CommonFunctions.scrollInElement(driver, DropDownList, ext_report, test);
		ContentReadReportsPage.BusinessGroups_chk(driver).click();
		Thread.sleep(3000);
		ReportsPage.ClickAtWorkspace(driver);
		BrokenLinkReportPage.CreatedDateBetween(driver).sendKeys(ApplicationConstants.BLRCreatedDate_Between);
		BrokenLinkReportPage.CreatedDate_To(driver).sendKeys(ApplicationConstants.BLRCreatedDate_To);
		ContentReadReportsPage.Apply_btn(driver).click();
		Thread.sleep(2000);
		CommonFunctions.FileExists(driver,ApplicationConstants.BLR_FILEPATH, ext_report, test);
		element = ReportsPage.Refresh_Link(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Refresh Link", ext_report, test);
		element = ReportsPage.Print_Link(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Print Link", ext_report, test);
		element = ReportsPage.Export_Link(driver);
		CommonFunctions.VerifyElementPresent(driver, element, "Export Link", ext_report, test);
		CommonFunctions.clickElementWebDriver(driver, element, "Export Link", ext_report, test);
		Thread.sleep(2000);
		CommonFunctions.scrollInElement(driver, DropDownList, ext_report, test);
		element = ReportsPage.Excel_Link(driver);
		CommonFunctions.clickElementWebDriver(driver,element,"Excel Link", ext_report, test);
		//element = ReportsPage.ExcelMenuItem_Link(driver);
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, lnkExcelMenuItem,"ExcelMenuItem", driver, ext_report, test);
		commonFunctions.clkElement(driver,lnkExcelMenuItem,lnkExcelMenuItem, ext_report, test);
		Thread.sleep(4000);
		CommonFunctions.ExportFile(driver, ext_report, test);
		Thread.sleep(4000);
		int numberOfRows = CommonFunctions.checkRowsForColumn(ApplicationConstants.BLR_ColumnName,ApplicationConstants.BLR_FILEPATH,ApplicationConstants.BLR_SheetName);
		System.out.println("number of rows" +numberOfRows);
		AdminUtils.excelReader(ApplicationConstants.BLR_FILEPATH,ApplicationConstants.BLR_SheetName);


	}


	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("EW_214");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_214");
		ext_report.config().reportHeadline("-EW_214"); 
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