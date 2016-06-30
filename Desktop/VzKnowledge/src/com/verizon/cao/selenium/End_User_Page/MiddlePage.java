package com.verizon.cao.selenium.End_User_Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.common.CommonFunctions;
import com.verizon.cao.selenium.common.Log;

public class MiddlePage {
	static WebDriver driver = null;
	static CommonFunctions cmf = new CommonFunctions();
	private static WebElement element;

	public boolean chk_news(WebDriver driver, String newsObj) {
		if (cmf.existsElement(newsObj, driver) == true) {
			return true;
		} else {
			return false;
		}
	}

	public String get_news_title(WebDriver driver, String titleObj, ExtentReports ext_report, ExtentTest test) {
		try {
			String news_title = driver.findElement(By.xpath(titleObj)).getText();
			System.out.println(driver.findElement(By.xpath(titleObj)).getText());
			Log.info("News Title is :" + driver.findElement(By.xpath(titleObj)).getText());
			test.log(LogStatus.PASS, "News Title", "News Title is " + news_title);
			return news_title;
		} catch (Exception e) {
			Log.error("Could not get News Title " + e);
			test.log(LogStatus.FAIL, "News Title", "Could not get News Title " + e);
			return null;
		}
	}

	public void chk_read_more(WebDriver driver, String readObj, ExtentReports ext_report, ExtentTest test) {
		try {
			if (driver.findElement(By.xpath(readObj)).getText().equalsIgnoreCase("Read More")) {
				System.out.println(driver.findElement(By.xpath(readObj)).getText());
				Log.info("Read More link is display");
				test.log(LogStatus.PASS, "Read More", "Read More link is display in the News Feed");
			} else {
				Log.info("Read More link is not exists");
				test.log(LogStatus.FAIL, "Read More", "Read More link is not exists in the news feed");
			}
		} catch (Exception e) {
			Log.error("Exception occured for the Element ckeck read more link " + readObj + e);
			test.log(LogStatus.FAIL, "Read More", "Could not able to find read more element " + e);
		}
	}

	public void chk_feed(WebDriver driver, String chkfeedObj, String chkgearObj, String noupdateObj,
			ExtentReports ext_report, ExtentTest test, String bg_value, String typeObj) {
		if (cmf.existsElement(chkfeedObj, driver) == true) {
			System.out.println("Feeds are available");
			List<WebElement> get_feed = driver.findElements(By.xpath(chkfeedObj));
			System.out.println("Totally there are " + get_feed.size() + " feed");
			Log.info("Feed are avialble in the BG " + bg_value + " for the filter type: " + typeObj
					+ " and total feeds are: " + get_feed.size());
			test.log(LogStatus.PASS, "My Feed", "Feed are avialble in the BG " + bg_value + " for the filter type: "
					+ typeObj + " and total feeds are: " + get_feed.size());
		} else if (cmf.existsElement(noupdateObj, driver) == true) {
			System.out.println("No Feeds are available");
			Log.info("No Feed are avialble in the BG" + bg_value);
			test.log(LogStatus.INFO, "My Feed",
					"No Feed are avialble in the BG " + bg_value + " for the filter type: " + typeObj);
		}

	}

	public void chk_feed_gear(WebDriver driver, String chkgearObj, String chkgeardetail, ExtentReports ext_report,
			ExtentTest test) {
		try {
			List<WebElement> get_gear_detail = driver.findElements(By.xpath(chkgeardetail));
//			int d = 0;
//			int k = 2;
			//int action_count = get_gear_detail.size() / k;
			for (WebElement g : get_gear_detail) {
				//d++;
				System.out.println("Gear Action is " + g.getText());
				Log.info("Gear Action is " + g.getText());
				test.log(LogStatus.PASS, "Action Gear", "Action gear :" + g.getText());
				//if (d ==  action_count){
				//	System.out.println("break");	
				//break;
			//}
			}
			
		} catch (Exception e) {
			Log.info("Exception occured in getting gear actions " + e);
			test.log(LogStatus.FAIL, "Action Gear", "Exception occured in getting gear actions " + e);
		}
	}

	public void chk_feed_filter(WebDriver driver, String filterObj, String filteroptObj, ExtentReports ext_report,
			ExtentTest test) {
		if (cmf.existsElement(filterObj, driver) == true) {
			System.out.println("My Feed Filter element is exist");
			Log.info("Feed Filter is Exist");
			test.log(LogStatus.PASS, "Feed Filter", "Feed Filetr element is Exist");
			List<WebElement> filter_type = driver.findElements(By.xpath(filteroptObj));
			String[] filter = {"Content","Alerts","Calendar Events","News"}; 
			int j = 0;
			for (WebElement f : filter_type) {
				System.out.println("Filter type is " + filter[j]);
				Log.info("Filter type is " + filter[j]);
				test.log(LogStatus.INFO, "Feed Filter Type", "Filter type is " + filter[j]);
				j++;
			}
		} else {
			Log.info("Feed Filter is not Exist");
			test.log(LogStatus.FAIL, "Feed Filter", "Feed Filter not Exist");
		}
	}

	public void sel_feed_filter(WebDriver driver, String clkfilterObj, String setfilterObj, String chkfeedObj,
			String noupdateObj, ExtentReports ext_report, ExtentTest test) {

		cmf.clkElement(driver, clkfilterObj, "Feed Filter", ext_report, test);
		cmf.clkElement(driver, setfilterObj, "Feed Filter Type", ext_report, test);
	}

	public void chk_breadcrumb(WebDriver driver, String breadObj, String titlename, String taxnameObj,
			ExtentReports ext_report, ExtentTest test) {
		String get_breadcrumb = driver.findElement(By.xpath(breadObj)).getText();
		System.out.println(get_breadcrumb);
		String nav[] = get_breadcrumb.split(" / ");
		if (nav[0].equals("Home") && nav[1].equals(taxnameObj) && nav[2].equals(titlename)) {
			System.out.println("Breadcrumb is verified");
			Log.info("Breadcrumb Verified " + get_breadcrumb);
			test.log(LogStatus.PASS, "Breadcrumb", "Breadcrumb Verified " + get_breadcrumb);
		} else {
			System.out.println("Breadcrumb not verified");
			Log.info("Breadcrumb not Verified " + get_breadcrumb);
			test.log(LogStatus.FAIL, "Breadcrumb", "Breadcrumb not Verified " + get_breadcrumb);
		}
	}

	public void content_detail(WebDriver driver, String ownerObj, String modiObj, String rateObj, String searchObj,
			ExtentReports ext_report, ExtentTest test) {
		if (cmf.existsElement(ownerObj, driver) == true) {
			System.out.println("Owner field is seen");
			String get_owner_name = driver.findElement(By.xpath(ownerObj + "//a")).getText();
			System.out.println("Content author is " + get_owner_name);
			Log.info("Content author is " + get_owner_name);
			test.log(LogStatus.PASS, "Content Author", "Content author is " + get_owner_name);
		} else {
			System.out.println("Element Owner not exist");
			Log.info("Element Owner not exist");
			test.log(LogStatus.FAIL, "Content Owner", "Element Owner not exist");
		}
		if (cmf.existsElement(modiObj, driver) == true) {
			System.out.println("Last Modified field is seen");
			String get_modified_time = driver.findElement(By.xpath(modiObj)).getText();
			System.out.println("Last Modified time is " + get_modified_time);
			Log.info("Last Modified time is " + get_modified_time);
			test.log(LogStatus.PASS, "Modified Time", "Last Modified time is " + get_modified_time);
		} else {
			System.out.println("Last Modified element not exist");
			Log.info("Last Modified element not exist");
			test.log(LogStatus.FAIL, "Modified Time", "Last Modified element not exist");
		}
		if (cmf.existsElement(rateObj, driver) == true) {
			System.out.println("Rating is exists");
			Log.info("Start rate element is exist");
			test.log(LogStatus.PASS, "Rate", "Start rate element is exist");
		} else {
			System.out.println("Start rate element not exist");
			Log.info("Start rate element not exist");
			test.log(LogStatus.FAIL, "Rate", "Start rate element not exist");
		}
		cmf.SwitchFrames(driver, "loadFrame");
		if (cmf.existsElement(searchObj, driver) == true) {
			System.out.println("Search Field is exists");
			Log.info("Search Field is exists");
			test.log(LogStatus.PASS, "Search", "Search Field is exists");
		} else {
			System.out.println("Search Field element not exists");
			Log.info("Search Field element not exists");
			test.log(LogStatus.FAIL, "Search", "Search Field element not exists");
		}
		driver.switchTo().defaultContent();
	}

	public void add_to_bookmark(WebDriver driver, String titleObj, String descObj, String addObj, String saveObj,
			String okObj, String closeObj, ExtentReports ext_report, ExtentTest test) {
		if (cmf.existsElement(titleObj, driver) == true) {
			System.out.println("Title Text box is available to edit");
			Log.info("Title Text box is available to edit");
			test.log(LogStatus.PASS, "Bookmark Title", "Title Text box is available to edit");
		} else {
			System.out.println("Title box field is not exist");
			Log.info("Title Text box box element not exist");
			test.log(LogStatus.INFO, "Bookmark Title", "Title Text box box element not exist");

		}
		if (cmf.existsElement(descObj, driver) == true) {
			System.out.println("Description Text box is available to edit");
			Log.info("Description Text box is available to edit");
			test.log(LogStatus.PASS, "Description", "Description Text box is available to edit");
		} else {
			System.out.println("Description field is not exist");
			Log.info("Description field is not exist");
			test.log(LogStatus.INFO, "Description", "Description field is not exist");
		}

		driver.findElement(By.xpath(addObj)).click();
		cmf.sleep(1000);
		if (driver.findElement(By.xpath(saveObj)).getText().contains("Your Bookmark has been saved.")) {
			System.out.println("Your Bookmark has been saved");
			Log.info("Your Bookmark has been saved");
			test.log(LogStatus.PASS, "Bookmark", "Successfully Bookmark saved");
			driver.findElement(By.xpath(okObj)).click();
			;
		} else {
			Log.info("Bookmark Success message not found");
			test.log(LogStatus.FAIL, "Bookmark", "Bookmark Success message not found");
		}

	}

	public void add_folder(WebDriver driver, String folderObj, String addObj, String nameObj, String addfolderObj,
			ExtentReports ext_report, ExtentTest test) {
		cmf.sleep(4000);
		cmf.clkElement(driver, folderObj, "VZK Folder", ext_report, test);
		cmf.sleep(4000);
		cmf.wait_to_element(driver, addObj);
		cmf.clkElement(driver, addObj, "Click Add", ext_report, test);
		cmf.sleep(1000);
		driver.findElement(By.xpath(nameObj)).sendKeys("Test"+CommonFunctions.timeStamp);
		cmf.clkElement(driver, addfolderObj, "Click Add a Folder", ext_report, test);
		cmf.sleep(1000);
	}

	public void chk_glossary_list(WebDriver driver, String listObj, ExtentReports ext_report, ExtentTest test) throws Exception {
		try {
			if (driver.findElement(By.xpath(listObj)).getText().equals("K")) {
				System.out.println("Glossary list has 'K' filter");
				Log.info("Glossary list items as per filter K");
				test.log(LogStatus.PASS, "Glossary Filter", "Glossary list items as per filter K");
			} else {
				Log.info("Glossary list items not matched with the filter K");
				test.log(LogStatus.FAIL, "Glossary Filter", "Glossary list items not matched with the filter K");
				Reporter.log("Glossary list items not matched with the filter K");
				throw new Exception("Glossary list items not matched with the filter K");
			}
		} catch (Exception e) {
			Log.info("Exception occured while the glossary filter " + e);
			test.log(LogStatus.FAIL, "Glossary Filter", "Exception occured while the glossary filter " + e);
			Reporter.log("Exception occured while the glossary filter " + e);
			throw new Exception("Exception occured while the glossary filter " + e);
		}
	}

	public void chk_glossary_search(WebDriver driver, String serObj, String value, String findObj,
			ExtentReports ext_report, ExtentTest test) {
		try {
			if (cmf.existsElement(serObj, driver) == true) {
				System.out.println("Search box exists");
				driver.findElement(By.xpath(serObj)).sendKeys(value);
				cmf.clkElement(driver, findObj, "Find", ext_report, test);
				cmf.wait_to_element(driver, serObj);
				driver.findElement(By.xpath(serObj)).clear();
				Log.info("Entered search keyword and clicked Find");
				test.log(LogStatus.PASS, "Glossary Search", "Entered search keyword and clicked Find");
			}
		} catch (Exception e) {
			Log.info("Exception occured while the glossary Search " + e);
			test.log(LogStatus.FAIL, "Glossary Search", "Exception occured while the glossary search " + e);
		}
	}

	public void chk_filter_glossary(WebDriver driver, String headerObj, String noitemObj, String didObj, String value,
			ExtentReports ext_report, ExtentTest test) {
		try {
			if (driver.findElement(By.xpath(headerObj)).getText().equalsIgnoreCase(value)) {
				System.out.println("Appropiate search text is listed");
				Log.info("Appropiate search items are listed as per search keyword");
				test.log(LogStatus.PASS, "Glossary Search", "Appropiate search items are listed as per search keyword");
			}
			else {
				if (driver.findElement(By.xpath(noitemObj)).getText().contains("No items match your search")) {
				System.out.println("Unavailable keyword is entered so it displays 'No Items match'");
				Log.info("Search keyword is not matched so it dispaly 'No Items match'");
				test.log(LogStatus.PASS, "Glossary Search",
						"Search keyword is not matched so it dispaly 'No Items match'");
			
			} 
				else{
					Log.info("Unmatched keyword is entered so it should displays 'No Items match'");
					test.log(LogStatus.FAIL, "Glossary Search", "Unmatched keyword is entered so it should displays 'No Items match'");
					Reporter.log("Unmatched keyword is entered so it should displays 'No Items match'");
					throw new Exception("Unmatched keyword is entered so it should displays 'No Items match'");
				}
				if (driver.findElement(By.xpath(didObj)).getText().contains("Did you mean")) {
				System.out.println("Unavailable keyword is entered so it displays 'Did you mean'");
				Log.info("Search keyword is not matched so it dispaly 'Did you mean'");
				test.log(LogStatus.PASS, "Glossary Search",
						"Search keyword is not matched so it dispaly 'Did you mean'");
			}
			}

		} catch (Exception e) {
			Log.info("Exception occured while finding search items" + e);
			test.log(LogStatus.FAIL, "Glossary Search", "Exception occured while finding search items" + e);

		}
	}

	public static WebElement calender_tool(WebDriver driver, String calObj, String noObj, ExtentReports ext_report,
			ExtentTest test) {
		if (cmf.existsElement(noObj, driver) == true) {
			element = driver.findElement(By.xpath(noObj));
		} else if (cmf.existsElement(calObj, driver) == true) {
			element = driver.findElement(By.xpath(calObj));
		}

		return element;
	}
	
	public static WebElement auto_search(WebDriver driver, String dataObj, String searchValue, String autoObj,ExtentReports ext_report,ExtentTest test){
		try{
			cmf.send_data(driver, dataObj, searchValue, ext_report, test);
			cmf.sleep(3000);
			if (cmf.existsElement(autoObj, driver) == true){
				element = driver.findElement(By.xpath(autoObj));
			}
		}
		catch (Exception e){
			Log.info("Exception occured while endering data " + e);
			test.log(LogStatus.FAIL, "Search", "Exception occured while entering search data" + e);
		}
		return element;
	}
	
	public static WebElement search_result(WebDriver driver, String resObj, String noresObj, String frameName,ExtentReports ext_report,ExtentTest test){
		try{
			cmf.sleep(3000);
			cmf.SwitchFrames(driver, frameName);
			if (cmf.existsElement(resObj, driver) == true){
				element = driver.findElement(By.xpath(resObj));
			}
			else if (cmf.existsElement(noresObj, driver) == true){
				element = driver.findElement(By.xpath(resObj));
			}
		}
		catch (Exception e){
			Log.info("Exception occured while endering data " + e);
			test.log(LogStatus.FAIL, "Search", "Exception occured while entering search data" + e);
		}
		return element;
	}
}
