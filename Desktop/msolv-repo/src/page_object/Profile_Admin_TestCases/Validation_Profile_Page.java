package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class Validation_Profile_Page {
	
	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.VALIDATION_PROFILE_FILEPATH);
	private static String Validate_msg = putil.getEnvironmentProperty("Validate_msg");
	private static String Submit = putil.getEnvironmentProperty("Submit");
	public static String pagebanner = putil.getEnvironmentProperty("pagebanner");
	public static String LN_lnk = putil.getEnvironmentProperty("LN_lnk");
	public static String Address2 = putil.getEnvironmentProperty("Address2");
	
	public static String strPath = Validate_msg+":"+Submit;
	

	public static WebElement Validate_msg(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Validate_msg));
	   	 
	   	 Log.info("Validate msg field Found");

	        return element;

	        }
	
	public static WebElement Submit(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Submit));
	   	 
	   	 Log.info("Submit Field Found");

	        return element;

	        }


}
