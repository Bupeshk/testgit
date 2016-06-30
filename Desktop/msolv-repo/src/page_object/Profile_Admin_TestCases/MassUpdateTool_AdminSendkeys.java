package page_object.Profile_Admin_TestCases;

import page_object.Profile_Admin_TestCases.MassUpdateTool_Admin_Page;
import utility.ExcelUtils;
import utility.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MassUpdateTool_AdminSendkeys {

	
	public static void Execute(WebDriver driver) throws Exception {
		String Selectoption = ExcelUtils.getExcelData("Selectoption", "MassUpdateTool");
		
		Select dropdown = new Select(MassUpdateTool_Admin_Page.Selectoption(driver));
		dropdown.selectByValue(Selectoption);
		MassUpdateTool_Admin_Page.Browse(driver).click();
		Runtime.getRuntime().exec("Drivers/FileUpload.exe");
		Utils.sleep(2000);
		MassUpdateTool_Admin_Page.Upload(driver).click();
		
	}

}