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

@SuppressWarnings("all")
public class EW_93 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();
	private String drop_action;
	private String action_gear;
	private CharSequence Content_Title;

	public EW_93() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Taxonomy");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
	/*	baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void chk_taxonomy() throws Exception {
		test = extent.startTest("Taxonomy");
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
		String get_taxonomy_name = driver.findElement(By.xpath(EndUser.clk_first_taxonomy)).getText();
		cmf.mouse_ie(driver, EndUser.clk_first_taxonomy, "Taxonomy -> "+get_taxonomy_name, extent, test);
		//cmf.mouse_hover(driver, EndUser.clk_first_taxonomy, "Taxonomy", extent, test);
		cmf.sleep(3000);
		if (cmf.existsElement(EndUser.clk_first_tax_topic, driver) == true){
			cmf.clkElement(driver, EndUser.clk_first_tax_topic, get_taxonomy_name+" first menu", extent, test);
		}
		else{
			cmf.mouse_click(driver, EndUser.clk_first_taxonomy, get_taxonomy_name, extent, test);
			//cmf.clkElement(driver, EndUser.clk_first_taxonomy, "Taxonomy", extent, test);
		}
		Thread.sleep(1000);
		cmf.wait_page_load(driver, "VZKnowledge - Content Listing");
		cmf.sleep(4000);
		if (cmf.existsElement(EndUser.chk_actions, driver) == true) {
			System.out.println("Actions is exists");
			Log.info("Action Exist");
			test.log(LogStatus.PASS, "Action", "Title Action is exist");
		}
		if (cmf.existsElement(EndUser.chk_head_title, driver) == true) {
			System.out.println("Title is exists");
			Log.info("Title Exist");
			test.log(LogStatus.PASS, "Title", "Title is exist");
		}
		if (cmf.existsElement(EndUser.chk_head_mod_date, driver) == true) {
			System.out.println("Modified Date is exists");
			Log.info("Modified date Exist");
			test.log(LogStatus.PASS, "Modified Date", "Title Modified date is exist");
		}
		if (cmf.existsElement(EndUser.get_first_con_title, driver) == true){
			drop_action = EndUser.clk_drop_actions;
			action_gear = EndUser.chk_gear_type;
			Content_Title = driver.findElement(By.xpath(EndUser.get_first_con_title)).getText();
		}
		else{
		    drop_action = EndUser.clk_drop_actions1;
			action_gear = EndUser.chk_gear_type_2;
			Content_Title = driver.findElement(By.xpath(EndUser.clk_next_content)).getText();
		}
		cmf.sleep(1000);
		String parentWindow = driver.getWindowHandle();
		//String Content_Title = driver.findElement(By.xpath(EndUser.get_first_con_title)).getText();
		cmf.clkElement(driver, drop_action, "Click Action", extent, test);
		cmf.clkElement(driver, action_gear + "[text()='Add to Bookmarks']", "Add Bookmark", extent, test);
		cmf.sleep(5000);
		cmf.switchChildWindow(driver, parentWindow);
		cmf.sleep(4000);
		cmf.clkElement(driver, EndUser.close_bookmark, "Close Bookmark", extent, test);
		cmf.sleep(2000);
		cmf.default_content(driver, parentWindow);
		cmf.sleep(2000);
		cmf.clkElement(driver, drop_action, "Click Action", extent, test);
		cmf.clkElement(driver, action_gear + "[text()='Feedback']", "Click Feedback", extent, test);
		cmf.sleep(5000);
		cmf.switchChildWindow(driver, parentWindow);
		cmf.sleep(5000);
		cmf.clkElement(driver, EndUser.close_feedback, "Close Feedback", extent, test);
		cmf.sleep(2000);
		cmf.default_content(driver, parentWindow);
		cmf.sleep(1000);
		cmf.clkElement(driver, drop_action, "Click Action", extent, test);
		cmf.clkElement(driver, action_gear + "[text()='Email']", "Click Email", extent, test);
		cmf.sleep(5000);
		cmf.switchChildWindow(driver, parentWindow);
		cmf.sleep(5000);
		cmf.wait_to_element(driver, EndUser.close_email);
		cmf.clkElement(driver, EndUser.close_email, "Close email", extent, test);
		cmf.sleep(2000);
		cmf.default_content(driver, parentWindow);
		cmf.sleep(1000);
		driver.findElement(By.xpath(EndUser.tax_find_box)).sendKeys(Content_Title);
		cmf.clkElement(driver, EndUser.tax_clk_find, "Click Find", extent, test);
		cmf.sleep(5000);
		cmf.switchChildWindow(driver, parentWindow);
		cmf.SwitchFrames(driver, "searchFrame");
		cmf.wait_to_element(driver, EndUser.tax_chk_result);
		if (cmf.existsElement(EndUser.tax_search_result, driver) == true) {
			System.out.println("Result Found");
			Log.info("Search string " + Content_Title + " Found");
			test.log(LogStatus.PASS, "Search String", "Search string " + Content_Title + " Found");
			driver.close();
		
		} else if (cmf.existsElement(EndUser.tax_nosearch_result, driver) == true) {
			Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_93");
			System.out.println("No Result Found");
			Log.info("Search string " + Content_Title + " not Found");
			test.log(LogStatus.INFO, "Search String", "Search string " + Content_Title + " not Found "+test.addScreenCapture(Report_Screen_PATH+"EW_93.png"));
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
