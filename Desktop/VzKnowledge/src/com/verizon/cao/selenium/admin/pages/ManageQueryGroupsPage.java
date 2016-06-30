package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ManageQueryGroupsPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement btnManageQueryGroup(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnManageQueryGroup));

		Log.info("Element found");

		return element;

	}
	public static WebElement QueryGroupName_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtQueryGroup_Name));

		Log.info("Element found");

		return element;

	}
	public static WebElement QueryGroupDesc_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtQueryGroup_Desc));

		Log.info("Element found");

		return element;

	}
	public static WebElement QueryGroupQuery_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtQueryGroup_Query));

		Log.info("Element found");

		return element;

	}
	public static WebElement AddQueryGroup_btn(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnAddQueryGroup));

		Log.info("Element found");

		return element;

	}


	
	


}
