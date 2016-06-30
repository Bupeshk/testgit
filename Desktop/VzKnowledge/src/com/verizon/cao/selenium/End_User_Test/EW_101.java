package com.verizon.cao.selenium.End_User_Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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

public class EW_101 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();
	private String get_con_title;

	public EW_101() throws Exception {
		super();
	}

	@BeforeClass

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Bookmark_Search");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
/*		baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void book_search() throws Exception {
		test = extent.startTest("NetworkBG_Bookmark_Search");
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
		cmf.sleep(4000);
		if (cmf.existsElement(EndUser.get_first_con_title, driver) == true) {
			get_con_title = driver.findElement(By.xpath(EndUser.get_first_con_title)).getText();
		} else {
			get_con_title = driver.findElement(By.xpath(EndUser.clk_next_content)).getText();
		}
		System.out.println("Title is " + get_con_title);
		Log.info("Clicked Content title is " + get_con_title);
		test.log(LogStatus.PASS, "Content Title", "Content title is " + get_con_title);
		cmf.mouse_ie(driver, EndUser.mouse_bookmark, "Bookmark", extent, test);
		//cmf.mouse_hover(driver, EndUser.mouse_bookmark, "Bookmark", extent, test);
		cmf.send_data(driver, EndUser.search_bookmark, get_con_title, extent, test);
		if (cmf.existsElement(EndUser.search_result_bookmark + "'" + get_con_title + "')]", driver) == true) {
			System.out.println("Element exist");
			Log.info("Searched bookmark title found");
			test.log(LogStatus.PASS, "Search Bookmark", "Searched bookmark title found");
		} else {
			Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_101");
			System.out.println("Element not found");
			Log.info("Searched bookmark title not found");
			test.log(LogStatus.INFO, "Search Bookmark", "Searched bookmark title not found "+test.addScreenCapture(Report_Screen_PATH+"EW_101.png"));
			throw new Exception("Bookmark Title not avialble while doing search");
		}
		//if (cmf.existsElement(EndUser.chk_content_type, driver) == false) {
		String parentWindow = driver.getWindowHandle();
		boolean con_type = cmf.existsElement(EndUser.chk_content_type, driver);
		cmf.clkElement(driver, EndUser.search_result_bookmark + "'" + get_con_title + "')]", "Search Bookmark",
				extent, test);
		cmf.sleep(5000);
		if (con_type == false){
		cmf.sleep(1000);
		//cmf.WindowHandles(driver);
		cmf.switchChildWindow(driver, parentWindow);
		cmf.wait_to_element(driver, EndUser.close_result_bookmark);
		cmf.sleep(4000);
		cmf.clkElement(driver, EndUser.close_result_bookmark, "Close Bookmark", extent, test);
		cmf.sleep(1000);
		
		}
		if (cmf.chkChildWindow(driver, parentWindow) == true){
			System.out.println("PDF document");
			
			cmf.sleep(5000);
			//cmf.alert(driver);
			Robot rb =new Robot();
			Thread.sleep(4000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			cmf.sleep(3000);
			cmf.switchChildWindow(driver, parentWindow);
			driver.close();
			System.out.println("Content type may be 'PDF'");
			Log.info("Content type may be 'PDF'");
			test.log(LogStatus.INFO, "Content Type", "Content type may be 'PDF'");
			}
			else{
				cmf.sleep(4000);
			cmf.suppress_window(extent, test);
			System.out.println("Content type may be 'PDF' or 'DOC'");
			Log.info("Content type may be 'PDF' or 'COS'");
			test.log(LogStatus.INFO, "Content Type", "Content type may be 'PDF' or 'DOC'");
		}
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
