package com.verizon.cao.selenium.End_User_Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
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
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_115 extends SetupBase implements Constants{
	private ExtentReports extent;
	private ExtentTest test;
	CommonFunctions cmf = new CommonFunctions();
	MiddlePage midpage = new MiddlePage();

	public EW_115() throws Exception {
		super();
	}

	@BeforeClass

	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Net_Check_Around_Verizon");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class" + baseurl);*/
}
	@Test
	public void chk_around_verizon(){
		test = extent.startTest("Net_Check_Around_Verizon");
		Log.info("VzKnowledge Login Invoked");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}
		cmf.clkElement(driver, "//div[@id='divCrum']/section/a", "Home", extent, test);
		cmf.Processing(driver);
		if (cmf.existsElement(EndUser.right_hand_side+"[text()='Around Verizon']", driver) == true){
			Log.info("Around Verizon Tab is available in the Right Hand Side for the BG "+Network_Bg);
			test.log(LogStatus.INFO, "Around Verizon","Around Verizon Tab is available in the Right Hand Side for the BG "+Network_Bg);
			cmf.sleep(5000);
			//int count = 5;
			for (int i = 0; i < 5; i++){
				if (cmf.existsElement(EndUser.clk_around_nav+i+"']", driver) == true){
					cmf.clkElement(driver, EndUser.clk_around_nav+i+"']", "Navigation "+i, extent, test);
					cmf.sleep(2000);
					WebElement elem = driver.findElement(By.xpath(EndUser.get_around_title));
					System.out.println("Check out");
					if (elem.getText().contains(News_title)){
						System.out.println("Check "+i);
						Log.info("Newly cretaed news "+News_title+" is display in the Around verizon for the BG "+Network_Bg);
						test.log(LogStatus.PASS, "Around Verizon","Newly cretaed news "+News_title+" is display in the Around verizon for the BG "+Network_Bg);
						break;
					}
					else if(i == 4){
						Log.info("Newly cretaed news "+News_title+" is not display in the Around verizon for the BG "+Network_Bg);
						test.log(LogStatus.INFO, "Around Verizon","Newly cretaed news "+News_title+" is not display in the Around verizon for the BG "+Network_Bg);
					}
				}
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