package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.PropertyUtility;

public class CCR_TEO_PO_Search_Page {
	
	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Constant.CCR_SEARCH_PAGE_FILEPATH);

	public static String WONumber = putil.getEnvironmentProperty("WO_Number");
	public static String TEONumber = putil.getEnvironmentProperty("TEO_Number");
	public static String PONumber = putil.getEnvironmentProperty("PO_Number");
	public static String SubmitBtn = putil.getEnvironmentProperty("Submit_Btn");
	public static String CartBtn = putil.getEnvironmentProperty("Cart_Btn");
	public static String CCRLink = putil.getEnvironmentProperty("CCR_Link");
	public static String MDBtn = putil.getEnvironmentProperty("MD_Btn");
	
	
	public static String StrCCRPath =  WONumber+":"+TEONumber+":"+PONumber;
	
	 public static WebElement WO_Number(WebDriver driver){
		 
       element = driver.findElement(By.xpath(WONumber));
       	
       return element;

       }
	 
	 public static WebElement TEO_Number(WebDriver driver){
		 
	       element = driver.findElement(By.xpath(TEONumber));
	      
	       return element;

	       }
	 
	 public static WebElement PO_Number(WebDriver driver){
		 
	       element = driver.findElement(By.xpath(PONumber));

	       return element;

	       }
	 

}
