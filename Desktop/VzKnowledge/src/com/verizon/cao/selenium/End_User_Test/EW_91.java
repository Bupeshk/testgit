package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.verizon.cao.selenium.common.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.End_User_Page.MiddlePage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_91 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;

	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_91() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		// super.environmentSetUp();
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_My_Feed_List");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
//		baseurl = super.getTestBaseUrl();
//		// adminHomePage = new AdminHomePage(driver);
//		System.out.println("inside before class" + baseurl);
	}

	@Test
	public void chk_my_feed() throws Exception {
		test = extent.startTest("NetworkBG_My_Feed_List");
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
		midpage.chk_feed(driver, EndUser.chk_myfeed, EndUser.chk_myfeed_gear, EndUser.chk_noupdate, extent, test,
				Network_Bg, "Content");
		if (cmf.existsElement(EndUser.chk_myfeed_gear, driver) == true) {
			System.out.println("Action gear is diaplay in the content");
			driver.findElement(By.xpath(EndUser.chk_myfeed_gear)).click();
			midpage.chk_feed_gear(driver, EndUser.chk_myfeed_gear, EndUser.chk_myfeed_gear_details, extent, test);
			Log.info("Action gear is display");
			String parentWindow = driver.getWindowHandle();
			String con_title = CommonFunctions.getTextElement(EndUser.feed_content_title);
			String con_no = CommonFunctions.getTextElement(EndUser.feed_content_no);
			driver.findElement(By.xpath("//input[@id='SearchContent']")).click();
			System.out.println("title is "+con_title);
			System.out.println("Content number is "+con_no);
			Log.info("Content is available and the title is "+con_title+" with the document number and description "+con_no);
			test.log(LogStatus.INFO, "Content Detail Verification",
					"Content is available and the title is "+con_title+" with the document number and description "+con_no +" for the BG "+ Network_Bg);
			cmf.clkElement(driver, EndUser.feed_content_title, "Content "+con_title, extent, test);
			cmf.sleep(1000);
			cmf.WindowHandles(driver);
			cmf.sleep(8000);
			if (cmf.existsElement(EndUser.close_email, driver) == true){
				Log.info("Content title "+con_title+" is clicked and open sucessfully");
				test.log(LogStatus.INFO, "Content Open",
						"Content title "+con_title+" is clicked and open sucessfully for the BG "+ Network_Bg);
			cmf.clkElement(driver, EndUser.close_email, "Content close", extent, test);
			}
			else{
				Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_91");
				Log.info("Content title "+con_title+" is clicked and failed to open");
				test.log(LogStatus.FAIL, "Content Open",
						"Content title "+con_title+" is clicked and failed to open for the BG "+ Network_Bg + test.addScreenCapture(Report_Screen_PATH+"EW_91.png"));
				Reporter.log("Content title "+con_title+" is clicked and failed to open for the BG "+ Network_Bg);
				cmf.default_content(driver, parentWindow);
				throw new Exception("Content title "+con_title+" is clicked and failed to open for the BG "+ Network_Bg);
			}
			cmf.default_content(driver, parentWindow);
		} else {
			Log.info("Action gear is not exists. Content may alert or news or No updates in the My Feed");
			test.log(LogStatus.INFO, "Action Gear",
					"Action gear is not exists. Content may alert or news or No updates in the My Feed " + Network_Bg);

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
