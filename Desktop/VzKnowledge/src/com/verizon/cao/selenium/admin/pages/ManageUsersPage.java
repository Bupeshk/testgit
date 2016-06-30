package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ManageUsersPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement AddUsers_btn(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnAddUsers));

		Log.info("Element found");

		return element;

	}


	public static WebElement ExportUsers_btn(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnExportUsers));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement SearchUser_txt(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(txtSearchUser));
     
		Log.info("Element found");

		return element;

	}
	
	public static WebElement Find_btn(WebDriver driver)
	{ 
		
			
		element = driver.findElement(By.xpath(btnSearchUser));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement btnDownloadTemplate(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnDownloadTemplate));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement btnBrowseFile(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(btnBrowseFile));
     
		Log.info("Element found");

		return element;

	}
	
	public static WebElement btnUpload(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(btnBrowseFile));
     
		Log.info("Element found");

		return element;

	}
	
	
	
	public static WebElement lstSystemRole(WebDriver driver)
	{ 
		
			
		element = driver.findElement(By.xpath(lstSystemRole));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement lstCustomRole(WebDriver driver)
	{ 
		
			
		element = driver.findElement(By.xpath(lstCustomRole));

		Log.info("Element found");

		return element;

	}
	public static WebElement btnFindUser(WebDriver driver)
	{ 
		
			
		element = driver.findElement(By.xpath(btnFindUser));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement lblSelectUsers(WebDriver driver,String obj)
	{ 
		
			
		element = driver.findElement(By.xpath(lblSelectUsers));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement optUserType1(WebDriver driver,String obj)
	{ 
		
			
		element = driver.findElement(By.xpath(optUserType1));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement optUserType2(WebDriver driver,String obj)
	{ 
		
			
		element = driver.findElement(By.xpath(optUserType2));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement txtFirstName(WebDriver driver,String obj)
	{ 
		
			
		element = driver.findElement(By.xpath(txtFirstName));

		Log.info("Element found");

		return element;

	}
	public static WebElement txtLastName(WebDriver driver,String obj)
	{ 
		
			
		element = driver.findElement(By.xpath(txtLastName));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement txtEnterpriseId(WebDriver driver,String obj)
	{ 
					
		element = driver.findElement(By.xpath(txtEnterpriseId));

		Log.info("Element found");

		return element;

	}
	public static WebElement OK_Cancel_btn(WebDriver driver,String obj)
	{ 
		object_path = btnOk_CancelSearch_starts+obj+btnOk_CancelSearch_ends;
			
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	public static WebElement Admin_Author_Roles_chkList(WebDriver driver,String obj)
	{
		object_path = chkUsers_Admin_Author_Roles_starts+obj+chkUsers_Admin_Author_Roles_ends;
			
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	
	
	
	


}
