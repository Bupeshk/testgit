package msol.Profile_Admin_TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utility.*;
 
import application_modules.*;

public class AssignReuseCoordinatorEmailAddress_Admin {
 
    public WebDriver driver;
 
    private String sTestCaseName;

    
    private ExtentTest AssignReuseCoordinatorEmailAddress_Admin_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/AssignReuseCoordinatorEmailAddress_Admin.html", true);


  @BeforeMethod
  public void beforeMethod() throws Exception {
	  
	  AssignReuseCoordinatorEmailAddress_Admin_Extent_Test  = extent.startTest(sTestCaseName, "");
 
         DOMConfigurator.configure("log4j.xml");
 
         sTestCaseName = this.toString();
 
         sTestCaseName = Utils.getTestCaseName(this.toString());
 
        Log.startTestCase(sTestCaseName);
 
        ExcelUtils.setExcelFile(GUI_Constant.Path_TestData + GUI_Constant.File_TestData,"Sheet1");
 
        driver = Utils.openBrowserFF();
 
        }
    
    @Test
    public void main() throws Exception {
   
  	    SignIn_Action.Execute(AssignReuseCoordinatorEmailAddress_Admin_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");
  		
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");
  		
  		String StrLnk_Admin = page_object.Profile_Admin_TestCases.Administration_Page.Admin;
  		Click_Action.Execute(driver, StrLnk_Admin);
  		Log.info("Click action performed on Admin ");

  		String StrAdminOptionsPath = page_object.Profile_Admin_TestCases.Administration_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdminOptionsPath);
  		Object_Exist_Loop_Action.Execute(AssignReuseCoordinatorEmailAddress_Admin_Extent_Test, StrAdminOptionsPath);
  		
  		String StrAssignReuseCoordinatorEmailAddress = page_object.Profile_Admin_TestCases.Administration_Page.AssignReuseCoordinatorEmailAddress;
  		Click_Action.Execute(driver, StrAssignReuseCoordinatorEmailAddress);
  		Log.info("Click action performed on Assign Reuse Coordinator Email Address");
  		
  		String StrAssignReuseCoordinatorEmailAddressPath = page_object.Profile_Admin_TestCases.AssignReuseCoordinatorEmailAddress_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrAssignReuseCoordinatorEmailAddressPath);
  		Object_Exist_Loop_Action.Execute(AssignReuseCoordinatorEmailAddress_Admin_Extent_Test, StrAssignReuseCoordinatorEmailAddressPath);
  				
  		page_object.Profile_Admin_TestCases.AssignReuseCoordinatorEmailAddress_AdminSendkeys.Execute(driver);
  		Log.info("Assign Reuse Coordinator Email Address function is done Successfully.");
  		
  		String StrAssignReuseCoordinatorEmailAddressvalidatePath = page_object.Profile_Admin_TestCases.Validation_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrAssignReuseCoordinatorEmailAddressvalidatePath);
  		Object_Exist_Loop_Action.Execute(AssignReuseCoordinatorEmailAddress_Admin_Extent_Test, StrAssignReuseCoordinatorEmailAddressvalidatePath);
  		  		
  		}
  		
	@AfterMethod
    public void afterMethod() {
   
  	  // driver.quit();
   
          }
    
 
}
