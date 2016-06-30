package com.verizon.cao.selenium.common;

import com.verizon.cao.selenium.common.ObjectRepository.Admin;

public class ApplicationConstants {
	//public static final String REPORT_PATH = "C:\\selenium\\workspace\\VzKnowledge\\report";
	public static final String REPORT_PATH = "./report";
	static final String SELENIUM_HUB_URL = "http://localhost:4444/wd/hub";
	//static final String SCREENSHOT_PATH = "C:\\selenium\\workspace\\VzKnowledge\\report\\ScreenShots";
	static final String SCREENSHOT_PATH = "./report/ScreenShots";
	public static final String[] BusinessGroup_Table_Headers = {"Name","Display Name","Description","Groups","Status","Actions"};
	public static final String UserName = "CHELLME";
	public static final String Password = "Ponchellam14@";
	public static final String leftNavLinks = "Admin";

	public static final String Manage_Business_group_Name ="undefined";
	public static final String BizGroups_Display_Name = "Test";
	public static final String BizGroups_Discription = "For Test";
	public static final String BizGroups_Status = "Active";
	public static final String BizGroups_AvaialbleGroups = "Feedback";
	public static final String BizGroups_AdminRoles = "Access Admin";
	public static final String BizGroups_AuthorRoles = "Alert Author";
	public static final String BizGroups_Sub_AdminRoles = "Manage Content Types";
	public static final String BizGroups_Sub_AuthorRoles = "Alerts";
	public static final String BizGroups_TabManageSystemRoles = "Manage System Roles";

	//manage default subscriptions
	public static final String RoleSubscriptions = "Collections,Global Operations - Service,Active,Editor";
	public static final String RegionSubscriptions = "All,US";
	public static final String RoleSubscriptions1 = "Collections,Global Operations - Service";

	//Manage Global Reviewers
	public static final String[] GlobalReviewers_Table_Headers = {"Name","Email","Action"};


	//Manage Meta types
	public static final String[] MetaType_Table_Headers = {"Name","Description","Is Hierarchical","Has Profile","Can Subscribe","Actions"};
	public  static final String MetaTypeName = "Test1243";
	public  static final String MetaTypeDesc = "For Test1243";


	//Manage WorkFlow Groups
	public static final String[] WorkFlowGroups_Table_Headers = {"Name","Description","Created Date","Modified Date","Status","Actions"};
	public static final String 	Actions_links = "Edit,MakeInactive,Delete";
	public static final String  FlowGroupName = "editor dev";
	public static final String  MakeInActive ="MakeInactive";
	public static final String 	MakeActive ="MakeActive";
	public static final String AddNewGroupDetails = "test12332:test123324:Active:Editor:Das, Udayanand X";
	public static final String NewGroupDesc = "test123324";


	//Manage Preset Roles
	public static final String[] PresetRoles_Table_Headers = {"Preset Role Name","Description","Actions"};
	public static final String Preset_Action_links = "Edit,Delete";
	public static final String PresetRole_Name = "New_PreSet";
	public static final String PresetRole_Desc = "New_PreSet_For_Test";
	public static final String PresetRole_Metadata = "Global Operations - Bill & Inquire";
	public static final String PresetRegion_Metadata = "All";


	//Manage Profile settings
	public static final String[] Profile_Settings_Table_Headers = {"Feature Name","Feature Display Name","Is Dropdown","Feature Value","Action"};

	//Manage SiteLayout
	public static final String[] SiteLayout_Table_Headers = {"Name","Description","Status","Is External","Is Internal","Display order","Actions"};

	//Query groups
	public static final String[] QueryGroups_Table_Headers = {"Name","Description","Query","Status","Actions"};
	public static final String QueryGroups_Name = "NewQueryName";
	public static final String QueryGroups_Desc = "NewQueryDesc";
	public static final String QueryGroups_Query = "NewQuery";
	public static final String QueryGroups_Status = "Active";
	public static final String  QueryGroups_GroupName ="APCCC";
	public static final String  QueryGroups_MakeInActive ="Make Inactive";
	public static final String QueryGroups_MakeActive ="Make Active";

	//Manage Users 
	public static final String[] Users_Table_Headers =  {"Name","Email","Enterprise ID","Status","Action"};
	//Manage Users Groups
	public static final String[] UsersGroups_Table_Headers =  {"Name","Description","Created By","Created Date","Modified Date","Status","Actions"};
	public static final String UsersGroups_Name = "Asparagus";
	public static final String UsersGroups_Actions = "Edit,Make Inactive,Make Active"; 

	//Manage Super Admin
	public static final String[] SuperAdmin_Table_Headers =  {"Name","Email","Action"};
	public static final String SuperAdmin_EID =  "1951982319";

	//Manage SitLayout
	public static final String[] SitLayOut_Table_Headers =  {"Name","Description","Status","Is External","Is Internal","Display order","Actions"};
	//Manage Properties
	public static final String[] Properties_Table_Headers =  {"Name","Value","Description","Actions"};
	public static final String Properties_Name = "NewPropertyName";
	public static final String Properties_Value = "PropertyValue";
	public static final String Properties_Desc = "NewPropertyDesc";


	//Reports
	public static final String VisitorName = "McMahon, Chandra";
	public static final String ContentReadReport = "Content Read Report";


	//ContentRatingReportPage - CRR
	public static final String CRR_FILEPATH 	= "C:\\Users\\CHELLME\\Downloads\\vzk_SubmittedRatingUsers_Modified.xlsx";
	public static final String CRR_ColumnName 	= "User Name";
	public static final String CRR_SheetName 	= "Sheet1";

	//Broken Link Report  - BLR
	public static final String BLR_FILEPATH 	= "C:\\Users\\CHELLME\\Downloads\\vzk_brokenlinks.xlsx";
	public static final String BLR_ColumnName 	= "Broken URL";
	public static final String BLR_SheetName 	= "Sheet1";
	public static final String BLRCreatedDate_Between= "08/16/2014";
	public static final String BLRCreatedDate_To= "12/15/2015";

	//Chunking Report  - BLR
	public static final String CR_FILEPATH 		= "C:\\Users\\CHELLME\\Downloads\\vzk_chunkdetailedReport_Modified.xlsx";
	public static final String CR_ColumnName 	= "Title";
	public static final String CR_SheetName		= "Sheet1";










}
