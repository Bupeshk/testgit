package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.End_User_Page.MiddlePage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_92 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;

	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_92() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_My Feed Filter");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void chk_feed_filter() throws Exception {
		test = extent.startTest("NetworkBG_My Feed Filter");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}
		/*SignInPage.UserID(driver, extent, test).sendKeys(Username);
		SignInPage.Password(driver, extent, test).sendKeys(Password);
		SignInPage.btn_SignOn(driver, extent, test).click();
		cmf.alert(driver);*/
		if (cmf.existsElement(EndUser.chk_myfeed, driver) == true) {
			Log.info("Feeds are avilable in the BG " + Network_Bg);
			test.log(LogStatus.INFO, "My Feed", "Feeds are avilable in the BG " + Network_Bg);
		
		midpage.chk_feed_filter(driver, EndUser.chk_myfeed_filter, EndUser.chk_myfeed_list_filter, extent, test);
		midpage.sel_feed_filter(driver, EndUser.chk_myfeed_filter, EndUser.select_feed_filter + "'Content']",
				EndUser.chk_myfeed, EndUser.chk_noupdate, extent, test);
		Thread.sleep(3000);
		midpage.chk_feed(driver, EndUser.chk_myfeed, EndUser.chk_myfeed_gear, EndUser.chk_noupdate, extent, test,
				Network_Bg, "Content");
		midpage.sel_feed_filter(driver, EndUser.chk_myfeed_filter, EndUser.select_feed_filter + "'Calendar Events']",
				EndUser.chk_myfeed, EndUser.chk_noupdate, extent, test);
		Thread.sleep(3000);
		midpage.chk_feed(driver, EndUser.chk_myfeed, EndUser.chk_myfeed_gear, EndUser.chk_noupdate, extent, test,
				Network_Bg, "Calender Events");
		} else {
			Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_92");
			Log.info("No Feeds are avilable in the BG " + Network_Bg);
			test.log(LogStatus.INFO, "My Feed", "No Feeds are avilable in the BG " + Network_Bg +test.addScreenCapture(Report_Screen_PATH+"EW_92.png"));
			throw new Exception("No Feeds are avilable in the BG " + Network_Bg);
		}
	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
//		cmf.VzLogout(driver);
		extent.endTest(test);
		extent.flush();
	}
}
