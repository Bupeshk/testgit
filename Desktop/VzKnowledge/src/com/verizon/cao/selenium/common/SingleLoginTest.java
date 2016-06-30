package com.verizon.cao.selenium.common;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.verizon.cao.selenium.common.ObjectRepository.Authoring;
import com.verizon.cao.selenium.setup.SetupBase;

@Test
public class SingleLoginTest extends SetupBase implements Authoring  {
	CommonFunctions common = new CommonFunctions();
	private String  baseurl ;

	public SingleLoginTest() throws Exception {
		super();
	} 
	//@BeforeSuite
	public  void Logintest() throws InterruptedException

	{

		//driver = new FirefoxDriver();
		//driver.get(BaseUrl);

		//driver = SetupBase.launchBrowser();
		LoginPage.UserID(driver).sendKeys("SELVRX2");
		LoginPage.Password(driver).sendKeys("2Wardsurgo@l");
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
		
	}

	@BeforeClass
	public  void setUp()throws Exception {
		//super.environmentSetUp();
		baseurl = super.getTestBaseUrl();
		//adminHomePage = new AdminHomePage(driver);
		System.out.println("inside before class"  +baseurl);

	} 


}
