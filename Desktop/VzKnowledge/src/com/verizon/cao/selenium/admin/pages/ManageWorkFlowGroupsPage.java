package com.verizon.cao.selenium.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ManageWorkFlowGroupsPage implements Admin {

	private static WebElement element = null;
	static String object_path = null;
	

	public static WebElement AddWorkFlowGroups_btn(WebDriver driver)
	{ 
		element = driver.findElement(By.xpath(btnAddWork_Flow_Groups));

		Log.info("Element found");

		return element;

	}

	public static WebElement Actions_lnk(WebDriver driver,String obj)
	{ 
		
		object_path = lnkManageWorkFlow_Actions_starts+obj+lnkManageWorkFlow_Actions_ends;
		
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement txtWorkFlowGroup_Name(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(txtWorkFlowGroup_Name));

		Log.info("Element found");

		return element;

	}
	public static WebElement WorkFlowGroupDesc_txt(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(txtWorkFlowGroup_Desc));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement GroupStatus_list(WebDriver driver,String obj)
	{ 
		object_path = lstWorkFlowGroup_Status_starts+obj+lstWorkFlowGroup_Status_ends;
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	public static WebElement AvailableRoles_opt(WebDriver driver,String obj)
	{ 
		object_path = optAvailableRoles_Editor_starts+obj+optAvailableRoles_Editor_ends;
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}

	public static WebElement AvailableUsers_List(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(object_path));

		Log.info("Element found");

		return element;

	}
	public static WebElement AvailableUsersAdd_btn(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(lnkAvailableUsers_Add));

		Log.info("Element found");

		return element;

	}
	
	public static WebElement AvailableUsersRemove_btn(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(lnkAvailableUsers_Remove));

		Log.info("Element found");

		return element;

	}
	public static WebElement AvailableUsersRemoveAll_btn(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(lnkAvailableUsers_RemoveAll));

		Log.info("Element found");

		return element;

	}
	public static WebElement AvailableUsersAddAll_btn(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(lnkAvailableUsers_AddAll));

		Log.info("Element found");

		return element;

	}
	public static WebElement SelectedUsers_List(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(lstSelectedUsers));

		Log.info("Element found");

		return element;

	}
	public static WebElement AddGroup_btn(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(btnAddWorkFlowGroup));

		Log.info("Element found");

		return element;

	}
	public static WebElement CancelGroup_btn(WebDriver driver)
	{ 
		
		element = driver.findElement(By.xpath(btnCancelWorkFlowGroup));

		Log.info("Element found");

		return element;

	}
}
