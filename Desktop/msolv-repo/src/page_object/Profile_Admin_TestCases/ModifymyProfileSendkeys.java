package page_object.Profile_Admin_TestCases;

import utility.ExcelUtils;
import page_object.Profile_Admin_TestCases.ModifymyProfile_Page;
import org.openqa.selenium.WebDriver;

public class ModifymyProfileSendkeys {
	
	public static void Execute(WebDriver driver) throws Exception {
        String Telephone1 = ExcelUtils.getExcelData("Telephone1", "Modify_My_Profile");
		ModifymyProfile_Page.Telephone1(driver).sendKeys(Telephone1);
		ModifymyProfile_Page.Btn_Submit(driver).click();
	
	}

}