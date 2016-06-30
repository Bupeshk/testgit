package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class VendorExpediteManagement_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.VENDOR_EXPEDITE_MANAGEMENT_ADMIN_FILEPATH);
	private static String CCRWO = putil.getEnvironmentProperty("CCRWO");
	private static String Vendor = putil.getEnvironmentProperty("Vendor");
	private static String Submit = putil.getEnvironmentProperty("Submit");
	
	
	public static String strPath = CCRWO+":"+Vendor+":"+Submit;
	
	public static WebElement CCRWO(WebDriver driver){
		 
   	 element = driver.findElement(By.xpath(CCRWO));
   	 
   	 Log.info("CCRWO Field Found");

        return element;

        }
	

	public static WebElement Vendor(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Vendor));
	   	 
	   	 Log.info("Vendor field Found");

	        return element;

	        }
	
	public static WebElement Submit(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Submit));
	   	 
	   	 Log.info("Submit field Found");

	        return element;

	        }
	
	 
}