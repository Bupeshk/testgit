package application_modules;
import com.relevantcodes.extentreports.ExtentTest;

import utility.Utils;

public class Object_Exist_Loop_Action {
	
	public static boolean Execute(ExtentTest test,String StrPath) throws Exception{
		try{		
			boolean result = true;
			String [] elementArray = StrPath.split(":");
	  		for (int i=0 ; i<elementArray.length;i++ ){
	  			if(! Utils.existsElement(test,elementArray[i])){
	  				result = false;
	  				break;
	  			}
	  		}
	  		return result;
		}
		catch(Exception e){
			return false;
		}
  	
	}
}
