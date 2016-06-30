package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class FeedBackReportsGeneralPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement CategoryName_chk(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(chkBusinessGroups));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement FeedBackType_chk(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(chkReportRole));

		Log.info("Element found");

		return element;

	}
	public static WebElement FeedBackStatus_chk(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(chkContentStatus));

		Log.info("Element found");

		return element;

	}
	
	

	
	


}
