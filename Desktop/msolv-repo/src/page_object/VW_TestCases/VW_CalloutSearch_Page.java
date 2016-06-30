package page_object.VW_TestCases;

import utility.PropertyUtility;
import utility.VW_Constant;

public class VW_CalloutSearch_Page {
	
private static PropertyUtility  putil = new PropertyUtility(VW_Constant.VW_CALLOUT_SEARCH_PAGE_FILEPATH);
	
	public static String CalloutTrackingNum = putil.getEnvironmentProperty("CalloutTracking_Num");
	public static String SubmitBtn = putil.getEnvironmentProperty("Submit_Btn");
	public static String ClearBtn = putil.getEnvironmentProperty("Clear_Btn");
	
	public static String CalloutPage =  CalloutTrackingNum+":"+SubmitBtn+":"+ClearBtn;

}
