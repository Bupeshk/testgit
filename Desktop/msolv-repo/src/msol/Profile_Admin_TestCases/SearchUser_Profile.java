package msol.Profile_Admin_TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utility.*;
 
import application_modules.*;

public class SearchUser_Profile {
 
    public WebDriver driver;
 
    private String sTestCaseName;
    
    private ExtentTest SearchUser_Profile_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/SearchUser_Profile.html", true);


  @BeforeMethod
  public void beforeMethod() throws Exception {
 
         DOMConfigurator.configure("log4j.xml");
 
         sTestCaseName = this.toString();
 
         sTestCaseName = Utils.getTestCaseName(this.toString());
 
        Log.startTestCase(sTestCaseName);
 
        String ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;
        
        ExcelUtils.setExcelFile(ExcelPath,"Sheet2");
 
        driver = Utils.openBrowserFF();
 
        }
    
    @Test
    public void main() throws Exception {
    	SearchUser_Profile_Extent_Test  = extent.startTest(sTestCaseName, "");
   
  	    SignIn_Action.Execute(SearchUser_Profile_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");
  		
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");
  		
  		String StrLnkProfile = page_object.Profile_Admin_TestCases.AddUserProfile_Page.lnk_Profile;
  		Click_Action.Execute(driver, StrLnkProfile);
  		Log.info("Click action performed on Profile ");
  		
  		String StrProfileOptionsPath = page_object.Profile_Admin_TestCases.User_Profile_Options_Page.strPath;
  		Log.info("Combined xPath is: "+StrProfileOptionsPath);
  		Object_Exist_Loop_Action.Execute(SearchUser_Profile_Extent_Test, StrProfileOptionsPath);
  		
  		String StrLnk_Search = page_object.Profile_Admin_TestCases.SearchUserProfile_Page.SearchUser;
  		Click_Action.Execute(driver, StrLnk_Search);
  		Log.info("Click action performed on Search User ");
  		
  		String StrSearchuserProfilePath = page_object.Profile_Admin_TestCases.SearchUserProfile_Page.strPath;
  		Log.info("Combined xPath is: "+StrSearchuserProfilePath);
  		Object_Exist_Loop_Action.Execute(SearchUser_Profile_Extent_Test, StrSearchuserProfilePath);
  		
  		page_object.Profile_Admin_TestCases.SearchUserProfileSendkeys.Execute(driver);
  		Log.info("Search User function is done Successfully.");
  		
  		String StrModifymyProfilevalidatePath = page_object.Profile_Admin_TestCases.Validation_Profile_Page.strPath;
  		Log.info("Combined xPath is: "+StrModifymyProfilevalidatePath);
  		Object_Exist_Loop_Action.Execute(SearchUser_Profile_Extent_Test, StrModifymyProfilevalidatePath);
  		
  		}
  		
	@AfterMethod
    public void afterMethod() {
   
  	  // driver.quit();
   
          }
   
}
