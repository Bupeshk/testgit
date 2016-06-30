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
import com.verizon.cao.selenium.End_User_Page.HeaderPage;
import com.verizon.cao.selenium.End_User_Page.MiddlePage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_126 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	HeaderPage headpage = new HeaderPage();
	MiddlePage midpage = new MiddlePage();

	public EW_126() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Access_Request");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void access() throws Exception {
		test = extent.startTest("NetworkBG_Access_Request");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}
		cmf.VzLogout(driver);		
		//driver.get(BaseUrl);
		driver.get("http://knowledge.ebiz.verizon.com/vzknowledge/BackDoorlogin.portal?test=true");
		driver.findElement(By.xpath("//input[@id='enterpriseId']")).sendKeys("6498316705");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("kms _force");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		/*SignInPage.UserID(driver, extent, test).sendKeys(feedback_user);
		SignInPage.Password(driver, extent, test).sendKeys(feedback_pass);
		SignInPage.btn_SignOn(driver, extent, test).click();
		cmf.alert(driver);*/
		cmf.Processing(driver);
		headpage.click_profile(driver, EndUser.profile_name, EndUser.myprofile_chk, extent, test);
		String parentWindow = driver.getWindowHandle();
		cmf.clkElement(driver, EndUser.clk_end_req, "Request Access", extent, test);
		cmf.WindowHandles(driver);
		cmf.wait_to_element(driver, EndUser.clk_access_finish);
		cmf.clkElement(driver, EndUser.clk_req_role + "'" + B_Role_access + "']", B_Role_access, extent,
				test);
		cmf.clkElement(driver, EndUser.clk_role_request, "Role Request", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_access_finish);
		cmf.clkElement(driver, EndUser.clk_access_finish, "Finish", extent, test);
		cmf.sleep(2000);
		cmf.default_content(driver, parentWindow);
		cmf.clkElement(driver, EndUser.clk_home, "Home", extent, test);
		cmf.Processing(driver);
		cmf.clkElement(driver, EndUser.clk_message, "Message", extent, test);
		cmf.wait_page_load(driver, "VZKnowledge - Messages");
		cmf.clkElement(driver, EndUser.clk_access_request, "Access Request", extent, test);
		cmf.wait_page_load(driver, "VZKnowledge - Messages");
		int rowCount = driver.findElements(By.xpath(EndUser.access_table)).size();
		int Flag = 0;
		for (int i = 1; i < rowCount + 1; i++) {
			if (cmf.existsElement("//tbody//tr[" + i + "]//a[contains(text(),'" + access_user_name + "')]",
					driver) == true) {
				cmf.clkElement(driver, "//tbody//tr[" + i + "]//a[contains(text(),'View details')]", "View Details",
						extent, test);
				Flag++;
				Log.info("Newly Created access request is listed");
				test.log(LogStatus.PASS, "Access Request", "Newly Created access request listed");
			}
		}
		if (Flag == 0) {
			Log.info("Newly Created access request not listed");
			test.log(LogStatus.FAIL, "Access Request", "Newly Created access request not listed");
			throw new Exception("Newly Created access request not listed");
		}
		
		cmf.WindowHandles(driver);
		cmf.wait_to_element(driver, EndUser.access_approve);
		cmf.clkElement(driver, EndUser.access_plus, "Role", extent, test);
		cmf.sleep(2000);
		cmf.clkElement(driver, EndUser.access_role, "Access Role", extent, test);
		cmf.clkElement(driver, EndUser.access_approve, "Approve", extent, test);
		cmf.wait_to_element(driver, EndUser.access_ok);
		cmf.clkElement(driver, EndUser.access_ok, "OK", extent, test);
	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
//		cmf.VzLogout(driver);
		extent.endTest(test);
		extent.flush();
	}
}
