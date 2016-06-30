package application_modules;

import utility.Utils;

public class Get_Text_Loop_Action {
	
public static String [] Execute(String StrPath) throws Exception{
	
			String [] elementArray = StrPath.split(":");
			String [] textArray = new String[elementArray.length];
			for (int i=0 ; i<elementArray.length;i++ ){
  			//Log.info("xPath is: "+elementArray[i]);
  			textArray[i] = Utils.getText(elementArray[i]);
		}
  		return textArray;
  		
}
}
