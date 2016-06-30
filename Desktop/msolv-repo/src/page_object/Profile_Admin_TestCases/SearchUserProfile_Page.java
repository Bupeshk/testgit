package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class SearchUserProfile_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.SEARCH_USER_PROFILE_FILEPATH);
	public static String SearchUser = putil.getEnvironmentProperty("SearchUser");
	public static String InactiveUser = putil.getEnvironmentProperty("InactiveUser");
	private static String UserID = putil.getEnvironmentProperty("User_ID");
	public static String lastname = putil.getEnvironmentProperty("last_name");
	public static String Submit = putil.getEnvironmentProperty("Submit");
	public static String Reset = putil.getEnvironmentProperty("Reset");
	private static String Back = putil.getEnvironmentProperty("Back");
	
	
	public static String strPath = InactiveUser+":"+UserID+":"+lastname+":"+Submit+":"+Reset+":"+Back;
	
	public static WebElement InactiveUser(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(InactiveUser));
	   	 
	   	 Log.info("Inactive User Checkbox Found");

	        return element;

	        }
	
	
	public static WebElement LastName(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(lastname));
	   	 
	   	 Log.info("Last Name field Found");

	        return element;

	        }
	
	public static WebElement UserID(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(UserID));
	   	 
	   	 Log.info("User ID field Found");

	        return element;

	        }
	
	public static WebElement Btn_Submit(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Submit));
	   	 
	   	 Log.info("Submit field Found");

	        return element;

	        }
	
	public static WebElement Reset(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Reset));
	   	 
	   	 Log.info("Reset field Found");

	        return element;

	        }
	
	public static WebElement Back(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Back));
	   	 
	   	 Log.info("Back field Found");

	        return element;

	        }
	
	
	 
}