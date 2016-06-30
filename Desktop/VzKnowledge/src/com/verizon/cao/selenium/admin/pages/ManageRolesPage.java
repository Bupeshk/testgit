package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ManageRolesPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement Add_btn(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnManageRoles_Add));

		Log.info("Element found");

		return element;

	}


	public static WebElement Edit_btn(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnManageRoles_Edit));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement AddChild_btn(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(btnManageRoles_AddChild));
     
		Log.info("Element found");

		return element;

	}
	public static WebElement AddRole(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(btnAddRole));
     
		Log.info("Element found");

		return element;

	}
	
	
	
	
	


}
