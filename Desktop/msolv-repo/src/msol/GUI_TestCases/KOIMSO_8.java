package msol.GUI_TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import application_modules.Click_Action;
import application_modules.MouseHover_Action;
import application_modules.Object_Exist_Loop_Action;
import application_modules.SignIn_Action;
import page_object.GUI_TestCases.Base_Class;
import page_object.GUI_TestCases.Excess_Material_Search_page;
import page_object.GUI_TestCases.Home_Page;
import utility.GUI_Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class KOIMSO_8 {
	
	public static WebDriver driver;
    private String sTestCaseName;
    String ExcelPath;
    private ExtentTest Excess_Material_Search_Extent_Test = null;
	public static ExtentReports extent = new ExtentReports("src/Excess_Material_Search.html", true);
 
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  
	  	 DOMConfigurator.configure("log4j.xml");		 
	     sTestCaseName = this.toString();
	     sTestCaseName = Utils.getTestCaseName(this.toString());
	     Log.startTestCase(sTestCaseName);
	     ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;	     
	     ExcelUtils.setExcelFile(ExcelPath,"GUI_CASES");
	     new Base_Class(driver); 
	     driver = Utils.openBrowserFF();
	  
  }	
	
  @Test
  public void ExcessMaterial_Search() throws Exception {
	  
	  try{
		  Excess_Material_Search_Extent_Test  = extent.startTest(sTestCaseName, "");
	  SignIn_Action.Execute(Excess_Material_Search_Extent_Test, driver);
	  System.out.println("Login Successfully.");
	  Log.info("Login Successfully.");
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      Log.info("Implicit wait applied on the driver for 10 seconds");
      
  	  WebElement Lookup_element = Home_Page.LookUp(driver);
	  MouseHover_Action.Execute(driver,Lookup_element);
	  Log.info("Lookup mouse hover performed");
		
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      Log.info("Implicit wait applied on the driver for 10 seconds");
		
      String StrPath = Home_Page.StrPath;
      Log.info("Combined xPath is: "+StrPath);
    
      Object_Exist_Loop_Action.Execute(Excess_Material_Search_Extent_Test, StrPath);
      
      String ExcessMaterial_path = Home_Page.ExcessMaterialSearch;
	  Click_Action.Execute(driver, ExcessMaterial_path);
	  
	  String Screen_Path = Excess_Material_Search_page.ScreenOption;
	  Click_Action.Execute(driver, Screen_Path);
	  
	  String Submit_Path = Excess_Material_Search_page.Submit_Btn;
	  Click_Action.Execute(driver, Submit_Path);
	  
	  int Excess_Material_ColList = driver.findElements(By.xpath("//*[@class='FIELDTITLE sortable']")).size();
      Log.info("Number of Columns :" + Excess_Material_ColList );
      
      for (int i=1; i<Excess_Material_ColList+1; i++){
     
    	  String Excess_Material_ColDetail_Path = "//*[@id='searchList']/thead/tr/th["+i+"]/a";  
    	  Utils.getText(Excess_Material_ColDetail_Path);
    	  
      }
      
      WebElement ExcessLookup_element = Excess_Material_Search_page.ExcessLookUp(driver);
	  MouseHover_Action.Execute(driver,ExcessLookup_element);
	  Log.info("Lookup mouse hover performed");
	  Click_Action.Execute(driver, ExcessMaterial_path);
	  
	  
	  String Excel_Path = Excess_Material_Search_page.ExcelOption;
	  Click_Action.Execute(driver, Excel_Path);
	  Click_Action.Execute(driver, Submit_Path);
	  
	  Runtime.getRuntime().exec("src/test_data/clickok.exe"); 
	  
	  Utils.sleep(20000);
	  

	  String Text_Path = Excess_Material_Search_page.TextOption;
	  Click_Action.Execute(driver, Text_Path);
	  Click_Action.Execute(driver, Submit_Path);
	  
	  Runtime.getRuntime().exec("src/test_data/clickok.exe"); 

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
