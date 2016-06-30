package com.verizon.cao.selenium.authoring.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.authoring.pages.AuthoringContentPage;
import com.verizon.cao.selenium.authoring.pages.AuthoringDashboardPage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.LoginPageTest;
import com.verizon.cao.selenium.common.RepConstants;
import com.verizon.cao.selenium.common.ObjectRepository.Authoring;
import com.verizon.cao.selenium.setup.SetupBase;

@Test
public class EW_173 extends SetupBase implements Authoring {

	public static ExtentReports ext_report = new ExtentReports(RepConstants.REPORT_PATH+ "\\AuthoringNewsCreateContentPageTest.html", true,
			DisplayOrder.OLDEST_FIRST);
	private ExtentTest test;
	CommonFunctions common = new CommonFunctions();
	private String  baseurl ;
	public EW_173() throws Exception {
		super();
	}
	//@BeforeSuite
	@Test
	public  void Logintest() throws Exception
	
	{
		test = ext_report.startTest("LoginPageTest");
		LoginPageTest loginpage = new LoginPageTest();
		loginpage.Logintest();
		test.log(LogStatus.PASS, "LoginPageTest", "Login successfully done");

		AuthoringDashboardPage.folderAccountSupport(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "AuthoringNewsCreateContentPageTest", "folderAccountSupport clicked successfully done");
		
		AuthoringDashboardPage.eleCreate(driver).click();
		AuthoringContentPage.chckrole(driver).click();
		AuthoringContentPage.btncontinue(driver).click();
		AuthoringContentPage.txtboxtitle(driver).sendKeys("a");
		AuthoringContentPage.txtdescription(driver).sendKeys("a");

		String get_date = common.GetCurrentSystemDate();
		AuthoringContentPage.authoring_effect_date(driver).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(AuthoringContentPage.authoring_set_date+"'"+get_date+"']")).click();
		AuthoringContentPage.authoring_valid_date(driver).click();
		Thread.sleep(1000);
		AuthoringContentPage.authoring_clk_next(driver).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(AuthoringContentPage.authoring_set_date+"'"+get_date+"']")).click();

		common.switchFrame(driver, authoring_frame);
		Thread.sleep(1000);
		AuthoringContentPage.authoring_body_desc(driver).sendKeys("Test automation");
		driver.switchTo().defaultContent();
		
		AuthoringContentPage.btnsave(driver).click();
		common.existsElement(driver,eleverifyNews);
		AuthoringContentPage.btnviewdetails(driver).click();
		test.log(LogStatus.PASS, "AuthoringNewsCreateContentPageTest", "btnviewdetails clicked successfully done");
		
		AuthoringContentPage.folderNews(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "AuthoringNewsCreateContentPageTest", "folderNews clicked successfully done");
		AuthoringContentPage.chckcontent(driver).click();
		AuthoringDashboardPage.elePublish(driver).click();
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "AuthoringNewsCreateContentPageTest", "Test case successfully done");
	}
	@BeforeClass
	public  void setUp()throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("AuthoringNewsCreateContentPageTest");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("AuthoringNewsCreateContentPageTest");
		ext_report.config().reportHeadline("-AuthoringNewsCreateContentPageTest");
		//super.environmentSetUp();
		baseurl = super.getTestBaseUrl();
		//adminHomePage = new AdminHomePage(driver);
		System.out.println("inside before class"  +baseurl);

	} 
	
	

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");

		ext_report.endTest(test);
		ext_report.flush();
	}	
	
}
