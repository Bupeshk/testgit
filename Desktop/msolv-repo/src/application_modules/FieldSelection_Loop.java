package application_modules;

import utility.Log;
import utility.Utils;

public class FieldSelection_Loop {
	
	public static boolean Execute(String StrsendKeyPath,String StrValuePath ) throws Exception{
		
		try{
		
		boolean result = true;
		String [] SendkeyArray = StrsendKeyPath.split(":");
		String [] ValueArray = StrValuePath.split(":");
  		for (int i=0; i<SendkeyArray.length; i++){
  			if (! Utils.SelDropDown1(SendkeyArray[i],ValueArray[i]))
  				result = false;
		}
  		return result;
  		
		}catch (Exception e){
			
		 Log.error(e.getMessage());
   		 throw (e);
			
		}

}

}
