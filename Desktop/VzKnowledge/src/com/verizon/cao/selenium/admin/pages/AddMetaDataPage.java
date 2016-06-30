package com.verizon.cao.selenium.admin.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class AddMetaDataPage implements Admin {
	private static WebDriver driver;
	
	public AddMetaDataPage(WebDriver driver) {
	    this.driver = driver;
	  }

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement MetaData_btn_Add_Cancel(WebDriver driver,String button)
	{ 
		object_path = btnMetaDataAdd_starts+button+btnMetaDataAdd_ends;
		
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}


	public static WebElement MetaDataValue_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtMetaDataValue));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement MetaDataDesc_txt(WebDriver driver)
	{ 
		
				
		element = driver.findElement(By.xpath(txtMetaDataDesc));
     
		Log.info("Element found");

		return element;

	}
	
	public static WebElement StatusOfData_lst(WebDriver driver)
	{ 
						
		element = driver.findElement(By.xpath(lstStatus));

		Log.info("Element found");

		return element;

	}
	
	
	public static WebElement EndUserRoles_Opt(WebDriver driver,String obj)
	{ 
		
		object_path = optEndUserRoles_starts+obj+optEndUserRoles_ends;
		
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	


}
