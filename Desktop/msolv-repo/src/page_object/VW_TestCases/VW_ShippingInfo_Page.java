package page_object.VW_TestCases;

import utility.ExcelUtils;
import utility.PropertyUtility;
import utility.VW_Constant;

public class VW_ShippingInfo_Page {
	
	private static PropertyUtility  putil = new PropertyUtility(VW_Constant.VW_SHIPPING_INFO_PAGE_FILEPATH);

	public static String ShippingInfo = putil.getEnvironmentProperty("Shipping_Info");
	public static String JobSiteReq = putil.getEnvironmentProperty("JobSite_Req");
	public static String JobContactInfo = putil.getEnvironmentProperty("JobContact_Info");
	
	private static String ShippingInstruction = putil.getEnvironmentProperty("Shipping_instruction");
	private static String JobSiteFloor = putil.getEnvironmentProperty("JobSite_Floor");
	private static String Contactname = putil.getEnvironmentProperty("Contact_name");
	private static String ContactEmail = putil.getEnvironmentProperty("Contact_Email");
	private static String ContactPhone1 = putil.getEnvironmentProperty("Contact_Phone1");
	private static String ContactPhone2 = putil.getEnvironmentProperty("Contact_Phone2");
	private static String ContactPhone3 = putil.getEnvironmentProperty("Contact_Phone3");
	
	public static String Submit_Btn = putil.getEnvironmentProperty("Submit_Btn");
	
	public static String ConfirmPgShippingInfo = putil.getEnvironmentProperty("ConfirmPg_ShippingInfo");
	public static String ConfirmPgShippingDetails = putil.getEnvironmentProperty("ConfirmPg_ShippingDetails");
	public static String ConfirmPgJobSiteReq = putil.getEnvironmentProperty("ConfirmPg_JobSiteReq");
	public static String ConfirmPgJobContactInfo = putil.getEnvironmentProperty("ConfirmPg_JobContactInfo");
	
	private static String ShippingInstruction_Value = ExcelUtils.getExcelData("Shipping_Instruction","Callout_Functionality");
	private static String JobSiteFloor_Value = ExcelUtils.getExcelData("JobSite_Floor","Callout_Functionality");
	private static String Contactname_Value = ExcelUtils.getExcelData("Contact_person_Name","Callout_Functionality");
	private static String ContactEmail_Value = ExcelUtils.getExcelData("Contact_email","Callout_Functionality");
	private static String ContactPhone1_Value = ExcelUtils.getExcelData("Contact_phone1","Callout_Functionality");
	private static String ContactPhone2_Value = ExcelUtils.getExcelData("Contact_phone2","Callout_Functionality");
	private static String ContactPhone3_Value = ExcelUtils.getExcelData("Contact_phone3","Callout_Functionality");
	
	public static String ShippingInfoValidation = ShippingInfo+":"+JobSiteReq+":"+JobContactInfo;
	public static String ShippingInfoPath = ShippingInstruction+":"+JobSiteFloor+":"+Contactname+":"+ContactEmail+":"+ContactPhone1+":"+ContactPhone2+":"+ContactPhone3;
	public static String ShippingInfoValues = ShippingInstruction_Value+":"+JobSiteFloor_Value+":"+Contactname_Value+":"+ContactEmail_Value+":"+ContactPhone1_Value+":"+ContactPhone2_Value+":"+ContactPhone3_Value;
	public static String Conf_ShippingInfoValidation = ConfirmPgShippingInfo+":"+ConfirmPgShippingDetails+":"+ConfirmPgJobSiteReq+":"+ConfirmPgJobContactInfo;
	
}
