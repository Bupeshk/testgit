package page_object.Profile_Admin_TestCases;

import utility.ExcelUtils;
import page_object.Profile_Admin_TestCases.SearchUserProfile_Page;
import org.openqa.selenium.WebDriver;

public class SearchUserProfileSendkeys {
	
	public static void Execute(WebDriver driver) throws Exception {

		String UserID = ExcelUtils.getExcelData("User_ID", "Search_User_Profile");
		SearchUserProfile_Page.UserID(driver).sendKeys(UserID);
	}

}