package com.verizon.cao.selenium.End_User_Test;

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

public class EW_103 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();
	private String get_con_title;

	public EW_103() throws Exception {
		super();
	}

	@BeforeClass

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Manage_Bookmark");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void manage_book() throws Exception {
		test = extent.startTest("NetworkBG_Manage_Bookmark");
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
			get_con_title = driver.findElement(By.xpath(EndUser.get_first_con_title)).getText();
		} else {
			get_con_title = driver.findElement(By.xpath(EndUser.clk_next_content)).getText();
		}
		System.out.println("Title is " + get_con_title);
		Log.info("Clicked Content title is " + get_con_title);
		test.log(LogStatus.PASS, "Content Title", "Content title is " + get_con_title);
		cmf.mouse_ie(driver, EndUser.mouse_bookmark, "Bookmark", extent, test);
		//cmf.mouse_hover(driver, EndUser.mouse_bookmark, "Bookmark", extent, test);
		try {
			cmf.sleep(4000);
			driver.findElement(By.linkText("Manage Bookmarks")).click();
			Log.info("Manage Bookmark Clicked");
			test.log(LogStatus.PASS, "Manage Bookamrk", "Manage Bookmark clicked successfully");
		} catch (Exception e) {
			Log.info("Manage Bookmark failed to click " + e);
			test.log(LogStatus.FAIL, "Manage Bookamrk", "Manage Bookmark failed to click " + e);
			throw new Exception("Manage Bookmark failed to click " + e);
		}
		cmf.wait_to_element(driver, EndUser.manage_bookmark);
		cmf.sleep(3000);
		if (cmf.existsElement(EndUser.manage_bookmark_tree, driver) == true) {
			if (cmf.existsElement(EndUser.manage_first_tree, driver) == true) {
				cmf.clkElement(driver, EndUser.manage_first_tree, "Navigate", extent, test);
				if (cmf.existsElement(EndUser.manage_second_tree+"Test"+CommonFunctions.timeStamp+"')]", driver) == true) {
					//cmf.clkElement(driver, EndUser.manage_second_tree, "Navigate", extent, test);
					driver.findElement(By.xpath("//li[@class='close-last']/img")).click();
					if (cmf.existsElement(EndUser.manage_clk_title + "'" + get_con_title + "')]", driver) == true) {
						System.out.println("Able to navigate");
						Log.info("Tree Structure found and able to navigate to bookmark title");
						test.log(LogStatus.PASS, "Tree Structure",
								"Tree Structure found and able to navigate to bookmark title");
					} else {
						Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_103");
						System.out.println("Tree Structure not found");
						Log.info("Tree Structure not found and not able to navigate to bookmark title");
						test.log(LogStatus.FAIL, "Tree Structure",
								"Tree Structure not found and not able to navigate to bookmark title "+test.addScreenCapture(Report_Screen_PATH+"EW_103.png"));
						throw new Exception("Tree Structure not found and not able to navigate to bookmark title");
					}
				}
			}
		} else {
			System.out.println("No Navigation is found");
			Log.info("No bookmark folder and title");
			test.log(LogStatus.INFO, "Tree Structure", "No bookmark folder and title");
			throw new Exception("Navigation not Found ");
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
