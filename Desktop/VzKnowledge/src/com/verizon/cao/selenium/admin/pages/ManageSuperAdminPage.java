package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ManageSuperAdminPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement btnSuperAdmin_AddUser(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnSuperAdmin_AddUser));

		Log.info("Element found");

		return element;

	}


	
	


}
