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
import page_object.Profile_Admin_TestCases.SearchUserProfile_Page;

public class KOIMSO_43 {
 
    public WebDriver driver;
 
    private String sTestCaseName;
 
    private ExtentTest SearchUser_Profile_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/SearchUser_Profile.html", true);


  @BeforeMethod
  @Parameters("BrowserType")
  public void beforeMethod(String BrowserType) throws Exception {
 
         DOMConfigurator.configure("log4j.xml");
 
         sTestCaseName = this.toString();
 
         sTestCaseName = Utils.getTestCaseName(this.toString());
 
        Log.startTestCase(sTestCaseName);
 
        String ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;
        
        ExcelUtils.setExcelFile(ExcelPath,"Profile_Cases");
        
        if (BrowserType.equalsIgnoreCase("firefox")){
        	driver = Utils.openBrowserFF();
        }
        else{
        	driver = Utils.openBrowserIE();
        }
 
        }
    
    @Test
    @Parameters("testCaseId")
    public void Search_User(String testCaseId) throws Exception {
    	SearchUser_Profile_Extent_Test  = extent.startTest(testCaseId, "");
   
  	    SignIn_Action.Execute(SearchUser_Profile_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");
  		SearchUser_Profile_Extent_Test.log(LogStatus.PASS, "Login Successfully.");
  		
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");
  		
  		String StrLnkProfile = page_object.Profile_Admin_TestCases.AddUserProfile_Page.lnk_Profile;
  		Click_Action.Execute(driver, StrLnkProfile);
  		Log.info("Click action performed on Profile ");
  		SearchUser_Profile_Extent_Test.log(LogStatus.PASS, "Click action performed on Profile ");
  		
  		String StrProfileOptionsPath = page_object.Profile_Admin_TestCases.User_Profile_Options_Page.strPath;
  		Log.info("Combined xPath is: "+StrProfileOptionsPath);
  		Object_Exist_Loop_Action.Execute(SearchUser_Profile_Extent_Test, StrProfileOptionsPath);
  		
  		String StrLnk_Search = page_object.Profile_Admin_TestCases.SearchUserProfile_Page.SearchUser;
  		Click_Action.Execute(driver, StrLnk_Search);
  		Log.info("Click action performed on Search User ");
  		SearchUser_Profile_Extent_Test.log(LogStatus.PASS, "Click action performed on Search User ");
  		
  		String StrSearchuserProfilePath = page_object.Profile_Admin_TestCases.SearchUserProfile_Page.strPath;
  		Log.info("Combined xPath is: "+StrSearchuserProfilePath);
  		Object_Exist_Loop_Action.Execute(SearchUser_Profile_Extent_Test, StrSearchuserProfilePath);
  		
  		String Lastname = ExcelUtils.getExcelData("Last_Name", "Search_User_Profile");
  		if (Lastname != null){
  		String Lastname_path = page_object.Profile_Admin_TestCases.SearchUserProfile_Page.lastname;
  		Utils.SetSendKeys(SearchUser_Profile_Extent_Test, Lastname_path, Lastname); 
  		}
  		else{
  		page_object.Profile_Admin_TestCases.SearchUserProfileSendkeys.Execute(driver);
  		}
  		SearchUserProfile_Page.Btn_Submit(driver).click();
  		
  		String pagebanner = page_object.Profile_Admin_TestCases.Validation_Profile_Page.pagebanner;
  		if(Utils.ispresent(SearchUser_Profile_Extent_Test, pagebanner)){
  			
  			String LastName_Link = page_object.Profile_Admin_TestCases.Validation_Profile_Page.LN_lnk;
  			Click_Action.Execute(driver, LastName_Link);
  		}
  		
  		String Address2  = page_object.Profile_Admin_TestCases.Validation_Profile_Page.Address2;
  		String Address_Value  = ExcelUtils.getExcelData("Address_Line2", "Search_User_Profile");
  		Utils.SetSendKeys(SearchUser_Profile_Extent_Test, Address2, Address_Value);
  		SearchUserProfile_Page.Btn_Submit(driver).click();
  		
  		Log.info("Search User function is done Successfully.");
  		SearchUser_Profile_Extent_Test.log(LogStatus.PASS, "Search User function is done Successfully.");
  		
  		String StrModifymyProfilevalidatePath = page_object.Profile_Admin_TestCases.Validation_Profile_Page.strPath;
  		Log.info("Combined xPath is: "+StrModifymyProfilevalidatePath);
  		Object_Exist_Loop_Action.Execute(SearchUser_Profile_Extent_Test, StrModifymyProfilevalidatePath);
  		

  		
  		}
  		
	@AfterMethod
    public void afterMethod() {
   
		extent.endTest(SearchUser_Profile_Extent_Test);
		extent.flush()	;
   
          }
   
}
