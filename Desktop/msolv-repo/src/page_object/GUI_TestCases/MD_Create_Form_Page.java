package page_object.GUI_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.GUI_Constant;
import utility.ExcelUtils;
import utility.PropertyUtility;

public class MD_Create_Form_Page {
	

	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.MD_CREATE_FORM_FILEPATH);

	
	private static String Header = putil.getEnvironmentProperty("Header");
	private static String AddLineDetails = putil.getEnvironmentProperty("Add_Line_Details");
	private static String LineDetails = putil.getEnvironmentProperty("Line_Details");
	public static String EnggSearch = putil.getEnvironmentProperty("Engg_Search");
	public static String Engg_Submit = putil.getEnvironmentProperty("Engg_Submit");
	public static String Rtn_Warehouse = putil.getEnvironmentProperty("Rtn_Warehouse");
	private static String Address1 = putil.getEnvironmentProperty("Address1");
	private static String City = putil.getEnvironmentProperty("City");
	private static String Zip = putil.getEnvironmentProperty("Zip");
	public static String State = putil.getEnvironmentProperty("State");
	private static String CLLI_Code = putil.getEnvironmentProperty("CLLI_Code");
	public static String Cal_img = putil.getEnvironmentProperty("Cal_img");
	public static String Day = putil.getEnvironmentProperty("Day");
	public static String Month = putil.getEnvironmentProperty("Month");
	public static String Year = putil.getEnvironmentProperty("Year");
	private static String Pickup_Instructions = putil.getEnvironmentProperty("PickupInstructions");
	public static String PO_Number = putil.getEnvironmentProperty("PO_Number");
	public static String Line_Number = putil.getEnvironmentProperty("Line_Number");
	public static String Part_Number = putil.getEnvironmentProperty("Part_Number");
	public static String Material_Id = putil.getEnvironmentProperty("Material_Id");
	public static String returnQty = putil.getEnvironmentProperty("Return_Qty");
	public static String Return_Request = putil.getEnvironmentProperty("Return_Request");
	public static String Return_Reason = putil.getEnvironmentProperty("Return_Reason");
	public static String Add_lines = putil.getEnvironmentProperty("Add_lines");
	public static String Submit_Page = putil.getEnvironmentProperty("Submit_Page");
	public static String Tracking_Number = putil.getEnvironmentProperty("Tracking_Number");
	
	private static String Address_Value = ExcelUtils.getExcelData("Address","Create_MD_New_CCRNumber");
	private static String City_Value = ExcelUtils.getExcelData("City","Create_MD_New_CCRNumber");
	private static String Zip_Value = ExcelUtils.getExcelData("Zip","Create_MD_New_CCRNumber");
	private static String CLLI_Code_Value = ExcelUtils.getExcelData("CLLI_Code","Create_MD_New_CCRNumber");
	private static String Pickup_Instructions_Value = ExcelUtils.getExcelData("Pickup_Instruction","Create_MD_New_CCRNumber");
	public static String PO_Number_Value = ExcelUtils.getExcelData("PO_Num","Create_MD_New_CCRNumber");
	public static String Line_Number_Value = ExcelUtils.getExcelData("Line_Num","Create_MD_New_CCRNumber");
	public static String Part_Number_Value = ExcelUtils.getExcelData("Part_Num","Create_MD_New_CCRNumber");
	public static String Material_Id_Value = ExcelUtils.getExcelData("Material_ID","Create_MD_New_CCRNumber");
	public static String returnQty_Value = ExcelUtils.getExcelData("Return_Qty","Create_MD_New_CCRNumber");
	
	private static String AaronLindsey = putil.getEnvironmentProperty("Aaron_Lindsey");
	//private static String Adenrele_Adedeji = putil.getEnvironmentProperty("Adenrele_Adedeji");
	
	public static String StrMDCreateFormPath =  Header+":"+AddLineDetails+":"+LineDetails;
	public static String StrMDCreateFields = 	Address1+":"+City+":"+Zip+":"+CLLI_Code+":"+Pickup_Instructions;
	public static String StrMDCreateValues = 	Address_Value+":"+City_Value+":"+Zip_Value+":"+CLLI_Code_Value+":"+Pickup_Instructions_Value;
	
	
	
	
	public static WebElement Sel_Engg(WebDriver driver){
		 
	       element = driver.findElement(By.xpath("//*[@value='"+AaronLindsey+",9999999999,m-solv-ebusiness@verizon.com']"));
	      
	       return element;

	       }
	

}
