package com.verizon.cao.selenium.End_User_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Log;

public class RightHandNav {
	static WebDriver driver = null;
	static CommonFunctions cmf = new CommonFunctions();
	private static WebElement element;
	
	public void chk_elem_right(WebDriver driver, String rightObj, String[] rightelem,ExtentReports ext_report, ExtentTest test){
		for (int i=0; i<rightelem.length; i++){
        	if (cmf.existsElement(rightObj+"[text()='"+rightelem[i]+"']", driver) == true){
        		System.out.println("Content "+rightelem[i]+"is present");
        		Log.info("Content "+rightelem[i]+" is available");
        		test.log(LogStatus.PASS, "RHN", "Menu "+rightelem[i]+" is display");
        	}
        	else{
        		Log.info("Content "+rightelem[i]+" is not available");
        		test.log(LogStatus.FAIL, "RHN", "Menu "+rightelem[i]+" is not display");
        	}
        }
	}
	
	public static WebElement cal_allevent(WebDriver driver, String allObj, String noObj, String clkObj,ExtentReports ext_report, ExtentTest test){
		if (cmf.existsElement(allObj, driver) ==  true){
			cmf.clkElement(driver, allObj, "All Event", ext_report, test);
			cmf.sleep(2000);
			if (cmf.existsElement(noObj, driver) == true){
				element = driver.findElement(By.xpath(noObj));
			}
			else if (cmf.existsElement(clkObj, driver) == true){
				element = driver.findElement(By.xpath(clkObj));
			}
		}
		return element;
	}
	
public static WebElement cal_internal(WebDriver driver, String intObj, String noObj, String clkintObj,ExtentReports ext_report, ExtentTest test){
	if (cmf.existsElement(intObj, driver) ==  true){
		cmf.clkElement(driver, intObj, "Internal Tab", ext_report, test);
		cmf.sleep(2000);
		if (cmf.existsElement(noObj, driver) == true){
			element = driver.findElement(By.xpath(noObj));
		}
		else if (cmf.existsElement(clkintObj, driver) == true){
			element = driver.findElement(By.xpath(clkintObj));
		}
	}
	return element;
	}

public static WebElement cal_external(WebDriver driver, String extObj, String noObj, String clkextObj,ExtentReports ext_report, ExtentTest test){
	if (cmf.existsElement(extObj, driver) ==  true){
		cmf.clkElement(driver, extObj, "External Tab", ext_report, test);
		cmf.sleep(2000);
		if (cmf.existsElement(noObj, driver) == true){
			element = driver.findElement(By.xpath(noObj));
		}
		else if (cmf.existsElement(clkextObj, driver) == true){
			element = driver.findElement(By.xpath(clkextObj));
		}
	}
	return element;
}
}
