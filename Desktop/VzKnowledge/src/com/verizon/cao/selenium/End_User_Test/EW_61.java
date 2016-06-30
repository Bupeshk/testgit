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

public class EW_61 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_61() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Author_Feedback_close");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
//		baseurl = super.getTestBaseUrl();
//		System.out.println("inside before class" + baseurl);
	}

	@Test
	public void feedback_inbox() throws Exception {
		test = extent.startTest("Author_Feedback_close");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}
		cmf.VzLogout(driver);		
		driver.get(BaseUrl);
		/*SignInPage.UserID(driver, extent, test).sendKeys(Username);
		SignInPage.Password(driver, extent, test).sendKeys(Password);
		SignInPage.btn_SignOn(driver, extent, test).click();
		cmf.alert(driver);*/
		cmf.Processing(driver);
		cmf.clkElement(driver, EndUser.clk_message, "Message", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_feedback_tab);
		if (cmf.existsElement(EndUser.message_total_page, driver) == true) {
			navigate_next(driver,EndUser.message_total_page, EndUser.message_inbox_next,
					EndUser.author_feedback_cmt + feedback_author_response + "']" + EndUser.feedback_reply_detail);
		} else if (cmf.existsElement(
				EndUser.author_feedback_cmt + feedback_author_response + "']" + EndUser.feedback_reply_detail,
				driver) == true) {
			Log.info("Replied Feedback is listed with the Action REply2' and shows response from Content Owner");
			test.log(LogStatus.PASS, "Feedback",
					"Replied Feedback is listed with the Action Reply2 and shows response from Content Owner");
			close_author_feedback(driver,
					EndUser.author_feedback_cmt + feedback_author_response + "']" + EndUser.feedback_reply_detail,
					feedback_author_reason);
		} else {
			Log.info("Replied Feedback is not listed with the Action 'Reply 2'");
			test.log(LogStatus.FAIL, "Feedback", "Replied Feedback is not listed with the Action 'Reply 2'");
		}
		cmf.wait_to_element(driver, EndUser.clk_feedback_tab);
		cmf.sleep(2000);
		cmf.mouse_ie(driver, EndUser.clk_feedback_tab, "Feedback", extent, test);
		cmf.sleep(3000);
		cmf.clkElement(driver, EndUser.clk_feedback_close, "Feedback Close", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_feedback_tab);
		cmf.sleep(5000);
		if (driver.findElement(By.xpath(EndUser.chk_feedback_close_cmt)).getText().contains(feedback_author_response)) {
			Log.info("Close Feedback Comment is listed in Close item");
			test.log(LogStatus.PASS, "Feedback Comment", "Close Feedback Comment is listed in Close item");
		} else {
			Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_61");
			Log.info("Close Feedback Comment is not listed in Close item");
			test.log(LogStatus.FAIL, "Feedback Comment", "Close Feedback Comment is not listed in Close item "+test.addScreenCapture(Report_Screen_PATH+"EW_61.png"));
			Reporter.log("Close Feedback Comment is not listed in Close item");
			throw new Exception("Close Feedback Comment is not listed in Close item");
		}
	}

	public void navigate_next(WebDriver driver,String totalObj, String nextObj, String replyObj) throws Exception {
		//WebDriver driver = CommonFunctions.driver;
		int totalCount = Integer.parseInt(driver.findElement(By.xpath(totalObj)).getText());
		for (int page = 0; page < totalCount; page++) {
			if (cmf.existsElement(replyObj, driver) == true) {
				Log.info("Replied Feedback is listed with the Action Reply2' and shows response from Content Owner");
				test.log(LogStatus.PASS, "Feedback",
						"Replied Feedback is listed with the Action Reply2 and shows response from Content Owner");
				close_author_feedback(driver,
						EndUser.author_feedback_cmt + feedback_author_response + "']" + EndUser.feedback_reply_detail,
						feedback_author_reason);
				break;
			} else {
				if (cmf.existsElement(nextObj, driver) == true) {
					cmf.clkElement(driver, nextObj, "NEXT", extent, test);
					cmf.wait_to_element(driver, EndUser.clk_feedback_tab);
					Log.info("Clicked NEXT");
					test.log(LogStatus.INFO, "NEXT", "Clicked NEXT");
				} else {
					Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_61");
					Log.info("Replied Feedback is not listed with the Action 'Reply 2'");
					test.log(LogStatus.FAIL, "Feedback", "Replied Feedback is not listed with the Action 'Reply 2' "+test.addScreenCapture(Report_Screen_PATH+"EW_61.png"));
					Reporter.log("Replied Feedback is not listed with the Action 'Reply 2'");
					throw new Exception("Replied Feedback is not listed with the Action 'Reply 2'");
				}
			}
		}
	}

	public void close_author_feedback(WebDriver driver,String rep2Obj, String clsReason) {
		//WebDriver driver = CommonFunctions.driver;
		String parentWindow = driver.getWindowHandle();
		cmf.clkElement(driver, rep2Obj, "Reply 2", extent, test);
		cmf.wait_to_element(driver, EndUser.feedback_close);
		cmf.send_data(driver, EndUser.feedback_reason, clsReason, extent, test);
		cmf.sleep(1000);
		cmf.clkElement(driver, EndUser.feedback_close, "Feedback Close", extent, test);
		cmf.sleep(1000);
		cmf.clkElement(driver, EndUser.feedback_close_window, "Feedback Close", extent, test);
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
