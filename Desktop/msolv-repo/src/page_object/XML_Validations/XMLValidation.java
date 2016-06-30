package page_object.XML_Validations;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

import utility.Log;
import utility.PropertyUtility;
import utility.XML_Constant;


public class XMLValidation {

private static PropertyUtility  putil = new PropertyUtility(XML_Constant.XMLValidation_PropPath);
	
	 String TEOurl = putil.getEnvironmentProperty("TEOurl");
	 String CCPPOurl =putil.getEnvironmentProperty("CCPPOurl");
	 String BOMurl = putil.getEnvironmentProperty("BOMurl");
	 String vSAPPOurl = putil.getEnvironmentProperty("vSAPPOurl");
	 String COEPPOurl = putil.getEnvironmentProperty("COEPPOurl");
	 String vSAPPOAurl= putil.getEnvironmentProperty("vSAPPOAurl");
	 String PKMSurl = putil.getEnvironmentProperty("PKMSurl");
	 String textarea = putil.getEnvironmentProperty("textarea");
	 String submit = putil.getEnvironmentProperty("submit");
	 String resultxml;
	 String responseurl;
	 String validationType= "teo";
	 
	
	public  String pasteXMLandSubmit(WebDriver driver, StringBuilder updatedxml,String validationType) throws Exception 
	{
		
		switch(validationType.toLowerCase())
		{
		case "teo":
						driver.get(TEOurl);
						break;
		case "vsappocreation":
		case "vsapponewline":
						driver.get(vSAPPOurl);
						break;
		case "ccppo":
						driver.get(CCPPOurl);
						break;
		case "bom":
						driver.get(BOMurl);
						break;
		case "coeppo": 
						driver.get(COEPPOurl);
						break;
		case "vsappoa":
		case "vsappoasn":
						driver.get(vSAPPOAurl);
						break;
		case "pkms":
						driver.get(PKMSurl);
						break;
			
		}
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath(textarea)).clear();
		//String updatexml = updatedxml.toString();
		//WebElement element = driver.findElement(By.xpath(textarea));
		//setAttribute(element,"value",updatexml);
		driver.findElement(By.xpath(textarea)).sendKeys(updatedxml);
		Log.info("Pasted the input xml into text area");
		driver.findElement(By.xpath(submit)).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		resultxml= driver.getPageSource();
		resultxml= resultxml.trim();
		//System.out.println(resultxml);
		return resultxml;
	
	}
	
	public void setAttribute(WebElement element, String attributeName, String value)
	{
		WrapsDriver wd = (WrapsDriver) element;
		JavascriptExecutor driver = (JavascriptExecutor)wd.getWrappedDriver();
		driver.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attributeName, value);
	} 
}
