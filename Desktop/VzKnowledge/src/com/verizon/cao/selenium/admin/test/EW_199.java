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
import com.verizon.cao.selenium.admin.pages.AddOrEditMetaTypePage;
import com.verizon.cao.selenium.admin.pages.AdminCommonPages;
import com.verizon.cao.selenium.admin.pages.AdminHomePage;
import com.verizon.cao.selenium.admin.pages.EditBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageGlobalReviewersPage;
import com.verizon.cao.selenium.admin.pages.ManageMetaDataPage;
import com.verizon.cao.selenium.admin.pages.ManageMetaTypePage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_199 extends SetupBase implements Admin,Common {

	private String  baseurl ;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_199.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test; 
	public EW_199() throws Exception {
		super();
	}

	@Test
	public void ManageMetaTypeTest() throws Exception
	{
		test = ext_report.startTest("ManageMetaTypeTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		String objectPath= lnkLeftNav_starts+"Manage MetaTypes"+lnkLeftNav_ends;
		System.out.println("objectPath"  + objectPath);
		Thread.sleep(5000);

		AdminHomePage.Left_NavLinks(driver, "Manage MetaTypes").click();
		boolean b = CommonFunctions.verifyElementPresentWebdriver(attributeName_xpath, lstMetaType_BusinessGroup, lstMetaType_BusinessGroup, driver);
		if(b == false)
		{

			driver.navigate().refresh();

			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage MetaTypes").click();
			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, lstMetaType_BusinessGroup,"lstMetaType_BusinessGroup", driver, ext_report, test);

		//Thread.sleep(5000);
		System.out.println("verifies************ ");
		CommonFunctions.SelDropDown(lstMetaType_BusinessGroup, "Verizon Enterprise Solutions", driver);
		
		Thread.sleep(10000);
		CommonFunctions.SelDropDown(lstMetaType_ContentType, "Alerts", driver);
		Thread.sleep(2000);
		
		CommonFunctions.getTableHeaders("MetaTypes",driver, ext_report, test);
		ManageMetaTypePage.AddMetaType_btn(driver).click();
		Thread.sleep(2000);
		AddOrEditMetaTypePage.MetaTypeName_txt(driver).sendKeys("NewMetaTypeName");
		AddOrEditMetaTypePage.MetaTypeDescription_txt(driver).sendKeys("sendKeys");
		driver.findElement(By.xpath(lstIsHierarchical_Options_starts)).click();
		driver.findElement(By.xpath(lstIsHierarchical_Options_ends)).click();
		driver.findElement(By.xpath("//span[@id='ddcl-hasprofile']/span")).click();
		driver.findElement(By.xpath("//div[@id='ddcl-hasprofile-ddw']//div//label[text() ='YES']")).click();
		driver.findElement(By.xpath("//span[@id='ddcl-issubscribe']/span")).click();
		driver.findElement(By.xpath("//div[@id='ddcl-issubscribe-ddw']//div//label[text() ='YES']")).click();
		
		AddOrEditMetaTypePage.AddMetaType_btn(driver).click();
		CommonFunctions.alertAccept(driver);
		Thread.sleep(2000);
		CommonFunctions.alertAccept(driver);
		Thread.sleep(5000);
		
		

		
		
		
		
		





		//commonFunctions.verifyElementPresentWebdriver(attributeName_xpath, element1, "element Found", driver);

		//		// WebDriverWait wait = new WebDriverWait(driver, 1000);



	}

	@BeforeMethod
	public  void setUp()throws Exception {
		Log.startTestCase("ManageMetaTypeTest");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_199");
		ext_report.config().reportHeadline("-EW_199"); 
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