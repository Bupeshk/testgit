package com.verizon.cao.selenium.common;

public interface Constants {
	
	//Report Path
	static final String REPORT_PATH="./report";
	
	//Screen-Shot Pat
	static final String Screen_PATH="./report/Screenshots/";
	static final String Report_Screen_PATH="./Screenshots/";
	
	static final String TESTNGPATH = "testng.xml";
	
	//Login Existing User
	static final String Select_Bg = "Verizon Enterprise Solutions";
	static final String Network_Bg = "Finance";
	
	//static final String Select_Bg = "Network & Technology";
	static final String Username = "KUMARBU";
	static final String Password = "I@mdle@d";
	
	//EndUser Feedback
	static final String feedback_comment = "Automation VzKnowledge";
	
	//Network BG
	static final String network_taxonomy = "Metrics & Reporting";
	
	//News Authoring
	static final String News_title = "News-VES-06-01-2016";
	static final String News_desc = "This is end user Demo News";
	static final String News_message = "Test Automation for News Authoring Test case";
	static final String Role_access = "Global Operations - Service";  // For all - 'All'
	static final String Finance_Role_access = "Finance Transformation Org";
	static final String B_Role_access = "CFS Management";
	
	//Reference
	static final String ref_search = "Verizon Customer";
	static final String net_ref_link1 = "Business Groups";
	static final String net_ref_link2 = "Network & Technology homepage";
	
	//Contact
	static final String Contact_name = "Report";
	static final String Contact_email = "demo@verizon.com";
	static final String Contact_phone = "9874563210";
	static final String Contact_category = "Midwest";
	
	//Contact - Network BG
	static final String Network_name = "VZUserreport";
	static final String Network_email = "finance@verizon.com";
	static final String Network_phone = "9874563210";
	static final String Network_category = "Billing";
	
	//Network - Customize Profile
	//static final String Network_Bg = "AsiaPac Ntwk Ops";
	static final String[] network_custom_role = {"Bill to Cash"};
    static final String[] network_custom_region = {"All"};
    
    //Access Request
    static final String access_role_name = "Managed Security Services";
    static final String access_user_name = "Subramanain";
    static final String access_req_name = "Kumarg, Bupesh Kumar";
    static final String network_access_role = "Global Network Operations";
    
    //Calender
    static final String calender_title = "Calendar-Test-6-1-2016_12-1-13";
    
    //Admin & Author Feedback 
    static final String feedback_admin_eid = "0819225237";
    static final String feedback_author_eid = "1127119836"; //1127119836 //6498316705
    static final String feedback_eid_pass = "kms _force";
    static final String feedback_user = "SUBRRA9";
	static final String feedback_pass = "Shiva@85";
	static final String feedback_user_name = "Acar";
	static final String admin_feedback_cmt = "IE Feedback";
	static final String feedback_admin_reason = "IE Feedback Reason";
	static final String feedback_admin_response = "IE Feedback Response";
	static final String feedback_author_reason = "IE Author Reason";
	static final String feedback_author_response = "IE Author Response";
	static final String feedback_author_comment = "IE Author Feedback";
	
	//FAQ Select Category 
	static final String sel_faq_category = "VzKnowledge";
	
	//Basic Search
	static final String basic_search_con = "Fios tv";
	
	static final String SELENIUM_HUB_URL = "http://114.9.152.5:4444/wd/hub";
	
	}

