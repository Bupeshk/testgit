package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
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

public class EW_122 extends SetupBase implements Constants{
	
	private ExtentReports extent;
	private ExtentTest test;
CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();
	HeaderPage endTop = new HeaderPage();
	public EW_122() throws Exception {
		super();
	}
	
	@BeforeMethod
	
	public  void setUp()throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_Validating_Contacts");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class"  +baseurl);*/
}
	@Test
	public void validate_contacts() throws Exception{
		test = extent.startTest("NetworkBG_Validating_Contacts");
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
		endTop.testBg(driver, EndUser.clk_bg, EndUser.clk_ves_bg + "'" + Network_Bg + "']", Network_Bg, extent, test);
		cmf.wait_page_load(driver, "VZKnowledge - Home");
		cmf.clkElement(driver, EndUser.clk_contacts, "Contacts", extent, test);
		cmf.wait_to_element(driver, EndUser.clk_add_contact);
		cmf.send_data(driver, EndUser.contact_search_box, Network_name, extent, test);
		cmf.clkElement(driver, EndUser.clk_contact_find, "Find", extent, test);
		cmf.wait_page_load(driver, "VZKnowledge - Contacts");
		cmf.sleep(1000);
		if (cmf.existsElement(EndUser.chk_noup_contact, driver) == true){
			//if (!driver.findElement(By.xpath(EndUser.chk_contact_name)).getText().equalsIgnoreCase(Contact_name)) {
				System.out.println("Contact name "+Network_name+" not found for the user account "+feedback_user);
				Log.info("Contact name "+Network_name+" not found for the user account "+feedback_user);
				test.log(LogStatus.PASS, "Contact", "Contact name "+Network_name+" not found for the user account "+feedback_user);
			} else {
				String get_screen_path = Ext_Report.CaptureScreen(driver, Screen_PATH+"EW_122");
				System.out.println("Newly created contact "+Network_name+" is appeared for the user account "+feedback_user);
				Log.info("Newly created contact "+Network_name+" is appeared for the user account "+feedback_user);
				test.log(LogStatus.FAIL, "Contact", "Newly created contact "+Network_name+" is appeared for the user account "+feedback_user+test.addScreenCapture(get_screen_path));
				Reporter.log("Newly created contact "+Network_name+" is appeared for the user account "+feedback_user);
				throw new Exception("Newly created contact "+Network_name+" is appeared for the user account "+feedback_user);
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
