package msol.GUI_TestCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utility.*;
import application_modules.*;
import page_object.GUI_TestCases.*;


public class KOIMSO_1 {
 
    public WebDriver driver;
    private String sTestCaseName;
    private WebElement StrElement;    
    String ExcelPath;
    //String ExcelPath1;
    private ExtentTest Callout_Functionality_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/Callout_Functionality.html", true);
    public String Reason;
    Utils ut = new Utils();
    PropertyUtility  putil = new PropertyUtility(GUI_Constant.HOME_PAGE_FILEPATH);
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
    public void Callout_Functionality(String BrowserType1, String testCaseId) throws Exception {
    	
    	try{
    		//Initializing the Test
    		
    		Callout_Functionality_Extent_Test  = extent.startTest(testCaseId, "");
    		
        	if (! GUI_Constant.executeTestCase){
        		Callout_Functionality_Extent_Test.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
        		throw new SkipException("Skipping the test case as application is not available.");			
        	}    
        	  ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File1_TestData;
              ExcelUtils.setExcelFile(ExcelPath,"Callout_Functionality");
          
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
        
    		
    		
    		Log.info("**********STEP-1**********");
    		
    		//Signing in to the application
			SignIn_Action.Execute(Callout_Functionality_Extent_Test,driver);	
			String Calloutpath = Home_Page.Lookup;
			if(Utils.ispresent(Callout_Functionality_Extent_Test, Calloutpath)){
				Log.info("Login Successfully.");
				Callout_Functionality_Extent_Test.log(LogStatus.PASS, "1", "Login Successfully.");
				Reporter.log("Login Successfully.");
				
			}
			else{
				Log.info("Login Failed");
				Callout_Functionality_Extent_Test.log(LogStatus.FAIL, "1", ",Login Failed");
				ut.getScreenShot(driver,testCaseId, "Login Failed",Callout_Functionality_Extent_Test); 
				Reason = "Login Failed, Please Check the Credentials";
				throw new Exception(Reason);
			}
			Log.info("**********STEP-2**********");
			
			//Looking for the Lookup Menu Button and then clicking the CCR search link 
			WebElement Callout_element = Home_Page.LookUp(driver);
			StrElement = Home_Page.LookUp_CCRSearch(driver);
			MouseHoverIE.Execute(driver, Callout_element, StrElement);
			Callout_Functionality_Extent_Test.log(LogStatus.PASS, "2", "Clicked CCR Search Succesfully");
			
		/*	MouseHover_Action.Execute(driver,Callout_element);
			Log.info("Lookup mouse hover performed");
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Log.info("Implicit wait applied on the driver for 10 seconds");
				
			StrPath = Home_Page.StrPath;
			Log.info("Combined xPath is: "+StrPath);
			
			Object_Exist_Loop_Action.Execute(StrPath);
						
			StrElement.click();
			Log.info("Click action performed on CCR_TEO_PO_Search");  */
			
			Log.info("**********STEP-3**********");
			

    		int RowCount  = ExcelUtils.getRowCount();
    		
    		for (int k=1; k<RowCount+1; k++){
 
			Utils.sleep(5000);
			String StrCCRSearchPath = CCR_TEO_PO_Search_Page.StrCCRPath;
			Log.info("Combined xPath is: "+StrCCRSearchPath);
			
			if(Object_Exist_Loop_Action.Execute(Callout_Functionality_Extent_Test,StrCCRSearchPath))
				Callout_Functionality_Extent_Test.log(LogStatus.PASS, "3", "CCR #/WO # ,TEO # ,PO#  Exist ");
			else{
				Callout_Functionality_Extent_Test.log(LogStatus.FAIL, "3", "CCR #/WO # ,TEO # ,PO# Do Not Exist ");
				ut.getScreenShot(driver,testCaseId, "CCR #/WO # ,TEO # ,PO# Do Not Exist",Callout_Functionality_Extent_Test); 
			}
			String CCRNumber=ExcelUtils.getExcelData("CCR_Number","Iteration"+k+"");
			Log.info("CCR# Fetched from Excel :" + CCRNumber);
			Callout_Functionality_Extent_Test.log(LogStatus.INFO, "4", "CCR# Fetched from Excel :" + CCRNumber);
			String WONum_path = CCR_TEO_PO_Search_Page.WONumber;
			Utils.SetSendKeys(Callout_Functionality_Extent_Test,WONum_path, CCRNumber);
			Log.info(CCRNumber + "placed in the edit field" );
			  
			String Submit_BtnPath = CCR_TEO_PO_Search_Page.SubmitBtn;
			Click_Action.Execute(driver, Submit_BtnPath);
			
			int CCR_ColList = driver.findElements(By.xpath("//*[@class='FIELDTITLE']")).size();
			int CCR_ColList1 = driver.findElements(By.xpath("//*[@class='FIELDTITLE sortable']")).size();
			int TotalExcess_Material_ColList = CCR_ColList+CCR_ColList1;
			Log.info("Number of Columns :" + TotalExcess_Material_ColList );
			  
			for (int i=1; i<TotalExcess_Material_ColList+1; i++){
			 
				String CCR_Path = "//*[@id='searchList']/thead/tr/th["+i+"]";  
				Utils.getText(CCR_Path);
				  
			}
			    
			String Cart_BtnPath = CCR_TEO_PO_Search_Page.CartBtn;
			Click_Action.Execute(driver, Cart_BtnPath);
			
			String CCRDetailsHeader = CCR_Details_Page.CCRDetails_Header;
			if(Utils.ispresent(Callout_Functionality_Extent_Test, CCRDetailsHeader))
			{
				String winHandleBefore = driver.getWindowHandle();
				
				String VendorManager = CCR_Details_Page.VendorManager_Search;
				Click_Action.Execute(driver, VendorManager);
				
				for(String winHandle : driver.getWindowHandles()){
			  	    driver.switchTo().window(winHandle);
			  	}
				
				String Engineer = CCR_Details_Page.InstallOpion;
				Click_Action.Execute(driver, Engineer);
				
				String Submit_Eng = CCR_Details_Page.SubmitBtn;
				Click_Action.Execute(driver, Submit_Eng);
				
				driver.switchTo().window(winHandleBefore);
				
				String TeamLead = CCR_Details_Page.Team_Lead;
				Click_Action.Execute(driver, TeamLead);
				
				for(String winHandle : driver.getWindowHandles()){
			  	    driver.switchTo().window(winHandle);
			  	}
			
				Click_Action.Execute(driver, Engineer);
				Click_Action.Execute(driver, Submit_Eng);
				
				driver.switchTo().window(winHandleBefore);
				
				String SaveBtn = CCR_Details_Page.SaveBtn;
				Click_Action.Execute(driver, SaveBtn);
				
				Runtime.getRuntime().exec("src/test_data/clickok.exe"); 
				Utils.sleep(10000);
				
				String CalloutCCRBtn = CCR_Details_Page.CalloutCCR;
				Click_Action.Execute(driver, CalloutCCRBtn);
			}	
			
			int LineDetails_rowcount = driver.findElements(By.xpath("//*[@name='checkgroup']")).size();
		    Log.info("Number of rows :" + LineDetails_rowcount );
		    
		    int CallOutQty_count = driver.findElements(By.xpath("//input[contains(@type , 'text')]")).size();
		    Log.info("Number of rows :" + CallOutQty_count );
		    
		    if (LineDetails_rowcount == CallOutQty_count){
		    	Log.info("For each Call Out Lines row, Callout Quantity column has textbox to enter the quantity number to be called out.");	    		    	
		    }
		    else{
		    	Log.error("Callout Quantity column textboxes are missing in Callout details page");
				Reason = "Textbox verification in Callout Details Page";
		    	Base_Class.bResult=false;
		    }
		    
		    /*String StrPreCallout = Callout_details.PreviousCallouts;
		    Click_Action.Execute(driver, StrPreCallout);
		    
		    Utils.sleep(5000);
		    
		    String StrTrackingInfo = Tracking_Information.TrakInfoHeader;
		    Utils.existsElement(Callout_Functionality_Extent_Test,StrTrackingInfo);
		   	
		    String StrTrackingInfo_BackBtn = Tracking_Information.Backbtn;
		    Click_Action.Execute(driver, StrTrackingInfo_BackBtn);  */
		    
		   
		    String [] PO_Num = (ExcelUtils.getExcelData("PO_Number", "Iteration"+k+"")).split(":");
		    String [] Line_Num = (ExcelUtils.getExcelData("Line_Number", "Iteration"+k+"")).split(":");
		    String[] Callout_qty = (ExcelUtils.getExcelData("Callout_Quantity", "Iteration"+k+"")).split(":");
		    for (int j=0 ; j<PO_Num.length;j++ ){ 
		    	int PONum = (new Integer(PO_Num[j])).intValue();
		    	
		    	if (Line_Num[j]!=null && Line_Num[j].length() > 0){
		    		
		    		WebElement CalloutDetail_Chkbx1 = driver.findElement(By.xpath("//tr[contains(.,'"+PO_Num[j]+"') and contains(@class,'TRBG') and contains(.,'"+Line_Num[j]+"')]/td[1]/input"));
		    		CalloutDetail_Chkbx1.click();
		    		
		    	}
		    	else{
		    		
		    		WebElement CalloutDetail_Chkbx1 = driver.findElement(By.xpath("//td[contains(text(),'"+PO_Num[j]+"')]/../td[1]/input[1]"));
		    		CalloutDetail_Chkbx1.click();
		    		
		    	}
		    
		    	String strQtyOnHandPath = ExcelUtils.getExcelData("Qty_OnHand", "Iteration"+k+"");
		    	if (strQtyOnHandPath!=null && strQtyOnHandPath.length() > 0)
		        	strQtyOnHandPath = strQtyOnHandPath + ":" + Utils.getText("//table/tbody/tr["+(PONum+2)+"]/td[12]");
		        else
		        	strQtyOnHandPath = Utils.getText("//table/tbody/tr["+(PONum+2)+"]/td[12]");
		    	
		        ExcelUtils.setExcelData(ExcelPath,"Qty_OnHand","Iteration"+k+"",strQtyOnHandPath);
		    	
		    	WebElement CalloutDetail_Edtbx = driver.findElement(By.xpath("//*[@name='callOutQty"+PONum+"']"));
		    	CalloutDetail_Edtbx.clear();	    	
		    	Utils.SetSendKeys(Callout_Functionality_Extent_Test,"//*[@name='callOutQty"+PONum+"']", Callout_qty[j].trim());
		    }
		    
			
		    String CalloutSel = Callout_details.CalloutSel;
		    Click_Action.Execute(driver, CalloutSel);
		   
		    Utils.sleep(5000);
		    
		    
		    String ShippingInstruction_Value = ExcelUtils.getExcelData("Shipping_Instruction","Iteration"+k+"");
			String JobSiteFloor_Value = ExcelUtils.getExcelData("JobSite_Floor","Iteration"+k+"");
			String Contactname_Value = ExcelUtils.getExcelData("Contact_person_Name","Iteration"+k+"");
		    String ContactEmail_Value = ExcelUtils.getExcelData("Contact_email","Iteration"+k+"");
			String ContactPhone1_Value = ExcelUtils.getExcelData("Contact_phone1","Iteration"+k+"");
			String ContactPhone2_Value = ExcelUtils.getExcelData("Contact_phone2","Iteration"+k+"");
			String ContactPhone3_Value = ExcelUtils.getExcelData("Contact_phone3","Iteration"+k+"");
			
			String ShippingInfoValues = ShippingInstruction_Value+":"+JobSiteFloor_Value+":"+Contactname_Value+":"+ContactEmail_Value+":"+ContactPhone1_Value+":"+ContactPhone2_Value+":"+ContactPhone3_Value;
		    
		    String grpShippingInfoPath = Shipping_Info_Page.ShippingInfoPath;
		    SetSendKeys_Action.Execute(Callout_Functionality_Extent_Test,grpShippingInfoPath, ShippingInfoValues); 
		    
		    String ContinueBtn = Shipping_Info_Page.Continue_Btn;
		    Click_Action.Execute(driver, ContinueBtn);
		    
		    String ShippingConfimPath = Shipping_Info_Page.ShippingConfim;
	        Log.info("Combined xPath is: "+ShippingConfimPath);
	   		Object_Exist_Loop_Action.Execute(Callout_Functionality_Extent_Test,ShippingConfimPath);
	   		Get_Text_Loop_Action.Execute(ShippingConfimPath);
	   		
	   		String MobileNumPath = Shipping_Info_Page.Mobile_Num;
	   		String MobileNum = Utils.getText(MobileNumPath);
	   		ExcelUtils.setExcelData(ExcelPath,"Contact_phone","Iteration"+k+"",MobileNum);
	   		String DatePath = Shipping_Info_Page.Date;
	   		String Date = Utils.getText(DatePath);
	   		ExcelUtils.setExcelData(ExcelPath,"Ship_Date","Iteration"+k+"",Date);
	   		
	   		String Shipping_SubmitBtn = Shipping_Info_Page.SubmitBtn;
		    Click_Action.Execute(driver, Shipping_SubmitBtn);
		    
		    for (int l=0 ; l<PO_Num.length;l++ ){ 
		    String Tracking_Number_Path = "//table[3]/tbody/tr[2]/td/a["+(l+1)+"]";
		   
		    String StrTrackingNum = ExcelUtils.getExcelData("Tracking_Number", "Iteration"+k+"");
	    	if (StrTrackingNum!=null && StrTrackingNum.length() > 0)
	    		StrTrackingNum = StrTrackingNum + ":" + Utils.getText(Tracking_Number_Path);
	        else
	        	StrTrackingNum = Utils.getText(Tracking_Number_Path);
	    		Log.info(StrTrackingNum);
	    	
	        ExcelUtils.setExcelData(ExcelPath,"Tracking_Number","Iteration"+k+"",StrTrackingNum);
		    
		    }
		   
		    WebElement Callout_element1 = Home_Page.LookUp(driver);
		    WebElement StrElement1 = Home_Page.LookUp_CCRSearch(driver);
		    MouseHoverIE.Execute(driver, Callout_element1, StrElement1);
    		 
		    if(Base_Class.bResult==true){
		    	 
				ExcelUtils.setExcelData(ExcelPath, "Result", "Iteration"+k+"", "Pass");
	 
			}else{
				
				ExcelUtils.setExcelData(ExcelPath, "Result", "Iteration"+k+"", "Fail");
				throw new Exception(Reason);
				
			}		    
    	}	     
    	}catch (Exception e){
	  	    
    		// ExcelUtils.setExcelData(ExcelPath, "Result", "Iteration"+k+"", "Fail");
    		 extent.endTest(Callout_Functionality_Extent_Test);
    		 Log.error(e.getMessage());
    		 extent.flush();
    		 throw (e);
    		 
    	 }

    	
  		}
  		
	@AfterMethod
    public void afterMethod() throws Exception {
		
	  //String strLogout = Home_Page.Logout;
	  // Click_Action.Execute(driver, strLogout);
	  Log.endTestCase(sTestCaseName);
	  extent.endTest(Callout_Functionality_Extent_Test);
	  extent.flush();
	 
  	 // driver.quit();
   
          }
   
 
}
