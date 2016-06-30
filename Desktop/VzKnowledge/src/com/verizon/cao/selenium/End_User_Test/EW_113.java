package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class EW_113 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();

	private Object baseurl;
	MiddlePage midpage = new MiddlePage();

	public EW_113() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_News_Authoring");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void create_news() throws Exception {
		test = extent.startTest("NetworkBG_News_Authoring");
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
		// cmf.sleep(3000);
		// cmf.PageToLoadTimeOut(driver);
		// driver.navigate().refresh();
		cmf.Processing(driver);*/
		String parentWindow = driver.getWindowHandle();
		if (cmf.existsElement(EndUser.clk_authoring, driver) == true){
			Log.info("Authoring Exist in BG "+Network_Bg);
			test.log(LogStatus.PASS, "Authoring", "Authoring Exist in BG "+Network_Bg);
		}
		else{
			Log.info("Authoring not Exist in BG "+Network_Bg);
			test.log(LogStatus.INFO, "Authoring", "Authoring not Exist in BG "+Network_Bg);
			throw new SkipException("Skipping the test case as error encountered during login.");
		}
		cmf.clkElement(driver, EndUser.clk_authoring, "Authoring", extent, test);
		cmf.sleep(1000);
		cmf.WindowHandles(driver);
		driver.manage().window().maximize();
		cmf.wait_to_element(driver, EndUser.authoring_wait_elem);
		cmf.SelectDropDown(driver, EndUser.auth_set_bgroup, Network_Bg, extent, test);
		cmf.wait_page_load(driver, "VZKnowledgeAuthoring - Home");
		cmf.clkElement(driver, EndUser.clk_authoring_news, "Clicked News", extent, test);
		cmf.wait_to_element(driver, EndUser.authoring_wait_elem);
		cmf.clkElement(driver, EndUser.clk_authoring_create, "Clicked Create", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_authoring_continue);
		cmf.clkElement(driver, "//input[@title='" + Finance_Role_access + "']", "Select Role", extent, test);
		cmf.clkElement(driver, EndUser.clk_authoring_continue, "Clicked Continue", extent, test);
		cmf.wait_to_element(driver, EndUser.authoring_save_news);
		cmf.send_data(driver, EndUser.authoring_news_title, News_title, extent, test);
		cmf.send_data(driver, EndUser.auth_news_desc, News_desc, extent, test);
		cmf.clkElement(driver, EndUser.authoring_effect_date, "Effective Date", extent, test);
		String get_date = cmf.GetCurrentSystemDate();
		cmf.clkElement(driver, EndUser.authoring_set_date + "'" + get_date + "']", "Set Current Date", extent,
				test);
		cmf.clkElement(driver, EndUser.authoring_valid_date, "Validity Date", extent, test);
		cmf.clkElement(driver, EndUser.authoring_clk_next, "Click Next in Validity Date", extent, test);
		cmf.clkElement(driver, EndUser.authoring_set_date + "'" + get_date + "']", "Set Validity Date", extent,
				test);
		cmf.switchFrame(driver, EndUser.authoring_frame);
		cmf.sleep(3000);
		WebElement editable = driver.switchTo().activeElement();
		editable.sendKeys(News_message);
		driver.switchTo().defaultContent();
		cmf.clkElement(driver, EndUser.authoring_save_news, "Clicked Save", extent, test);
		cmf.wait_to_element(driver, EndUser.authoring_goto);
		if (cmf.existsElement(EndUser.authoring_msg_success, driver) == true) {
			if (driver.findElement(By.xpath(EndUser.authoring_msg_success)).getText()
					.contains("Your News has been successfully saved")) {
				System.out.println("News Created");
				Log.info("News Successfully Created");
				test.log(LogStatus.PASS, "News", "News Successfully Created");
			}
		}
		cmf.clkElement(driver, EndUser.authoring_goto, "Clicked GoTo", extent, test);
		cmf.clkElement(driver, EndUser.sel_authoring_news_title + "'" + News_title + "']", "Clicked GoTo", extent,
				test);
		cmf.clkElement(driver, EndUser.authoring_news_publish, "Clicked Publish", extent, test);
		cmf.sleep(1000);
		cmf.alert(driver);
		driver.close();
		cmf.default_content(driver, parentWindow);
		cmf.sleep(1000);
	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
//		cmf.VzLogout(driver);
		extent.endTest(test);
		extent.flush();
	}
}
