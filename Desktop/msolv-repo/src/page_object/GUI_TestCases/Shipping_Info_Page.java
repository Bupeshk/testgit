package page_object.GUI_TestCases;

import utility.GUI_Constant;
import utility.PropertyUtility;

public class Shipping_Info_Page {
	
	
	//private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.SHIPPING_INFO_FILEPATH);
	
	private static String ShippingInstruction = putil.getEnvironmentProperty("Shipping_instruction");
	private static String JobSiteFloor = putil.getEnvironmentProperty("JobSite_Floor");
	private static String Contactname = putil.getEnvironmentProperty("Contact_name");
	private static String ContactEmail = putil.getEnvironmentProperty("Contact_Email");
	private static String ContactPhone1 = putil.getEnvironmentProperty("Contact_Phone1");
	private static String ContactPhone2 = putil.getEnvironmentProperty("Contact_Phone2");
	private static String ContactPhone3 = putil.getEnvironmentProperty("Contact_Phone3");
	public static String Continue_Btn = putil.getEnvironmentProperty("Continue_Btn");
	private static String JobSiteShippingInfo = putil.getEnvironmentProperty("JobSite_ShippingInfo");
	private static String ShippingDetails = putil.getEnvironmentProperty("Shipping_Details");
	private static String JobSiteReq = putil.getEnvironmentProperty("JobSite_Req");
	private static String JobContactinfo = putil.getEnvironmentProperty("JobContact_info");
	public static String SubmitBtn = putil.getEnvironmentProperty("Submit_Btn");
	public static String Mobile_Num = putil.getEnvironmentProperty("Mobile_Num");
	public static String Date = putil.getEnvironmentProperty("Date");
	

	public static String ShippingInfoPath = ShippingInstruction+":"+JobSiteFloor+":"+Contactname+":"+ContactEmail+":"+ContactPhone1+":"+ContactPhone2+":"+ContactPhone3;
	public static String ShippingConfim = JobSiteShippingInfo+":"+ShippingDetails+":"+JobSiteReq+":"+JobContactinfo;
	
	
	
}
