package application_modules;

import com.relevantcodes.extentreports.ExtentTest;

import utility.Log;
import utility.Utils;

public class SetSendKeys_Action {
	


public static boolean Execute(ExtentTest test, String StrsendKeyPath,String StrValuePath) throws Exception{
	
		try{
	
			boolean result = true;
			String [] SendkeyArray = StrsendKeyPath.split(":");
			String [] ValueArray = StrValuePath.split(":");
	  		for (int i=0; i<SendkeyArray.length; i++){
	  			if (! Utils.SetSendKeys(test,SendkeyArray[i],ValueArray[i]))
	  				result = false;
	  		}
	  		return result;
  		
		}catch (Exception e){
			
			Log.error(e.getMessage());
			throw (e);
			
		}

}

}
