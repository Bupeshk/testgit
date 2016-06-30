package com.verizon.cao.selenium.common.ObjectRepository;


public interface Authoring {

	//######################################################################################################//
	//Authoring Home Page
	//######################################################################################################//
	public static final String lnkauthoring = "//li[@id='authoringLnk']//a";
	public static final String dropBG = "//*[@id='curBG']";
	public static final String lnkHome = "//*[@id='breadcrumb']";
	

	//######################################################################################################//
	//Authoring Dashboard Page
	//######################################################################################################//
	public static final String elerecentlyedit = "//*[contains(text(),'My Recently Edited')]";
	public static final String eleViewsummary = "//*[@id='ContentSummary']/div[1]";
	public static final String elemypublications = "//*[contains(text(),'My Publications')]";
	public static final String elerecentlycreate = "//*[contains(text(),'My Recently Created')]";
	public static final String elesavedsearch = "//*[contains(text(),'My SavedSearch')]";
	public static final String elependingapprove = "//*[contains(text(),'My Pending Approvals')]";
	public static final String eleworkflowitem = "//*[contains(text(),'My Workflow Items')]";
	public static final String elemyfavourites = "//*[contains(text(),'My Favorites')]";	
	

	//######################################################################################################//
	//Authoring My Content Summary Page
	//######################################################################################################//
	public static final String elecheckout = "//*[contains(text(),'Checkout')]";
	public static final String eleDraft = "//*[contains(text(),'Draft')]";
	public static final String elepublished = "//*[contains(text(),'Published')]";
	public static final String elePendingApproval = "//*[contains(text(),'Pending Approval')]";
	public static final String eleReviewDue = "//*[contains(text(),'Review Due')]";
	public static final String eleReviewPastDue = "//*[contains(text(),'Review Past Due')]";
	public static final String eleDueforArchival = "//*[contains(text(),'Due for Archival')]";
	public static final String eleOwner = "//*[contains(text(),'Owner')]";
	public static final String elesecondAuthor = "//*[contains(text(),'2nd Author')]";
	

	//######################################################################################################//
	//Authoring My Draft Content
	//######################################################################################################//
	public static final String tabledraftcontent = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td[1]";
	public static final String tabledraftcontentTitle = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td[1]/table/thead/tr[2]/th[1]";
	public static final String tabledraftcontentLatestpost = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td[1]/table/thead/tr[2]/th[2]";
	public static final String tabledraftcontentAction = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td[1]/table/thead/tr[2]/th[3]";
	public static final String tabledraftcontentInfo = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td[1]/table/thead/tr[2]/th[4]";
	
	//######################################################################################################//
	//Authoring My Recently Edited
	//######################################################################################################//
	public static final String tablerecentlyedit = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td[2]";
	public static final String tablerecentlyTitle = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td[2]/table/thead/tr[2]/th[1]";
	public static final String tablerecentlyLatestpost = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td[2]/table/thead/tr[2]/th[2]";
	public static final String tablerecentlyAction = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td[2]/table/thead/tr[2]/th[3]";
	public static final String tablerecentlyInfo = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td[2]/table/thead/tr[2]/th[4]";
	
	//######################################################################################################//
	//Authoring My My Publication
	//######################################################################################################//
	public static final String tablemypublication = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[2]/td[1]";
	public static final String tablemypublicationTitle = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[2]/td[1]/table/thead/tr[2]/th[1]";
	public static final String tablemypublicationLatestpost = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[2]/td[1]/table/thead/tr[2]/th[2]";
	public static final String tablemypublicationAction = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[2]/td[1]/table/thead/tr[2]/th[3]";
	public static final String tablemypublicationInfo = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[2]/td[1]/table/thead/tr[2]/th[4]";
	
	//######################################################################################################//
	//Authoring My Recently Create
	//######################################################################################################//
	public static final String tablerecentlycreate = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[2]/td[2]";
	public static final String tablerecentlycreateTitle = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[2]/td[2]/table/thead/tr[2]/th[1]";
	public static final String tablerecentlycreateLatestpost = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[2]/td[2]/table/thead/tr[2]/th[2]";
	public static final String tablerecentlycreateAction = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[2]/td[2]/table/thead/tr[2]/th[3]";
	public static final String tablerecentlycreateInfo = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[2]/td[2]/table/thead/tr[2]/th[4]";
	
	//######################################################################################################//
	//Authoring My Saved Search
	//######################################################################################################//
	public static final String tablesavedsearch = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[3]/td[1]";
	public static final String tablesavedsearchTitle = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[3]/td[1]/table/thead/tr[2]/th[1]";
	public static final String tablesavedsearchLatestpost = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[3]/td[1]/table/thead/tr[2]/th[2]";
	public static final String tablesavedsearchAction = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[3]/td[1]/table/thead/tr[2]/th[3]";
	public static final String tablesavedsearchInfo = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[3]/td[1]/table/thead/tr[2]/th[4]";
	
	//######################################################################################################//
	//Authoring My Pending Approval
	//######################################################################################################//
	public static final String tablependingapproval = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[3]/td[2]";
	public static final String tablependingapprovalTitle = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[3]/td[2]/table/thead/tr[2]/th[1]";
	public static final String tablependingapprovalLatestpost = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[3]/td[2]/table/thead/tr[2]/th[2]";
	public static final String tablependingapprovalAction = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[3]/td[2]/table/thead/tr[2]/th[3]";
	public static final String tablependingapprovalInfo = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[3]/td[2]/table/thead/tr[2]/th[4]";
	
	//######################################################################################################//
	//Authoring My work flow items
	//######################################################################################################//
	public static final String tableworkflowitems = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[4]/td[1]";
	public static final String tableworkflowitemsTitle = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[4]/td[1]/table/thead/tr[2]/th[1]";
	public static final String tableworkflowitemsLatestpost = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[4]/td[1]/table/thead/tr[2]/th[2]";
	public static final String tableworkflowitemsAction = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[4]/td[1]/table/thead/tr[2]/th[3]";
	public static final String tableworkflowitemsInfo = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[4]/td[1]/table/thead/tr[2]/th[4]";
	
	//######################################################################################################//
	//Authoring My Favorites
	//######################################################################################################//
	public static final String tablefavorites = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[4]/td[2]";
	public static final String tablefavoritesTitle = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[4]/td[2]/table/thead/tr[2]/th[1]";
	public static final String tablefavoritesLatestpost = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[4]/td[2]/table/thead/tr[2]/th[2]";
	public static final String tablefavoritesAction = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[4]/td[2]/table/thead/tr[2]/th[3]";
	public static final String tablefavoritesInfo = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[4]/td[2]/table/thead/tr[2]/th[4]";

	//######################################################################################################//
	//Authoring Due for Archival
	//######################################################################################################//
	public static final String tabledueforarchival = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[5]/td[1]";
	public static final String tabledueforarchivalTitle = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[5]/td[1]/table/thead/tr[2]/th[1]";
	public static final String tabledueforarchivalLatestpost = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[5]/td[1]/table/thead/tr[2]/th[2]";
	public static final String tabledueforarchivalAction = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[5]/td[1]/table/thead/tr[2]/th[3]";
	public static final String tabledueforarchivalInfo = "//*[@id='contentcontainer']/tbody/tr/td[2]/form[2]/table/tbody/tr[5]/td[1]/table/thead/tr[2]/th[4]";
	
	//######################################################################################################//
	//Authoring VES
	//######################################################################################################//
	public static final String folderAccountSupport = "//*[text()='Account Support ']";
	public static final String eleCreate = "//*[text()='Create']";
	public static final String elePublish= "//*[text()='Publish']";
	public static final String eleArchive= "//*[text()='Archive']";
	public static final String eleDelete= "//*[text()='Delete']";
	public static final String eleTrashMove= "//*[text()='Trash Move']";
	public static final String eleMassMetadataUpdate= "//*[text()='Mass Metadata Update']";
	public static final String eleMoveTaxonomy= "//*[text()='Move Taxonomy']";
	public static final String eleUpdateRoles= "//*[text()='Update Roles']";
	public static final String eleChangeOwner= "//*[text()='Change Owner']";
	
	public static final String searchTextBox= "//*[@id='searchTextBox']";
	public static final String btnsearch= "//*[text()='Search']";
	public static final String selectview= "//*[@id='RecordsperPage']";
	public static final String nxticon= "//*[@id='next_icon']";
	public static final String previcon= "//*[@id='prev_icon']";
	
	//######################################################################################################//
	//Authoring Create Content Without Workflow
	//######################################################################################################//
	public static final String elenewcontent = "//*[text()='New Content']";
	public static final String chckrole = "//*[@id='alldiv']";
	public static final String btncontinue = "//*[text()='Continue ']";
	public static final String txtboxtitle = "//*[@id='dDocTitle']";
	public static final String txtdescription = "//*[@id='xDescription']";
	public static final String txtkeyword = "//*[@id='xKeyword']";
	public static final String selectcategory = "//*[@id='xCategory']";
	public static final String selectheadertype = "//*[@id='xChunkType']";
	public static final String selectheaderclassification = "//*[@id='xChunkClass']";
	public static final String txtauthornote = "//*[@id='xAuthorNote']";
	public static final String btnaddRegion = "//*[@id='top']/div[2]/div[4]/table/tbody/tr/td/table/tbody/tr[9]/td[1]/img";
	public static final String chckregion = "//*[@valnm='All']";
	public static final String btnsubmit = "//*[@id='editRole_panel_cancel_button']";
	public static final String btncontinuenxt = "//*[@id='submit']";
	public static final String selectworkflow = "//*[@id='xWfPub']";
	public static final String txtURL = "//*[@id='xUrl']";
	public static final String btnsave = "//*[@id='editRole_panel_cancel_button']";
	public static final String lnkMoveTaxonomy = "//a[@title='Move Taxonomy']";
	public static final String chckAccountSupport = "//*[@valnm='Account Support']";
	public static final String lnkMassMetadata = "//a[@title='Mass Metadata Update']";
	public static final String selectMetaData = "//*[@name='cboMetadata']";
	public static final String selectDocType = "//*[@name='xDocumentType']";
	public static final String txtKeyword = "//input[@name='txtMetaKeyword']";
	public static final String lnkUpdateRoles = "//a[text()='Update Roles']";
	public static final String btnContinue = "//a[@title='Continue']";
	public static final String lnkChangeOwner = "//a[text()='Change Owner']";
	public static final String radioAuthor = "(//input[@name='author'])[1]";
	public static final String btnTransfer = "//*[@title='Transfer Ownership']";
	
	public static final String eleverify = ".//*[contains(text(),'Your Content has been successfully saved')]";
	public static final String btnviewdetails = "//*[text()='View Details']";
	public static final String btngotofolder = "//*[text()='Goto Folder']";
	public static final String btncheckinsimilar = "//*[text()='Check In Similar']";
	
	//######################################################################################################//
	//Authoring Create Content Without Workflow
	//######################################################################################################//
	public static final String chckcontent = "//*[@id='data']/tr[1]/td[1]";
	public static final String btnclose = "//*[@id='TB_closeWindowButton']";
	
	
	public static final String mouseover = "(//img[@alt='Action'])[3]";
	
	public static final String UnArchive = "//a[@title='UnArchive']";
	public static final String RevisionHistory = "//a[@title='Revision History']";
	public static final String eleRevisionHistory = "//span[text()='Revision History']";
	
	public static final String CheckinSimilar = "//a[@title='CheckinSimilar']";
	public static final String CheckOut = "//a[@title='Check Out']";
	
	public static final String lnkcontent = "//*[@id='data']/tr[1]/td[2]/a";
	public static final String lnkaddfavorites = "//*[@title='Add To Favorites']";
	public static final String lnkremovefavorites = "//*[@title='Remove from Favorites']";
	
	public static final String lnkViewAuditTrail = "//*[@title='View Audit Trail']";
	public static final String eleAuditTrail = "//*[text()='Audit Trail']";
	public static final String btnprevious = "//*[@title='Previous Page']";
	public static final String btnnext = "//*[@title='Next Page']";
	
	//######################################################################################################//
	//Authoring End User My Feed
	//######################################################################################################//
	public static final String lnktaxonomy = "//a[text()='Taxonomy']";
	public static final String elemyfeed = "//*[@class='feedTxt']";
	public static final String eledocnum = "(//*[contains(text(),'Document Number')])[1]";
	public static final String lnkBG = "//a[@id='curBG']";
	public static final String lnkFinance = "//a[text()='Finance']";
	public static final String lnkNetworkTechnology = "//a[text()='Network & Technology']";

	//######################################################################################################//
	//Authoring End User My Feed
	//######################################################################################################//
	public static final String selectsearch = "//*[@name='searchOption']";	
	public static final String txtsearch = "//*[@name='searchKeyword']";
	public static final String buttonsearch = "//*[@title='Search']";
	public static final String verifyresult = "//*[contains(text(),'Found')]";
	public static final String verifynorecord = "//*[contains(text(),'No')]";
	
	public static final String lnkAdvancedsearch = "//*[@name='frmQuickSearch']";
	public static final String txtsearchterm = "//*[@name='txtFullSearch']";
	public static final String selectcontenttype = "//*[@name='contentType']";
	public static final String btnSearchterm = "//*[@title='search']";
	
	public static final String radiocustom = "//*[@id='dynamiccontainer']/div[1]/table[2]/tbody/tr[2]/td[2]/input[2]";
	public static final String selectcustomtitle = "//*[@name='dDocTitle_cmd']";
	public static final String txttitle = "//*[@id='dDocTitle']";
	public static final String chooseeditor = "//*[@id='xSteptwoUsersmulti']/option[1]";
	
	public static final String folderAlert = "//a[contains(text(),'Alerts')]";
	public static final String authoring_frame = "//iframe[@class='cke_wysiwyg_frame cke_reset']";
	public static final String authoring_body_desc = "//body";
	public static final String authoring_break_yes = "//select[@id='xIsBreakingNews']";
	public static final String authoring_effect_date = "//input[@id='xEffectiveDate']"; 
	public static final String authoring_set_date = "//*[@id='datepick-div']//table//a[text()=";
	public static final String authoring_clk_next = "//*[@id='datepick-div']//a[text()='Next']";
	public static final String authoring_valid_date = "//input[@id='xValidityPeriod']";
	public static final String selectAlertType = "//*[@name='xAlertType']";
	public static final String eleverifyAlert = "//*[contains(text(),'Your Alerts has been successfully saved')]";

	public static final String folderNews = "//a[contains(text(),'News')]";
	public static final String eleverifyNews = "//*[contains(text(),'Your News has been successfully saved')]";
	
	public static final String folderCalendar = "//a[contains(text(),'Calendar')]";	
	public static final String selecttimezone = "//*[@name='xPubTimeZone']";
	public static final String eleverifyCalendar = "//*[contains(text(),'has been successfully saved')]";
	
	public static final String folderContacts = "//a[contains(text(),'Contacts')]";	
	public static final String txtEmailID = "//*[@name='xMetadata0']";
	public static final String txtPhone = "//*[@name='xMetadata1']";
	public static final String ChooseCategory = "//select[@id='xCategorymulti']/option[1]";
	
	public static final String folderFAQ = "//a[contains(text(),'FAQ')]";
	public static final String lnkFAQ = "//a[text()='FAQ']";	
	public static final String eleFAQ = "//*[@class='atoz_content']";	
	public static final String folderGlossary = "//a[contains(text(),'Glossary')]";
	public static final String lnkGlossary = "//a[text()='eGlossary']";
	public static final String lnkContacts = "//a[text()='Contacts']";
	public static final String lnkCalendar = "//a[text()='Calendar']";
	public static final String lnkNews = "//a[text()='News']";
	public static final String eleNews = "//*[@name='allnewsForm']/div[3]";

	//######################################################################################################//
	//Authoring Home
	//######################################################################################################//
	public static final String HeaderAdmin = "//a[text()='Admin']";	
	public static final String HeaderHelp = "//a[text()='Help']";
	public static final String eleHelpIssues = "//*[text()='Technical/Desktop Issues']";
	public static final String eleAdministration = "//a[text()='Administration']";
	
	public static final String lnkAlerts = "//a[text()='Alerts']";
	public static final String eleAlerts = "//*[@id='alertsForm']";

}
