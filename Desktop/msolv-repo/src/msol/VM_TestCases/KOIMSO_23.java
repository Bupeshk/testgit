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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class KOIMSO_23 {
	
	public WebDriver driver;
    private String sTestCaseName;    
    String ExcelPath;
    String Result;
    String[] Callout_qty;
    
    private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
    private ExtentTest VW_CalloutSearch_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/VW_Callout_Search.html", true);

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
    public void VW_Callout_Search(String testCaseId) throws Exception {
		
		try{
			
		
			VW_CalloutSearch_Extent_Test  = extent.startTest(testCaseId, "");
			String strLogin = page_object.VW_TestCases.VW_Login_Page.UserID;
			String sUserName = putil.getEnvironmentProperty("VW_Username");
			Utils.SetSendKeys(VW_CalloutSearch_Extent_Test, strLogin, sUserName);
			
			String Submitbtn = page_object.VW_TestCases.VW_Login_Page.SubmitBtn;
			Click_Action.Execute(driver, Submitbtn);
			
			String SideMenu_lnk = page_object.VW_TestCases.VW_Home_Page.StrSideMenu;
			Object_Exist_Loop_Action.Execute(VW_CalloutSearch_Extent_Test, SideMenu_lnk);
			
			String CalloutSearch_lnk = page_object.VW_TestCases.VW_Home_Page.CalloutSearch_lnk;
			Click_Action.Execute(driver, CalloutSearch_lnk);
			
			String CalloutSearchPage = page_object.VW_TestCases.VW_CalloutSearch_Page.CalloutPage;
			Object_Exist_Loop_Action.Execute(VW_CalloutSearch_Extent_Test, CalloutSearchPage);
			
			String TrackingNumber=ExcelUtils.getExcelData("Tracking_Number","Callout_Functionality");
			Log.info("Tracking Number Fetched from Excel :" + TrackingNumber);
			VW_CalloutSearch_Extent_Test.log(LogStatus.INFO, "4", "Tracking Number Fetched from Excel :" + TrackingNumber);
			String TrackingNum_path = page_object.VW_TestCases.VW_CalloutSearch_Page.CalloutTrackingNum;
			Utils.SetSendKeys(VW_CalloutSearch_Extent_Test,TrackingNum_path, TrackingNumber);
			Log.info(TrackingNumber + "placed in the edit field" );
			VW_CalloutSearch_Extent_Test.log(LogStatus.INFO, "4", TrackingNumber + "placed in the edit field");
			
			String CCRSearchBtn = page_object.VW_TestCases.VW_CalloutSearch_Page.SubmitBtn;
			Click_Action.Execute(driver, CCRSearchBtn);
			
			String CCRNumber=ExcelUtils.getExcelData("CCR_Number","Callout_Details_Search");
			Log.info("CCR# Fetched from Excel :" + CCRNumber);
			VW_CalloutSearch_Extent_Test.log(LogStatus.INFO, "4", "CCR# Fetched from Excel :" + CCRNumber);
			
			
			String CartBtn = page_object.VW_TestCases.VW_CCR_SearchPage.CartBtn;
			Click_Action.Execute(driver, CartBtn);
			
			String CCRNum_Path = "//font[contains(text(),'"+CCRNumber+"')]";
			//Click_Action.Execute(driver, CCRNum_Path);
			
			String CalloutCCR_Btn = page_object.VW_TestCases.VW_CCR_SearchPage.CalloutCCR;
			//Click_Action.Execute(driver, CalloutCCR_Btn); */
			
			String CheckBx_Path = page_object.VW_TestCases.VW_CalloutDetails_Page.Checkbox;
			int LineDetails_rowcount = driver.findElements(By.xpath(CheckBx_Path)).size();
		    Log.info("Number of rows :" + LineDetails_rowcount );
		    
		    int CallOutQty_count = driver.findElements(By.xpath("//input[contains(@type , 'text')]")).size();
		    Log.info("Number of rows :" + CallOutQty_count );
		    
		    if (LineDetails_rowcount == CallOutQty_count){
		    	Log.info("For each Call Out Lines row, Callout Quantity column has textbox to enter the quantity number to be called out.");	    		    	
		    }
		    else{
		    	Log.error("Callout Quantity column textboxes are missing in Callout details page");
		    	Base_Class.bResult=false;
		    }
			
		    String [] Sel_Callout_details = (ExcelUtils.getExcelData("Sel_Callout_detail", "Callout_Details_Search")).split(":");
		    Callout_qty = (ExcelUtils.getExcelData("Callout_Quantity", "Callout_Functionality")).split(":");
		    
			for (int j=1 ; j<Sel_Callout_details.length+1;j++ ){ 
		    	int Sel_Callout_detail = (new Integer(Sel_Callout_details[j-1])).intValue();
		    	WebElement CalloutDetail_Chkbx = driver.findElement(By.xpath("//*[@name='coFlag' and @value='"+Sel_Callout_detail+"']"));
		    	CalloutDetail_Chkbx.click();
		    	
		    	String strQtyOnHandPath = ExcelUtils.getExcelData("Qty_OnHand", "Callout_Details_Search");
		    	if (strQtyOnHandPath!=null && strQtyOnHandPath.length() > 0)
		        	strQtyOnHandPath = strQtyOnHandPath + ":" + Utils.getText("(.//*[@id='line0']/td[12])["+Sel_Callout_detail+"]");
		        else
		        	strQtyOnHandPath = Utils.getText("(.//*[@id='line0']/td[12])["+Sel_Callout_detail+"]");
		    	
		        ExcelUtils.setExcelData(ExcelPath,"Qty_OnHand","Callout_Details_Search",strQtyOnHandPath);
		    	
		    	WebElement CalloutDetail_Edtbx = driver.findElement(By.xpath("//*[@name='calloutQty"+Sel_Callout_detail+"']"));
		    	CalloutDetail_Edtbx.clear();			    	
		    	Utils.SetSendKeys(VW_CalloutSearch_Extent_Test,"//*[@name='calloutQty"+Sel_Callout_detail+"']", Callout_qty[j-1]);
		    }
			
		    String CalloutBtn = page_object.VW_TestCases.VW_CalloutDetails_Page.Callout_Btn;
		    Click_Action.Execute(driver, CalloutBtn);
		    
		    String ShippingInfoChk = page_object.VW_TestCases.VW_ShippingInfo_Page.ShippingInfoValidation;
			Object_Exist_Loop_Action.Execute(VW_CalloutSearch_Extent_Test, ShippingInfoChk);
			
			 Utils.sleep(5000);
			    
			 String grpShippingInfoPath = page_object.VW_TestCases.VW_ShippingInfo_Page.ShippingInfoPath;
			 String grpShippingInfoValues = page_object.VW_TestCases.VW_ShippingInfo_Page.ShippingInfoValues;
			 SetSendKeys_Action.Execute(VW_CalloutSearch_Extent_Test,grpShippingInfoPath, grpShippingInfoValues); 
			 
			 String SubmitBtn = page_object.VW_TestCases.VW_ShippingInfo_Page.Submit_Btn;
			 Click_Action.Execute(driver, SubmitBtn);
			 				 
			 String ShippingInfoChk1 = page_object.VW_TestCases.VW_ShippingInfo_Page.Conf_ShippingInfoValidation;
			 Object_Exist_Loop_Action.Execute(VW_CalloutSearch_Extent_Test, ShippingInfoChk1);
			
			 String ConfSubmitBtn = page_object.VW_TestCases.VW_ShippingInfo_Page.Submit_Btn;
			Click_Action.Execute(driver, ConfSubmitBtn);
			 
			 String Tracking_Number_Path = "//table[2]/tbody/tr[3]/td/a";
			 String StrTrackingNum = ExcelUtils.getExcelData("Tracking_Number", "Callout_Details_Search");
			 if (StrTrackingNum!=null && StrTrackingNum.length() > 0)
				 StrTrackingNum = StrTrackingNum + ":" + Utils.getText(Tracking_Number_Path);
			 else
			     StrTrackingNum = Utils.getText(Tracking_Number_Path);
			   	 Log.info(StrTrackingNum);
			    	
			 ExcelUtils.setExcelData(ExcelPath,"Tracking_Number","Callout_Details_Search",StrTrackingNum);
			 
			 Click_Action.Execute(driver, Tracking_Number_Path);
			 
			 Utils.existsElement(VW_CalloutSearch_Extent_Test, "//td[contains(text(),'"+CCRNumber+"')]");
			 Log.info("CCR Number Exist in Delivery Details Page ");
			
			 Utils.existsElement(VW_CalloutSearch_Extent_Test, "//a[contains(text(),'"+StrTrackingNum+"')]");
			 Log.info("Tracking Number Exist in Delivery Details Page ");
			 
			 String DeliveryDetail = page_object.VW_TestCases.VW_Delivery_Details.DeliveryDetail_Path;
			 Object_Exist_Loop_Action.Execute(VW_CalloutSearch_Extent_Test, DeliveryDetail);
			 
			 String SignedBy = page_object.VW_TestCases.VW_Delivery_Details.SignedBy;
			 Utils.SetSendKeys(VW_CalloutSearch_Extent_Test, SignedBy, sUserName);
				 
			 String CheckBx = page_object.VW_TestCases.VW_Delivery_Details.DeliveryChkbx;
			 Click_Action.Execute(driver, CheckBx);
			 
			 String Delivery_SumbitBtn = page_object.VW_TestCases.VW_Delivery_Details.SubmitBtn;
			 Click_Action.Execute(driver, Delivery_SumbitBtn);
			 
			 String ConfirmMsg =  page_object.VW_TestCases.VW_Delivery_Details.ConfirmMsg;
			 Utils.existsElement(VW_CalloutSearch_Extent_Test, ConfirmMsg);
			 
			 Click_Action.Execute(driver, CalloutSearch_lnk);
			 Utils.SetSendKeys(VW_CalloutSearch_Extent_Test,TrackingNum_path, TrackingNumber);
			 Log.info(TrackingNumber + "placed in the edit field" );
			 VW_CalloutSearch_Extent_Test.log(LogStatus.INFO, "4", TrackingNumber + "placed in the edit field");
			 Click_Action.Execute(driver, CCRSearchBtn);
			 Click_Action.Execute(driver, CCRNum_Path);
			 Click_Action.Execute(driver, CalloutCCR_Btn);
			
			 for (int k=1 ; k<Sel_Callout_details.length+1;k++ ){ 
			    	int Sel_Callout_detail = (new Integer(Sel_Callout_details[k-1])).intValue();
				
			    	String strQtyOnHandPath1 = ExcelUtils.getExcelData("Qty_OnHand_After", "Callout_Details_Search");
			    	if (strQtyOnHandPath1!=null && strQtyOnHandPath1.length() > 0)
			        	strQtyOnHandPath1 = strQtyOnHandPath1 + ":" + Utils.getText("(.//*[@id='line0']/td[12])["+Sel_Callout_detail+"]");
			        else{
			        	strQtyOnHandPath1 = Utils.getText("(.//*[@id='line0']/td[12])["+Sel_Callout_detail+"]");
			        	ExcelUtils.setExcelData(ExcelPath,"Qty_OnHand_After","Callout_Details_Search",strQtyOnHandPath1);
			        } 	
			 }
			 
			 String [] QTYOnHand = (ExcelUtils.getExcelData("Qty_OnHand", "Callout_Details_Search")).split(":");
			 String [] QTYOnHandAfter = (ExcelUtils.getExcelData("Qty_OnHand_After", "Callout_Details_Search")).split(":");
			 for (int i=0; i<QTYOnHand.length;i++ ){ 
				 
				 if((new Integer(QTYOnHand[i]).intValue()-new Integer(Callout_qty[i]).intValue())==new Integer(QTYOnHandAfter[i]).intValue()){
					 Log.info("QTY on Hand Value Updated according to Callout Quantity"); 
				 }
				 else{
					 Log.info("QTY on hand Value not updated"); 
				 }
			 }
			 
			if(Base_Class.bResult==true){
		    	 
				ExcelUtils.setExcelData(ExcelPath, "Result", "Callout_Details_Search", "Pass");
	 
			}else{
				
				throw new Exception(Result);
				
			}		    
		     
    	}catch (Exception e){
	  	    
    		ExcelUtils.setExcelData(ExcelPath, "Result", "Callout_Details_Search", "Fail");
    		 Log.error(e.getMessage());
    		 VW_CalloutSearch_Extent_Test.log(LogStatus.FAIL, e.getMessage());
    		 throw (e);
		
    		}
    }
  
 	@AfterMethod
 	public void afterMethod() {
 		
 		Log.endTestCase(sTestCaseName);
		extent.endTest(VW_CalloutSearch_Extent_Test);
		extent.flush();
		driver.quit();
 		
 	}

}
