package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
import org.testng.Reporter;
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

public class EW_82 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_82() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Validating_Contacts");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		//baseurl = super.getTestBaseUrl();
		//System.out.println("inside before class" + baseurl);
	}

	@Test
	public void validate_contacts() throws Exception {
		test = extent.startTest("Validating_Contacts");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}
		
		cmf.VzLogout(driver);		
		//driver.get(BaseUrl);
		driver.get("http://knowledge.ebiz.verizon.com/vzknowledge/BackDoorlogin.portal?test=true");
		driver.findElement(By.xpath("//input[@id='enterpriseId']")).sendKeys("0819225237");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("kms _force");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		/*SignInPage.UserID(driver, extent, test).sendKeys(feedback_user);
		SignInPage.Password(driver, extent, test).sendKeys(feedback_pass);
		SignInPage.btn_SignOn(driver, extent, test).click();
		cmf.alert(driver);*/
		cmf.Processing(driver);
		cmf.clkElement(driver, EndUser.clk_contacts, "Contacts", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_add_contact);
		cmf.send_data(driver, EndUser.contact_search_box, Contact_name, extent, test);
		cmf.sleep(3000);
		cmf.clkElement(driver, EndUser.clk_contact_find, "Find", extent, test);
		cmf.wait_page_load(driver, "VZKnowledge - Contacts");
		cmf.sleep(3000);
		if (cmf.existsElement(EndUser.chk_noup_contact, driver) == true){
		//if (!driver.findElement(By.xpath(EndUser.chk_contact_name)).getText().equalsIgnoreCase(Contact_name)) {
			System.out.println("Contact name "+Contact_name+" not found for the user account "+feedback_user);
			Log.info("Contact name "+Contact_name+" not found for the user account "+feedback_user);
			test.log(LogStatus.PASS, "Contact", "Contact name "+Contact_name+" not found for the user account "+feedback_user);
		} else {
			System.out.println("Newly created contact "+Contact_name+" is appeared for the user account "+feedback_user);
			Log.info("Newly created contact "+Contact_name+" is appeared for the user account "+feedback_user);
			test.log(LogStatus.FAIL, "Contact", "Newly created contact "+Contact_name+" is appeared for the user account "+feedback_user);
			Reporter.log("Newly created contact "+Contact_name+" is appeared for the user account "+feedback_user);
			throw new Exception("Newly created contact "+Contact_name+" is appeared for the user account "+feedback_user);
		}
	}

	@AfterMethod
	public void teardown() {
		Log.info("VzKnowledge - AfterClass() method invoked...");
		WebDriver driver = CommonFunctions.driver;
//		cmf.VzLogout(driver);
		extent.endTest(test);
		extent.flush();
	}
}
