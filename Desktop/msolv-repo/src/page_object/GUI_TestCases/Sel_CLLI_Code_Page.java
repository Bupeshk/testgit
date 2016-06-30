package page_object.GUI_TestCases;

import utility.GUI_Constant;
import utility.PropertyUtility;

public class Sel_CLLI_Code_Page {
	
	//private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.SEL_CLLI_CODE_FILEPATH);
	
	public static String Submit_Btn = putil.getEnvironmentProperty("Submit_btn");


}
