package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class Validation_MassUpdateTool_Admin_Page {
	
	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.VALIDATION_MASS_UPDATE_TOOL_FILEPATH);
	private static String Validate_msg = putil.getEnvironmentProperty("Validate_msg");
	private static String Selectoption = putil.getEnvironmentProperty("Selectoption");
	
	public static String strPath = Validate_msg+":"+Selectoption;
	

	public static WebElement Validate_msg(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Validate_msg));
	   	 
	   	 Log.info("Validate msg field Found");

	        return element;

	        }
	
	public static WebElement Selectoption(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Selectoption));
	   	 
	   	 Log.info("Select option Field Found");

	        return element;

	        }


}
