package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ManageUserGroupsPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement btnAddUserGroups(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnAddUserGroups));

		Log.info("Element found");

		return element;

	}


	public static WebElement txtSearchUser(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtSearchUser));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement btnSearchUser(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(btnSearchUser));
     
		Log.info("Element found");

		return element;

	}
	
	public static WebElement Ok_button(WebDriver driver,String obj)
	{ 
			
		element = driver.findElement(By.xpath(btnGo));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement makeActive_InActive_link(WebDriver driver,String groupName,String actionLink )
	{ 
		object_path = lnkActions_starts+groupName+lnkActions_middle+actionLink+lnkActions_ends;
		
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	
	
	


}
