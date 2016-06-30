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

public class EW_226  extends SetupBase implements Admin,Common {

	private CommonFunctions commonFunctions;
	private String  baseurl ;
	private AdminHomePage adminHomePage;

	private ManageBusinessGroupsPage manageBusinessGroupsPage;
	private WebElement element;
	private WebDriverWait wait,wait1,wait2;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_226.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test; 
	public EW_226() throws Exception {
		super();
	}

	@Test
	public void WorkFlowReportsPageTest() throws Exception
	{
		test = ext_report.startTest("WorkFlowReportsPageTest");
		ReportsPageTest reportsPageTest = new ReportsPageTest();
		reportsPageTest.ReportsPageTest();
		driver.findElement(By.xpath(lnkMore)).click();
		ReportsPage.MoreReportTabs(driver, "Workflow Report").click();

		//business group
		driver.findElement(By.xpath(imgBusinessGroup)).click();
		wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lblPleaseWait)));
		Thread.sleep(2000);
		CommonFunctions.scrollInElement(driver, DropDownList, ext_report, test);
		ContentReadReportsPage.BusinessGroups_chk(driver).click();
		Thread.sleep(3000);
		//role
		driver.findElement(By.xpath(ClickAtWorkspace)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(imgRole)).click();
		wait1 = new WebDriverWait(driver,300);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lblPleaseWait)));
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body//div[@class = 'DropDownValueList']")));
		Thread.sleep(6000);
		CommonFunctions.scrollInElement(driver, DropDownList, ext_report, test);
		Thread.sleep(5000);
		//ContentReadReportsPage.ReportRole_chk(driver).click();
		driver.findElement(By.xpath("html/body//div[@class = 'DropDownValueList']//label[text() = 'Global Operations - Business Ops']//preceding-sibling::input")).click();
		ContentReadReportsPage.Apply_btn(driver).click();
		Thread.sleep(4000);
		CommonFunctions.existsElement(driver, lnkExport, ext_report, test);
		CommonFunctions.existsElement(driver, lnkPrint, ext_report, test);
		CommonFunctions.existsElement(driver, lnkRefresh, ext_report, test);
		String filePATH = "C:\\Users\\CHELLME\\Downloads\\vzk_WorkflowdetailReport_Modified.xlsx";
		CommonFunctions.FileExists(driver,filePATH, ext_report, test);
		//clicking on viewed user link
		driver.findElement(By.xpath("//td[contains(text(), 'Global Operations - Business Ops')]//following-sibling::td//a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(lnkViewWorkFlowDetails)).click();
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, txtWorkFlowReportTitle, txtWorkFlowReportTitle, driver, ext_report, test);
	commonFunctions.clkElement(driver, lnkExport, lnkExport, ext_report, test);
		//driver.findElement(By.xpath(lnkExport)).click();
		Thread.sleep(2000);
		commonFunctions.clkElement(driver,lnkExcel,lnkExcel, ext_report, test);
		Thread.sleep(2000);
		commonFunctions.waitForElementPresentWebdriver(attributeName_xpath, lnkExcelMenuItem,"lnkExcelMenuItem", driver, ext_report, test);
		commonFunctions.clkElement(driver,lnkExcelMenuItem,lnkExcelMenuItem, ext_report, test);
		Thread.sleep(4000);
		CommonFunctions.ExportFile(driver, ext_report, test);
		Thread.sleep(4000);
		int numberOfRows = CommonFunctions.checkRowsForColumn("Title","C:\\Users\\CHELLME\\Downloads\\vzk_WorkflowdetailReport_Modified.xlsx", "Sheet1");
		System.out.println("number of rows" +numberOfRows);
		AdminUtils.excelReader("C:\\Users\\CHELLME\\Downloads\\vzk_WorkflowdetailReport_Modified.xlsx","Sheet1");
		

	}


	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("EW_227");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_227");
		ext_report.config().reportHeadline("-EW_227"); 
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