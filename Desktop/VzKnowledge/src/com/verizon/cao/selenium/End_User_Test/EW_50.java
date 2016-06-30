package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.End_User_Page.HeaderPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EW_50 extends SetupBase implements Constants {

	CommonFunctions cmf = new CommonFunctions();
	HeaderPage endTop = new HeaderPage();
	private ExtentReports extent;
	private ExtentTest test;
	public EW_50() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Login Existing User");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
	}

	@Test
	public void Chk_lgn() throws InterruptedException

	{
		test = extent.startTest("Login Existing User");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}		
		Log.info("VzKnowledge Login Invoked.");
		//SignInPage.UserID(driver, extent, test).sendKeys(Username);
		//SignInPage.Password(driver, extent, test).sendKeys(Password);
		//SignInPage.btn_SignOn(driver, extent, test).click();
		//cmf.alert(driver);
		cmf.Processing(driver);
		test.log(LogStatus.PASS, "Business Group",Select_Bg+" Page loaded");
		endTop.testBg(driver, EndUser.clk_bg, EndUser.clk_ves_bg + "'" + Select_Bg + "']", Select_Bg, extent, test);
	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
		extent.endTest(test);
		extent.flush();
		extent.close();
	}

}
