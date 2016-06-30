package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ExcelUtils;
import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class LMVRoutingMaintenance_Admin_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.LMV_ROUTING_MAINTENANCE_ADMIN_FILEPATH);
	private static String wmsType = putil.getEnvironmentProperty("wmsType");
	private static String logicalGroup = putil.getEnvironmentProperty("logicalGroup");
	private static String plantCode = putil.getEnvironmentProperty("plantCode");
	private static String wmsSystemId = putil.getEnvironmentProperty("wmsSystemId");
	public static String Submit = putil.getEnvironmentProperty("Submit");
	public static String Modify = putil.getEnvironmentProperty("Modify");
	private static String wmsWarehouseId = putil.getEnvironmentProperty("wmsWarehouseId");
	private static String wmsOwnerId = putil.getEnvironmentProperty("wmsOwnerId");
	private static String wmsPostMethod = putil.getEnvironmentProperty("wmsPostMethod");
	private static String wmsUpdateService = putil.getEnvironmentProperty("wmsUpdateService");
	private static String wmsCertificate = putil.getEnvironmentProperty("wmsCertificate");
	private static String wmsUrl = putil.getEnvironmentProperty("wmsUrl");
	private static String newLmvRoutingId = putil.getEnvironmentProperty("newLmvRoutingId");
	
	private static String wmsType_value = ExcelUtils.getExcelData("wmsType", "LMVRoutingMaintenance");
	private static String logicalGroup_value = ExcelUtils.getExcelData("logicalGroup", "LMVRoutingMaintenance");
	private static String plantCode_value = ExcelUtils.getExcelData("plantCode", "LMVRoutingMaintenance");
	private static String newLmvRoutingId_value = ExcelUtils.getExcelData("newLmvRoutingId", "LMVRoutingMaintenance");
	private static String wmsSystemId_value = ExcelUtils.getExcelData("wmsSystemId", "LMVRoutingMaintenance");
	private static String wmsWarehouseId_value = ExcelUtils.getExcelData("wmsWarehouseId", "LMVRoutingMaintenance");
	private static String wmsOwnerId_value = ExcelUtils.getExcelData("wmsOwnerId", "LMVRoutingMaintenance");
	private static String wmsPostMethod_value = ExcelUtils.getExcelData("wmsPostMethod", "LMVRoutingMaintenance");
	private static String wmsUpdateService_value = ExcelUtils.getExcelData("wmsUpdateService", "LMVRoutingMaintenance");
	private static String wmsCertificate_value = ExcelUtils.getExcelData("wmsCertificate", "LMVRoutingMaintenance");
	private static String wmsUrl_value = ExcelUtils.getExcelData("wmsUrl", "LMVRoutingMaintenance");

	public static String strPath = wmsType+":"+logicalGroup+":"+plantCode+":"+wmsSystemId+":"+Submit+":"+wmsWarehouseId+":"+wmsOwnerId+":"+wmsPostMethod+":"+wmsUpdateService+":"+wmsCertificate+":"+wmsUrl+":"+newLmvRoutingId+":"+Modify;
	public static String grpstrPath = wmsType+":"+logicalGroup+":"+plantCode+":"+wmsSystemId+":"+wmsWarehouseId+":"+wmsOwnerId+":"+wmsPostMethod+":"+wmsUpdateService+":"+wmsCertificate+":"+wmsUrl+":"+newLmvRoutingId;
	public static String grpstrvalue = wmsType_value+":"+logicalGroup_value+":"+plantCode_value+":"+wmsSystemId_value+":"+wmsWarehouseId_value+":"+wmsOwnerId_value+":"+wmsPostMethod_value+":"+wmsUpdateService_value+":"+wmsCertificate_value+":"+wmsUrl_value+":"+newLmvRoutingId_value;
	
	public static WebElement wmsType(WebDriver driver){
		 
   	 element = driver.findElement(By.xpath(wmsType));
   	 
   	 Log.info("wms Type Field Found");

        return element;

        }

	public static WebElement logicalGroup(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(logicalGroup));
	   	 
	   	 Log.info("logical Group Field Found");

	        return element;

	        }
	
	public static WebElement plantCode(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(plantCode));
	   	 
	   	 Log.info("plantCode Field Found");

	        return element;

	        }
	public static WebElement wmsSystemId(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(wmsSystemId));
	   	 
	   	 Log.info("wms System Id Found");

	        return element;

	        }

	public static WebElement wmsWarehouseId(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(wmsWarehouseId));
	   	 
	   	 Log.info("wms Warehouse Id Field Found");

	        return element;

	        }
	public static WebElement wmsOwnerId(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(wmsOwnerId));
	   	 
	   	 Log.info("wms Owner Id Field Found");

	        return element;

	        }
	public static WebElement wmsPostMethod(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(wmsPostMethod));
	   	 
	   	 Log.info("wms Post Method Field Found");

	        return element;

	        }
	public static WebElement wmsUpdateService(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(wmsUpdateService));
	   	 
	   	 Log.info("wms Update Service Field Found");

	        return element;

	        }
	public static WebElement wmsCertificate(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(wmsCertificate));
	   	 
	   	 Log.info("wms Certificate Field Found");

	        return element;

	        }
	public static WebElement wmsUrl(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(wmsUrl));
	   	 
	   	 Log.info("wms Url Field Found");

	        return element;

	        }
	public static WebElement newLmvRoutingId(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(newLmvRoutingId));
	   	 
	   	 Log.info("new Lmv Routing Id Field Found");

	        return element;

	        }
	 
	 
}