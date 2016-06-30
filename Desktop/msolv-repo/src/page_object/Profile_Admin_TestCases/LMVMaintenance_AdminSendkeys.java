package page_object.Profile_Admin_TestCases;

import page_object.Profile_Admin_TestCases.LMVMaintenance_Admin_Page;

import org.openqa.selenium.WebDriver;

import application_modules.Click_Action;


public class LMVMaintenance_AdminSendkeys {

	public static void Execute(WebDriver driver) throws Exception {

  		String Strcheck_box = LMVMaintenance_Admin_Page.checkbox;
  		Click_Action.Execute(driver, Strcheck_box);
		LMVMaintenance_Admin_Page.Delete(driver).click();
		driver.switchTo().alert().accept();
		
	}

}