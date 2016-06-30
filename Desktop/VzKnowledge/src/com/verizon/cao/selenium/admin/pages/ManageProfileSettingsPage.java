package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.ObjectRepository.Admin;

import com.verizon.cao.selenium.common.Log;

public class ManageProfileSettingsPage implements Admin{
	private static WebElement element = null;
	static String object_path = null;
	  private WebDriver driver;
	  
	public ManageProfileSettingsPage(WebDriver driver) {
	    this.driver = driver;
	  }
	
	public static WebElement btnAddNewProfileSettings(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnAddNewProfileSettings));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement lstProfileSettings_GlossaryCategory(WebDriver driver,String obj)
	{
		object_path = lstProfileSettings_GlossaryCategory_starts+obj+lstProfileSettings_GlossaryCategory_ends;
			
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	

	
	public static WebElement btnUpdateGlossaryCategory(WebDriver driver)
	{
		 
		element = driver.findElement(By.xpath(btnUpdateGlossaryCategory));
		
		Log.info("Element found");

		return element;

	}
	public static WebElement lnkContentType_ProfileSettings(WebDriver driver,String obj)
	{
		object_path = lnkContentType_ProfileSettings_starts+obj+lnkContentType_ProfileSettings_ends;
			
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement btnWorkFlowEdit(WebDriver driver)
	{
		
		
		element = driver.findElement(By.xpath(btnWorkFlowEdit));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement chkContentWorkFlow(WebDriver driver,String obj)
	{
		object_path = chkContentWorkFlow_starts+obj+chkContentWorkFlow_ends;
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");
		
		return element;

	}
	
	
	
	public static WebElement lstContentDefaultWorkFlow(WebDriver driver)
	{
		
			
		element = driver.findElement(By.xpath(lstContentDefaultWorkFlow));
		
		Log.info("Element found");

		return element;

	}
	
	
		public static WebElement btnUpdateReviewDate_WorkFlow(WebDriver driver)
	{
		
			
		element = driver.findElement(By.xpath(btnUpdateReviewDate_WorkFlow));
		
		Log.info("Element found");

		return element;

	}
		public static WebElement chkSecondaryAuthors(WebDriver driver)
		{
			
				
			element = driver.findElement(By.xpath(chkSecondaryAuthors));
			
			Log.info("Element found");

			return element;

		}
		
		public static WebElement lstUserGroups(WebDriver driver)
		{
			
				
			element = driver.findElement(By.xpath(lstUserGroups));
			
			Log.info("Element found");

			return element;

		}
		
		public static WebElement lstSelUserGroups(WebDriver driver)
		{
			
				
			element = driver.findElement(By.xpath(lstSelUserGroups));
			
			Log.info("Element found");

			return element;

		}
		public static WebElement btnUserGroups_Add(WebDriver driver)
		{
			
				
			element = driver.findElement(By.xpath(btnUserGroups_Add));
			
			Log.info("Element found");

			return element;

		}
		public static WebElement btnUserGroups_AddAll(WebDriver driver)
		{
			
				
			element = driver.findElement(By.xpath(btnUserGroups_AddAll));
			
			Log.info("Element found");

			return element;

		}
		public static WebElement btnUserGroups_Remove(WebDriver driver)
		{
			
				
			element = driver.findElement(By.xpath(btnUserGroups_Remove));
			
			Log.info("Element found");

			return element;

		}
		public static WebElement btnUserGroups_RemoveAll(WebDriver driver)
		{
			
				
			element = driver.findElement(By.xpath(btnUserGroups_RemoveAll));
			
			Log.info("Element found");

			return element;

		}
		
		public static WebElement btnUpdateFeedBackRecipients(WebDriver driver)
		{
			
				
			element = driver.findElement(By.xpath(btnUpdateFeedBackRecipients));
			
			Log.info("Element found");

			return element;

		}
		
		
	
	
	

}
