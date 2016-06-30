package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
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

public class EW_73 extends SetupBase implements Constants{
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();
	WebDriver driver = CommonFunctions.driver;
	public EW_73() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Trending_Action");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
//		baseurl = super.getTestBaseUrl();
//		System.out.println("inside before class" + baseurl);
	}
	
	@Test
	public void trend_action(){
		test = extent.startTest("Trending_Action");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}
		cmf.clkElement(driver, EndUser.clk_trending, "Trending", extent, test);
		cmf.wait_to_element(driver, EndUser.chk_trending_section);
	
	String[] trending_section = { "MyRecentlyViewed", "My Subscriptions", "My Search History", "Top Viewed",
			"Top Rated", "Top Subscribed" };
	String parentWindow = driver.getWindowHandle();
	for (int trend = 0; trend < trending_section.length; trend++) {
		if (cmf.existsElement(EndUser.chk_trending_section, driver) == true) {
			System.out.println("Article section Found");
			Log.info("Trending article section found");
			int count = trend + 1;
			if (cmf.existsElement(EndUser.chk_all_article + "[" + count + "]" + "//h2", driver) == true) {
				if (cmf.existsElement(EndUser.chk_all_article + "[" + count + "]" + "//li[1]", driver) == true) {
					System.out.println("Trending Section " + trending_section[trend] + " is appeared with items");
					Log.info("Trending Section " + trending_section[trend] + " is appeared with items");
					test.log(LogStatus.PASS, trending_section[trend],
							"Trending Section " + trending_section[trend] + " is appeared with items");
					//cmf.clkElement(driver, EndUser.chk_all_article + "[" + count + "]" + "//li[1]//div[@class='items']/a", "Trending Action", extent, test);
					cmf.clkElement(driver, EndUser.chk_all_article + "[" + count + "]" + "//li[1]//a[@class='drop actions']", "Trending Action", extent, test);
					cmf.sleep(2000);
					cmf.clkElement(driver, EndUser.chk_all_article + "[" + count + "]" + "//li[1]//div[@class='items']/a[text()='Add to Bookmarks']", "Add Bookmark", extent, test);
					cmf.sleep(5000);
					cmf.switchChildWindow(driver, parentWindow);
					cmf.sleep(4000);
					cmf.clkElement(driver, EndUser.close_bookmark, "Close Bookmark Window", extent, test);
					cmf.sleep(1000);
					cmf.default_content(driver, parentWindow);
					cmf.clkElement(driver, EndUser.chk_all_article + "[" + count + "]" + "//li[1]//a[@class='drop actions']", "Trending Action", extent, test);
					cmf.sleep(2000);
					cmf.clkElement(driver, EndUser.chk_all_article + "[" + count + "]" + "//li[1]//div[@class='items']/a[text()='Email']", "Click Email", extent, test);
					cmf.sleep(5000);
					cmf.switchChildWindow(driver, parentWindow);
					cmf.sleep(4000);
					cmf.clkElement(driver, EndUser.close_email, "Close Email Window", extent, test);
					cmf.sleep(1000);
					cmf.default_content(driver, parentWindow);
					cmf.clkElement(driver, EndUser.chk_all_article + "[" + count + "]" + "//li[1]//a[@class='drop actions']", "Trending Action", extent, test);
					cmf.sleep(2000);
					cmf.clkElement(driver, EndUser.chk_all_article + "[" + count + "]" + "//li[1]//div[@class='items']/a[text()='Feedback']", "Click Feedback", extent, test);
					cmf.sleep(5000);
					cmf.switchChildWindow(driver, parentWindow);
					cmf.sleep(4000);
					cmf.clkElement(driver, EndUser.close_feedback, "Close Feedback Window", extent, test);
					cmf.sleep(1000);
					cmf.default_content(driver, parentWindow);
					break;
				} else {
					System.out
							.println("Trending Section " + trending_section[trend] + " is not appeared with items");
					Log.info("Trending Section " + trending_section[trend] + " is not appeared with items");
					test.log(LogStatus.INFO, trending_section[trend],
							"Trending Section " + trending_section[trend] + " is not appeared with items");
				}
			} else {
				System.out.println("Trending Section " + trending_section[trend] + " is not appeared");
				Log.info("Trending Section " + trending_section[trend] + " is not appear");
				test.log(LogStatus.INFO, trending_section[trend],
						"Trending Section " + trending_section[trend] + " is not appear");
			}
		} else {
			System.out.println("Trending article section not found");
			Log.info("Trending article section not found");
			test.log(LogStatus.INFO, "Trending", "Trending article section not found");
		}
	}
	

}
@AfterMethod
public void teardown() {
	Log.info("VzKnowledge - AfterClass() method invoked...");
//	cmf.VzLogout(driver);
	extent.endTest(test);
	extent.flush();
}
}
