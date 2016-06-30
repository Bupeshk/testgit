package msol.Profile_Admin_TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.*;
 
import application_modules.*;

public class KOIMSO_33 {
 
    public WebDriver driver;
 
    private String sTestCaseName;
 
    
    private ExtentTest OrganizationMaintenance_Admin_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/OrganizationMaintenance_Admin.html", true);


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
    	OrganizationMaintenance_Admin_Extent_Test  = extent.startTest(testCaseId, "");
   
  	    SignIn_Action.Execute(OrganizationMaintenance_Admin_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");
  		OrganizationMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Login Successfully.");

  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");

  		String StrLnk_Admin = page_object.Profile_Admin_TestCases.Administration_Page.Admin;
  		Click_Action.Execute(driver, StrLnk_Admin);
  		Log.info("Click action performed on Admin ");
  		OrganizationMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on Admin ");

  		String StrAdminOptionsPath = page_object.Profile_Admin_TestCases.Administration_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdminOptionsPath);
  		Object_Exist_Loop_Action.Execute(OrganizationMaintenance_Admin_Extent_Test, StrAdminOptionsPath);
  		
  		String StrOrganizationAndGroupMaintenance = page_object.Profile_Admin_TestCases.Administration_Page.OrganizationAndGroupMaintenance;
  		Click_Action.Execute(driver, StrOrganizationAndGroupMaintenance);
  		Log.info("Click action performed on Organization And Group Maintenance");
  		OrganizationMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on Organization And Group Maintenance");
  		
  		String StrOrganizationMaintenance = page_object.Profile_Admin_TestCases.Organization_Group_Maintenance_Admin_Page.OrganizationMaintenance;
  		Click_Action.Execute(driver, StrOrganizationMaintenance);
  		Log.info("Click action performed on Organization Maintenance");
  		OrganizationMaintenance_Admin_Extent_Test.log(LogStatus.PASS,"Click action performed on Organization Maintenance");
  		
  		String StrDiscrepancyMaintenancePath = page_object.Profile_Admin_TestCases.DiscrepancyMaintenance_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrDiscrepancyMaintenancePath);
  		Object_Exist_Loop_Action.Execute(OrganizationMaintenance_Admin_Extent_Test, StrDiscrepancyMaintenancePath);
  		
  		String StrAdd = page_object.Profile_Admin_TestCases.DiscrepancyMaintenance_Admin_Page.Add;
  		Click_Action.Execute(driver, StrAdd);
  		Log.info("Click action performed on ADD");
  		OrganizationMaintenance_Admin_Extent_Test.log(LogStatus.PASS,"Click action performed on ADD");
  
  		String grpMDCreateFields = page_object.Profile_Admin_TestCases.Organization_Maintenance_Admin_Page.grpstrPath;
        String grpMDCreateValues = page_object.Profile_Admin_TestCases.Organization_Maintenance_Admin_Page.grpstrvalue;
        SetSendKeys_Action.Execute(OrganizationMaintenance_Admin_Extent_Test, grpMDCreateFields, grpMDCreateValues);
        
  		String StrSave = page_object.Profile_Admin_TestCases.Organization_Maintenance_Admin_Page.Save;
  		Click_Action.Execute(driver, StrSave);
  		Log.info("Organization Maintenance function is done Successfully.");
  		OrganizationMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Organization Maintenance function is done Successfully.");

  		String strValue = ExcelUtils.getExcelData("Code", "OrganizationMaintenance");
  		WebElement element = driver.findElement(By.xpath("//input[@value='"+strValue+"']"));
  		element.click();

  		String StrDelete = page_object.Profile_Admin_TestCases.DiscrepancyMaintenance_Admin_Page.Delete;
  		Click_Action.Execute(driver, StrDelete);
  		Log.info("Click action performed on Delete");
  		OrganizationMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on Delete");
  		Log.info("Organization Maintenance function is done Successfully.");
  		OrganizationMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Organization Maintenance function is done Successfully.");
  		
  		}

	@AfterMethod
    public void afterMethod() {

		extent.endTest(OrganizationMaintenance_Admin_Extent_Test);
		extent.flush();


          }
}
