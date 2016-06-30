package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ExcelUtils;
import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class Organization_Maintenance_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.ORGANISATION_MAINTENANCE_ADD_ADMIN_FILEPATH);
	private static String Code = putil.getEnvironmentProperty("Code");
	private static String Name = putil.getEnvironmentProperty("Name");
	private static String Description = putil.getEnvironmentProperty("Description");
	private static String Contact = putil.getEnvironmentProperty("Contact");
	public static String ContactEmail = putil.getEnvironmentProperty("ContactEmail");
	public static String Save = putil.getEnvironmentProperty("Save");
	
	private static String Code_value = ExcelUtils.getExcelData("Code", "OrganizationMaintenance");
	private static String Name_value = ExcelUtils.getExcelData("Name", "OrganizationMaintenance");
	private static String Description_value = ExcelUtils.getExcelData("Description", "OrganizationMaintenance");
	private static String Contact_value = ExcelUtils.getExcelData("Contact", "OrganizationMaintenance");
	private static String ContactEmail_value = ExcelUtils.getExcelData("ContactEmail", "OrganizationMaintenance");

	public static String strPath = Code+":"+Name+":"+Description+":"+Contact+":"+ContactEmail+":"+Save;
	public static String grpstrPath = Code+":"+Name+":"+Description+":"+Contact+":"+ContactEmail;
	public static String grpstrvalue = Code_value+":"+Name_value+":"+Description_value+":"+Contact_value+":"+ContactEmail_value;


	public static WebElement Code(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Code));
	   	 
	   	 Log.info("Code field Found");

	        return element;

	        }

	public static WebElement Name(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Name));
	   	 
	   	 Log.info("Name field Found");

	        return element;

	        }

	public static WebElement Description(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Description));
	   	 
	   	 Log.info("Description field Found");

	        return element;

	}
	public static WebElement Contact(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Contact));
	   	 
	   	 Log.info("Contact field Found");

	        return element;

	}
	public static WebElement ContactEmail(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(ContactEmail));
	   	 
	   	 Log.info("Contact Email field Found");

	        return element;

	}
	 
}