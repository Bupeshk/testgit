package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
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
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_53 extends SetupBase implements Constants {

	private ExtentReports extent;
	private ExtentTest test;

	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();
	WebDriver driver = CommonFunctions.driver;
	
	public EW_53() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("My Feed Filter");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		//baseurl = super.getTestBaseUrl();
		//System.out.println("inside before class" + baseurl);
	}

	@Test
	public void chk_feed_filter() throws InterruptedException {
		WebDriver driver = CommonFunctions.driver;
		test = extent.startTest("My Feed Filter");
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> My Feed Filter.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}		
		Log.info("VzKnowledge Login Invoked");
/*		SignInPage.UserID(driver, extent, test).sendKeys(Username);
		SignInPage.Password(driver, extent, test).sendKeys(Password);
		SignInPage.btn_SignOn(driver, extent, test).click();
		cmf.alert(driver);
		cmf.Processing(driver);*/

		if (cmf.existsElement(EndUser.chk_myfeed_filter, driver) == true) {
			midpage.chk_feed_filter(driver, EndUser.chk_myfeed_filter, EndUser.chk_myfeed_list_filter, extent,
					test);
			midpage.sel_feed_filter(driver, EndUser.chk_myfeed_filter, EndUser.select_feed_filter + "'Content']",
					EndUser.chk_myfeed, EndUser.chk_noupdate, extent, test);
	        cmf.Processing(driver);
			midpage.chk_feed(driver, EndUser.chk_myfeed, EndUser.chk_myfeed_gear, EndUser.chk_noupdate, extent,
					test, Select_Bg, "Content");
			midpage.sel_feed_filter(driver, EndUser.chk_myfeed_filter,
					EndUser.select_feed_filter + "'Calendar Events']", EndUser.chk_myfeed, EndUser.chk_noupdate,
					extent, test);
			cmf.Processing(driver);
			midpage.chk_feed(driver, EndUser.chk_myfeed, EndUser.chk_myfeed_gear, EndUser.chk_noupdate, extent,
					test, Select_Bg,"Calendar Events");
		} else {
			String get_screen_path = Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_53");
			Log.info("Feed Filter is not seen in the Home Page");
			test.log(LogStatus.FAIL, "Feed Filter", "Feed Filter is not seen in the Home Page"+test.addScreenCapture(Report_Screen_PATH+"EW_53.png"));
			Reporter.log(" Feed Filter is not seen in the Home Page"+ Select_Bg);
		}
	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
		extent.endTest(test);
		extent.flush();
	}
}
