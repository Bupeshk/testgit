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

public class KOIMSO_31 {
 
    public WebDriver driver;
 
    private String sTestCaseName;
 

    private ExtentTest VendorContactMaintenance_Admin_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/VendorContactMaintenance_Admin.html", true);


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
    	VendorContactMaintenance_Admin_Extent_Test  =  extent.startTest(testCaseId, "");
   
  	    SignIn_Action.Execute(VendorContactMaintenance_Admin_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");
  		VendorContactMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Login Successfully.");

  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");

  		String StrLnk_Admin = page_object.Profile_Admin_TestCases.Administration_Page.Admin;
  		Click_Action.Execute(driver, StrLnk_Admin);
  		Log.info("Click action performed on Admin ");
  		VendorContactMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on Admin ");

  		String StrAdminOptionsPath = page_object.Profile_Admin_TestCases.Administration_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdminOptionsPath);
  		Object_Exist_Loop_Action.Execute(VendorContactMaintenance_Admin_Extent_Test, StrAdminOptionsPath);
  		
  		String StrVendorContactMaintenance = page_object.Profile_Admin_TestCases.Administration_Page.VendorContactMaintenance;
  		Click_Action.Execute(driver, StrVendorContactMaintenance);
  		Log.info("Click action performed on Vendor Contact Maintenance");
  		VendorContactMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on Vendor Contact Maintenance");

  		String StrVendorContactMaintenancePath = page_object.Profile_Admin_TestCases.VendorContactMaintenance_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrVendorContactMaintenancePath);
  		Object_Exist_Loop_Action.Execute(VendorContactMaintenance_Admin_Extent_Test, StrVendorContactMaintenancePath);

  		page_object.Profile_Admin_TestCases.VendorContactMaintenance_AdminSendkeys.Execute(driver);
  		Log.info("Vendor Contact Maintenance function is done Successfully.");
  		VendorContactMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Vendor Contact Maintenance function is done Successfully.");

  		String StrVendorContactMaintenancevalidatePath = page_object.Profile_Admin_TestCases.Validation_VendorContactMaintenance_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrVendorContactMaintenancevalidatePath);
  		Object_Exist_Loop_Action.Execute(VendorContactMaintenance_Admin_Extent_Test, StrVendorContactMaintenancevalidatePath);
  		
  		}

	@AfterMethod
    public void afterMethod() {

		extent.endTest(VendorContactMaintenance_Admin_Extent_Test);
		extent.flush();

          }
}
