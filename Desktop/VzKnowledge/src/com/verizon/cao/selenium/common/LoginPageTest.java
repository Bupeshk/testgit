package com.verizon.cao.selenium.common;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.verizon.cao.selenium.common.ObjectRepository.Authoring;
import com.verizon.cao.selenium.setup.SetupBase;

@Test
public class LoginPageTest extends SetupBase implements Authoring  {
	CommonFunctions common = new CommonFunctions();
	private String  baseurl ;

	public LoginPageTest() throws Exception {
		super();
	} 
	//@BeforeSuite
	public  void Logintest() throws InterruptedException

	{

		//driver = new FirefoxDriver();
		//driver.get(BaseUrl);

		//driver = SetupBase.launchBrowser();
		LoginPage.UserID(driver).sendKeys(RepConstants.UserName);
		LoginPage.Password(driver).sendKeys(RepConstants.Password);
		LoginPage.btn_SignOn(driver).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(6000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.navigate().refresh();


		common.existsElement(driver,lnkHome);
		common.existsElement(driver,lnkauthoring);
		common.existsElement(driver,dropBG);
		driver.findElement(By.xpath(lnkauthoring)).click();
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
		    if(!windowHandle.equals(parentWindow))
		   {
		    	driver.close();
		    	driver.switchTo().window(windowHandle);
		     System.out.println("child window--"+windowHandle+"Parent Window"+parentWindow);
		     
		    }
		}

		common.existsElement(driver,eleViewsummary);


	}

	@BeforeClass
	public  void setUp()throws Exception {
		//super.environmentSetUp();
		baseurl = super.getTestBaseUrl();
		//adminHomePage = new AdminHomePage(driver);
		System.out.println("inside before class"  +baseurl);

	} 


}
