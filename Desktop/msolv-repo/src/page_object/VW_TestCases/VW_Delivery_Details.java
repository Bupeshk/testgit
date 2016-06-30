package page_object.VW_TestCases;

import utility.PropertyUtility;
import utility.VW_Constant;

public class VW_Delivery_Details {
	
	private static PropertyUtility  putil = new PropertyUtility(VW_Constant.VW_DELIVERY_DETAILS_PAGE_FILEPATH);

	public static String DeliveryReqDate = putil.getEnvironmentProperty("DeliveryReq_Date");
	public static String DeliveryChkbx = putil.getEnvironmentProperty("Delivery_Chkbx");
	public static String SubmitBtn = putil.getEnvironmentProperty("submit_btn");
	public static String SignedBy = putil.getEnvironmentProperty("Signed_By");
	public static String ConfirmMsg = putil.getEnvironmentProperty("Confirm_Msg");
	
	public static String DeliveryDetail_Path =  DeliveryReqDate+":"+DeliveryChkbx+":"+SubmitBtn;

}
