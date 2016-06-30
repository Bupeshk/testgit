package page_object.Profile_Admin_TestCases;

import utility.ExcelUtils;
import page_object.Profile_Admin_TestCases.AssignReuseCoordinatorEmailAddress_Admin_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignReuseCoordinatorEmailAddress_AdminSendkeys {
	
	public static void Execute(WebDriver driver) throws Exception {
		String CustomerID = ExcelUtils.getExcelData("CustomerID", "AssignReuseCoordinatorEmailAddress");
		String ReuseCoordinatorEmailAddress = ExcelUtils.getExcelData("ReuseCoordinatorEmailAddress", "AssignReuseCoordinatorEmailAddress");
		
		Select dropdown = new Select(AssignReuseCoordinatorEmailAddress_Admin_Page.CustomerID(driver));
		dropdown.selectByValue(CustomerID);
		AssignReuseCoordinatorEmailAddress_Admin_Page.ReuseCoordinatorEmailAddress(driver).clear();
		AssignReuseCoordinatorEmailAddress_Admin_Page.ReuseCoordinatorEmailAddress(driver).sendKeys(ReuseCoordinatorEmailAddress);
		AssignReuseCoordinatorEmailAddress_Admin_Page.Submit(driver).click();
	
	}

}