package application_modules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class MouseHoverIE {
	public static void Execute(WebDriver driver,WebElement a,WebElement b) throws Exception{
	 try 
	     {
	         String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
	         ((JavascriptExecutor) driver).executeScript(mouseOverScript,a);
	         Thread.sleep(2000);
	         ((JavascriptExecutor) driver).executeScript(mouseOverScript,b);
	         Thread.sleep(2000);
	         Log.info("Lookup mouse hover performed");
	      
	         //String StrPath = Home_Page.StrPath;
	         //Log.info("Combined xPath is: "+StrPath);
	   		 //Object_Exist_Loop_Action.Execute(StrPath);
	         
	         ((JavascriptExecutor) driver).executeScript("arguments[0].click();",b);
	         Log.info(b+"Clicked");

	    } catch (Exception e) {
	    	 Log.error(e.getMessage());
    		 throw (e);
	    }
	} 

}
