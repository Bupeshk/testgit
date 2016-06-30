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

public class EW_102 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();
	private String drop_action;
	private String action_gear;
	private String get_con_title;

	public EW_102() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Bookmark_Add");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		
	}

	@Test
	public void bookmark_add() throws Exception {
		test = extent.startTest("NetworkBG_Bookmark_Add");
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
		cmf.wait_page_load(driver, "VZKnowledge - Content Listing");
		cmf.sleep(3000);
		if (cmf.existsElement(EndUser.get_first_con_title, driver) == true) {
			drop_action = EndUser.clk_drop_actions;
			action_gear = EndUser.chk_gear_type;
			get_con_title = driver.findElement(By.xpath(EndUser.get_first_con_title)).getText();
		} else {
			drop_action = EndUser.clk_drop_actions1;
			action_gear = EndUser.chk_gear_type_2;
			get_con_title = driver.findElement(By.xpath(EndUser.clk_next_content)).getText();
		}
		System.out.println("Title is " + get_con_title);
		Log.info("Clicked Content title is " + get_con_title);
		test.log(LogStatus.PASS, "Content Title", "Content title is " + get_con_title);
		cmf.clkElement(driver, drop_action, "Click Action", extent, test);
		String parentWindow = driver.getWindowHandle();
		cmf.clkElement(driver, action_gear + "[text()='Add to Bookmarks']", "Add To Bookmark", extent, test);
		cmf.sleep(4000);
		cmf.switchChildWindow(driver, parentWindow);
		midpage.add_folder(driver, EndUser.clk_vzk_bookmark, EndUser.clk_addbt_bookmark, EndUser.enter_folder_name,
				EndUser.clk_add_a_folder, extent, test);
		midpage.add_to_bookmark(driver, EndUser.edit_bookmark_title, EndUser.desc_bookmark, EndUser.add_bookmark,
				EndUser.save_msg_bookmark, EndUser.clk_ok_bookmark, EndUser.close_result_bookmark, extent, test);
		cmf.default_content(driver, parentWindow);
		cmf.wait_page_load(driver, "VZKnowledge - Content Listing");
		cmf.mouse_ie(driver, EndUser.mouse_bookmark, "Bookmark", extent, test);
		//cmf.mouse_hover(driver, EndUser.mouse_bookmark, "Bookmark", extent, test);
		cmf.send_data(driver, EndUser.search_bookmark, get_con_title, extent, test);
		//driver.findElement(By.xpath(EndUser.search_bookmark)).sendKeys(get_con_title);
		cmf.sleep(2000);
		if (cmf.existsElement(EndUser.search_result_bookmark + "'" + get_con_title + "')]", driver) == true) {
			System.out.println("Element exist");
			Log.info("Searched bookmark title is available " + get_con_title);
			test.log(LogStatus.PASS, "Bookmark Search", "Searched bookmark title is available " + get_con_title);
		} else {
			Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_102");
			System.out.println("Element not found");
			Log.info("Searched bookmark title not available " + get_con_title);
			test.log(LogStatus.PASS, "Bookmark Search", "Bookmark title not available " + get_con_title +test.addScreenCapture(Report_Screen_PATH+"EW_102.png"));
			throw new Exception("Bookmark Title not avialble while doing search");
		}
		/*cmf.clkElement(driver, EndUser.search_result_bookmark + "'" + get_con_title + "')]", "Click Bookmark",
				extent, test);
		cmf.sleep(2000);

		cmf.WindowHandles(driver);
		cmf.clkElement(driver, EndUser.close_result_bookmark, "Close Bookmark", extent, test);
		cmf.sleep(1000);*/
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
