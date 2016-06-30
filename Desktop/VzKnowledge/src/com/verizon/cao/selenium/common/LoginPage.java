package com.verizon.cao.selenium.common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.verizon.cao.selenium.common.ObjectRepository.Common;

public class LoginPage implements Common {
	
	private static WebElement element = null;
	private static String object_path;
	
	 public static WebElement UserID(WebDriver driver){
		 
        element = driver.findElement(By.xpath(userID));
        	
        return element;

        }

    public static WebElement Password(WebDriver driver){

   	 element = driver.findElement(By.xpath(passWord));
   	 
   	 return element;

        }

    public static WebElement btn_SignOn(WebDriver driver){

   	 element = driver.findElement(By.xpath(signOn));
   	 
   	 return element;

        }

    public static WebElement Temp_NAV_Links(WebDriver driver,String obj)
    {
    	object_path = leftNav_links_starts+obj+Nav_links_ends;

      	 element = driver.findElement(By.xpath(object_path));
      	 
      	 return element;
}
    
    
    
}