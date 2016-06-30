package page_object.VW_TestCases;

import utility.ExcelUtils;
import utility.PropertyUtility;
import utility.VW_Constant;

public class VW_Discrepancies_Page {
	
	private static PropertyUtility  putil = new PropertyUtility(VW_Constant.VW_DISCREPANCIES_PAGE_FILEPATH);

	public static String PONumber = putil.getEnvironmentProperty("PO_Number");
	public static String PartNumber = putil.getEnvironmentProperty("Part_Number");
	public static String Quantity = putil.getEnvironmentProperty("Quantity");
	public static String Description = putil.getEnvironmentProperty("Description");
	public static String DiscrepencyType = putil.getEnvironmentProperty("Discrepency_Type");
	public static String SubmitBtn = putil.getEnvironmentProperty("Submit_Btn");
	public static String ConfirmMsg = putil.getEnvironmentProperty("Confirm_Msg");
	public static String DiscrepencyMsg = putil.getEnvironmentProperty("Discrepency_Msg");
	
	public static String PONumber_Value = ExcelUtils.getExcelData("PO_Number", "Discrepancies");
	public static String PartNumber_Value = ExcelUtils.getExcelData("Part_Number", "Discrepancies");
	public static String Quantity_Value = ExcelUtils.getExcelData("Discrepancy_Quantity", "Discrepancies");
	public static String Description_Value = ExcelUtils.getExcelData("Discrepancy_Description", "Discrepancies");
	public static String DiscrepencyType_Value = ExcelUtils.getExcelData("Discrepency_Type", "Discrepancies");
	
	public static String Discrepency_FieldExist =  PONumber+":"+PartNumber+":"+Quantity+":"+Description+":"+DiscrepencyType+":"+SubmitBtn;
	public static String Discrepency_Fieldpath =  PONumber+":"+PartNumber+":"+Quantity+":"+Description;
	public static String Discrepency_FieldValue =  PONumber_Value+":"+PartNumber_Value+":"+Quantity_Value+":"+Description_Value;
}
