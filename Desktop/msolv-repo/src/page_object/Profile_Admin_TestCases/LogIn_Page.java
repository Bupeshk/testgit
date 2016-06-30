package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;


public class LogIn_Page {
	
	 private static WebElement element = null;
	
	 
	 public static WebElement UserName(WebDriver driver){
		 
         element = driver.findElement(By.xpath("//*[@name='USERID']"));
         	
         Log.info("Username text box found");
 
         return element;
 
         }
 
     public static WebElement Password(WebDriver driver){
 
    	 element = driver.findElement(By.xpath("//*[@name='PASSWORD']"));
    	 
    	 Log.info("Password text box found");
 
         return element;
 
         }
 
     public static WebElement btn_LogIn(WebDriver driver){
 
    	 element = driver.findElement(By.xpath("//*[@alt='Submit the form']"));
    	 
    	 Log.info("Submit button found");
 
         return element;
 
         }
 
}

