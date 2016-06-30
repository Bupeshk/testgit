package page_object;

import utility.Constant;
import utility.PropertyUtility;

public class TEODetails_Page {
	
private static PropertyUtility  putil = new PropertyUtility(Constant.TEO_DETAILS_FILEPATH);
	
	public static String TeoLines_Heading = putil.getEnvironmentProperty("TeoLines_Heading");
	public static String SC_Chkbx = putil.getEnvironmentProperty("SC_Chkbx");
	public static String SC_Btn = putil.getEnvironmentProperty("SC_Btn");
	
	

}
