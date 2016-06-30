package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class AssignReuseCoordinatorEmailAddress_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.ASSIGN_REUSE_COORDINATOR_EMAIL_ADDRESS_ADMIN_FILEPATH);
	private static String CustomerID = putil.getEnvironmentProperty("CustomerID");
	private static String ReuseCoordinatorEmailAddress = putil.getEnvironmentProperty("ReuseCoordinatorEmailAddress");
	private static String Submit = putil.getEnvironmentProperty("Submit");
	
	
	public static String strPath = CustomerID+":"+ReuseCoordinatorEmailAddress+":"+Submit;
	
	public static WebElement CustomerID(WebDriver driver){
		 
   	 element = driver.findElement(By.xpath(CustomerID));
   	 
   	 Log.info("Customer ID Field Found");

        return element;

        }
	

	public static WebElement ReuseCoordinatorEmailAddress(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(ReuseCoordinatorEmailAddress));
	   	 
	   	 Log.info("Reuse Coordinator Email Address field Found");

	        return element;

	        }
	
	public static WebElement Submit(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Submit));
	   	 
	   	 Log.info("Submit field Found");

	        return element;

	        }
	
	 
}