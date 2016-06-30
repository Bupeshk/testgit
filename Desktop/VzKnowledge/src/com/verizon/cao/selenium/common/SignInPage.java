package com.verizon.cao.selenium.common;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Common;

public class SignInPage implements Common {
     private static WebElement element = null;
	
	 public static WebElement UserID(WebDriver driver1,ExtentReports ext_report,ExtentTest test){
		 
        element = driver1.findElement(By.xpath(userID));
        Log.info("Username Entered");
        test.log(LogStatus.PASS, "Username", "Username Entered");
        return element;

        }

    public static WebElement Password(WebDriver driver1,ExtentReports ext_report,ExtentTest test){

   	 element = driver1.findElement(By.xpath(passWord));
   	Log.info("Password Entered");
   	test.log(LogStatus.PASS, "Password", "Password Entered");
   	 return element;

        }

    public static WebElement btn_SignOn(WebDriver driver1,ExtentReports ext_report,ExtentTest test){

   	 element = driver1.findElement(By.xpath(signOn));
   	Log.info("Clicked Submit button");
   	test.log(LogStatus.PASS, "Submit", "Submit button Clicked");
   	 return element;

        }
}
