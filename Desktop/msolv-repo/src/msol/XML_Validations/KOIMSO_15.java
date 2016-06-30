package msol.XML_Validations;

import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import page_object.GUI_TestCases.Base_Class;
import page_object.XML_Validations.XMLValidation;
import utility.ExcelUtils;
import utility.GUI_Constant;
import utility.Log;
import utility.Utils;
import utility.XMLUtil;


/********   This program is to perform PKMS interface XML Validations(CEVA Receiver)  **********/


public class KOIMSO_15 {
	public WebDriver driver;
	String sTestCaseName;
	String xmlstatus;
	String resultxml;
	String path;
	StringBuilder updatedxml;
	boolean mainstatus;
	String validationType="pkms";
	XMLValidation xmlvalidation = new XMLValidation();
	ExtentTest PKMS_XML_ExtentTest = null;
	public  ExtentReports extent = new ExtentReports("Test_Report/PKMS_XML.html", true);
	
	
	@BeforeMethod
    @Parameters({"BrowserType","testCaseId"})
    public void beforeMethod(String BrowserType, String testCaseId) throws Exception {
	  
        DOMConfigurator.configure("log4j.xml");
        sTestCaseName = this.toString();
        String sTestCaseName = Utils.getTestCaseName(this.toString());
        Log.startTestCase(sTestCaseName);
    }

	
	
	 @Test
	 @Parameters({"BrowserType","testCaseId"})
	public void PKMS_XML(String BrowserType, String testCaseId) throws Exception
	{
		 
		 PKMS_XML_ExtentTest  = extent.startTest(testCaseId, "");
	 		
	     	if (! GUI_Constant.executeTestCase){
	     		PKMS_XML_ExtentTest.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
	     		throw new SkipException("Skipping the test case as application is not available.");			
	     	}    
	     	path =GUI_Constant.Path_TestData+GUI_Constant.File_TestData;
	         ExcelUtils.setExcelFile(path,"XML_Cases");
	       
	         if (GUI_Constant.env.equalsIgnoreCase("Local")){
	         	if (BrowserType.equalsIgnoreCase("firefox"))
	         		driver = Utils.openBrowserFF();
	         	else
	         		driver = Utils.openBrowserIE();
	         }
	         else{
	         	if (BrowserType.equalsIgnoreCase("firefox"))
	         		driver = Utils.open_selhubFF();
	         	else
	         		driver = Utils.open_selhubIE();            	
	         	
	         }
	         
	         new Base_Class(driver);   
		
		String Flowenabled = ExcelUtils.getExcelData("FlowEnabled", "KOIMSO_12");
		if(Flowenabled.equalsIgnoreCase("y"))
			ExcelUtils.setExcelFile(path,"XML_Flow");
		else
			ExcelUtils.setExcelFile(path,"XML_Cases");
		String PKMStestdatapath = ExcelUtils.getExcelData("TestData_Path", "KOIMSO_15");
		String InputPKMSXMLFilename = ExcelUtils.getExcelData("Input_XML_Name", "KOIMSO_15");
		String ResponsePKMSXMLFilename = ExcelUtils.getExcelData("Response_XML_Name", "KOIMSO_15");
		String input[] = InputPKMSXMLFilename.split(":");
		String response[] = ResponsePKMSXMLFilename.split(":");
		String status[] = new String[input.length];
		XMLUtil xmlutil= new XMLUtil();
		
		for(int i=0;i<input.length;i++)
		{
			PKMS_XML_ExtentTest.log(LogStatus.PASS, "Selected "+input[i]+ " file and starting execution");
			System.out.println("Selected "+input[i]+ " file and starting execution");
			xmlstatus="pkmsinput";
			System.out.println(xmlstatus);
			try {
				xmlutil.xmlvalid(xmlstatus,PKMStestdatapath+input[i],"");
				} 
			catch (ParserConfigurationException | SAXException  e1)
				{
				e1.printStackTrace();
				Log.error(e1.getMessage());
				}
			updatedxml = xmlutil.xmlRead(PKMStestdatapath+input[i]);
			PKMS_XML_ExtentTest.log(LogStatus.PASS,"2", "Copied the xml");
			resultxml= xmlvalidation.pasteXMLandSubmit(driver,updatedxml,validationType);
			PKMS_XML_ExtentTest.log(LogStatus.PASS,"3", "Pasted the xml in text area and submitted");
			xmlutil.createAcknowledgeXML(resultxml,PKMStestdatapath+response[i]);
	        xmlstatus="pkmsresponse";
	        System.out.println(xmlstatus);
			try {
				xmlutil.xmlvalid(xmlstatus,PKMStestdatapath+response[i],"");
				} 
			catch (ParserConfigurationException | SAXException  e)
				{
				e.printStackTrace();
				Log.error(e.getMessage());
				}
			PKMS_XML_ExtentTest.log(LogStatus.PASS,"4-5", "verified the response ACKCODE and DESCRPITN tags");
			System.out.println("Loop for PKMS::"+i);
			status[i] = xmlutil.checkDBrow(validationType);
			PKMS_XML_ExtentTest.log(LogStatus.PASS,"6-7", "verified the presence of record in Database");
		} 
		for(int j=0;j<status.length;j++)
		{
			
			if(status[j].equals("There is no record created in database- Failed") || status[j].equalsIgnoreCase("updated XML submission failed because of Duplicate PO"))
			{
				System.out.println(input[j]+" is failed");
				PKMS_XML_ExtentTest.log(LogStatus.ERROR, input[j]+ " "+status[j]);
				mainstatus= true;
			}
			else{
				System.out.println(input[j]+ " is passed");
				PKMS_XML_ExtentTest.log(LogStatus.PASS, input[j]+ " "+status[j]);
			}
	
		}
		
		if(mainstatus)
			throw new Exception("The test case is failed either because of no created record or because of Duplicate PO");			
		
	}
	
	@AfterMethod
	public void afterMethod() {

		extent.endTest(PKMS_XML_ExtentTest);
		extent.flush();
		driver.quit();
	}
}
