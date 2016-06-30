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
import com.verizon.cao.selenium.End_User_Page.MiddlePage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_60 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();
	HeaderPage endTop = new HeaderPage();
	public EW_60() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Author_Feedback_Inbox");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
//		baseurl = super.getTestBaseUrl();
//		System.out.println("inside before class" + baseurl);
	}

	@Test
	public void feedback_inbox() throws Exception {
		test = extent.startTest("Author_Feedback_Inbox");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}
		cmf.VzLogout(driver);		
		//driver.get(BaseUrl);
		driver.get("http://knowledge.ebiz.verizon.com/vzknowledge/BackDoorlogin.portal?test=true");
		driver.findElement(By.xpath("//input[@id='enterpriseId']")).sendKeys(feedback_author_eid);
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(feedback_eid_pass);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		/*SignInPage.UserID(driver, extent, test).sendKeys(feedback_user);
		SignInPage.Password(driver, extent, test).sendKeys(feedback_pass);
		SignInPage.btn_SignOn(driver, extent, test).click();
		cmf.alert(driver);*/
		cmf.Processing(driver);
		endTop.testBg(driver, EndUser.clk_bg, EndUser.clk_ves_bg + "'" + Select_Bg + "']", Select_Bg, extent, test);
		cmf.wait_page_load(driver, "VZKnowledge - Home");
		cmf.clkElement(driver, EndUser.clk_message, "Message", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_feedback_tab);
		if (cmf.existsElement(EndUser.chk_feedback_open, driver) == true) {
			Log.info("Feedback display the open items");
			test.log(LogStatus.PASS, "Feedback", "Feedback display the Inbox items");
		} else {
			cmf.mouse_hover(driver, EndUser.clk_feedback_tab, "Feedback", extent, test);
			cmf.clkElement(driver, EndUser.clk_feedback_inbox, "Feedback Open", extent, test);
			cmf.wait_to_element(driver, EndUser.clk_feedback_tab);
			Log.info("Feedback display the open items");
			test.log(LogStatus.PASS, "Feedback", "Feedback display the Inbox items");
		}
		if (driver.findElement(By.xpath(EndUser.chk_feedback_cmt)).getText().contains(feedback_author_comment)) {
			Log.info("Newly added feedback comment is listed in the top most");
			test.log(LogStatus.PASS, "Feedback Comment", "Newly added feedback comment is listed in the top most");
			String parentWindow = driver.getWindowHandle();
			cmf.clkElement(driver, EndUser.clk_feedback_reply, "Reply 1", extent, test);
			cmf.WindowHandles(driver);
			cmf.wait_to_element(driver, EndUser.feedback_reply_close);
			String[] feedback_link = { "Reply", "Reroute", "Reply & Close Feedback", "Close Feedback" };
			for (int i = 0; i < feedback_link.length; i++) {
				if (cmf.existsElement("//a[@title='" + feedback_link[i] + "']", driver) == true) {
					Log.info("Button " + feedback_link[i] + " is present");
					test.log(LogStatus.PASS, "Feedback Button", "Button " + feedback_link[i] + " is present");
				} else {
					Log.info("Button " + feedback_link[i] + " is not present");
					test.log(LogStatus.INFO, "Feedback Button", "Button " + feedback_link[i] + " not is present");
				}
			}
			cmf.send_data(driver, EndUser.feedback_response, feedback_author_response, extent, test);
			cmf.sleep(1000);
			cmf.clkElement(driver, EndUser.feedback_reply, "Reply Feedback", extent, test);
			cmf.sleep(2000);
			cmf.wait_to_element(driver, EndUser.feedback_close_window);
			cmf.clkElement(driver, EndUser.feedback_close_window, "Feedback Window Close", extent, test);
			cmf.sleep(2000);
			cmf.default_content(driver, parentWindow);
			// driver.navigate().refresh();
			if (cmf.existsElement(EndUser.message_total_page, driver) == true) {
				navigate_next(driver,EndUser.message_total_page, EndUser.message_inbox_next,
						EndUser.author_feedback_cmt + feedback_author_response + "']" + EndUser.feedback_action_detail);
			} else if (cmf.existsElement(
					EndUser.author_feedback_cmt + feedback_author_response + "']" + EndUser.feedback_action_detail,
					driver) == true) {
				Log.info("Replied Feedback is listed with the Action 'View Details'");
				test.log(LogStatus.PASS, "Feedback", "Replied Feedback is listed with the Action 'View Details");
			} else {
				Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_60");
				Log.info("Replied Feedback is not listed with the Action 'View Details'");
				test.log(LogStatus.FAIL, "Feedback", "Replied Feedback is not listed with the Action 'View Details' "+test.addScreenCapture(Report_Screen_PATH+"EW_60.png"));
				Reporter.log("Replied Feedback is not listed with the Action 'View Details'");
				throw new Exception("Replied Feedback is not listed with the Action 'View Details'");
			}
		} else {
			Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_60");
			Log.info("Newly added feedback comment is not listed in the top most");
			test.log(LogStatus.FAIL, "Feedback Comment", "Newly added feedback comment is not listed in the top most "+test.addScreenCapture(Report_Screen_PATH+"EW_60.png"));
			Reporter.log("Newly added feedback comment is not listed in the top most");
			throw new Exception("Newly added feedback comment is not listed in the top most");
		}
	}

	public void navigate_next(WebDriver driver,String totalObj, String nextObj, String viewObj) {
		//WebDriver driver = CommonFunctions.driver;
		int totalCount = Integer.parseInt(driver.findElement(By.xpath(totalObj)).getText());
		for (int page = 0; page < totalCount; page++) {
			if (cmf.existsElement(viewObj, driver) == true) {
				Log.info("Replied Feedback is listed with the Action 'View Details'");
				test.log(LogStatus.PASS, "Feedback", "Replied Feedback is listed with the Action 'View Details");
				break;
			} else {
				if (cmf.existsElement(nextObj, driver) == true) {
					cmf.clkElement(driver, nextObj, "NEXT", extent, test);
					cmf.wait_to_element(driver, EndUser.clk_feedback_tab);
					Log.info("Clicked NEXT");
					test.log(LogStatus.INFO, "NEXT", "Clicked NEXT");
				} else {
					Log.info("Replied Feedback is not listed with the Action 'View Details'");
					test.log(LogStatus.FAIL, "Feedback",
							"Replied Feedback is not listed with the Action 'View Details");
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