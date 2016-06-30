package com.verizon.cao.selenium.authoring.tests;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.cao.selenium.authoring.pages.AuthoringContentPage;
import com.verizon.cao.selenium.authoring.pages.AuthoringDashboardPage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.LoginPageTest;
import com.verizon.cao.selenium.common.ObjectRepository.Authoring;
import com.verizon.cao.selenium.setup.SetupBase;

@Test
public class EW_155 extends SetupBase implements Authoring {

	CommonFunctions common = new CommonFunctions();
	private String  baseurl ;
	public EW_155() throws Exception {
		super();
	}
	//@BeforeSuite
	@Test
	public  void Logintest() throws Exception
	
	{
		LoginPageTest loginpage = new LoginPageTest();
		loginpage.Logintest();
		
		AuthoringDashboardPage.folderAccountSupport(driver).click();
		Thread.sleep(2000);
		
		AuthoringContentPage.chckcontent(driver).click();
		
		WebElement UnArchive_mouseover = AuthoringContentPage.mouseover(driver);

	      common.Execute(driver,UnArchive_mouseover);
	      AuthoringContentPage.CheckOut(driver).click();

	}
	@BeforeClass
	public  void setUp()throws Exception {
		//super.environmentSetUp();
		baseurl = super.getTestBaseUrl();
		//adminHomePage = new AdminHomePage(driver);
		System.out.println("inside before class"  +baseurl);

	} 
	
	
}
