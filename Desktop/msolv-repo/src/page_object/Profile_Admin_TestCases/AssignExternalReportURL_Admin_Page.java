package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class AssignExternalReportURL_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.ASSIGN_EXTERNAL_REPORT_URL_ADMIN_FILEPATH);
	private static String CustomerID = putil.getEnvironmentProperty("CustomerID");
	private static String Role = putil.getEnvironmentProperty("Role");
	private static String ExternalReportURL = putil.getEnvironmentProperty("ExternalReportURL");
	private static String Submit = putil.getEnvironmentProperty("Submit");
	
	
	public static String strPath = CustomerID+":"+Role+":"+ExternalReportURL+":"+Submit;
	
	public static WebElement CustomerID(WebDriver driver){
		 
   	 element = driver.findElement(By.xpath(CustomerID));
   	 
   	 Log.info("Customer ID Field Found");

        return element;

        }
	
	public static WebElement Role(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Role));
	   	 
	   	 Log.info("Role field Found");

	        return element;

	        }
	
	public static WebElement ExternalReportURL(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(ExternalReportURL));
	   	 
	   	 Log.info("External Report URL field Found");

	        return element;

	        }
	
	public static WebElement Submit(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Submit));
	   	 
	   	 Log.info("Submit field Found");

	        return element;

	        }
	
	 
}