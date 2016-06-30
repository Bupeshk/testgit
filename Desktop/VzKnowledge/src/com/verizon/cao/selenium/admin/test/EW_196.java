package com.verizon.cao.selenium.admin.test;


import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.admin.pages.AddMetaDataPage;
import com.verizon.cao.selenium.admin.pages.AdminCommonPages;
import com.verizon.cao.selenium.admin.pages.AdminHomePage;
import com.verizon.cao.selenium.admin.pages.EditBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageBusinessGroupsPage;
import com.verizon.cao.selenium.admin.pages.ManageMetaDataPage;
import com.verizon.cao.selenium.common.AdminHomPageTest;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Ext_Report;
import com.verizon.cao.selenium.common.ApplicationConstants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.*;
import com.verizon.cao.selenium.setup.SetupBase;

public class EW_196  extends SetupBase implements Admin,Common {

	private CommonFunctions commonFunctions;
	private String  baseurl ;
	private AdminHomePage adminHomePage;
	private ManageBusinessGroupsPage manageBusinessGroupsPage;
	private WebElement element;
	//public static ExtentReports ext_report = new ExtentReports(ApplicationConstants.REPORT_PATH + "\\EW_196.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentReports extent;
	private ExtentTest test; 
	public EW_196() throws Exception {
		super();
	}

	@Test
	public void ManageBizGroups() throws Exception
	{
		test = extent.startTest("ManageBusinessGroupsTest");
		WebDriver driver = CommonFunctions.driver;
		if (! CommonFunctions.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as error encountered during login.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> Login Existing User.");
			throw new SkipException("Skipping the test case as error encountered during login.");			
		}
		AdminHomPageTest adminTest = new AdminHomPageTest();
		adminTest.AdminHome(driver);
		CommonFunctions.writeConsole(driver.getTitle());
		Thread.sleep(5000);
		AdminHomePage.Left_NavLinks(driver,"Manage Business Group").click();
		boolean b = CommonFunctions.verifyElementPresentWebdriver(attributeName_xpath, btnAddNew_Business_Groups, btnAddNew_Business_Groups, driver);
		if(b == false)
		{

			driver.navigate().refresh();

			Thread.sleep(10000);
			AdminHomePage.Left_NavLinks(driver, "Manage Business Group").click();	

			Thread.sleep(10000);
		}
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, btnAddNew_Business_Groups,"btnAddNew_Business_Groups", driver, extent, test);
		CommonFunctions.getTableHeaders("BusinessGroup",driver, extent, test);
		AdminCommonPages.Action_Links(driver, ApplicationConstants.Manage_Business_group_Name, "Edit").click();
		Thread.sleep(10000);
		CommonFunctions.waitForElementPresentWebdriver(attributeName_xpath, ClickBizStatusDropDown, ClickBizStatusDropDown, driver, extent, test);
		element = EditBusinessGroupsPage.DisplayName_txt(driver);
		CommonFunctions.ClearTextBoxAndSendKeys(driver, element, ApplicationConstants.BizGroups_Display_Name);
		element = EditBusinessGroupsPage.Discription_txt(driver);
		CommonFunctions.ClearTextBoxAndSendKeys(driver, element, ApplicationConstants.BizGroups_Discription);
		driver.findElement(By.xpath(ClickBizStatusDropDown)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='ddcl-busstatus-ddw']//label[text() = 'InActive']")).click();
		CommonFunctions.scrollingToBottomOfPage(driver);
		//CommonFunctions.SelDropDown(lstBusiness_Status,"Active",driver);
		boolean c =CommonFunctions.existsElement(driver,lblNo_Groups_Found, extent, test);
		if(c == false )
		{
			List<WebElement> elements = driver.findElements(By.xpath("//div[@id='addgroup']//tr//td"));
			for(int i =1;i<=elements.size();i++)
			{
				element = driver.findElement(By.xpath("//div[@id='addgroup']//tr["+i+"]//td"));
				if(element.getText().contains(ApplicationConstants.BizGroups_AvaialbleGroups))
				{
					driver.findElement(By.xpath("//div[@id='addgroup']//tr["+i+"]//td//input[@type = 'checkbox']")).click();
					///element.click();
				}
				Thread.sleep(5000);
			}
		}
		element = EditBusinessGroupsPage.Next_btn(driver);
		CommonFunctions.clickElementWebDriver(driver, element, "next button", extent, test);
		/*Click on Manage System Roles link */
		element = EditBusinessGroupsPage.Tabs_link(driver, ApplicationConstants.BizGroups_TabManageSystemRoles);
		CommonFunctions.clickElementWebDriver(driver,element,"Manage System Roles", extent, test);
		Thread.sleep(5000);
		EditBusinessGroupsPage.Admin_Author_Roles_chkList(driver, "Access Admin").click();
		EditBusinessGroupsPage.PlusTree_Btn(driver, "Access Admin").click();
		EditBusinessGroupsPage.SubAdmin_SubAuthor_Roles_chkList(driver, "Access Admin", "Manage Content Types");
		EditBusinessGroupsPage.Update_AddBusinessGroups_btn(driver).click();
		Thread.sleep(10000);
		CommonFunctions.alertAccept(driver);
	
	}

	@BeforeMethod
	public  void setUp()throws Exception {
		//super.environmentSetUp();
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("ManageSiteLayOutTest");
		Log.info("BeforeClass Method Invoked");
		extent = Ext_Report.Instance("Admin");		
		
	}
	
	@AfterMethod
	public void LogOut() 
	{
		extent.endTest(test);
		extent.flush(); 	
	}
}