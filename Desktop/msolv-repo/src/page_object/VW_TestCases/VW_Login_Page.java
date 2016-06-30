package page_object.VW_TestCases;

import utility.PropertyUtility;
import utility.VW_Constant;

public class VW_Login_Page {
	
	private static PropertyUtility  putil = new PropertyUtility(VW_Constant.VW_LOGIN_FILEPATH);
	
	public static String UserID = putil.getEnvironmentProperty("Userid");
	public static String SubmitBtn = putil.getEnvironmentProperty("Submit_Btn");
}
