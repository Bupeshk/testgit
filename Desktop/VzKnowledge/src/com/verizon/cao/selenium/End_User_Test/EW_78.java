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
import com.verizon.cao.selenium.End_User_Page.HeaderPage;
import com.verizon.cao.selenium.End_User_Page.MiddlePage;
import com.verizon.cao.selenium.End_User_Page.RightHandNav;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_78 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	RightHandNav righthand = new RightHandNav();
	MiddlePage midpage = new MiddlePage();
	private WebElement element;

	public EW_78() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Checking_Profile");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
/*		baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void chk_profile() throws Exception {
		test = extent.startTest("Checking_Profile");
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
		//cmf.clkElement(driver, EndUser.profile_name, "Click Profile", extent, test);
		cmf.sleep(3000);
		cmf.clkElement(driver, EndUser.myprofile_chk, "Click My Profile", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_save_continue);
		element = HeaderPage.chk_profile_msg(driver, EndUser.chk_profile_page, extent, test);
		if (element.getText().contains("Welcome to VZ Knowledge")) {
			Log.info("Welcome Message is appeared in the Profile Page");
			test.log(LogStatus.PASS, "Welcome Message", "Welcome Message is appeared in the Profile Page");
		} else {
			Log.info("Welcome Message is not dispaly in the Profile Page");
			test.log(LogStatus.FAIL, "Welcome Message", "Welcome Message is not dispaly in the Profile Page");
			throw new Exception("Welcome Message is appeared in the Profile Page");
		}
		element = HeaderPage.chk_box_subs(driver, EndUser.chk_subscriptions, extent, test);
		if (element != null) {
			Log.info("Checkbox is available with message 'Set your subscriptions to match your profile selections'");
			test.log(LogStatus.PASS, "Checkbox Subscriptions",
					"Checkbox is available with message 'Set your subscriptions to match your profile selections'");
		} else {
			Log.info("Check box is not available");
			test.log(LogStatus.FAIL, "Checkbox Subscriptions", "Check box is not available");
			throw new Exception("Check box is not available");
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
