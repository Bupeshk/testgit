package page_object.GUI_TestCases;

import utility.GUI_Constant;
import utility.PropertyUtility;

public class CCR_Details_Page {
	
	
	private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.CCR_DETAILS_FILEPATH);
	public static String CommentsBtn = putil.getEnvironmentProperty("Comments_Btn");
	
	public static String CCRDetails_Header = putil.getEnvironmentProperty("CCRDetails_Header");
	public static String VendorManager_Search = putil.getEnvironmentProperty("VendorManager_Search");
	public static String Team_Lead = putil.getEnvironmentProperty("Team_Lead");
	public static String InstallOpion = putil.getEnvironmentProperty("Install_Opion");
	public static String SubmitBtn = putil.getEnvironmentProperty("Submit_Btn");
	public static String SaveBtn = putil.getEnvironmentProperty("Save_Btn");
	public static String CalloutCCR = putil.getEnvironmentProperty("Callout_CCR");
	

}
