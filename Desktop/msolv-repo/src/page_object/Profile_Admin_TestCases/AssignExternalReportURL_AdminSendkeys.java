package page_object.Profile_Admin_TestCases;

import utility.ExcelUtils;
import page_object.Profile_Admin_TestCases.AssignExternalReportURL_Admin_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignExternalReportURL_AdminSendkeys {

	public static void Execute(WebDriver driver) throws Exception {

		String CustomerID = ExcelUtils.getExcelData("CustomerID", "AssignExternalReportURL");
		String Role = ExcelUtils.getExcelData("Role", "AssignExternalReportURL");
		String ExternalReportURL = ExcelUtils.getExcelData("ExternalReportURL", "AssignExternalReportURL");
		
		Select dropdown = new Select(AssignExternalReportURL_Admin_Page.CustomerID(driver));
		dropdown.selectByValue(CustomerID);
		Select dropdownrole = new Select(AssignExternalReportURL_Admin_Page.Role(driver));
		dropdownrole.selectByValue(Role);
		AssignExternalReportURL_Admin_Page.ExternalReportURL(driver).clear();
		AssignExternalReportURL_Admin_Page.ExternalReportURL(driver).sendKeys(ExternalReportURL);
		AssignExternalReportURL_Admin_Page.Submit(driver).click();
	
	}

}