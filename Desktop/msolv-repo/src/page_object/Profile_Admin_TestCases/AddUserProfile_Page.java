package page_object.Profile_Admin_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ExcelUtils;
import utility.Log;
import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class AddUserProfile_Page {
	
	private static WebElement element = null;
	
	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.ADDUSERPROFILE_FILEPATH);
	public static String lnk_Profile = putil.getEnvironmentProperty("Profile");
	public static String Add_User = putil.getEnvironmentProperty("Adduser");
	private static String lastname = putil.getEnvironmentProperty("last_name");
	private static String First_Name = putil.getEnvironmentProperty("First_Name");
	private static String Middle_Initial = putil.getEnvironmentProperty("Middle_Initial");
	private static String User_ID = putil.getEnvironmentProperty("User_ID");
	private static String User_Role = putil.getEnvironmentProperty("User_Role");
	public static String UserRoleOption = putil.getEnvironmentProperty("UserRoleOption");
	public static String Organization = putil.getEnvironmentProperty("Organization");
	private static String Group = putil.getEnvironmentProperty("Group");
	private static String Address_Line1 = putil.getEnvironmentProperty("Address_Line1");
	private static String Address_Line2 = putil.getEnvironmentProperty("Address_Line2");
	private static String City = putil.getEnvironmentProperty("City");
	private static String State = putil.getEnvironmentProperty("State");
	private static String Zip = putil.getEnvironmentProperty("Zip");
	private static String Telephone = putil.getEnvironmentProperty("Telephone");
	private static String Telephone1 = putil.getEnvironmentProperty("Telephone1");
	private static String Telephone2 = putil.getEnvironmentProperty("Telephone2");
	private static String Telephone3 = putil.getEnvironmentProperty("Telephone3");
	private static String Pager = putil.getEnvironmentProperty("Pager");
	private static String Pin = putil.getEnvironmentProperty("Pin");
	private static String Cell = putil.getEnvironmentProperty("Cell");
	private static String Email = putil.getEnvironmentProperty("Email");
	private static String Supervisor = putil.getEnvironmentProperty("Supervisor");
	private static String supervisorName = putil.getEnvironmentProperty("supervisorName");
	private static String supervisorTelephone1 = putil.getEnvironmentProperty("supervisorTelephone1");
	private static String supervisorTelephone2 = putil.getEnvironmentProperty("supervisorTelephone2");
	private static String supervisorTelephone3 = putil.getEnvironmentProperty("supervisorTelephone3");
	private static String supervisorEmail = putil.getEnvironmentProperty("supervisorEmail");
	private static String Green_Alert = putil.getEnvironmentProperty("Green_Alert");
	private static String fiveDay_Alert = putil.getEnvironmentProperty("fiveDay_Alert");
	private static String tenDay_Alert = putil.getEnvironmentProperty("tenDay_Alert");
	private static String Subsequent_Materials_Alert = putil.getEnvironmentProperty("Subsequent_Materials_Alert");
	private static String transfer_Alert = putil.getEnvironmentProperty("transfer_Alert");
	private static String Material_DISPOSITION_Creation_Alert = putil.getEnvironmentProperty("Material_DISPOSITION_Creation_Alert");
	private static String Material_DISPOSITION_Authorization_Alert = putil.getEnvironmentProperty("Material_DISPOSITION_Authorization_Alert");
	private static String Delivery_Date_Alert = putil.getEnvironmentProperty("Delivery_Date_Alert");
	private static String Callout_Alert = putil.getEnvironmentProperty("Callout_Alert");
	private static String MaterialTransfer_Alert = putil.getEnvironmentProperty("MaterialTransfer_Alert");
	public static String Offshore_Flag = putil.getEnvironmentProperty("Offshore_Flag");
	public static String Submit = putil.getEnvironmentProperty("Submit");
	
	public static String Last_Name_value = ExcelUtils.getExcelData("Last_Name", "Add_User_Profile");
	public static String First_Name_value = ExcelUtils.getExcelData("First_Name", "Add_User_Profile");
	public static String Middle_Initial_value = ExcelUtils.getExcelData("Middle_Initial", "Add_User_Profile");
	public static String User_ID_value = ExcelUtils.getExcelData("User_ID", "Add_User_Profile");
	public static String Organization_value = ExcelUtils.getExcelData("Organization", "Add_User_Profile");
	public static String Address_Line1_value = ExcelUtils.getExcelData("Address_Line1", "Add_User_Profile");
	public static String Address_Line2_value = ExcelUtils.getExcelData("Address_Line2", "Add_User_Profile");
	public static String Telephone1_value = ExcelUtils.getExcelData("Telephone1", "Add_User_Profile");
	public static String Telephone2_value = ExcelUtils.getExcelData("Telephone2", "Add_User_Profile");
	public static String Telephone3_value = ExcelUtils.getExcelData("Telephone3", "Add_User_Profile");
	public static String Email_value = ExcelUtils.getExcelData("Email", "Add_User_Profile");
	public static String supervisorName_value = ExcelUtils.getExcelData("supervisorName", "Add_User_Profile");
	public static String supervisorEmail_value = ExcelUtils.getExcelData("supervisorEmail", "Add_User_Profile");
	public static String supervisorTelephone1_value = ExcelUtils.getExcelData("supervisorTelephone1", "Add_User_Profile");
	public static String supervisorTelephone2_value = ExcelUtils.getExcelData("supervisorTelephone2", "Add_User_Profile");
	public static String supervisorTelephone3_value = ExcelUtils.getExcelData("supervisorTelephone3", "Add_User_Profile");

	
	
	public static String strPath = lnk_Profile+":"+lastname+":"+First_Name+":"+Middle_Initial+":"+User_ID+":"+User_Role+":"+Organization+":"+Group+":"+Address_Line1+":"+Address_Line2+":"+City+":"+State+":"+Zip+":"+Telephone+":"+Pager+":"+Pin+":"+Cell+":"+Email+":"+Supervisor+":"+Green_Alert+":"+fiveDay_Alert+":"+tenDay_Alert+":"+Subsequent_Materials_Alert+":"+transfer_Alert+":"+Material_DISPOSITION_Creation_Alert+":"+Material_DISPOSITION_Authorization_Alert+":"+Delivery_Date_Alert+":"+Callout_Alert+":"+MaterialTransfer_Alert+":"+Offshore_Flag+":"+Submit;
	public static String grpstrPath = lastname+":"+First_Name+":"+Middle_Initial+":"+User_ID+":"+Organization+":"+Address_Line1+":"+Address_Line2+":"+Telephone1+":"+Telephone2+":"+Telephone3+":"+Email+":"+supervisorName+":"+supervisorEmail+":"+supervisorTelephone1+":"+supervisorTelephone2+":"+supervisorTelephone3;
	public static String grpstrvalue = Last_Name_value+":"+First_Name_value+":"+Middle_Initial_value+":"+User_ID_value+":"+Organization_value+":"+Address_Line1_value+":"+Address_Line2_value+":"+Telephone1_value+":"+Telephone2_value+":"+Telephone3_value+":"+Email_value+":"+supervisorName_value+":"+supervisorEmail_value+":"+supervisorTelephone1_value+":"+supervisorTelephone2_value+":"+supervisorTelephone3_value;
	
	

	
	
	public static WebElement LastName(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(lastname));
	   	 
	     return element;

	        }
	
	public static WebElement FirstName(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(First_Name));
	   	 
	   	 Log.info("First Name field Found");

	        return element;

	        }
	
	public static WebElement MiddleInitial(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Middle_Initial));
	   	 
	   	 Log.info("Middle Initial field Found");

	        return element;

	        }
	
	public static WebElement UserID(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(User_ID));
	   	 
	   	 Log.info("User ID field Found");

	        return element;

	        }
	
	public static WebElement UserRole(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(User_Role));
	   	 
	   	 Log.info("User Role field Found");

	        return element;

	        }

	
	public static WebElement Organization(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Organization));
	   	 
	   	 Log.info("Organization field Found");

	        return element;

	        }
	
	public static WebElement Group(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Group));
	   	 
	   	 Log.info("Group field Found");

	        return element;

	        }
	
	public static WebElement AddressLine1(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Address_Line1));
	   	 
	   	 Log.info("Address Line 1 field Found");

	        return element;

	        }
	
	public static WebElement AddressLine2(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Address_Line2));
	   	 
	   	 Log.info("Address Line 2 field Found");

	        return element;

	        }
	
	public static WebElement City(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(City));
	   	 
	   	 Log.info("City field Found");

	        return element;

	        }
	
	public static WebElement State(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(State));
	   	 
	   	 Log.info("State field Found");

	        return element;

	        }
	
	public static WebElement Zip(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Zip));
	   	 
	   	 Log.info("Zip field Found");

	        return element;

	        }

	
	public static WebElement Telephone(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Telephone));
	   	 
	   	 Log.info("Telephone field Found");

	        return element;

	        }
	public static WebElement Telephone1(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Telephone1));
	   	 
	   	 Log.info("Telephone field Found");

	        return element;

	        }
	public static WebElement Telephone2(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Telephone2));
	   	 
	   	 Log.info("Telephone field Found");

	        return element;

	        }
	public static WebElement Telephone3(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Telephone3));
	   	 
	   	 Log.info("Telephone field Found");

	        return element;

	        }
	public static WebElement Pager(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Pager));
	   	 
	   	 Log.info("Pager field Found");

	        return element;

	        }

	
	public static WebElement Pin(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Pin));
	   	 
	   	 Log.info("Pin field Found");

	        return element;

	        }

	
	public static WebElement Cell(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Cell));
	   	 
	   	 Log.info("Cell field Found");

	        return element;

	        }

	
	public static WebElement Email(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Email));
	   	 
	   	 Log.info("E-mail field Found");

	        return element;

	        }
	
	public static WebElement Supervisor(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Supervisor));
	   	 
	   	 Log.info("Supervisor field Found");

	        return element;

	        }
	public static WebElement supervisorName(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(supervisorName));
	   	 
	   	 Log.info("Supervisor field Found");

	        return element;

	        }
	public static WebElement supervisorTelephone1(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(supervisorTelephone1));
	   	 
	   	 Log.info("supervisorTelephone1 field Found");

	        return element;

	        }
	public static WebElement supervisorTelephone2(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(supervisorTelephone2));
	   	 
	   	 Log.info("supervisorTelephone2 field Found");

	        return element;

	        }
	public static WebElement supervisorTelephone3(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(supervisorTelephone3));
	   	 
	   	 Log.info("supervisorTelephone3 field Found");

	        return element;

	        }
	public static WebElement supervisorEmail(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(supervisorEmail));
	   	 
	   	 Log.info("supervisorEmail field Found");

	        return element;

	        }
	public static WebElement GreenAlert(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Green_Alert));
	   	 
	   	 Log.info("Green Alert field Found");

	        return element;

	        }
	
	public static WebElement fiveDayAlert(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(fiveDay_Alert));
	   	 
	   	 Log.info("5-Day Alert field Found");

	        return element;

	        }
	
	public static WebElement tenDayAlert(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(tenDay_Alert));
	   	 
	   	 Log.info("10-Day Alert field Found");

	        return element;

	        }
	
	public static WebElement SubsequentMaterialsAlert(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Subsequent_Materials_Alert));
	   	 
	   	 Log.info("Subsequent Materials Alert field Found");

	        return element;

	        }
	
	public static WebElement transferAlert(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(transfer_Alert));
	   	 
	   	 Log.info("transfer Alert field Found");

	        return element;

	        }
	
	public static WebElement MaterialDISPOSITIONCreationAlert(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Material_DISPOSITION_Creation_Alert));
	   	 
	   	 Log.info("Material DISPOSITION Creation Alert field Found");

	        return element;

	        }
	
	public static WebElement MaterialDISPOSITIONAuthorizationAlert(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Material_DISPOSITION_Authorization_Alert));
	   	 
	   	 Log.info("Material DISPOSITION Authorization Alert field Found");

	        return element;

	        }
	public static WebElement DeliveryDateAlert(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Delivery_Date_Alert));
	   	 
	   	 Log.info("Delivery Date Alert field Found");

	        return element;

	        }
	public static WebElement CalloutAlert(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(Callout_Alert));
	   	 
	   	 Log.info("Callout Alert field Found");

	        return element;

	        }
	public static WebElement MaterialTransferAlert(WebDriver driver){
		 
	   	 element = driver.findElement(By.xpath(MaterialTransfer_Alert));
	   	 
	   	 Log.info("MaterialTransfer Alert field Found");

	        return element;

	        }
	
}