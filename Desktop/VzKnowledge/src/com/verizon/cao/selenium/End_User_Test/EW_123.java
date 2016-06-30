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

public class EW_123 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_123() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_FAQ");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void frequent() throws Exception {
		test = extent.startTest("NetworkBG_FAQ");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}
		cmf.VzLogout(driver);		
		driver.get(BaseUrl);
		/*SignInPage.UserID(driver, extent, test).sendKeys(Username);
		SignInPage.Password(driver, extent, test).sendKeys(Password);
		SignInPage.btn_SignOn(driver, extent, test).click();
		cmf.alert(driver);*/
		cmf.Processing(driver);
		cmf.clkElement(driver, EndUser.clk_faq, "FAQ", extent, test);
		cmf.wait_to_element(driver, EndUser.faq_plus_minus);
		cmf.sleep(1000);
		cmf.clkElement(driver, EndUser.sel_faq_category, "FAQ Category", extent, test);
		cmf.sleep(500);
		cmf.clkElement(driver, "//label[contains(text(),'VZKnowledge Content Authoring')]", "VzKnowledge", extent,
				test);
		cmf.wait_to_element(driver, EndUser.faq_plus_minus);
		cmf.sleep(1000);
		if (driver.findElement(By.xpath(EndUser.faq_validate_category)).getText()
				.equalsIgnoreCase("VZKnowledge Content Authoring")) {
			System.out.println("Category is VZKnowledge Content Authoring");
			Log.info("VZKnowledge Content Authoringe is selected");
			test.log(LogStatus.PASS, "VzKnowledge Category",
					"Questions are relvent to the VZKnowledge Content Authoring category ");
		} else {
			System.out.println("Category is not VzKnowledge Content Authoring");
			Log.info("Category is not VzKnowledge Content Authoring");
			test.log(LogStatus.FAIL, "VzKnowledge Category", "Category is not VzKnowledge Content Authoring");
		}
		cmf.clkElement(driver, EndUser.faq_plus_minus, "Click +", extent, test);
		if (cmf.existsElement(EndUser.faq_expand_text, driver) == true) {
			System.out.println("Search Text is expanded");
			Log.info("After clicking '+' symbol text is expanded");
			test.log(LogStatus.PASS, "Click +", "After clicking '+' symbol text is expanded");
		}
		cmf.sleep(1000);
		cmf.clkElement(driver, EndUser.faq_plus_minus, "Click -", extent, test);
		cmf.sleep(1000);
		cmf.clkElement(driver, EndUser.faq_toggle, "Expand Toggle", extent, test);
		cmf.clkElement(driver, EndUser.faq_toggle, "FAQ Toggle", extent, test);
		//driver.findElement(By.xpath(EndUser.faq_toggle)).click();
		if (cmf.existsElement(EndUser.faq_expand_text, driver) == true) {
			System.out.println("After clicking expand button Search Text is expanded");
			Log.info("After clicking expand button symbol text is expanded");
			test.log(LogStatus.PASS, "Expand Toggle", "After clicking expand button symbol text is expanded");
		}
		cmf.sleep(2000);
	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
//		cmf.VzLogout(driver);
		extent.endTest(test);
		extent.flush();
	}
}
