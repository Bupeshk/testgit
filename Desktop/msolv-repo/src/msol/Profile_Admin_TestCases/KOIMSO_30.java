package msol.Profile_Admin_TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.*;
 
import application_modules.*;

public class KOIMSO_30 {
 
    public WebDriver driver;
 
    private String sTestCaseName;
 
    
    private ExtentTest VendorExpediteManagement_Admin_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/VendorExpediteManagement_Admin.html", true);


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
    	VendorExpediteManagement_Admin_Extent_Test  = extent.startTest(testCaseId, "");
   
  	    SignIn_Action.Execute(VendorExpediteManagement_Admin_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");
  		VendorExpediteManagement_Admin_Extent_Test.log(LogStatus.PASS, "Login Successfully.");
  		
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");
  		
  		String StrLnk_Admin = page_object.Profile_Admin_TestCases.Administration_Page.Admin;
  		Click_Action.Execute(driver, StrLnk_Admin);
  		Log.info("Click action performed on Admin ");
  		VendorExpediteManagement_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on Admin ");

  		String StrAdminOptionsPath = page_object.Profile_Admin_TestCases.Administration_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdminOptionsPath);
  		Object_Exist_Loop_Action.Execute(VendorExpediteManagement_Admin_Extent_Test, StrAdminOptionsPath);
  		
  		String StrVendorExpediteManagement = page_object.Profile_Admin_TestCases.Administration_Page.VendorExpediteManagement;
  		Click_Action.Execute(driver, StrVendorExpediteManagement);
  		Log.info("Click action performed on Vendor Expedite Management");
  		VendorExpediteManagement_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on Vendor Expedite Management");
  		
  		String StrVendorExpediteManagementPath = page_object.Profile_Admin_TestCases.VendorExpediteManagement_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrVendorExpediteManagementPath);
  		Object_Exist_Loop_Action.Execute(VendorExpediteManagement_Admin_Extent_Test, StrVendorExpediteManagementPath);
  			
  		page_object.Profile_Admin_TestCases.VendorExpediteManagement_AdminSendkeys.Execute(driver);
  		Log.info("Vendor Expedite Management function is done Successfully.");
  		VendorExpediteManagement_Admin_Extent_Test.log(LogStatus.PASS, "Vendor Expedite Management function is done Successfully.");
  		
  		String StrVendorExpediteManagementvalidatePath = page_object.Profile_Admin_TestCases.Validation_VendorExpediteManagement_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrVendorExpediteManagementvalidatePath);
  		Object_Exist_Loop_Action.Execute(VendorExpediteManagement_Admin_Extent_Test, StrVendorExpediteManagementvalidatePath);
  			
  		}
  		
	@AfterMethod
    public void afterMethod() {
   
		extent.endTest(VendorExpediteManagement_Admin_Extent_Test);
		extent.flush()	;
   
          }
    
 
}
