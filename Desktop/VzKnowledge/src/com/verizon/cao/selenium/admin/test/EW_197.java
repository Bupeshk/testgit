package com.verizon.cao.selenium.admin.test;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.verizon.cao.selenium.admin.pages.AddMetaDataPage;
import com.verizon.cao.selenium.admin.pages.AdminCommonPages;
import com.verizon.cao.selenium.admin.pages.AdminHomePage;
import com.verizon.cao.selenium.admin.pages.EditBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageDefaultSubscriptionPage;
import com.verizon.cao.selenium.admin.pages.ManageMetaDataPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_197  extends SetupBase implements Admin,Common {

	private CommonFunctions commonFunctions;
	private String  baseurl ;
	private AdminHomePage adminHomePage;

	private ManageDefaultSubscriptionPage manageDefaultSubscriptionPage;
	private WebElement element;
	private String[] role;
	private String[] region;
	public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_197.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test; 
	public EW_197() throws Exception {
		super();
	}

	@Test
	public void ManageDefaultSub() throws Exception
	{
		test = ext_report.startTest("ManageDefaultSubscriptionsTest");
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome();
		CommonFunctions.writeConsole(driver.getTitle());
		AdminHomePage.Left_NavLinks(driver, "Manage Default Subscriptions").click();
		boolean b = CommonFunctions.verifyElementPresentWebdriver(attributeName_xpath, btnSaveSubscriptions, btnSaveSubscriptions, driver);
		if(b == false)
		{

			driver.navigate().refresh();

			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage Default Subscriptions").click();	

			Thread.sleep(10000);
		}

		//Thread.sleep(10000);
		ManageDefaultSubscriptionPage.Role_Region_btn(driver, "Role").click();
			
		if (ApplicationConstants.RoleSubscriptions1.contains(","))
		{
			role = ApplicationConstants.RoleSubscriptions1.split(",");
			for( int i =0;i<role.length;i++)
			{

				System.out.println(role[i]+"<---->role["+i+"]");	
				ManageDefaultSubscriptionPage.Role_RegionTreeView_chkBoxes(driver, role[i]).click();
			}
		}

		List<WebElement>element1 = driver.findElements(By.xpath(lblDefault_Sub_Role));
		for(int j =1;j<element1.size();j++) 
		{
			String text = driver.findElement(By.xpath(lblDefault_Sub_Role+"["+j+"]")).getText();
			if(text.contains(role[j]))
			{
				CommonFunctions.writeConsole("found"+text+"under role section ");
			}
		}

		ManageDefaultSubscriptionPage.Role_Region_btn(driver, "Region").click();


		if (ApplicationConstants.RegionSubscriptions.contains(","))
		{
			region = ApplicationConstants.RegionSubscriptions.split(",");
			for( int i =0;i<region.length;i++)
				ManageDefaultSubscriptionPage.Role_RegionTreeView_chkBoxes(driver, region[i]).click();
		}

		List<WebElement> Region = driver.findElements(By.xpath(lblDefault_Sub_Region));
		for(int k =1;k<Region.size();k++) 
		{
			String regionText = driver.findElement(By.xpath(lblDefault_Sub_Region+"["+k+"]")).getText();
			if(regionText.contains(region[k]))
			{
				CommonFunctions.writeConsole("found "+region[k]+ " under Region section");
			}
		}

		ManageDefaultSubscriptionPage.SaveSubscriptions_btn(driver).click();
		CommonFunctions.alertAccept(driver);







	}

	@BeforeMethod
	public  void setUp()throws Exception {
		//super.environmentSetUp();
		Log.startTestCase("EW_197");
		Log.info("BeforeClass Method Invoked");
		ext_report.config().documentTitle("VzKnowledge Automation");
		ext_report.config().reportName("EW_197");
		ext_report.config().reportHeadline("-EW_197"); 
		baseurl = super.getTestBaseUrl();
		driver.manage().deleteAllCookies();
		//adminHomePage = new AdminHomePage(driver);
		System.out.println("inside before class"  +baseurl);

	}
	@AfterMethod
	public void LogOut() 
	{
		ext_report.endTest(test);
		ext_report.flush(); 	
	}
}