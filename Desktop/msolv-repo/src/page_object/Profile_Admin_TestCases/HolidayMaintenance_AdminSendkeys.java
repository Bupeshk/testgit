package page_object.Profile_Admin_TestCases;

import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import page_object.Profile_Admin_TestCases.HolidayMaintenance_Admin_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HolidayMaintenance_AdminSendkeys {

	public static void Execute(WebDriver driver) throws Exception {
		String description = ExcelUtils.getExcelData("description", "HolidayMaintenance");
		
		String winHandleBefore = driver.getWindowHandle();
		HolidayMaintenance_Admin_Page.datepicker(driver).click();

		for(String winHandle : driver.getWindowHandles()){
	  	    driver.switchTo().window(winHandle);
	  	  }
		
	  	String date = ExcelUtils.getExcelData("date", "HolidayMaintenance");
	      WebElement Dayelement = driver.findElement(By.xpath("//*[@href='javascript:returnDate("+date+")']"));
	      Dayelement.click();
	      Log.info(Dayelement + "Clicked Successfully.");
	      
	      driver.switchTo().window(winHandleBefore); 
	      
		HolidayMaintenance_Admin_Page.RegionEast(driver).click();
		HolidayMaintenance_Admin_Page.description(driver).sendKeys(description);
		HolidayMaintenance_Admin_Page.Save(driver).click();
		Utils.sleep(2000);
		HolidayMaintenance_Admin_Page.SelectAll(driver).click();
		HolidayMaintenance_Admin_Page.Delete(driver).click();
		
	}

	
}
