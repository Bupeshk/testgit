package application_modules;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Log;



public class MouseHover_Action {
	
	public static void Execute(WebDriver driver, WebElement element ) throws Exception{
		
		try{
		
		//WebElement element = Home_Page.LookUp(driver);
		
		Actions action = new Actions(driver);

	    //action.moveToElement(element).build().perform();
	  
        action.moveToElement(element).perform();
 
 
        action.click();
 
        action.perform();

		}catch (Exception e){
			
			 Log.error(e.getMessage());
   		 throw (e);
			
		}
	    
	    
	}

}
