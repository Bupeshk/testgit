package msol.VM_TestCases;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import application_modules.Click_Action;
import application_modules.Object_Exist_Loop_Action;
import application_modules.SetSendKeys_Action;
import page_object.GUI_TestCases.Base_Class;
import utility.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;

public class KOIMSO_21 {
	
	 	public WebDriver driver;
	    private String sTestCaseName;    
	    String ExcelPath;
	    String Result;
	    private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
	    private ExtentTest VW_Callout_Functionality_Extent_Test = null;
	    public static ExtentReports extent = new ExtentReports("Test_Report/VW_Callout_Functionality.html", true);
  
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
	    public void VM_Callout_Functionality(String BrowserType, String testCaseId) throws Exception {
	    	
	    	try{
	    	
	    		VW_Callout_Functionality_Extent_Test  = extent.startTest(testCaseId, "");
		 		
		     	if (! GUI_Constant.executeTestCase){
		     		VW_Callout_Functionality_Extent_Test.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
		     		throw new SkipException("Skipping the test case as application is not available.");			
		     	}    
		     	ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;
				ExcelUtils.setExcelFile(ExcelPath,"VW_Cases");
		       
		         if (GUI_Constant.env.equalsIgnoreCase("Local")){
		         	if (BrowserType.equalsIgnoreCase("firefox"))
		         		driver = Utils.openVMBrowserFF();
		         	else
		         		driver = Utils.openVMBrowserIE();
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
				Utils.SetSendKeys(VW_Callout_Functionality_Extent_Test, strLogin, sUserName);
				
				String Submitbtn = page_object.VW_TestCases.VW_Login_Page.SubmitBtn;
				Click_Action.Execute(driver, Submitbtn);
				
				String SideMenu_lnk = page_object.VW_TestCases.VW_Home_Page.StrSideMenu;
				Object_Exist_Loop_Action.Execute(VW_Callout_Functionality_Extent_Test, SideMenu_lnk);
				
				String CCRSearch_Path = page_object.VW_TestCases.VW_Home_Page.CCRSearch_lnk;
				Click_Action.Execute(driver, CCRSearch_Path);
				
				String StrCCRSearchPath = page_object.VW_TestCases.VW_CCR_SearchPage.StrCCRPath;
				Log.info("Combined xPath is: "+StrCCRSearchPath);
				
				if(Object_Exist_Loop_Action.Execute(VW_Callout_Functionality_Extent_Test,StrCCRSearchPath))
					VW_Callout_Functionality_Extent_Test.log(LogStatus.PASS, "3", "CCR #/WO # ,TEO # ,PO# and Search Button Exist in CCR Search page");
				else
				{
					VW_Callout_Functionality_Extent_Test.log(LogStatus.FAIL, "3", "In CCR Search page atleast one field among 'CCR-WO Number/TEO number/Tracking number' does not Exist");
					Result = "In CCR Search page atleast one field among 'CCR-WO Number/TEO number/PO number' does not Exist";
					Base_Class.bResult=false;
				}
				
				String CCRNumber=ExcelUtils.getExcelData("CCR_Number","Callout_Functionality");
				Log.info("CCR# Fetched from Excel :" + CCRNumber);
				VW_Callout_Functionality_Extent_Test.log(LogStatus.INFO, "4", "CCR# Fetched from Excel :" + CCRNumber);
				String WONum_path = page_object.VW_TestCases.VW_CCR_SearchPage.WONumber;
				Utils.SetSendKeys(VW_Callout_Functionality_Extent_Test,WONum_path, CCRNumber);
				Log.info(CCRNumber + "placed in the edit field" );
				VW_Callout_Functionality_Extent_Test.log(LogStatus.INFO, "4", CCRNumber + "placed in the edit field");
				
				String SearchBtn = page_object.VW_TestCases.VW_CCR_SearchPage.SearchBtn;
				Click_Action.Execute(driver, SearchBtn);
				
				String CartBtn = page_object.VW_TestCases.VW_CCR_SearchPage.CartBtn;
				Click_Action.Execute(driver, CartBtn);
				
				/*String CCRNum_Path = "//font[contains(text(),'"+CCRNumber+"')]";
				Click_Action.Execute(driver, CCRNum_Path);
				
				String CalloutCCR_Btn = page_object.VW_TestCases.VW_CCR_SearchPage.CalloutCCR;
				Click_Action.Execute(driver, CalloutCCR_Btn); */
				
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
				
			    
			    
			    
			    String [] PO_Num = (ExcelUtils.getExcelData("PO_Number", "Callout_Functionality")).split(":");
			    String [] Line_Num = (ExcelUtils.getExcelData("Line_Number", "Callout_Functionality")).split(":");
			    String[] Callout_qty = (ExcelUtils.getExcelData("Callout_Quantity", "Callout_Functionality")).split(":");
			    for (int j=0 ; j<PO_Num.length;j++ ){ 
			    	//int PONum = (new Integer(PO_Num[j])).intValue();
			    		
		    		WebElement CalloutDetail_Chkbx1 = driver.findElement(By.xpath("//tr[contains(.,'"+PO_Num[j]+"') and contains(@class,'TRBG') and contains(.,'"+Line_Num[j]+"')]/td[1]/input"));
		    		CalloutDetail_Chkbx1.click();

			    	String strQtyOnHandPath = ExcelUtils.getExcelData("Qty_OnHand", "Callout_Functionality");

		    		if (strQtyOnHandPath!=null && strQtyOnHandPath.length() > 0)
		        	strQtyOnHandPath = strQtyOnHandPath + ":" + Utils.getText("//tr[contains(.,'"+PO_Num[j]+"') and contains(@class,'TRBG') and contains(.,'"+Line_Num[j]+"')]/td[12]");
			        else
			        	strQtyOnHandPath = Utils.getText("//tr[contains(.,'"+PO_Num[j]+"') and contains(@class,'TRBG') and contains(.,'"+Line_Num[j]+"')]/td[12]");
			        ExcelUtils.setExcelData(ExcelPath,"Qty_OnHand","Callout_Functionality",strQtyOnHandPath);
			    	
			    	WebElement CalloutDetail_Edtbx = driver.findElement(By.xpath("//tr[contains(.,'"+PO_Num[j]+"') and contains(@class,'TRBG') and contains(.,'"+Line_Num[j]+"')]/td[13]/input"));
			    	CalloutDetail_Edtbx.clear();	    	
			    	//Utils.SetSendKeys(VW_Callout_Functionality_Extent_Test,"//tr[contains(.,'"+PO_Num[j]+"') and contains(@class,'TRBG') and contains(.,'"+Line_Num[j]+"')]/td[13]/input']", Callout_qty[j].trim());
			    	CalloutDetail_Edtbx.sendKeys(Callout_qty[j].trim());	
			    }   
			    
			  /*  String [] Sel_Callout_details = (ExcelUtils.getExcelData("Sel_Callout_detail", "Callout_Functionality")).split(":");
			    String[] Callout_qty = (ExcelUtils.getExcelData("Callout_Quantity", "Callout_Functionality")).split(":");
			    for (int j=1 ; j<Sel_Callout_details.length+1;j++ ){ 
			    	int Sel_Callout_detail = (new Integer(Sel_Callout_details[j-1])).intValue();
			    	WebElement CalloutDetail_Chkbx = driver.findElement(By.xpath("//*[@name='coFlag' and @value='"+Sel_Callout_detail+"']"));
			    	CalloutDetail_Chkbx.click();
			    	
			    	String strQtyOnHandPath = ExcelUtils.getExcelData("Qty_OnHand", "Callout_Functionality");
			    	if (strQtyOnHandPath!=null && strQtyOnHandPath.length() > 0)
			        	strQtyOnHandPath = strQtyOnHandPath + ":" + Utils.getText("(.//*[@id='line0']/td[12])["+Sel_Callout_detail+"]");
			        else
			        	strQtyOnHandPath = Utils.getText("(.//*[@id='line0']/td[12])["+Sel_Callout_detail+"]");
			    	
			        ExcelUtils.setExcelData(ExcelPath,"Qty_OnHand","Callout_Functionality",strQtyOnHandPath);
			    	
			    	WebElement CalloutDetail_Edtbx = driver.findElement(By.xpath("//*[@name='calloutQty"+Sel_Callout_detail+"']"));
			    	CalloutDetail_Edtbx.clear();			    	
			    	Utils.SetSendKeys(VW_Callout_Functionality_Extent_Test,"//*[@name='calloutQty"+Sel_Callout_detail+"']", Callout_qty[j-1]);
			    }  */
				
			    Utils.sleep(1000);
			    
			    String CalloutBtn = page_object.VW_TestCases.VW_CalloutDetails_Page.Callout_Btn;
			    Click_Action.Execute(driver, CalloutBtn);
			    
			    String ShippingInfoChk = page_object.VW_TestCases.VW_ShippingInfo_Page.ShippingInfoValidation;
				Object_Exist_Loop_Action.Execute(VW_Callout_Functionality_Extent_Test, ShippingInfoChk);
				
				 Utils.sleep(5000);
				    
				 String grpShippingInfoPath = page_object.VW_TestCases.VW_ShippingInfo_Page.ShippingInfoPath;
				 String grpShippingInfoValues = page_object.VW_TestCases.VW_ShippingInfo_Page.ShippingInfoValues;
				 SetSendKeys_Action.Execute(VW_Callout_Functionality_Extent_Test,grpShippingInfoPath, grpShippingInfoValues); 
				 
				 String SubmitBtn = page_object.VW_TestCases.VW_ShippingInfo_Page.Submit_Btn;
				 Click_Action.Execute(driver, SubmitBtn);
				 				 
				 String ShippingInfoChk1 = page_object.VW_TestCases.VW_ShippingInfo_Page.Conf_ShippingInfoValidation;
				 Object_Exist_Loop_Action.Execute(VW_Callout_Functionality_Extent_Test, ShippingInfoChk1);
				
				 String ConfSubmitBtn = page_object.VW_TestCases.VW_ShippingInfo_Page.Submit_Btn;
				Click_Action.Execute(driver, ConfSubmitBtn);
				 
				 String Tracking_Number_Path = "//table[2]/tbody/tr[3]/td/a";
				 String StrTrackingNum = ExcelUtils.getExcelData("Tracking_Number", "Callout_Functionality");
				 if (StrTrackingNum!=null && StrTrackingNum.length() > 0)
					 StrTrackingNum = StrTrackingNum + ":" + Utils.getText(Tracking_Number_Path);
				 else
				     StrTrackingNum = Utils.getText(Tracking_Number_Path);
				   	 Log.info(StrTrackingNum);
				    	
				 ExcelUtils.setExcelData(ExcelPath,"Tracking_Number","Callout_Functionality",StrTrackingNum);
				 
				 Click_Action.Execute(driver, Tracking_Number_Path);
				 
				 Utils.existsElement(VW_Callout_Functionality_Extent_Test, "//td[contains(text(),'"+CCRNumber+"')]");
				 Log.info("CCR Number Exist in Delivery Details Page ");
				
				 Utils.existsElement(VW_Callout_Functionality_Extent_Test, "//a[contains(text(),'"+StrTrackingNum+"')]");
				 Log.info("Tracking Number Exist in Delivery Details Page ");
				 
				 String DeliveryDetail = page_object.VW_TestCases.VW_Delivery_Details.DeliveryDetail_Path;
				 Object_Exist_Loop_Action.Execute(VW_Callout_Functionality_Extent_Test, DeliveryDetail);
				 
				 DatabaseUtil dbUtil = new DatabaseUtil();
				 String status = dbUtil.checkRowForCalloutFunctionality(StrTrackingNum);
			  	 System.out.println("Status is : "+status);
			  	 
			  	 if (status.equalsIgnoreCase("fail")){
			  		 Log.error("No Row Found in calloutAction table for corresponding Tracking number: "+StrTrackingNum);
			  		 Base_Class.bResult=false;
			  	 }
			  	 
			  	 else if(status.equalsIgnoreCase("error")){
			  		Log.error("Database Connection Error");
			  		Base_Class.bResult=false;
			  	 }
			  	 
			  	 else{
			  		 Log.info("Row Exist in CalloutAction table for corresponding Tracking number: "+StrTrackingNum);
			  	 }
			 
				if(Base_Class.bResult==true){
			    	 
					ExcelUtils.setExcelData(ExcelPath, "Result", "Callout_Functionality", "Pass");
		 
				}else{
					
					throw new Exception("Test Case Failed because of Verification");
					
				}		    
			     
	    	}catch (Exception e){
		  	    
	    		ExcelUtils.setExcelData(ExcelPath, "Result", "Callout_Functionality", "Fail");
	    		 Log.error(e.getMessage());
	    		 VW_Callout_Functionality_Extent_Test.log(LogStatus.FAIL, e.getMessage());
	    		 throw (e);
			
	    		}
	    }

		@AfterMethod
		public void afterMethod() {
			
			Log.endTestCase(sTestCaseName);
			extent.endTest(VW_Callout_Functionality_Extent_Test);
			extent.flush();
			//driver.quit();
			
		}

}
