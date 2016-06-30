package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ManagePropertiesPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement btnProperty(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnAddProperty));

		Log.info("Element found");

		return element;

	}


	public static WebElement PropertyName_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtPropertyName));

		Log.info("Element found");

		return element;

	}
	public static WebElement PropertyValue_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtPropertyValue));

		Log.info("Element found");

		return element;

	}
	public static WebElement PropertyDesc_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtPropertyDesc));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement btnAddProperty_ManageProperties(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnAddProperty_ManageProperties));

		Log.info("Element found");

		return element;

	}

}
