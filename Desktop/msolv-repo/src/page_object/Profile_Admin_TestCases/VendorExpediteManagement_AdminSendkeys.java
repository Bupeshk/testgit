package page_object.Profile_Admin_TestCases;

import utility.ExcelUtils;
import page_object.Profile_Admin_TestCases.VendorExpediteManagement_Admin_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class VendorExpediteManagement_AdminSendkeys {

	public static void Execute(WebDriver driver) throws Exception {
		String CCRWO = ExcelUtils.getExcelData("CCRWO", "VendorExpediteManagement");
		String Vendor = ExcelUtils.getExcelData("Vendor", "VendorExpediteManagement");

		Select dropdown = new Select(VendorExpediteManagement_Admin_Page.CCRWO(driver));
		dropdown.selectByValue(CCRWO);
		Select dropdownval = new Select(VendorExpediteManagement_Admin_Page.Vendor(driver));
		dropdownval.selectByValue(Vendor);
		VendorExpediteManagement_Admin_Page.Submit(driver).click();
	
	}

}