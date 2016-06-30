package com.verizon.cao.selenium.common;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.verizon.cao.selenium.admin.pages.AddMetaDataPage;
import com.verizon.cao.selenium.admin.pages.AdminCommonPages;
import com.verizon.cao.selenium.admin.pages.AdminHomePage;
import com.verizon.cao.selenium.admin.pages.ContentReadReportsPage;
import com.verizon.cao.selenium.admin.pages.EditBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageMetaDataPage;
import com.verizon.cao.selenium.admin.pages.ReportsPage;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class ReportsPageTest  extends SetupBase implements Admin,Common {

	private CommonFunctions commonFunctions;
	private String  baseurl ;
	private AdminHomePage adminHomePage;
	private ApplicationConstants constants;
	private ManageBusinessGroupsPage manageBusinessGroupsPage;
	private WebElement element;
	private WebDriverWait wait,wait1,wait2;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\ReportsPageTest.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test; 
	public ReportsPageTest() throws Exception {
		super();
	}

	@Test
	public void ReportsPageTest() throws Exception
	{
		test = ext_report.startTest("ReportsPageTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		String objectPath= lnkLeftNav_starts+"Manage Metadata"+lnkLeftNav_ends;
		System.out.println("objectPath"  + objectPath);
		Thread.sleep(5000);


		AdminHomePage.Left_NavLinks(driver, "Reports").click();
		boolean b = CommonFunctions.existsElement(driver, btnOtherReports, ext_report, test);
		if(b == false)
		{

			driver.navigate().refresh();

			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Reports").click();	

			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnOtherReports,"btnOtherReports", driver, ext_report, test);

		//Thread.sleep(5000);

		String window = driver.getWindowHandle();
		ReportsPage.OtherReports_btn(driver).click();
		Thread.sleep(3000);

		driver.switchTo().window(window);
		driver.close();
		Thread.sleep(15000);
		for ( String handle : driver.getWindowHandles()) {

			System.out.println(handle);

			driver.switchTo().window(handle);
		}
		//CommonFunctions.existsElement(driver, btnApply);
		Boolean signin = CommonFunctions.existsElement(driver, "//input[@id = 'idlogon']", ext_report, test);
		if(signin == true)
		{
			driver.navigate().refresh();
			CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnApply,"btnApply", driver, ext_report, test);
			signin = false;
		}
		if(signin == false)
			System.out.println("element found");
		else
			OBIEELogin();
	}



	public  void OBIEELogin() throws Exception

	{
		AdminCommonPages.OBIEE_UserName(driver).sendKeys(constants.UserName);
		AdminCommonPages.OBIEE_Password(driver).sendKeys(constants.Password);
		AdminCommonPages.OBIEE_SignIn(driver).click();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Thread.sleep(5000);


	}

}