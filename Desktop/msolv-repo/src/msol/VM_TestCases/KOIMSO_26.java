package msol.VM_TestCases;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import application_modules.Click_Action;
import application_modules.Object_Exist_Loop_Action;
import application_modules.SetSendKeys_Action;
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

public class KOIMSO_26 {
	public WebDriver driver;
    private String sTestCaseName;    
    String ExcelPath;
    String Result;
    private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
    private ExtentTest VW_Discrepancies_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/VW_Discrepancies.html", true);

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
    public void Discrepancies(String testCaseId) throws Exception {
	  
    	try{
	    	
    		VW_Discrepancies_Extent_Test  = extent.startTest(testCaseId, "");
			String strLogin = page_object.VW_TestCases.VW_Login_Page.UserID;
			String sUserName = putil.getEnvironmentProperty("VW_Username");
			Utils.SetSendKeys(VW_Discrepancies_Extent_Test, strLogin, sUserName);
			
			String Submitbtn = page_object.VW_TestCases.VW_Login_Page.SubmitBtn;
			Click_Action.Execute(driver, Submitbtn);
			
			String SideMenu_lnk = page_object.VW_TestCases.VW_Home_Page.StrSideMenu;
			Object_Exist_Loop_Action.Execute(VW_Discrepancies_Extent_Test, SideMenu_lnk);
			
			String Discrepancies_lnk = page_object.VW_TestCases.VW_Home_Page.Discrepancies_lnk;
			Click_Action.Execute(driver, Discrepancies_lnk);
			
			String DiscrepencyFieldExist = page_object.VW_TestCases.VW_Discrepancies_Page.Discrepency_FieldExist;
			Log.info("Combined xPath is: "+DiscrepencyFieldExist);
			
			if(Object_Exist_Loop_Action.Execute(VW_Discrepancies_Extent_Test,DiscrepencyFieldExist))
				VW_Discrepancies_Extent_Test.log(LogStatus.PASS, "3", "PO#,part#,Quantity,Discrepancy type,Discrepancy Discription and Search Button Exist in Discrepancies page");
			else
			{
				VW_Discrepancies_Extent_Test.log(LogStatus.FAIL, "3", "In Discrepancies page atleast one field among 'PO#/part#/Quantity/Discrepancy type/Discrepancy Discription/Search Button' does not Exist");
				Result = "In Discrepancies page atleast one field among 'PO#/part#/Quantity/Discrepancy type/Discrepancy Discription/Search Button' does not Exist";
				Base_Class.bResult=false;
			}
			
			String Discrepancies_Paths = page_object.VW_TestCases.VW_Discrepancies_Page.Discrepency_Fieldpath;
			String Discrepancies_Values = page_object.VW_TestCases.VW_Discrepancies_Page.Discrepency_FieldValue;
		    SetSendKeys_Action.Execute(VW_Discrepancies_Extent_Test, Discrepancies_Paths, Discrepancies_Values);
			
		    String Discrepancy_Type = page_object.VW_TestCases.VW_Discrepancies_Page.DiscrepencyType;
		    String DiscrepancyType_Value = page_object.VW_TestCases.VW_Discrepancies_Page.DiscrepencyType_Value;
		    Utils.SelDropDown1(Discrepancy_Type, DiscrepancyType_Value);
		    
		    String SubmitBtn = page_object.VW_TestCases.VW_Discrepancies_Page.SubmitBtn;
		    Click_Action.Execute(driver, SubmitBtn);
		    
		    String ConfirmMsg =  page_object.VW_TestCases.VW_Discrepancies_Page.ConfirmMsg;
			if(Utils.existsElement(VW_Discrepancies_Extent_Test, ConfirmMsg)){
				Log.info("Discrepancies transaction has been successfully processed. ");
				 VW_Discrepancies_Extent_Test.log(LogStatus.PASS, "Discrepancies transaction has been successfully processed. ");
			}
			else{
				String DiscrepancyMsgPath =  page_object.VW_TestCases.VW_Discrepancies_Page.DiscrepencyMsg;
				String DiscrepancyMsg = Utils.getText(DiscrepancyMsgPath);
				Log.info(DiscrepancyMsg);
				VW_Discrepancies_Extent_Test.log(LogStatus.FAIL, DiscrepancyMsg);
				Result = DiscrepancyMsg;
			}
			
			if(Base_Class.bResult==true){
		    	 
				ExcelUtils.setExcelData(ExcelPath, "Result", "Callout_Functionality", "Pass");
	 
			}else{
				
				throw new Exception(Result);
				
			}		    
		     
    	}catch (Exception e){
	  	    
    		ExcelUtils.setExcelData(ExcelPath, "Result", "Callout_Functionality", "Fail");
    		 Log.error(e.getMessage());
    		 VW_Discrepancies_Extent_Test.log(LogStatus.FAIL, e.getMessage());
    		 throw (e);
		
    		}
    }

	@AfterMethod
	public void afterMethod() {
		
		Log.endTestCase(sTestCaseName);
		extent.endTest(VW_Discrepancies_Extent_Test);
		extent.flush();
		driver.quit();
		
	}

}
