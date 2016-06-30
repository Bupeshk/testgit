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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class KOIMSO_6 {
	
	public static WebDriver driver;
    private String sTestCaseName;
    String ExcelPath;
    private ExtentTest CreateMD_Existing_CCRNumber_Extent_Test = null;
    public static ExtentReports extent = new ExtentReports("src/CreateMD_Existing_CCRNumber.html", true);
  
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
    public void CreateMD_WithExistingCCRNum() throws Exception {
	  
	try{
	  
	  CreateMD_Existing_CCRNumber_Extent_Test  = extent.startTest(sTestCaseName, "");	  	
	  SignIn_Action.Execute(CreateMD_Existing_CCRNumber_Extent_Test, driver);
	  System.out.println("Login Successfully.");
	  Log.info("Login Successfully.");
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      Log.info("Implicit wait applied on the driver for 10 seconds");
		
      String StrPath = Home_Page.StrMDPath;
      Log.info("Combined xPath is: "+StrPath);
  
      Object_Exist_Loop_Action.Execute(CreateMD_Existing_CCRNumber_Extent_Test, StrPath);
      
      WebElement Material_Disposition_Ele = Home_Page.Matetial_Disposition(driver);
      
      MouseHover_Action.Execute(driver,Material_Disposition_Ele);
	  Log.info("Lookup mouse hover performed");
	  
	  WebElement CreateMD_Ele = Home_Page.EleCreateMD(driver);
      CreateMD_Ele.click();
      
      String StrMDPagePath = Material_Disposition_Page.StrPath;
      Log.info("Combined xPath is: "+StrMDPagePath);
      
      Object_Exist_Loop_Action.Execute(CreateMD_Existing_CCRNumber_Extent_Test, StrMDPagePath);
      
      String CCRNumber=ExcelUtils.getExcelData("CCR_Number", "CreateMD_Existing_CCRNumber");
      Log.info("CCR# Fetched from Excel :" + CCRNumber );
      Material_Disposition_Page.CCRWONumber(driver).sendKeys(CCRNumber);
      Log.info(CCRNumber + "placed in the edit field" );
      
      String StrMDButton = Material_Disposition_Page.SubmitBtn;
      Click_Action.Execute(driver, StrMDButton);
    
      String Clli_Sel=ExcelUtils.getExcelData("CLLI_Code", "CreateMD_Existing_CCRNumber");
      WebElement CLLI_element = driver.findElement(By.xpath("//*[@value='"+Clli_Sel+"']"));
      CLLI_element.click();
      
      String Submit_CLLI = Sel_CLLI_Code_Page.Submit_Btn;
      Click_Action.Execute(driver, Submit_CLLI);
      
      String StrRequestMDFormPath = MD_Request_Form.StrMDRequestFormPath;
      Log.info("Combined xPath is: "+StrRequestMDFormPath);
      
      Object_Exist_Loop_Action.Execute(CreateMD_Existing_CCRNumber_Extent_Test, StrRequestMDFormPath);
      
      String grpMDRequestFields = MD_Request_Form.StrMDRequestFields;
      String grpMDRequestValues = MD_Request_Form.StrMDRequestValues;
      SetSendKeys_Action.Execute(CreateMD_Existing_CCRNumber_Extent_Test, grpMDRequestFields, grpMDRequestValues);
      
      Select_Line_Detail.Execute(CreateMD_Existing_CCRNumber_Extent_Test, driver);
      
      String MDRequest_SubmitBtn = MD_Request_Form.SubmitBtn;
      Click_Action.Execute(driver, MDRequest_SubmitBtn);
      
      String Tracking_Number_Path = MD_Request_Form.Tracking_Number;
      String Tracking_Number = Utils.getText(Tracking_Number_Path);
      
      String existingMDTrackingNumber = ExcelUtils.getExcelData("MD_Tracking_Number", "CreateMD_Existing_CCRNumber");
      if (existingMDTrackingNumber!=null && existingMDTrackingNumber.length() > 0)
    	  ExcelUtils.setExcelData(ExcelPath,"MD_Tracking_Number","CreateMD_Existing_CCRNumber",existingMDTrackingNumber +";"+Tracking_Number); 
      else
    	  ExcelUtils.setExcelData(ExcelPath,"MD_Tracking_Number","CreateMD_Existing_CCRNumber",Tracking_Number);
      
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
