package page_object;


import utility.Constant;
import utility.PropertyUtility;

public class MD_Search_Page {
	
	//private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Constant.MD_SEARCH_FILEPATH);
	
	public static String WONumber = putil.getEnvironmentProperty("WO_Number");
	private static String PONumber = putil.getEnvironmentProperty("PO_Number");
	private static String FieldEngineer = putil.getEnvironmentProperty("Field_Engineer");
	public static String SubmitBtn = putil.getEnvironmentProperty("Submit_Btn");
	
	
	public static String StrPath =  WONumber+":"+PONumber+":"+FieldEngineer;
	
	
	
}
