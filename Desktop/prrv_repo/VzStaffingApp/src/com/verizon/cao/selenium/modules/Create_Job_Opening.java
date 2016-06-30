package com.verizon.cao.selenium.modules;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verizon.cao.selenium.constants.ApplicationConstants;
import com.verizon.cao.selenium.constants.MyConstants;
import com.verizon.cao.selenium.util.ExcelUtils;
import com.verizon.cao.selenium.util.Log;
import com.verizon.cao.selenium.util.PropertyUtility;
import com.verizon.cao.selenium.util.StaffingUtil; 




public class Create_Job_Opening implements ApplicationConstants{
	
	PropertyUtility putility = new PropertyUtility(OBJECT_REPO_FILEPATH);
	StaffingUtil su = new StaffingUtil();
	ExcelUtils excelUtils = new ExcelUtils();
	public static ExtentReports extent = new ExtentReports(REPORT_PATH+"/CreateJobOpening.html", true,DisplayOrder.OLDEST_FIRST);
	 private ExtentTest test ;
	
	@Test
	@Parameters("testCaseId")
	
	public void JO (String testCaseId) throws Exception {
		//Starting the extent report
		test = extent.startTest("Creating New Job for TestCase - '"+testCaseId);
		/*if (! MyConstants.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
			throw new SkipException("Skipping the test case as application is not available.");			
		}*/
		
		if (! su.executeTestCase("Create_JO", testCaseId)){
			test.log(LogStatus.SKIP, "Skipping the test case as there is no data available for test case in DB.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
			throw new SkipException("Skipping the test case as there is no data available for test case in DB.");			
		}
		System.out.println("Going to start creating jobs ::"+MyConstants.env);
		//Initiating log4j
		Log.startTestCase(testCaseId);
		String TestCase_Desc,Create_Clone,navigate,URL,Login,Pwd,cl_jo,hiringManager,JobOpeningType,TargetOpening,RsnForJobOpening,EmpReplaced,jobLocation,jobCodeTitle,Union_Code,CBA,Company,Department,Driving_Requirements;
		String Addrecruiter,PostDate,PostDuration,Referral_PgmID,StaffOpp_Type,Add_Recruiters,Add_Hiring_Managers,Add_Interviewers,Add_Interested_Parties,Add_Additional_Locations,Billable_Contractual,Company_Client_Name,Hours,TravelPercentage;
		// String Scope,Business_Unit,Security_Clearance_Type,MailDrop;
		try{
			ExcelUtils.setExcelFile(DATA_FILEPATH,"Create_JO");
			TestCase_Desc = ExcelUtils.getExcelData("TC_Desc",testCaseId);
			Create_Clone = ExcelUtils.getExcelData("Create_Clone",testCaseId);
			navigate = ExcelUtils.getExcelData("Navigation",testCaseId);
			URL = ExcelUtils.getExcelData("URL",testCaseId);
			Login = ExcelUtils.getExcelData("Login",testCaseId);
			Pwd = ExcelUtils.getExcelData("Pwd",testCaseId);
			cl_jo = ExcelUtils.getExcelData("JO",testCaseId);
			hiringManager = ExcelUtils.getExcelData("Hiring_Manager",testCaseId);
			JobOpeningType = ExcelUtils.getExcelData("Job_Opening_Type",testCaseId);
			TargetOpening = ExcelUtils.getExcelData("Target_Openings",testCaseId);
			RsnForJobOpening = ExcelUtils.getExcelData("Reason_for_Job_Opening",testCaseId);
			EmpReplaced = ExcelUtils.getExcelData("Employees_Being_Replaced",testCaseId);
			//Scope = ExcelUtils.getExcelData("Scope",testCaseId);
			//Business_Unit = ExcelUtils.getExcelData("Business_Unit",testCaseId);
			jobLocation = ExcelUtils.getExcelData("Location",testCaseId);
			jobCodeTitle = ExcelUtils.getExcelData("Job_Code",testCaseId);
			Union_Code = ExcelUtils.getExcelData("Union_Code",testCaseId);
			Company = ExcelUtils.getExcelData("Company",testCaseId);
			Department = ExcelUtils.getExcelData("Department",testCaseId);
			Driving_Requirements = ExcelUtils.getExcelData("Driving_Requirements",testCaseId);
			CBA = ExcelUtils.getExcelData("CBA",testCaseId);
			//MailDrop = ExcelUtils.getExcelData("CBA",testCaseId);
			Addrecruiter = ExcelUtils.getExcelData("Add_Recruiter",testCaseId);
			PostDate = ExcelUtils.getExcelData("PostDate",testCaseId);
			PostDuration = ExcelUtils.getExcelData("PostDuration",testCaseId);
			Referral_PgmID = ExcelUtils.getExcelData("Referral_PgmID",testCaseId);
			StaffOpp_Type = ExcelUtils.getExcelData("StaffOpp_Type",testCaseId);
			Add_Recruiters = ExcelUtils.getExcelData("Add_Recruiters",testCaseId);
			Add_Hiring_Managers = ExcelUtils.getExcelData("Add_Hiring_Managers",testCaseId);
			Add_Interviewers = ExcelUtils.getExcelData("Add_Interviewers",testCaseId);
			Add_Interested_Parties = ExcelUtils.getExcelData("Add_Interested_Parties",testCaseId);
			Add_Additional_Locations = ExcelUtils.getExcelData("Add_Additional_Locations",testCaseId);
			Billable_Contractual = ExcelUtils.getExcelData("Billable_Contractual",testCaseId);
			Company_Client_Name = ExcelUtils.getExcelData("Company_Client_Name",testCaseId);
			Hours = ExcelUtils.getExcelData("Hours",testCaseId);
			TravelPercentage = ExcelUtils.getExcelData("TravelPercentage",testCaseId);
		}
		catch (Exception e){
			System.out.println("Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e);
			Reporter.log("Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exception : "+ e);
			test.log(LogStatus.FAIL,"Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e);
			excelUtils.setCellData("Create_JO", "FAIL", testCaseId, "Result_Status");
			excelUtils.setCellData("Create_JO", "Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e, testCaseId, "Result_Errors");
			throw new Exception("Error occured while trying to login to the application  -  " +e);
		}		
		
		test.log(LogStatus.INFO, "App Launch and Login", "Usage: <span style='font-weight:bold;'>Going To launch URL and Login in the application</span>");
		//Launching the application
		su.LaunchUrl(extent,test,URL,"Create_JO",testCaseId);
		//Logging into the application
		su.Staffing_Login(extent,test,Login,Pwd,"Create_JO",testCaseId);
		Log.info("Executing Test Case "+testCaseId+" "+TestCase_Desc );
		System.out.println("Executing Test Case "+testCaseId+" "+TestCase_Desc );
		
		 //extent.addSystemInfo("Selenium Version", "2.46");
		// extent.addSystemInfo("Environment", "Staging");
		
		//Condition to check if new job is to created or to be cloned from existing job
		 if (Create_Clone.equalsIgnoreCase("Create")){
			 
			 test.log(LogStatus.INFO, "Creation of Job", "Usage: <span style='font-weight:bold;'>Creating new Job</span>");
			 
			//Navigating to Create Job Opening page
			su.Navigate_To_Menu(extent,test, navigate,"Create_JO",testCaseId);
			
			//Switching to a different frame to identify the objects on page
			su.SwitchFrames("ptifrmtgtframe");
			su.Processing();
			
			 //Selecting the type of job
			su.SelectDropDown(test,putility.getProperty("job_opening_type"),JobOpeningType,"Create_JO",testCaseId);
			
			//Entering Hiring Manager Id
			su.SetData(test,putility.getProperty("hiring_mgr_id"),hiringManager);  //hiringManager
			
			//Entering total targets for Opening
			su.setTarget(extent,test,TargetOpening,"Create_JO",testCaseId);
			su.checkPopUp(extent,test,"Create_JO",testCaseId,"TargetOpening");    //TargetOpening
			su.SwitchFrames("ptifrmtgtframe");
			
			//Selecting reason for job opening from drop down
			su.SelectDropDown(test,putility.getProperty("rsn_for_job_opening"), RsnForJobOpening,"Create_JO",testCaseId);
			
			//Entering Employee to be replaced only when the opening type is "Backfill"
			if (RsnForJobOpening.equalsIgnoreCase("Backfill")) {
				su.Processing();
				su.SetLookUpValue(extent,test,putility.getProperty("emp_replaced_lkup"),putility.getProperty("emp_txt_box"),EmpReplaced,"Create_JO",testCaseId);
				//switching to current frame
				su.SwitchFrames("ptifrmtgtframe");
			}
			
			//Selecting Business Unit from Drop down
			//su.SelectDropDown(test,putility.getProperty("business_unit"), Business_Unit,"Create_JO",testCaseId);
			
				
			//Entering Hiring Manager Id
			su.Processing();
			su.SetData(test,putility.getProperty("job_location"), jobLocation);
			su.checkPopUp(extent,test,"Create_JO",testCaseId,"job_location");    //TargetOpening
			su.SwitchFrames("ptifrmtgtframe");
			
			
			//Entering Union code only for specific job type
			if (JobOpeningType.equalsIgnoreCase("Wireline Associate")) {
				System.out.println("Entering Union code");
				su.SetLookUpValue(extent,test,putility.getProperty("union_code_lkup"),putility.getProperty("union_code_txt_Box"),Union_Code,"Create_JO",testCaseId);
				su.SwitchFrames("ptifrmtgtframe");
				su.Processing();	
				
				if(su.existsElement(putility.getProperty("cba"))){
					CBA = "004 - CWA Dist 9 - CA";
					su.SelectDropDown(test,putility.getProperty("cba"), CBA, "Create_JO", testCaseId);
					su.Processing();
				}
			}
			
			//Entering job code title
			su.Processing();
			su.SetLookUpValue(extent,test,putility.getProperty("job_code_title"),putility.getProperty("job_code_txt_box"),jobCodeTitle,"Create_JO",testCaseId);
			su.SwitchFrames("ptifrmtgtframe");
			su.Processing();
			
			//Entering Company and Department details if it is not auto populated
			if (su.existsElement(putility.getProperty("company"))){
				String  com = su.getText(putility.getProperty("company"));
				if (com == null || RsnForJobOpening.equalsIgnoreCase("New Headcount") ){
					su.SetData(test,putility.getProperty("company"), Company);
					su.Processing();
					su.SetData(test,putility.getProperty("department"), Department);
					su.Processing();
				}
				
			}
			
			
			//If Billable has any value then selecting from drop down
			if (Billable_Contractual != null && Billable_Contractual.trim().length() >0 ){
				su.SelectDropDown(test,putility.getProperty("billable_contractual"), Billable_Contractual,"Create_JO",testCaseId);
				su.Processing();
				su.SetData(test,putility.getProperty("company_client_name"), Company_Client_Name);
				su.Processing();				
			}
			
			//Clicking Yes for Pole climbing question for job type Wireline Associate
			if (JobOpeningType.equalsIgnoreCase("Wireline Associate")) {
				if(su.existsElement(putility.getProperty("pole_climbing"))){
					su.clickElement(test,putility.getProperty("pole_climbing"),"Position require pole climbing",testCaseId);
					System.out.println("Does this position require pole climbing is selected as : YES");
				}
				
			}
			
			//Entering Additional job specs if mentioned in data sheet
			
			su.SetData(test,putility.getProperty("hours"), Hours);
			su.checkPopUp(extent,test,"Create_JO",testCaseId,"hours");    
			su.SwitchFrames("ptifrmtgtframe");
			
			//Selecting travel Percentage from drop down
			su.SelectDropDown(test,putility.getProperty("travel_percentage"), TravelPercentage,"Create_JO",testCaseId);
			
			//Selecting Driving Requirements from Drop down
			su.SelectDropDown(test,putility.getProperty("driving_requirements"), Driving_Requirements,"Create_JO",testCaseId);
			
			//Selecting Security Clearance type from Drop down
			//su.SelectDropDown(test,putility.getProperty("security_clearance_type"), Security_Clearance_Type,"Create_JO",testCaseId);
			
			//Selecting Relocation from Drop down
			//su.SelectDropDown(test,putility.getProperty("relocation_package"), Relocation_Package);		
			
			//Adding first recruiter
			su.Processing();
			su.clickElement(test,putility.getProperty("add_recruiter_link"),"add_recruiter_link",testCaseId);
			su.SetLookUpValue(extent,test,putility.getProperty("add_recruiter_lkup"),putility.getProperty("emp_txt_box"),Addrecruiter,"Create_JO",testCaseId);
			su.SwitchFrames("ptifrmtgtframe");
			
			//Adding additional recruiter if needed
			if (Add_Recruiters.trim().length()>0){
				su.Processing();
				su.clickElement(test,putility.getProperty("add_recruiter_link"),"add_recruiter_link",testCaseId);
				su.SetLookUpValue(extent,test,putility.getProperty("add_recruiter_lkup_1"),putility.getProperty("emp_txt_box"),Add_Recruiters,"Create_JO",testCaseId);
				su.SwitchFrames("ptifrmtgtframe");
				test.log(LogStatus.PASS, "Additional recruiter should get added","Additional recruiter  '"+Add_Recruiters+"'  addedd successfully");
			}
			
			//Adding additional hiring manager if needed
			if (Add_Hiring_Managers.trim().length()>0){
				su.Processing();
				su.clickElement(test,putility.getProperty("add_hiring_manager"),"add_hiring_manager",testCaseId);
				su.SetLookUpValue(extent,test,putility.getProperty("add_hiring_mgr_lkup"),putility.getProperty("emp_txt_box"),Add_Hiring_Managers,"Create_JO",testCaseId);
				su.SwitchFrames("ptifrmtgtframe");
				test.log(LogStatus.PASS, "Additional hiring manager should get added","Add_Hiring_Managers  '"+Add_Hiring_Managers+"'  addedd successfully");
			}
			
			//Adding additional interviewer if needed
			if (Add_Interviewers.trim().length()>0){
				su.Processing();
				su.clickElement(test,putility.getProperty("add_interviewer_link"),"add_interviewer_link",testCaseId);
				su.SetLookUpValue(extent,test,putility.getProperty("add_interviewer_lkup"),putility.getProperty("emp_txt_box"),Add_Interviewers,"Create_JO",testCaseId);
				su.SwitchFrames("ptifrmtgtframe");
				test.log(LogStatus.PASS, "Additional Interviewers should get added","Add Interviewers   '"+Add_Interviewers+"'  addedd successfully");
			}
			
			//Adding additional parties  if needed
			if (Add_Interested_Parties.trim().length()>0){
				su.Processing();
				su.clickElement(test,putility.getProperty("add_interested_parties_link"),"add_interested_parties_link",testCaseId);
				su.SetLookUpValue(extent,test,putility.getProperty("add_interested_parties_lkup"),putility.getProperty("emp_txt_box"),Add_Interested_Parties,"Create_JO",testCaseId);
				su.SwitchFrames("ptifrmtgtframe");
				test.log(LogStatus.PASS, "Additional Interested Parties should get added","Additional Interested Parties   '"+Add_Interested_Parties+"'  addedd successfully");
			}
			
			//Adding additional locations  if needed
			if (Add_Additional_Locations.trim().length()>0){
				su.Processing();
				su.clickElement(test,putility.getProperty("additional_location_link"),"additional_location_link",testCaseId);
			}
			
		
		 } //Else part is for cloning an existing Job id
		 else if(Create_Clone.equalsIgnoreCase("Clone")) {
			 test.log(LogStatus.INFO, "Clone JOBS", "Usage: <span style='font-weight:bold;'>Cloning from an existing Job</span>");
			 
			//Navigating to Find Job Opening page
			su.Navigate_To_Menu(extent,test,navigate,"Create_JO",testCaseId);
			
			//Switching to a different frame to identify the objects on page
			su.SwitchFrames("ptifrmtgtframe");
			su.Processing();
			
			//Entering JO Id
			su.SetData(test,putility.getProperty("clone_job_opening_id"), cl_jo);
			
			//Click on Search button to find Job Opening
			su.clickElement(test,putility.getProperty("clone_search"),"clone_search",testCaseId);
			
			//Click on Resulting Job Opening
			su.clickElement(test,putility.getProperty("clone_click_job"),"clone_click_job",testCaseId);
			
			//Click on Clone Button
			su.Clone_Job(test,putility.getProperty("click_clone"),putility.getProperty("create_clone"),testCaseId);
		
			//Switching to Frame
			su.SwitchFrames("ptifrmtgtframe");
		 }
		
		//Navigating to Job posting page
		su.clickElement(test,putility.getProperty("job_posting_link"),"job_posting_link",testCaseId);
		
		//Removing special character from the JO header
		su.RemoveSpclChar(test,putility.getProperty("job_posting_header"));
		
		//Entering Job description in all the fields
		su.setJobDescription(test,putility.getProperty("job_description_txt"),"Create_JO",testCaseId,Create_Clone);

		//Clicking on Posting Destinations click
		su.clickElement(test,putility.getProperty("add_posting_destinations"),"add_posting_destinations",testCaseId);
	
		//Entering posting date and duration for the job
		su.setDate_PostDuration(test,PostDate,PostDuration,"Create_JO",testCaseId);
		su.Processing();
		
		//Selecting Referral Program ID or Opportunity Type
		su.SelectDropDown(test,putility.getProperty("referal_prgm_id"), Referral_PgmID,"Create_JO",testCaseId);
		
		su.SelectDropDown(test,putility.getProperty("staffing_oportunity_type"), StaffOpp_Type,"Create_JO",testCaseId);
		
		
		//Clicking on OK btn 
		su.clickElement(test,putility.getProperty("ok_btn"),"ok_btn",testCaseId);
		su.Processing();
		//Clicking on Submit button
		su.clickElement(test,putility.getProperty("save_submit_btn"),"save_submit_btn",testCaseId);
		//Checking for any error on submitting the job
		
		//Handling windows and 
		//Clicking on No to directly upload the job on site without approval
		su.Processing();
		su.WindowHandles();
		if (su.existsElement(putility.getProperty("no_btn"))){
			su.clickElement(test,putility.getProperty("no_btn"),"no_btn",testCaseId);
			//Again switching back to the previous frame
			su.SwitchFrames("ptifrmtgtframe");
		}else {
			su.checkPopUp(extent,test,"Create_JO",testCaseId,"Job_opening_type");
			su.SwitchFrames("ptifrmtgtframe");				
			}
		boolean val=true;
		//Fetching the new Job Id created
		if(su.existsElement(putility.getProperty("new_job_id"))){
			String  job_id = su.getText(putility.getProperty("new_job_id"));
			if (job_id.isEmpty()){
				excelUtils.setCellData("Create_JO", "FAIL", testCaseId, "Result_Status");
				test.log(LogStatus.FAIL, "New Job Id Creation", "Usage: <span style='font-weight:bold;'>Job Id could not be created</span>");
				test.log(LogStatus.FAIL, "New Job ID must be created"," New Job id for  "+testCaseId+" - "+TestCase_Desc+"  could not be craeted");
				Log.error("New Job id for  - "+testCaseId+" - "+TestCase_Desc+" - could not be created");
			} else {
				val=false;
				System.out.println("New Job for TC   '"+testCaseId+"'  is created as : "+job_id);
				excelUtils.setCellData("Create_JO", job_id, testCaseId, "Result_JO");
				excelUtils.setCellData("Create_JO", "PASS", testCaseId, "Result_Status");
				test.log(LogStatus.PASS, "New Job Id Creation", "Usage: <span style='font-weight:bold;'>Job Id created successfully</span>");
				test.log(LogStatus.PASS,"New Job ID must be created", " New Job id for  "+testCaseId+" - "+TestCase_Desc+"  is  - '"+job_id+"' created successfully");
				Log.info("New Job id for  "+testCaseId+" - "+TestCase_Desc+"  is  - '"+job_id+"' created successfully");			
			}	
			
		}
		 if(val){
			 throw new Exception("New Job id for  - "+testCaseId+" - "+TestCase_Desc+" - could not be created");  
		 }
		
	}
	
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  
		  DOMConfigurator.configure("log4j.xml");
		  Log.startTestCase("Start Execution");
		  Log.info("Staffing :: beforeClass() method invoked...");
		  extent.config().documentTitle("Staffing Automation");
		  extent.config().reportName("Creating Jobs");
		  extent.config().reportHeadline("-Staffing");
		 
				
	  }	
	
	  @AfterMethod
	  @Parameters("testCaseId")
	  public void afterMethod(String testCaseId) {
		  Log.info("Staffing :: afterClass() method invoked...");
		  try{
			  if (su.executeTestCase("Create_JO", testCaseId)){
					 //Handling the windows
					 su.WindowHandles();
					 //App log out
				 	su.AppLogout(test);
				 	su.Driverquit();
				 } 
			  //Ending the Entent test
			  extent.endTest(test);
			  //Writing the report to HTML format
			  extent.flush();    
		  } catch(Exception e){
			  Log.error("Staffing :: App Logout failed () :: Exception:"+e);
			  extent.endTest(test);
			  extent.flush();  
		  }
	  }	 
	
}
