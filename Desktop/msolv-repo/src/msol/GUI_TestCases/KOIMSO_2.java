package msol.GUI_TestCases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.*;
import utility.*;
import application_modules.*;
import page_object.GUI_TestCases.*;


public class KOIMSO_2 {
	
	public WebDriver driver1;
    private String sTestCaseName;
    String ExcelPath;
    private ExtentTest Callout_Search_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("Test_Report/Callout_Search.html", true);
    String StrColoumnGrp;
    public String Reason;
    Utils ut = new Utils();
    
    @BeforeMethod
    @Parameters({"BrowserType1","testCaseId"})
    public void beforeMethod(String BrowserType1, String testCaseId) throws Exception {
	  
        DOMConfigurator.configure("log4j.xml");
        sTestCaseName = this.toString();
        String sTestCaseName = Utils.getTestCaseName(this.toString());
        Log.startTestCase(sTestCaseName);
    }
 
    
    @Test
    @Parameters({"BrowserType1","testCaseId"})
    public void Callout_Search(String BrowserType1, String testCaseId) throws Exception {
    	
    	try{
    		//Initializing the Test
    		
    		Callout_Search_Extent_Test  = extent.startTest(testCaseId, "");
    		
        	if (! GUI_Constant.executeTestCase){
        		Callout_Search_Extent_Test.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
        		throw new SkipException("Skipping the test case as application is not available.");			
        	}    
        	  ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File1_TestData;
              ExcelUtils.setExcelFile(ExcelPath,"Callout_Search");
          
            if (GUI_Constant.env.equalsIgnoreCase("Local")){
            	if (BrowserType1.equalsIgnoreCase("firefox"))
            		driver1 = Utils.openBrowserFF();
            	else
            		driver1 = Utils.openBrowserIE();
            }
            else{
            	if (BrowserType1.equalsIgnoreCase("firefox"))
            		driver1 = Utils.open_selhubFF();
            	else
            		driver1 = Utils.open_selhubIE();            	
            	
            }
            
            new Base_Class(driver1); 
			
		 //Initializing Extent report test	
		 Callout_Search_Extent_Test  = extent.startTest(testCaseId, "");	
		 //Login to the application
		 SignIn_Action.Execute(Callout_Search_Extent_Test,driver1);	
			String Calloutpath = Home_Page.Lookup;
			if(Utils.ispresent(Callout_Search_Extent_Test, Calloutpath)){
				Log.info("Login Successfully.");
				Callout_Search_Extent_Test.log(LogStatus.PASS, "1", "Login Successfully.");
				Reporter.log("Login Successfully.");
				
			}
			else{
				Log.info("Login Failed");
				Callout_Search_Extent_Test.log(LogStatus.FAIL, "1", ",Login Failed");
				ut.getScreenShot(driver1,testCaseId, "Login Failed",Callout_Search_Extent_Test); 
				Reason = "Login Failed, Please Check the Credentials";
				throw new Exception(Reason);
			}
		 
		 Log.info("**********STEP-1**********");

		 //Checking the existence of Callout menu button in Homepage
		 String strCallout = Home_Page.Callout;
		 if(Utils.existsElement(Callout_Search_Extent_Test, strCallout))
		 Callout_Search_Extent_Test.log(LogStatus.PASS, "1", "Callout Menu option exist in Home page");

		 Log.info("**********STEP-2**********");
		 
		 //Clicking the Callout Button
		 WebElement strElement = Home_Page.CalloutMenu(driver1);
		 MouseHoverIE.Execute(driver1, strElement, strElement);
		 Callout_Search_Extent_Test.log(LogStatus.INFO, "Callout Menu button clicked");
		 
		 //Checking Express callout page title
		 WebElement Pg_Title = Express_Callout_Page.PageTitle(driver1);
		 String StrPageTitle = Pg_Title.getText();
		 Log.info("Page loaded: "+StrPageTitle);
		 Callout_Search_Extent_Test.log(LogStatus.PASS, "2", "Page loaded: "+StrPageTitle);
		 
		 Log.info("**********STEP-3**********");
		 
		 int RowCount  = ExcelUtils.getRowCount() - 1;
	     System.out.println(RowCount);
	    		
	     for (int k=1; k<RowCount+1; k++){
	    	
			 //Checking Express Call Out Search page Elements
			 Utils.sleep(3000);
			 String StrCalloutPath = Express_Callout_Page.StrPath;
		     Log.info("Combined xPath is: "+StrCalloutPath);
		  	 if(Object_Exist_Loop_Action.Execute(Callout_Search_Extent_Test, StrCalloutPath))
		     Callout_Search_Extent_Test.log(LogStatus.PASS, "3", "Express Call Out Search page displays the search options CCR #/WO #, TEO # along with Submit & reset buttons");
		  		 
		  	 Log.info("**********STEP-4**********");
		  	 //Entering CCR# from Excel
			 String CCRNumber=ExcelUtils.getExcelData("CCR_Number", "Iteration"+k+"");
			 Log.info("CCR# Fetched from Excel :" + CCRNumber );
			 Callout_Search_Extent_Test.log(LogStatus.INFO, "CCR# Fetched from Excel :" + CCRNumber);
			 Express_Callout_Page.WONumber(driver1).sendKeys(CCRNumber );
			 Log.info(CCRNumber  + "placed in the edit field, in Express Call out page" );
			 Callout_Search_Extent_Test.log(LogStatus.INFO, CCRNumber  + "placed in the edit field, in Express Call out page");
			 
			 //Clicking Submit button in Express CallOut page
			 String SubmitBtn_path = Express_Callout_Page.SubmitBtn;
			 if(Click_Action.Execute(driver1, SubmitBtn_path))
			 Callout_Search_Extent_Test.log(LogStatus.PASS, "4","Submit button in Express CallOut page clicked Sucessfully  ");
			 else
			 Callout_Search_Extent_Test.log(LogStatus.ERROR, "4","Submit button in Express CallOut page not clicked or Found");
			
			 Log.info("**********STEP-5**********");
			 Utils.sleep(5000);
			 String StrCalloutDetailsPath = Callout_details.Str_CalloutDetails_Path;
		     Log.info("Combined xPath is: "+StrCalloutDetailsPath);
		     
		     Object_Exist_Loop_Action.Execute(Callout_Search_Extent_Test, StrCalloutDetailsPath);
		 
	
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
			    
		     
		     //Callout_details.CompareQtyOnHand("Qty_OnHand","Callout_Quantity","Callout_Functionality","Callout_Search");
		     ExcelUtils.setExcelFile(ExcelPath,"Callout_Functionality");
		     String CF_QtyHand = ExcelUtils.getExcelData("Qty_OnHand", "Iteration"+k+"");
		     String CF_Callout_Quantity = ExcelUtils.getExcelData("Callout_Quantity", "Iteration"+k+"");
		     int CF_QtyLeft = (new Integer(CF_QtyHand)).intValue() - (new Integer(CF_Callout_Quantity)).intValue();
		     
		     ExcelUtils.setExcelFile(ExcelPath,"Callout_Search");
		     int CS_QtyHand = new Integer(ExcelUtils.getExcelData("Qty_OnHand", "Iteration"+k+"")).intValue();
		     
		     if (!(CF_QtyLeft == CS_QtyHand)){
		    	 Log.error("Qty OnHand is not equal to (Previous Qty on hand - Call out quantity)"); 
		    	 Base_Class.bResult=false;
		    	 Reason = "Qty OnHand is not equal to (Previous Qty on hand - Call out quantity)";
		     }
		     else
		    	 Log.info("Qty OnHand is equal to (Previous Qty on hand - Call out quantity)"); 
		     
		     String StrPreCallout = Callout_details.PreviousCallouts;
		     Click_Action.Execute(driver1, StrPreCallout);
		     
		     ExcelUtils.setExcelFile(ExcelPath,"Callout_Functionality");
	     	 String TrackingNumber = ExcelUtils.getExcelData("Tracking_Number","Iteration"+k+"");
		 	 String [] TrackingArray = TrackingNumber.split(":");
		 	 Log.info("Tracking number Acquired from Callout Functionality is:  "+TrackingNumber);
		 	 for (int j=0 ; j<TrackingArray.length;j++ ){ 
		 		WebElement Tracking_element = driver1.findElement(By.xpath("//*[text()='"+TrackingArray[j]+"']"));
		 		Tracking_element.click();
		 		Log.info(Tracking_element + "Clicked Successfully");
		 		String StrTrackingDetailPath = Tracking_Details_page.strGetText;
			    Log.info("Combined xPath is: "+StrTrackingDetailPath);
			     
			    Object_Exist_Loop_Action.Execute(Callout_Search_Extent_Test, StrTrackingDetailPath);
			    String [] cellValueArray = Get_Text_Loop_Action.Execute(StrTrackingDetailPath);
			    StrColoumnGrp = Tracking_Details_page.strGetColName;
			    String [] ColoumnArray = StrColoumnGrp.split(":");
			    
			    ExcelUtils.setExcelFile(ExcelPath,"Callout_Search");
			     for(int i=0; i<cellValueArray.length;i++){
			     String strTrackVerif = ExcelUtils.getExcelData(ColoumnArray[i], "Iteration"+k+"");
			     if (strTrackVerif !=null && strTrackVerif.length() > 0){
			    	 strTrackVerif = strTrackVerif + ":" +cellValueArray[i];
			     	 ExcelUtils.setExcelData(ExcelPath,ColoumnArray[i],"Iteration"+k+"",strTrackVerif);
			     }
			     else
			    	 ExcelUtils.setExcelData(ExcelPath,ColoumnArray[i],"Iteration"+k+"",cellValueArray[i]);
			     }
			     
			     
			     String Back_btn = Tracking_Details_page.BackBtn;
			     Click_Action.Execute(driver1, Back_btn);		 
			     
				}
		 		
		 	 Tracking_Details_page.CompareTrackingDetails(StrColoumnGrp);
		 	
		 	 
		 	 
		 	 if(Base_Class.bResult==true){
		    	 
				// If the value of boolean variable is True, then your test is complete pass and do this
	 
				ExcelUtils.setExcelData(ExcelPath, "Result", "Iteration"+k+"", "Pass");
	 
			 }else{
	 
				throw new Exception(Reason);
	 
			 }	
	     }

	}catch (Exception e){
  	    
		// ExcelUtils.setExcelData(ExcelPath, "Result", "Iteration"+k+"", "Fail");
		 extent.endTest(Callout_Search_Extent_Test);
		 Log.error(e.getMessage());
		 extent.flush();
		 throw (e);
		 
	 }

	 	 
	 	 }     
	     
	     
	    
	
  
	@AfterMethod
	public void afterMethod() {
		
		 Log.endTestCase(sTestCaseName);
		  extent.endTest(Callout_Search_Extent_Test);
		  extent.flush();
		 
	  	 //driver1.quit();
	   
		
		
		
	}

}
