package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.ObjectRepository.Admin;

import com.verizon.cao.selenium.common.Log;

public class ManageDefaultSubscriptionPage implements Admin{
	private static WebElement element = null;
	static String object_path = null;
	  private WebDriver driver;
	  
	public ManageDefaultSubscriptionPage(WebDriver driver) {
	    this.driver = driver;
	  }
	
	public static WebElement Role_RegionTreeView_chkBoxes(WebDriver driver,String obj)
	{ 
		object_path = chkRole_Region_starts+obj+chkRole_Region_ends;
		
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement SaveSubscriptions_btn(WebDriver driver)
	{
		 
		element = driver.findElement(By.xpath(btnSaveSubscriptions));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement Role_Region_btn(WebDriver driver,String obj)
	{
		object_path = lnkRole_Region_starts+obj+lnkRole_Region_ends; 
		
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement DefaultSubscription_Role_List(WebDriver driver)
	{
		
		
		element = driver.findElement(By.xpath(lblDefault_Sub_Role));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement DefaultSubscription_Region_List(WebDriver driver)
	{
		
		
		element = driver.findElement(By.xpath(lblDefault_Sub_Region));
		
		Log.info("Element found");

		return element;

	}
	}
