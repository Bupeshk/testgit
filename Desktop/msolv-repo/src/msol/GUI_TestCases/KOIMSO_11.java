package msol.GUI_TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import application_modules.Click_Action;
import application_modules.MouseHoverIE;
import application_modules.Object_Exist_Loop_Action;
import application_modules.SignIn_Action;
import page_object.GUI_TestCases.Base_Class;
import page_object.GUI_TestCases.CCR_TEO_PO_Search_Page;
import page_object.GUI_TestCases.Home_Page;
import page_object.GUI_TestCases.TEODetails_Page;
import utility.GUI_Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

import org.testng.annotations.BeforeMethod;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class KOIMSO_11 {
 public WebDriver driver;
	 
	 private String sTestCaseName;
	    
	 private WebElement StrElement;
	    
	 String ExcelPath;
	 
	 private ExtentTest Soft_Close_Extent_Test = null;
	 public static ExtentReports extent = new ExtentReports("src/Soft_Close.html", true);
	  
	  
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
	  public void Soft_Close() throws Exception {
		 
		 try{
			   
			 Soft_Close_Extent_Test  = extent.startTest(sTestCaseName, "");
				SignIn_Action.Execute(Soft_Close_Extent_Test, driver);
				Log.info("Login Successfully.");
				Reporter.log("Login Successfully.");
				
				WebElement Callout_element = Home_Page.LookUp(driver);
				StrElement = Home_Page.LookUp_CCRSearch(driver);
				MouseHoverIE.Execute(driver, Callout_element, StrElement);
				
				Utils.sleep(5000);
				
				String StrCCRSearchPath = CCR_TEO_PO_Search_Page.StrCCRPath;
				Log.info("Combined xPath is: "+StrCCRSearchPath);
				Object_Exist_Loop_Action.Execute(Soft_Close_Extent_Test, StrCCRSearchPath);
				
				String PONumber=ExcelUtils.getExcelData("PO_Number", "Soft_Close");
				Log.info("PO# Fetched from Excel :" + PONumber );
				String PONum_path = CCR_TEO_PO_Search_Page.PONumber;
				Utils.SetSendKeys(Soft_Close_Extent_Test, PONum_path, PONumber);
				Log.info(PONumber + "placed in the edit field" );
				
				String Submit_BtnPath = CCR_TEO_PO_Search_Page.SubmitBtn;
				Click_Action.Execute(driver, Submit_BtnPath);
				
				String TEOHeading_Path = TEODetails_Page.TeoLines_Heading;
				Utils.existsElement(Soft_Close_Extent_Test, TEOHeading_Path);
				
				WebElement POelement = driver.findElement(By.xpath("//td[2][contains(.,'"+PONumber+"')]"));
				POelement.getTagName();
				String POTXT = POelement.getText();
				Log.info(POTXT);
				//form[@name='f1']/table[5]/tbody/tr[2]/td[2]
				String SoftClose_ChkbxPath = TEODetails_Page.SC_Chkbx;
				Utils.existsElement(Soft_Close_Extent_Test, SoftClose_ChkbxPath);
				Click_Action.Execute(driver, SoftClose_ChkbxPath);
				
				String SCBtn_Path = TEODetails_Page.SC_Btn;
				Click_Action.Execute(driver, SCBtn_Path);
				
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				Log.info(alertText);
				alert.accept();
				
				Utils.sleep(3000);
				String SCAcknowledge = TEODetails_Page.SCAcknowledge;
				String SCAcknowledge_Text = Utils.getText(SCAcknowledge);
				Log.info(SCAcknowledge_Text);
				
				String BackBtn = TEODetails_Page.Back_Btn;
				Click_Action.Execute(driver, BackBtn);
				
				
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
