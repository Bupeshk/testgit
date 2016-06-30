package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class BrokenLinkReportPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement CreatedDateBetween(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtCreatedDate_Between));

		Log.info("Element found");

		return element;

	}

		
	public static WebElement CreatedDate_To(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtCreatedDate_To));

		Log.info("Element found");

		return element;

	}
	
	
}
