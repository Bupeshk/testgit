package page_object;

import utility.Constant;
import utility.PropertyUtility;

public class Sel_CLLI_Code_Page {
	
	//private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Constant.SEL_CLLI_CODE_FILEPATH);
	
	public static String Submit_Btn = putil.getEnvironmentProperty("Submit_btn");


}
