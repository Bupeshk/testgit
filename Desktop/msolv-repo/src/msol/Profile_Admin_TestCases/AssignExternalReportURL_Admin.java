package msol.Profile_Admin_TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utility.*;
 
import application_modules.*;

public class AssignExternalReportURL_Admin {
 
    public WebDriver driver;
 
    private String sTestCaseName;

    private ExtentTest AssignExternalReportURL_Admin_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/AssignExternalReportURL_Admin.html", true);
    
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  
	  AssignExternalReportURL_Admin_Extent_Test  = extent.startTest(sTestCaseName, "");
	  
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
   
  	    SignIn_Action.Execute(AssignExternalReportURL_Admin_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");
  		
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");
  		
  		String StrLnk_Admin = page_object.Profile_Admin_TestCases.Administration_Page.Admin;
  		Click_Action.Execute(driver, StrLnk_Admin);
  		Log.info("Click action performed on Admin ");

  		String StrAdminOptionsPath = page_object.Profile_Admin_TestCases.Administration_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdminOptionsPath);
  		Object_Exist_Loop_Action.Execute(AssignExternalReportURL_Admin_Extent_Test, StrAdminOptionsPath);
  		
  		String StrAssignExternalReportURL = page_object.Profile_Admin_TestCases.Administration_Page.AssignExternalReportURL;
  		Click_Action.Execute(driver, StrAssignExternalReportURL);
  		Log.info("Click action performed on Assign External Report URL ");
  		
  		String StrAdminAssignexternalURLPath = page_object.Profile_Admin_TestCases.AssignExternalReportURL_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdminAssignexternalURLPath);
  		Object_Exist_Loop_Action.Execute(AssignExternalReportURL_Admin_Extent_Test, StrAdminAssignexternalURLPath);
  				
  		page_object.Profile_Admin_TestCases.AssignExternalReportURL_AdminSendkeys.Execute(driver);
  		Log.info("Assign External Report URL function is done Successfully.");
  		
  		String StrAdminAssignexternalvalidatePath = page_object.Profile_Admin_TestCases.Validation_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdminAssignexternalvalidatePath);
  		Object_Exist_Loop_Action.Execute(AssignExternalReportURL_Admin_Extent_Test, StrAdminAssignexternalvalidatePath);
  		  		
  		}
  		
	@AfterMethod
    public void afterMethod() {
   
  	  // driver.quit();
   
          }
   
 
}
