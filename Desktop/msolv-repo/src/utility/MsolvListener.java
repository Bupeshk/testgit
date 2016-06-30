package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.IExecutionListener;

public class MsolvListener implements IExecutionListener {
	
	@Override
	public void onExecutionStart() {	
		XMLUtil xmlUtil = new XMLUtil();
		String env = xmlUtil.getAttributeValue(GUI_Constant.TESTNGPATH,"env");
		WebDriver driver = null;
		try 
		{
			if (env.equalsIgnoreCase("Local"))
			{
				System.out.println("Local execution");
				GUI_Constant.env = "LOCAL";
				driver = Utils.openBrowserIE();
			}
			else
			{
				System.out.println("HUB execution");
				GUI_Constant.env = "DEVOPS";
				driver = Utils.open_selhubIE();
			}	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        WebElement element = driver.findElement(By.xpath(".//img[contains(@src,'msolvlogo.gif')]"));
	        if (element.getTagName() == null || element.getTagName().length() == 0) 
	        {
	              System.out.println("APPLICATION IS NOT RESPONDING.");
	              GUI_Constant.executeTestCase = false;
	        }
	        else
	        {
	        	GUI_Constant.executeTestCase = true;
	        }
	        driver.quit();
		}
		catch (Exception e) 
		{
			System.out.println("APPLICATION IS NOT RESPONDING. Following error occurred : " + e);
			e.printStackTrace();
			GUI_Constant.executeTestCase = false;
		}
	}	

	@Override
	public void onExecutionFinish() {
		//System.out.println("Inside onExecutionFinish method...");
		// TODO Auto-generated method stub
	}
}
