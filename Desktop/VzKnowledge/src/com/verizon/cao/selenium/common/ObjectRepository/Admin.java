package com.verizon.cao.selenium.common.ObjectRepository;import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.Log;

public interface Admin {

	//######################################################################################################//
	//Admin Home Page
	//######################################################################################################//
	public static final String lnkAdmin = "//div[@id = 'toolsMenu']//a[text() = 'Admin']";
	public static final String lnkGlobalNav_starts ="//header[@id='globalHeader']//ul//li//a[contains(text(),'";
	public static final String lnkGlobalNav_ends ="')]";
	public static final String lnkLeftNav_starts ="//li//a[contains(text(),'"; //aside[@id = 'leftnav']//ul
	public static final String lnkLeftNav_ends ="')]";
	public static final String lnkUserName_starts ="//div[@id='vz-user-menu-name']/span/a[@title = '";
	public static final String lnkUserName_ends ="']";
	public static final String lnkHome ="//header[@id='title_section']//a[text() = 'Home']";
	public static final String lstBusinessGroup ="//div//span[@id='ddcl-business']";
	public static final String lstBusinessGroup_item_starts ="//div[@id='ddcl-business-ddw']//div//label[text() = '";
	public static final String lstBusinessGroup_item_ends ="']";


	//######################################################################################################//
	//Common to Manage User Groups,Manage Users,Manage WorkFlow Groups pages
	//######################################################################################################//
	public static final String tblHeaders_starts ="//table[@class = 'uitable large sort_table AdminSorting']//th[text() = '";
	public static final String tblHeaders_ends ="']";
	public static final String lnkActions_starts ="//table//td[contains(text(),'";
	public static final String lnkActions_middle ="')]//following-sibling::td//a[text() = '";
	public static final String lnkActions_ends ="']";

	//######################################################################################################//
	//Manage Meta Data Page,Manage Roles
	//######################################################################################################//
	public static final String lstContentType = "//select[@id='ctid']";
	public static final String lstMetaType ="//select[@id='mtid']";
	public static final String btnMetaDataActions_starts = "//div[@id = 'dtableRoles']//a//span[text() = '";
	public static final String btnMetaDataActions_ends = "']";
	public static final String radioInformation_starts = "//li//label[text() = '";
	public static final String radioInformation_ends = "']//preceding::input[@type = 'radio']";

	//######################################################################################################//
	//Add Meta Data Page
	//######################################################################################################//
	public static final String btnMetaDataAdd_starts = "//a[@id='add']/span[text() = '";
	public static final String btnMetaDataAdd_ends = "']";
	public static final String txtMetaDataValue ="//input[@id='metadataName']";
	public static final String txtMetaDataDesc ="//textarea[@id='metadataDesc']";
	public static final String lstStatus = "//select[@id = 'selStatus']";
	public static final String optEndUserRoles_starts = "//input[@type = 'checkbox' and @valnm = '";
	public static final String optEndUserRoles_ends = "']";




	//######################################################################################################//
	//Manage User Groups Page
	//######################################################################################################//
	public static final String btnAddUserGroups ="//div[@id='AddButton']//a//span[text() = 'Add User Group']";
	//######################################################################################################//
	//Manage Users Page
	//######################################################################################################//
	public static final String btnAddUsers ="//a[@id='AddButton']//span[text() = 'Add Users']";
	public static final String btnExportUsers ="//a[@id='expUser']/span[contains(text(),'Export Users')]";
	public static final String txtSearchUser ="//input[@id='searchTxt']";
	public static final String btnSearchUser ="//input[@id = 'searchTxt']//following-sibling::a//span[text() = 'Find']";
	public static final String btnDownloadTemplate ="//a[@id='userTemplate']/span[contains(text(),'Download')]";
	public static final String btnBrowseFile ="//input[@id='fileName']";
	public static final String btnUpload ="//a[@id='uploadUser']/span[text() = 'Upload']";
	public static final String lstSystemRole ="//select[@id='searchSysRole']";
	public static final String lstCustomRole ="//select[@id='searchCusRole']";
	public static final String btnFindUser ="//label[@for = 'role']//following-sibling::a//span[text() = 'Find']";
	public static final String lblSelectUsers ="//div[@id='AddSection']/table//td//b[text() ='Select users:' ]";
	public static final String optUserType1 ="//input[@id='usertype1']";
	public static final String txtFirstName ="//input[@id='firstName']";
	public static final String txtMiddleName ="//input[@id='mInitial']";
	public static final String txtLastName ="//input[@id='lastName']";
	public static final String optUserType2 ="//input[@id='usertype2']";
	public static final String txtEnterpriseId  ="//input[@id='eid']";
	public static final String btnOk_CancelSearch_starts  ="//a[@title =  'Search']//span[text() = '";
	public static final String btnOk_CancelSearch_ends  ="']";
	public static final String btnGo ="//a//span[text() = 'Go']";
	public static final String tableUsers = "//table[@class = 'uitable large sort_table AdminSorting']";
	public static final String chkUsers_Admin_Author_Roles_starts = "//span[contains(text(),'";
	public static final String chkUsers_Admin_Author_Roles_ends = "')]//preceding-sibling::input[@type = 'checkbox']";
	//######################################################################################################//
	//Manage Business Groups
	//######################################################################################################//
	public static final String btnAddNew_Business_Groups ="//div[@id = 'AddButton']//span[text() = 'Add New Business Group']";

	//######################################################################################################//
	//Edit Business Groups
	//######################################################################################################//
	public static final String TabsManageBizGroups_starts ="//a[contains(text(),'";
	public static final String TabsManageBizGroups_ends ="')]";
	public static final String txtBizName ="//input[@id='busname']";
	public static final String txtDisplayName ="//input[@id='displayNm']";
	public static final String txtDiscription ="//input[@id='busdesc']";
	public static final String ClickBizStatusDropDown ="//span[@id = 'ddcl-busstatus']";
	public static final String lstBusiness_Status ="//select[@id = 'busstatus']";
	public static final String chkAllowExternal ="//input[@id='allowExternal' and @type = 'checkbox']";
	public static final String btnNext = "//a//span[text() = 'Next']";
	public static final String btnBusinessGroupInfo_Cancel = "//a//span[text() = 'Cancel']";
	public static final String chkAdmin_Author_Roles_starts = "//span[starts-with(@id, 'selSysRole') and text() = '";
	public static final String chkAdmin_Author_Roles_ends = "']//preceding-sibling::input[@type = 'checkbox']";
	public static final String chkSubAdmin_Author_Roles_starts = "//span[starts-with(@id, 'selSysRole') and text() = '";
	public static final String chkSubAdmin_Author_Roles_middle = "']//following-sibling::div//span[text() = '";
	public static final String chkSubAdmin_Author_Roles_ends = "']//preceding-sibling::input[@type = 'checkbox']";
	public static final String btnPlusTree_starts = "//ul//li//span[text() = '";
	public static final String btnPlusTree_ends = "']//preceding-sibling::input[@type = 'button']";

	public static final String lblNo_Groups_Found = "//div[@id='addgroup']//td[contains(text(), 'No Groups Found')]";
	//after this alert box ,only ok button
	public static final String btnAddBusinessGroups = "//a//span[@id='addbtn']";
	public static final String btnManageSystemRole_Cancel="//section[@id = 'step2_tab']//a//span[text() = 'Cancel']";

	//public static final String "//div[@id = 'addgroup']//tr[1]//td[1][normalize-space(text() = 'CMB Feedback Recipients')]//input[@name = 'groups']";
	//######################################################################################################//
	//Manage Default Subscriptions
	//######################################################################################################//
	public static final String chkRole_Region_starts  ="//li//input[@value = '";
	public static final String chkRole_Region_ends  ="']";
	public static final String btnSaveSubscriptions  ="//a//span[text() = 'Save  Subscriptions']";
	public static final String lnkRole_Region_starts  ="//li//span[text() ='";
	public static final String lnkRole_Region_ends  ="']";
	public static final String lblDefault_Sub_Role  ="//h2[text() = 'Default Subscriptions']//following-sibling::h4[text() = 'Role']//following-sibling::div//p";
	public static final String lblDefault_Sub_Region  ="//h2[text() = 'Default Subscriptions']//following-sibling::h4[text() = 'Region']//following-sibling::div//p";



	//######################################################################################################//
	//Manage WorkFlow Groups
	//######################################################################################################//
	public static final String btnAddWork_Flow_Groups ="//table[@id = 'AddButton']//span[text() = 'Add Workflow Group']";
	public static final String lnkManageWorkFlow_Actions_starts ="//thead[//th[text() = 'Actions']]//following-sibling::tbody//td//a[text() = '";
	public static final String lnkManageWorkFlow_Actions_ends ="']";
	public static final String txtWorkFlowGroup_Name ="//input[@id='groupName']";
	public static final String txtWorkFlowGroup_Desc ="//textarea[@id='groupDescription']";
	public static final String lstWorkFlowGroup_Status_starts ="//div[@id='ddcl-selStatus-ddw']//div//label[text() = '";
	public static final String lstWorkFlowGroup_Status_ends ="']";
	public static final String optAvailableRoles_Editor_starts ="//span[@id='sysRoleDiv']//input[text()='";
	public static final String optAvailableRoles_Editor_ends ="']";
	public static final String optAvailableRoles_StakeHolders ="//span[@id='sysRoleDiv']//input[@id = 'sysrole_19']";
	public static final String lstAvailableUsers ="//select[@id='available_users']";
	public static final String lstSelectedUsers ="//select[@id='selected_users']";
	public static final String lnkAvailableUsers_Add ="//div[@id='AddSection']//td//a[@title= 'add']";
	public static final String lnkAvailableUsers_AddAll ="//div[@id='AddSection']//td//a[@title= 'add all']";
	public static final String lnkAvailableUsers_Remove ="//div[@id='AddSection']//td//a[@title= 'remove']";
	public static final String lnkAvailableUsers_RemoveAll ="//div[@id='AddSection']//td//a[@title= 'remove all']";
	public static final String btnAddWorkFlowGroup ="//a[@id='add']/span[text()= 'Add Workflow Group']";
	public static final String btnCancelWorkFlowGroup ="//td//a[@title= 'Cancel']";


	//######################################################################################################//
	//Manage Global Reviewers
	//######################################################################################################//
	public static final String lstBusinessGroups ="//select[@id='businessGroup']";
	public static final String btnAddUser ="//a//span[text() = 'Add User']";
	public static final String tableManageGlobalReviewers ="//table[@class = 'uitable large sort_table AdminSorting']";
	public static final String txtGlobalReviwer_FirstName = "//input[@id='firstName']";
	public static final String txtGlobalReviewer_Middle = "//input[@id='mInitial']";
	public static final String txtGlobalReviewer_LastName = "//input[@id='lastName']";
	public static final String txtGlobalReviewer_EnterpriseID = "//input[@id='eid']";
	public static final String optGlobalReviewerUserType1 ="//input[@id='usertype1']";
	public static final String optGlobalReviewerUserType2 ="//input[@id='usertype2']";
	public static final String btnGlobalReviewer_ShowUsers = "//a//span[text() = 'Show Users']";
	public static final String btnGlobalReviewer_Cancel = "//a//span[text() = 'Cancel']";
	public static final String lblNumber_Of_Users_Found = "//div[@id = 'usersResult']//b";
	public static final String lblFullName_Of_Users_Found_starts = "//section[@class = 'team_table']//tr//td[contains(text() ,'";
	public static final String lblFullName_Of_Users_Found_ends = "')]";





	//######################################################################################################//
	//View Global Reviewers =VGR
	//######################################################################################################//
	public static final String lstBusinessGroup_VGR ="//select[@id = 'businessGroup']";

	//######################################################################################################//
	//Manage Profile Settings
	//######################################################################################################//
	public static final String lstGlossaryCategory_starts ="//div[@id = 'ddcl-glosscat-ddw']//div//label[text() = '";
	public static final String lstGlossaryCategory_ends ="']";


	//######################################################################################################//
	//Reports
	//######################################################################################################//
	public static final String lstGlossaryCategory_startq ="//div[@id = 'ddcl-glosscat-ddw']//div//label[text() = '";
	public static final String lstGlossaryCategory_endsq ="']";



	//######################################################################################################//
	//Manage Meta Types
	//######################################################################################################//
	public static final String lstMetaType_BusinessGroup = "//select[@id='bgpid']";
	public static final String lstMetaType_ContentType = "//select[@id='contentType']";
	public static final String btnAddMetaType = "//div[@id='AddButton']/a/span[text() = 'Add MetaType']";
	public static final String lnkEditMetaType_starts = "///tr//td[text() = '";
	public static final String lnkEditMetaType_ends = "']//following-sibling::td//a[text() = 'Edit']";
	public static final String txtMetaTypeName = "//input[@id='metatypename']";
	public static final String txtMetaTypeDesc = "//input[@id='metatypedesc']";
	public static final String lstIsHierarchical_Options_starts = "//span[@id='ddcl-hierarchial']/span";
	public static final String lstIsHierarchical_Options_ends = "//div[@id='ddcl-hierarchial-ddw']//div//label[text() ='YES']";

	public static final String lstHasProfile_Options_starts = "//div//label[text() = '";
	public static final String lstHasProfile_Options_ends = "']//preceding-sibling::input[@name = 'ddcl-hasprofile']";
	public static final String lstCanSubscribe_Options_starts = "//div//label[text() = '";
	public static final String lstCanSubscribe_Options_ends = "']//preceding-sibling::input[@name = 'ddcl-issubscribe']";
	public static final String btnAddMetaType_Edit = "//a[@id='add']/span[text() = 'Add MetatType']";
	public static final String btnCancelMetaType = "//div[@id='AddSection']//a//span[text() = 'Cancel']";
	public static final String btnUpdateMetaType = "//div[@id='AddSection']//a//span[text() = 'Update MetatType']";
	public static final String tblData_starts = "//table//tbody//tr//td[text() = '";
	public static final String lstIsHierarchical = "//span[@id='ddcl-hierarchial']//preceding-sibling::select[@id = 'hierarchial']";
	public static final String lstHasProfile = "//span[@id='ddcl-hasprofile']//preceding-sibling::select[@id = 'hasprofile']";
	public static final String lstCanSubscribe = "//span[@id='ddcl-issubscribe']//preceding-sibling::select[@id = 'issubscribe']";

	//######################################################################################################//
	//Manage Preset Roles
	//######################################################################################################//
	public static final String btnAddPresetRole = "//div[@id='AddButton']/a/span[text() = 'Add Preset Role']";
	public static final String txtPresetRoleName = "//input[@id = 'addprerolename']";
	public static final String txtPresetRoleDescription = "//textarea[@id='addpreroledesc']";
	public static final String lnkMetaDataRole = "//div[@id = 'addnewpreset']//ul[@class = 'tab_labels']//li//span[text() = 'Role']";
	public static final String lnkMetaDataRegion = "//div[@id = 'addnewpreset']//ul[@class = 'tab_labels']//li//span[text() = 'Region']";
	public static final String chkMetaData_Role_Region_starts = "//span[text() = '";
	public static final String chkMetaData_Role_Region_ends = "']//preceding-sibling::input[@type = 'checkbox']";
	public static final String btnAddPresetRole_Edit = "//a[@id='add']/span[text() = 'Add Preset Role']";
	public static final String btnCancelPresetRole = "//div[@id = 'AddSection']//table//span[text() = 'Cancel']";
	public static final String btnUpdatePresetRole_Edit = "//a[@id='edit']/span[text() = 'Update Preset Role']";

	//######################################################################################################//
	//Manage Meta Types
	//######################################################################################################//
	public static final String btnSuperAdmin_AddUser = "//a//span[text() = 'Add User']";


	//######################################################################################################//
	//Manage Query Group
	//######################################################################################################//
	public static final String btnManageQueryGroup = "//div[@id='AddButton']/a/span[text() = 'Add QueryGroup']";
	public static final String txtQueryGroup_Name = "//input[@id='querygroupname']";
	public static final String txtQueryGroup_Desc = "//input[@id='querygroupdesc']";
	public static final String txtQueryGroup_Query = "//textarea[@id = 'querygroupquery']";
	public static final String lstQueryGroup_Status = "//select[@id='status']";
	public static final String btnAddQueryGroup = "//a/span[text() = 'Add QueryGroup']";
	
	//######################################################################################################//
	//Manage Property
	//######################################################################################################//
	public static final String btnAddProperty = "//div[@id='AddButton']/a/span[text() = 'Add Property']";
	public static final String txtPropertyName = "//input[@id='propertyname']";
	public static final String txtPropertyValue = "//textarea[@id='propertyvalue']";
	public static final String txtPropertyDesc = "//textarea[@id='propertydesc']";
	public static final String btnAddProperty_ManageProperties = "//a[@id='add']/span[text() = 'Add Property']";
	//alert box
	public static final String btnCancelProperty = "//a//span[text() = 'Cancel']";


	//######################################################################################################//
	//Manage Profile Settings
	//######################################################################################################//
	public static final String btnAddNewProfileSettings = "//a[@id='AddButton']/span[text() = 'Add New Profile Setting']";
	public static final String lstProfileSettings_GlossaryCategory_starts = "//div[@id='ddcl-glosscat-ddw']//label[text() = '";
	public static final String lstProfileSettings_GlossaryCategory_ends = "']";
	public static final String btnUpdateGlossaryCategory = "//a//span[@id='upddefgloscat']";
	public static final String lnkContentType_ProfileSettings_starts = "//div[@id = 'cty']//ul//li//a[text() = '";
	public static final String lnkContentType_ProfileSettings_ends = "']";
	public static final String btnWorkFlowEdit = "//label[text() ='Edit']//following-sibling::input[@type = 'checkbox']";
	public static final String lstReviewDate = "//select[@id = 'reviewdate']";
	public static final String lstAutoArchiveDate = "//select[@id='autoArcFlag']";
	public static final String chkAutoPublish = "//div[@id='AutoPubDiv']//input[@id = 'autoPubFlag']";
	public static final String chkMail_To_SecAuthor = "///div[@id='notifyDiv']//input[@id = 'notifyFlag']";
	public static final String chkContentWorkFlow_starts = "//td//ul//li//input[@textval=  '";
	public static final String chkContentWorkFlow_ends = "']";
	public static final String lstContentDefaultWorkFlow = "//select[@id='isdeft']";
	public static final String btnUpdateReviewDate_WorkFlow = "//a//span[@id='updRwfBtn']";
	public static final String chkSecondaryAuthors = "//input[@id='chkSecAuthor']";
	public static final String lstUserGroups = "//select[@id='userGroups']";
	public static final String lstSelUserGroups = "//select[@id='selUserGroups']";
	public static final String btnUserGroups_Add = "//div[@id='addtnlfeedBackDiv']//td//a[@title = 'add']";
	public static final String btnUserGroups_AddAll = "//div[@id='addtnlfeedBackDiv']//td//a[@title = 'add all']";
	public static final String btnUserGroups_Remove = "//div[@id='addtnlfeedBackDiv']//td//a[@title = 'remove']";
	public static final String btnUserGroups_RemoveAll = "//div[@id='addtnlfeedBackDiv']//td//a[@title = 'remove all']";
	public static final String btnUpdateFeedBackRecipients = "//a[@id = 'edit']//span[text() = 'Update Feedback Recipients']";

	public static final String txtProfileSettingsName = "//input[@id='fname']";
	public static final String txtProfileSettingsDisplayName = "//input[@id='fdispname']";
	public static final String lstIsDropDown = "//select[@id='dropDown']";
	public static final String optValue_starts = "//label[text() = 'Value']//following-sibling::input[@value = '";
	public static final String optValue_ends = "']";
	public static final String txtValue = "//input[@id='featureTxtVal']";
	public static final String btnAddProfileSetting = "//a//span[@id='addbtn']";
	//alert box
	public static final String btnCancelProfileSetting = "//a[@title = 'Cancel']";

	//######################################################################################################//
	//Manage Roles
	//######################################################################################################//
	public static final String lblManageSiteLayout ="//h1[text() = 'Manage Site Layout']";




	//######################################################################################################//
	//Manage Roles
	//######################################################################################################//
	public static final String btnManageRoles_Add = "//div[@id='dtableRoles']/a/span[text() = 'Add']";
	public static final String btnManageRoles_Edit = "//div[@id='dtableRoles']/a/span[text() = 'Edit']";
	public static final String btnManageRoles_AddChild = "//div[@id='dtableRoles']/a/span[text() = 'Add Child']";
	public static final String txtRoleName = "//input[@id='roleName']";
	public static final String txtRoleNotes = "//textarea[@id='roleDesc']";
	public static final String txtRoleDesc = "//textarea[@id='roleDescription']";
	public static final String chkManageRoles_AllowExternal = "//input[@id='allowExternal']";
	public static final String lstManageRoles_Status = "//select[@id='selStatus']";
	public static final String lnkContentTypes_starts = "//div[@id='cty']//ul//li//a[text() = '";
	public static final String lnkContentTypes_ends = "']";
	public static final String chkBusinessGroupDefault = "//label[text() = 'Business Group Default']//following-sibling::input[@type = 'checkbox']";
	public static final String chkWorkFlow_starts = "//label[contains(text(),'Workflow')]//following-sibling::div//ul/li//input[@textval ='";
	public static final String chkWorkFlow_ends = "']";
	public static final String lstDefaultWorkFlow_starts = "//label[contains(text(),'Default Workflow')]//following-sibling::span//select[@id = 'isdeft']//option[text() = '";
	public static final String lstDefaultWorkFlow_ends ="']";
	public static final String chkAvailableGroups = "//label[text()='Available Groups']//following-sibling::div//ul[1]/li[text()]//input";
	public static final String btnAddRole = "//a//span[@id='addbtn']";
	public static final String btnCancelRole = "//div[@id='addgroup']//a//span[text() = 'Cancel']";



	///////REPORTS//////////////
	//######################################################################################################//
	//Reports
	//######################################################################################################//
	//Login page OBIEE/
	public static final String txt_OBIEE_UserName = "//input[@id='sawlogonuser']";
	public static final String txt_OBIEE_Password = "//input[@id='sawlogonpwd']";
	public static final String btn_OBIEE_SignIn = "//input[@id='idlogon']";
	public static final String btnOtherReports = "//td//a[text() = 'Other Reports']";
	public static final String btnWebTrends = "//td//a[text() = 'Webtrends']";
	public static final String lnkEmail = "//h1[text() = 'Manage Reports']//following-sibling::table//a[text() = 'VZKnowledge Support']";
	public static final String lblPleaseWait = "//div[@class = 'DropDownLoading']//span[text() = 'Please Wait']";
	public static final String lnkTabs_starts = "//td//span[contains(text(),'";
	public static final String lnkTabs_ends ="')]";
	public static final String lnkMoreTabs_starts = "//table[@id='menuOptionTable']//td//span[text() = '";
	public static final String lnkMoreTabs_ends = "']";
	public static final String lblPageLoading = "//span[text() = 'Processing, please wait...']";

	public static final String lnkMore = "//div[@id='idComponentLevelTabbarOuterDiv']/div/table/tbody/tr/td[3]/img";
	public static final String lstReportsBusinessGroups = "//table//tr//td[label//span[text() ='Business Group']]//following-sibling::td//span//div//input";
	public static final String lstReportsRole = "//table//tr//td[label//span[text() ='Role']]//following-sibling::td//span//div//input";
	public static final String lstContentStatus = "//table//tr//td[label//span[text() ='Content Status']]//following-sibling::td//span//div//img";
	public static final String lstReportsContentType = "//table//tr//td[label//span[text() ='Content Type']]//following-sibling::td//span//div//input";
	public static final String lstIsVLSS = "//table//tr//td[label//span[text() ='Is VLSS?']]//following-sibling::td//span//div//img";
	public static final String chkBusinessGroups = "html/body//div[@class = 'DropDownValueList']//label[text() = 'VES']//preceding-sibling::input";
	public static final String chkReportRole = "html/body//div[@class = 'DropDownValueList']//label[text() = 'Global Operations - Bill & Inquire']//preceding-sibling::input";
	public static final String chkContentStatus= "html/body//div[@class = 'DropDownValueList']//label[text() = 'ARCHIVED']//preceding-sibling::input";
	public static final String chkReportsContentType = "html/body//div[@class = 'DropDownValueList']//label[text() = 'ALERT']//preceding-sibling::input";
	public static final String chkIsVLSS = "html/body//div[@class = 'DropDownValueList']//label[text() = 'Yes']//preceding-sibling::input";
	public static final String chkCategoryName = "html/body//div[@class = 'DropDownValueList']//label[text() = 'ALERTS']//preceding-sibling::input";
	public static final String chkFeedBackType = "html/body//div[@class = 'DropDownValueList']//label[text() = 'CLARIFICATION']//preceding-sibling::input";
	public static final String chkFeedBackStatus  = "html/body//div[@class = 'DropDownValueList']//label[text() = 'New']//preceding-sibling::input";
	public static final String chkPortletName = "html/body//div[@class = 'DropDownValueList']//label[text() = 'Around Verizon']//preceding-sibling::input";
	public static final String txtReadDate_Between = "//span[span[contains(text(),'-')]]//preceding-sibling::span//input";
	public static final String txtReadDate_To = "//span[span[contains(text(),'-')]]//following-sibling::span//input";
	public static final String txtCreatedDate_Between = "//td[span[contains(text(),'-')]]//preceding-sibling::td//span//input";
	public static final String txtCreatedDate_To = "//td[span[contains(text(),'-')]]//following-sibling::td//span//input";
	public static final String DropDownList = "html/body//div[@class = 'DropDownValueList']";

	public static final String imgBusinessGroup = "//table//tr//td[label//span[text() ='Business Group']]//following-sibling::td//img";
	public static final String imgRole = "//table//tr//td[label//span[text() ='Role']]//following-sibling::td//img";
	public static final String imgMetadataType = "//table//tr//td[label//span[text() ='Metadata Type']]//following-sibling::td//img";
	public static final String imgUserType = "//table//tr//td[label//span[text() ='User Type']]//following-sibling::td//img";
	public static final String imgMetadataValues = "//table//tr//td[label//span[text() ='Metadata Values']]//following-sibling::td//img";
	public static final String imgAlertName = "//table//tr//td[label//span[text() ='Alert Name']]//following-sibling::td//img";
	public static final String imgCategoryName = "//table//tr//td[label//span[text() ='Category Name']]//following-sibling::td//img";
	public static final String imgFeedBackType = "//table//tr//td[label//span[text() ='Feedback Type']]//following-sibling::td//img";
	public static final String imgFeedBackStatus = "//table//tr//td[label//span[text() ='Feedback Status']]//following-sibling::td//img";
	public static final String imgInternal_External = "//table//tr//td[label//span[text() ='Internal_External']]//following-sibling::td//img";
	public static final String imgRoleName = "//table//tr//td[label//span[text() ='Role Name']]//following-sibling::td//img";
	public static final String imgContentType = "//table//tr//td[label//span[text() ='Content Type']]//following-sibling::td//img";
	public static final String imgPortletName = "//table//tr//td[label//span[text() ='Portlet Name']]//following-sibling::td//img";
	public static final String imgOwnerName = "//table//tr//td[label//span[text() ='Owner Name']]//following-sibling::td//img";
	public static final String lnkExcel = "//td[@class = 'shadowMenuCell']//td[text() = 'Excel']";
	public static final String lnkExcelMenuItem = "//td[@class = 'shadowMenuCell']//td[text() = 'Excel 2007+']";
	public static final String lnkVisitorDetails = "//table[@id='menuOptionTable']//td//span[text() = 'Visitor Details']";
	public static final String lnkViewUsers = "//table[@id='menuOptionTable']//td//span[text() = 'View Users']";
	public static final String lnkViewWorkFlowDetails = "//table[@id='menuOptionTable']//td//span[text() = 'View Workflow Details']";
	public static final String lnkViewDocDetails = "//table[@id='menuOptionTable']//td//span[text() = 'View Doc Title']";
	public static final String lnkViewDetails = "//table[@id='menuOptionTable']//td//span[text() = 'View Details']";
	public static final String lnkViewRatedUsers = "//table[@id='menuOptionTable']//td//span[text() = 'View Rated Users']";
	public static final String lnkViewSubscribedUsers = "//table[@id='menuOptionTable']//td//span[text() = 'View Subscribed Users']";
	public static final String lnkViewCertifiedUsers = "//table[@id='menuOptionTable']//td//span[text() = 'View Certified Users']";
	public static final String lnkViewFeedback = "//table[@id='menuOptionTable']//td//span[text() = 'View Feedback']";
	public static final String txtVisitorDetailsTitle = "//table[@class = 'TitleTable']//td[text() = 'Visitors Report']";
	public static final String txtContentReadReportTitle = "//table[@class = 'TitleTable']//td[text() = 'Content Read Report']";
	public static final String txtWorkFlowReportTitle = "//table[@class = 'TitleTable']//td[text() = 'Workflow Report']";
	public static final String txtChunkingReportTitle = "//table[@class = 'TitleTable']//td[text() = 'Chunking Report']";
	public static final String txtRequiredReadingReportTitle = "//table[@class = 'TitleTable']//td[text() = 'Required Reading Report']";
	public static final String txtContentReadPerUserTitle = "//table[@class = 'TitleTable']//td[text() = 'Content Read Per User']";
	public static final String txtProfileReportTitle = "//table[@class = 'TitleTable']//td[text() = 'Profile Report']";
	public static final String txtSearchRatingReportTitle = "//table[@class = 'TitleTable']//td[text() = 'Search Rating Report']";
	public static final String txtSubmittedRatingReportTitle = "//table[@class = 'TitleTable']//td[text() = 'Submitted Rating Report']";
	public static final String txtMetaData_Subscription_ReportTitle = "//table[@class = 'TitleTable']//td[text() = 'Metadata Subscription Report']";
	public static final String txtReadAndCompliance_ReportTitle = "//table[@class = 'TitleTable']//td[text() = 'Read and Compliance Report - Alert']";
	public static final String txtFeedBackReport_General_Title = "//table[@class = 'TitleTable']//td[text() = 'Feedback Report - General']";
	public static final String txtFeedBackReport_Content_Title = "//table[@class = 'TitleTable']//td[text() = 'Feedback Report - Content']";

	public static final String lnkExport = "//td[@class = 'ResultLinksCell']//a[text() = 'Export']";
	public static final String lnkFeedBackExport = "//div[@viewtype = 'compoundView'][table[@class = 'CVTable']]//following-sibling::table//td//a[text() = 'Export']";
	public static final String lnkPrint = "//td[@class = 'ResultLinksCell']//a[text() = 'Print']";
	public static final String lnkRefresh = "//td[@class = 'ResultLinksCell']//a[text() = 'Refresh']";
	public static final String ClickAtWorkspace = "//div[@id='DashboardPageContentDiv']";
	public static final String btnApply = "//td//input[@id='gobtn']";
	public static final String btnReset = "//a[@name = 'reset']";

	public static final String txtContentRatingReport_Role = "//td//a[text() = 'Bill Inquiry Team Overview']";
	public static final String lnkCountOfDocs = "//td[text() = 'VES']//following-sibling::td//a";








}

