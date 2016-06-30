package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class AdminCommonPages implements Admin {
	private static WebElement element = null;
	static String object_path = null;
	
	public static WebElement TableHeaders(WebDriver driver,String obj)
	{ 
		
		object_path = tblHeaders_starts+obj+tblHeaders_ends;
		System.out.println("object_path" +object_path);

		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	
	
	public static WebElement Action_Links(WebDriver driver,String Name,String Action)
	{ 
		
		object_path = lnkActions_starts+Name+lnkActions_middle+Action+lnkActions_ends;
		
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	
	//dummy
	public static WebElement ColumnNames_Check(WebDriver driver,String obj)
	{ 
		
		object_path = tblHeaders_starts+obj+tblHeaders_ends;
		System.out.println("object_path" +object_path);

		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}

	public static WebElement OBIEE_UserName(WebDriver driver){
		 
        element = driver.findElement(By.xpath(txt_OBIEE_UserName));
        	
        return element;

        }

    public static WebElement OBIEE_Password(WebDriver driver){

   	 element = driver.findElement(By.xpath(txt_OBIEE_Password));
   	 
   	 return element;

        }

    public static WebElement OBIEE_SignIn(WebDriver driver){

   	 element = driver.findElement(By.xpath(btn_OBIEE_SignIn));
   	 
   	 return element;

        }
}
