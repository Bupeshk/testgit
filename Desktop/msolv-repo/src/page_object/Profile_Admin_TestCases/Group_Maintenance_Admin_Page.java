package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ExcelUtils;
import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class Group_Maintenance_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.GROUP_MAINTENANCE_ADD_ADMIN_FILEPATH);
	public static String OrganizationCode = putil.getEnvironmentProperty("OrganizationCode");
	private static String GroupCode = putil.getEnvironmentProperty("GroupCode");
	private static String Name = putil.getEnvironmentProperty("Name");
	private static String Description = putil.getEnvironmentProperty("Description");
	private static String Contact = putil.getEnvironmentProperty("Contact");
	public static String ContactEmail = putil.getEnvironmentProperty("ContactEmail");
	public static String Save = putil.getEnvironmentProperty("Save");
	
	public static String GroupCode_value = ExcelUtils.getExcelData("GroupCode", "GroupMaintenance");
	public static String Name_value = ExcelUtils.getExcelData("Name", "GroupMaintenance");
	public static String Description_value = ExcelUtils.getExcelData("Description", "GroupMaintenance");
	public static String Contact_value = ExcelUtils.getExcelData("Contact", "GroupMaintenance");
	public static String ContactEmail_value = ExcelUtils.getExcelData("ContactEmail", "GroupMaintenance");
	public static String OrganizationCode_value = ExcelUtils.getExcelData("OrganizationCode", "GroupMaintenance");

	public static String strPath = OrganizationCode+":"+GroupCode+":"+Name+":"+Description+":"+Contact+":"+ContactEmail+":"+Save;
	public static String grpstrPath = GroupCode+":"+Name+":"+Description+":"+Contact+":"+ContactEmail;
	public static String grpstrvalue = GroupCode_value+":"+Name_value+":"+Description_value+":"+Contact_value+":"+ContactEmail_value;
	
	public static WebElement OrganizationCode(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(OrganizationCode));
	   	 
	   	 Log.info("Organization Code field Found");

	        return element;

	        }
	
	public static WebElement GroupCode(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(GroupCode));
	   	 
	   	 Log.info("Group Code field Found");

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