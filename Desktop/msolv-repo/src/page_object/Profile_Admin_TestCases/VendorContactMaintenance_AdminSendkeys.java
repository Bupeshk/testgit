package page_object.Profile_Admin_TestCases;

import utility.ExcelUtils;
import page_object.Profile_Admin_TestCases.VendorContactMaintenance_Admin_Page;
import org.openqa.selenium.WebDriver;

public class VendorContactMaintenance_AdminSendkeys {

	public static void Execute(WebDriver driver) throws Exception {
		String VendorName = ExcelUtils.getExcelData("VendorName", "VendorContactMaintenance");
		
		VendorContactMaintenance_Admin_Page.VendorName(driver).sendKeys(VendorName);
		VendorContactMaintenance_Admin_Page.Submit(driver).click();
	
	}

}