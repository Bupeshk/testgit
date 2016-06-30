package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class HolidayMaintenance_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.HOLIDAY_MAINTENANCE_ADMIN_FILEPATH);
	private static String description = putil.getEnvironmentProperty("description");
	private static String RegionEast = putil.getEnvironmentProperty("RegionEast");
	private static String Save = putil.getEnvironmentProperty("Save");
	private static String SelectAll = putil.getEnvironmentProperty("SelectAll");
	private static String Delete = putil.getEnvironmentProperty("Delete");
	private static String datepicker = putil.getEnvironmentProperty("datepicker");
	private static String date = putil.getEnvironmentProperty("date");

	public static String strPath = description+":"+RegionEast+":"+Save+":"+SelectAll+":"+Delete+":"+datepicker+":"+date;
	
	public static WebElement description(WebDriver driver){
		 
   	 element = driver.findElement(By.xpath(description));
   	 
   	 Log.info("description Field Found");

        return element;

        }
	
	public static WebElement RegionEast(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(RegionEast));
	   	 
	   	 Log.info("Region East Field Found");

	        return element;

	        }
	
	public static WebElement Save(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Save));
	   	 
	   	 Log.info("Save Field Found");

	        return element;

	        }
	public static WebElement SelectAll(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(SelectAll));
	   	 
	   	 Log.info("Select All Field Found");

	        return element;

	        }
	public static WebElement Delete(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Delete));
	   	 
	   	 Log.info("Delete Field Found");

	        return element;

	        }
	public static WebElement datepicker(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(datepicker));
	   	 
	   	 Log.info("date picker Field Found");

	        return element;

	        }
	public static WebElement date(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(date));
	   	 
	   	 Log.info("date Field Found");

	        return element;

	        }
	 
}