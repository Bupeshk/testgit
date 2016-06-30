package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ManageSiteLayoutPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement BusinessGroup_list(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(lstMetaType_BusinessGroup));

		Log.info("Element found");

		return element;

	}


	public static WebElement ContentType_list(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(lstMetaType_ContentType));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement AddMetaType_btn(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(btnAddMetaType));
     
		Log.info("Element found");

		return element;

	}
	
	public static WebElement Edit_link(WebDriver driver,String obj)
	{ 
		
		object_path = lnkEditMetaType_starts+obj+lnkEditMetaType_ends;
		
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	
	
	


}
