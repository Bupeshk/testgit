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

public class EW_56 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();
    HeaderPage endTop = new HeaderPage();
	public EW_56() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Enduser_Admin_Feedback");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
	}

	@Test
	public void feedback_enduser() throws Exception {
		test = extent.startTest("Enduser_Admin_Feedback");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}			
		cmf.VzLogout(driver);		
		driver.get("http://knowledge.ebiz.verizon.com/vzknowledge/BackDoorlogin.portal?test=true");
		driver.findElement(By.xpath("//input[@id='enterpriseId']")).sendKeys(feedback_admin_eid);
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(feedback_eid_pass);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		/*SignInPage.UserID(driver, extent, test).sendKeys(feedback_user);
		SignInPage.Password(driver, extent, test).sendKeys(feedback_pass);
		SignInPage.btn_SignOn(driver, extent, test).click();
		cmf.alert(driver);*/
		cmf.Processing(driver);
		endTop.testBg(driver, EndUser.clk_bg, EndUser.clk_ves_bg + "'" + Select_Bg + "']", Select_Bg, extent, test);
		cmf.wait_page_load(driver, "VZKnowledge - Home");
		String parentWindow = driver.getWindowHandle();
		cmf.clkElement(driver, EndUser.clk_feedback, "Feedback", extent, test);
		cmf.sleep(4000);
		cmf.WindowHandles(driver);
		cmf.wait_to_element(driver, EndUser.clk_feedback_submit);
		if (cmf.existsElement(EndUser.feedback_your_name, driver) == true) {
			System.out.println("Your name is: " + driver.findElement(By.xpath(EndUser.feedback_your_name)).getText());
			Log.info("Your name is: " + driver.findElement(By.xpath(EndUser.feedback_your_name)).getText());
			test.log(LogStatus.PASS, "Your Name",
					"Your name is: " + driver.findElement(By.xpath(EndUser.feedback_your_name)).getText());
		}
		if (cmf.existsElement(EndUser.feedback_your_mail, driver) == true) {
			System.out.println("Your email is: " + driver.findElement(By.xpath(EndUser.feedback_your_mail)).getText());
			Log.info("Your email is: " + driver.findElement(By.xpath(EndUser.feedback_your_mail)).getText());
			test.log(LogStatus.PASS, "Your Email",
					"Your Email is: " + driver.findElement(By.xpath(EndUser.feedback_your_mail)).getText());
		}
		if (cmf.existsElement(EndUser.feedback_content_before, driver) == true) {
			System.out.println("'Check here if you contacted us about this before' check box is exist");
			Log.info("'Check here if you contacted us about this before' check box is exist");
			test.log(LogStatus.PASS, "Check Box",
					"'Check here if you contacted us about this before' check box is exist");
		}
		if (cmf.existsElement(EndUser.feedback_urgent, driver) == true) {
			System.out.println("Check box 'Urgent' is exist");
			Log.info("Check box 'Urgent' is exist");
			test.log(LogStatus.PASS, "Check Box", "Check box 'Urgent' is exist");
		}
		cmf.send_data(driver, EndUser.feedback_comment_box, admin_feedback_cmt, extent, test);
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
			Reporter.log("Exception occured while getting text " + e);
			throw new Exception("Exception occured while getting text " + e);
		}
		cmf.clkElement(driver, EndUser.close_feedback, "Close", extent, test);
		cmf.sleep(1000);
		cmf.default_content(driver, parentWindow);
		cmf.clkElement(driver, EndUser.clk_message, "Messages", extent, test);
		cmf.wait_page_load(driver, "VZKnowledge - Messages");
		if (cmf.existsElement(EndUser.message_total_page, driver) == true) {
			navigate_next(driver,EndUser.message_total_page, EndUser.message_inbox_next,
					EndUser.author_feedback_cmt + admin_feedback_cmt + "']" + EndUser.feedback_action_detail);
		} else if (cmf.existsElement(
				EndUser.author_feedback_cmt + admin_feedback_cmt + "']" + EndUser.feedback_action_detail,
				driver) == true) {
			Log.info("Newly added Feedback is listed with the Action 'View Details'");
			test.log(LogStatus.PASS, "Feedback", "Newly added Feedback is listed with the Action 'View Details");
		} else {
			Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_56");
			Log.info("Feedback is not listed with the Action 'View Details'");
			test.log(LogStatus.FAIL, "Feedback", "Feedback is not listed with the Action 'View Details "+test.addScreenCapture(Report_Screen_PATH+"EW_56.png"));
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
