package msol.XML_Validations;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import page_object.XML_Validations.*;
import utility.GUI_Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import utility.XMLUtil;

/********   This program is to perform COEP PO interface XML Validations  **********/


public class KOIMSO_16 {

	
	public WebDriver driver;
	String sTestCaseName;
	String xmlstatus;
	String resultxml;
	StringBuilder updatedxml;
	boolean mainstatus;
	String validationType="coeppo";
	XMLValidation xmlvalidation = new XMLValidation();
	ExtentTest COEPPO_XML_ExtentTest = null;
	public  ExtentReports extent = new ExtentReports("Test_Report/COEPPO_XML.html", true);

	
	
	  @BeforeMethod
	  @Parameters("BrowserType")
	  public  void beforeMethod(String BrowserType) throws Exception {
	 
	      DOMConfigurator.configure("log4j.xml");
	      sTestCaseName = this.toString();
	      try {
			sTestCaseName = Utils.getTestCaseName(this.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      Log.startTestCase(sTestCaseName);
	 	 String path =GUI_Constant.Path_TestData+GUI_Constant.File_TestData;
	      ExcelUtils.setExcelFile(path,"XML_Cases");
	      if (BrowserType.equalsIgnoreCase("firefox")){
	        	driver = Utils.openBrowserFF();
	        }
	        else{
	        	driver = Utils.openBrowserIE();
	        }
	      
	  }

	
	
	@Test
	@Parameters("testCaseId")
	public void COEPPO_XML(String testCaseId) throws Exception
	{
		COEPPO_XML_ExtentTest  = extent.startTest(testCaseId, "");
		String COEPPOtestdatapath = ExcelUtils.getExcelData("TestData_Path", "KOIMSO_16");
		String InputCOEPPOXMLFilename = ExcelUtils.getExcelData("Input_XML_Name", "KOIMSO_16");
		String ResponseCOEPPOXMLFilename = ExcelUtils.getExcelData("Response_XML_Name", "KOIMSO_16");
		String input[] = InputCOEPPOXMLFilename.split(":");
		String response[] = ResponseCOEPPOXMLFilename.split(":");
		String status[] = new String[input.length];
		XMLUtil xmlutil= new XMLUtil();
		
		for(int i=0;i<input.length;i++)
		{
			COEPPO_XML_ExtentTest.log(LogStatus.PASS, "Selected "+input[i]+ " file and starting execution");
			System.out.println("Selected "+input[i]+ " file and starting execution");
			xmlstatus="coeppoinput";
			System.out.println(xmlstatus);
			try {
				xmlutil.xmlvalid(xmlstatus,COEPPOtestdatapath+input[i],"");
				} 
			catch (ParserConfigurationException | SAXException  e1)
				{
				e1.printStackTrace();
				Log.error(e1.getMessage());
				}
			updatedxml = xmlutil.xmlRead(COEPPOtestdatapath+input[i]);
			COEPPO_XML_ExtentTest.log(LogStatus.PASS,"2", "Copied the xml");
			resultxml= xmlvalidation.pasteXMLandSubmit(driver,updatedxml,validationType);
			COEPPO_XML_ExtentTest.log(LogStatus.PASS,"3", "Pasted the xml in text area and submitted");
			xmlutil.createAcknowledgeXML(resultxml,COEPPOtestdatapath+response[i]);
	        xmlstatus="coepporesponse";
	        System.out.println(xmlstatus);
			try {
				xmlutil.xmlvalid(xmlstatus,COEPPOtestdatapath+response[i],"");
				} 
			catch (ParserConfigurationException | SAXException  e)
				{
				e.printStackTrace();
				Log.error(e.getMessage());
				}
			COEPPO_XML_ExtentTest.log(LogStatus.PASS,"4-5", "verified the response ACKCODE and DESCRPITN tags");
			status[i] = xmlutil.checkDBrow(validationType);
			COEPPO_XML_ExtentTest.log(LogStatus.PASS,"6-7", "verified the presence of record in Database");
		} 
		for(int j=0;j<status.length;j++)
		{
			
			if(status[j].equals("There is no record created in database- Failed") || status[j].equalsIgnoreCase("updated XML submission failed because of Duplicate PO"))
			{
				System.out.println(input[j]+" is failed");
				COEPPO_XML_ExtentTest.log(LogStatus.ERROR, input[j]+ " "+status[j]);
				mainstatus= true;
			}
			else{
				System.out.println(input[j]+ " is passed");
				COEPPO_XML_ExtentTest.log(LogStatus.PASS, input[j]+ " "+status[j]);
			}
	
		}
		
		if(mainstatus)
			throw new Exception("The test case is failed either because of no created record or because of Duplicate PO");			
		
	}

	@AfterMethod
	public void afterMethod() {

		extent.endTest(COEPPO_XML_ExtentTest);
		extent.flush();
		driver.quit();
	}
}
