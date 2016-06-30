package msol.Profile_Admin_TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utility.*;
 
import application_modules.*;

public class LMVMaintenance_Admin {
 
    public WebDriver driver;
 
    private String sTestCaseName;

    private ExtentTest LMVMaintenance_Admin_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/LMVMaintenance_Admin.html", true);


  @BeforeMethod
  public void beforeMethod() throws Exception {
 
         DOMConfigurator.configure("log4j.xml");
 
         sTestCaseName = this.toString();
 
         sTestCaseName = Utils.getTestCaseName(this.toString());
 
        Log.startTestCase(sTestCaseName);
 
        String ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;
        
        ExcelUtils.setExcelFile(ExcelPath,"Sheet3");
 
        driver = Utils.openBrowserFF();
 
        }
    
    @Test
    public void main() throws Exception {
    	LMVMaintenance_Admin_Extent_Test  = extent.startTest(sTestCaseName, "");
   
  	    SignIn_Action.Execute(LMVMaintenance_Admin_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");

  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");

  		String StrLnk_Admin = page_object.Profile_Admin_TestCases.Administration_Page.Admin;
  		Click_Action.Execute(driver, StrLnk_Admin);
  		Log.info("Click action performed on Admin ");

  		String StrAdminOptionsPath = page_object.Profile_Admin_TestCases.Administration_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdminOptionsPath);
  		Object_Exist_Loop_Action.Execute(LMVMaintenance_Admin_Extent_Test, StrAdminOptionsPath);
  		
  		String StrMaterialStatusChange = page_object.Profile_Admin_TestCases.Administration_Page.MaterialStatusChange;
  		Click_Action.Execute(driver, StrMaterialStatusChange);
  		Log.info("Click action performed on Material Status Change");

  		page_object.Profile_Admin_TestCases.LMVMaintenance_AdminSendkeys.Execute(driver);
  		Log.info("LMV Maintenance function is done Successfully.");	
  		}

	@AfterMethod
    public void afterMethod() {

  	  // driver.quit();

          }
}
