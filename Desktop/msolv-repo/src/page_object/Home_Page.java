package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.PropertyUtility;

public class Home_Page {
	
	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Constant.HOME_PAGE_FILEPATH);
	
	private static String Lookup = putil.getEnvironmentProperty("Look_Up");
	private static String CCRSearch = putil.getEnvironmentProperty("CCR_Search");
	private static String CalloutSearch = putil.getEnvironmentProperty("Callout_Search");
	public static String ExcessMaterialSearch = putil.getEnvironmentProperty("Excess_Material_Search");
	private static String TransferLookup = putil.getEnvironmentProperty("Transfer_lookup");
	public static String Callout = putil.getEnvironmentProperty("Callout");
	private static String Material_Disposition = putil.getEnvironmentProperty("Material_Disposition");
	private static String CreateMD = putil.getEnvironmentProperty("Create_MD");
	public static String MD_Search = putil.getEnvironmentProperty("MD_Search");
	
	public static String StrPath =  CCRSearch+":"+CalloutSearch+":"+ExcessMaterialSearch+":"+TransferLookup;
	public static String StrMDPath = Material_Disposition;
	
	
	
	public static WebElement LookUp(WebDriver driver){
		 
        element = driver.findElement(By.xpath(Lookup));
        	
        return element;

     }
	
	public static WebElement LookUp_CCRSearch(WebDriver driver){
		 
        element = driver.findElement(By.xpath(CCRSearch));
    
        return element;

     }
	
	public static WebElement Matetial_Disposition(WebDriver driver){
		 
        element = driver.findElement(By.xpath(Material_Disposition));
    
        return element;

     }
	
	public static WebElement EleCreateMD(WebDriver driver){
		 
        element = driver.findElement(By.xpath(CreateMD));
    
        return element;

     }
	
	 
}