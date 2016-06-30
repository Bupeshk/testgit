package utility;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//import org.apache.log4j.Logger;

//import com.verizon.cmb.perfecto.selenium.beans.PropertyBean;
//import com.verizon.cmb.perfecto.selenium.constants.ApplicationConstants;
//import com.verizon.cmb.perfecto.selenium.logger.SeleniumLogWrapper;


public class PropertyUtility {

	
	Properties prop = new Properties();
	public PropertyUtility(String fileName){
		try{
		InputStream input =  null;
		//File file = new File(fileName);
		//System.out.println("File creted "+file);
		input = new FileInputStream(fileName);
		//System.out.println("input creted "+input);
		prop.load(input);				
		
		}
		catch (IOException e) {
			//System.out.println("Error "+e);
	    	//logger.error("PropertyUtility :: getEnvironmentProperty, Exception:"+e);
	   }
	}
	public String getEnvironmentProperty(String propertyKey){
		
		//logger.info("PropertyUtility :: getEnvironmentProperty, invoked...");
		String propertyValue=null;
		propertyValue=prop.getProperty(propertyKey);
		//System.out.println("propertyValue creted "+propertyValue);
		//logger.info("PropertyUtility :: getEnvironmentProperty, propertyKey:"+propertyKey+", propertyValue:"+propertyValue);
		return propertyValue;
		
	}
}