package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class DiscrepancyMaintenance_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.DISCREPANCY_MAINTENANCE_ADMIN_FILEPATH);
	public static String ClearAll = putil.getEnvironmentProperty("ClearAll");
	public static String Back = putil.getEnvironmentProperty("Back");
	public static String Add = putil.getEnvironmentProperty("Add");
	private static String SelectAll = putil.getEnvironmentProperty("SelectAll");
	public static String Delete = putil.getEnvironmentProperty("Delete");

	public static String strPath = ClearAll+":"+Back+":"+Add+":"+SelectAll+":"+Delete;
	
	public static WebElement ClearAll(WebDriver driver){
		 
   	 element = driver.findElement(By.xpath(ClearAll));
   	 
   	 Log.info("Clear All Field Found");

        return element;

        }
	
	public static WebElement Back(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Back));
	   	 
	   	 Log.info("Back Field Found");

	        return element;

	        }
	
	public static WebElement SelectAll(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(SelectAll));
	   	 
	   	 Log.info("Select All Field Found");

	        return element;

	        }

}