package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class AddRolesPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;

	public static WebElement RoleName_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtRoleName));

		Log.info("Element found");

		return element;

	}


	public static WebElement RoleNotes_txt(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(txtRoleNotes));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement RoleDesc_txt(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(txtRoleDesc));
     
		Log.info("Element found");

		return element;

	}
	public static WebElement AddRole_btn(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(btnAddRole));
     
		Log.info("Element found");

		return element;

	}
	
	public static WebElement AllowExternal_chkBox(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(chkManageRoles_AllowExternal));
     
		Log.info("Element found");

		return element;

	}
	
	
	public static WebElement Status_list(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(lstManageRoles_Status));
     
		Log.info("Element found");

		return element;

	}
	public static WebElement Content_Types_list(WebDriver driver,String obj)
	{ 
		object_path = lnkContentTypes_starts+obj+lnkContentTypes_ends;
	
		element = driver.findElement(By.xpath(object_path));
     
		Log.info("Element found");

		return element;

	}
	public static WebElement BusinessGroupDefault_chkBox(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(chkBusinessGroupDefault));
     
		Log.info("Element found");

		return element;

	}
	
	public static WebElement ReviewDate_Workflow(WebDriver driver,String obj)
	{ 
		object_path = chkWorkFlow_starts+obj+chkWorkFlow_ends;
		
		element = driver.findElement(By.xpath(object_path));
     
		Log.info("Element found");

		return element;

	}
	public static WebElement DeafultWorkFlow_List(WebDriver driver,String obj)
	{ 
		object_path = lstDefaultWorkFlow_starts+obj+lstDefaultWorkFlow_ends;
		
		element = driver.findElement(By.xpath(object_path));
     
		Log.info("Element found");

		return element;

	}
	
	public static WebElement AvailableGroups_chkBox(WebDriver driver)
	{ 
	
		element = driver.findElement(By.xpath(chkAvailableGroups));
     
		Log.info("Element found");

		return element;

	}
	
	
	


}
