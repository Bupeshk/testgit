package com.verizon.cao.selenium.End_User_Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_55 extends SetupBase implements Constants {

	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_55() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Content_details");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		// baseurl = super.getTestBaseUrl();
		// System.out.println("inside before class" + baseurl);
	}

	@Test
	public void chk_content_list() throws Exception {
		test = extent.startTest("Content_details");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (!CommonFunctions.executeTestCase) {
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.",
					"Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");
		}
		/*
		 * SignInPage.UserID(driver, extent, test).sendKeys(Username);
		 * SignInPage.Password(driver, extent, test).sendKeys(Password);
		 * SignInPage.btn_SignOn(driver, extent, test).click();
		 * cmf.alert(driver); cmf.Processing(driver);
		 */
		String get_taxonomy_name = driver.findElement(By.xpath(EndUser.clk_first_taxonomy)).getText();
		cmf.mouse_ie(driver, EndUser.clk_first_taxonomy, "Taxonomy ->"+get_taxonomy_name, extent, test);
		//cmf.mouse_hover(driver, EndUser.clk_first_taxonomy, "Taxonomy", extent, test);
		cmf.sleep(3000);
		if (cmf.existsElement(EndUser.clk_first_tax_topic, driver) == true) {
			cmf.clkElement(driver, EndUser.clk_first_tax_topic, get_taxonomy_name+" first menu", extent, test);
		} else {
			cmf.clkElement(driver, EndUser.clk_first_taxonomy, get_taxonomy_name, extent, test);
		}
		// cmf.clkElement(driver, EndUser.clk_first_tax_topic, "Taxonomy",
		// extent, test);
		cmf.wait_to_element(driver, EndUser.clk_first_content);
		cmf.sleep(1000);
		String get_con_title = driver.findElement(By.xpath(EndUser.clk_first_content)).getText();
		Log.info("Clicked Content title is " + get_con_title);
		test.log(LogStatus.PASS, "Content Title", "Content title is " + get_con_title);
		String parentWindow = driver.getWindowHandle();
		if (cmf.existsElement(EndUser.chk_content_type, driver) == false) {
			cmf.clkElement(driver, EndUser.clk_first_content, "Content", extent, test);
			cmf.wait_to_element(driver, EndUser.chk_content_submit);
			cmf.sleep(1000);
			midpage.chk_breadcrumb(driver, EndUser.chk_breadcrumb, get_con_title, get_taxonomy_name, extent, test);
			midpage.content_detail(driver, EndUser.chk_content_owner, EndUser.chk_content_modified,
					EndUser.chk_content_rate, EndUser.chk_search_con, extent, test);
			cmf.clkElement(driver, EndUser.clk_content_expand, "Content Indentifiers", extent, test);
			cmf.sleep(1000);
			if (cmf.existsElement(EndUser.chk_content_expand, driver) == true) {
				Log.info("Content Expanded");
				test.log(LogStatus.PASS, "Content Expand", "After clicking Content Identifier Content expanded");
			}
			cmf.send_data(driver, EndUser.chk_content_comment, "Test Comment", extent, test);
			cmf.clkElement(driver, EndUser.chk_content_submit, "Submit", extent, test);
			cmf.sleep(1000);
			if (driver.findElement(By.xpath(EndUser.chk_comment_msg)).getText()
					.equalsIgnoreCase("Thanks for your comment! It has been submitted for moderation!")) {
				Log.info("Successfully Commented");
				test.log(LogStatus.PASS, "Comment", "Successfully Commented");
			}
		} else {
			cmf.clkElement(driver, EndUser.clk_first_content, "Content", extent, test);
			cmf.sleep(5000);
			if (cmf.chkChildWindow(driver, parentWindow) == true){
			
			cmf.sleep(2000);
			Robot rb =new Robot();
			Thread.sleep(4000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			cmf.WindowHandles(driver);
			cmf.sleep(2000);
			driver.close();
			System.out.println("Content type may be 'PDF'");
			Log.info("Content type may be 'PDF'");
			test.log(LogStatus.INFO, "Content Type", "The Content '"+get_con_title+"' may be 'PDF'");
			}
			else{
				cmf.sleep(4000);
			cmf.suppress_window(extent, test);
			System.out.println("Content type may be 'EXCEL' or 'DOC'");
			Log.info("Content type may be 'Excel' or 'DOC'");
			test.log(LogStatus.INFO, "Content Type", "The Content '"+get_con_title+"' may be 'Excel' or 'DOC'");
		}
		}
		cmf.default_content(driver, parentWindow);
	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
		// cmf.VzLogout(driver);
		extent.endTest(test);
		extent.flush();
	}
}
