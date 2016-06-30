package msol.GUI_TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import application_modules.Click_Action;
import application_modules.MouseHoverIE;
import application_modules.Object_Exist_Loop_Action;
import application_modules.SignIn_Action;
import page_object.GUI_TestCases.Base_Class;
import page_object.GUI_TestCases.CCR_Details_Page;
import page_object.GUI_TestCases.CCR_TEO_PO_Search_Page;
import page_object.GUI_TestCases.Home_Page;
import page_object.GUI_TestCases.TEOComments_Page;
import utility.GUI_Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class KOIMSO_10 {
	 
	 public WebDriver driver;	 
	 private String sTestCaseName;	    
	 private WebElement StrElement;	    
	 String ExcelPath;
	 private ExtentTest EnterComments_TEODetailsPage_Extent_Test = null;
	 public static ExtentReports extent = new ExtentReports("src/EnterComments_TEODetailsPage.html", true);
	  
	 @BeforeMethod
	 public void beforeMethod() throws Exception {
	 
		 DOMConfigurator.configure("log4j.xml");	 
	     sTestCaseName = this.toString();	 
	     sTestCaseName = Utils.getTestCaseName(this.toString());	 
	     Log.startTestCase(sTestCaseName);	        
	     ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;	 
	     ExcelUtils.setExcelFile(ExcelPath,"GUI_CASES");	 
	     driver = Utils.openBrowserIE();
	     new Base_Class(driver);  
	 
	     }
	
	 @Test
	  public void Enter_Comments_TEODetails() throws Exception {
		 
		 try{
			 EnterComments_TEODetailsPage_Extent_Test  = extent.startTest(sTestCaseName, "");
				SignIn_Action.Execute(EnterComments_TEODetailsPage_Extent_Test, driver);
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
				
				Utils.sleep(5000);
				
				String StrCCRSearchPath = CCR_TEO_PO_Search_Page.StrCCRPath;
				Log.info("Combined xPath is: "+StrCCRSearchPath);
				Object_Exist_Loop_Action.Execute(EnterComments_TEODetailsPage_Extent_Test, StrCCRSearchPath);
				
				String CCRNumber=ExcelUtils.getExcelData("CCR_Number", "EnterComments_TEODetailsPage");
				Log.info("CCR# Fetched from Excel :" + CCRNumber );
				String WONum_path = CCR_TEO_PO_Search_Page.WONumber;
				Utils.SetSendKeys(EnterComments_TEODetailsPage_Extent_Test, WONum_path, CCRNumber);
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
				
				String CCRLink_BtnPath = CCR_TEO_PO_Search_Page.CCRLink;
				Click_Action.Execute(driver, CCRLink_BtnPath);
				
				String TEONum = ExcelUtils.getExcelData("TEO_Number", "EnterComments_TEODetailsPage");
				String TEONum_path = "//a[contains(text(),'"+TEONum+"')]";
				Click_Action.Execute(driver, TEONum_path);
				
				String winHandleBefore = driver.getWindowHandle();
				
				String Comments_Btn = CCR_Details_Page.CommentsBtn;
				Click_Action.Execute(driver, Comments_Btn);
		     
				for(String winHandle : driver.getWindowHandles()){
		    	    driver.switchTo().window(winHandle);
		    	}
		     
				String Comment_Elements = TEOComments_Page.Comments_path;
				Log.info("Combined xPath is: "+Comment_Elements);
				Object_Exist_Loop_Action.Execute(EnterComments_TEODetailsPage_Extent_Test, Comment_Elements);
				
				Utils.sleep(5000);
				String CommentText_value = ExcelUtils.getExcelData("Comment_Text", "EnterComments_TEODetailsPage");
				String CommentText = TEOComments_Page.CommentText;
				Utils.SetSendKeys(EnterComments_TEODetailsPage_Extent_Test, CommentText, CommentText_value);
				
				String TEOPath = TEOComments_Page.SelTEO;
				String TEOValue = TEOComments_Page.SelTEO_Value;
				Utils.SelDropDown1(TEOPath, TEOValue);
				
				Utils.sleep(5000);
				String PoPath = TEOComments_Page.SelPO;
				String PoValue = TEOComments_Page.SelPO_Value;
				Utils.SelDropDown1(PoPath, PoValue);
				
				Utils.sleep(5000);
				String LinePath = TEOComments_Page.SelLine;
				String LineValue = TEOComments_Page.SelLine_Value;
				Utils.SelDropDown1(LinePath, LineValue);
				
				Utils.sleep(5000);
				String CommentTypePath = TEOComments_Page.CommentType;
				String CommentTypeValue = TEOComments_Page.CommentType_Value;
				Utils.SelDropDown1(CommentTypePath, CommentTypeValue);
				
				Utils.sleep(5000);
				String CommentsSubmit_Btn = TEOComments_Page.SubmitBtn;
				Click_Action.Execute(driver, CommentsSubmit_Btn);
				
				Utils.sleep(6000);   	
				WebElement TEOelement = driver.findElement(By.xpath("//td[13][contains(.,'"+CommentText_value+"')]"));
				TEOelement.getTagName();
				String TEO_CommentTXT = TEOelement.getText();
				Log.info(TEO_CommentTXT);
				driver.switchTo().window(winHandleBefore);
				
				
				
				
				
				if(Base_Class.bResult==true){
			    	 
						// If the value of boolean variable is True, then your test is complete pass and do this
			 
						ExcelUtils.setExcelData(ExcelPath, "Result", sTestCaseName, "Pass");
			 
				}else{
			 
						throw new Exception("Test Case Failed because of Verification");
			 
				}		    
				    
			    
		    	}catch (Exception e){
			  	    
		    		 ExcelUtils.setExcelData(ExcelPath, "Result", sTestCaseName, "Fail");
		    		 Log.error(e.getMessage());
		    		 throw (e);
		    		 
		    	 }

		  		
		  		}
		 
	
	
	  @AfterMethod
	  public void afterMethod() {
	  }

}

