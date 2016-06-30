package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ReportsPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement OtherReports_btn(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnOtherReports));

		Log.info("Element found");

		return element;

	}

	
	public static WebElement ReportTabs(WebDriver driver,String strElement)
	{ 
		object_path = lnkTabs_starts+strElement+lnkTabs_ends;
		
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement MoreReportTabs(WebDriver driver,String strElement)
	{ 
		object_path = lnkMoreTabs_starts+strElement+lnkMoreTabs_ends;
		
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement Export_Link(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(lnkExport));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement Print_Link(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(lnkPrint));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement Refresh_Link(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(lnkRefresh));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement Excel_Link(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(lnkExcel));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement ExcelMenuItem_Link(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(lnkExcelMenuItem));

		Log.info("Element found");

		return element;

	}
	public static WebElement ClickAtWorkspace(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(ClickAtWorkspace));

		Log.info("Element found");

		return element;

	}
	

	
	


}
