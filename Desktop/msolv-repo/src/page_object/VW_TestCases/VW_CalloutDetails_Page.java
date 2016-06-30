package page_object.VW_TestCases;

import utility.PropertyUtility;
import utility.VW_Constant;

public class VW_CalloutDetails_Page {
	
	private static PropertyUtility  putil = new PropertyUtility(VW_Constant.VW_CCR_DETAILS_PAGE_FILEPATH);

	public static String Checkbox = putil.getEnvironmentProperty("Checkbox");
	public static String Callout_Btn = putil.getEnvironmentProperty("Callout_Btn");
	
}
