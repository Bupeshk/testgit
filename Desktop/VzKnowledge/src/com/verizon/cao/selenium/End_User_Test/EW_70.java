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
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_70 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_70() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Trending");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
//		baseurl = super.getTestBaseUrl();
//		System.out.println("inside before class" + baseurl);
	}

	@Test
	public void trending() {
		test = extent.startTest("Trending");
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
		cmf.clkElement(driver, EndUser.clk_trending, "Trending", extent, test);
		cmf.wait_to_element(driver, EndUser.chk_trending_section);
		String[] trending_section = { "MyRecentlyViewed", "My Subscriptions", "My Search History", "Top Viewed",
				"Top Rated", "Top Subscribed" };
		for (int trend = 0; trend < trending_section.length; trend++) {
			if (cmf.existsElement(EndUser.chk_trending_section, driver) == true) {
				System.out.println("Article section Found");
				Log.info("Trending article section found");
				int count = trend + 1;
				if (cmf.existsElement(EndUser.chk_all_article + "[" + count + "]" + "//h2", driver) == true) {
					System.out.println("Trending Section " + trending_section[trend] + " is appear");
					Log.info("Trending Section " + trending_section[trend] + " is appear");
					test.log(LogStatus.PASS, "Trending Section",
							"Trending Section " + trending_section[trend] + " is appear");
					if (cmf.existsElement(EndUser.chk_all_article + "[" + count + "]" + "//li", driver) == true) {
						System.out.println("Trending Section " + trending_section[trend] + " is appeared with items");
						Log.info("Trending Section " + trending_section[trend] + " is appeared with items");
						test.log(LogStatus.PASS, trending_section[trend],
								"Trending Section " + trending_section[trend] + " is appeared with items");
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
//		cmf.VzLogout(driver);
		extent.endTest(test);
		extent.flush();
	}
}
