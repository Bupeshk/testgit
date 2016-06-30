package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
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
import com.verizon.cao.selenium.End_User_Page.RightHandNav;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_128 extends SetupBase implements Constants{
	
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	RightHandNav righthand = new RightHandNav();
	MiddlePage midpage = new MiddlePage();
	private Object baseurl;
	private WebElement element;

	public EW_128() throws Exception {
		super();
	}

	@BeforeMethod
public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Basic_Search");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
	}
@Test
public void search(){
	test = extent.startTest("Basic_Search");
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
	cmf.send_data(driver, EndUser.enter_search, "Fios tv", extent, test);
	cmf.clkElement(driver, EndUser.clk_search_vzk, "Search", extent, test);
	cmf.Processing_img(driver, EndUser.search_loading_img);
	cmf.sleep(2000);
	cmf.ClearData(driver, EndUser.clk_search_all);
	element = MiddlePage.auto_search(driver, EndUser.clk_search_all, "Fios tv", EndUser.chk_auto_search, extent, test);
	if (element != null){
		//List<WebElement> = element;
		Log.info("Auto Search is display and the count is "+element.getSize());
		test.log(LogStatus.PASS, "Auto Search", "Auto Search is display and the count is "+element.getSize());
	}
	else{
		Log.info("Auto Search is not display");
		test.log(LogStatus.FAIL, "Auto Search", "Auto Search is not display");
	}
	cmf.clkElement(driver, EndUser.clk_search_vzk1, "Search", extent, test);
	cmf.Processing_img(driver, EndUser.search_loading_img);
	element = MiddlePage.search_result(driver, EndUser.search_result, EndUser.search_noresult, "search_iframe",extent, test);
	if (element != null){
		Log.info("Search result found ");
		test.log(LogStatus.PASS, "Search Result", "Search result found ");
	}
	else if (element.getText().contains("No results were found for your query")){
		Log.info("Search result not found");
		test.log(LogStatus.INFO, "Search Result", "Search result not found and it display: No results were found for your query");
	}
	driver.switchTo().defaultContent();
	cmf.sleep(4000);
	cmf.clkElement(driver, EndUser.sel_search_within, "Search Drop Down", extent, test);
	cmf.sleep(2000);
	cmf.clkElement(driver, EndUser.sel_search_bg, "Your Business Group", extent, test);
	cmf.Processing_img(driver, EndUser.search_loading_img);
	element = MiddlePage.search_result(driver, EndUser.search_result, EndUser.search_noresult, "search_iframe",extent, test);
	if (element != null){
		Log.info("Search result found ");
		test.log(LogStatus.PASS, "Search Result", "Search result found ");
	}
	else if (element.getText().contains("No results were found for your query")){
		Log.info("Search result not found");
		test.log(LogStatus.INFO, "Search Result", "Search result not found and it display: No results were found for your query");
	}
	driver.switchTo().defaultContent();
	cmf.sleep(4000);
	cmf.clkElement(driver, EndUser.sel_search_within, "Search Drop Down", extent, test);
	cmf.sleep(2000);
	cmf.clkElement(driver, EndUser.sel_search_all, "ALL VzKnowledge", extent, test);
	cmf.Processing_img(driver, EndUser.search_loading_img);
	element = MiddlePage.search_result(driver, EndUser.search_result, EndUser.search_noresult, "search_iframe",extent, test);
	if (element != null){
		Log.info("Search result found ");
		test.log(LogStatus.PASS, "Search Result", "Search result found ");
	}
	else if (element.getText().contains("No results were found for your query")){
		Log.info("Search result not found");
		test.log(LogStatus.INFO, "Search Result", "Search result not found and it display: No results were found for your query");
	}
	driver.switchTo().defaultContent();
}

@AfterMethod
public void teardown() {
	Log.info("VzKnowledge - AfterClass() method invoked...");
//	cmf.VzLogout(driver);
	extent.endTest(test);
	extent.flush();
}
}
