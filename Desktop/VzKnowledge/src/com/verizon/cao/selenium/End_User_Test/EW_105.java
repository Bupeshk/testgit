package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
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

public class EW_105 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_105() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Alerts");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void alert_box() {
		test = extent.startTest("NetworkBG_Alerts");
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
		String alert_unread = get_count(EndUser.alert_unread_count);
		Log.info("Total count of recent alert is " + alert_unread);
		test.log(LogStatus.INFO, "Recent Alerts", "Total count of recent alert is " + alert_unread);
		cmf.clkElement(driver, EndUser.clk_alerts, "Alerts", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_recent_alert);
		if (!alert_unread.equals("0")) {
			if (cmf.existsElement(EndUser.alert_type, driver) == true) {
				Log.info("Recent alert has alert");
				test.log(LogStatus.PASS, "Recent Alert", "Recent alert displays alert");
				String alert_title = driver.findElement(By.xpath(EndUser.alert_title)).getText();
				String alert_type = driver.findElement(By.xpath(EndUser.alert_type)).getText();
				Log.info("Alert Title is " + alert_title + " and type is " + alert_type);
				test.log(LogStatus.PASS, "Alert Details",
						"Alert Title is " + alert_title + " and type is " + alert_type);
				String parentWindow = driver.getWindowHandle();
				cmf.clkElement(driver, EndUser.alert_title, "Alert Title", extent, test);
				cmf.sleep(8000);
				cmf.switchChildWindow(driver, parentWindow);
				//cmf.wait_to_element(driver, EndUser.alert_submit);
				cmf.clkElement(driver, EndUser.alert_close, "Alert Close", extent, test);
				cmf.sleep(2000);
				cmf.default_content(driver, parentWindow);
				cmf.clkElement(driver, EndUser.clk_alerts, "Alert", extent, test);
				cmf.wait_to_element(driver, EndUser.clk_recent_alert);
				String alter_unread = get_count(EndUser.alert_unread_count);
				if (!alert_unread.equals(alter_unread)) {
					Log.info("Alert count is reduced after reading the recent alert and count is " + alter_unread);
					test.log(LogStatus.PASS, "Alert Count",
							"Alert count is reduced after reading the recent alert and the count is " + alter_unread);
				} else {
					Log.error("Alert count is not reduced after reading the recent alert");
					test.log(LogStatus.FAIL, "Alert Count",
							"Alert count is not reduced after reading the recent alert");
				}
			} else {
				if (driver.findElement(By.xpath(EndUser.alert_no_update)).getText()
						.equalsIgnoreCase("No recent updates are available")) {
					Log.info("No Recent update alert is shown in Recent Alert Tab");
					test.log(LogStatus.INFO, "Alert", "No Recent update alert is shown in Recent Alert Tab");
				}
			}
		} else {
			if (driver.findElement(By.xpath(EndUser.alert_no_update)).getText()
					.equalsIgnoreCase("No recent updates are available")) {
				Log.info("No Recent update alert is shown in Recent Alert Tab and alert unread count is "
						+ alert_unread);
				test.log(LogStatus.INFO, "Alert",
						"No Recent update alert is shown in Recent Alert Tab and alert unread count is "
								+ alert_unread);
			}
		}

	}

	public static String get_count(String alertObj) {
		WebDriver driver = CommonFunctions.driver;
		String count = driver.findElement(By.xpath(alertObj)).getText();
		return count;

	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
//		cmf.VzLogout(driver);
		extent.endTest(test);
		extent.flush();
	}
}
