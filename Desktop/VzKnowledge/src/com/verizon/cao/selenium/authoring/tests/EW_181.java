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
public class EW_181 extends SetupBase implements Authoring {

	public static ExtentReports ext_report = new ExtentReports(RepConstants.REPORT_PATH+ "\\AuthoringGlossaryCreateContentWorkflowPageTest.html", true,
			DisplayOrder.OLDEST_FIRST);
	private ExtentTest test;
	CommonFunctions common = new CommonFunctions();
	private String  baseurl ;
	public EW_181() throws Exception {
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
	test.log(LogStatus.PASS, "AuthoringGlossaryCreateContentWorkflowPageTest", "folderAccountSupport clicked successfully done");
	
		AuthoringDashboardPage.eleCreate(driver).click();
		AuthoringContentPage.chckrole(driver).click();
		AuthoringContentPage.btncontinue(driver).click();
		AuthoringContentPage.txtboxtitle(driver).sendKeys("a");
		AuthoringContentPage.txtdescription(driver).sendKeys("a");
	
		AuthoringContentPage.btnsave(driver).click();
		test.log(LogStatus.PASS, "AuthoringGlossaryCreateContentWorkflowPageTest", "btnsave clicked successfully done");
		common.existsElement(driver,eleverifyCalendar);
		AuthoringContentPage.btnviewdetails(driver).click();
		
		AuthoringContentPage.folderGlossary(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "AuthoringGlossaryCreateContentWorkflowPageTest", "folderGlossary clicked successfully done");
		AuthoringContentPage.chckcontent(driver).click();
		AuthoringDashboardPage.elePublish(driver).click();
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "AuthoringGlossaryCreateContentWorkflowPageTest", "Test case successfully done");
							
	}
	@BeforeClass
	public  void setUp()throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("AuthoringGlossaryCreateContentWorkflowPageTest");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("AuthoringGlossaryCreateContentWorkflowPageTest");
		ext_report.config().reportHeadline("-AuthoringGlossaryCreateContentWorkflowPageTest");
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
