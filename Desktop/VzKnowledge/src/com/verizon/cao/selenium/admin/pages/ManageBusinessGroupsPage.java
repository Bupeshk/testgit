package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.ObjectRepository.Admin;

import com.verizon.cao.selenium.common.Log;

public class ManageBusinessGroupsPage implements Admin{
	private static WebElement element = null;
	static String object_path = null;
	  private WebDriver driver;
	  
	public ManageBusinessGroupsPage(WebDriver driver) {
	    this.driver = driver;
	  }
	
	public static WebElement AddNewBusinessGroup_Btn(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnAddNew_Business_Groups));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement DisplayName_txt(WebDriver driver,String obj)
	{
		 
		element = driver.findElement(By.xpath(txtDisplayName));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement Discription_txt(WebDriver driver)
	{
		
		
		element = driver.findElement(By.xpath(txtDiscription));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement BusinessStatus_dropdown(WebDriver driver)
	{
		
		element = driver.findElement(By.xpath(lstBusiness_Status));

		Log.info("Element found");
		
		return element;

	}
	
	
	
	public static WebElement AllowExternal_chk(WebDriver driver,String obj)
	{
		
			
		element = driver.findElement(By.xpath(chkAllowExternal));
		
		Log.info("Element found");

		return element;

	}
	
	
	public static WebElement BusinessGroupInfo_btn(WebDriver driver,String obj)
	{
		object_path = btnMetaDataAdd_starts+obj+btnMetaDataAdd_ends;
			
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	
	
	

}
