package page_object.Profile_Admin_TestCases;

import page_object.Profile_Admin_TestCases.MaterialStatusChange_Admin_Page;
import utility.ExcelUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class MaterialStatusChange_AdminSendkeys {

	public static void Execute(WebDriver driver) throws Exception {
		String materialStatusTo = ExcelUtils.getExcelData("materialStatusTo", "MaterialStatusChange");
		String materialStatus = ExcelUtils.getExcelData("materialStatus", "MaterialStatusChange");
		String cwonumber = ExcelUtils.getExcelData("cwonumber", "MaterialStatusChange");
		
		Select dropdown = new Select(MaterialStatusChange_Admin_Page.materialStatusTo(driver));
		dropdown.selectByValue(materialStatusTo);
		Select dropdownval = new Select(MaterialStatusChange_Admin_Page.materialStatus(driver));
		dropdownval.selectByValue(materialStatus);
		MaterialStatusChange_Admin_Page.cwonumber(driver).sendKeys(cwonumber);
		MaterialStatusChange_Admin_Page.Save(driver).click();
	
	}

}