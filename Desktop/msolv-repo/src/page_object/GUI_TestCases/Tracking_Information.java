package page_object.GUI_TestCases;

import utility.GUI_Constant;
import utility.PropertyUtility;

public class Tracking_Information {
	
	//private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.TRACKING_INFORMATION_FILEPATH);
	
	
	public static String TrakInfoHeader = putil.getEnvironmentProperty("TrakInfoHeader");
	public static String Backbtn = putil.getEnvironmentProperty("Back_btn");
	
	
	
	 
}
