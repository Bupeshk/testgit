package page_object.Profile_Admin_TestCases;

import utility.Profile_Admin_Constant;
import utility.PropertyUtility;

public class Organization_Group_Maintenance_Admin_Page {

	private static PropertyUtility  putil = new PropertyUtility(Profile_Admin_Constant.ORGANISATION_GROUP_MAINTENANCE_ADMIN_FILEPATH);
	public static String GroupMaintenance = putil.getEnvironmentProperty("GroupMaintenance");
	public static String OrganizationMaintenance = putil.getEnvironmentProperty("OrganizationMaintenance");
	
	public static String strPath = OrganizationMaintenance+":"+GroupMaintenance;

}