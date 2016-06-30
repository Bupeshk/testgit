package msol.Profile_Admin_TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.*;
 
import application_modules.*;

public class KOIMSO_40 {
 
    public WebDriver driver;
 
    private String sTestCaseName;
 


    private WebElement StrEle;
    private ExtentTest LMVRoutingMaintenance_Admin_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/LMVRoutingMaintenance_Admin.html", true);

   
 
  @BeforeMethod
  @Parameters("BrowserType")
  public void beforeMethod(String BrowserType) throws Exception {
 
         DOMConfigurator.configure("log4j.xml");
 
         sTestCaseName = this.toString();
 
         sTestCaseName = Utils.getTestCaseName(this.toString());
 
        Log.startTestCase(sTestCaseName);
 
        String ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;
        
        ExcelUtils.setExcelFile(ExcelPath,"Admin_Cases");

 
        if (BrowserType.equalsIgnoreCase("firefox")){
        	driver = Utils.openBrowserFF();
        }
        else{
        	driver = Utils.openBrowserIE();
        }
 
 
        }
    
    @Test
    @Parameters("testCaseId")
    public void main(String testCaseId) throws Exception {
    	LMVRoutingMaintenance_Admin_Extent_Test  =extent.startTest(testCaseId, "");
    	
  	    SignIn_Action.Execute(LMVRoutingMaintenance_Admin_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");
  		LMVRoutingMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Login Successfully.");

  		String newLmvRoutingId = ExcelUtils.getExcelData("newLmvRoutingId", "Admin_Cases"); 
		 String [] CCRArray = newLmvRoutingId.split(":");
		 for (int k=0 ; k<CCRArray.length;k++ ){

  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");

  		String StrLnk_Admin = page_object.Profile_Admin_TestCases.Administration_Page.Admin;
  		Click_Action.Execute(driver, StrLnk_Admin);
  		Log.info("Click action performed on Admin ");
  		LMVRoutingMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on Admin ");


  		String StrAdminOptionsPath = page_object.Profile_Admin_TestCases.Administration_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdminOptionsPath);
  		Object_Exist_Loop_Action.Execute(LMVRoutingMaintenance_Admin_Extent_Test, StrAdminOptionsPath);
  		
  		String StrLMVRoutingMaintenance = page_object.Profile_Admin_TestCases.Administration_Page.LMVRoutingMaintenance;
  		Click_Action.Execute(driver, StrLMVRoutingMaintenance);
  		Log.info("Click action performed on LMV Routing Maintenance");
  		LMVRoutingMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on LMV Routing Maintenance");

  		
  		String StrLMVMaintenancePath = page_object.Profile_Admin_TestCases.LMVMaintenance_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrLMVMaintenancePath);
  		Object_Exist_Loop_Action.Execute(LMVRoutingMaintenance_Admin_Extent_Test, StrLMVMaintenancePath);
  		
  		String StrAdd = page_object.Profile_Admin_TestCases.DiscrepancyMaintenance_Admin_Page.Add;
  		Click_Action.Execute(driver, StrAdd);
  		Log.info("Click action performed on ADD");
  		LMVRoutingMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on ADD");

  
  		String grpMDCreateFields = page_object.Profile_Admin_TestCases.LMVRoutingMaintenance_Admin_Page.grpstrPath;
        String grpMDCreateValues = page_object.Profile_Admin_TestCases.LMVRoutingMaintenance_Admin_Page.grpstrvalue;
        SetSendKeys_Action.Execute(LMVRoutingMaintenance_Admin_Extent_Test, grpMDCreateFields, grpMDCreateValues);
		
  		String StrSubmit = page_object.Profile_Admin_TestCases.LMVRoutingMaintenance_Admin_Page.Submit;
  		Click_Action.Execute(driver, StrSubmit);
  		Log.info("LMV Routing Maintenance is done Successfully.");
  		LMVRoutingMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "LMV Routing Maintenance is done Successfully.");

  		
  		String Strcheckbox = page_object.Profile_Admin_TestCases.LMVMaintenance_Admin_Page.checkbox;
  		Click_Action.Execute(driver, Strcheckbox);
  		String StrModify = page_object.Profile_Admin_TestCases.LMVRoutingMaintenance_Admin_Page.Modify;
  		Click_Action.Execute(driver, StrModify);
  		StrEle = page_object.Profile_Admin_TestCases.LMVRoutingMaintenance_Admin_Page.wmsUrl(driver);
  		StrEle.sendKeys("test value");
  		String Str_Submit = page_object.Profile_Admin_TestCases.LMVRoutingMaintenance_Admin_Page.Submit;
  		Click_Action.Execute(driver, Str_Submit);

  		String Strcheck_box = page_object.Profile_Admin_TestCases.LMVMaintenance_Admin_Page.checkbox;
  		Click_Action.Execute(driver, Strcheck_box);
  		String StrDelete = page_object.Profile_Admin_TestCases.DiscrepancyMaintenance_Admin_Page.Delete;
  		Click_Action.Execute(driver, StrDelete);
  		driver.switchTo().alert().accept();
  		
  		Log.info("Click action performed on Delete");
  		LMVRoutingMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on Delete");

  		Log.info("LMV Routing Maintenance function is done Successfully.");
  		LMVRoutingMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "LMV Routing Maintenance function is done Successfully.");

		 
	 }
  		}

	@AfterMethod
    public void afterMethod() {
		extent.endTest(LMVRoutingMaintenance_Admin_Extent_Test);
		extent.flush();

          }
}
