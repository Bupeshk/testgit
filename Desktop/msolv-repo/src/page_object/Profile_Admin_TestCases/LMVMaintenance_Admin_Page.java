package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class LMVMaintenance_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.LMV_MAINTENANCE_ADMIN_FILEPATH);
	public static String Delete = putil.getEnvironmentProperty("Delete");
	public static String checkbox = putil.getEnvironmentProperty("checkbox");
	public static String Back = putil.getEnvironmentProperty("Back");
	public static String Add = putil.getEnvironmentProperty("Add");

	public static String strPath = checkbox+":"+Delete;

	public static WebElement Delete(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Delete));
	   	 
	   	 Log.info("Delete field Found");

	        return element;

	        }
	public static WebElement Add(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Add));
	   	 
	   	 Log.info("Add field Found");

	        return element;

	        }
	public static WebElement Back(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Back));
	   	 
	   	 Log.info("Back Field Found");

	        return element;

	        }
	
	 
}