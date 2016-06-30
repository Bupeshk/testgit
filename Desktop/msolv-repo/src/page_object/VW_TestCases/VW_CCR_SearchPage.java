package page_object.VW_TestCases;

import utility.PropertyUtility;
import utility.VW_Constant;

public class VW_CCR_SearchPage {
	
	private static PropertyUtility  putil = new PropertyUtility(VW_Constant.VW_CCR_SEARCH_PAGE_FILEPATH);

	public static String WONumber = putil.getEnvironmentProperty("WO_Number");
	public static String TEONumber = putil.getEnvironmentProperty("TEO_Number");
	public static String PONumber = putil.getEnvironmentProperty("PO_Number");
	public static String SearchBtn = putil.getEnvironmentProperty("Search_Btn");
	public static String CalloutCCR = putil.getEnvironmentProperty("CalloutCCR");
	public static String CartBtn = putil.getEnvironmentProperty("Cart_Btn");
	
	
	public static String StrCCRPath =  WONumber+":"+TEONumber+":"+PONumber;
	
	
	
// *******************************************CCR Search in Delivery Functionality******************************************************
	
	
	
	public static String DF_WONumber = putil.getEnvironmentProperty("DF_WONumber");
	public static String DF_TEONumber = putil.getEnvironmentProperty("DF_TEONumber");
	public static String Tracking_Number = putil.getEnvironmentProperty("Tracking_Number");
	public static String DeliveryStatus = putil.getEnvironmentProperty("Delivery_Status");
		
	public static String StrDeliveryPath =  DF_WONumber+":"+DF_TEONumber+":"+Tracking_Number+":"+SearchBtn;




//*******************************************CCR Search in RECEIVING Functionality******************************************************


	public static String R_WONumber = putil.getEnvironmentProperty("R_WONumber");
	public static String R_TEONumber = putil.getEnvironmentProperty("R_TEONumber");
	public static String R_PONumber = putil.getEnvironmentProperty("R_PONumber");

	public static String StrReceivingPath =  R_WONumber+":"+R_TEONumber+":"+R_PONumber+":"+SearchBtn;

}