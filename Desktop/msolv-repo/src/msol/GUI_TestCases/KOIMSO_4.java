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
import page_object.GUI_TestCases.CCR_MaterialSummary;
import page_object.GUI_TestCases.CCR_TEO_PO_Search_Page;
import page_object.GUI_TestCases.Home_Page;
import page_object.GUI_TestCases.MD_Request_Form;
import page_object.GUI_TestCases.MaterialComments_Page;
import page_object.GUI_TestCases.TEODetails_Page;
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

public class KOIMSO_4 {
	
	 public WebDriver driver;
	 
	    private String sTestCaseName;			
	    private WebElement StrElement;
	    
	    String ExcelPath;
	    private ExtentTest Material_Summary_Extent_Test = null;
	   	public static ExtentReports extent = new ExtentReports("Test_Report/Material_Summary.html", true);
	  
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
	   	public void Material_Summary(String BrowserType1, String testCaseId) throws Exception {

			try{
			
				//Initializing the Test
			
				Material_Summary_Extent_Test  = extent.startTest(testCaseId, "");
				
				if (! GUI_Constant.executeTestCase){
					Material_Summary_Extent_Test.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
				throw new SkipException("Skipping the test case as application is not available.");			
				}    
				ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File1_TestData; 
				ExcelUtils.setExcelFile(ExcelPath,"Material_Summary");
				  
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
	 
				SignIn_Action.Execute(Material_Summary_Extent_Test, driver);
				Log.info("Login Successfully.");
				Reporter.log("Login Successfully.");
				
				WebElement Callout_element = Home_Page.LookUp(driver);
				StrElement = Home_Page.LookUp_CCRSearch(driver);
				MouseHoverIE.Execute(driver, Callout_element, StrElement);
				
				
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
					Object_Exist_Loop_Action.Execute(Material_Summary_Extent_Test, StrCCRSearchPath);
					
					String CCRNumber=ExcelUtils.getExcelData("CCR_Number", "Iteration"+k+"");
					Log.info("CCR# Fetched from Excel :" + CCRNumber );
					String WONum_path = CCR_TEO_PO_Search_Page.WONumber;
					Utils.SetSendKeys(Material_Summary_Extent_Test, WONum_path, CCRNumber);
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
					
					String MDBtn_Path = CCR_TEO_PO_Search_Page.MDBtn;
					Click_Action.Execute(driver, MDBtn_Path);
				
					String StrCCRSummarypath = CCR_MaterialSummary.CCRMaterialpath;
					Log.info("Combined xPath is: "+StrCCRSummarypath);
					Object_Exist_Loop_Action.Execute(Material_Summary_Extent_Test, StrCCRSummarypath);
					
					String CCRNUM_Verif = "//a[text()='"+CCRNumber+"']";
					Utils.existsElement(Material_Summary_Extent_Test, CCRNUM_Verif);
					
					int CCRMaterial_ColList = driver.findElements(By.xpath("//*[@class='FIELDTITLE']")).size();
					Log.info("Number of Columns :" + CCRMaterial_ColList );
					  
					for (int i=2; i<CCRMaterial_ColList+2; i++){
					 
						String Excess_Material_ColDetail_Path = "//table[7]/tbody/tr[1]/td["+i+"]/a/b";  
						Utils.getText(Excess_Material_ColDetail_Path);
						  
					}
					
					String CCRButtonPath = CCR_MaterialSummary.CCRMaterialBtnPath;
					Log.info("Combined xPath is: "+CCRButtonPath);
					Object_Exist_Loop_Action.Execute(Material_Summary_Extent_Test, CCRButtonPath);
					
					String winHandleBefore = driver.getWindowHandle();
					
					String CCRCommentBtn = CCR_MaterialSummary.CommentsBtn;
					Click_Action.Execute(driver, CCRCommentBtn);
					
					for(String winHandle : driver.getWindowHandles()){
			    	    driver.switchTo().window(winHandle);
			    	    driver.manage().window().maximize();
			    	}
			     
					Utils.sleep(5000);
					String Comment_Elements = MaterialComments_Page.Comments_path;
					Log.info("Combined xPath is: "+Comment_Elements);
					Object_Exist_Loop_Action.Execute(Material_Summary_Extent_Test, Comment_Elements);
					
					Utils.sleep(5000);
					String CommentText_value = ExcelUtils.getExcelData("Comment_Text",  "Iteration"+k+"");
					String CommentText = MaterialComments_Page.CommentText;
					Utils.SetSendKeys(Material_Summary_Extent_Test, CommentText, CommentText_value);
					
					
					String TEOPath = MaterialComments_Page.SelTEO;
					String SelTEO_Value = ExcelUtils.getExcelData("TEO", "Iteration"+k+"");
					Utils.SelDropDown1(TEOPath, SelTEO_Value);
					
					Utils.sleep(5000);
					String PoPath = MaterialComments_Page.SelPO;
					String SelPO_Value = ExcelUtils.getExcelData("PO", "Iteration"+k+"");					
					Utils.SelDropDown1(PoPath, SelPO_Value);
					
					Utils.sleep(5000);
					String LinePath = MaterialComments_Page.SelLine;
					String SelLine_Value = ExcelUtils.getExcelData("Line", "Iteration"+k+"");
					Utils.SelDropDown1(LinePath, SelLine_Value);
					
					Utils.sleep(5000);
					String CommentTypePath = MaterialComments_Page.CommentType;
					String CommentType_Value = ExcelUtils.getExcelData("Comment_Type", "Iteration"+k+"");
					Utils.SelDropDown1(CommentTypePath, CommentType_Value);
					
					Utils.sleep(5000);
					String CommentsSubmit_Btn = MaterialComments_Page.SubmitBtn;
					Click_Action.Execute(driver, CommentsSubmit_Btn);
					
					Utils.sleep(6000);   	
					WebElement TEOelement = driver.findElement(By.xpath("//td[13][contains(.,'"+CommentText_value+"')]"));
					TEOelement.getTagName();
					String TEO_CommentTXT = TEOelement.getText();
					Log.info(TEO_CommentTXT);
					
					driver.close();
					driver.switchTo().window(winHandleBefore);
					
					
					String TEONum = ExcelUtils.getExcelData("TEO",  "Iteration"+k+"");
					//String TEONum_path = "//tr[2]/td[5]/a[contains(text(),'"+TEONum+"')]";
					String TEONum_path = "//a[contains(text(),'"+TEONum+"')]";
					Click_Action.Execute(driver, TEONum_path);
					
					String MaterialBtn = TEODetails_Page.Material_Btn;
					Click_Action.Execute(driver, MaterialBtn);
					
					 String MDRequestField = MD_Request_Form.Pickup_Instructions;
				     String MDRequestValue = ExcelUtils.getExcelData("Pickup_Instruction",  "Iteration"+k+"");
				     Utils.SetSendKeys(Material_Summary_Extent_Test, MDRequestField, MDRequestValue);
				     
				    // Select_Line_Detail.Execute(Material_Summary_Extent_Test, driver);
				     
				     String ReturnReason_Value = ExcelUtils.getExcelData("Reason_for_Return","Iteration"+k+"");
						String returnQty_Value = ExcelUtils.getExcelData("Return_Qty","Iteration"+k+"");
						String [] ReturnQty_ValueArray = returnQty_Value.split(":");
						System.out.println(ReturnQty_ValueArray.length);
						String [] ReturnReason_ValueArray = ReturnReason_Value.split(":");
						
					for (int i=1; i<ReturnQty_ValueArray.length+1; i++){
							
							WebElement Return_Req = driver.findElement(By.xpath("//*[@name='RETURN_REQUEST"+i+"']"));
							Return_Req.click();
							Utils.sleep(3000);
							String ReturnReason_path = "//*[@name='RETURN_REASON"+i+"']";
						    String strReturnReasonValue = ReturnReason_ValueArray[i-1];
						    System.out.println(strReturnReasonValue);
						    Utils.SelDropDown(ReturnReason_path, strReturnReasonValue);
						    Utils.sleep(3000);
						    String ReturnQty_Path = "//*[@name='RETURN_QTY"+i+"']";
						    Utils.SetSendKeys(Material_Summary_Extent_Test,ReturnQty_Path,ReturnQty_ValueArray[i-1]);
					   
						}
				     
				     String SubmitBtn1 = MD_Request_Form.SubmitBtn;
				     Click_Action.Execute(driver, SubmitBtn1);
				     
				     if(Base_Class.bResult==true){
				    	 
							// If the value of boolean variable is True, then your test is complete pass and do this
				 
							ExcelUtils.setExcelData(ExcelPath, "Result",  "Iteration"+k+"", "Pass");
				 
						 }else{
				 
							throw new Exception("Test Case Failed because of Verification");
				 
						 }		    
					    
	    		}	 
			}catch (Exception e){
		    
				//ExcelUtils.setExcelData(ExcelPath, "Result", sTestCaseName, "Fail");
				 extent.endTest(Material_Summary_Extent_Test);
				 Log.error(e.getMessage());
				 extent.flush();
				 throw (e);
			 
		 }   
	  
  }
  

  @AfterMethod
  public void afterMethod() {
	  Log.endTestCase(sTestCaseName);
		extent.endTest(Material_Summary_Extent_Test);
		extent.flush();
  }

}
