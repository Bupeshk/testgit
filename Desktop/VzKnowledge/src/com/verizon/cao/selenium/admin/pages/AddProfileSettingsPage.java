package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.ObjectRepository.Admin;

import com.verizon.cao.selenium.common.Log;

public class AddProfileSettingsPage implements Admin{
	private static WebElement element = null;
	static String object_path = null;
	  private WebDriver driver;
	  
	public AddProfileSettingsPage(WebDriver driver) {
	    this.driver = driver;
	  }
	
	public static WebElement txtProfileSettingsName(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtProfileSettingsName));
		
		Log.info("Element found");

		return element;

	}
	
	
	

	
	public static WebElement txtProfileSettingsDisplayName(WebDriver driver)
	{
		 
		element = driver.findElement(By.xpath(txtProfileSettingsDisplayName));
		
		Log.info("Element found");

		return element;

	}
	
	
	public static WebElement lstIsDropDown(WebDriver driver)
	{
		
		
		element = driver.findElement(By.xpath(lstIsDropDown));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement optValue(WebDriver driver,String obj)
	{
		object_path = optValue_starts+obj+optValue_ends;
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");
		
		return element;

	}
	
	
	
	public static WebElement btnAddProfileSetting(WebDriver driver)
	{
		
			
		element = driver.findElement(By.xpath(btnAddProfileSetting));
		
		Log.info("Element found");

		return element;

	}
	public static WebElement txtValue(WebDriver driver)
	{
		
			
		element = driver.findElement(By.xpath(txtValue));
		
		Log.info("Element found");

		return element;

	}
	
	
	
}
