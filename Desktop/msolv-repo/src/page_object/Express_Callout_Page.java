package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Constant;
import utility.PropertyUtility;

public class Express_Callout_Page {
	
	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Constant.EXPRESS_CALLOUT_FILEPATH);
	
	private static String WONumber = putil.getEnvironmentProperty("CCR_Number");
	private static String TEONumber = putil.getEnvironmentProperty("TEO_Number");
	private static String ResetBtn = putil.getEnvironmentProperty("Reset_btn");
	public static String SubmitBtn = putil.getEnvironmentProperty("Submit_btn");
	public static String PageTitle = putil.getEnvironmentProperty("Page_Title");
	
	public static String StrPath =  WONumber+":"+TEONumber+":"+ResetBtn+":"+SubmitBtn;
	
	public static WebElement WONumber(WebDriver driver){
		 
        element = driver.findElement(By.xpath(WONumber));
      
        return element;

        }
	
	public static WebElement PageTitle(WebDriver driver){
		 
        element = driver.findElement(By.xpath(PageTitle));
      
        return element;

     }
	

	
}
