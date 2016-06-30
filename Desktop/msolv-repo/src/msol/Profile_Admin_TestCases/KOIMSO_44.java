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

public class KOIMSO_44 {
 
    public WebDriver driver;
 
    private String sTestCaseName;

    private ExtentTest Modifymyprofile_Profile_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/Modifymyprofile_Profile.html", true);


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
    public void main(String testCaseId) throws Exception {
    	Modifymyprofile_Profile_Extent_Test  = extent.startTest(testCaseId, "");
   
  	    SignIn_Action.Execute(Modifymyprofile_Profile_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");
  		Modifymyprofile_Profile_Extent_Test.log(LogStatus.PASS, "Login Successfully.");
  		
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");
  		
  		String StrLnkProfile = page_object.Profile_Admin_TestCases.AddUserProfile_Page.lnk_Profile;
  		Click_Action.Execute(driver, StrLnkProfile);
  		Log.info("Click action performed on Profile ");
  		Modifymyprofile_Profile_Extent_Test.log(LogStatus.PASS, "Click action performed on Profile");

  		String StrProfileOptionsPath = page_object.Profile_Admin_TestCases.User_Profile_Options_Page.strPath;
  		Log.info("Combined xPath is: "+StrProfileOptionsPath);
  		Object_Exist_Loop_Action.Execute(Modifymyprofile_Profile_Extent_Test, StrProfileOptionsPath);
  		
  		String StrLnk_Modifymyprofile = page_object.Profile_Admin_TestCases.ModifymyProfile_Page.Modifymyprofile;
  		Click_Action.Execute(driver, StrLnk_Modifymyprofile);
  		Log.info("Click action performed on Modify my profile");
  		Modifymyprofile_Profile_Extent_Test.log(LogStatus.PASS, "Click action performed on Modify my profile");

  		page_object.Profile_Admin_TestCases.ModifymyProfileSendkeys.Execute(driver);
  		Log.info("Modify My Profile function is done Successfully.");
  		Modifymyprofile_Profile_Extent_Test.log(LogStatus.PASS,"Modify My Profile function is done Successfully.");
  		
  		String StrModifymyProfilevalidatePath = page_object.Profile_Admin_TestCases.Validation_Profile_Page.strPath;
  		Log.info("Combined xPath is: "+StrModifymyProfilevalidatePath);
  		Object_Exist_Loop_Action.Execute(Modifymyprofile_Profile_Extent_Test, StrModifymyProfilevalidatePath);
  		  		
  		}
  		
	@AfterMethod
    public void afterMethod() {
   
		extent.endTest(Modifymyprofile_Profile_Extent_Test);
		extent.flush()	;
   
          }
   
 
}
