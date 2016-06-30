package msol.GUI_TestCases;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import application_modules.Click_Action;
import application_modules.MouseHoverIE;
import application_modules.Object_Exist_Loop_Action;
import application_modules.SignIn_Action;
import page_object.GUI_TestCases.Base_Class;
import page_object.GUI_TestCases.CCR_TEO_PO_Search_Page;
import page_object.GUI_TestCases.Home_Page;
import utility.GUI_Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;

public class KOIMSO_3 {
	
	public WebDriver driver;
	private String sTestCaseName;
	WebElement StrElement;
	String ExcelPath;
	public String Reason;
	Utils ut = new Utils();
	private ExtentTest Callout_Details_Search_Extent_Test = null;
	public static ExtentReports extent = new ExtentReports("Test_Report/Callout_Details_Search.html", true);
	
	
	@BeforeMethod
    @Parameters({"BrowserType1","testCaseId"})
    public void beforeMethod(String BrowserType, String testCaseId) throws Exception {
	  
    	DOMConfigurator.configure("log4j.xml");
        sTestCaseName = this.toString();
        String sTestCaseName = Utils.getTestCaseName(this.toString());
        Log.startTestCase(sTestCaseName);
        
    }
	 

    @Test
    @Parameters({"BrowserType1","testCaseId"})
    public void Callout_Details_Search(String BrowserType1, String testCaseId) throws Exception {
    	
		try{
		
			//Initializing the Test
		
			Callout_Details_Search_Extent_Test  = extent.startTest(testCaseId, "");
			
			if (! GUI_Constant.executeTestCase){
				Callout_Details_Search_Extent_Test.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
			throw new SkipException("Skipping the test case as application is not available.");			
			}    
			ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File1_TestData; 
			ExcelUtils.setExcelFile(ExcelPath,"Callout_Details_Search");
			  
			    if (GUI_Constant.env.equalsIgnoreCase("Local")){
			if (BrowserType1.equalsIgnoreCase("firefox"))
					driver = Utils.openBrowserFF();
				else
					driver = Utils.openBrowserIE();
			}
			else{
				if (BrowserType1.equalsIgnoreCase("firefox"))
			    		driver = Utils.open_selhubFF();
			    	else
			    		driver = Utils.open_selhubIE();            	
			    	
			    }
			    
			new Base_Class(driver); 
			
			SignIn_Action.Execute(Callout_Details_Search_Extent_Test,driver);	
			String Calloutpath = Home_Page.Lookup;
			if(Utils.ispresent(Callout_Details_Search_Extent_Test, Calloutpath)){
				Log.info("Login Successfully.");
				Callout_Details_Search_Extent_Test.log(LogStatus.PASS, "1", "Login Successfully.");
				Reporter.log("Login Successfully.");
				
			}
			else{
				Log.info("Login Failed");
				Callout_Details_Search_Extent_Test.log(LogStatus.FAIL, "1", ",Login Failed");
				ut.getScreenShot(driver,testCaseId, "Login Failed",Callout_Details_Search_Extent_Test); 
				Reason = "Login Failed, Please Check the Credentials";
				throw new Exception(Reason);
			}
			
			WebElement Callout_element = Home_Page.LookUp(driver);
			StrElement = Home_Page.LookUp_CCRSearch(driver);
			MouseHoverIE.Execute(driver, Callout_element, StrElement);
			Callout_Details_Search_Extent_Test.log(LogStatus.PASS, "2", "Clicked CCR Search Succesfully");
			
			//MouseHover_Action.Execute(driver,Callout_element);
			//Log.info("Lookup mouse hover performed");
			
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Log.info("Implicit wait applied on the driver for 10 seconds");
				
			   // StrPath = Home_Page.StrPath;
			//Log.info("Combined xPath is: "+StrPath);
			
			//Object_Exist_Loop_Action.Execute(StrPath);
			
			
			//StrElement.click();
			//Log.info("Click action performed on CCR_TEO_PO_Search");
			
			int RowCount  = ExcelUtils.getRowCount();
    		System.out.println(RowCount);
    		
    		for (int k=1; k<RowCount+1; k++){
 			
			Utils.sleep(5000);
			String StrCCRSearchPath = CCR_TEO_PO_Search_Page.StrCCRPath;
			Log.info("Combined xPath is: "+StrCCRSearchPath);
			if(Object_Exist_Loop_Action.Execute(Callout_Details_Search_Extent_Test,StrCCRSearchPath))
				Callout_Details_Search_Extent_Test.log(LogStatus.PASS, "3", "CCR #/WO # ,TEO # ,PO#  Exist ");
			else{
				Callout_Details_Search_Extent_Test.log(LogStatus.FAIL, "3", "CCR #/WO # ,TEO # ,PO# Do Not Exist ");
				 Base_Class.bResult=false;
		    	 Reason = "CCR #/WO # ,TEO # ,PO# Do Not Exist in CCR_Search_Page )";
			}
			
			String CCRNumber=ExcelUtils.getExcelData("CCR_Number", "Iteration"+k+"");
			Log.info("CCR# Fetched from Excel :" + CCRNumber );
			String WONum_path = CCR_TEO_PO_Search_Page.WONumber;
			Utils.SetSendKeys(Callout_Details_Search_Extent_Test, WONum_path, CCRNumber);
			Log.info(CCRNumber + "placed in the edit field" );
			  
			String Submit_BtnPath = CCR_TEO_PO_Search_Page.SubmitBtn;
			Click_Action.Execute(driver, Submit_BtnPath);
			
			int Excess_Material_ColList = driver.findElements(By.xpath("//*[@class='FIELDTITLE']")).size();
			int Excess_Material_ColList1 = driver.findElements(By.xpath("//*[@class='FIELDTITLE sortable']")).size();
			int TotalExcess_Material_ColList = Excess_Material_ColList+Excess_Material_ColList1;
			Log.info("Number of Columns :" + TotalExcess_Material_ColList );
			  
			for (int i=1; i<TotalExcess_Material_ColList+1; i++){
			 
				String Excess_Material_ColDetail_Path = "//*[@id='searchList']/thead/tr/th["+i+"]";  
				Utils.getText(Excess_Material_ColDetail_Path);
				  
			}
			    
			String Cart_BtnPath = CCR_TEO_PO_Search_Page.CartBtn;
			Click_Action.Execute(driver, Cart_BtnPath);
			
			
			int LineDetails_rowcount = driver.findElements(By.xpath("//*[@name='checkgroup']")).size();
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
			   
			    String [] Sel_Callout_details = (ExcelUtils.getExcelData("Sel_Callout_detail", "Iteration"+k+"")).split(":");
			 for (int j=0 ; j<Sel_Callout_details.length;j++ ){ 
				
				 int Sel_Callout_detail = (new Integer(Sel_Callout_details[j])).intValue();
				 String strQtyOnHandPath = ExcelUtils.getExcelData("Qty_OnHand", "Iteration"+k+"");
			 if (strQtyOnHandPath!=null && strQtyOnHandPath.length() > 0)
				strQtyOnHandPath = strQtyOnHandPath + ":" + Utils.getText("//table/tbody/tr["+(Sel_Callout_detail+2)+"]/td[12]");
			 else
				strQtyOnHandPath = Utils.getText("//table/tbody/tr["+(Sel_Callout_detail+2)+"]/td[12]");	
			 ExcelUtils.setExcelData(ExcelPath,"Qty_OnHand","Iteration"+k+"",strQtyOnHandPath);
			 }
			
			 ExcelUtils.setExcelFile(ExcelPath,"Callout_Functionality");
		     String CF_QtyHand = ExcelUtils.getExcelData("Qty_OnHand", "Iteration"+k+"");
		     String CF_Callout_Quantity = ExcelUtils.getExcelData("Callout_Quantity", "Iteration"+k+"");
		     int CF_QtyLeft = (new Integer(CF_QtyHand)).intValue() - (new Integer(CF_Callout_Quantity)).intValue();
		     
		     ExcelUtils.setExcelFile(ExcelPath,"Callout_Details_Search");
		     int CS_QtyHand = new Integer(ExcelUtils.getExcelData("Qty_OnHand", "Iteration"+k+"")).intValue();
		     
		     if (!(CF_QtyLeft == CS_QtyHand)){
		    	 Log.error("Qty OnHand is not equal to (Previous Qty on hand - Call out quantity)"); 
		    	 Base_Class.bResult=false;
		    	 Reason = "Qty OnHand is not equal to (Previous Qty on hand - Call out quantity)";
		     }
		     else
		    	 Log.info("Qty OnHand is equal to (Previous Qty on hand - Call out quantity)"); 
			
			if(Base_Class.bResult==true){
				 
				// If the value of boolean variable is True, then your test is complete pass and do this
			 
						ExcelUtils.setExcelData(ExcelPath, "Result", "Iteration"+k+"", "Pass");
			 
					}else{
			 
						throw new Exception(Reason);
			 
					}		    
				    
    		}    
		}catch (Exception e){
		  	    
			//ExcelUtils.setExcelData(ExcelPath, "Result", sTestCaseName, "Fail");
			 extent.endTest(Callout_Details_Search_Extent_Test);
			 Log.error(e.getMessage());
			 extent.flush();
			 throw (e);
			 
		 }
		
		
		}

	@AfterMethod
    public void afterMethod() {
   
		Log.endTestCase(sTestCaseName);
		extent.endTest(Callout_Details_Search_Extent_Test);
		extent.flush();
  	  // driver.quit();
   
          }
   
}
