package com.verizon.cao.selenium.authoring.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.cao.selenium.authoring.pages.AuthoringContentPage;
import com.verizon.cao.selenium.authoring.pages.AuthoringDashboardPage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.LoginPageTest;
import com.verizon.cao.selenium.common.ObjectRepository.Authoring;
import com.verizon.cao.selenium.setup.SetupBase;

@Test
public class EW_175 extends SetupBase implements Authoring {

	CommonFunctions common = new CommonFunctions();
	private String  baseurl ;
	public EW_175() throws Exception {
		super();
	}
	//@BeforeSuite
	@Test
	public  void Logintest() throws Exception
	
	{
		LoginPageTest loginpage = new LoginPageTest();
		loginpage.Logintest();
		
		AuthoringContentPage.folderCalendar(driver).click();
		Thread.sleep(1000);
		
		AuthoringDashboardPage.eleCreate(driver).click();
		AuthoringContentPage.chckrole(driver).click();
		AuthoringContentPage.btncontinue(driver).click();
		AuthoringContentPage.txtboxtitle(driver).sendKeys("a");
		AuthoringContentPage.txtdescription(driver).sendKeys("a");
	
		AuthoringContentPage.selectcategory(driver).click();
		CommonFunctions.SelDropDown(selectcategory,"Employee Reminder",driver);
		AuthoringContentPage.selecttimezone(driver).click();
		CommonFunctions.SelDropDown(selecttimezone,"ADT - Atlantic Daylight Time",driver);	
		
		String get_date = common.GetCurrentSystemDate();
		AuthoringContentPage.authoring_effect_date(driver).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(AuthoringContentPage.authoring_set_date+"'"+get_date+"']")).click();
		AuthoringContentPage.authoring_valid_date(driver).click();
		Thread.sleep(1000);
		AuthoringContentPage.authoring_clk_next(driver).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(AuthoringContentPage.authoring_set_date+"'"+get_date+"']")).click();

		AuthoringContentPage.btnsave(driver).click();
		common.existsElement(driver,eleverifyCalendar);
		AuthoringContentPage.btnviewdetails(driver).click();
		
		AuthoringContentPage.folderCalendar(driver).click();
		Thread.sleep(1000);
		AuthoringContentPage.chckcontent(driver).click();
		AuthoringDashboardPage.elePublish(driver).click();
		driver.switchTo().alert().accept();
							
	}
	@BeforeClass
	public  void setUp()throws Exception {
		//super.environmentSetUp();
		baseurl = super.getTestBaseUrl();
		//adminHomePage = new AdminHomePage(driver);
		System.out.println("inside before class"  +baseurl);

	} 
	
	
	
	
}
