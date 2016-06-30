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

public class EW_98 extends SetupBase implements Constants{
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_98() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_EndUser_Author_Feedback");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}
	
	@Test
	public void feedback_inbox() throws Exception {
		test = extent.startTest("NetworkBG_EndUser_Author_Feedback");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}
		cmf.VzLogout(driver);		
		driver.get(BaseUrl);
		SignInPage.UserID(driver, extent, test).sendKeys(Username);
		SignInPage.Password(driver, extent, test).sendKeys(Password);
		SignInPage.btn_SignOn(driver, extent, test).click();
		cmf.alert(driver);
		cmf.Processing(driver);
		midpage.sel_feed_filter(driver, EndUser.chk_myfeed_filter, EndUser.select_feed_filter + "'Content']",
				EndUser.chk_myfeed, EndUser.chk_noupdate, extent, test);
		cmf.Processing(driver);
		if (cmf.existsElement(EndUser.chk_user_content + feedback_user_name + "')]" + EndUser.chk_user_content_gear,
				driver) == true) {
			Log.info("Newly added Content is listed in the My Feed");
			test.log(LogStatus.PASS, "Content", "Newly added Content is listed in the My Feed");
			cmf.clkElement(driver,
					EndUser.chk_user_content + feedback_user_name + "')]" + EndUser.chk_user_content_gear,
					"Action Gear", extent, test);
			cmf.sleep(2000);
			String parentWindow = driver.getWindowHandle();
			cmf.clkElement(driver, EndUser.chk_user_content + feedback_user_name + "')]" + EndUser.clk_gear_feedback,
					"Action -> Feedback", extent, test);
			cmf.WindowHandles(driver);
			cmf.wait_to_element(driver, EndUser.clk_feedback_submit);
			cmf.send_data(driver, EndUser.feedback_comment_box, feedback_author_comment, extent, test);
			cmf.clkElement(driver, EndUser.clk_feedback_submit, "Submit", extent, test);
			cmf.sleep(2000);
			try {
				if (driver.findElement(By.xpath(EndUser.feedback_success_msg)).getText()
						.contains("Thanks for your feedback")) {
					System.out.println("Feedback Comment successfully submitted");
					Log.info("Feedback Comment successfully submitted");
					test.log(LogStatus.PASS, "Feedback Comment", "Feedback Comment successfully submitted");
				}
			} catch (Exception e) {
				Log.info("Exception occured while getting text " + e);
				test.log(LogStatus.FAIL, "Feedback Comment", "Exception occured while getting text " + e);
				throw new Exception("Exception occured while getting text " + e);
			}
			cmf.clkElement(driver, EndUser.close_feedback, "Close", extent, test);
			cmf.default_content(driver, parentWindow);
		} else if (cmf.existsElement(EndUser.chk_noupdate, driver) == true) {
			Log.info("No Recent Updates");
			test.log(LogStatus.INFO, "Content", "My Feed shows No Recent Updates");
			throw new Exception("My Feed shows No Recent Updates");
		} else {
			Log.info("Newly added Content is not listed in the My Feed");
			test.log(LogStatus.FAIL, "Content", "Newly added Content is not listed in the My Feed");
			Reporter.log("Newly added Content is not listed in the My Feed");
			throw new Exception("Newly added Content is not listed in the My Feed");
		}
		cmf.clkElement(driver, EndUser.clk_message, "Message", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_feedback_tab);
		if (cmf.existsElement(EndUser.message_total_page, driver) == true) {
			navigate_next(driver,EndUser.message_total_page, EndUser.message_inbox_next,
					EndUser.author_feedback_cmt + feedback_author_comment + "']" + EndUser.feedback_action_detail);
		} else if (cmf.existsElement(
				EndUser.author_feedback_cmt + feedback_author_comment + "']" + EndUser.feedback_action_detail,
				driver) == true) {
			Log.info("Newly added Feedback is listed with the Action 'View Details'");
			test.log(LogStatus.PASS, "Feedback", "Newly added Feedback is listed with the Action 'View Details");
		} else {
			Log.info("Feedback is not listed with the Action 'View Details'");
			test.log(LogStatus.FAIL, "Feedback", "Feedback is not listed with the Action 'View Details");
			Reporter.log("Feedback is not listed with the Action 'View Details'");
			throw new Exception("Feedback is not listed with the Action 'View Details'");
		}
	}

	public void navigate_next(WebDriver driver,String totalObj, String nextObj, String viewObj) {
		//WebDriver driver = CommonFunctions.driver;
		int totalCount = Integer.parseInt(driver.findElement(By.xpath(totalObj)).getText());
		for (int page = 0; page < totalCount; page++) {
			if (cmf.existsElement(viewObj, driver) == true) {
				Log.info("Feedback is listed with the Action 'View Details'");
				test.log(LogStatus.PASS, "Feedback", "Feedback is listed with the Action 'View Details");
				break;
			} else {
				if (cmf.existsElement(nextObj, driver) == true) {
					cmf.clkElement(driver, nextObj, "NEXT", extent, test);
					cmf.wait_to_element(driver, EndUser.clk_feedback_tab);
					Log.info("Clicked NEXT");
					test.log(LogStatus.INFO, "NEXT", "Clicked NEXT");
				} else {
					Log.info("Feedback is not listed with the Action 'View Details'");
					test.log(LogStatus.FAIL, "Feedback", "Feedback is not listed with the Action 'View Details");
				}
			}
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
