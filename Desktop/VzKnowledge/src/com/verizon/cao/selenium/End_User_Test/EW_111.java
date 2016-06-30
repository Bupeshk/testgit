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

public class EW_111 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_111() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Trending_section");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void trending_section() throws Exception {
		test = extent.startTest("NetworkBG_Trending_section");
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
		String[] trending_section = { "My Recently Viewed", "My Subscriptions", "My Search History", "Top Viewed",
				"Top Rated", "Top Subscribed" };
		for (int trend = 0; trend < trending_section.length; trend++) {
			cmf.mouse_ie(driver, EndUser.mouse_trending, "Trending", extent, test);
			//cmf.mouse_hover(driver, EndUser.mouse_trending, "Trending", extent, test);
			cmf.sleep(3000);
			try {
				cmf.mouse_click(driver, EndUser.mouse_trending_sections + trending_section[trend] + "']", "Trending",
						extent, test);
				//driver.findElement(By.linkText(trending_section[trend])).click();
				cmf.wait_page_load(driver, "VZKnowledge - AllTrendingsList");
				System.out.println("Trending Section " + trending_section[trend] + " is appear");
				Log.info("Trending Section " + trending_section[trend] + " display side drop down with items in the BG "
						+ Network_Bg);
				test.log(LogStatus.PASS, trending_section[trend], "Trending Section " + trending_section[trend]
						+ " display side drop down with items in the Bg " + Network_Bg);
			} catch (Exception e) {
				System.out.println("Exception occured while clicking " + trending_section[trend] + e);
				Log.info("Exception occured while clicking " + trending_section[trend] + e);
				test.log(LogStatus.INFO, trending_section[trend],
						"Exception occured while clicking " + trending_section[trend] + e);

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