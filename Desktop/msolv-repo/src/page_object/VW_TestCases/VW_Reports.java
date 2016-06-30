package page_object.VW_TestCases;

import utility.PropertyUtility;
import utility.VW_Constant;

public class VW_Reports {

	private static PropertyUtility  putil = new PropertyUtility(VW_Constant.VW_REPORTS_PAGE_FILEPATH);

	public static String VendorDeliver = putil.getEnvironmentProperty("Vendor_Deliver");
	public static String VendorLead = putil.getEnvironmentProperty("Vendor_Lead");
	public static String JobManagement = putil.getEnvironmentProperty("Job_Management");
	public static String JobItinerary = putil.getEnvironmentProperty("Job_Itinerary");
	public static String Excel = putil.getEnvironmentProperty("Excel");
	public static String Screen = putil.getEnvironmentProperty("Screen");
	public static String Submit_Btn = putil.getEnvironmentProperty("Submit");
	public static String ScreenChk = putil.getEnvironmentProperty("Screen_Chk");
	public static String Reports_Lnk =  VendorDeliver+":"+VendorLead+":"+JobManagement+":"+JobItinerary;
	public static String Radio_lnk =  Excel+":"+Screen;
	
}
