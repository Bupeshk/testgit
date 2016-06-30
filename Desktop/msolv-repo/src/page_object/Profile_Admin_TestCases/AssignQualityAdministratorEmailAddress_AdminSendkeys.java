package page_object.Profile_Admin_TestCases;

import utility.ExcelUtils;
import page_object.Profile_Admin_TestCases.AssignQualityAdministratorEmailAddress_Admin_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignQualityAdministratorEmailAddress_AdminSendkeys {
	
	public static void Execute(WebDriver driver) throws Exception {
		String CustomerID = ExcelUtils.getExcelData("CustomerID", "AssignQualityAdministratorEmailAddress");
		String QualityAdminEMailAddress = ExcelUtils.getExcelData("QualityAdminEMailAddress", "AssignQualityAdministratorEmailAddress");
		
		Select dropdown = new Select(AssignQualityAdministratorEmailAddress_Admin_Page.CustomerID(driver));
		dropdown.selectByValue(CustomerID);
		AssignQualityAdministratorEmailAddress_Admin_Page.QualityAdminEMailAddress(driver).clear();
		AssignQualityAdministratorEmailAddress_Admin_Page.QualityAdminEMailAddress(driver).sendKeys(QualityAdminEMailAddress);
		AssignQualityAdministratorEmailAddress_Admin_Page.Submit(driver).click();
	
	}

}