package msol.Profile_Admin_TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utility.*;
 
import application_modules.*;

public class GroupMaintenance_Admin {
 
    public WebDriver driver;
 
    private String sTestCaseName;
    
    private ExtentTest GroupMaintenance_Admin_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/GroupMaintenance_Admin.html", true);


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
    	GroupMaintenance_Admin_Extent_Test  = extent.startTest(sTestCaseName, "");
    	
   
  	    SignIn_Action.Execute(GroupMaintenance_Admin_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");

  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");

  		String StrLnk_Admin = page_object.Profile_Admin_TestCases.Administration_Page.Admin;
  		Click_Action.Execute(driver, StrLnk_Admin);
  		Log.info("Click action performed on Admin ");

  		String StrAdminOptionsPath = page_object.Profile_Admin_TestCases.Administration_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdminOptionsPath);
  		Object_Exist_Loop_Action.Execute(GroupMaintenance_Admin_Extent_Test, StrAdminOptionsPath);
  		
  		String StrOrganizationAndGroupMaintenance = page_object.Profile_Admin_TestCases.Administration_Page.OrganizationAndGroupMaintenance;
  		Click_Action.Execute(driver, StrOrganizationAndGroupMaintenance);
  		Log.info("Click action performed on Organization And Group Maintenance");
  		
  		String StrGroupMaintenance = page_object.Profile_Admin_TestCases.Organization_Group_Maintenance_Admin_Page.GroupMaintenance;
  		Click_Action.Execute(driver, StrGroupMaintenance);
  		Log.info("Click action performed on Group Maintenance");
  		
  		String StrDiscrepancyMaintenancePath = page_object.Profile_Admin_TestCases.DiscrepancyMaintenance_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrDiscrepancyMaintenancePath);
  		Object_Exist_Loop_Action.Execute(GroupMaintenance_Admin_Extent_Test, StrDiscrepancyMaintenancePath);
  		
  		String StrAdd = page_object.Profile_Admin_TestCases.DiscrepancyMaintenance_Admin_Page.Add;
  		Click_Action.Execute(driver, StrAdd);
  		Log.info("Click action performed on ADD");
  
  		String grpMDCreateFields = page_object.Profile_Admin_TestCases.Group_Maintenance_Admin_Page.grpstrPath;
        String grpMDCreateValues = page_object.Profile_Admin_TestCases.Group_Maintenance_Admin_Page.grpstrvalue;
        SetSendKeys_Action.Execute(GroupMaintenance_Admin_Extent_Test, grpMDCreateFields, grpMDCreateValues);

  		String strorgPath = page_object.Profile_Admin_TestCases.Group_Maintenance_Admin_Page.OrganizationCode;
        String StrorgValue = ExcelUtils.getExcelData("OrganizationCode", "Group_Maintenance_Admin_Page");
        Utils.SelDropDown(strorgPath, StrorgValue);
        
  		String StrSave = page_object.Profile_Admin_TestCases.Group_Maintenance_Admin_Page.Save;
  		Click_Action.Execute(driver, StrSave);
  		Log.info("Group Maintenance function is done Successfully.");

  		String strorgval = ExcelUtils.getExcelData("OrganizationCode", "GroupMaintenance");
  		String strgrpcodealue = ExcelUtils.getExcelData("GroupCode", "GroupMaintenance");
  		String strValue = strorgval + ":" + strgrpcodealue;
  		WebElement element = driver.findElement(By.xpath("//input[@value='"+strValue+"']"));
  		element.click();
  		
  		String StrDelete = page_object.Profile_Admin_TestCases.DiscrepancyMaintenance_Admin_Page.Delete;
  		Click_Action.Execute(driver, StrDelete);
  		Log.info("Click action performed on Delete");
  		Log.info("Organization Maintenance function is done Successfully.");
  		
  		}

	@AfterMethod
    public void afterMethod() {

  	  // driver.quit();

          }
}
