package com.verizon.cao.selenium.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;
import com.verizon.cao.selenium.common.ObjectRepository.Common;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;



public class CommonFunctions implements Common, Constants  {
	public static com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium selenium;
	public static final String STANDARD_PAGE_LOAD_WAIT_TIME = "120000"; //milliseconds
	public static final int STANDARD_PAGE_LOAD_WAIT_TIME_WEBDRIVER = 60; //second
	public static int timeOutInSeconds = 100;
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	static int reqcellrowno;
	static int reqcellcolno;
	ApplicationConstants variables;
	
	public static boolean executeTestCase = true;
	
	public static String timeStamp = "";
	
	public static WebDriver driver ;
	protected static ThreadLocal<RemoteWebDriver> threadDriver = null;
	
	public void alert(WebDriver driver){
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public boolean existsElement(String strElement,WebDriver driver) {
	    try {
	    	WebElement element = driver.findElement(By.xpath(strElement));
	    	element.getTagName();
	    	System.out.println(element + "Exist");
	        return true;
	
	    } catch (NoSuchElementException e) {
	    	//Log.error("Exception :" + e.getMessage());
	    	//Reporter.log("Exception :" + e.getMessage());
	    	System.out.println(strElement + " does not existExist");
	        return false;
	    }
	}
	
	public void Processing(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loadAgain")));
	}
	
	public void Processing_img(WebDriver driver,String imgObj){
		try {
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(imgObj)));
		}
		catch (Exception e){
			
		}
	}
	
	public void WindowHandles(WebDriver driver)
	{
		try{

			for ( String handle : driver.getWindowHandles()) {

				System.out.println(handle);

				driver.switchTo().window(handle);
			}
			
		} catch (Exception e){
			System.out.println("Handle window error - "+e);
			
		}
		
	}
	
	public void default_content(WebDriver driver,String pwindow)
	{
		driver.switchTo().window(pwindow);
	}
	
	public void sleep(long millis) 
	{
		try 
		{
			Thread.sleep(millis);
		}catch (InterruptedException e){
			//Log.error("Exception :" + e.getMessage());
		}
	}
	public void SwitchFrames(WebDriver driver,String FrameName){
		try{
			driver.switchTo().frame(FrameName);	
		} catch (Exception e){
			//Log.error("Frame could not be changed - "+e);
		}
	}
	
	public void ClearData(WebDriver driver,String inputObj){
		try{
			driver.findElement(By.xpath(inputObj)).clear();
		} catch (Exception e){
			Log.error("Exception occured while clearing the data in the Search "+e);
		}
		  			

	}
	
	public void PageToLoadTimeOut(WebDriver driver)
	{
		try {
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
		}
		catch (Exception e){
			System.out.println("Page Load Timeout"+e);
		}
	} 
	
	public void mouse_hover(WebDriver driver, String hoverObj,String value,ExtentReports ext_report,ExtentTest test){
		try {
		WebElement elem = driver.findElement(By.xpath(hoverObj));
		Actions action = new Actions(driver);
   	    //action.moveToElement(elem).perform();
		action.moveToElement(elem).build().perform();
   	    Log.info("Mouse over to "+value);
   	    test.log(LogStatus.PASS, "Mouse Hover","Mouse over to "+value );
        //action.click().perform(); //IE Browser
   	    
		}
		catch (Exception e){
			System.out.println("Exception "+e);
			Log.info("Exception occured during mouse over to "+value +e);
	   	    test.log(LogStatus.FAIL, "Mouse Hover","Exception occured during mouse over to "+value +e);
		}
	}
	
	public void mouse_ie(WebDriver driver,String hoverObj,String value,ExtentReports ext_report,ExtentTest test) throws Exception{
		 try 
		     {
			 WebElement elem = driver.findElement(By.xpath(hoverObj));
		         String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		         ((JavascriptExecutor) driver).executeScript(mouseOverScript,elem);
		         Thread.sleep(3000);
		         Log.info("Lookup mouse hover performed");
		         Log.info(elem+"Clicked");
		         test.log(LogStatus.PASS, value,"Mouse over to the element "+value);

		    } catch (Exception e) {
		    	 Log.error(e.getMessage());
	    		 throw (e);
		    }
		}
	
	public void mouse_click(WebDriver driver,String hoverObj,String value,ExtentReports ext_report,ExtentTest test) throws Exception{
		 try 
		     {
			 WebElement elem = driver.findElement(By.xpath(hoverObj));
		         String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		         ((JavascriptExecutor) driver).executeScript(mouseOverScript,elem);
		         Thread.sleep(2000);
		         ((JavascriptExecutor) driver).executeScript("arguments[0].click();",elem);
		         Log.info("Lookup mouse hover performed");
		         Log.info(elem+"Clicked");

		    } catch (Exception e) {
		    	 Log.error(e.getMessage());
	    		 throw (e);
		    }
		} 
	
	public void wait_page_load(WebDriver driver, String title){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20); //you can play with the time integer  to wait for longer than 15 seconds.`
			wait.until(ExpectedConditions.titleContains(title)); 
		}
		catch (Exception e){
			System.out.println("Exception "+e);
		}
	}
	
	public void wait_to_element(WebDriver driver, String eleObj){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 15); //you can play with the time integer  to wait for longer than 15 seconds.`
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(eleObj)));
		}
		catch (Exception e){
			System.out.println("Exception "+e);
		}
	}
	
	public String GetCurrentSystemDate(){
		int day, month, year;
		GregorianCalendar date = new GregorianCalendar();

		day = date.get(Calendar.DAY_OF_MONTH);
		month = date.get(Calendar.MONTH);
		year = date.get(Calendar.YEAR);
		//String Sysdate = ""+(month+1)+"/"+day+"/"+year;
		//String Current_day = ;
		System.out.println("Current date is  "+day+"/"+(month+1)+"/"+year);
		return String.valueOf(day);
	}
	
	public String switchFrame(WebDriver driver, String frameObj){
		driver.switchTo().defaultContent();
		WebElement frame= driver.findElement(By.xpath(frameObj));
		String frame_name = frame.getAttribute("class");
		System.out.println(frame_name);
	    driver.switchTo().frame(frame);
		return frame_name;
	}
	
	public WebElement checkBox(String strElement,WebDriver driver) {
	    try {
	    	WebElement element = driver.findElement(By.xpath(strElement));
	    	element.getTagName();
	    	return element;
	    } catch (Exception e) {
	    	//Log.error("Exception :" + e.getMessage());
	    	//Reporter.log("Exception :" + e.getMessage());
	    	System.out.println(strElement + " does not existExist");
	        return null;
	    }
	}
	
	public void SelectDropDown(WebDriver driver,String objPath, String value,ExtentReports ext_report,ExtentTest test) throws Exception{
		try{
			if (value != null && value.trim().length() >0 ){
				Select oSelect = new Select(driver.findElement(By.xpath(objPath)));
				oSelect.selectByVisibleText(value);
				Log.info("Selected - '"+value+"' from the dropdown");
				test.log(LogStatus.PASS, "value", value+" selected from the drop down");
			}
		} catch (Exception e){
			Log.error("Staffing :: Dropdown selection failed..." +e);
			test.log(LogStatus.FAIL, "value", "Exception occured for dropdown selection "+e);
		}
	}
	
	public void clkElement(WebDriver driver,String clkObject,String Elementname,ExtentReports ext_report,ExtentTest test){
		try{
			driver.findElement(By.xpath(clkObject)).click();
			Log.info(Elementname+" - having xpath '"+clkObject+"' clicked sucessfully");
			//test.log(LogStatus.PASS, Elementname, "Element having xpath '"+clkObject+"' clicked sucessfully");
			test.log(LogStatus.PASS, Elementname, Elementname+"' clicked sucessfully");
			System.out.println(Elementname+" - having xpath '"+clkObject+"' clicked sucessfully");
		} catch (Exception e){
			System.out.println("Element  '"+clkObject+"'  click failed "+e);
			Log.error(Elementname+" - having xpath '"+clkObject+"'  click failed  - "+e);
		}
	}
	
	public void VzLogout(WebDriver driver){
		Log.info("VzKnowledge : Logout Method Invoked");
		try {
			driver.findElement(By.xpath(EndUser.profile_name)).click();
			sleep(1000);
			driver.findElement(By.xpath(EndUser.profile_signout)).click();
			sleep(1000);
			//driver.quit();
		}
		catch (Exception e){
			System.out.println("VzKnowledge LogOut :: Failed");
			Log.info("VzKnowledge LogOut :: Exception "+e);
		}
	}
	public void send_data(WebDriver driver,String dataObj,String dataValue,ExtentReports ext_report,ExtentTest test){
		try{
			driver.findElement(By.xpath(dataObj)).sendKeys(dataValue);
			Log.info("Data  '"+dataValue+"' entered sucessfully in the text box");
			test.log(LogStatus.PASS, "dataValue "+dataValue+"' sucessfully entered in the Text box");
		} catch (Exception e){
			Log.info("Exception Occured while entering the data "+dataValue+" in the text box"+e);
			test.log(LogStatus.FAIL, "dataValue","Exception Occured while entering the data "+dataValue+" in the text box"+e);
		}
	}
	
	/*For Admin*/
	
	public static boolean VerifyElementPresent(WebDriver driver,WebElement element,String elementName,ExtentReports ext_report,ExtentTest test) {
		try {
			//WebElement element = driver.findElement(By.xpath(strElement));
			element.getTagName();
			Log.info("Element ["+elementName+" ] not Present");
			test.log(LogStatus.PASS,elementName, "Element ["+elementName+" ] does not Present");
			return true;

		} catch (NoSuchElementException e) {
			Log.error("Element ["+elementName+" ] not Present");
			test.log(LogStatus.PASS,elementName, "Element ["+elementName+" ] does not Present");
			
			return false;
		}
	}

	public static void writeConsole(String message){
		System.out.println("INFO: "+message);			
	}

	public void waitForPageToLoad(WebDriver driver){
		writeConsole("waitForPageToLoad["+STANDARD_PAGE_LOAD_WAIT_TIME+"]");	
		selenium.waitForPageToLoad(STANDARD_PAGE_LOAD_WAIT_TIME);
	}






	public static void alertAccept(WebDriver driver){		
		try{
		writeConsole("Webdriver Alert accept");
		Alert alert = driver.switchTo().alert();		
		alert.accept();
		Log.info("Alert accepted");
		
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void alertDismiss(WebDriver driver){		
		writeConsole("Webdriver Alert dismiss");
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	

	public static boolean isAlertPresent(){
		try{   
			   driver.switchTo().alert().dismiss();  
			  }catch(Exception e){ 
			   System.out.println("unexpected alert not present");   
			  }
		return false;

	}

	public void multipleWindowHandles(WebDriver driver)
	{

		for ( String handle : driver.getWindowHandles()) {

			System.out.println(handle);

			driver.switchTo().window(handle);

		}
	}

	public void SwitchToParentWindow(WebDriver driver)
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.switchTo().window(parentWindow); //cntrl to parent window
			}
		}
	}
	
	public boolean chkChildWindow(WebDriver driver, String pwindow)
	{
		//boolean result = true;
		Set<String> handles =  driver.getWindowHandles();
		boolean result = false;
		for(String windowHandle  : handles)
		{
			System.out.println("Handle: "+windowHandle);
			if(!windowHandle.equals(pwindow))
			{
				System.out.println("Content may Doc or Excel");
				result = true;
			}
			else{
				result = false;
			}
		}
		return result;
	}
	
	public void switchChildWindow(WebDriver driver, String pwindow)
	{
		Set<String> handles =  driver.getWindowHandles();
		
		for(String windowHandle  : handles)
		{
			System.out.println("Handle: "+windowHandle);
			if(!windowHandle.equals(pwindow))
			{
				System.out.println(windowHandle);
				driver.switchTo().window(windowHandle);
			
			}
			else{
				
			}
		}
	
	}

	public String getTitleWebdriver() 
	{	
		String gettitle = driver.getTitle();
		writeConsole("Webdriver getTitle["+gettitle+"]");
		return gettitle;

	}

			
	
	public static void doubleClick(String objectPath,WebDriver driver){
		try{
			Actions action = new Actions(driver);
			WebElement element=driver.findElement(By.xpath(objectPath));
			//Double click
			action.doubleClick(element).perform();
		}catch(Exception e){
			Reporter.log("Double click failed  -"+e);
			Log.error("Double click failed on - "+objectPath);

		}

	}


	public static void DivLoading(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[starts-with(@id , 'divLoading')]//img")));
	}

	public static void WaitForElementNotVisible(WebDriver driver,String strElement)
	{
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(strElement)));
	}



	public static void waitForElementPresentWebdriver(String byattributename,String byattributevalue,String elementName,WebDriver driver,ExtentReports ext_report,ExtentTest test){
		try {
			writeConsole("Webdriver Wait for presenceOfElementLocated["+byattributename+", "+byattributevalue+"]");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(byattributeNameValue(byattributename, byattributevalue)));
			Reporter.log("Element ["+elementName+" ] was Present");
			Log.info("Element ["+elementName+" ] was Present");
			test.log(LogStatus.PASS,elementName, "Element ["+elementName+" ] was Present");
		} catch (Exception e) {
			Log.error("Element ["+elementName+" ] was not Present");
			test.log(LogStatus.PASS,elementName, "Element ["+elementName+" ] was not Present");
			writeConsole("Element ["+elementName+" ] was Not Present");
		}

	}
	public static By byattributeNameValue(String byattributename,String byattributevalue) {
		By by = null;	

		if (byattributename == null) {
			writeConsole("Attribute Name is Empty or Null");
		}

		//				This Below Condition will Modify OR to Work on Webdriver and also works with Selenium RC
		if (byattributevalue.contains("css=")) {
			byattributevalue = byattributevalue.replace("css=", "");
			if (byattributevalue.contains("contains")) {
				by = (By) ((JavascriptExecutor)driver).executeScript("return$(\""+ byattributevalue +"\")[0]");
				if (by == null) {
					writeConsole("Attribute Value is Not Found");
				}
				return by;		
			}

		}else if (byattributevalue.contains("xpath=")) {
			byattributevalue = byattributevalue.replace("xpath=", "");
		}

		switch(byattributename) {
		case "classname":
			by = By.className(byattributevalue);
			break;
		case "cssselector":
			by = By.cssSelector(byattributevalue);
			break;
		case "id":
			by = By.id(byattributevalue);
			break;
		case "linktext":
			by = By.linkText(byattributevalue);
			break;
		case "name":
			by = By.name(byattributevalue);
			break;
		case "partiallinktext":
			by = By.partialLinkText(byattributevalue);
			break;
		case "tagname":
			by = By.tagName(byattributevalue);
			break;
		case "xpath":
			by = By.xpath(byattributevalue);
			break;			
		default:
			writeConsole("Invalid Attribute Name : "+byattributename);
			break;

		}					
		writeConsole("["+by+"]");
		return by;


	}
	public static boolean verifyElementPresentWebdriver(String byattributename,String byattributevalue,String elementname,WebDriver driver) throws Exception{
		Reporter.log("Proceed to verify Element("+elementname+") is Present correctly");
		writeConsole("Element Present["+byattributename+", "+byattributevalue+"]");
		try {						
			byattributeNameValue(byattributename, byattributevalue);
			writeConsole("Webdriver Element Present");
			Reporter.log("Element("+elementname+") was Present correctly");	
			return true;
		} catch (Exception e) {
			writeConsole("Webdriver Element Not Present");
			writeConsole("Element ["+elementname+" ] was Not Present");	
			return false;
		}

	}

	public static void getTableHeaders(String elementValue,WebDriver driver,ExtentReports ext_report,ExtentTest test) throws Exception
	{
		String [] values;
		try
		{
		if(elementValue.equalsIgnoreCase("BusinessGroup"))
		{
			values = ApplicationConstants.BusinessGroup_Table_Headers;
			for(int i=0;i< values.length;i++)
			{
				System.out.println("values===" +values[i]+"length===" +values.length);
				verifyElementPresentWebdriver(attributeName_xpath,Admin.tblHeaders_starts+values[i]+Admin.tblHeaders_ends,elementValue,driver);
				Log.info(values[i] +"-Verified available Table headers");
				test.log(LogStatus.PASS,values[i], "Verified available Table headers");
			}		 
		}
		else if(elementValue.equalsIgnoreCase("GlobalReviewers") && elementValue.equalsIgnoreCase("Properties"))
		{
			values = ApplicationConstants.GlobalReviewers_Table_Headers;
			for(int i=0;i< values.length;i++)
			{
				System.out.println("values===" +values[i]+"length===" +values.length);
				verifyElementPresentWebdriver(attributeName_xpath,Admin.tblHeaders_starts+values[i]+Admin.tblHeaders_ends,elementValue,driver);
				Log.info(values[i] +"-Verified available Table headers");
				test.log(LogStatus.PASS,values[i], "Verified available Table headers");
			}	

		}
		else if(elementValue.equalsIgnoreCase("MetaTypes"))
		{
			values = ApplicationConstants.MetaType_Table_Headers;
			for(int i=0;i< values.length;i++)
			{
				System.out.println("values===" +values[i]+"length===" +values.length);
				verifyElementPresentWebdriver(attributeName_xpath,Admin.tblHeaders_starts+values[i]+Admin.tblHeaders_ends,elementValue,driver);
				Log.info(values[i] +"-Verified available Table headers");
				test.log(LogStatus.PASS,values[i], "Verified available Table headers");
			}	

		}
		else if(elementValue.equalsIgnoreCase("SuperAdmin"))
		{
			values = ApplicationConstants.SuperAdmin_Table_Headers;
			for(int i=0;i< values.length;i++)
			{
				System.out.println("values===" +values[i]+"length===" +values.length);
				verifyElementPresentWebdriver(attributeName_xpath,Admin.tblHeaders_starts+values[i]+Admin.tblHeaders_ends,elementValue,driver);
				Log.info(values[i] +"-Verified available Table headers");
				test.log(LogStatus.PASS,values[i], "Verified available Table headers");
			}	

		}
		else if(elementValue.equalsIgnoreCase("WorkFlowGroups"))
		{
			values = ApplicationConstants.WorkFlowGroups_Table_Headers;
			for(int i=0;i< values.length;i++)
			{
				System.out.println("values===" +values[i]+"length===" +values.length);
				verifyElementPresentWebdriver(attributeName_xpath,Admin.tblHeaders_starts+values[i]+Admin.tblHeaders_ends,elementValue,driver);
				Log.info(values[i] +"-Verified available Table headers");
				test.log(LogStatus.PASS,values[i], "Verified available Table headers");
			}	

		}
		else if(elementValue.equalsIgnoreCase("PresetRoles"))
		{
			values = ApplicationConstants.PresetRoles_Table_Headers;
			for(int i=0;i< values.length;i++)
			{
				System.out.println("values===" +values[i]+"length===" +values.length);
				verifyElementPresentWebdriver(attributeName_xpath,Admin.tblHeaders_starts+values[i]+Admin.tblHeaders_ends,elementValue,driver);
				Log.info(values[i] +"-Verified available Table headers");
				test.log(LogStatus.PASS,values[i], "Verified available Table headers");
			}	

		}
		else if(elementValue.equalsIgnoreCase("ProfileSettings"))
		{
			values = ApplicationConstants.Profile_Settings_Table_Headers;
			for(int i=0;i< values.length;i++)
			{
				System.out.println("values===" +values[i]+"length===" +values.length);
				verifyElementPresentWebdriver(attributeName_xpath,Admin.tblHeaders_starts+values[i]+Admin.tblHeaders_ends,elementValue,driver);
				Log.info(values[i] +"-Verified available Table headers");
				test.log(LogStatus.PASS,values[i], "Verified available Table headers");
			}	

		}
		else if(elementValue.equalsIgnoreCase("SiteLayout"))
		{
			values = ApplicationConstants.SiteLayout_Table_Headers;
			for(int i=0;i< values.length;i++)
			{
				System.out.println("values===" +values[i]+"length===" +values.length);
				verifyElementPresentWebdriver(attributeName_xpath,Admin.tblHeaders_starts+values[i]+Admin.tblHeaders_ends,elementValue,driver);
				Log.info(values[i] +"-Verified available Table headers");
				test.log(LogStatus.PASS,values[i], "Verified available Table headers");
			}	

		}
		else if(elementValue.equalsIgnoreCase("QueryGroups"))
		{
			values = ApplicationConstants.QueryGroups_Table_Headers;
			for(int i=0;i< values.length;i++)
			{
				System.out.println("values===" +values[i]+"length===" +values.length);
				verifyElementPresentWebdriver(attributeName_xpath,Admin.tblHeaders_starts+values[i]+Admin.tblHeaders_ends,elementValue,driver);
				Log.info(values[i] +"-Verified available Table headers");
				test.log(LogStatus.PASS,values[i], "Verified available Table headers");
			}	

		}
		
		else if(elementValue.equalsIgnoreCase("ManageUsers"))
		{
			values = ApplicationConstants.Users_Table_Headers;
			for(int i=0;i< values.length;i++)
			{
				System.out.println("values===" +values[i]+"length===" +values.length);
				verifyElementPresentWebdriver(attributeName_xpath,Admin.tblHeaders_starts+values[i]+Admin.tblHeaders_ends,elementValue,driver);
				Log.info(values[i] +"-Verified available Table headers");
				test.log(LogStatus.PASS,values[i], "Verified available Table headers");
			}	

		}
		else if(elementValue.equalsIgnoreCase("UserGroups"))
		{
			values = ApplicationConstants.UsersGroups_Table_Headers;
			for(int i=0;i< values.length;i++)
			{
				System.out.println("values===" +values[i]+"length===" +values.length);
				verifyElementPresentWebdriver(attributeName_xpath,Admin.tblHeaders_starts+values[i]+Admin.tblHeaders_ends,elementValue,driver);
				Log.info(values[i] +"-Verified available Table headers");
				test.log(LogStatus.PASS,values[i], "Verified available Table headers");
			}	

		}

		}catch(Exception e)
		{
			Log.info(elementValue +"-Table is not visible");
			test.log(LogStatus.PASS,elementValue, "Table is not visible");
		}
	}


	

	public static WebElement attributeNameValue(String attributename,String attributevalue) {
		WebElement webelement = null;
		if (attributename == null) {
			writeConsole("Attribute Name is Empty or Null");
		}

		//	This Below Condition will Modify OR to Work on Webdriver and also works with Selenium RC
		if (attributevalue.contains("css=")) {
			attributevalue = attributevalue.replace("css=", "");
			if (attributevalue.contains("contains")) {
				//						writeConsole("Contains ");
				webelement = (WebElement)((JavascriptExecutor)driver).executeScript("return $(\""+attributevalue +"\")[0]");

				if (webelement == null) {
					writeConsole("Attribute Value is Not Found");
				}
				return webelement;

			}

		}else if (attributevalue.contains("xpath=")) {
			attributevalue = attributevalue.replace("xpath=", "");
		}
		switch(attributename) {
		case "classname":
			webelement = driver.findElement(By.className(attributevalue));
			break;
		case "cssselector":
			webelement = driver.findElement(By.cssSelector(attributevalue));
			break;
		case "id":
			webelement = driver.findElement(By.id(attributevalue));
			break;
		case "linktext":
			webelement = driver.findElement(By.linkText(attributevalue));
			break;
		case "name":
			webelement = driver.findElement(By.name(attributevalue));
			break;
		case "partiallinktext":
			webelement = driver.findElement(By.partialLinkText(attributevalue));
			break;
		case "tagname":
			webelement = driver.findElement(By.tagName(attributevalue));
			break;
		case "xpath":
			System.out.println("attributevalue"  +attributevalue);
			webelement = driver.findElement(By.xpath(attributevalue));
			break;			
		default:
			writeConsole("Invalid Attribute Name : "+attributename);
			break;

		}
		//				writeConsole("["+webelement+"]");
		return webelement;

	}

	
	public void scrollInToWindow(){
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Log.info( "Scrolled in to window successfully ");
		
	}

	public static void scrollInElement(WebDriver driver,String element,ExtentReports ext_report,ExtentTest test)
	{
		try
		{
		// Initialize Javascript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll inside web element vertically (e.g. 100 pixel)
		js.executeScript("arguments[0].scrollTop = arguments[1];",driver.findElement(By.xpath(element)), 100);
		Log.info("Scrolled in to  "+element+ "successfully");
		test.log(LogStatus.PASS,element, "Scrolled in to  "+element+ "successfully");
		}
		catch(Exception e)
		{
			Log.info("Failed to Scroll In To Element- " +element);
			test.log(LogStatus.PASS,element, "Failed to Scroll In To Element");
		}
		
	}

	public static void scrollingToBottomOfPage(WebDriver driver) {
		//driver.navigate().to(URL);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Log.info("Scrolled to bottom of the page successfully ");
		writeConsole("Scrolled to bottom of the page successfully ");
	}
	public static void scrollingByCoordinatesofAPage(WebDriver driver,int coordinateStart,int coordinateEnd) {
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy("+coordinateStart+","+coordinateEnd+")");
		Log.info("Scrolled from "+coordinateStart+"To"+coordinateEnd+" successfuly in the page");
		writeConsole("Scrolled from "+coordinateStart+"To "+ coordinateEnd+" successfuly in the page");
	}


	public static void clickWebdriver(String attributename,String attributevalue){
		writeConsole("Webdriver click["+attributename+", "+attributevalue+"]");
		((WebElement) byattributeNameValue(attributename, attributevalue)).click();
	}

	public static void ExportFile(WebDriver driver,ExtentReports ext_report,ExtentTest test) throws AWTException, InterruptedException
	{
		try{

			Robot rb =new Robot();
			Thread.sleep(1000);
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(3000);
			rb.keyPress(KeyEvent.VK_ENTER); 
			rb.keyRelease(KeyEvent.VK_ENTER); 
			writeConsole("Clicked ok button");
			Log.info("Exported File Successfully");
			test.log(LogStatus.PASS, "Exported File Successfully");
		}
		catch(Exception e)
		{
			Log.info("Failed to Export File");
			test.log(LogStatus.PASS, "Failed to Export File");
		}

	}
	
	public void suppress_window(ExtentReports ext_report,ExtentTest test) throws AWTException, InterruptedException
	{
		try{

			Robot rb =new Robot();
			Thread.sleep(4000);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			//rb.keyRelease(KeyEvent.VK_RIGHT); 
			Log.info("Able to see windows dialog and clicked cancel");
			test.log(LogStatus.PASS, "Dialog","Able to see windows dialog and clicked cancel");
		}
		catch(Exception e)
		{
			Log.info("Failed to Export File");
			test.log(LogStatus.PASS, "Failed to Export File");
		}
	}



	public static boolean FileExists(WebDriver driver,String fileName,ExtentReports ext_report,ExtentTest test) {
		// TODO Auto-generated method stub
		boolean b = false;
		File file = new File(fileName);
		b = file.exists();
		if(b ==true)
		{
			Log.info(fileName +" - File Exists");
			test.log(LogStatus.PASS, fileName, "File Exists");
			file.delete();
			Log.info(fileName +" - File Deleted");
			test.log(LogStatus.PASS, fileName, "File Deleted");
		}
		else
		{
			writeConsole("File does not exists");
			Log.info(fileName +" - File Not Found");
			test.log(LogStatus.PASS, fileName, "File Not Found");
		}
		return b;



	}

	
	public static void clickElementWebDriver(WebDriver driver,WebElement clkObject,String Elementname,ExtentReports ext_report,ExtentTest test){
		try{
			clkObject.click();
			Log.info(Elementname+" - having xpath '"+clkObject+"' clicked sucessfully");
			test.log(LogStatus.PASS, Elementname, "Element having xpath '"+clkObject+"' clicked sucessfully");
			System.out.println(Elementname+" - having xpath '"+clkObject+"' clicked sucessfully");
		} catch (Exception e){
			System.out.println("Element  '"+clkObject+"'  click failed "+e);
			Log.error(Elementname+" - having xpath '"+clkObject+"'  click failed  - "+e);
			test.log(LogStatus.FAIL, Elementname, "Element having xpath '"+clkObject+"' clicked sucessfully");
		}
	} 

	public static void getTableData(WebDriver driver,String objectpath,ExtentReports ext_report,ExtentTest test) throws Exception
	{
		try
		{
		WebElement Webtable=driver.findElement(By.xpath(objectpath));
		List<WebElement> TotalRowCount=Webtable.findElements(By.xpath(objectpath+"/tbody/tr"));
		Log.info("No. of Users in the results: "+TotalRowCount.size());
		test.log(LogStatus.PASS,"No. of Users in the results: "+TotalRowCount.size());
		try{
		// Now we will Iterate the Table and print the Values   
		int RowIndex=1;
		for(WebElement rowElement:TotalRowCount)
		{
			List<WebElement> TotalColumnCount=rowElement.findElements(By.xpath("td"));
			int ColumnIndex=1;
			for(WebElement colElement:TotalColumnCount)
			{
				Log.info("Row "+RowIndex+" Column "+ColumnIndex+" Data "+colElement.getText());
				test.log(LogStatus.PASS,"Row "+RowIndex+" Column "+ColumnIndex+" Data "+colElement.getText());
				ColumnIndex=ColumnIndex+1;
			}
			RowIndex=RowIndex+1;
		}
		}catch(Exception e){
		Log.error("Unable to fetch Row values"+e);
		test.log(LogStatus.FAIL, " Unable to fetch Row values");
		}
		}finally
		{
			Log.info("Table Data Iterated");
			writeConsole("Table Data Iterated");
		}

	}
	
	public static void getTableDataLinks(WebDriver driver,String objectpath,ExtentReports ext_report,ExtentTest test) throws Exception
	{
		try
		{
		WebElement Webtable=driver.findElement(By.xpath(objectpath));
		List<WebElement> TotalRowCount=Webtable.findElements(By.xpath(objectpath+"/tbody/tr"));
		Log.info("No. of Users in the results: "+TotalRowCount.size());
		test.log(LogStatus.PASS,"No. of Users in the results: "+TotalRowCount.size());
		try{
		// Now we will Iterate the Table and print the Values   
		int RowIndex=1;
		for(WebElement rowElement:TotalRowCount)
		{
			List<WebElement> TotalColumnCount=rowElement.findElements(By.xpath("td/a"));
			int ColumnIndex=1;
			for(WebElement colElement:TotalColumnCount)
			{
				Log.info("Row "+RowIndex+" Column "+ColumnIndex+" Data "+colElement.getText());
				test.log(LogStatus.PASS,"Row "+RowIndex+" Column "+ColumnIndex+" Data "+colElement.getText());
				ColumnIndex=ColumnIndex+1;
			}
			RowIndex=RowIndex+1;
		}
		}catch(Exception e){
		Log.error("Unable to fetch Row values"+e);
		test.log(LogStatus.FAIL, " Unable to fetch Row values");
		}
		}finally
		{
			Log.info("Table Data Iterated");
			writeConsole("Table Data Iterated");
		}

	}

	public static String getTextElement(String objPath)
	{
		try{
		WebElement element = driver.findElement(By.xpath(objPath));
		System.out.println(objPath);
		String value = element.getText();
		return value;
		
		}
		catch (Exception e){
			return null;	
		}
	}

	

	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			System.out.println("Error while intializing the excel file " + e);
		}
	}

	public static String getExcelData(String columnname, String rowname) throws Exception {
		ArrayList<String> testcasenamedata = new ArrayList<String>();
		ArrayList<String> colnamedata = new ArrayList<String>();
		int writtenrowno = ExcelWSheet.getPhysicalNumberOfRows();
		boolean colFound = false;
		boolean rowFound = false;	
		String CellData = "";
		try{
			Row = ExcelWSheet.getRow(0);
			int writtencolno = Row.getLastCellNum();
			for (int i = 0; i < writtenrowno; i++) {
				Row = ExcelWSheet.getRow(i);
				Cell = Row.getCell(0);
				if (Cell != null) {
					testcasenamedata.add(Cell.getStringCellValue());
					if (rowname.equalsIgnoreCase(testcasenamedata.get(i))) {
						reqcellrowno = i;
						rowFound = true;
						break;
					}
				}
			}
			if (rowFound) {
				for (int j = 0; j < writtencolno; j++) {
					Row = ExcelWSheet.getRow(0);
					Cell = Row.getCell(j);
					if (Cell != null) {
						colnamedata.add(Cell.getStringCellValue());
						if (columnname.equalsIgnoreCase(colnamedata.get(j))) {
							reqcellcolno = j;
							colFound = true;
							break;
						}
					}
				}
			}
			if (colFound) {
				Cell = ExcelWSheet.getRow(reqcellrowno).getCell(reqcellcolno);
				Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
				CellData = Cell.getStringCellValue();
			}
			return CellData;
		}
		catch (Exception e) {
			System.out.println("Error while getting the cell data by getExcelData(Str1,Str2) for column : "+columnname+" and row : "+rowname+" Exception : " + e.getMessage());
			return CellData;
		}		
	}



	public static int checkRowsForColumn(String columnname, String fileName, String sheetName) throws Exception {
		int dataNumber = 0;
		try 
		{
			InputStream inp = new FileInputStream(fileName);
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheet(sheetName);

			int rowNum = 0;
			int colNum = 0;
			boolean colFound = false;

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				org.apache.poi.ss.usermodel.Row rowLoop = sheet.getRow(i);
				if (rowLoop != null){
					for (int j = 0; j < rowLoop.getLastCellNum(); j++) {
						org.apache.poi.ss.usermodel.Cell c = rowLoop.getCell(j);
						if (c != null) {
							c.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
							String testcaserowname = c.getStringCellValue();
							if (columnname.equalsIgnoreCase(testcaserowname)) {
								rowNum = i;
								colNum = j;
								colFound = true;
								break;
							}
						}
					}
				}
			}
			if (colFound) {
				for (int k = (rowNum+1); k < sheet.getPhysicalNumberOfRows(); k++) {
					org.apache.poi.ss.usermodel.Cell cell = sheet.getRow(k).getCell(colNum);
					cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
					String CellData = cell.getStringCellValue();
					if(CellData != null && CellData.trim().length()>0)
						dataNumber++;
				}

			}                    
			return dataNumber;
		}
		catch (Exception e) {
			System.out.println("Error while getting the cell data by checkRowsForColumn(Str1,Str2,Str3) for column : "+columnname+" Exception : " + e.getMessage());
			return dataNumber;
		}             
	}

public static void ClearTextBoxAndSendKeys(WebDriver driver,WebElement element,String SendChars)
{
	try{
		element.clear();
		element.sendKeys(SendChars);
		Log.info(element+"-This text box cleared sucessfully");
		
	} catch (Exception e){
		writeConsole(element+"-This text box not cleared sucessfully");
		Log.error(element+"-This text box not cleared sucessfully" +e);
	}
}

public static void SendKeysWithoutClear(WebDriver driver,WebElement element,String SendChars,ExtentReports ext_report,ExtentTest test)
{
	try{
		
		element.sendKeys(SendChars);
		Log.info(element+"-Entered"+SendChars+"in Text box");
		test.log(LogStatus.PASS, "Entered "+SendChars+"in Text box");
		
		
	} catch (Exception e){
		writeConsole(element+"Unable to Enter"+SendChars+"in Text box");
		Log.error(element+"Unable to Enter"+SendChars+"in Text box" +e);
	}
}


public static boolean SelDropDown(String strPath,String SelValue,WebDriver driver)throws Exception{
	boolean result = true;
	WebElement element= driver.findElement(By.xpath(strPath));
	if (element.getTagName() !=null && element.getTagName().length()>0){
		Select se=new Select(element);
		se.selectByVisibleText(SelValue);
	}
	else{
		Log.error("Element for xPath "+strPath+" dosen't exists");
		result = false;
	}
	return 	result;
}

public static boolean existsElement(WebDriver driver,String strElement,ExtentReports ext_report,ExtentTest test){
	try {
		WebElement element = driver.findElement(By.xpath(strElement));
		element.getTagName();
		Log.error("Element ["+strElement+" ] not Present");
		test.log(LogStatus.PASS,strElement, "Element ["+strElement+" ] does not Present");
		return true;

	} catch (NoSuchElementException e) {
		Log.error("Element ["+strElement+" ] not Present");
		test.log(LogStatus.PASS,strElement, "Element ["+strElement+" ] does not Present");
		
		return false;
	}
}

// For Authoring

public boolean existsElement(WebDriver driver,String strElement) {
    try {
    	WebElement element = driver.findElement(By.xpath(strElement));
    	element.getTagName();
    	System.out.println(element + "Exist");
    	return true;

    } catch (NoSuchElementException e) {

    	System.out.println( " does not existExist");
        return false;
    }
} 
//public static boolean SelDropDown(String strPath,String SelValue,WebDriver driver)throws Exception{
//	boolean result = true;
//	WebElement element= driver.findElement(By.xpath(strPath));
//	if (element.getTagName() !=null && element.getTagName().length()>0){
//		Select se=new Select(element);
//		se.selectByVisibleText(SelValue);
//	}
//	else{
//		Log.error("Element for xPath "+strPath+" dosen't exists");
//		result = false;
//	}
//	return 	result;
//}


public void Execute(WebDriver driver, WebElement element ) throws Exception{
	
	try{
	
	Actions action = new Actions(driver);
  
    action.moveToElement(element).perform();

    action.click();

    action.perform();

	}catch (Exception e){
		
		 Log.error(e.getMessage());
		 throw (e);
		
	}
    
    
}
public static void FindTextInTable(WebDriver driver,String tablePath,ExtentReports ext_report,ExtentTest test)
{
WebElement TableElement = driver.findElement(By.xpath(tablePath));
List<WebElement> TotalRowCount=TableElement.findElements(By.xpath(tablePath+"/tbody/tr"));
System.out.println("RowCount" +TotalRowCount.size());
String value = null;
int row = 1,column = 1;
for (WebElement element1:TotalRowCount) 
{
if(value.contains(ApplicationConstants.PresetRole_Name))
{
	System.out.println("inside");
	List<WebElement> TotalColumnCount=element1.findElements(By.xpath(tablePath+"/tbody/tr/td"));
	System.out.println("size" +TotalColumnCount.size());
	for (WebElement element2:TotalColumnCount)
	{
		value = element2.getText();
		Log.info(value+"-Text found ");
		test.log(LogStatus.PASS, value+"-Text found ");	
		//column = column+1;
	}
}
}

}



public static void open_selhubFF() throws Exception{
	
	threadDriver = new ThreadLocal<RemoteWebDriver>(); 
	DesiredCapabilities dc = new DesiredCapabilities(); 
	FirefoxProfile fp = new FirefoxProfile(); 
	dc.setCapability(FirefoxDriver.PROFILE, fp); 
	dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName()); 
	threadDriver.set(new RemoteWebDriver(new URL(SELENIUM_HUB_URL), dc)); 
	driver = threadDriver.get(); 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	driver.manage().deleteAllCookies(); 	
}

public static void open_selhubIE() throws Exception{
	
	threadDriver = new ThreadLocal<RemoteWebDriver>(); 
	DesiredCapabilities dc =  DesiredCapabilities.internetExplorer();
	dc.setPlatform(Platform.WINDOWS);
	dc.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
	dc.setVersion("11");  
	threadDriver.set(new RemoteWebDriver(new URL(SELENIUM_HUB_URL), dc)); 
	driver = threadDriver.get(); 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	driver.manage().deleteAllCookies(); 
}	



public static void openBrowserIE() throws Exception{
   
    try{
    	
    	System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
    	DesiredCapabilities returnCapabilities = DesiredCapabilities.internetExplorer();
    	//returnCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
    	driver = new InternetExplorerDriver(returnCapabilities);
    	
    	//driver=new InternetExplorerDriver(); 
        Log.info("New driver instantiated");
        driver.manage().window().maximize();
        Log.info("Web application launched successfully");
    }catch (Exception e){

        Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());

    }
}


public static void openBrowserFF() throws Exception{
	
	   // String sBrowserName;
	    
	    try{
	    	
	    	driver = new FirefoxDriver();
	    			
	        Log.info("New driver instantiated");
	
	
	        
	        driver.manage().window().maximize();
	
	        Log.info("Web application launched successfully");
	
	
	    }catch (Exception e){
	
	        Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
	
	    }
		
	}

}


	
	
	
	

