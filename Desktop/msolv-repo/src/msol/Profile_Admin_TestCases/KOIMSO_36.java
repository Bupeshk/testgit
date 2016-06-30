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
import page_object.Profile_Admin_TestCases.HolidayMaintenance_Admin_Page;

public class KOIMSO_36 {
 
    public WebDriver driver;
 
    private String sTestCaseName;
 
    
    private ExtentTest HolidayMaintenance_Admin_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/HolidayMaintenance_Admin.html", true);


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
    	
    	HolidayMaintenance_Admin_Extent_Test  = extent.startTest(testCaseId, "");
   
  	    SignIn_Action.Execute(HolidayMaintenance_Admin_Extent_Test, driver);
   
  		System.out.println("Login Successfully.");
  		Log.info("Login Successfully.");
  		HolidayMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Login Successfully.");

  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");

  		String StrLnk_Admin = page_object.Profile_Admin_TestCases.Administration_Page.Admin;
  		Click_Action.Execute(driver, StrLnk_Admin);
  		Log.info("Click action performed on Admin ");
  		HolidayMaintenance_Admin_Extent_Test.log(LogStatus.PASS,"Click action performed on Admin ");

  		String StrAdminOptionsPath = page_object.Profile_Admin_TestCases.Administration_Page.strPath;
  		Log.info("Combined xPath is: "+StrAdminOptionsPath);
  		Object_Exist_Loop_Action.Execute(HolidayMaintenance_Admin_Extent_Test, StrAdminOptionsPath);
  		
  		String StrHolidayMaintenance = page_object.Profile_Admin_TestCases.Administration_Page.HolidayMaintenance;
  		Click_Action.Execute(driver, StrHolidayMaintenance);
  		Log.info("Click action performed on Holiday Maintenance");
  		HolidayMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on Holiday Maintenance");

  		String StrDiscrepancyMaintenancePath = page_object.Profile_Admin_TestCases.DiscrepancyMaintenance_Admin_Page.strPath;
  		Log.info("Combined xPath is: "+StrDiscrepancyMaintenancePath);
  		Object_Exist_Loop_Action.Execute(HolidayMaintenance_Admin_Extent_Test, StrDiscrepancyMaintenancePath);
  		
  		String StrAdd = page_object.Profile_Admin_TestCases.DiscrepancyMaintenance_Admin_Page.Add;
  		Click_Action.Execute(driver, StrAdd);
  		Log.info("Click action performed on ADD");
  		HolidayMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Click action performed on ADD");
  
  		
  		String winHandleBefore = driver.getWindowHandle();
		HolidayMaintenance_Admin_Page.datepicker(driver).click();

		for(String winHandle : driver.getWindowHandles()){
	  	    driver.switchTo().window(winHandle);
	  	  }
		
	  	String date = ExcelUtils.getExcelData("date", "HolidayMaintenance");
	  	System.out.println(date);
	      WebElement Dayelement = driver.findElement(By.xpath("//*[@href='javascript:returnDate("+date+")']"));
	      Dayelement.click();
	      Log.info(Dayelement + "Clicked Successfully.");    
	    driver.switchTo().window(winHandleBefore); 
	    
	    Utils.sleep(2000);
	    String ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;        
        ExcelUtils.setExcelFile(ExcelPath,"Admin_Cases");
	    String description = ExcelUtils.getExcelData("desc", "HolidayMaintenance");  
	    System.out.println("desc: "+description);
		HolidayMaintenance_Admin_Page.description(driver).sendKeys(description);
		HolidayMaintenance_Admin_Page.RegionEast(driver).click();
		HolidayMaintenance_Admin_Page.Save(driver).click();
		Utils.sleep(2000);
		HolidayMaintenance_Admin_Page.SelectAll(driver).click();
		HolidayMaintenance_Admin_Page.Delete(driver).click();
  		//page_object.Profile_Admin_TestCases.HolidayMaintenance_AdminSendkeys.Execute(driver);
  		Log.info("Holiday Maintenance function is done Successfully.");
  		HolidayMaintenance_Admin_Extent_Test.log(LogStatus.PASS, "Holiday Maintenance function is done Successfully.");
 		}

	@AfterMethod
    public void afterMethod() {

		extent.endTest(HolidayMaintenance_Admin_Extent_Test);
		extent.flush();

          }
}
