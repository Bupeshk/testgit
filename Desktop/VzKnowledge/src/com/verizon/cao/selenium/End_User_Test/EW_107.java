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
import com.verizon.cao.selenium.End_User_Page.HeaderPage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_107 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	HeaderPage endTop = new HeaderPage();

	public EW_107() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Training");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void training() throws Exception {
		test = extent.startTest("NetworkBG_Training");
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
		String parentWindow = driver.getWindowHandle();
		cmf.mouse_hover(driver, EndUser.mouse_training, "Training", extent, test);
		endTop.search_box(driver, EndUser.clk_training_search, "VZLearn", EndUser.clk_training_search_result,
				extent, test);
		cmf.mouse_hover(driver, EndUser.mouse_vzknowledge, "VZKnowledge", extent, test);
		try {
			// driver.findElement(By.xpath(EndUser.mouse_training_modules)).click();
			// cmf.mouse_hover(driver, EndUser.mouse_training, "Training",
			// extent, test);
			// cmf.mouse_hover(driver, EndUser.mouse_vzknowledge, "VZKnowledge",
			// extent, test);
			// cmf.sleep(4000);
			cmf.mouse_hover(driver, EndUser.mouse_training_modules, "Training_Modules", extent, test);
			cmf.sleep(5000);
			driver.findElement(By.linkText("Admin Training")).click();
			Log.info("Admin Training link is clicked");
			test.log(LogStatus.PASS, "Admin Training", "Admin Training link is clicked");
		} catch (Exception e) {
			Log.info("Exception occured while clicking Admin Training link " + e);
			test.log(LogStatus.FAIL, "Admin Training", "Exception occured while clicking Admin Training link " + e);
			throw new Exception("Exception occured while clicking Admin Training link " + e);
		}
		cmf.sleep(1000);
		cmf.WindowHandles(driver);
		if (driver.getCurrentUrl() != null) {
			System.out.println("Admin Training Url is " + driver.getCurrentUrl());
			Log.info("Admin Training Url is " + driver.getCurrentUrl());
			test.log(LogStatus.PASS, "Admin Training", "Admin Training Url is " + driver.getCurrentUrl());
		} else {
			System.out.println("Admin Training Url not found");
			Log.info("Admin Training Url is not found");
			test.log(LogStatus.INFO, "Admin Training", "Admin Training Url not exist");
		}
		cmf.sleep(1000);
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
