package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.End_User_Page.RightHandNav;
import com.verizon.cao.selenium.End_User_Page.MiddlePage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_81 extends SetupBase implements Constants{
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	RightHandNav righthand = new RightHandNav();
	MiddlePage midpage = new MiddlePage();
	private WebElement element;

	public EW_81() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Calender");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
/*		baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void access() throws Exception {
		test = extent.startTest("Calender");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}
		/*SignInPage.UserID(driver, extent, test).sendKeys(Username);
		SignInPage.Password(driver, extent, test).sendKeys(Password);
		SignInPage.btn_SignOn(driver, extent, test).click();
		cmf.alert(driver);
		cmf.Processing(driver);*/
		element = RightHandNav.cal_allevent(driver,EndUser.clk_cal_alleve,EndUser.chk_noup_alleve,EndUser.chk_cal_title_alleve,extent, test);
		if (element.getText().contains("No recent updates are available.")){
			Log.info("All Events has no updates");
			test.log(LogStatus.INFO, "ALL Events", "All Events has no updates");
		}
		else if (element.getText().contains(calender_title)){
			Log.info("All Events has an event and title is "+calender_title);
			test.log(LogStatus.PASS, "ALL Events", "All Events has an event and title is "+calender_title+" with the hyperlink");
		}
		element = RightHandNav.cal_internal(driver,EndUser.clk_cal_internal,EndUser.chk_noup_internal,EndUser.chk_cal_title_int,extent, test);
		if (element.getText().contains("No recent updates are available.")){
			Log.info("Internal Event has no updates");
			test.log(LogStatus.INFO, "Internal", "Internal has no updates");
		}
		else if (element.getText().contains(calender_title)){
			Log.info("Internal has an event and title is "+calender_title);
			test.log(LogStatus.PASS, "Internal", "Internal has an event and title is "+calender_title+" with the hyperlink");
		}
		element = RightHandNav.cal_external(driver,EndUser.clk_cal_external,EndUser.chk_noup_external,EndUser.chk_cal_title_ext,extent, test);
		if (element.getText().contains("No recent updates are available.")){
			Log.info("External Event has no updates");
			test.log(LogStatus.INFO, "External", "External has no updates");
		}
		else if (element.getText().contains(calender_title)){
			Log.info("External has an event and title is "+calender_title);
			test.log(LogStatus.PASS, "External", "External has an event and title is "+calender_title+" with the hyperlink");
		}
		driver.navigate().refresh();
		cmf.clkElement(driver, EndUser.clk_calender, "Calender", extent, test);
		cmf.wait_page_load(driver, "VZKnowledge - CalendarList");
		cmf.sleep(4000);
		element = MiddlePage.calender_tool(driver,EndUser.calender_noup,EndUser.calender_title,extent, test);
		if (element.getText().contains("No recent updates are available.")){
			Log.info("Calender has no Events so it dispalys No recent updates are available");
			test.log(LogStatus.INFO, "Calender", "Calender has no Events so it dispalys No recent updates are available");
		}
		else if (element.getText().contains(calender_title)){
			Log.info("Calender has an event and title is "+calender_title);
			test.log(LogStatus.PASS, "Calender", "Calender has an event and title is "+calender_title);
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
