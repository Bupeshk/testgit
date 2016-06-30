package application_modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;
public class IsDisplayed_Action {
	
	public static void Execute(WebDriver driver, WebElement DISPElement) throws Exception{  
	    
	    if(DISPElement.isDisplayed())     
	    {      
	      Log.info(DISPElement.getText()+ "is Displayed");    
	    }    
	}              
}

