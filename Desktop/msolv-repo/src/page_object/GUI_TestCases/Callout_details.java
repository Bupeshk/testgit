package page_object.GUI_TestCases;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.GUI_Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.PropertyUtility;

public class Callout_details {
	
	private static WebElement element = null;
	private static PropertyUtility  putil = new PropertyUtility(GUI_Constant.CALLOUT_DETAIL_FILEPATH);
	
	private static String CCRHeader = putil.getEnvironmentProperty("CCR_Header");
	//private static String CCRHeader1 = putil.getEnvironmentProperty("CCR_Header1");
	private static String CalloutLines = putil.getEnvironmentProperty("Callout_Lines");
	private static String CalloutQtyPath = putil.getEnvironmentProperty("Callout_Qtypath");
	public static String PreviousCallouts = putil.getEnvironmentProperty("previous_Callouts");
	public static String QtyOnHand = putil.getEnvironmentProperty("Qty_OnHand");
	public static String CalloutSel = putil.getEnvironmentProperty("Callout_Sel");
	
	
	public static String Str_CalloutDetails_Path =  CCRHeader+":"+ CalloutLines;
	public static String strGetColName = "Qty_OnHand:Callout_Quantity";
	
	
	public static WebElement CalloutQty(WebDriver driver){
		 
        element = driver.findElement(By.xpath(CalloutQtyPath));
    
        return element;

     }
	
	public static WebElement QtyOnHand(WebDriver driver){
		 
        element = driver.findElement(By.xpath(QtyOnHand));
    
        return element;

     }
	
	public static boolean CompareQtyOnHand(String col1, String col2, String row1, String row2) throws Exception {
	    try {
	    	 boolean matchFlag = true;
		     String [] qtyOnHands = (ExcelUtils.getExcelData(col1,row1)).split(":");
		     String [] callOutQty = (ExcelUtils.getExcelData(col2,row1)).split(":");
		    int [] differnce = new int[qtyOnHands.length];
		    for (int i=0; i<qtyOnHands.length;i++){
		    	differnce[i] = (new Integer(qtyOnHands[i])).intValue() - (new Integer(callOutQty[i])).intValue();
		    }
		    
		    String [] ActQtyDetails = (ExcelUtils.getExcelData("Qty_OnHand",row2)).split(":");
		     for(int j=0; j<ActQtyDetails.length; j++){
		    	 int actQtyDetail = (new Integer (ActQtyDetails[j])).intValue();
		    	 if (!(actQtyDetail == differnce[j]))
		    		 matchFlag = false;
		     }
		     if (matchFlag)
		    	 Log.info("Qty OnHand is equal to (Previous Qty on hand - Call out quantity)");
		     else
		    	 Log.error("Qty OnHand is not equal to (Previous Qty on hand - Call out quantity)");
		    
		     return matchFlag;  
	    } catch (NoSuchElementException e) {
	    	Log.error("Exception :" + e.getMessage());
	        return false;
	    }
	    }
	
	
	
	

}
