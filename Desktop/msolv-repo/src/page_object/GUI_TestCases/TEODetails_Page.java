package page_object.GUI_TestCases;

import utility.GUI_Constant;
import utility.PropertyUtility;

public class TEODetails_Page {
	
private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.TEO_DETAILS_FILEPATH);
	
	public static String TeoLines_Heading = putil.getEnvironmentProperty("TeoLines_Heading");
	public static String SC_Chkbx = putil.getEnvironmentProperty("SC_Chkbx");
	public static String SC_Btn = putil.getEnvironmentProperty("SC_Btn");
	public static String Material_Btn = putil.getEnvironmentProperty("Material_Btn");
	public static String SCAcknowledge = putil.getEnvironmentProperty("SC_Acknowledge");
	public static String Back_Btn = putil.getEnvironmentProperty("Back_Btn");
	
	

}
