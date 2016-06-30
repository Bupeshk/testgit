package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class VendorContactMaintenance_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.VENDOR_CONTACT_MAINTENANCE_ADMIN_FILEPATH);
	private static String VendorName = putil.getEnvironmentProperty("VendorName");
	private static String Submit = putil.getEnvironmentProperty("Submit");
	
	
	public static String strPath = VendorName+":"+Submit;
	
	public static WebElement VendorName(WebDriver driver){
		 
   	 element = driver.findElement(By.xpath(VendorName));
   	 
   	 Log.info("Vendor Name Field Found");

        return element;

        }
	

	public static WebElement Submit(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Submit));
	   	 
	   	 Log.info("Submit field Found");

	        return element;

	        }
	
	 
}