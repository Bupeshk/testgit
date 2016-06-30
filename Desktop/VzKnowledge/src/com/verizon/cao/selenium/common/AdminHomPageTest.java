package com.verizon.cao.selenium.common;
import com.verizon.cao.selenium.setup.SetupBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.verizon.cao.selenium.admin.pages.AdminHomePage;


public class AdminHomPageTest extends SetupBase {
	private String baseurl;
	private AdminHomePage adminHomePage;
	private CommonFunctions commonFunctions;
	ApplicationConstants constants;

	public AdminHomPageTest() throws Exception {
		super();
	}



	public void AdminHome(WebDriver driver) throws Exception
	{

		UserLogin(driver);
		Thread.sleep(4000);
		driver.navigate().refresh();
		String window = driver.getWindowHandle();
		driver.switchTo().window(window);
		driver.close();
		for ( String handle : driver.getWindowHandles()) {

			System.out.println(handle);

			driver.switchTo().window(handle);
		}
		Thread.sleep(6000);
	}
	public  void UserLogin(WebDriver driver) throws Exception

	{
/*		LoginPage.UserID(driver).sendKeys(constants.UserName);
		LoginPage.Password(driver).sendKeys(constants.Password);
		LoginPage.btn_SignOn(driver).click();
		CommonFunctions.alertAccept(driver);*/
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Thread.sleep(5000);
		LoginPage.Temp_NAV_Links(driver,constants.leftNavLinks).click();


	}

	

}
