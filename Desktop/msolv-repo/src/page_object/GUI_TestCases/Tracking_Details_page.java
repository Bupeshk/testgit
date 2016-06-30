package page_object.GUI_TestCases;

import java.util.NoSuchElementException;
import utility.GUI_Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.PropertyUtility;

public class Tracking_Details_page {
	
	String ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File_TestData;
	//private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.TRACKING_DETAIL_FILEPATH);
	
	private static String CallOutQty = putil.getEnvironmentProperty("Call_Out_Qty");
	private static String ShipDate = putil.getEnvironmentProperty("Ship_Date");
	private static String ContactPersonname = putil.getEnvironmentProperty("Contact_Person_name");
	private static String ContactEmail = putil.getEnvironmentProperty("Contact_Email");
	private static String Contactphone = putil.getEnvironmentProperty("Contact_phone");
	public static String BackBtn = putil.getEnvironmentProperty("Back_Btn");

	public static String strGetText = CallOutQty+":"+ShipDate+":"+ContactPersonname+":"+ContactEmail+":"+Contactphone;
	public static String strGetColName = "Callout_Quantity:Ship_Date:Contact_person_Name:Contact_email:Contact_phone";
	
	public static boolean CompareTrackingDetails(String StrColoumnGrp) throws Exception {
	    try {
	    	 String ExcelPath = GUI_Constant.Path_TestData + GUI_Constant.File1_TestData;
	    	 boolean matchFlag = true;
	    	 int RowCount  = ExcelUtils.getRowCount() - 1;
		     System.out.println(RowCount);		
		     for (int k=1; k<RowCount+1; k++){
		    	 
			     String [] ColoumnArray = StrColoumnGrp.split(":");
			     String [] CalloutSearch_TrackingDetails = new String[ColoumnArray.length];
			     String [] CalloutFunctionality_TrackingDetails = new String[ColoumnArray.length];
			     for(int j=0; j<ColoumnArray.length; j++){
			    	 CalloutSearch_TrackingDetails[j] =	ExcelUtils.getExcelData(ColoumnArray[j],"Iteration"+k+"");
			     }  
			     for(int j=0; j<ColoumnArray.length; j++){
			    	 ExcelUtils.setExcelFile(ExcelPath,"Callout_Functionality");
			    	 CalloutFunctionality_TrackingDetails[j] =	ExcelUtils.getExcelData(ColoumnArray[j],"Iteration"+k+"");
			     } 
			     for(int j=0; j<ColoumnArray.length; j++){
			    	 if (CalloutSearch_TrackingDetails[j].indexOf(CalloutFunctionality_TrackingDetails[j]) == -1)
			    		 matchFlag = false;
			    }
			     if (matchFlag)
			    	 Log.info("Call Out Quantity, Ship date, Job contact Information is matching");
			     else
			    	 Log.error("Call Out Quantity, Ship date, Job contact Information is not matching");
		     }
		     return matchFlag;
	    } catch (NoSuchElementException e) {
	    	Log.error("Exception :" + e.getMessage());
	        return false;
	    }
	    }
	    
	}

