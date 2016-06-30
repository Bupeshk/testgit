package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.PropertyUtility;

public class Excess_Material_Search_page {


	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Constant.EXCESS_MATERIAL_SEARCH_PAGE_FILEPATH);
	
	public static String ScreenOption = putil.getEnvironmentProperty("Screen_Option");
	public static String ExcelOption = putil.getEnvironmentProperty("Excel_Option");
	public static String TextOption = putil.getEnvironmentProperty("Text_Option");
	public static String Submit_Btn = putil.getEnvironmentProperty("Submit_Btn");
	public static String LookUpMenu = putil.getEnvironmentProperty("LookUp_Menu");
	
	
	public static WebElement ExcessLookUp(WebDriver driver){
		 
        element = driver.findElement(By.xpath(LookUpMenu));
        	
        return element;

     }
}
