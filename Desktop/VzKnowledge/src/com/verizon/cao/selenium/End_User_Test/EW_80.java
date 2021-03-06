package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class EW_80 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_80() throws Exception {
		super();
	}

	@BeforeClass

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Customize_Sunscriptions");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
	/*	baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void custom_profile() {
		test = extent.startTest("Customize_Sunscriptions");
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
		cmf.clkElement(driver, EndUser.profile_name, "Click Profile", extent, test);
		cmf.sleep(3000);
		cmf.clkElement(driver, EndUser.myprofile_chk, "Click My Profile", extent, test);
		int count = 0;
		cmf.wait_to_element(driver, EndUser.clk_customize_subs);
		cmf.clkElement(driver, EndUser.clk_customize_subs, "Click Customize Subscriptions", extent, test);
		cmf.wait_to_element(driver, EndUser.custom_role);
		do {
			cmf.clkElement(driver, EndUser.custom_role, "Role", extent, test);
			chk_element(driver,EndUser.select_custom_role,EndUser.custom_role_obj);
			cmf.clkElement(driver, EndUser.custom_region, "Role", extent, test);
			chk_element(driver,EndUser.select_custom_region,EndUser.custom_region_obj);
			cmf.clkElement(driver, EndUser.custom_selection, "Custom Selection", extent, test);
			String parentWindow = driver.getWindowHandle();
			cmf.clkElement(driver, EndUser.clk_save_continue, "Save and Continue", extent, test);
			cmf.sleep(2000);
			cmf.WindowHandles(driver);
			cmf.wait_to_element(driver, EndUser.clk_continue_page);
			for (int n = 0; n < EndUser.select_custom_role.length; n++) {
				if (cmf.existsElement("//li[contains(text(),'" + EndUser.select_custom_role[n] + "')]",
						driver) == true) {
					cmf.clkElement(driver, EndUser.clk_continue_page, "Continue Home Page", extent, test);
					System.out.println("Continue Page clicked");
					Log.info("Continue Page window displays the selected role and region");
					test.log(LogStatus.PASS, "Continue Page",
							"Continue Page window displays the selected role and region");
					count++;
					break;
				} else {
					System.out.println("Role and Region not selected");
					cmf.clkElement(driver, EndUser.close_continue_page, "Close Home Page", extent, test);
				}
			}
			System.out.println("Success");
			cmf.default_content(driver, parentWindow);
			cmf.sleep(2000);
		} while (count < 1);
		cmf.Processing(driver);
		/*cmf.clkElement(driver, EndUser.clk_role, "Click Role", extent, test);
		for (int m = 0; m < EndUser.select_custom_role.length; m++) {
			if (cmf.existsElement(EndUser.chk_role_items + "'" + EndUser.select_custom_role[m] + "')]",
					driver) == true) {

				System.out.println("Role " + EndUser.select_custom_role[m] + " is availbale in the Role drop down");
				Log.info("Role " + EndUser.select_custom_role[m] + " is availbale in the Role drop down");
				test.log(LogStatus.PASS, "Role",
						"Role " + EndUser.select_custom_role[m] + " is availbale in the Role drop down");
				cmf.sleep(500);
			}

		}*/
	}
	
	public void chk_element(WebDriver driver,String[] selObj, String cusObj){
		for (int K = 0; K < selObj.length; K++) {
			WebElement elem = cmf.checkBox(cusObj + "'" + selObj[K] + "']",
					driver);
			if (!elem.isDisplayed()){
				((JavascriptExecutor) driver).executeScript(
		                "arguments[0].scrollIntoView();", elem);
			}
			if (elem.getAttribute("checked") == null) {
				cmf.clkElement(driver, cusObj + "'" + selObj[K] + "']",
						selObj[K], extent, test);
				Log.info("Element " + selObj[K] + " checked");
				test.log(LogStatus.PASS, "Region", "Element " + selObj[K] + " checked");
				cmf.sleep(500);
			} else {
				System.out.println("Element " + EndUser.custom_region_obj + "'" + selObj[K]
						+ "']" + " already checked");
				Log.info("Element " + selObj[K] + " already checked");
				test.log(LogStatus.INFO, "Region",
						"Element " + selObj[K] + " already checked");
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
