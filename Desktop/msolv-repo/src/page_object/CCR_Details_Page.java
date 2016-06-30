package page_object;

import utility.Constant;
import utility.PropertyUtility;

public class CCR_Details_Page {
	
	
	private static PropertyUtility  putil = new PropertyUtility(Constant.CCR_DETAILS_FILEPATH);
	public static String CommentsBtn = putil.getEnvironmentProperty("Comments_Btn");
	

}
