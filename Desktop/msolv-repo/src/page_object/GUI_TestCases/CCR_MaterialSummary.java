package page_object.GUI_TestCases;

import utility.GUI_Constant;
import utility.PropertyUtility;

public class CCR_MaterialSummary {
	
	private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.CCR_MATERIALSUMMARY_FILEPATH);
	private static String CCRMaterialSummary = putil.getEnvironmentProperty("CCR_MaterialSummary");
	private static String CCRInfo = putil.getEnvironmentProperty("CCR_Info");
	public static String TEOSection = putil.getEnvironmentProperty("TEO_Section");
	public static String ExporttoExcel = putil.getEnvironmentProperty("Export_to_Excel");
	public static String Backbtn = putil.getEnvironmentProperty("Back_btn");
	public static String Savebtn = putil.getEnvironmentProperty("Save_btn");
	public static String ClearAll = putil.getEnvironmentProperty("Clear_All");
	public static String CommentsBtn = putil.getEnvironmentProperty("Comments_Btn");
	
	
	public static String CCRMaterialpath = CCRMaterialSummary+":"+CCRInfo+":"+TEOSection;
	public static String CCRMaterialBtnPath = ExporttoExcel+":"+Backbtn+":"+Savebtn+":"+ClearAll+":"+CommentsBtn;

}
