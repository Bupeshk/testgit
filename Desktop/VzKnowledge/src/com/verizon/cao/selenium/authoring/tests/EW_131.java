package com.verizon.cao.selenium.authoring.tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.LoginPageTest;
import com.verizon.cao.selenium.common.ObjectRepository.Authoring;
import com.verizon.cao.selenium.setup.SetupBase;

@Test
public class EW_131 extends SetupBase implements Authoring {

	CommonFunctions common = new CommonFunctions();
	private String  baseurl ;
	public EW_131() throws Exception {
		super();
	}
	//@BeforeSuite
	@Test
	public  void Logintest() throws Exception
	
	{
		LoginPageTest loginpage = new LoginPageTest();
		loginpage.Logintest();
		
		common.existsElement(driver,elerecentlyedit);
		common.existsElement(driver,eleViewsummary);
		common.existsElement(driver,elemypublications);
		common.existsElement(driver,elerecentlycreate);
		common.existsElement(driver,elesavedsearch);
		common.existsElement(driver,elependingapprove);
		common.existsElement(driver,eleworkflowitem);
		common.existsElement(driver,elemyfavourites);
		
	}
	@BeforeClass
	public  void setUp()throws Exception {
		//super.environmentSetUp();
		baseurl = super.getTestBaseUrl();
		//adminHomePage = new AdminHomePage(driver);
		System.out.println("inside before class"  +baseurl);

	} 
	
	
}
