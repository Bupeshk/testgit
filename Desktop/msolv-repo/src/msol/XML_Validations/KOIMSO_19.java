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

import page_object.XML_Validations.XMLValidation;
import utility.ExcelUtils;
import utility.GUI_Constant;
import utility.Log;
import utility.Utils;
import utility.XMLUtil;


/********   This program is to perform vSAP POA XML Validations  **********/



public class KOIMSO_19 {

	
	public WebDriver driver;
	String sTestCaseName;
	String xmlstatus;
	String resultxml;
	StringBuilder updatedxml;
	boolean mainstatus;
	String validationType="vsappoa";
	XMLValidation xmlvalidation = new XMLValidation();
	ExtentTest vSAPPOA_XML_ExtentTest = null;
	public  ExtentReports extent = new ExtentReports("Test_Report/vSAPPOA_XML.html", true);
	
	
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
	public void vSAPPOA_XML(String testCaseId) throws Exception
	{
		vSAPPOA_XML_ExtentTest  = extent.startTest(testCaseId, "");
		String vSAPPOAtestdatapath = ExcelUtils.getExcelData("TestData_Path", "KOIMSO_19");
		String InputvSAPPOAXMLFilename = ExcelUtils.getExcelData("Input_XML_Name", "KOIMSO_19");
		String ResponsevSAPPOAXMLFilename = ExcelUtils.getExcelData("Response_XML_Name", "KOIMSO_19");
		String input[] = InputvSAPPOAXMLFilename.split(":");
		String response[] = ResponsevSAPPOAXMLFilename.split(":");
		String status[] = new String[input.length];
		XMLUtil xmlutil= new XMLUtil();
		
		for(int i=0;i<input.length;i++)
		{
			vSAPPOA_XML_ExtentTest.log(LogStatus.PASS, "Selected "+input[i]+ " file and starting execution");
			
			System.out.println("Selected "+input[i]+ " file and starting execution");
			xmlstatus="vsappoainput";
			System.out.println(xmlstatus);
			try {
				xmlutil.xmlvalid(xmlstatus,vSAPPOAtestdatapath+input[i],"");
				} 
			catch (ParserConfigurationException | SAXException  e1)
				{
				e1.printStackTrace();
				Log.error(e1.getMessage());
				}
			updatedxml = xmlutil.xmlRead(vSAPPOAtestdatapath+input[i]);
			vSAPPOA_XML_ExtentTest.log(LogStatus.PASS,"2", "Copied the xml");
			resultxml= xmlvalidation.pasteXMLandSubmit(driver,updatedxml,validationType);
			vSAPPOA_XML_ExtentTest.log(LogStatus.PASS,"3", "Pasted the xml in text area and submitted");
			xmlutil.createAcknowledgeXML(resultxml,vSAPPOAtestdatapath+response[i]);
	        xmlstatus="vsappoaresponse";
	        System.out.println(xmlstatus);
			try {
				xmlutil.xmlvalid(xmlstatus,vSAPPOAtestdatapath+response[i],"");
				} 
			catch (ParserConfigurationException | SAXException  e)
				{
				e.printStackTrace();
				Log.error(e.getMessage());
				}
			vSAPPOA_XML_ExtentTest.log(LogStatus.PASS,"4-5", "verified the response ACKCODE and DESCRPITN tags");
			status[i] = xmlutil.checkDBrow(validationType);
			vSAPPOA_XML_ExtentTest.log(LogStatus.PASS,"6-7", "verified the presence of record in Database");
		} 
		for(int j=0;j<status.length;j++)
		{
			
			if(status[j].equals("There is no record created in database- Failed") || status[j].equalsIgnoreCase("updated XML submission failed because of Duplicate PO"))
			{
				System.out.println(input[j]+" is failed");
				vSAPPOA_XML_ExtentTest.log(LogStatus.ERROR, input[j]+ " "+status[j]);
				mainstatus= true;
			}
			else{
				System.out.println(input[j]+ " is passed");
				vSAPPOA_XML_ExtentTest.log(LogStatus.PASS, input[j]+ " "+status[j]);
			}
	
		}
		
		if(mainstatus)
			throw new Exception("The test case is failed either because of no created record or because of Duplicate PO");			
		
	}
	@AfterMethod
	public void afterMethod() {

		extent.endTest(vSAPPOA_XML_ExtentTest);
		extent.flush()	;
		driver.quit();
	}
}
