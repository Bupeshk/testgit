package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class Home_Page {
	
	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.HOME_PAGE_FILEPATH);
	
	private static String Lookup = putil.getEnvironmentProperty("Look_Up");
	private static String CCRSearch = putil.getEnvironmentProperty("CCR_Search");
	private static String CalloutSearch = putil.getEnvironmentProperty("Callout_Search");
	private static String ExcessMaterialSearch = putil.getEnvironmentProperty("Excess_Material_Search");
	private static String TransferLookup = putil.getEnvironmentProperty("Transfer_lookup");

	public static String StrPath =  CCRSearch+":"+CalloutSearch+":"+ExcessMaterialSearch+":"+TransferLookup;

	public static WebElement LookUp(WebDriver driver){
		 
        element = driver.findElement(By.xpath(Lookup));
        	
        Log.info("Lookup tab found in home page");

        return element;

     }
	
	public static WebElement LookUp_CCRSearch(WebDriver driver){
		 
        element = driver.findElement(By.xpath(CCRSearch));
    
        return element;

     }
	
	public static WebElement Lnk_Profile(WebDriver driver){
		 
   	 element = driver.findElement(By.xpath("//*[@alt='Profile']"));
   	 
   	 Log.info("Profile Link Found");

        return element;

        }
	
	public static WebElement Lnk_Adduser(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath("//a[text()='Add User']"));
	   	 
	   	 Log.info("Add User Link Found");

	        return element;

	        }
	
	public static WebElement Lnk_Searchuser(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath("//a[text()='Search User']"));
	   	 
	   	 Log.info("Search User Link Found");

	        return element;

	        }
	
	public static WebElement Lnk_Modifymyprofile(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath("//*[contains(text(),'Modify my')]"));
	   	 
	   	 Log.info("Modify my profile Link Found");

	        return element;

	        }
	
	 
}