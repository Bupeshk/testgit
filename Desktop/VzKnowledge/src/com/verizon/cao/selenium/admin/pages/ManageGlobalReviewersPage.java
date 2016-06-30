package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ManageGlobalReviewersPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement BusinessGroup_Dropdown(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(lstBusinessGroups));

		Log.info("Element found");

		return element;

	}


	public static WebElement AddUser_Button(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnAddUser));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement FirstName_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtGlobalReviwer_FirstName));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement MiddleName_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtGlobalReviewer_Middle));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement LastName_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtGlobalReviewer_LastName));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement EnterpriseID_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtGlobalReviewer_EnterpriseID));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement ShowUsers_btn(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnGlobalReviewer_ShowUsers));

		Log.info("Element found");

		return element;

	}
	public static WebElement Cancel_btn(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnGlobalReviewer_Cancel));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement Users_Found_lbl(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(lblNumber_Of_Users_Found));

		Log.info("Element found");

		return element;

	}
	
	

	public static WebElement GlobalReviewers_Option1(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(optGlobalReviewerUserType1));

		Log.info("Element found");

		return element;

	}
	public static WebElement GlobalReviewers_OptionEID(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(optGlobalReviewerUserType2));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement lblFullName_Of_Users_Found(WebDriver driver,String obj)
	{ 
		
		object_path = lblFullName_Of_Users_Found_starts+obj+lblFullName_Of_Users_Found_ends;
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	
}