package com.verizon.cao.selenium.End_User_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.EndUser;

public class HeaderPage implements Constants{
	
	static WebDriver driver = null;
	private static WebElement element;
	CommonFunctions cmf = new CommonFunctions();
	
	public void testBg(WebDriver driver, String clkBg, String selBgGrp, String bg_value, ExtentReports ext_report,ExtentTest test){
		try {
		if (driver.findElement(By.xpath(clkBg)).getText().contains(bg_value)){
			System.out.println("Current Business Group is "+bg_value);
			Log.info("Current Business Group is "+bg_value);
			test.log(LogStatus.PASS, "Business Group", "Current Business Group: "+bg_value);
		}
		else{
			cmf.clkElement(driver, clkBg, "Business Group", ext_report, test);
			test.log(LogStatus.INFO, "Business Group", "Current Business Group: "+driver.findElement(By.xpath(clkBg)).getText());
			Log.info("Clicked Business Group");
			cmf.sleep(1000);
			cmf.clkElement(driver, selBgGrp, selBgGrp, ext_report, test);
			cmf.Processing(driver);
			Log.info("Selected Business Group is "+bg_value);
			test.log(LogStatus.PASS, "Business Group", "Current Business Group: "+bg_value);
		}
		}
		catch (Exception e){
			Log.error("Business group: "+bg_value+" failed to select");
			test.log(LogStatus.FAIL,"Business Group Should be selected", "Usage: <span style='font-weight:bold;'>Business Group could not be Selected</span>");
		}
		}
	
	public boolean verifyMenu(WebDriver driver, String menuObj){
		if (cmf.existsElement(menuObj, driver) == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void search_box(WebDriver driver, String searchObj, String value, String resultObj,ExtentReports ext_report,ExtentTest test){
		try{
			driver.findElement(By.xpath(searchObj)).sendKeys(value);
	        if (cmf.existsElement(resultObj+"'"+value+"')]", driver) == true){
	        	System.out.println("Element exist");
	        	Log.info("Searched text has"+value+" result data found");
				test.log(LogStatus.PASS, "Reference Search", "Searched text has"+value+" result data found");
	        }
	        else{
	        	System.out.println("Element not found");
	        	Log.info("Searched text has"+value+" result no data found");
				test.log(LogStatus.INFO, "Reference Search", "Searched text has"+value+" result no data found");
	        	return;
	        }
		}
		catch (Exception e){
			
		}
	}
	
	public void click_profile(WebDriver driver,String profileObj,String myprofileObj,ExtentReports ext_report,ExtentTest test){
		cmf.clkElement(driver,profileObj, "Click Profile", ext_report, test);
		cmf.sleep(3000);
		cmf.clkElement(driver,myprofileObj, "Click My Profile", ext_report, test);
		cmf.wait_to_element(driver, EndUser.clk_save_continue);
	}
	
	public static WebElement chk_profile_msg(WebDriver driver,String profileObj,ExtentReports ext_report,ExtentTest test){
		element = driver.findElement(By.xpath(profileObj));
		return element;
		
	}
	
public static WebElement chk_box_subs(WebDriver driver,String subsObj,ExtentReports ext_report,ExtentTest test){
		try {
		element = driver.findElement(By.xpath(subsObj));
		return element;
		}
		catch (Exception e){
			return null;	
		}
	}
		
}