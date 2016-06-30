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

public class EW_108 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_108() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Glossary");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void e_glossary() throws Exception {
		test = extent.startTest("NetworkBG_Glossary");
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
		driver.navigate().refresh();
		/*if (cmf.existsElement("clk_glossary", driver) == true) {
			cmf.clkElement(driver, EndUser.clk_glossary, "Glossary", extent, test);
		} else {
			driver.navigate().refresh();*/
			cmf.wait_page_load(driver, "VZKnowledge - Home");
			cmf.clkElement(driver, EndUser.clk_glossary, "Glossary", extent, test);
		//}
		cmf.wait_to_element(driver, EndUser.chk_glossary_category);
		if (cmf.existsElement(EndUser.chk_glossary_category, driver) == true) {
			System.out.println("Category drop down is appeared");
			Log.info("Category drop down is appeared");
			test.log(LogStatus.PASS, "Glossary Category", "Category drop down is appeared");
		}
		cmf.clkElement(driver, EndUser.glossary_list_k, "Filter K", extent, test);
		cmf.wait_page_load(driver, "VZKnowledge - Glossary");
		cmf.sleep(2000);
		midpage.chk_glossary_list(driver, EndUser.chk_glossary_list, extent, test);
		midpage.chk_glossary_search(driver, EndUser.chk_search_glossary, "Telnet", EndUser.find_glossary, extent,
				test);
		midpage.chk_filter_glossary(driver, EndUser.glossary_header, EndUser.chk_glossary_noitems,
				EndUser.chk_glossary_didyou, "Telnet", extent, test);
		midpage.chk_glossary_search(driver, EndUser.chk_search_glossary, "ihhuu", EndUser.find_glossary,
				extent, test);
		midpage.chk_filter_glossary(driver, EndUser.glossary_header, EndUser.chk_glossary_noitems,
				EndUser.chk_glossary_didyou, "ihhuu", extent, test);

	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
		/*cmf.VzLogout(driver);*/
		extent.endTest(test);
		extent.flush();
	}

}
