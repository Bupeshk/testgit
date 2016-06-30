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
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;

public class KOIMSO_22 {
	
	public WebDriver driver;
    private String sTestCaseName;    
    String ExcelPath;
    String Result;
    private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
    private ExtentTest VW_Delivery_Functionality_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/VW_Delivery_Functionality.html", true);

    @BeforeMethod
    @Parameters({"BrowserType","testCaseId"})
    public void beforeMethod(String BrowserType, String testCaseId) throws Exception {
	  
        DOMConfigurator.configure("log4j.xml");
        sTestCaseName = this.toString();
        String sTestCaseName = Utils.getTestCaseName(this.toString());
        Log.startTestCase(sTestCaseName);
    }
	
    @Test
	@Parameters({"BrowserType","testCaseId"})
	public void VW_Delivery_Functionality(String BrowserType, String testCaseId) throws Exception {
		
	    	
    	try{
		    	
			VW_Delivery_Functionality_Extent_Test  = extent.startTest(testCaseId, "");
	 		
	     	if (! GUI_Constant.executeTestCase){
	     		VW_Delivery_Functionality_Extent_Test.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
	     		throw new SkipException("Skipping the test case as application is not available.");			
	     	}    
	     	ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;
			ExcelUtils.setExcelFile(ExcelPath,"VW_Cases");
	       
	         if (GUI_Constant.env.equalsIgnoreCase("Local")){
	         	if (BrowserType.equalsIgnoreCase("firefox"))
	         		driver = Utils.openVMBrowserFF();
	         	else
	         		driver = Utils.openBrowserIE();
	         }
	         else{
	         	if (BrowserType.equalsIgnoreCase("firefox"))
	         		driver = Utils.openVMBrowserFF();
	         	else
	         		driver = Utils.open_selhubIE();            	
	         	
	         }
	         
	         new Base_Class(driver);  
		         
			String strLogin = page_object.VW_TestCases.VW_Login_Page.UserID;
			String sUserName = putil.getEnvironmentProperty("VW_Username");
			Utils.SetSendKeys(VW_Delivery_Functionality_Extent_Test, strLogin, sUserName);
			
			String Submitbtn = page_object.VW_TestCases.VW_Login_Page.SubmitBtn;
			Click_Action.Execute(driver, Submitbtn);
			
			String SideMenu_lnk = page_object.VW_TestCases.VW_Home_Page.StrSideMenu;
			Object_Exist_Loop_Action.Execute(VW_Delivery_Functionality_Extent_Test, SideMenu_lnk);
			
			String Delivery_Path = page_object.VW_TestCases.VW_Home_Page.Delivery_lnk;
			Click_Action.Execute(driver, Delivery_Path);
			
			String StrCCRSearchPath = page_object.VW_TestCases.VW_CCR_SearchPage.StrDeliveryPath;
			Log.info("Combined xPath is: "+StrCCRSearchPath);
			
			if(Object_Exist_Loop_Action.Execute(VW_Delivery_Functionality_Extent_Test,StrCCRSearchPath))
				VW_Delivery_Functionality_Extent_Test.log(LogStatus.PASS, "3", "CCR #/WO # ,TEO # ,Tracking number and Search Button Exist in CCR Search page");
			else
			{
				VW_Delivery_Functionality_Extent_Test.log(LogStatus.FAIL, "3", "In CCR Search page atleast one field among 'CCR-WO Number/TEO number/Tracking number/Search Button' does not Exist");
				Result = "In CCR Search page atleast one field among 'CCR-WO Number/TEO number/Tracking number/Search Button' does not Exist";
				Base_Class.bResult=false;
			}
			
			String TrackingNumber=ExcelUtils.getExcelData("Tracking_Number","Callout_Functionality");
			Log.info("Tracking Number Fetched from Excel :" + TrackingNumber);
			VW_Delivery_Functionality_Extent_Test.log(LogStatus.INFO, "4", "Tracking Number Fetched from Excel :" + TrackingNumber);
			String TrackingNum_path = page_object.VW_TestCases.VW_CCR_SearchPage.Tracking_Number;
			Utils.SetSendKeys(VW_Delivery_Functionality_Extent_Test,TrackingNum_path, TrackingNumber);
			Log.info(TrackingNumber + "placed in the edit field" );
			VW_Delivery_Functionality_Extent_Test.log(LogStatus.INFO, "4", TrackingNumber + "placed in the edit field");
			
			String CCRSearchBtn = page_object.VW_TestCases.VW_CCR_SearchPage.SearchBtn;
			Click_Action.Execute(driver, CCRSearchBtn);
			 
			String DeliveryStatus = Utils.getText(page_object.VW_TestCases.VW_CCR_SearchPage.DeliveryStatus).trim();
			if(DeliveryStatus.equals("N")){
				String TrackingPath = "(//a[contains(text(),'"+TrackingNumber+"')])[1]";
				Click_Action.Execute(driver, TrackingPath);
			}
			else{
				Log.error(TrackingNumber+": Deilivery transaction already processed");
				VW_Delivery_Functionality_Extent_Test.log(LogStatus.ERROR, "9", TrackingNumber+": Deilivery transaction already processed");	
				Result = TrackingNumber+": Deilivery transaction already processed";
				throw new Exception(Result);
			}
			 
			String DeliveryDetail = page_object.VW_TestCases.VW_Delivery_Details.DeliveryDetail_Path;
			Object_Exist_Loop_Action.Execute(VW_Delivery_Functionality_Extent_Test, DeliveryDetail);
			 
			String SignedBy = page_object.VW_TestCases.VW_Delivery_Details.SignedBy;
			Utils.SetSendKeys(VW_Delivery_Functionality_Extent_Test, SignedBy, sUserName);
			 
			String CheckBx = page_object.VW_TestCases.VW_Delivery_Details.DeliveryChkbx;
			Click_Action.Execute(driver, CheckBx);
			 
			String Delivery_SumbitBtn = page_object.VW_TestCases.VW_Delivery_Details.SubmitBtn;
			Click_Action.Execute(driver, Delivery_SumbitBtn);
			 
			String ConfirmMsg =  page_object.VW_TestCases.VW_Delivery_Details.ConfirmMsg;
			Utils.existsElement(VW_Delivery_Functionality_Extent_Test, ConfirmMsg);
			
			Click_Action.Execute(driver, Delivery_Path);
			Utils.SetSendKeys(VW_Delivery_Functionality_Extent_Test,TrackingNum_path, TrackingNumber);			 
			Click_Action.Execute(driver, CCRSearchBtn);
			
			String DeliveryStatus1 = Utils.getText(page_object.VW_TestCases.VW_CCR_SearchPage.DeliveryStatus).trim();
			if(DeliveryStatus1.equals("Y")){
				Log.info(TrackingNumber+"Deilivery transaction has been successfully processed");
				VW_Delivery_Functionality_Extent_Test.log(LogStatus.PASS, "9", TrackingNumber+"Deilivery transaction has been successfully processed");
			}
			else{
				Log.error(TrackingNumber+": Status has not changed to 'Y' in Delivery Search Results Page");
				VW_Delivery_Functionality_Extent_Test.log(LogStatus.ERROR, "9", TrackingNumber+": Status has not changed to 'Y' in Delivery Search Results Page");	
				Result = TrackingNumber+": Status has not changed to 'Y' in Delivery Search Results Page";
				Base_Class.bResult=false;
			}
			 
			
			if(Base_Class.bResult==true){
		    	 
				ExcelUtils.setExcelData(ExcelPath, "Result", "Delivery_Functionality", "Pass");
	 
			}else{
				
				throw new Exception(Result);
				
			}		    
		     
    	}catch (Exception e){
	  	    
    		 ExcelUtils.setExcelData(ExcelPath, "Result", "Delivery_Functionality", "Fail");
    		 Log.error(e.getMessage());
    		 VW_Delivery_Functionality_Extent_Test.log(LogStatus.FAIL, e.getMessage());
    		 throw (e);
		
		}
	}
	  
	@AfterMethod
	public void afterMethod() {
		
		Log.endTestCase(sTestCaseName);
		extent.endTest(VW_Delivery_Functionality_Extent_Test);
		extent.flush();
		//driver.quit();
		
	}

}
