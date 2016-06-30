package page_object;

import java.util.NoSuchElementException;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.PropertyUtility;

public class Tracking_Details_page {
	
	String ExcelPath = Constant.Path_TestData + Constant.File_TestData;
	//private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(Constant.TRACKING_DETAIL_FILEPATH);
	
	private static String CallOutQty = putil.getEnvironmentProperty("Call_Out_Qty");
	private static String ShipDate = putil.getEnvironmentProperty("Ship_Date");
	private static String ContactPersonname = putil.getEnvironmentProperty("Contact_Person_name");
	private static String ContactEmail = putil.getEnvironmentProperty("Contact_Email");
	private static String Contactphone = putil.getEnvironmentProperty("Contact_phone");

	public static String strGetText = CallOutQty+":"+ShipDate+":"+ContactPersonname+":"+ContactEmail+":"+Contactphone;
	public static String strGetColName = "Callout_Quantity:Ship_Date:Contact_person_Name:Contact_email:Contact_phone";
	
	public static boolean CompareTrackingDetails(String StrColoumnGrp) {
	    try {
	    	 boolean matchFlag = false;
		     String [] ColoumnArray = StrColoumnGrp.split(":");
		     String [] CalloutSearch_TrackingDetails = new String[ColoumnArray.length];
		     String [] CalloutFunctionality_TrackingDetails = new String[ColoumnArray.length];
		     for(int j=0; j<ColoumnArray.length; j++){
		    	 CalloutSearch_TrackingDetails[j] =	ExcelUtils.getExcelData(ColoumnArray[j],"Callout_Search");
		     }  
		     for(int j=0; j<ColoumnArray.length; j++){
		    	 CalloutFunctionality_TrackingDetails[j] =	ExcelUtils.getExcelData(ColoumnArray[j],"Callout_Functionality");
		     } 
		     for(int j=0; j<ColoumnArray.length; j++){
		    	 if (CalloutFunctionality_TrackingDetails[j].equalsIgnoreCase(CalloutSearch_TrackingDetails[j]))
		    		 matchFlag = true;
		    	else
		    		 matchFlag = false;
		    }
		     if (matchFlag)
		    	 Log.info("Call Out Quantity, Ship date, Job contact Information is matching");
		     else
		    	 Log.error("Call Out Quantity, Ship date, Job contact Information is not matching");
		    
		     return matchFlag;  
	    } catch (NoSuchElementException e) {
	    	Log.error("Exception :" + e.getMessage());
	        return false;
	    }
	    }
	    
	}

