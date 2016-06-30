package com.verizon.cao.selenium.setup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Constants;
import com.verizon.cao.selenium.common.Log;
import com.verizon.cao.selenium.common.ObjectRepository.Common;

public class SetupBase implements Common{

	public static final int DEFAULT_TIMEOUT = 60;
	//public static WebDriver driver;
	public static WebDriverWait driverWaitDefault;
	//protected static ThreadLocal<RemoteWebDriver> threadDriver = null;
	
/*	protected static String getTestBaseUrl() throws MalformedURLException {

//		DOMConfigurator.configure("log4j.xml");

		// Code for running from Selenium HUB

		 threadDriver = new ThreadLocal<RemoteWebDriver>();
		 DesiredCapabilities dc = new DesiredCapabilities();
		 FirefoxProfile fp = new FirefoxProfile();
		 dc.setCapability(FirefoxDriver.PROFILE, fp);
		 dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
		 threadDriver.set(new RemoteWebDriver(new URL(HubUrl), dc));
		 driver = threadDriver.get();

		// Set capability

		//System.out.println("Setting capability: Firefox");
		
		DOMConfigurator.configure("log4j.xml");
		driver = new FirefoxDriver();
		Log.info("Driver Initiated");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(BaseUrl);
		System.out.println("Test base url: " + BaseUrl);
		Log.info("VzKnowledge Url Launched");
		return BaseUrl;
	}*/
	
}