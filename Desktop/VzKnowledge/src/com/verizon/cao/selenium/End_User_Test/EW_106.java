package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.End_User_Page.HeaderPage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_106 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	HeaderPage endTop = new HeaderPage();

	public EW_106() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Reference");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void reference() throws Exception {
		test = extent.startTest("NetworkBG_Reference");
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
		cmf.mouse_ie(driver, EndUser.mouse_reference, "Reference", extent, test);
		//cmf.mouse_hover(driver, EndUser.mouse_reference, "Reference", extent, test);
		endTop.search_box(driver, EndUser.clk_reference_serach, "Verizon Customer", EndUser.clk_reference_serach_result,
				extent, test);
		cmf.mouse_ie(driver, EndUser.chk_reference_tab_external, "Reference->External", extent, test);
		if (cmf.existsElement(EndUser.chk_reference_tab_external, driver) == true) {
			System.out.println("External Sites tab is display");
			if (cmf.existsElement(EndUser.chk_ref_external_link, driver) == true) {
				System.out.println("External Sites tab has link");
				Log.info("External Sites tab clicked and it display some links");
				test.log(LogStatus.PASS, "External Sites",
						"External Sites tab clicked and it display some links in BG " + Network_Bg);
			} else {
				Log.info("External Sites tab clicked but no links");
				test.log(LogStatus.INFO, "External Sites",
						"External Sites tab clicked but no links in BG " + Network_Bg);
			}
		} else {
			Log.info("External Sites tab not exists in BG " + Network_Bg);
			test.log(LogStatus.INFO, "External Sites", "External Sites tab not exists in BG " + Network_Bg);
		}
		cmf.sleep(2000);
		cmf.mouse_ie(driver, EndUser.mouse_reference, "Reference", extent, test);
		if (cmf.existsElement(EndUser.chk_reference_tab_verizon, driver) == true) {
			System.out.println("Verizon Sites tab is display");
			driver.findElement(By.xpath(EndUser.chk_reference_tab_verizon)).click();
			if (cmf.existsElement(EndUser.chk_ref_verizon_link, driver) == true) {
				System.out.println("Verizon Sites tab has link");
				Log.info("Verizon Sites tab clicked and it display some links");
				test.log(LogStatus.PASS, "Verizon Sites",
						"Verizon Sites tab clicked and it display some links in BG " + Network_Bg);
			} else {
				Log.info("Verizon Sites tab clicked but no links");
				test.log(LogStatus.INFO, "Verizon Sites",
						"External Sites tab clicked but no links in BG " + Network_Bg);
			}
		} else {
			Log.info("Verizon Sites tab not exists in BG " + Network_Bg);
			test.log(LogStatus.INFO, "Verizon Sites", "Verizon Sites tab not exists in BG " + Network_Bg);
		}
		String parentWindow = driver.getWindowHandle();
		try {
		driver.findElement(By.linkText(net_ref_link1)).click();
		cmf.sleep(1000);
		driver.findElement(By.linkText(net_ref_link2)).click();
		} catch (Exception e) {
			Log.info("Exception occured on clicking "+net_ref_link2+ e);
			test.log(LogStatus.FAIL, "Absense Tracker",
					"Exception occured on clicking "+net_ref_link2+ e);
			Reporter.log("Exception occured on clicking "+net_ref_link2+ e);
			throw new Exception("Exception occured on clicking Absense Tracker link in Verizon Site Tab " + e);
		}
		cmf.sleep(1000);
		cmf.switchChildWindow(driver, parentWindow);
		if (driver.getCurrentUrl() != null) {
			System.out.println("Link " + net_ref_link2 + " url is " + driver.getCurrentUrl());
			Log.info("Link " + net_ref_link2 + " url is " + driver.getCurrentUrl());
			test.log(LogStatus.PASS, net_ref_link2, "Link " + net_ref_link2 + " url is " + driver.getCurrentUrl());
		} else {
			System.out.println("Link " + net_ref_link2 + "Url not found");
			Log.info("Link " + net_ref_link2 + "Url not found");
			test.log(LogStatus.INFO, net_ref_link2, "Link " + net_ref_link2 + "Url not found");
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
