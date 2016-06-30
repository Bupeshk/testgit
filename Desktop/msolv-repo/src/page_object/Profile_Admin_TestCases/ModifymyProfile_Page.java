package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class ModifymyProfile_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.MODIFY_MY_PROFILE_FILEPATH);
	public static String Modifymyprofile = putil.getEnvironmentProperty("Modifymyprofile");
	public static String Submit = putil.getEnvironmentProperty("Submit");
	public static String Resetpassword = putil.getEnvironmentProperty("Resetpassword");
	private static String Back = putil.getEnvironmentProperty("Back");
	private static String Telephone1 = putil.getEnvironmentProperty("Telephone1");
	
	
	public static String strPath = Modifymyprofile+":"+Submit+":"+Resetpassword+":"+Back+":"+Telephone1;
	
	public static WebElement Btn_Submit(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Submit));
	   	 
	   	 Log.info("Submit field Found");

	        return element;

	        }
	
	public static WebElement Resetpassword(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Resetpassword));
	   	 
	   	 Log.info("Reset password field Found");

	        return element;

	        }
	
	public static WebElement Back(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Back));
	   	 
	   	 Log.info("Back field Found");

	        return element;

	        }
	
	public static WebElement Telephone1(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Telephone1));
	   	 
	   	 Log.info("Telephone1 field Found");

	        return element;

	        }
	 
}