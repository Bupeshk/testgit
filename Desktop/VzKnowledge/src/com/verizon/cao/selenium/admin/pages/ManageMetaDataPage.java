package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ManageMetaDataPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement ContentType(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(lstContentType));

		Log.info("Element found");

		return element;

	}


	public static WebElement MetaType(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(lstContentType));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement ManageMetaData_Buttons(WebDriver driver,String obj)
	{ 
		
		object_path = btnMetaDataActions_starts+obj+btnMetaDataActions_ends;
		
		element = driver.findElement(By.xpath(object_path));
     
		Log.info("Element found");

		return element;

	}
	
	public static WebElement MetaData_RadioBtn(WebDriver driver,String obj)
	{ 
		
		object_path = radioInformation_starts+obj+radioInformation_ends;
		
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	
	
	


}
