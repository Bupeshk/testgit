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
import com.verizon.cao.selenium.admin.pages.ContentReadReportsPage;
import com.verizon.cao.selenium.admin.pages.EditBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageMetaDataPage;
import com.verizon.cao.selenium.admin.pages.ReportsPage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ReportsPageTest;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_215  extends SetupBase implements Admin,Common {

	private CommonFunctions commonFunctions;
	private String  baseurl ;
	private AdminHomePage adminHomePage;

	private ManageBusinessGroupsPage manageBusinessGroupsPage;
	private WebElement element;
	private WebDriverWait wait,wait1,wait2;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_215.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test; 

	public EW_215() throws Exception {
		super();
	}

	@Test
	public void ReadAndComplianceReportPageTest() throws Exception
	{
		test = ext_report.startTest("PortletReportPageTest");
		ReportsPageTest reportsPageTest = new ReportsPageTest();
		reportsPageTest.ReportsPageTest();
		Thread.sleep(2000);
		ReportsPage.ReportTabs(driver, "Read & Compliance Report - Alert").click();
		driver.findElement(By.xpath(imgBusinessGroup)).click();
		 wait = new WebDriverWait(driver,300);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lblPleaseWait)));
			Thread.sleep(2000);
			CommonFunctions.scrollInElement(driver, "html/body//div[@class = 'DropDownValueList']", ext_report, test);
			ContentReadReportsPage.BusinessGroups_chk(driver).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(ClickAtWorkspace)).click();
			driver.findElement(By.xpath(txtCreatedDate_Between)).sendKeys("08/16/2014");
			driver.findElement(By.xpath(txtCreatedDate_To)).sendKeys("12/15/2015");
			ContentReadReportsPage.Apply_btn(driver).click();
			Thread.sleep(2000);
			CommonFunctions.existsElement(driver, lnkExport, ext_report, test);
			CommonFunctions.existsElement(driver, lnkPrint, ext_report, test);
			CommonFunctions.existsElement(driver, lnkRefresh, ext_report, test);
			commonFunctions.clkElement(driver, lnkExport, lnkExport, ext_report, test);
			//driver.findElement(By.xpath(lnkExport)).click();
			Thread.sleep(2000);
			CommonFunctions.scrollInElement(driver,"//div[@id='DashboardPageContentDiv']", ext_report, test);
			commonFunctions.clkElement(driver,lnkExcel,lnkExcel, ext_report, test);
			CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, lnkExcelMenuItem,"lnkExcelMenuItem", driver, ext_report, test);
			commonFunctions.clkElement(driver,lnkExcelMenuItem,lnkExcelMenuItem, ext_report, test);
			Thread.sleep(4000);
			CommonFunctions.ExportFile(driver, ext_report, test);
						
			
	}

	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("EW_215");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_215");
		ext_report.config().reportHeadline("-EW_215"); 
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