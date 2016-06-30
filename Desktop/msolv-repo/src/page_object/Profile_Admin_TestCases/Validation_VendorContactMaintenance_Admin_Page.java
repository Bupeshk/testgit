package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class Validation_VendorContactMaintenance_Admin_Page {
	
	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.VALIDATION_VENDOR_CONTACT_MAINTENANCE_FILEPATH);
	private static String VendorName = putil.getEnvironmentProperty("VendorName");
	private static String VendorCode = putil.getEnvironmentProperty("VendorCode");
	private static String ContactName = putil.getEnvironmentProperty("ContactName");
	private static String ContactPhone = putil.getEnvironmentProperty("ContactPhone");
	private static String VendorEmailAddress = putil.getEnvironmentProperty("VendorEmailAddress");
	private static String ContactFax = putil.getEnvironmentProperty("ContactFax");
	private static String SecondaryEmailAddress = putil.getEnvironmentProperty("SecondaryEmailAddress");
	private static String Back = putil.getEnvironmentProperty("Back");
	private static String Submit = putil.getEnvironmentProperty("Submit");
	
	public static String strPath = VendorName+":"+VendorCode+":"+ContactName+":"+ContactPhone+":"+VendorEmailAddress+":"+ContactFax+":"+SecondaryEmailAddress+":"+Back+":"+Submit;
	

	public static WebElement VendorName(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(VendorName));
	   	 
	   	 Log.info("Vendor Name field Found");

	        return element;

	        }
	public static WebElement VendorCode(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(VendorCode));
	   	 
	   	 Log.info("Vendor Code field Found");

	        return element;

	        }
	public static WebElement ContactName(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(ContactName));
	   	 
	   	 Log.info("Contact Name field Found");

	        return element;

	        }
	public static WebElement ContactPhone(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(ContactPhone));
	   	 
	   	 Log.info("Contact Phone field Found");

	        return element;

	        }
	public static WebElement VendorEmailAddress(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(VendorEmailAddress));
	   	 
	   	 Log.info("Vendor Email Address field Found");

	        return element;

	        }
	public static WebElement ContactFax(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(ContactFax));
	   	 
	   	 Log.info("Contact Fax field Found");

	        return element;

	        }
	public static WebElement SecondaryEmailAddress(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(SecondaryEmailAddress));
	   	 
	   	 Log.info("Secondary Email Address field Found");

	        return element;

	        }
	public static WebElement Back(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Back));
	   	 
	   	 Log.info("Back field Found");

	        return element;

	        }
	
	public static WebElement Submit(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Submit));
	   	 
	   	 Log.info("Submit Field Found");

	        return element;

	        }


}
