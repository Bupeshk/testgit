package com.verizon.cao.selenium.common;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.cao.selenium.common.ObjectRepository.Authoring;
import com.verizon.cao.selenium.setup.SetupBase;

@Test
public class SelectRegionTest extends SetupBase implements Authoring  {
	CommonFunctions common = new CommonFunctions();
	private String  baseurl ;

	public SelectRegionTest() throws Exception {
		super();
	} 
	//@BeforeSuite
	public  void selectRegionval() throws InterruptedException
	
	{

		for (String handle1 : driver.getWindowHandles()) {

			System.out.println(handle1);

			driver.switchTo().window(handle1);

		} 

	}

	@BeforeClass
	public  void setUp()throws Exception {
		//super.environmentSetUp();
		baseurl = super.getTestBaseUrl();
		//adminHomePage = new AdminHomePage(driver);
		System.out.println("inside before class"  +baseurl);

	} 

	
}
