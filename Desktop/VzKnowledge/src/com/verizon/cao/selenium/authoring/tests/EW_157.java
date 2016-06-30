package com.verizon.cao.selenium.authoring.tests;
import org.apache.log4j.xml.DOMConfigurator;
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
public class EW_157 extends SetupBase implements Authoring {

	public static ExtentReports ext_report = new ExtentReports(RepConstants.REPORT_PATH+ "\\AuthoringViewAuditTrailPageTest.html", true,
			DisplayOrder.OLDEST_FIRST);
	private ExtentTest test;


	CommonFunctions common = new CommonFunctions();
	private String  baseurl ;
	public EW_157() throws Exception {
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
		Thread.sleep(2000);
	      test.log(LogStatus.PASS, "AuthoringViewAuditTrailPageTest", "folderAccountSupport clicked successfully done");		

		AuthoringContentPage.lnkcontent(driver).click();
		AuthoringContentPage.lnkViewAuditTrail(driver).click();
	      test.log(LogStatus.PASS, "AuthoringViewAuditTrailPageTest", "lnkViewAuditTrail clicked successfully done");
	      
		common.existsElement(driver,eleAuditTrail);
		common.existsElement(driver,btnprevious);
		common.existsElement(driver,btnnext);
	      test.log(LogStatus.PASS, "AuthoringViewAuditTrailPageTest", "Test case successfully done");
		
	}
	@BeforeClass
	public  void setUp()throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("AuthoringViewAuditTrailPageTest");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("AuthoringViewAuditTrailPageTest");
		ext_report.config().reportHeadline("-AuthoringViewAuditTrailPageTest");
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
