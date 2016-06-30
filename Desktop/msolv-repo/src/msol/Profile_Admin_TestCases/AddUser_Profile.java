package msol.Profile_Admin_TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utility.*;
 
import application_modules.*;

public class AddUser_Profile {
 
    public WebDriver driver;
 
    private String sTestCaseName;
  
    private ExtentTest AddUser_Profile_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/AddUser_Profile.html", true);
    
 
  @BeforeMethod
  public void beforeMethod() throws Exception {
 
         DOMConfigurator.configure("log4j.xml");
 
         sTestCaseName = this.toString();
 
         sTestCaseName = Utils.getTestCaseName(this.toString());
 
        Log.startTestCase(sTestCaseName);
        
        String ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;
 
        ExcelUtils.setExcelFile(ExcelPath,"Profile_Cases");
 
        //iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,GUI_Constant.Col_TestCaseName);
 
        driver = Utils.openBrowserFF();
 
        }
    
    @Test
    public void main() throws Exception {
   
    	
    	AddUser_Profile_Extent_Test  = extent.startTest(sTestCaseName, "");
  	    SignIn_Action.Execute(AddUser_Profile_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");
  		
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");
  		
  		String StrLnkProfile = page_object.Profile_Admin_TestCases.AddUserProfile_Page.lnk_Profile;
  		Click_Action.Execute(driver, StrLnkProfile);
  		Log.info("Click action performed on Profile ");

  		String StrProfileOptionsPath = page_object.Profile_Admin_TestCases.User_Profile_Options_Page.strPath;
  		Log.info("Combined xPath is: "+StrProfileOptionsPath);
  		Object_Exist_Loop_Action.Execute(AddUser_Profile_Extent_Test, StrProfileOptionsPath);
  		
  		Utils.sleep(3000);
  		String StraddProfile = page_object.Profile_Admin_TestCases.AddUserProfile_Page.Add_User;
  		Click_Action.Execute(driver, StraddProfile);
  		Log.info("Click action performed on Add User ");
  		
  		String StrAdduserProfilePath = page_object.Profile_Admin_TestCases.AddUserProfile_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdduserProfilePath);
  		Object_Exist_Loop_Action.Execute(AddUser_Profile_Extent_Test, StrAdduserProfilePath);
  				
  		String grpMDCreateFields = page_object.Profile_Admin_TestCases.AddUserProfile_Page.grpstrPath;
        String grpMDCreateValues = page_object.Profile_Admin_TestCases.AddUserProfile_Page.grpstrvalue;
        SetSendKeys_Action.Execute(AddUser_Profile_Extent_Test, grpMDCreateFields, grpMDCreateValues); 
  		Log.info("Add User function is done Successfully.");
  		
  		String strorgPath = page_object.Profile_Admin_TestCases.AddUserProfile_Page.Organization;
        String StrorgValue = ExcelUtils.getExcelData("Organization", "Add_User_Profile");
        Utils.SelDropDown(strorgPath, StrorgValue);
        
  		String StrUserRoleOption = page_object.Profile_Admin_TestCases.AddUserProfile_Page.UserRoleOption;
  		Click_Action.Execute(driver, StrUserRoleOption);
  		String StrOffshoreFlag = page_object.Profile_Admin_TestCases.AddUserProfile_Page.Offshore_Flag;
  		Click_Action.Execute(driver, StrOffshoreFlag);
  		String StrBtn_Submit = page_object.Profile_Admin_TestCases.AddUserProfile_Page.Submit;
  		Click_Action.Execute(driver, StrBtn_Submit);

  		
  		
  		String StrAdduserProfilevalidatePath = page_object.Profile_Admin_TestCases.Validation_Profile_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdduserProfilevalidatePath);
  		Object_Exist_Loop_Action.Execute(AddUser_Profile_Extent_Test, StrAdduserProfilevalidatePath);
  		  		
  		}
  		
	@AfterMethod
    public void afterMethod() {
   
  	  // driver.quit();
   
          }
   
 
}
