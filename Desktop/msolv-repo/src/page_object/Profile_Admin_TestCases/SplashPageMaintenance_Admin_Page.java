package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class SplashPageMaintenance_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.SPLASH_PAGE_MAINTENANCE_ADMIN_FILEPATH);
	private static String modify = putil.getEnvironmentProperty("modify");
	private static String bodycontent = putil.getEnvironmentProperty("bodycontent");

	public static String strPath = modify+":"+bodycontent;
	
	public static WebElement modify(WebDriver driver){
		 
   	 element = driver.findElement(By.xpath(modify));
   	 
   	 Log.info("modify Field Found");

        return element;

        }
	
	public static WebElement bodycontent(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(bodycontent));
	   	 
	   	 Log.info("body content Field Found");

	        return element;

	        }
	
	 
}