package com.verizon.cao.selenium.authoring.tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.cao.selenium.authoring.pages.AuthoringContentPage;
import com.verizon.cao.selenium.authoring.pages.AuthoringDashboardPage;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.LoginPageTest;
import com.verizon.cao.selenium.common.SelectRegionTest;
import com.verizon.cao.selenium.common.ObjectRepository.Authoring;
import com.verizon.cao.selenium.setup.SetupBase;

@Test
public class EW_144 extends SetupBase implements Authoring {

	CommonFunctions common = new CommonFunctions();
	private String  baseurl ;
	public EW_144() throws Exception {
		super();
	}
	//@BeforeSuite
	@Test
	public  void Logintest() throws Exception
	
	{
		LoginPageTest loginpage = new LoginPageTest();
		loginpage.Logintest();
		
		AuthoringDashboardPage.folderAccountSupport(driver).click();
		Thread.sleep(1000);
		
		AuthoringDashboardPage.eleCreate(driver).click();
		AuthoringContentPage.chckrole(driver).click();
		AuthoringContentPage.btncontinue(driver).click();
		AuthoringContentPage.txtboxtitle(driver).sendKeys("a");
		AuthoringContentPage.txtdescription(driver).sendKeys("a");
		AuthoringContentPage.txtkeyword(driver).sendKeys("a");
		AuthoringContentPage.txtauthornote(driver).sendKeys("a");
		CommonFunctions.SelDropDown(selectcategory,"Access Diversity",driver);
		CommonFunctions.SelDropDown(selectheadertype,"Communications",driver);
		CommonFunctions.SelDropDown(selectheaderclassification,"Bulletins",driver);
		AuthoringContentPage.btnaddRegion(driver).click();
		
		SelectRegionTest selectregion = new SelectRegionTest();
		selectregion.selectRegionval();
		
		AuthoringContentPage.btncontinuenxt(driver).click();
		AuthoringContentPage.btncontinuenxt(driver).click();
		CommonFunctions.SelDropDown(selectworkflow,"No Workflow",driver);
		AuthoringContentPage.btncontinuenxt(driver).click();
		AuthoringContentPage.txtURL(driver).sendKeys("www.verizon.com");
		AuthoringContentPage.btnsave(driver).click();
		common.existsElement(driver,eleverify);
		AuthoringContentPage.btncheckinsimilar(driver).click();
	}
	@BeforeClass
	public  void setUp()throws Exception {
		//super.environmentSetUp();
		baseurl = super.getTestBaseUrl();
		//adminHomePage = new AdminHomePage(driver);
		System.out.println("inside before class"  +baseurl);

	} 
	
	
}
