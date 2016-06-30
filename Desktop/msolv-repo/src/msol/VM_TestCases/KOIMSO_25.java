package msol.VM_TestCases;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import application_modules.Click_Action;
import application_modules.Object_Exist_Loop_Action;
import page_object.GUI_TestCases.Base_Class;
import utility.ExcelUtils;
import utility.GUI_Constant;
import utility.Log;
import utility.PropertyUtility;
import utility.Utils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class KOIMSO_25 {
	
	public WebDriver driver;
    String sTestCaseName;    
    String ExcelPath;
    String Result;
    private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
    private ExtentTest VW_Reports_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/VW_Reports.html", true);

    @BeforeMethod
    @Parameters("BrowserType")
    public void beforeMethod(String BrowserType) throws Exception {
 
		 DOMConfigurator.configure("log4j.xml");
		 sTestCaseName = this.toString();
		 String sTestCaseName = Utils.getTestCaseName(this.toString());
		 Log.startTestCase(sTestCaseName);
		 ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;
		 ExcelUtils.setExcelFile(ExcelPath,"VW_Cases");
		 if (BrowserType.equalsIgnoreCase("firefox")){
	        	driver = Utils.openVMBrowserFF();
	     }
	     else{
	        	driver = Utils.openBrowserIE();
	     }
		 new Base_Class(driver);  
	 	 
    }	
	
	@Test
	@Parameters("testCaseId")
	public void Reports(String testCaseId) throws Exception {
		
		try{
	    	
			VW_Reports_Extent_Test  = extent.startTest(testCaseId, "");
			String strLogin = page_object.VW_TestCases.VW_Login_Page.UserID;
			String sUserName = putil.getEnvironmentProperty("VW_Username");
			Utils.SetSendKeys(VW_Reports_Extent_Test, strLogin, sUserName);
			
			String Submitbtn = page_object.VW_TestCases.VW_Login_Page.SubmitBtn;
			Click_Action.Execute(driver, Submitbtn);
			
			String SideMenu_lnk = page_object.VW_TestCases.VW_Home_Page.StrSideMenu;
			Object_Exist_Loop_Action.Execute(VW_Reports_Extent_Test, SideMenu_lnk);
			
			String Reports_Path = page_object.VW_TestCases.VW_Home_Page.Reports_lnk;
			Click_Action.Execute(driver, Reports_Path);
			
			String Report_link = page_object.VW_TestCases.VW_Reports.Reports_Lnk;
			Object_Exist_Loop_Action.Execute(VW_Reports_Extent_Test, Report_link);
			
			String Vendor_Deliver = page_object.VW_TestCases.VW_Reports.VendorDeliver;
			Click_Action.Execute(driver, Vendor_Deliver);
			
			String Radio_link = page_object.VW_TestCases.VW_Reports.Radio_lnk;
			Object_Exist_Loop_Action.Execute(VW_Reports_Extent_Test, Radio_link);
			
			String Screen_Lnk = page_object.VW_TestCases.VW_Reports.Screen;
			Click_Action.Execute(driver, Screen_Lnk);
			
			String SubmitBtn = page_object.VW_TestCases.VW_Reports.Submit_Btn;
			Click_Action.Execute(driver, SubmitBtn);
			
			String ScreenChk = page_object.VW_TestCases.VW_Reports.ScreenChk;
			utility.Utils.existsElement(VW_Reports_Extent_Test, ScreenChk);
			
			Click_Action.Execute(driver, Reports_Path);
			Object_Exist_Loop_Action.Execute(VW_Reports_Extent_Test, Report_link);
			Click_Action.Execute(driver, Vendor_Deliver);
			Object_Exist_Loop_Action.Execute(VW_Reports_Extent_Test, Radio_link);
			
			String Excel_Lnk = page_object.VW_TestCases.VW_Reports.Excel;
			Click_Action.Execute(driver, Excel_Lnk);
			
			Click_Action.Execute(driver, SubmitBtn);
			
			Runtime.getRuntime().exec("src/test_data/clickok.exe"); 
			  
			Utils.sleep(20000);
			
			if(Base_Class.bResult==true){
		    	 
				ExcelUtils.setExcelData(ExcelPath, "Result", "Delivery_Functionality", "Pass");
	 
			}else{
				
				throw new Exception(Result);
				
			}		    
		     
    	}catch (Exception e){
	  	    
    		 ExcelUtils.setExcelData(ExcelPath, "Result", "Delivery_Functionality", "Fail");
    		 Log.error(e.getMessage());
    		 VW_Reports_Extent_Test.log(LogStatus.FAIL, e.getMessage());
    		 throw (e);
		
		}
	}
	  
	@AfterMethod
	public void afterMethod() {
		
		Log.endTestCase(sTestCaseName);
		extent.endTest(VW_Reports_Extent_Test);
		extent.flush();
		//driver.quit();
		
	}
}
