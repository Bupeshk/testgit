package application_modules;

import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import page_object.GUI_TestCases.*;

public class Add_Line_Detail {
	
public static void Execute(ExtentTest test, WebDriver driver) throws Exception{
	
	try{
		
	
	String PO_Path  = MD_Create_Form_Page.PO_Number;
	String Line_Path  = MD_Create_Form_Page.Line_Number;
	String Part_Path  = MD_Create_Form_Page.Part_Number;
	String Material_Path  = MD_Create_Form_Page.Material_Id;
	String ReturnQty_Path = MD_Create_Form_Page.returnQty;
	
	String [] PO_Number_ValueArray = MD_Create_Form_Page.PO_Number_Value.split(":");
	String [] Line_Number_ValueArray = MD_Create_Form_Page.Line_Number_Value.split(":");
	String [] Part_Number_ValueArray = MD_Create_Form_Page.Part_Number_Value.split(":");
	String [] Material_Id_ValueArray = MD_Create_Form_Page.Material_Id_Value.split(":");
	String ReturnQty_value = MD_Create_Form_Page.returnQty_Value;

	for (int i=0; i<PO_Number_ValueArray.length; i++){

		String StrReturn_req = MD_Create_Form_Page.Return_Request;
	    Click_Action.Execute(driver, StrReturn_req);
		
		Utils.SetSendKeys(test,PO_Path,PO_Number_ValueArray[i]);
		Utils.SetSendKeys(test,Line_Path,Line_Number_ValueArray[i]);
		Utils.SetSendKeys(test,Part_Path,Part_Number_ValueArray[i]);
		Utils.SetSendKeys(test,Material_Path,Material_Id_ValueArray[i]);
		Utils.SetSendKeys(test,ReturnQty_Path,ReturnQty_value);
		
		String strReturnReasonPath = MD_Create_Form_Page.Return_Reason;
	    String strReturnReasonValue = ExcelUtils.getExcelData("Reason_for_Return","Create_MD_New_CCRNumber");
	    Utils.SelDropDown(strReturnReasonPath, strReturnReasonValue);
	    
		String StrAddLineBtn = MD_Create_Form_Page.Add_lines;
		Click_Action.Execute(driver, StrAddLineBtn);
		
	}
	
	}catch (Exception e){
		
		 Log.error(e.getMessage());
		 throw (e);
		
	}
	


}

}
