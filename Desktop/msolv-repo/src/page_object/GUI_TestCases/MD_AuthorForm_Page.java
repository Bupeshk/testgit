package page_object.GUI_TestCases;


import utility.GUI_Constant;
import utility.PropertyUtility;

public class MD_AuthorForm_Page {
	
	//private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.MD_AUTHORFORM_FILEPATH);

	
	public static String CalendarBtn = putil.getEnvironmentProperty("Calendar_Btn");
	public static String SaveEditsBtn = putil.getEnvironmentProperty("SaveEdits_Btn");
	public static String AuthorizeBtn = putil.getEnvironmentProperty("Authorize_Btn");
	
}
