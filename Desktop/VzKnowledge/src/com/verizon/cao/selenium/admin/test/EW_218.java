package com.verizon.cao.selenium.admin.test;


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

public class EW_218  extends SetupBase implements Admin,Common {

	private CommonFunctions commonFunctions;
	private String  baseurl ;
	private AdminHomePage adminHomePage;
	private ManageBusinessGroupsPage manageBusinessGroupsPage;
	private WebElement element;
	private WebDriverWait wait,wait1,wait2;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_218.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test; 
	int numberOfRows =0;
	public EW_218() throws Exception {
		super();
	}

	@Test
	public void ProfileReportPageTest() throws Exception
	{
		test = ext_report.startTest("ContentRatingReportPageTest");
		ReportsPageTest reportsPageTest = new ReportsPageTest();
		reportsPageTest.ReportsPageTest();
	
		driver.findElement(By.xpath(lnkMore)).click();
		ReportsPage.MoreReportTabs(driver, "Content Rating Report").click();
		Thread.sleep(2000);
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, imgUserType, "User Type drop down list", driver, ext_report, test);

		//business group
		driver.findElement(By.xpath(imgBusinessGroup)).click();
		CommonFunctions.WaitForElementNotVisible(driver, lblPleaseWait);
		Thread.sleep(2000);
		CommonFunctions.scrollInElement(driver, DropDownList, ext_report, test);
		ContentReadReportsPage.BusinessGroups_chk(driver).click();
		Thread.sleep(3000);
		ContentReadReportsPage.Apply_btn(driver).click();
		Thread.sleep(4000);
		CommonFunctions.FileExists(driver,ApplicationConstants.CRR_FILEPATH, ext_report, test);
		//click on viewed user link
		driver.findElement(By.xpath(txtContentRatingReport_Role)).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(lnkViewRatedUsers)).click();
		Thread.sleep(5000);
		//wait1.until(ExpectedConditions.titleIs(title)visibilityOfElementLocated(By.xpath(lblPleaseWait)));
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, txtSubmittedRatingReportTitle, "Content Rating Report", driver, ext_report, test);
		System.out.println("page title" +driver.getTitle());
		Thread.sleep(4000);
		CommonFunctions.existsElement(driver, lnkExport, ext_report, test);
		CommonFunctions.existsElement(driver, lnkPrint, ext_report, test);
		CommonFunctions.existsElement(driver, lnkRefresh, ext_report, test);
		Thread.sleep(2000);
		commonFunctions.clkElement(driver, lnkExport, lnkExport,ext_report,test);
		commonFunctions.clkElement(driver,lnkExcel,lnkExcel,ext_report,test);
		Thread.sleep(2000);
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, lnkExcelMenuItem,"Excel Menu Item", driver, ext_report, test);
		commonFunctions.clkElement(driver,lnkExcelMenuItem,lnkExcelMenuItem,ext_report,test);
		Thread.sleep(4000);
		CommonFunctions.ExportFile(driver, ext_report, test);
		Thread.sleep(4000);
		numberOfRows = CommonFunctions.checkRowsForColumn(ApplicationConstants.CRR_ColumnName,ApplicationConstants.CRR_FILEPATH,ApplicationConstants.CRR_SheetName);
		System.out.println("number of rows" +numberOfRows);
		AdminUtils.excelReader(ApplicationConstants.CRR_FILEPATH,ApplicationConstants.CRR_SheetName);
		

	}


	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("EW_218");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_218");
		ext_report.config().reportHeadline("-EW_218"); 

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