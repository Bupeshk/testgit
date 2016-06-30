package com.verizon.cao.selenium.End_User_Test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.End_User_Page.HeaderPage;
import com.verizon.cao.selenium.End_User_Page.LeftHandNav;
import com.verizon.cao.selenium.End_User_Page.MiddlePage;
import com.verizon.cao.selenium.End_User_Page.RightHandNav;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_90 extends SetupBase implements Constants {

	private ExtentReports extent;
	private ExtentTest test;

	CommonFunctions cmf = new CommonFunctions();
	LeftHandNav leftnav = new LeftHandNav();
	MiddlePage midpage = new MiddlePage();
	HeaderPage endTop = new HeaderPage();
	RightHandNav rightnav = new RightHandNav();

	public EW_90() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Login Validation User");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
//		baseurl = super.getTestBaseUrl();
//		System.out.println("inside before class" + baseurl);
	}

	@Test
	public void chk_left_nav() {
		test = extent.startTest("NetworkBG_Login_Validation");
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
		cmf.sleep(3000);
		driver.navigate().refresh();
		cmf.Processing(driver);
		leftnav.chk_content_label(driver, EndUser.chk_con_label, extent, test);
		List<WebElement> get_content = LeftHandNav.chk_content_type(driver, EndUser.left_content);
		if (get_content.size() != 0) {
			System.out.println("All Content types are available");
			Log.info("All Content types are seen below the content label");
			test.log(LogStatus.PASS, "Content Types", "All content types are display in the LHN");
		} else {
			Log.info("Content types are not available");
			test.log(LogStatus.FAIL, "Content Types",
					"Content types are not available in the business group " + Network_Bg);
		}
		leftnav.chk_tool_label(driver, EndUser.chk_tool_label, extent, test);
		List<WebElement> get_tool = LeftHandNav.chk_content_type(driver, EndUser.left_tools);
		if (get_tool.size() != 0) {
			System.out.println("Tools types are seen");
			Log.info("All Tools types are seen followed by the Content");
			test.log(LogStatus.PASS, "Tool Types", "All tool types are display in the LHN");
			// String[] chk_tool = {"Admin", "Authoring", "Calendar",
			// "Communication Hub", "Contacts", "eGlossary", "FAQ", "News"};
			for (WebElement we : get_tool) {
				System.out.println(we.getText());
				Log.info("Tool type " + we.getText() + " is display in the business group " + Network_Bg);
				test.log(LogStatus.INFO, "Tool Type",
						"Tool type " + we.getText() + " is display in the business group " + Network_Bg);
			}
		} else {
			Log.info("Tools types are not available");
			test.log(LogStatus.FAIL, "Tool Types", "Tools types are not available in the business group " + Network_Bg);
		}
		if (midpage.chk_news(driver, EndUser.chk_news_feed) == true) {
			System.out.println("News is Available");
			Log.info("News Feed is display with Yellow colour");
			test.log(LogStatus.PASS, "News", "News Feed is display with Yellow colour");
			midpage.get_news_title(driver, EndUser.chk_news_title, extent, test);
			midpage.chk_read_more(driver, EndUser.chk_news_read_more, extent, test);
		} else {
			Log.info("News Feed is not avilable");
			test.log(LogStatus.INFO, "News", "News Feed is not available in BG " + Network_Bg);
		}
		String[] menulist = { "VZKnowledge", "Reference", "Training", "Bookmarks", "Trending", "CrowdAround" };
		for (int i = 0; i < menulist.length; i++) {
			if (endTop.verifyMenu(driver, EndUser.red_tool_menu + "[text()='" + menulist[i] + "']") == true) {
				System.out.println("Menu " + menulist[i] + "is present");
				Log.info("Menu " + menulist[i] + " is available");
				test.log(LogStatus.PASS, "Red Tool Menu", "Menu " + menulist[i] + " is display");
			}
		}
		String[] right_list = { "Around Verizon", "Share With Your Customers", "Mark Your Calendar" };
		rightnav.chk_elem_right(driver, EndUser.right_hand_side, right_list, extent, test);
	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
//		cmf.VzLogout(driver);
		extent.endTest(test);
		extent.flush();
	}
}
