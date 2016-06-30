package page_object;

import org.openqa.selenium.WebDriver;

public class Base_Class {
	
	public static WebDriver driver;
	 
	public static boolean bResult;
 
	public  Base_Class(WebDriver driver){
 
		Base_Class.driver = driver;
 
		Base_Class.bResult = true;
 
	}


}
