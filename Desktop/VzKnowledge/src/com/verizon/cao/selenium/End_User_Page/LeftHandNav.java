package com.verizon.cao.selenium.End_User_Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Log;

public class LeftHandNav {
	static WebDriver driver = null;
	CommonFunctions cmf = new CommonFunctions();

	public void chk_content_label(WebDriver driver, String conObj, ExtentReports ext_report, ExtentTest test) {
		if (cmf.existsElement(conObj, driver) == true) {
			System.out.println("Content Label Is Present");
			Log.info("Content is present in the Left hand side");
			test.log(LogStatus.PASS, "Content", "Content Label is display in the LHN");
		}

	}

	public static List<WebElement> chk_content_type(WebDriver driver, String contypeObj) {
		try {
			List<WebElement> lis_left = driver.findElements(By.xpath(contypeObj));
			return lis_left;
		} catch (Exception e) {
			System.out.println("Exception " + e);
			Log.error("Exception occured for the element '" + contypeObj + "' to fetch all the content types");
			return null;
		}

	}

	public void chk_tool_label(WebDriver driver, String toolObj, ExtentReports ext_report, ExtentTest test) {
		if (cmf.existsElement(toolObj, driver) == true) {
			System.out.println("Tool Label Is Present");
			Log.info("Tool is seen at bottom in the Left hand side");
			test.log(LogStatus.PASS, "Tool", "Tool Label is display in the LHN");
		}
	}

	public static List<WebElement> chk_tool_type(WebDriver driver, String tooltypeObj) {
		try {
			List<WebElement> lis_tools = driver.findElements(By.xpath(tooltypeObj));
			return lis_tools;
		} catch (Exception e) {
			System.out.println("Exception " + e);
			Log.error("Exception occured for the element '" + tooltypeObj + "' to fetch all the content types");
			return null;
		}
	}
}