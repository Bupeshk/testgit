package page_object;

import utility.Constant;
import utility.ExcelUtils;
import utility.PropertyUtility;

public class Shipping_Info_Page {
	
	//private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Constant.SHIPPING_INFO_FILEPATH);
	
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
	
	private static String ShippingInstruction_Value = ExcelUtils.getExcelData("Shipping_Instruction","Callout_Functionality");
	private static String JobSiteFloor_Value = ExcelUtils.getExcelData("JobSite_Floor","Callout_Functionality");
	private static String Contactname_Value = ExcelUtils.getExcelData("Contact_person_Name","Callout_Functionality");
	private static String ContactEmail_Value = ExcelUtils.getExcelData("Contact_email","Callout_Functionality");
	private static String ContactPhone1_Value = ExcelUtils.getExcelData("Contact_phone1","Callout_Functionality");
	private static String ContactPhone2_Value = ExcelUtils.getExcelData("Contact_phone2","Callout_Functionality");
	private static String ContactPhone3_Value = ExcelUtils.getExcelData("Contact_phone3","Callout_Functionality");
	
	public static String ShippingInfoPath = ShippingInstruction+":"+JobSiteFloor+":"+Contactname+":"+ContactEmail+":"+ContactPhone1+":"+ContactPhone2+":"+ContactPhone3;
	public static String ShippingInfoValues = ShippingInstruction_Value+":"+JobSiteFloor_Value+":"+Contactname_Value+":"+ContactEmail_Value+":"+ContactPhone1_Value+":"+ContactPhone2_Value+":"+ContactPhone3_Value;
	public static String ShippingConfim = JobSiteShippingInfo+":"+ShippingDetails+":"+JobSiteReq+":"+JobContactinfo;
	
	
	
}
