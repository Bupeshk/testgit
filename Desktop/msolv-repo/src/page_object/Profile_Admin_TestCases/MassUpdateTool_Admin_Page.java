package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class MassUpdateTool_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.MASS_UPDATE_TOOL_ADMIN_FILEPATH);
	private static String Selectoption = putil.getEnvironmentProperty("Selectoption");
	private static String Browse = putil.getEnvironmentProperty("Browse");
	private static String Upload = putil.getEnvironmentProperty("Upload");

	public static String strPath = Selectoption+":"+Browse+":"+Upload;
	
	public static WebElement Selectoption(WebDriver driver){
		 
   	 element = driver.findElement(By.xpath(Selectoption));
   	 
   	 Log.info("Select option Field Found");

        return element;

        }
	
	public static WebElement Browse(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Browse));
	   	 
	   	 Log.info("Browse Field Found");

	        return element;

	        }
	
	public static WebElement Upload(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Upload));
	   	 
	   	 Log.info("Upload Field Found");

	        return element;

	        }
	
	 
	 
}