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

public class EW_125 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();

	private Object baseurl;
	MiddlePage midpage = new MiddlePage();

	public EW_125() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Help");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void help_link() {
		test = extent.startTest("NetworkBG_Help");
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
		cmf.clkElement(driver, EndUser.clk_help, "Help", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_help_url);
		cmf.sleep(1000);
		String parentWindow = driver.getWindowHandle();
		cmf.clkElement(driver, EndUser.clk_help_url, "Helpdesk Url", extent, test);
		cmf.sleep(5000);
		cmf.WindowHandles(driver);
		if (driver.getCurrentUrl() != null) {
			System.out.println("Helpdesk Url is " + driver.getCurrentUrl());
			Log.info("Helpdesk Url is " + driver.getCurrentUrl());
			test.log(LogStatus.PASS, "Helpdesk Url", "Helpdesk Url is " + driver.getCurrentUrl());
			driver.close();
		} else {
			System.out.println("Helpdesk Url not found");
			Log.info("Helpdesk Url not found or it may not be open");
			test.log(LogStatus.INFO, "HelpDesk URL", "Helpdesk Url not found or it may not be open");
			driver.close();
		}
		cmf.sleep(1000);
		cmf.default_content(driver, parentWindow);
	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
//		cmf.VzLogout(driver);
		extent.endTest(test);
		extent.flush();
	}
}
