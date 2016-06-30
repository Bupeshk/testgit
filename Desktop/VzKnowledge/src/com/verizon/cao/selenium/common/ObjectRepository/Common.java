package com.verizon.cao.selenium.common.ObjectRepository;

public interface Common {
	
	public static final String HubUrl = "http://114.9.152.53:4444/wd/hub";
	public static final String attributeName_classname = "classname";
	public static final String attributeName_cssselector = "cssselector";
	public static final String attributeName_id = "id";
	public static final String attributeName_linktext = "linktext";
	public static final String attributeName_name = "name";
	public static final String attributeName_partiallinktext = "partiallinktext";
	public static final String attributeName_tagname = "tagname";
	public static final String attributeName_xpath = "xpath";
	
    static final String BaseUrl = "http://knowledge.ebiz.verizon.com/vzknowledge/home.portal";
    static final String ExtranetBaseUrl = "https://www98.verizon.com/kms/vzknowledge";
    
		public static final String userID = "//input[@id='USERID' or @id='username']";
		public static final String passWord = "//input[@id='PASSWORD' or @id='password']";
		//public static final String signOn = "//a[@title = 'Sign-On']";
		public static final String signOn = "//span[text() = 'Sign-On' or text()='Login']";
		
		public static final String tools_menu = "//div[@id = 'toolsMenu']";
		public static final String globalNav_links ="//header[@id='globalHeader']//ul//li//a[text() = '";
		public static final String leftNav_links_starts ="//li[@id='adminLnk']/a[text() = '";
		public static final String Nav_links_ends ="']";
}
