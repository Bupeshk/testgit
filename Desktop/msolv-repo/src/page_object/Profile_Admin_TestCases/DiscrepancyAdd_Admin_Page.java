package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ExcelUtils;
import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class DiscrepancyAdd_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.DISCREPANCY_ADD_ADMIN_FILEPATH);
	private static String DiscrepancyFailCodeName = putil.getEnvironmentProperty("DiscrepancyFailCodeName");
	public static String Save = putil.getEnvironmentProperty("Save");
	public static String DiscrepancyFailCode = putil.getEnvironmentProperty("DiscrepancyFailCode");
	private static String DiscrepancyFailCode_value = ExcelUtils.getExcelData("DiscrepancyFailCode", "DiscrepancyMaintenance");
	private static String DiscrepancyFailCodeName_value = ExcelUtils.getExcelData("DiscrepancyFailCodeName", "DiscrepancyMaintenance");

	public static String strPath = Save+":"+DiscrepancyFailCode+":"+DiscrepancyFailCodeName;
	public static String grpstrPath = DiscrepancyFailCode+":"+DiscrepancyFailCodeName;
	public static String grpstrvalue = DiscrepancyFailCode_value+":"+DiscrepancyFailCodeName_value;



	public static WebElement DiscrepancyFailCode(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(DiscrepancyFailCode));
	   	 
	   	 Log.info("Discrepancy Fail Code field Found");

	        return element;

	        }

	public static WebElement DiscrepancyFailCodeName(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(DiscrepancyFailCodeName));
	   	 
	   	 Log.info("Discrepancy Fail Code Name field Found");

	        return element;

	}
	 
}