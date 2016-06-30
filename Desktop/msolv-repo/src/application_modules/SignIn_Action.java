package application_modules;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import page_object.GUI_TestCases.LogIn_Page;
import utility.GUI_Constant;
import utility.Log;
import utility.PropertyUtility;

public class SignIn_Action {
	
	
	private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
	
	private static String sUserName = putil.getEnvironmentProperty("Username");
	private static String sPassword = putil.getEnvironmentProperty("Password");
	
	//Execute
	public static void Execute(ExtentTest test, WebDriver driver) throws Exception{
	
	try{
	
	LogIn_Page.UserName(driver).sendKeys(sUserName);
	test.log(LogStatus.INFO, "Username entered in the Username text box: "+sUserName+"");
	Log.info("Username entered in the Username text box");
	
	LogIn_Page.Password(driver).sendKeys(sPassword);
	Log.info("Password entered in the Password text box");
	test.log(LogStatus.INFO, "Password entered in the Password text box");

	LogIn_Page.btn_LogIn(driver).click();
	Log.info("Click action performed on Submit button");
	test.log(LogStatus.INFO, "Click action performed on Submit button");
		
	}catch (Exception e){
		
		 Log.error(e.getMessage());
		 throw (e);
		
	}

}

}
