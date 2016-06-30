package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class EW_121 extends SetupBase implements Constants {
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();

	private Object baseurl;
	MiddlePage midpage = new MiddlePage();

	public EW_121() throws Exception {
		super();
	}

	@BeforeMethod

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Contacts");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}

	@Test
	public void contacts() throws Exception {
		test = extent.startTest("NetworkBG_Contacts");
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
		cmf.clkElement(driver, EndUser.clk_contacts, "Contacts", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_add_contact);
		cmf.clkElement(driver, EndUser.clk_add_contact, "Add Contacts", extent, test);
		cmf.wait_to_element(driver, EndUser.save_contact);
		cmf.sleep(1000);
		cmf.send_data(driver, EndUser.contact_name, Network_name, extent, test);
		cmf.send_data(driver, EndUser.contact_email, Network_email, extent, test);
		cmf.send_data(driver, EndUser.contact_phone, Network_phone, extent, test);
		cmf.clkElement(driver, EndUser.sel_contact_category, "Click Category", extent, test);
		cmf.sleep(500);
		WebElement elem = cmf.checkBox(EndUser.clk_contact_category + "'" + Network_category + "']", driver);
		String get_id = elem.getAttribute("for");
		driver.findElement(By.xpath("//input[@id='" + get_id + "']")).click();
		cmf.sleep(1000);
		cmf.clkElement(driver, EndUser.contact_hours, "Click Hour", extent, test);
		cmf.clkElement(driver, EndUser.save_contact, "Click Save", extent, test);
		cmf.alert(driver);
		cmf.wait_to_element(driver, EndUser.clk_add_contact);
		if (driver.findElement(By.xpath(EndUser.chk_contact_name)).getText().equalsIgnoreCase(Network_name)) {
			System.out.println("Newly created conatct appeared at first row");
			Log.info("Newly created conatct appeared at first row");
			test.log(LogStatus.PASS, "Contact",
					"Newly created conatct appeared at first row and the contact name is  " + Network_name);
		}
		else{
			System.out.println("Newly created contact "+Network_name+" is not appeared for the user account "+Username);
			Log.info("Newly created contact "+Network_name+" is not appeared for the user account "+Username);
			test.log(LogStatus.FAIL, "Contact", "Newly created contact "+Network_name+" is not appeared for the user account "+Username);
			Reporter.log("Newly created contact "+Network_name+" is not appeared for the user account "+Username);
			throw new Exception("Newly created contact "+Network_name+" is not appeared for the user account "+Username);
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
