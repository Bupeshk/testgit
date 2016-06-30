package page_object.Profile_Admin_TestCases;

import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class Administration_Page {

	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.ADMINISTRATION_FILEPATH);
	public static String Admin = putil.getEnvironmentProperty("Admin");
	public static String AssignExternalReportURL = putil.getEnvironmentProperty("AssignExternalReportURL");
	public static String AssignQualityAdministratorEmailAddress = putil.getEnvironmentProperty("AssignQualityAdministratorEmailAddress");
	public static String AssignReuseCoordinatorEmailAddress = putil.getEnvironmentProperty("AssignReuseCoordinatorEmailAddress");
	public static String VendorExpediteManagement = putil.getEnvironmentProperty("VendorExpediteManagement");
	public static String VendorContactMaintenance = putil.getEnvironmentProperty("VendorContactMaintenance");
	public static String DiscrepancyMaintenance = putil.getEnvironmentProperty("DiscrepancyMaintenance");
	public static String OrganizationAndGroupMaintenance = putil.getEnvironmentProperty("OrganizationAndGroupMaintenance");
	public static String LMVMaintenance = putil.getEnvironmentProperty("LMVMaintenance");
	public static String LMVRoutingMaintenance = putil.getEnvironmentProperty("LMVRoutingMaintenance");
	public static String HolidayMaintenance = putil.getEnvironmentProperty("HolidayMaintenance");
	public static String SplashPageMaintenance = putil.getEnvironmentProperty("SplashPageMaintenance");
	public static String MassUpdateTool = putil.getEnvironmentProperty("MassUpdateTool");
	public static String MassUpdateAdmin = putil.getEnvironmentProperty("MassUpdateAdmin");
	public static String MaterialStatusChange = putil.getEnvironmentProperty("MaterialStatusChange");
	
	public static String strPath = Admin+":"+AssignQualityAdministratorEmailAddress+":"+AssignReuseCoordinatorEmailAddress+":"+VendorExpediteManagement+":"+VendorContactMaintenance+":"+DiscrepancyMaintenance+":"+OrganizationAndGroupMaintenance+":"+LMVMaintenance+":"+HolidayMaintenance+":"+SplashPageMaintenance+":"+MassUpdateTool+":"+MassUpdateAdmin+":"+MaterialStatusChange;
	

}