package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.ObjectRepository.Admin;

import com.verizon.cao.selenium.common.Log;

public class EditBusinessGroupsPage implements Admin{
	private static WebElement element = null;
	static String object_path = null;
	  private WebDriver driver;
	  
	public EditBusinessGroupsPage(WebDriver driver) {
	    this.driver = driver;
	  }
	
	
	public static WebElement Tabs_link(WebDriver driver,String obj)
	{
		object_path = TabsManageBizGroups_starts+obj+TabsManageBizGroups_ends;
		
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	public static WebElement Name_txt(WebDriver driver)
	{
		 
		element = driver.findElement(By.xpath(txtBizName));
		
		Log.info("Element found");

		return element;

	}
	public static WebElement DisplayName_txt(WebDriver driver)
	{
		 
		element = driver.findElement(By.xpath(txtDisplayName));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement Discription_txt(WebDriver driver)
	{
		
		
		element = driver.findElement(By.xpath(txtDiscription));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement BusinessStatus_dropdown(WebDriver driver)
	{
		
		element = driver.findElement(By.xpath(lstBusiness_Status));

		Log.info("Element found");
		
		return element;

	}
	
	
	
	public static WebElement AllowExternal_chk(WebDriver driver)
	{
		
			
		element = driver.findElement(By.xpath(chkAllowExternal));
		
		Log.info("Element found");

		return element;

	}
	
	
	public static WebElement AvailableGroups_chkList(WebDriver driver,String obj)
	{
		object_path = btnMetaDataAdd_starts+obj+btnMetaDataAdd_ends;
			
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	
	
	public static WebElement Next_btn(WebDriver driver)
	{
		
			
		element = driver.findElement(By.xpath(btnNext));
		
		Log.info("Element found");

		return element;

	}
	
	
	public static WebElement BusinessGroupInfoCancel_btn(WebDriver driver)
	{
		
			
		element = driver.findElement(By.xpath(btnBusinessGroupInfo_Cancel));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement Admin_Author_Roles_chkList(WebDriver driver,String obj)
	{
		object_path = chkAdmin_Author_Roles_starts+obj+chkAdmin_Author_Roles_ends;
			
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement SubAdmin_SubAuthor_Roles_chkList(WebDriver driver,String obj1,String obj2)
	{
		object_path =chkSubAdmin_Author_Roles_starts+obj1+chkSubAdmin_Author_Roles_middle+obj2+chkSubAdmin_Author_Roles_ends;
			
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement Update_AddBusinessGroups_btn(WebDriver driver)
	{
		
			
		element = driver.findElement(By.xpath(btnAddBusinessGroups));
		
		Log.info("Element found");

		return element;

	}

	public static WebElement ManageSystemRoleCancel_btn(WebDriver driver)
	{
		
			
		element = driver.findElement(By.xpath(btnManageSystemRole_Cancel));
		
		Log.info("Element found");

		return element;

	}
	
	public static WebElement PlusTree_Btn(WebDriver driver,String obj)
	{
		object_path = btnPlusTree_starts+obj+btnPlusTree_ends;
			
		element = driver.findElement(By.xpath(object_path));
		
		Log.info("Element found");

		return element;

	}
	
}
