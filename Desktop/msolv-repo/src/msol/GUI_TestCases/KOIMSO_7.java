package msol.GUI_TestCases;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import application_modules.Click_Action;
import application_modules.IsDisplayed_Action;
import application_modules.MouseHoverIE;
import application_modules.MouseHover_Action;
import application_modules.Object_Exist_Loop_Action;
import application_modules.SignIn_Action;
import page_object.GUI_TestCases.Home_Page;
import page_object.GUI_TestCases.MD_AuthorForm_Page;
import page_object.GUI_TestCases.MD_Create_Form_Page;
import page_object.GUI_TestCases.MD_Search_Page;
import utility.GUI_Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class KOIMSO_7 {
	
	public static WebDriver driver;
    private String sTestCaseName;
    String ExcelPath;
    private ExtentTest Material_Disposition_Search_Extent_Test = null;
   	public static ExtentReports extent = new ExtentReports("src/Material_Disposition_Search.html", true);
 
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  
	  	DOMConfigurator.configure("log4j.xml");
		 
	     sTestCaseName = this.toString();

	     sTestCaseName = Utils.getTestCaseName(this.toString());

	     Log.startTestCase(sTestCaseName);

	     ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;
	     
	     ExcelUtils.setExcelFile(ExcelPath,"GUI_CASES");

	     driver = Utils.openBrowserIE();
	  
  }
	
  @Test
  public void Material_Disposition_Search() throws Exception {
	  
	  Material_Disposition_Search_Extent_Test  = extent.startTest(sTestCaseName, "");
	  SignIn_Action.Execute(Material_Disposition_Search_Extent_Test, driver);
	  System.out.println("Login Successfully.");
	  Log.info("Login Successfully.");
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      Log.info("Implicit wait applied on the driver for 10 seconds");
		
      String StrPath = Home_Page.StrMDPath;
      Log.info("Combined xPath is: "+StrPath);
  
      Object_Exist_Loop_Action.Execute(Material_Disposition_Search_Extent_Test, StrPath);
      
	  WebElement Material_Disposition_Ele = Home_Page.Matetial_Disposition(driver);
	  WebElement StrElement = Home_Page.MDSearch(driver);
	  MouseHoverIE.Execute(driver, Material_Disposition_Ele, StrElement);
	  
	  String StrMDSearchPath = MD_Search_Page.StrPath;
      Log.info("Combined xPath is: "+StrMDSearchPath);
      
      Object_Exist_Loop_Action.Execute(Material_Disposition_Search_Extent_Test, StrMDSearchPath);
      
      String CCRNumber=ExcelUtils.getExcelData("CCR_Number", "Material_Disposition_Search");
      Log.info("CCR# Fetched from Excel :" + CCRNumber );
      String WONum_path = MD_Search_Page.WONumber;
      Utils.SetSendKeys(Material_Disposition_Search_Extent_Test, WONum_path, CCRNumber);
      Log.info(CCRNumber + "placed in the edit field" );
      
      String StrMDButton = MD_Search_Page.SubmitBtn;
      Click_Action.Execute(driver, StrMDButton);
      
      String MD_Request_Tracking_Number = ExcelUtils.getExcelData("MD_Request_TrackingNum", "Material_Disposition_Search");
      String MD_Request_Tracking_Number_Path = "//a[contains(text(),'"+MD_Request_Tracking_Number+"')]";
      Click_Action.Execute(driver, MD_Request_Tracking_Number_Path);
	  
      String winHandleBefore = driver.getWindowHandle();
      
      String strPickup_DatePath = MD_AuthorForm_Page.CalendarBtn;
      Click_Action.Execute(driver, strPickup_DatePath);
      
      for(String winHandle : driver.getWindowHandles()){
  	    driver.switchTo().window(winHandle);
  	  }
      
      String strMonthPath = MD_Create_Form_Page.Month;
      String StrMonthValue = ExcelUtils.getExcelData("MDSearch_Month","Material_Disposition_Search");
      Utils.SelDropDown1(strMonthPath, StrMonthValue);
      
      String strYearPath = MD_Create_Form_Page.Year;
      String StrYearValue = ExcelUtils.getExcelData("MDSearch_Year","Material_Disposition_Search");
      Utils.SelDropDown1(strYearPath, StrYearValue);
      
      String StrDayValue = ExcelUtils.getExcelData("MDSearch_Day","Material_Disposition_Search");
      WebElement Dayelement = driver.findElement(By.xpath("//*[@href='javascript:returnDate("+StrDayValue+")']"));
      Dayelement.click();
      Log.info(Dayelement + "Clicked Successfully.");
      
      driver.switchTo().window(winHandleBefore);
      
      int LineDetails_rowcount = driver.findElements(By.xpath("//input[contains(@value , 'Reuse')]")).size();
      Log.info("Number of rows :" + LineDetails_rowcount );
	  
      for (int i=0; i<LineDetails_rowcount; i++){
    	  
    	  String LineDetail_Path = "//*[@name = 'disposition"+i+"' and @value = 'Reuse']";  
    	  Click_Action.Execute(driver, LineDetail_Path);
    	  
      }
      
      String AuthorizeBtn = MD_AuthorForm_Page.AuthorizeBtn;
      Click_Action.Execute(driver, AuthorizeBtn);
      Alert alert = driver.switchTo().alert();
      alert.accept(); 
      Utils.sleep(2000);
      Click_Action.Execute(driver, AuthorizeBtn);
      String AuthorVerif_Text = "Material Disposition has been Authorized";
      WebElement AuthorVerifelement = driver.findElement(By.xpath("//font[contains(text(),'"+AuthorVerif_Text+"')]"));
      IsDisplayed_Action.Execute(driver, AuthorVerifelement);
     
      String EmailVerif_Text = "Material Disposition Authorization Emails have been sent";
      WebElement EmailVerifelement = driver.findElement(By.xpath("//font[contains(text(),'"+EmailVerif_Text+"')]"));
      IsDisplayed_Action.Execute(driver, EmailVerifelement);
       
  }

  @AfterMethod
  public void afterMethod() {
  }

}
