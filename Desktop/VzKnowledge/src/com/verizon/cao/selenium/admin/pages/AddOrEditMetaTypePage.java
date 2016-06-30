package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class AddOrEditMetaTypePage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement MetaTypeName_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtMetaTypeName));

		Log.info("Element found");

		return element;

	}


	public static WebElement MetaTypeDescription_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtMetaTypeDesc));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement IsHierarchical_list(WebDriver driver,String obj)
	{ 
		object_path =lstIsHierarchical_Options_starts+obj+lstIsHierarchical_Options_ends;
		
		element = driver.findElement(By.xpath(object_path));
     
		Log.info("Element found");

		return element;

	}
	
	public static WebElement HasProfile_list(WebDriver driver,String obj)
	{ 
		
		object_path = lstHasProfile_Options_starts+obj+lstHasProfile_Options_ends;
		
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	public static WebElement CanSubscribe_list(WebDriver driver,String obj)
	{ 
		
		object_path = lstCanSubscribe_Options_starts+obj+lstCanSubscribe_Options_ends;
		
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement AddMetaType_btn(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(btnAddMetaType_Edit));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement UpdateMetaType_btn(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(btnUpdateMetaType));

		Log.info("Element found");

		return element;

	}
	public static WebElement CancelMetaType_btn(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(btnCancelMetaType));

		Log.info("Element found");

		return element;

	}
	
	
	


}
