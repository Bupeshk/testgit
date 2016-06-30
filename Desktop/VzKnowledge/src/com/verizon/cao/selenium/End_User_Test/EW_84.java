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
import com.verizon.cao.selenium.End_User_Page.MiddlePage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_84 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_84() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Communication_Hub");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void communication() throws Exception {
		test = extent.startTest("Communication_Hub");
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
		cmf.clkElement(driver, EndUser.clk_communication, "Communication", extent, test);
		cmf.wait_to_element(driver, EndUser.communication_wait);
		try {
		String get_content_type = driver.findElement(By.xpath(EndUser.get_first_content_type)).getText();
		String get_unread_count = driver.findElement(By.xpath(EndUser.get_content_unread_count)).getText();
		if (get_content_type != null) {
			Log.info("Content Type is " + get_content_type + " Unread count is " + get_unread_count);
			test.log(LogStatus.INFO, "Content Type",
					"Content Type is " + get_content_type + " Unread count is " + get_unread_count);
			cmf.clkElement(driver, EndUser.get_content_unread_count, "Click " + get_content_type, extent, test);
			cmf.Processing_img(driver, EndUser.chk_loading_img);
			String get_unread_title = driver.findElement(By.xpath(EndUser.clk_first_content_title)).getText();
			Log.info("First Content title is " + get_unread_title);
			test.log(LogStatus.INFO, "Content Title", "First Content title is " + get_unread_title);
			cmf.clkElement(driver, EndUser.clk_first_content_title, "Firs Content", extent, test);
			cmf.sleep(4000);
			cmf.clkElement(driver, EndUser.clk_communication, "Communication", extent, test);
			String get_unread_count1 = driver.findElement(By.xpath(EndUser.get_content_unread_count)).getText();
			cmf.wait_to_element(driver, EndUser.communication_wait);

			if (!get_unread_count.equals(get_unread_count1)) {
				System.out.println("Content count is reduced");
				Log.info("Content count is reduced");
				test.log(LogStatus.PASS, "Content Count",
						"Content count is reduced and the count is " + get_unread_count1);
			} else {
				Log.info("Content count is not reduced by one");
				test.log(LogStatus.FAIL, "Content Count",
						"After reading the Content, count is not reduced by one and the count is " + get_unread_count1);
				Reporter.log("After reading the Content, count is not reduced by one and the count is " + get_unread_count1);
				throw new Exception("After reading the Content, count is not reduced by one and the count is " + get_unread_count1);
			}
		} else {
			Log.info("No Items were listed in the Communication Hub");
			test.log(LogStatus.INFO, "Communication Hub", "No Items were listed in the Communication Hub");
			throw new Exception("No Items were listed in the Communication Hub");
		}
		}
		catch (Exception e){
			test.log(LogStatus.FAIL, "Communication Hub", "Exception occured while checking content in the Communication hub "+e);
			throw new Exception("Exception occured while checking content in the Communication hub "+e);
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
