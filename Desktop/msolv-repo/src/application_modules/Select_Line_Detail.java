package application_modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import page_object.GUI_TestCases.MD_Request_Form;
import utility.Log;
import utility.Utils;

public class Select_Line_Detail {
	
	public static void Execute(ExtentTest test, WebDriver driver) throws Exception{
	
	try{	

	String [] ReturnQty_ValueArray = MD_Request_Form.returnQty_Value.split(":");
	String [] ReturnReason_ValueArray = MD_Request_Form.ReturnReason_Value.split(":");
	
	for (int i=1; i<ReturnQty_ValueArray.length+1; i++){
		
		WebElement Return_Req = driver.findElement(By.xpath("//*[@name='RETURN_REQUEST"+i+"']"));
		Return_Req.click();
		
		String ReturnReason_path = "//*[@name='RETURN_REASON"+i+"']";
	    String strReturnReasonValue = ReturnReason_ValueArray[i-1];
	    Utils.SelDropDown(ReturnReason_path, strReturnReasonValue);
	    
	    String ReturnQty_Path = "//*[@name='RETURN_QTY"+i+"']";
	    Utils.SetSendKeys(test,ReturnQty_Path,ReturnQty_ValueArray[i-1]);
	}
	
	}catch (Exception e){
		
		 Log.error(e.getMessage());
		 throw (e);
		
	}
}

}

