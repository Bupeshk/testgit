package page_object;

import utility.Constant;
import utility.ExcelUtils;
import utility.PropertyUtility;

public class CCRComments_Page {
	

	private static PropertyUtility  putil = new PropertyUtility(Constant.COMMENTS_FILEPATH);
	public static String CommentText = putil.getEnvironmentProperty("Comment_Text");
	public static String CommentType = putil.getEnvironmentProperty("Comment_Type");
	public static String SelTEO = putil.getEnvironmentProperty("Sel_TEO");
	public static String SelPO = putil.getEnvironmentProperty("Sel_PO");
	public static String SelLine = putil.getEnvironmentProperty("Sel_Line");
	private static String SelBOMLine = putil.getEnvironmentProperty("Sel_BOM_Line");
	private static String ShippingInfo = putil.getEnvironmentProperty("Shipping_Info");
	public static String SubmitBtn = putil.getEnvironmentProperty("Submit_Btn");
	
	public static String CommentType_Value = ExcelUtils.getExcelData("Comment_Type", "EnterComments_CCRDetailsPage");
	public static String SelTEO_Value = ExcelUtils.getExcelData("TEO", "EnterComments_CCRDetailsPage");
	public static String SelPO_Value = ExcelUtils.getExcelData("PO", "EnterComments_CCRDetailsPage");
	public static String SelLine_Value = ExcelUtils.getExcelData("Line", "EnterComments_CCRDetailsPage");
	
	
	public static String Comments_path = CommentText+":"+CommentType+":"+SelTEO+":"+SelPO+":"+SelLine+":"+SelBOMLine+":"+ShippingInfo;
	public static String Comments_path1 = CommentType+":"+SelTEO;
	public static String Comments_Value = CommentType_Value+":"+SelTEO_Value;
			
}
