package com.verizon.cao.selenium.End_User_Test;

import java.util.List;

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
import com.verizon.cao.selenium.common.SignInPage;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_114 extends SetupBase implements Constants{
	
	private ExtentReports extent;
	private ExtentTest test;
CommonFunctions cmf = new CommonFunctions();
	
	private Object baseurl;
	MiddlePage midpage = new MiddlePage();
	public EW_114() throws Exception {
		super();
	}
	
	@BeforeClass
	
	public  void setUp()throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("NetworkBG_News_Validation");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("End_User");
		/*baseurl = super.getTestBaseUrl();
		System.out.println("inside before class"  +baseurl);*/
}
	@Test
	public void news_validate(){
		test = extent.startTest("NetworkBG_News_Validation");
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
		if (midpage.chk_news(driver, EndUser.chk_news_feed) == true){
			System.out.println("News is Available");
			Log.info("News Feed is display with Yellow colour");
			List<WebElement> scroll_news = driver.findElements(By.xpath(EndUser.chk_news_slide));
			for (int i=0; i<scroll_news.size(); i++){
			String title_news = midpage.get_news_title(driver, EndUser.chk_news_title,extent, test);
			if (title_news.equalsIgnoreCase(News_title)){
				System.out.println("Newly created News is Available");
				Log.info("Newly created News is Available");
				test.log(LogStatus.PASS, "News", "News created news is available and the title is "+News_title);
				break;
			}
			else{
				cmf.clkElement(driver, EndUser.chk_news_slide, "News Slide", extent, test);
				//driver.findElement(By.xpath("//section[@id='home_slide']/a[1]")).click();
			}
			}
			if (cmf.existsElement(EndUser.clk_news, driver) == true) {
				cmf.clkElement(driver, EndUser.clk_news, "Click News", extent, test);
			} else {
				driver.navigate().refresh();
				//cmf.wait_page_load(driver, "VZKnowledge - All News");
				cmf.clkElement(driver, EndUser.clk_news, "News", extent, test);
			}
			cmf.wait_to_element(driver, EndUser.chk_news_section);
			if (cmf.existsElement(EndUser.newly_created_news+"'"+News_title+"')]", driver) == true){
				System.out.println("Newly created News is Available1");
				Log.info("clicked News title and it display the details");
				test.log(LogStatus.PASS, "News", "News created news is available and the title is "+News_title);
			}
		}
		else{
			Log.info("News Feed is not available in BG "+Network_Bg);
			test.log(LogStatus.INFO, "News", "News Feed is not available in BG "+Network_Bg);
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
