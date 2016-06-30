package application_modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utility.Log;

public class Click_Action {
	
	public static boolean Execute(WebDriver driver, String strElement) throws Exception{
		
			WebElement element = driver.findElement(By.xpath(strElement));
			element.click();
			Log.info(element + "Clicked Successfully.");
			return true;
		
	}

}
