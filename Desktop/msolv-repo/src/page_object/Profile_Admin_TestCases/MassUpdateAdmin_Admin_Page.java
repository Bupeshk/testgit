package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ExcelUtils;
import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class MassUpdateAdmin_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.MASS_UPDATE_ADMIN_FILEPATH);
	public static String Back = putil.getEnvironmentProperty("Back");
	public static String Modify = putil.getEnvironmentProperty("Modify");
	public static String Delete = putil.getEnvironmentProperty("Delete");
	public static String Add = putil.getEnvironmentProperty("Add");
	public static String Submit = putil.getEnvironmentProperty("Submit");
	private static String uploadType = putil.getEnvironmentProperty("uploadType");
	private static String fileName = putil.getEnvironmentProperty("fileName");
	private static String desc = putil.getEnvironmentProperty("desc");
	
	private static String uploadType_value = ExcelUtils.getExcelData("uploadType", "MassUpdateAdmin");
	private static String fileName_value = ExcelUtils.getExcelData("fileName", "MassUpdateAdmin");
	private static String desc_value = ExcelUtils.getExcelData("desc", "MassUpdateAdmin");
	
	public static String strPath = Back+":"+Modify+":"+Delete+":"+Add+":"+Submit+":"+uploadType+":"+fileName+":"+desc;
	public static String grpstrPath = uploadType+":"+fileName+":"+desc;
	public static String grpstrvalue = uploadType_value+":"+fileName_value+":"+desc_value;

	public static WebElement Back(WebDriver driver){
		 
   	 element = driver.findElement(By.xpath(Back));
   	 
   	 Log.info("Back Field Found");

        return element;

        }
	
	public static WebElement Modify(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Modify));
	   	 
	   	 Log.info("Modify Field Found");

	        return element;

	        }
	
	public static WebElement Delete(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Delete));
	   	 
	   	 Log.info("Delete Field Found");

	        return element;

	        }
	public static WebElement Add(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Add));
	   	 
	   	 Log.info("Add Field Found");

	        return element;

	        }

	public static WebElement uploadType(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(uploadType));
	   	 
	   	 Log.info("upload Type Field Found");

	        return element;

	        }
	public static WebElement fileName(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(fileName));
	   	 
	   	 Log.info("fileName Field Found");

	        return element;

	        }
	public static WebElement desc(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(desc));
	   	 
	   	 Log.info("desc Field Found");

	        return element;

	        }
	
	 
	 
}