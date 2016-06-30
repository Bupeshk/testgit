package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class MaterialStatusChange_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.MATERIAL_STATUS_CHANGE_ADMIN_FILEPATH);
	private static String Save = putil.getEnvironmentProperty("Save");
	private static String materialStatusTo = putil.getEnvironmentProperty("materialStatusTo");
	private static String materialStatus = putil.getEnvironmentProperty("materialStatus");
	private static String cwonumber = putil.getEnvironmentProperty("cwonumber");

	public static String strPath = cwonumber+":"+Save+":"+materialStatusTo+":"+Save;
	

	public static WebElement materialStatusTo(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(materialStatusTo));
	   	 
	   	 Log.info("material Status To field Found");

	        return element;

	        }

	public static WebElement Save(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Save));
	   	 
	   	 Log.info("Save field Found");

	        return element;

	        }
	public static WebElement materialStatus(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(materialStatus));
	   	 
	   	 Log.info("material Status field Found");

	        return element;

	        }
	public static WebElement cwonumber(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(cwonumber));
	   	 
	   	 Log.info("cwo number Field Found");

	        return element;

	        }
	
	 
}