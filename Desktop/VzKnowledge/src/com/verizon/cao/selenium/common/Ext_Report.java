package com.verizon.cao.selenium.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;


public class Ext_Report implements Constants{

public static ExtentReports Instance(String End_User){
	ExtentReports extent;
	String Path = REPORT_PATH+"//"+End_User+CommonFunctions.timeStamp+".html";
	//String Path = REPORT_PATH+"//"+End_User+".html";
	System.out.println(Path);
	extent = new ExtentReports(Path, false);
	extent.config()
	           .documentTitle("VzKnowledge")
	           .reportName("VzKnowledge Automation");

	return extent;
 }

public static String CaptureScreen(WebDriver driver, String ImagesPath)
{
	TakesScreenshot oScn = (TakesScreenshot) driver;
	File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
	File oDest = new File(ImagesPath+".png");
	try {
		FileUtils.copyFile(oScnShot, oDest);
		return ImagesPath+".png";
	} 
	catch (IOException e) {System.out.println(e.getMessage());}
		return ImagesPath+".png";
	}

}
