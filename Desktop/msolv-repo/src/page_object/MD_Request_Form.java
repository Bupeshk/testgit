package page_object;

import utility.Constant;
import utility.ExcelUtils;
import utility.PropertyUtility;

public class MD_Request_Form {
	
	//private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Constant.MD_REQUEST_FORM_FILEPATH);

	
	private static String Header = putil.getEnvironmentProperty("Header");
	private static String Line_Details = putil.getEnvironmentProperty("Line_Details");
	//private static String Address1 = putil.getEnvironmentProperty("Address1");
	//private static String Address2 = putil.getEnvironmentProperty("Address2");
	//private static String City = putil.getEnvironmentProperty("City");
	//private static String Zip = putil.getEnvironmentProperty("Zip");
	public static String State = putil.getEnvironmentProperty("State");
	private static String Pickup_Instructions = putil.getEnvironmentProperty("Pickup_Instructions");
	public static String SubmitBtn = putil.getEnvironmentProperty("Submit_Btn");
	public static String Tracking_Number = putil.getEnvironmentProperty("Request_TrackingNumber");
	
	//private static String Address_Value = ExcelUtils.getExcelData("Address","CreateMD_Existing_CCRNumber");
	//private static String City_Value = ExcelUtils.getExcelData("City","CreateMD_Existing_CCRNumber");
	//private static String Zip_Value = ExcelUtils.getExcelData("Zip","CreateMD_Existing_CCRNumber");
	//private static String CLLI_Code_Value = ExcelUtils.getExcelData("CLLI_Code","CreateMD_Existing_CCRNumber");
	private static String Pickup_Instructions_Value = ExcelUtils.getExcelData("Pickup_Instruction","CreateMD_Existing_CCRNumber");
	public static String ReturnReason_Value = ExcelUtils.getExcelData("Reason_for_Return","CreateMD_Existing_CCRNumber");
	public static String returnQty_Value = ExcelUtils.getExcelData("Return_Qty","CreateMD_Existing_CCRNumber");

	public static String StrMDRequestFormPath = Header+":"+Line_Details;
	public static String StrMDRequestFields = Pickup_Instructions;
	public static String StrMDRequestValues = Pickup_Instructions_Value;
	
}
