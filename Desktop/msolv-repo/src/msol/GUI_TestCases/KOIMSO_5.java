package msol.GUI_TestCases;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import application_modules.*;
import page_object.GUI_TestCases.*;
import utility.*;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class KOIMSO_5 {
	
	public static WebDriver driver; 
    private String sTestCaseName;
    String ExcelPath;
    private ExtentTest Create_MD_New_CCRNumber_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("src/Create_MD_New_CCRNumber.html", true);
    
    @BeforeMethod
    public void beforeMethod() throws Exception {
	  
	  DOMConfigurator.configure("log4j.xml");	 
      sTestCaseName = this.toString();
      sTestCaseName = Utils.getTestCaseName(this.toString());
      Log.startTestCase(sTestCaseName);
      ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;     
      ExcelUtils.setExcelFile(ExcelPath,"GUI_CASES");
      driver = Utils.openBrowserFF();
      
    }
  
  
    @Test
    public void CreateMD_WithNewCCRNum() throws Exception {
	  
	  try{
	  
		  Create_MD_New_CCRNumber_Extent_Test  = extent.startTest(sTestCaseName, "");	  
		  SignIn_Action.Execute(Create_MD_New_CCRNumber_Extent_Test, driver);
		  System.out.println("Login Successfully.");
		  Log.info("Login Successfully.");
		  
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Log.info("Implicit wait applied on the driver for 10 seconds");
			
	      String StrPath = Home_Page.StrMDPath;
	      Log.info("Combined xPath is: "+StrPath);
	  
	      Object_Exist_Loop_Action.Execute(Create_MD_New_CCRNumber_Extent_Test, StrPath);
	      
	      WebElement Material_Disposition_Ele = Home_Page.Matetial_Disposition(driver);
	      
	      MouseHover_Action.Execute(driver,Material_Disposition_Ele);
		  Log.info("Lookup mouse hover performed");
		  
		  WebElement CreateMD_Ele = Home_Page.EleCreateMD(driver);
	      CreateMD_Ele.click();
	      
	      String StrMDPagePath = Material_Disposition_Page.StrPath;
	      Log.info("Combined xPath is: "+StrMDPagePath);
	      
	      Object_Exist_Loop_Action.Execute(Create_MD_New_CCRNumber_Extent_Test, StrMDPagePath);
	      
	      String CCRNumber=ExcelUtils.getExcelData("CCR_Number", "Create_MD_New_CCRNumber");
	      Log.info("CCR# Fetched from Excel :" + CCRNumber );
	      Material_Disposition_Page.CCRWONumber(driver).sendKeys(CCRNumber);
	      Log.info(CCRNumber + "placed in the edit field, in Express Call out page" );
	      
	      String StrMDButton = Material_Disposition_Page.SubmitBtn;
	      Click_Action.Execute(driver, StrMDButton);
	      
	      String StrCreateMDFormPath = MD_Create_Form_Page.StrMDCreateFormPath;
	      Log.info("Combined xPath is: "+StrCreateMDFormPath);
	      
	      Object_Exist_Loop_Action.Execute(Create_MD_New_CCRNumber_Extent_Test, StrCreateMDFormPath);
	      
	      String winHandleBefore = driver.getWindowHandle();
	      
	      String StrEnggSearchBtn = MD_Create_Form_Page.EnggSearch;
	      Click_Action.Execute(driver, StrEnggSearchBtn);
	      
	      //Utils.ChildWindowHandles();
	     
	      for(String winHandle : driver.getWindowHandles()){
	    	    driver.switchTo().window(winHandle);
	    	}
	     
	      WebElement SelEngg = MD_Create_Form_Page.Sel_Engg(driver);
	      SelEngg.click();
	      
	      String StrEnggSubmit = MD_Create_Form_Page.Engg_Submit;
	      Click_Action.Execute(driver, StrEnggSubmit);
	      
	      //driver.close();
	      driver.switchTo().window(winHandleBefore);
	      
	      String strReturnWHPath = MD_Create_Form_Page.Rtn_Warehouse;
	      String strReturnWHValue = ExcelUtils.getExcelData("Return_Warehouse","Create_MD_New_CCRNumber");
	      Log.info("strReturnWHValue");
	      Utils.SelDropDown(strReturnWHPath, strReturnWHValue);
	      
	      String strStatePath = MD_Create_Form_Page.State;
	      String StrStateValue = ExcelUtils.getExcelData("State","Create_MD_New_CCRNumber");
	      Utils.SelDropDown(strStatePath, StrStateValue);
	      
	      String strPickup_DatePath = MD_Create_Form_Page.Cal_img;
	      Click_Action.Execute(driver, strPickup_DatePath);
	      Utils.sleep(2000);
	      for(String winHandle : driver.getWindowHandles()){
	  	    driver.switchTo().window(winHandle);
	  	  }
	      
	      String strMonthPath = MD_Create_Form_Page.Month;
	      String StrMonthValue = ExcelUtils.getExcelData("Month","Create_MD_New_CCRNumber");
	      Utils.SelDropDown1(strMonthPath, StrMonthValue);
	      
	      String strYearPath = MD_Create_Form_Page.Year;
	      String StrYearValue = ExcelUtils.getExcelData("Year","Create_MD_New_CCRNumber");
	      Utils.SelDropDown1(strYearPath, StrYearValue);
	      
	      String StrDayValue = ExcelUtils.getExcelData("Day","Create_MD_New_CCRNumber");
	      WebElement Dayelement = driver.findElement(By.xpath("//*[@href='javascript:returnDate("+StrDayValue+")']"));
	      Dayelement.click();
	      Log.info(Dayelement + "Clicked Successfully.");
	      
	      driver.switchTo().window(winHandleBefore);
	     
	      String grpMDCreateFields = MD_Create_Form_Page.StrMDCreateFields;
	      String grpMDCreateValues = MD_Create_Form_Page.StrMDCreateValues;
	      SetSendKeys_Action.Execute(Create_MD_New_CCRNumber_Extent_Test, grpMDCreateFields, grpMDCreateValues);
	      
	      Add_Line_Detail.Execute(Create_MD_New_CCRNumber_Extent_Test, driver);
	      
	      String Submit_Page_btn = MD_Create_Form_Page.Submit_Page;
	      Click_Action.Execute(driver, Submit_Page_btn);
	      Alert alert = driver.switchTo().alert();
	      alert.accept(); 
	      Utils.sleep(2000);
	      Click_Action.Execute(driver, Submit_Page_btn);
	      
	      String Tracking_Number_Path = MD_Create_Form_Page.Tracking_Number;
	      String Tracking_Number = Utils.getText(Tracking_Number_Path);
	      
	      
	      String existingTrackingNumber = ExcelUtils.getExcelData("MD_Tracking_Number", "Create_MD_New_CCRNumber");
	      if (existingTrackingNumber!=null && existingTrackingNumber.length() > 0)
	    	  ExcelUtils.setExcelData(ExcelPath,"MD_Tracking_Number","Create_MD_New_CCRNumber",existingTrackingNumber +";"+Tracking_Number); 
	      else
	    	  ExcelUtils.setExcelData(ExcelPath,"MD_Tracking_Number","Create_MD_New_CCRNumber",Tracking_Number);
	      
	      
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
