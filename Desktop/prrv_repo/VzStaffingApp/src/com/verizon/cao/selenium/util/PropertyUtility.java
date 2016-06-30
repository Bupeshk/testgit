package com.verizon.cao.selenium.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




/*
 * CODE CHANGES HISTORY
 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * 	DATE		AUTHOR				METHODS MODIFIED/ADDED				CODE CHANGES DESCRIPTION
 * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *  07/29/2015  Harish Main      										Class initial creation. 	
 *  07/31/2015  Harish Main			getProperties()						Method used to read property file
 *  07/31/2015  Harish Main			getEnvironmentProperty()			Method used to read the environment property file
 *  07/31/2015  Harish Main			setProperties()						Method used to set the values in property file
 *  08/13/2015  Harish Main			appendProperty()					Method added to append property key - value	
 *  08/20/2015	Harish Main			getDevKitProperty(), 
 *  								getEnvironmentProperty(), 
 *  								getAppInstallProperty 				Added logger messages
*/


/**
 * @date 07/29/2015
 * @author Harish Main
 * @description Class to Read and Write property file
 *
 */

public class PropertyUtility {
	

	Properties prop = new Properties();	
	
	public PropertyUtility(String fileName)
	{
		try{
			InputStream input =  null;
			input = new FileInputStream(fileName);
			prop.load(input);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	/**
	 * @date 08/13/2015
	 * @author Chandrasekar Murugesan
	 * @description Method used to read property file from URL
	 * @param String as property name for which needs to return property value
	 */
	public String getProperty(String propertyKey){
		String propertyValue = "";
		propertyValue=prop.getProperty(propertyKey);
		return propertyValue;
	}
}