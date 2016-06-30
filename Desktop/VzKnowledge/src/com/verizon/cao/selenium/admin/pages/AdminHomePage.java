package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.ObjectRepository.Admin;

import com.verizon.cao.selenium.common.Log;

public class AdminHomePage implements Admin{
	private static WebElement element = null;
	static String object_path = null;
	  private WebDriver driver;
	  
	public AdminHomePage(WebDriver driver) {
	    this.driver = driver;
	  }
	
	public static WebElement Global_NavLinks(WebDriver driver,String obj)
	{ 
		
		object_path = lnkGlobalNav_starts+obj+lnkGlobalNav_ends;
		System.out.println("object_path" +object_path);
		element = driver.findElement(By.xpath(object_path));
		System.out.println("element   " +element);
		Log.info("Element found");

		return element;

	}
	
	public static WebElement Left_NavLinks(WebDriver driver,String obj)
	{
		 
		object_path = lnkLeftNav_starts+obj+lnkLeftNav_ends;

		element = driver.findElement(By.xpath(object_path));

		return element;

	}
	
	public static WebElement UserName_Link(WebDriver driver)
	{
		
		object_path = lnkUserName_starts+"Meenakshi"+lnkUserName_ends;
		System.out.println(object_path + "%%%%%%%%%%%%");
		element = driver.findElement(By.xpath(object_path));

		return element;

	}
	
	public static WebElement BusinessGroup_DropDown(WebDriver driver)
	{
		
		element = driver.findElement(By.xpath(lstBusinessGroup));

		return element;

	}
	
	
	
	public static WebElement BusinessGroup_ListItems(WebDriver driver,String obj)
	{
		
		object_path = lstBusinessGroup_item_starts+obj+lstBusinessGroup_item_ends;
		
		element = driver.findElement(By.xpath(object_path));

		return element;

	}
	
	
	

}
