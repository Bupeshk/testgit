package com.verizon.cao.selenium.testcase;


import java.io.*;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.IExecutionListener;

import com.verizon.cao.selenium.constants.ApplicationConstants;
import com.verizon.cao.selenium.constants.MyConstants;
import com.verizon.cao.selenium.util.DataBaseConnect;
import com.verizon.cao.selenium.util.StaffingUtil;
import com.verizon.cao.selenium.util.XMLParserUtil;

public class Driver implements IExecutionListener, ApplicationConstants {
	
	@Override
	public void onExecutionStart() {
		
		DOMConfigurator.configure("log4j.xml");
		XMLParserUtil xmlUtil = new XMLParserUtil();
		String env = xmlUtil.getAttributeValue(TESTNGPATH,"env");
		String browser = xmlUtil.getAttributeValue(TESTNGPATH,"browser");
		if (env.equalsIgnoreCase("Local")){
			MyConstants.env = "LOCAL";
		}
		else{
			MyConstants.env = "DEVOPS";
		}	
		if (browser.equalsIgnoreCase("firefox")){
			MyConstants.browser = "FIREFOX";
		}
		else if (browser.equalsIgnoreCase("internetexplorer")) {
			MyConstants.browser = "IE";
		}			

		try {
			DataBaseConnect dbc = new DataBaseConnect();
			dbc.clearData();
			System.out.println("Fetching Data from DB Kindly Wait"); 
			dbc.loadDataCreateJO();
			dbc.loadDataPrepareForHire();
			dbc.loadDataRecruiterE2EAction();
			dbc.loadDataApplyJobOpening();
			dbc.loadDataManageHire();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error while getting the data from Database: " + e);
			MyConstants.executeTestCase = false;
		}
		try {
			   BufferedWriter out = new BufferedWriter
				         (new FileWriter(LOG_FILEPATH));
				         out.write("");
				         out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error while deleting the log file before execution of test cases: " + e);
		}		


/*		try {
			StaffingUtil su = new StaffingUtil();
			if (!su.checkApplication())
				MyConstants.executeTestCase = false;
		} catch (Exception e) {
			System.out.println("APPLICATION IS NOT RESPONDING. Following error occurred : " + e);
			e.printStackTrace();
			MyConstants.executeTestCase = false;
		}*/
	}

	@Override
	public void onExecutionFinish() {
		System.out.println("Inside onExecutionFinish method...");
		// TODO Auto-generated method stub
	}

}
