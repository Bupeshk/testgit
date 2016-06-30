package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class User_Profile_Options_Page {
	
	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.USER_PROFILE_OPTIONS_FILEPATH);
	private static String lnk_Adduser = putil.getEnvironmentProperty("Add_User");
	private static String lnk_Searchuser = putil.getEnvironmentProperty("Search_User");
	private static String lnk_Modifymyprofile = putil.getEnvironmentProperty("Modify_My_Profile");
	
	public static String strPath = lnk_Adduser+":"+lnk_Searchuser+":"+lnk_Modifymyprofile;
	

	public static WebElement Lnk_Adduser(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(lnk_Adduser));
	   	 
	   	 Log.info("Add User Link Found");

	        return element;

	        }
	
	public static WebElement Lnk_Searchuser(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(lnk_Searchuser));
	   	 
	   	 Log.info("Search User Link Found");

	        return element;

	        }
	
	public static WebElement Lnk_Modifymyprofile(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(lnk_Modifymyprofile));
	   	 
	   	 Log.info("Modify my profile Link Found");

	        return element;

	        }

}
