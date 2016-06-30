package com.verizon.cao.selenium.common.ObjectRepository;

public interface EndUser {
	
//Login As New User
//"//input[@value='3']";
//"//span[text()='Save Business Group']";
	
//Login Validation
public static final String clk_bg = "//a[@id='curBG']";
public static final String clk_ves_bg = "//li/a[text()=";
public static final String chk_con_label = "//h2[text() ='Content']";
public static final String left_content = "//h2[text() ='Content']//following-sibling::div[@id ='yVmenu']//ul";
public static final String chk_tool_label = "//h2[text() ='Tools']";
public static final String left_tools = "//h2[text() ='Tools']//following-sibling::div[@id ='toolsMenu']//ul//li";
public static final String right_hand_side = "//aside[contains(@class,'rightCol')]//section//h1";
public static final String red_tool_menu = "//div[@id='yHmenu']//ul[@class='first-of-type']//li//a";

//My Feed Objects
public static final String chk_myfeed_filter = "//*[@id='feedType']";
public static final String chk_myfeed_list_filter = "//div[@id='feedTypeList']//a";
public static final String chk_noupdate = "//*[@id='loadAgain']/section/div[3]/div";
public static final String chk_myfeed = "//section//div[@class='feedStream indexacc']//div[@class='feed']";
//public static final String chk_myfeed_gear = "//section//div[@class='feedStream indexacc']//div[@class='feed']//following-sibling::div[@class='dd']";
public static final String chk_myfeed_gear = "//div[@class='feedInfo']//div[@class='dd']//a[@class='drop']";
//public static final String chk_myfeed_gear_details = "//section//div[@class='feedStream indexacc']//div[@class='feed']//following-sibling::div[@class='dd']//div[@class='items last']//a";
//public static final String chk_myfeed_gear_details = "//div[@class='feedInfo']//div[@class='dd']//div[contains(@class,items)]//a";
public static final String chk_myfeed_gear_details = "//div[@class='feedStream indexacc']/div/div[1]//div[contains(@class,'items')]/a";
public static final String select_feed_filter = "//*[@id='feedTypeList']//a[text()=";
public static final String feed_content_title = "//div[@class='feedStream indexacc']/div/div[1]//div[@class='link']/a";
public static final String feed_content_no = "//div[@class='feedStream indexacc']/div/div[1]//div[@class='link']/p";

//News Feed
public static final String chk_news_feed = "//div[@id='alertmain']";
public static final String chk_news_title = "//div[@id='alertmain']//a[@title]";
public static final String chk_news_read_more = "//div[@id='alertmain']//span//a[text()]";


//Taxonomy
public static final String clk_taxonomy = "//h2[text() ='Content']//following-sibling::div[@id ='yVmenu']//ul//a[text()='Taxonomy']"; //clk taxonomy
public static final String clk_first_taxonomy = "//div[@id='yVmenu']//li[1][@index='0']//a";
public static final String clk_first_tax_topic = "//div[@id='yVmenu']//li[1][@index='0']//li[1]//a";
public static final String clk_network_taxonomy = "//ul//a[text()='Metrics & Reporting']";
public static final String chk_actions = "//div[@class='sortingHead']//span[@class='actions1']"; //Actions
//public static final String chk_title = "//div[@class='sortingHead']//a[@id='divSortClass_1']"; //Title
public static final String chk_head_title = "//a[contains(text(),'Title')]";
//public static final String chk_modified_date =  "//div[@class='sortingHead']//a[@id='divSortClassDate_1']"; //Modified Date
public static final String chk_head_mod_date = "//a[contains(text(),'Modified Date')]";
public static final String clk_drop_actions = "//div[@id='divSort_1']//ul//li//a[contains(@class,'actions')]"; //clk action drop
public static final String clk_drop_actions1 = "//div[@id='divSort_2']//ul//li//a[contains(@class,'actions')]"; //clk action drop
public static final String get_first_con_title = "//div[@id='divSort_1']//span[@id='document']";
public static final String chk_gear_type = "//*[@id='divSortul_1']//li//div//div//div//a"; //get action gear detail
public static final String chk_gear_type_2 = "//*[@id='divSortul_2']//li[1]//div[contains(@class,'items_content_listing')]//a";
public static final String get_con_title = "//div[@class='document-header']//a[@class='title']";
public static final String tax_search_result = "//div[@id='search-results']";
public static final String tax_nosearch_result = "//div[@class='no-results']";
public static final String tax_find_box = "//input[@id='tpquery']"; //search
public static final String tax_clk_find = "//a[@title='Find']"; //clk find button
public static final String tax_chk_result = "//div[@id='viv-main']";
public static final String close_email = "//header[@id='globalHeader']//div/div[@class='hlinks']//a"; //close

//Feedback
public static final String clk_feedback = "//a[contains(@title,'VZKnowledge Feedback')]";
public static final String chk_feedback_category = "//select[@id='feedbackSelect']"; //select category
public static final String chk_feedback_type = "//select[@id='feedbackAbout']"; //select
public static final String feedback_your_name = "//div[@class='fieldObj'][1]//label[@class='text']"; //your name
public static final String feedback_your_mail = "//div[@class='fieldObj'][2]//label[@class='text']";  //Your Email
public static final String feedback_content_before = "//input[@id='contactedBefore']"; //Content Before
public static final String feedback_urgent = "//input[@id='urgent']"; //Urgent
public static final String feedback_comment_box = "//textarea[@id='question']"; //feedback question
public static final String close_feedback = "//header[@id='globalHeader']//div/div[@class='hlinks']//a"; //close
public static final String clk_feedback_submit = "//span[contains(text(),'Submit')]";
public static final String feedback_success_msg = "//div[@id='success']//h1";

//Bookmark
//*[@id='leftnav']/div[2]/section[2]/div/a/span - Add Bookmark
public static final String mouse_bookmark = "//li//a[text()='Bookmarks']";
public static final String search_bookmark = "//li//a[text()='Bookmarks']//following-sibling::div//input[@id = 'stext']";
public static final String search_result_bookmark = "//div[@id='mybmrkSearch']//following-sibling::a[contains(text(),";
public static final String close_result_bookmark = "//header[@id='globalHeader']//a[@class='button close']";
public static final String close_bookmark = "//div[@id='closeDiv']//a"; //close
public static final String manage_bookmark = "//ul[@id='leftNavTree']//img";
public static final String manage_bookmark_tree = "//ul[@id='leftNavTree']//ul//a";
public static final String manage_first_tree = "//ul[@id='leftNavTree']/li[1]/img";
//public static final String manage_second_tree = "//ul[@id='leftNavTree']/li[1]/ul/li[2]/img";
public static final String manage_second_tree = "//ul[@id='leftNavTree']/li[1]/ul/li//a[contains(text(),'";
public static final String manage_clk_title = "//ul[@id='leftNavTree']//ul//a[contains(text(),";
public static final String my_bookmark_search = "//a[contains(text(),'My Bookmarks')]//following-sibling::div//a[contains(text(),";
public static final String my_bookmark_search_clk = "//a[contains(text(),'My Bookmarks')]//following-sibling::div//a[text()=";

//Bookmark - Window

public static final String create_new_folder = "//a[@title='Create New Folder']";
public static final String newfolder_msg = "//h3[@id='newfolder']";
public static final String clk_vzk_bookmark = "//a[@id='1']";
public static final String clk_addbt_bookmark = "//span[text()='Add']";
public static final String enter_folder_name = "//input[@id='1_folder']";
public static final String clk_add_a_folder = "//span[contains(text(),'Add a Folder')]";
public static final String edit_bookmark_title = "//input[@id='bookmarkTitle']";
public static final String desc_bookmark = "//textarea[@id='bkDescription']";
public static final String add_bookmark = "//a[@title='Add Bookmark']";
public static final String save_msg_bookmark = "//div[@id='msg']/p";
public static final String clk_ok_bookmark = "//div[@id='msg']/a[@title='OK']";
public static final String my_book_mark = "//a[contains(text(),'My Bookmarks')]";

//Messages
public static final String clk_message = "//a[text()='Messages']";

//Content Details
public static final String clk_first_content = "//ul[@id='divSortul_1']//li[1]//span[@id='document']";
public static final String clk_next_content = "//ul[@id='divSortul_2']//li[1]//span[@id='document']";
public static final String chk_content_type = "//ul[@id='divSortul_1']/li[1]/div[2]/a/img";
public static final String chk_breadcrumb = ".//*[@id='breadcrumb']";
public static final String chk_search_con = "//input[@id='search_field']";
public static final String clk_content_gear = "//div[@class='items items_content']";
public static final String chk_content_owner = "//section[@id='content_listing']//p[1]";
public static final String chk_content_modified = "//section[@id='content_listing']//p[@class]";
public static final String chk_content_rate = "//section[@id='content_listing']//span[text()='Rate']";
public static final String chk_content_comment = "//textarea[@id='newcommenttext']";
public static final String chk_content_submit = "//div[@id='myComments']//span[text()='Submit']";
public static final String clk_content_expand = "//div[@class='expandable_header expandable_closed']";
public static final String chk_content_expand= "//div[@class='expandable_content']//tbody";
public static final String chk_comment_msg = "//div[@id='divErrorMsg1']";

//Reference
public static final String mouse_reference = "//li//a[text()='Reference']";
public static final String clk_reference_serach = "//li//a[text()='Reference']//following-sibling::div//input[@id='stext']";
public static final String clk_reference_serach_result = "//div[@id='refSearch']//following-sibling::a[contains(text(),";
public static final String chk_reference_tab_external = "//li//a[contains(text(),'External Sites')]";
public static final String chk_reference_tab_verizon = "//li//a[contains(text(),'Verizon Sites')]";
public static final String chk_ref_external_link = "//li//a[contains(text(),'External Sites')]//following-sibling::div//li";
public static final String chk_ref_verizon_link = "//li//a[contains(text(),'Verizon Sites')]//following-sibling::div//li";

//Training
public static final String mouse_training = "//div[@id='yHmenu']//li//a[text()='Training']";
public static final String clk_training_search = "//li//a[text()='Training']//following-sibling::div//input[@id='stext']";
public static final String clk_training_search_result = "//div[@id='trLinksSearch']//following-sibling::a[contains(text(),";
public static final String mouse_vzknowledge = "//li//a[text()='Training']//following-sibling::div//li//a[contains(text(),'VZKnowledge')]";
public static final String mouse_training_modules = "//a[contains(text(),'VZKnowledge')]//following-sibling::div//a[contains(text(),'Training Modules')]";

//eGlossary
public static final String clk_glossary = "//div[@id='toolsMenu']//a[text()='eGlossary']";
public static final String chk_glossary_category = "//select[@id='CATEGORY_SELECTED']";
public static final String chk_search_glossary = "//input[@id='searchName']";
public static final String find_glossary = "//a[@id='findbutton']";
public static final String glossary_list_k = "//a[@id='but_K']";
public static final String chk_glossary_list = "//div[@id='tip_links_a']//h3";
public static final String chk_glossary_noitems = "//td[text()='No items match your search']";
public static final String chk_glossary_didyou = "//span[text()='Did you mean:']";
public static final String glossary_res_filter = "//div[@class='glossary_header'][text()='Telnet']";
public static final String glossary_header = "//tr[1]//td[1]//div[@class='glossary_header']";

//Trending
public static final String clk_trending = "//div[@id='yHmenu']//li//a[text()='Trending']";
public static final String chk_trending_section = "//section[@id='trending']";
public static final String chk_all_article = "//section[@id='trending']//article";
public static final String mouse_trending = "//a[text()='Trending']";
public static final String mouse_trending_sections = "//a[text()='";
public static final String clk_trend_action = "//section[@id='trending']//article[1]//li[1]//a[@class='drop actions']";

//News
public static final String clk_authoring = "//div[@id='toolsMenu']//a[text()='Authoring']";
public static final String clk_authoring_news = "//a[text()='News']";
public static final String clk_authoring_create = "//div[@id='mainNav']//a[text()='Create']";
public static final String clk_authoring_all = "//input[@id='alldiv']";
public static final String clk_authoring_continue = "//a[@title='Continue']";
public static final String authoring_news_title = "//textarea[@id='dDocTitle']";
public static final String authoring_news_desc = "//textarea[@id='xDescription']";
public static final String auth_news_desc = "//input[@id='xDescription']";
public static final String authoring_break_yes = "//select[@id='xIsBreakingNews']";
public static final String authoring_effect_date = "//input[@id='xEffectiveDate']";
public static final String authoring_valid_date = "//input[@id='xValidityPeriod']";
public static final String authoring_body_desc = "//body";
public static final String authoring_save_news = "//a[@title='save']";
public static final String sel_authoring_news_title = "//input[@title=";
public static final String authoring_news_publish = "//div[@id='mainNav']//a[text()='Publish']";
public static final String authoring_wait_elem = "//a[text()='Legal Notice']";
public static final String authoring_set_date = "//*[@id='datepick-div']//table//a[text()=";
public static final String authoring_clk_next = "//*[@id='datepick-div']//a[text()='Next']";
public static final String authoring_frame = "//iframe[@class='cke_wysiwyg_frame cke_reset']";
public static final String authoring_msg_success = "//div[@id='divErrorTag']//tr[1]//td";
public static final String authoring_goto = "//div[@id='divErrorTag']//font[text()='Goto Folder']";
public static final String auth_set_bgroup = "//select[@id='business']";

//News Validation
public static String clk_news = "//div[@id='toolsMenu']//a[text()='News']";
public static String newly_created_news = "//div[@class='news']//a[contains(text(),";
public static String chk_news_section = "//section[@id='newstree']";
public static String chk_news_slide = "//section[@id='home_slide']/a";

//Checking Around Verizon
public static final String clk_around_nav = "//span[@id='pgl";
public static final String get_around_title = "//table[@id='resultstab']/tbody/tr[2]/td/h3";

//Profile Page 
public static final String profile_name = "//div[@id='vz-user-menu-name']/span/a";
public static final String profile_chk_name = "//div[@id='vz-user-menu-dropdown']/span";
public static final String myprofile_chk = "//a[contains(text(),'My Profile')]";
public static final String profile_signout = "//a[contains(text(),'Sign out')]";
public static final String preset_profile = "//span[contains(text(),'SELECT FROM A PRESET PROFILE')]";
public static final String custom_profile = "//span[contains(text(),'CREATE A CUSTOM PROFILE')]";
public static final String welcome_msg = "//p[contains(text(),'Welcome to VZ Knowledge')]";

//Custom Profile
public static final String custom_current_profile = "//a//span[text()='Current Profile']";
public static final String custom_role = "//a//span[text()='Role']";
public static final String custom_region = "//a//span[text()='Region']";
public static final String custom_selection = "//a//span[text()='Current Selection']";
// Role - [ 'All', 'Customer Inquiry and Conferencing','ETMS Support','Global Operations - Bill & Inquire','Global Operations - Business Ops','Global Operations - Engineer','Global Operations - Implement','Global Operations - Manage & Repair'
//'Global Operations - Provision (Ordering)','Global Operations - Service','Global Operations - Solution','Global Platform - Cloud Data Center','Global Platform - Cloudswitch','Global Platform - Connected Solutions'
//'Global Platform - GCIS','Global Platform - Health Care','Global Platform - Security Solutions','Global Platform - Telematics','Marketing','OH&S','Service Delivery Architecture','VZK DEV','Wholesale' ]
// Region - [ 'All', 'AsiaPac' ,'Canada', 'EMEA', 'Global', 'LatAm', 'US' ]
public static final String[] select_custom_role = {"Global Operations - Business Ops"};
public static final String[] select_custom_region = {"All"};
public static final String custom_role_obj = "//input[@value=";
public static final String custom_region_obj = "//input[@value=";
public static final String close_continue_page = "//div[@id='cboxClose']/span";
public static final String clk_save_continue = "//span[text()='Save and Continue to VZKnowledge']";
public static final String clk_continue_page = "//span[text()='Continue to Homepage']";
public static final String chk_profile_items = "//li[contains(text(),";
public static final String clk_role = "//a[@id='curRole']";
public static final String chk_role_items = "//div[@id='roleDropDown']//li//a[contains(text(),";
public static final String clk_customize_subs = "//span[contains(text(),'Customize Your Subscription')]";

//Contacts
public static final String clk_contacts = "//div[@id='toolsMenu']//a[text()='Contacts']";
public static final String chk_category = "//th[text()='Category']";
public static final String clk_add_contact = "//span[contains(text(),'Add a Contact')]";
public static final String contact_name = "//input[@id='txtFName']";
public static final String contact_email = "//input[@id='txtEmail']";
public static final String contact_phone = "//input[@id='txtPhone']";
public static final String sel_contact_category = "//span[@id='ddcl-ddlCategory']";
public static final String clk_contact_category = "//label[text()=";
public static final String contact_detail = "//input[@id='txtComments']";
public static final String save_contact = "//span[contains(text(),'Save Contact')]";
public static final String chk_contact_name = "//tr[@id='node-1']//td[2]";
public static final String contact_hours = "//input[@id='hours']";
public static final String contact_search_box = "//input[@id='txtDocName']";
public static final String clk_contact_find = "//span[text()='Find']";
public static final String chk_noup_contact = "//tbody[@id='data']/tr/td";

//Calender
public static final String clk_calender = "//div[@id='toolsMenu']//a[text()='Calendar']";
public static final String clk_cal_category = "//span[@id='ddcl-calCategory']";
public static final String sel_cal_category = "//label[contains(text(),'Seminar')]";
public static final String clk_cal_alleve = "//div[@id='calendarHome']//span[text()='All Events']";
public static final String clk_cal_internal = "//div[@id='calendarHome']//span[text()='Internal']";
public static final String clk_cal_external = "//div[@id='calendarHome']//span[text()='External']";
public static final String chk_noup_external = "//section[@id='external']/article/table/tbody/tr[2]/td[text()]";
public static final String chk_noup_internal = "//section[@id='internal']/article/table/tbody/tr[2]/td";
public static final String chk_noup_alleve = "//section[@id='alleve']/article/table/tbody/tr[2]/td";
public static final String chk_cal_title_alleve = "//section[@id='alleve']/article/table/tbody/tr[2]/td[1]/a";
public static final String chk_cal_title_int = "//section[@id='internal']/article/table/tbody/tr[2]/td[1]/a";
public static final String chk_cal_title_ext = "//section[@id='external']/article/table/tbody/tr[2]/td[1]/a";
public static final String calender_title = "//tr[@id='node-1']/td[2]";
public static final String calender_noup = "//tbody[@id='data']/tr/td";

//Checking Profile
public static final String chk_profile_page = "//section[@id='container']/form/section/section[1]/p[text()]";
public static final String chk_subscriptions = "//input[@id='Subscriptions']";

//FAQ
public static final String clk_faq = "//div[@id='toolsMenu']//a[text()='FAQ']";
public static final String sel_faq_category = "//span[@id='ddcl-CATEGORY_SELECTED']";
public static final String faq_search = "//input[@id='txtDocName']";
public static final String faq_validate_category = "//tr[@id='node-1']/td[3]";
public static final String faq_plus_minus = "//tr[@id='node-1']//td[1]//span";
public static final String faq_expand_text = "//tr[@id='node-1-1']";
public static final String faq_toggle = "//a[@id='expand_toggle']";
//"//label[text()='VzKnowledge']";

//Communication Hub
public static final String clk_communication = "//div[@id='toolsMenu']//a[text()='Communication Hub']";
public static final String get_first_content_type = "//form[@id='hubForm']//tr[21]//td[1]";
public static final String get_content_unread_count = "//form[@id='hubForm']//tr[21]//td[2]";
public static final String chk_loading_img = "//div[@id='loadingImage']";
public static final String clk_first_content_title = "//ul[@id='divSortul_1']//li[1]//div[2]//a//span";
public static final String communication_wait = "//form[@id='hubForm']";

//Help
public static final String clk_help = "//a[contains(@title,'VZKnowledge Help')]";
public static final String clk_help_url = "//a[text()='http://helpdesk.verizon.com']";

//Alerts
public static final String clk_alerts = "//div[@class='alertsbtn']//a[text()='Alerts']";
public static final String alert_unread_count = "//div[@id='flashalerts']//div[1]//div";
public static final String clk_recent_alert = "//span[contains(text(),'Recent Alerts')]";
public static final String clk_system_alert = "//span[contains(text(),'System')]";
public static final String clk_alert_type = "//span[@id='ddcl-typeDrop']";
public static final String alert_no_update = "//table[@id='datatable_sort']//tbody//tr//td";
public static final String alert_type = "//tr[@id='node-0']//td[3]";
public static final String alert_title = "//tr[@id='node-0']//td[6]//a";
public static final String alert_submit = "//span[text()='Submit']";
public static final String alert_close = "//span[text()='Close']";

//Access Request
public static final String clk_enduser_req = "//a[contains(text(),'End User')]";
public static final String clk_end_req = "//a[text()='End User']";
public static final String clk_req_role = "//input[@values=";
public static final String clk_access_close = "//div[@id='cboxClose']";
public static final String clk_role_request = "//a[@id='request_endaccess']";
public static final String clk_access_finish = "//a[@id='request_endfinish']";
public static final String clk_home = "//section[@id='breadcrumb']//a[text()='Home']";
public static final String clk_access_request = "//span[@id='profileRequests']";
public static final String access_table = "//div[@id='profileRequestsSubtabsList']//tbody//tr";
public static final String access_plus = "//div[@class='expandable_header expandable_closed']";
public static final String access_role = "//div[@class='expandable_content']//input";
public static final String access_from_name = "//tbody//tr//a[contains(text(),";
public static final String access_approve = "//span[text()='Approve']";
public static final String access_ok = "//span[text()='OK']";

//Validate Access Request
public static final String role_list_count = "//div[@id='roleDropDown']//ul//li";
public static final String find_role_name = "//li//a[text()=";

//Admin Feedback
public static final String clk_feedback_tab = "//span[@id='feedbacks']";
public static final String clk_feedback_inbox = "//label[@id='inbox']";
public static final String clk_feedback_close = "//a[@id='closedTab']";////a[@id='closedTab'] ////label[@id='closed']
public static final String chk_feedback_cmt = "//tbody//tr[1]//td[4]";
public static final String clk_feedback_reply = "//tbody//tr[1]//td[7]//a";
public static final String chk_feedback_close_cmt = "//div[@id='feedbackSubtabsListClosed']//tbody//tr[1]//td[3]";
public static final String feedback_response = "//textarea[@id='TextBox2']";
public static final String feedback_reason = "//textarea[@id='reason']";
public static final String feedback_close = "//a[@title='Close Feedback']";
public static final String feedback_reply = "//a[@title='Reply']";
public static final String feedback_reroute = "//a[@title='Reroute']";
public static final String feedback_reply_close = "//a[@title='Reply & Close Feedback']";
public static final String feedback_close_window = "//div[@id='cboxClose']";
public static final String chk_feedback_open = "//div[contains(text(),'Open')]";

//Author Feedback
public static final String chk_user_content = "//div[@class='feedTxt']//a[contains(text(),'";
public static final String chk_user_content_gear = "//following-sibling::div//a[@class='drop']";
public static final String clk_gear_feedback = "//following-sibling::div//a[text()='Feedback']";
public static final String message_total_page = "//span[@id='totalnoPages1']";
public static final String message_inbox_next = "//div[@id='next1']//span[text()='NEXT']";
public static final String message_close_next = "//div[@id='next2']//span[text()='NEXT']";
public static final String author_feedback_cmt = "//tbody//tr//td[text()='";
public static final String feedback_action_detail = "//following-sibling::td//a[contains(text(),'View Details')]";
public static final String feedback_reply_detail = "//following-sibling::td//a[contains(text(),'Reply 2')]";

//Basic Search
public static final String enter_search = "//input[@id='SearchEverything']";
public static final String clk_search_vzk = "//a[@title='Search VZKnowledge']";
public static final String clk_search_all = "//input[@id='SearchAll']";
public static final String clk_search_vzk1 = "//a[@title='Search VZKnowledge1']";
//"//div[@id='searchOverlayFull']//div[contains(@class,'suggest_link')]";
public static final String chk_auto_search = "//div[@id='searchOverlayFull']//div[contains(@id,'acSearch')]/div";
public static final String search_loading_img = "//div[@id='loading']/img";
public static final String search_noresult = "//div[@id='document-list']/div/p";
public static final String search_result = "//ol[@class='results']";
public static final String search_total_count = "//div[@id='search-details']/strong[3]";
public static final String sel_search_within = "//span[@id='ddcl-searchWith']";
public static final String sel_search_bg = "//div[@id='ddcl-searchWith-ddw']//label[text()='Your Business Group']";
public static final String sel_search_all = "//div[@id='ddcl-searchWith-ddw']//label[text()='All VZKnowledge']";
public static final String sel_search_histroy = "//span[@id='ddcl-qryhistory']";
public static final String search_his_item = "//div[@id='ddcl-qryhistory-ddw']//label[text()=";

}
