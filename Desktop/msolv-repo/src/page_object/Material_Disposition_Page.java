package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.PropertyUtility;

public class Material_Disposition_Page {
	
	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Constant.MATERIAL_DISPOSITION_FILEPATH);
	
	private static String CCRWONumber = putil.getEnvironmentProperty("CCR_WO_Number");
	private static String PONumber = putil.getEnvironmentProperty("PO_Number");
	public static String SubmitBtn = putil.getEnvironmentProperty("Submit_btn");
	
	public static String StrPath =  CCRWONumber+":"+PONumber;
	
	
	
	public static WebElement CCRWONumber(WebDriver driver){
		 
        element = driver.findElement(By.xpath(CCRWONumber));
        	
        return element;

     }
	

}
