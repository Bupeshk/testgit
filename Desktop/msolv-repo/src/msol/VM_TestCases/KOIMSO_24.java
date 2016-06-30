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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class KOIMSO_24 {
	
	public WebDriver driver;
    String sTestCaseName;    
    String ExcelPath;
    String Result;
    private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
    private ExtentTest VW_Receiving_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/VW_Receiving.html", true);

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
	public void Receiving(String testCaseId) throws Exception {
		try{
			VW_Receiving_Extent_Test  = extent.startTest(testCaseId, "");
			String strLogin = page_object.VW_TestCases.VW_Login_Page.UserID;
			String sUserName = putil.getEnvironmentProperty("VW_Username");
			Utils.SetSendKeys(VW_Receiving_Extent_Test, strLogin, sUserName);
			
			String Submitbtn = page_object.VW_TestCases.VW_Login_Page.SubmitBtn;
			Click_Action.Execute(driver, Submitbtn);
			
			String SideMenu_lnk = page_object.VW_TestCases.VW_Home_Page.StrSideMenu;
			Object_Exist_Loop_Action.Execute(VW_Receiving_Extent_Test, SideMenu_lnk);
			
			String Receiving_lnk = page_object.VW_TestCases.VW_Home_Page.Receiving_lnk;
			Click_Action.Execute(driver, Receiving_lnk);
			
			String StrCCRSearchPath = page_object.VW_TestCases.VW_CCR_SearchPage.StrReceivingPath;
			Log.info("Combined xPath is: "+StrCCRSearchPath);
			
			if(Object_Exist_Loop_Action.Execute(VW_Receiving_Extent_Test,StrCCRSearchPath))
				VW_Receiving_Extent_Test.log(LogStatus.PASS, "3", "CCR #/WO # ,TEO # and Search Button Exist in CCR Search page");
			else
			{
				VW_Receiving_Extent_Test.log(LogStatus.FAIL, "3", "In CCR Search page atleast one field among 'CCR-WO Number/TEO number/Search Button' does not Exist");
				Result = "In CCR Search page atleast one field among 'CCR-WO Number/TEO number/Search Button' does not Exist";
				Base_Class.bResult=false;
			}
			
			String CCRNumber=ExcelUtils.getExcelData("CCR_Number","Receiving");
			Log.info("CCR# Fetched from Excel :" + CCRNumber);
			VW_Receiving_Extent_Test.log(LogStatus.INFO, "4", "CCR# Fetched from Excel :" + CCRNumber);
			String WONum_path = page_object.VW_TestCases.VW_CCR_SearchPage.R_WONumber;
			Utils.SetSendKeys(VW_Receiving_Extent_Test,WONum_path, CCRNumber);
			Log.info(CCRNumber + "placed in the edit field" );
			VW_Receiving_Extent_Test.log(LogStatus.INFO, "4", CCRNumber + "placed in the edit field");
			
			String PONumber=ExcelUtils.getExcelData("PO_Number","Receiving");
			Log.info("CCR# Fetched from Excel :" + PONumber);
			VW_Receiving_Extent_Test.log(LogStatus.INFO, "4", "CCR# Fetched from Excel :" + PONumber);
			String PONum_path = page_object.VW_TestCases.VW_CCR_SearchPage.R_PONumber;
			Utils.SetSendKeys(VW_Receiving_Extent_Test,PONum_path, PONumber);
			Log.info(PONumber + "placed in the edit field" );
			VW_Receiving_Extent_Test.log(LogStatus.INFO, "4", PONumber + "placed in the edit field");
			
			String SearchBtn = page_object.VW_TestCases.VW_CCR_SearchPage.SearchBtn;
			Click_Action.Execute(driver, SearchBtn);
			
			int RedLight_Count = driver.findElements(By.xpath("//img[@src ='images/red.gif']")).size();		
			Log.info(Integer.toString(RedLight_Count));
			VW_Receiving_Extent_Test.log(LogStatus.INFO, Integer.toString(RedLight_Count));
			for (int i=1 ; i<RedLight_Count+1; i++ ){ 
				String StrRedPO_Path = "(//img[@src ='images/red.gif'])[1]/../../td[3]/a";
				Click_Action.Execute(driver, StrRedPO_Path);
				
				String ReceivingDetails_Pg = page_object.VW_TestCases.VW_ReceivingDetails_Page.ReceivingDetails;
				Object_Exist_Loop_Action.Execute(VW_Receiving_Extent_Test, ReceivingDetails_Pg);
				
				String ReceiveChkBx = page_object.VW_TestCases.VW_ReceivingDetails_Page.Receive_Chkbx;
				Click_Action.Execute(driver, ReceiveChkBx);
				
				String ReceiveBtn = page_object.VW_TestCases.VW_ReceivingDetails_Page.Receive_Btn;
				Click_Action.Execute(driver, ReceiveBtn);
				
				String ConfirmMsg = page_object.VW_TestCases.VW_ReceivingDetails_Page.Confirm_Msg;
				Utils.getText(ConfirmMsg);
				VW_Receiving_Extent_Test.log(LogStatus.INFO, ConfirmMsg);
				Log.info(ConfirmMsg);
				
				String GreeLight = page_object.VW_TestCases.VW_ReceivingDetails_Page.Green_Light;
				if(Utils.existsElement(VW_Receiving_Extent_Test, GreeLight)){
					
					VW_Receiving_Extent_Test.log(LogStatus.PASS, "Red light turn to green");
					Log.info("Red light turn to green");
				}
				else{
					
					VW_Receiving_Extent_Test.log(LogStatus.PASS, "Red light didnt turn to green");
					Log.error("Red light didnt turn to green");
					Result = "Red light didnt turn to green";
					Base_Class.bResult=false;
				}				
				
			}
			
			
			
			if(Base_Class.bResult==true){
		    	 
				ExcelUtils.setExcelData(ExcelPath, "Result", "Delivery_Functionality", "Pass");
	 
			}else{
				
				throw new Exception(Result);
				
			}		    
		     
    	}catch (Exception e){
	  	    
    		 ExcelUtils.setExcelData(ExcelPath, "Result", "Delivery_Functionality", "Fail");
    		 Log.error(e.getMessage());
    		 VW_Receiving_Extent_Test.log(LogStatus.FAIL, e.getMessage());
    		 throw (e);
		
		}
	}
	  
	@AfterMethod
	public void afterMethod() {
		
		Log.endTestCase(sTestCaseName);
		extent.endTest(VW_Receiving_Extent_Test);
		extent.flush();
		//driver.quit();
		
	}

}
