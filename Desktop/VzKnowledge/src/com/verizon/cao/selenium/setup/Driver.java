package com.verizon.cao.selenium.setup;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;

import org.testng.IExecutionListener;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.XMLParserUtil;
import com.verizon.cao.selenium.common.ObjectRepository.Common;

public class Driver implements Common, IExecutionListener, Constants{

	public static final int DEFAULT_TIMEOUT = 60;
	CommonFunctions cmf = new CommonFunctions();
	//protected static String getTestBaseUrl() throws MalformedURLException {
	
	@Override
	public void  onExecutionStart() {
		try{
			System.out.println("Inside onExecutionStart in Driver class.");
			XMLParserUtil xmlUtil = new XMLParserUtil();
			String env = xmlUtil.getAttributeValue(TESTNGPATH, "env");
			String browserName = xmlUtil.getAttributeValue(TESTNGPATH, "launchBrowser");
			boolean isExtranetTC = xmlUtil.isExtranetTC(TESTNGPATH);
			DOMConfigurator.configure("log4j.xml");
			if(env.equalsIgnoreCase("Devops")){
				if(browserName.equalsIgnoreCase("firefox"))
					CommonFunctions.open_selhubFF();
				else
					CommonFunctions.open_selhubIE();
			}
			else{
				if(browserName.equalsIgnoreCase("firefox"))
					CommonFunctions.openBrowserFF();
				else
					CommonFunctions.openBrowserIE();				
			}
			Log.info("Driver Initiated");
			CommonFunctions.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			if (isExtranetTC)
				CommonFunctions.driver.get(ExtranetBaseUrl);
			else
				CommonFunctions.driver.get(BaseUrl);
			
			Log.info("VzKnowledge Url Launched");
			/*CommonFunctions.driver.findElement(By.xpath(userID)).sendKeys(Username);
			CommonFunctions.driver.findElement(By.xpath(passWord)).sendKeys(Password);
			CommonFunctions.driver.findElement(By.xpath(signOn)).click();
			cmf.alert(CommonFunctions.driver);*/
			Calendar c = new GregorianCalendar();
			c.setTime(new Date());
			CommonFunctions.timeStamp = "-"+ c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR)+"_"+c.get(Calendar.HOUR_OF_DAY)+"-"+c.get(Calendar.MINUTE)+"-"+c.get(Calendar.SECOND); 
		}
		catch(Exception e){
			System.out.println("Error in login into application.");
			CommonFunctions.executeTestCase = false;
		}
		//return BaseUrl;
	}
	
	@Override
	public void onExecutionFinish() {
		System.out.println("Inside onExecutionFinish method...");
		CommonFunctions.driver.quit();
		// TODO Auto-generated method stub
	}

}
