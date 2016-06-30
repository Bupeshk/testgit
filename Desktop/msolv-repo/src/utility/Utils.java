package utility;


import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class Utils {
	
	
	public static WebDriver driver ;
	protected static ThreadLocal<RemoteWebDriver> threadDriver = null;
	
	
	
	public static WebDriver open_selhubFF() throws Exception{
		
		PropertyUtility putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
		threadDriver = new ThreadLocal<RemoteWebDriver>(); 
		DesiredCapabilities dc = new DesiredCapabilities(); 
		FirefoxProfile fp = new FirefoxProfile(); 
		dc.setCapability(FirefoxDriver.PROFILE, fp); 
		dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName()); 
		threadDriver.set(new RemoteWebDriver(new URL(putil.getEnvironmentProperty("SELENIUM_HUB_URL")), dc)); 
		driver = threadDriver.get(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.manage().deleteAllCookies(); 
		driver.get(putil.getEnvironmentProperty("baseUrl")); 
		return driver;
		
	}
	
	public static WebDriver open_selhubIE() throws Exception{
		
		PropertyUtility putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
		
		threadDriver = new ThreadLocal<RemoteWebDriver>(); 
		DesiredCapabilities dc =  DesiredCapabilities.internetExplorer();
		dc.setPlatform(Platform.WINDOWS);
		dc.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
		dc.setVersion("11");  
		threadDriver.set(new RemoteWebDriver(new URL(putil.getEnvironmentProperty("SELENIUM_HUB_URL")), dc)); 
		driver = threadDriver.get(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.manage().deleteAllCookies(); 
		driver.get(putil.getEnvironmentProperty("baseUrl")); 
		return driver;
	}	
	
	
	
	public static WebDriver openBrowserIE() throws Exception{
	
	    PropertyUtility putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
	    
	    try{
	    	
	    	System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
	    	driver=new InternetExplorerDriver(); 
	
	        Log.info("New driver instantiated");
		
	        driver.get(putil.getEnvironmentProperty("baseUrl"));
	        
	        driver.manage().window().maximize();
	
	        Log.info("Web application launched successfully");
	
	    }catch (Exception e){
	
	        Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
	
	    }
	
	    return driver;
	
	}
	
	
	public static WebDriver openBrowserFF() throws Exception{
		
		   // String sBrowserName;
		    PropertyUtility putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
		    
		    try{
		    	
		    	driver = new FirefoxDriver();
		    			
		        Log.info("New driver instantiated");
		
		
		        driver.get(putil.getEnvironmentProperty("baseUrl"));
		        
		        driver.manage().window().maximize();
		
		        Log.info("Web application launched successfully");
		
		
		    }catch (Exception e){
		
		        Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		
		    }
		
		    return driver;
		
		}
	
		public static WebDriver openVMBrowserFF() throws Exception{
		
		   // String sBrowserName;
		    PropertyUtility putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
		    
		    try{
		    	
		    	driver = new FirefoxDriver();		
		        Log.info("New driver instantiated");
		        driver.get(putil.getEnvironmentProperty("VMUrl"));	        
		        driver.manage().window().maximize();
		        Log.info("Web application launched successfully");
		
		
		    }catch (Exception e){
		
		        Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		
		    }
		
		    return driver;
		
		}
	
		
		public static WebDriver openVMBrowserIE() throws Exception{
			
		    PropertyUtility putil = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
		    
		    try{
		    	
		    	System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
		    	driver=new InternetExplorerDriver(); 
		
		        Log.info("New driver instantiated");
			
		        driver.get(putil.getEnvironmentProperty("VMUrl"));
		        
		        driver.manage().window().maximize();
		
		        Log.info("Web application launched successfully");
		
		    }catch (Exception e){
		
		        Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		
		    }
		
		    return driver;
		
		}
	
	
	
	
	
	
	public static String getTestCaseName(String sTestCase)throws Exception{
		 
	    String value = sTestCase;
	
	    try{
	
	        int posi = value.indexOf("@");
	
	        value = value.substring(0, posi);
	
	        posi = value.lastIndexOf(".");    
	
	        value = value.substring(posi + 1);
	
	        return value;
	
	            }catch (Exception e){
	
	        Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
	
	        throw (e);
	
	    }
	}
	
	public static void sleep(long millis) 
	{
		try 
		{
			Thread.sleep(millis);
		}catch (InterruptedException e){
			Log.error("Exception :" + e.getMessage());
		}
	}
	
	public static boolean existsElement(ExtentTest test,String strElement) {
	    try {
	    	WebElement element = driver.findElement(By.xpath(strElement));
	    	element.getTagName();
	    	Log.info(element.getText() + "Exist with Tag name: "+ element.getTagName());
	    	test.log(LogStatus.INFO, element.getText() + " Exist with Tag name: "+ element.getTagName());
	        return true;
	        
	    } catch (NoSuchElementException e) {
	    	Log.error("Exception :" + e.getMessage());
	    	test.log(LogStatus.ERROR, " Does not exist exception :" + e.getMessage());
	    	throw (e);
	    }
	    
	}
	
	public static boolean ispresent(ExtentTest test,String strElement) {
	    try {
	    	WebElement element = driver.findElement(By.xpath(strElement));
	    	element.getTagName();
	    	Log.info(element.getText() + "Exist with Tag name: "+ element.getTagName());
	    	test.log(LogStatus.INFO, element.getText() + " Exist with Tag name: "+ element.getTagName());       
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	    	return false;
	    }
	    return true;
	}
	
	
	public static String getText(String strPath)throws Exception{
		WebElement element = driver.findElement(By.xpath(strPath));
		String StrText = element.getText();
    	Log.info(StrText+"Found");
    	
    	return StrText;
	}
	
	public static boolean SetSendKeys(ExtentTest test, String strPath,String Strvalue)throws Exception{
		boolean result = true;
		WebElement element = driver.findElement(By.xpath(strPath));
		if (element.getTagName() !=null && element.getTagName().length()>0){
			element.sendKeys(Strvalue);
			Log.info(Strvalue + " is set");
			test.log(LogStatus.INFO, Strvalue + " is set");
			
		}
		else{
			Log.error("Element for xPath "+strPath+" dosen't exists");
			test.log(LogStatus.ERROR, "Element for xPath "+strPath+" dosen't exists");
			result = false;
		}
		return 	result;
	}
	
	

	public static boolean SelDropDown(String strPath,String SelValue)throws Exception{
		boolean result = true;
		WebElement element= driver.findElement(By.xpath(strPath));
		if (element.getTagName() !=null && element.getTagName().length()>0){
		Select se=new Select(element);
		se.selectByValue(SelValue);
		}
		else{
			Log.error("Element for xPath "+strPath+" dosen't exists");
			result = false;
		}
		return 	result;
	}
	
	public static boolean SelDropDown1(String strPath,String SelValue)throws Exception{
		boolean result = true;
		WebElement element= driver.findElement(By.xpath(strPath));
		if (element.getTagName() !=null && element.getTagName().length()>0){
		Select se=new Select(element);
		se.selectByVisibleText(SelValue);
		}
		else{
			Log.error("Element for xPath "+strPath+" dosen't exists");
			result = false;
		}
		return 	result;
	}
	
	public void getScreenShot(WebDriver driver, String testCase, String testStep, ExtentTest test) throws Exception {
		try{
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
			Calendar c = new GregorianCalendar();
			c.setTime(new Date());
			String file_name = "SS_"+testCase+"_"+testStep+"-"+ c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR)+"_"+c.get(Calendar.HOUR_OF_DAY)+"-"+c.get(Calendar.MINUTE)+"-"+c.get(Calendar.SECOND)+".png"; 
		    File file = new File(GUI_Constant.SCREENSHOT_PATH+""+file_name);
		    FileUtils.copyFile(screenshot, file);	
		    test.log(LogStatus.INFO, "Snapshot for  "+testStep+"  : " + test.addScreenCapture(GUI_Constant.REPORT_SCREENSHOT_PATH+""+file_name)); 
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("ERROR IN SCREENSHOT.");
		}
	}  
	
}
	
	
	
