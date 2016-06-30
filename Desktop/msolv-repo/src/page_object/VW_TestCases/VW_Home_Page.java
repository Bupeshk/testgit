package page_object.VW_TestCases;

import utility.PropertyUtility;
import utility.VW_Constant;

public class VW_Home_Page {
	

	private static PropertyUtility  putil = new PropertyUtility(VW_Constant.VW_HOMEPAGE_FILEPATH);
	
	public static String CCRSearch_lnk = putil.getEnvironmentProperty("CCR_Search");
	public static String Receiving_lnk = putil.getEnvironmentProperty("Receiving");
	public static String Delivery_lnk = putil.getEnvironmentProperty("Delivery");
	public static String CalloutSearch_lnk = putil.getEnvironmentProperty("Callout_Search");
	public static String Reports_lnk = putil.getEnvironmentProperty("Reports");
	public static String Discrepancies_lnk = putil.getEnvironmentProperty("Discrepancies");
	
	public static String StrSideMenu =  CCRSearch_lnk+":"+Receiving_lnk+":"+Delivery_lnk+":"+CalloutSearch_lnk+":"+Reports_lnk+":"+Discrepancies_lnk;
}
