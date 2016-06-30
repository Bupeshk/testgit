package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.ObjectRepository.Admin;

import com.verizon.cao.selenium.common.Log;

public class ManagePresetRolesPage implements Admin{
	private static WebElement element = null;
	static String object_path = null;
	  private WebDriver driver;
	  
	public ManagePresetRolesPage(WebDriver driver) {
	    this.driver = driver;
	  }
	
	public static WebElement btnAddPresetRole(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnAddPresetRole));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement txtPresetRoleName(WebDriver driver)
	{
		 
		element = driver.findElement(By.xpath(txtPresetRoleName));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement txtPresetRoleDescription(WebDriver driver)
	{
		
		
		element = driver.findElement(By.xpath(txtPresetRoleDescription));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement lnkMetaDataRole(WebDriver driver)
	{
		
		element = driver.findElement(By.xpath(lnkMetaDataRole));

		Log.info("Element found");
		
		return element;

	}
	
	
	
	public static WebElement lnkMetaDataRegion(WebDriver driver)
	{
		
			
		element = driver.findElement(By.xpath(lnkMetaDataRegion));
		
		Log.info("Element found");

		return element;

	}
	
	
	public static WebElement chkMetaData_Role_Region(WebDriver driver,String obj)
	{
		object_path = chkMetaData_Role_Region_starts+obj+chkMetaData_Role_Region_ends;
			
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	public static WebElement btnAddPresetRole_Edit(WebDriver driver)
	{
		
			
		element = driver.findElement(By.xpath(btnAddPresetRole_Edit));
		
		Log.info("Element found");

		return element;

	}
	
	
	
	

}
