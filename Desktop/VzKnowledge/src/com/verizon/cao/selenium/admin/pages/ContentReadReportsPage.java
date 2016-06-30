package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ContentReadReportsPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement BusinessGroups_chk(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(chkBusinessGroups));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement ReportRole_chk(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(chkReportRole));

		Log.info("Element found");

		return element;

	}
	public static WebElement ContentStatus_chk(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(chkContentStatus));

		Log.info("Element found");

		return element;

	}
	public static WebElement ContentType_chk(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(chkReportsContentType));

		Log.info("Element found");

		return element;

	}
	public static WebElement IsVLSS_chk(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(chkIsVLSS));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement Apply_btn(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnApply));

		Log.info("Element found");

		return element;

	}


	public static WebElement ReadDateBetween(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtReadDate_Between));

		Log.info("Element found");

		return element;

	}

	public static WebElement lblReadDate_To(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtReadDate_To));

		Log.info("Element found");

		return element;

	}


	
	


}
