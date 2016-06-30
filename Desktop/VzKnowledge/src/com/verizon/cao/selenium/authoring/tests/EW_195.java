package com.verizon.cao.selenium.authoring.tests;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.authoring.pages.AuthoringEnduserPage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.RepConstants;
import com.verizon.cao.selenium.common.SingleLoginTest;
import com.verizon.cao.selenium.common.ObjectRepository.Authoring;
import com.verizon.cao.selenium.setup.SetupBase;

@Test
public class EW_195 extends SetupBase implements Authoring {

	public static ExtentReports ext_report = new ExtentReports(RepConstants.REPORT_PATH+ "\\AuthoringNetworkTechnologyPublishingContentEnduserPageTest.html", true,
			DisplayOrder.OLDEST_FIRST);
	private ExtentTest test;
	CommonFunctions common = new CommonFunctions();
	private String  baseurl ;
	public EW_195() throws Exception {
		super();
	}
	//@BeforeSuite
	@Test
	public  void Logintest() throws Exception
	
	{
		test = ext_report.startTest("LoginPageTest");
		SingleLoginTest loginpage = new SingleLoginTest();
		loginpage.Logintest();
		test.log(LogStatus.PASS, "LoginPageTest", "Login successfully done");
		
		common.existsElement(driver, elemyfeed);
		AuthoringEnduserPage.lnktaxonomy(driver).click();
		test.log(LogStatus.PASS, "AuthoringNetworkTechnologyPublishingContentEnduserPageTest", "lnkTaxonomy clicked successfully done");
		common.existsElement(driver, eledocnum);

		test.log(LogStatus.PASS, "AuthoringNetworkTechnologyPublishingContentEnduserPageTest", "Test case successfully done");
	}
	@BeforeClass
	public  void setUp()throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("AuthoringNetworkTechnologyPublishingContentEnduserPageTest");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("AuthoringNetworkTechnologyPublishingContentEnduserPageTest");
		ext_report.config().reportHeadline("-AuthoringNetworkTechnologyPublishingContentEnduserPageTest");
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
