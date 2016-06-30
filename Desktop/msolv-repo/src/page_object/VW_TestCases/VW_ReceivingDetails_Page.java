package page_object.VW_TestCases;

import utility.PropertyUtility;
import utility.VW_Constant;

public class VW_ReceivingDetails_Page {
	
	private static PropertyUtility  putil = new PropertyUtility(VW_Constant.VW_RECEIVING_DETAILS_PAGE_FILEPATH);

	public static String ReceivingHeader = putil.getEnvironmentProperty("Receiving_Header");
	public static String MaterialDispositionrequest = putil.getEnvironmentProperty("MaterialDisposition_request");
	public static String ReceivingLineDetails = putil.getEnvironmentProperty("Receiving_LineDetails");
	public static String Receive_Chkbx = putil.getEnvironmentProperty("Receive_Chkbx");
	public static String Receive_Btn = putil.getEnvironmentProperty("Receive_Btn");
	public static String Green_Light = putil.getEnvironmentProperty("Green_Light");
	public static String Confirm_Msg = putil.getEnvironmentProperty("Confirm_Msg");
	
	
	public static String ReceivingDetails = ReceivingHeader+":"+MaterialDispositionrequest+":"+ReceivingLineDetails;

}
