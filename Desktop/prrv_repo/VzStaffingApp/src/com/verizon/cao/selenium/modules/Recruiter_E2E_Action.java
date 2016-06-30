package com.verizon.cao.selenium.modules;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
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
@SuppressWarnings("all")
public class Recruiter_E2E_Action implements ApplicationConstants{
	 PropertyUtility putility = new PropertyUtility(OBJECT_REPO_FILEPATH);
     StaffingUtil su = new StaffingUtil();
     ExcelUtils excelUtils = new ExcelUtils();
     public static ExtentReports extent = new ExtentReports(REPORT_PATH+"/RecruiterE2E.html", true,DisplayOrder.OLDEST_FIRST);
     private ExtentTest test ;
     public WebDriver driver;
     
     @Test
     @Parameters("testCaseId")
     public void REC_E2E(String testCaseId) throws Exception {
    	 
         System.out.println("Going to perform recruiter e2e action");
         
         //Starting the extent report
         test = extent.startTest("Performing Recruiter E2E Action for TestCase - '"+testCaseId);
         
         if (! MyConstants.executeTestCase){
 			test.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
 			throw new SkipException("Skipping the test case as application is not available.");			
 		}

 		if (! su.executeTestCase("Recruiter_e2e_Action", testCaseId)){
 			test.log(LogStatus.SKIP, "Skipping the test case as there is no data available for test case in DB.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
 			throw new SkipException("Skipping the test case as there is no data available for test case in DB.");			
 		}
 		
         //Initiating log4j
         Log.startTestCase(testCaseId);
         //Declaring alll required variables
         String TestCase_Desc,URL,Login,Pwd, navigate,Appln_Type,Applicant_Id, JobOpening_Id,Take_Action,JobOpening_Type, Status_Code, Status_ReasonStatus_Reason, Take_Action_1, Interview_Type;
         String Status_Reason, Apply_Rate, Over_All_rate, Recommen, Take_Action_2, Adjustment, Action_Job, Action_Rs, Total_Wages,Effective_sal;
         String  New_Wages, Rec_NPID, New_salary, Cost_Company, Change_Sal,Job_Offer_Status, Submit_Offer, Save_Offer, Submit_Offer_2,Reloc;
         try{
             ExcelUtils.setExcelFile(DATA_FILEPATH,"Recruiter_e2e_Action");
             TestCase_Desc = ExcelUtils.getExcelData("TC_Desc",testCaseId);
             URL = ExcelUtils.getExcelData("URL",testCaseId);
             Login = ExcelUtils.getExcelData("Login",testCaseId);
             Pwd = ExcelUtils.getExcelData("Pwd",testCaseId);
             navigate = ExcelUtils.getExcelData("Navigation1",testCaseId);
             Appln_Type = ExcelUtils.getExcelData("Applicant_Type",testCaseId);
             Applicant_Id = ExcelUtils.getExcelData("ApplicantID",testCaseId);
             JobOpening_Id = ExcelUtils.getExcelData("JobOpening_ID",testCaseId);
             Take_Action = ExcelUtils.getExcelData("Take_Action",testCaseId);
             JobOpening_Type = ExcelUtils.getExcelData("JobOpeningType",testCaseId);
             Status_Code = ExcelUtils.getExcelData("StatusCode",testCaseId);
             Status_Reason = ExcelUtils.getExcelData("Status_Reason",testCaseId);
             Take_Action_1 = ExcelUtils.getExcelData("Take_Action1",testCaseId);
             Interview_Type= ExcelUtils.getExcelData("InterviewType",testCaseId);
             Apply_Rate = ExcelUtils.getExcelData("Apply_Ratings",testCaseId);
             Over_All_rate = ExcelUtils.getExcelData("OverallRating",testCaseId);
             Recommen = ExcelUtils.getExcelData("Recommendation",testCaseId);
             Take_Action_2 = ExcelUtils.getExcelData("Take_Action2",testCaseId);
             Adjustment = ExcelUtils.getExcelData("Adjustment_Rsn",testCaseId);
             Effective_sal = ExcelUtils.getExcelData("EFFDT_New_Sal",testCaseId);
             Action_Job = ExcelUtils.getExcelData("Action",testCaseId);
             Action_Rs = ExcelUtils.getExcelData("Action_Reason",testCaseId);
             Total_Wages = ExcelUtils.getExcelData("Total_Wage_Credits_Given",testCaseId);
             New_Wages = ExcelUtils.getExcelData("NewWage_Step",testCaseId);
             Rec_NPID = ExcelUtils.getExcelData("NPID",testCaseId);
             New_salary = ExcelUtils.getExcelData("New_Base_Sal",testCaseId);
             Cost_Company = ExcelUtils.getExcelData("Cost_To_Company",testCaseId);
             Change_Sal = ExcelUtils.getExcelData("ChangeinSalary",testCaseId);
             Reloc = ExcelUtils.getExcelData("Reloc_Package",testCaseId);
             Job_Offer_Status = ExcelUtils.getExcelData("JobOffer_Status",testCaseId);
             Submit_Offer = ExcelUtils.getExcelData("Submit_JobOffer",testCaseId);
             Save_Offer = ExcelUtils.getExcelData("Save_JobOffer1",testCaseId);
             Submit_Offer_2 = ExcelUtils.getExcelData("Submit_JobOffer2",testCaseId);
         }
         catch (Exception e){
             System.out.println("Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e);
             Reporter.log("Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exception : "+ e);
             test.log(LogStatus.FAIL,"Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e);
             excelUtils.setCellData("Recruiter_e2e_Action", "FAIL", testCaseId, "Result_Status");
             excelUtils.setCellData("Recruiter_e2e_Action", "Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e, testCaseId, "Result_Errors");
             throw new Exception("Error occured while trying to login to the application  -  " +e);
         }
         
         test.log(LogStatus.INFO, "App Launch and Login", "Usage: <span style='font-weight:bold;'>Going To launch URL and Login in the application</span>");

         //Launching the application
         su.LaunchUrl(extent,test,URL,"Recruiter_e2e_Action",testCaseId);
         
         //Logging into the application
         su.Staffing_Login(extent,test,Login,Pwd,"Recruiter_e2e_Action",testCaseId);
         
         Log.info("Executing Test Case **** - "+testCaseId+" "+TestCase_Desc );
         System.out.println("Executing Test Case **** - "+testCaseId+" "+TestCase_Desc );
         
          test.log(LogStatus.INFO, "Recruiter E2E Action Initiation", "Usage: <span style='font-weight:bold;'>Recruiter E2E Action Initiated</span>");
          
         //Navigating to Create Job Opening page
         su.Navigate_To_Menu(extent,test, navigate,"Recruiter_e2e_Action",testCaseId);
         
         //Switching to a different frame to identify the objects on page
         su.SwitchFrames("ptifrmtgtframe");
         su.ProcessingRE2E();
         
         
         //Check if the applicant has "Link Application to Job" option
         if (Take_Action.length() != 0){
                         
         //Entering Applicant ID
         su.EnterData(putility.getProperty("rec_appln_id"),Applicant_Id);

         //Deselect the Status
         su.DeSelectDropDown(test,putility.getProperty("rec_appln_status"),"","Recruiter_e2e_Action",testCaseId);
         
         
         //Click Find Applicant 
         su.clickElement(test,putility.getProperty("rec_find_appln_search"),"rec_find_appln_search", testCaseId);
         
         su.ProcessingRE2E();
         
         //Searching the applicant
         su.alert(Applicant_Id);
         
         su.sleep(3000);
         String select_disposition = su.getText(putility.getProperty("rec_inter_disposition"));
         
         System.out.println("Disposition is "+select_disposition);
         
         //check the disposition status is selected or not
         if (select_disposition.contains("Accepted")){
        	test.log(LogStatus.PASS, "Recruiter E2E Action","Usage: <span style='font-weight:bold;'>Applicant - "+Applicant_Id+" had already been Accepted so exiting the Test Case</span>");
			Log.info("Applicant  - "+Applicant_Id+" had already been Accepted so exiting the Test Case");
			Reporter.log("Applicant  - "+Applicant_Id+" had already been Accepted so exiting the Test Case");
			excelUtils.setCellData("Recruiter_e2e_Action", "PASS", testCaseId, "Result_Status");
			excelUtils.setCellData("Recruiter_e2e_Action", "Applicant - "+Applicant_Id+" had already been Accepted so exiting the Test Case", testCaseId,"Result_Errors");
			throw new SkipException("Applicant - "+Applicant_Id+" had already been Accepted so exiting the Test Case");
         }else{
        	 System.out.println("NOT FOUND");
         }
         
         //Checking the satus of the applicant
         
         //Select Link Application to Job option from the drop down
         su.SelectDropDown(test,putility.getProperty("rec_select_action"),Take_Action,"Recruiter_e2e_Action",testCaseId);
         
         //Linked Applicant to Job opening ID
         su.rec_action1(test,putility.getProperty("rec_select_link_action"), Status_Reason, putility.getProperty("rec_job_id_link_action"), JobOpening_Id, putility.getProperty("rec_submit_link_action"),"Recruiter_e2e_Action",testCaseId);
         
         //check whether the applicant is already linked with the job opening id. If exists suppress the pop up and then exit from the program
         
         try {
         	 String get_pop_txt = su.chk_popup(test,putility.getProperty("rec_link_popup"),putility.getProperty("rec_link_cancel_popup"), testCaseId);
  			 if (get_pop_txt!=null){
  	            System.out.println(get_pop_txt);
  	            su.rec_switchFrame(putility.getProperty("rec_mod_frame"));
  	            su.clickElement(test,putility.getProperty("rec_cancel_link_action"),"rec_cancel_link_action", testCaseId);
                 su.default_content();
                 //return;
              }
         }
			catch ( Exception e){
				System.out.println("No Pop up appeared");	
			}
         
         su.SwitchFrames("ptifrmtgtframe");
         
         //su.sleep(3000);
         
         String link_status = su.getText(putility.getProperty("rec_link_success_msg"));
         
         if (link_status.contains("You have successfully linked Applicant(s) to Job Opening.")){
         	System.out.println("Applicant id "+Applicant_Id+" sucessfully linked to the job id "+JobOpening_Id+" and return success message is "+link_status);
         }
         else{
         	 System.out.println("Applicant id "+Applicant_Id+" not linked with the job opening id "+JobOpening_Id);
             // return;            
         }
         
         su.WindowHandles();
         
         //Navigating to Find Job Opening link
         String nav="Recruiting>Find Job Openings";
         su.Navigate_To_Menu(extent,test,nav,"Recruiter_e2e_Action",testCaseId);
         su.SwitchFrames("ptifrmtgtframe");
         }
         
         
         //Entered Jon Opening ID
         su.SetData(test,putility.getProperty("rec_job_id"), JobOpening_Id);

         //Click Search Button
         su.clickElement(test,putility.getProperty("rec_job_search"),"rec_job_search", testCaseId);
                         
         su.ProcessingRE2E();
         
         
         //Click on the Job Opening 
         su.clickElement(test,putility.getProperty("rec_ext_job"),"rec_ext_job", testCaseId);
                         
         su.ProcessingRE2E();
         
         //Click Find element
         su.clickElement(test,putility.getProperty("rec_ext_find_job"),"rec_ext_find_job", testCaseId);
         
         //Find the applicant information by providing Applicant Id in the alert box
         su.alert(Applicant_Id);
         su.checkPopUp(extent,test,"Recruiter_e2e_Action",testCaseId,"Searching the applicant ID");    //TargetOpening
		 su.SwitchFrames("ptifrmtgtframe");
      
         su.sleep(3000);
         String select_disposition1 = su.getText(putility.getProperty("rec_inter_disposition"));
         
         System.out.println("Disposition is "+select_disposition1);
         
         //check the disposition status is selected or not
         if (select_disposition1.contains("Accepted")){
        	test.log(LogStatus.PASS, "Recruiter E2E Action","Usage: <span style='font-weight:bold;'>Applicant - "+Applicant_Id+" had already been Accepted so exiting the Test Case</span>");
			Log.info("Applicant  - "+Applicant_Id+" had already been Accepted so exiting the Test Case");
			Reporter.log("Applicant  - "+Applicant_Id+" had already been Accepted so exiting the Test Case");
			excelUtils.setCellData("Recruiter_e2e_Action", "PASS", testCaseId, "Result_Status");
			excelUtils.setCellData("Recruiter_e2e_Action", "Applicant - "+Applicant_Id+" had already been Accepted so exiting the Test Case", testCaseId,"Result_Errors");
			throw new SkipException("Applicant - "+Applicant_Id+" had already been Accepted so exiting the Test Case");
         }else{
        	 System.out.println("NOT FOUND");
         }
         
         //Select Create Interview Evaluation from Take Action Drop Down
         su.SelectDropDown(test,putility.getProperty("rec_ext_sel_action"),Take_Action_1,"Recruiter_e2e_Action",testCaseId);
         
         su.rec_create_interview(test,putility.getProperty("rec_inter_option"),Interview_Type,putility.getProperty("rec_select_all"),putility.getProperty("rec_apply_lookup"),Apply_Rate, putility.getProperty("rec_click_rate"),putility.getProperty("rec_click_go"),putility.getProperty("rec_overall_rating"),Over_All_rate,putility.getProperty("rec_recommen"),Recommen,putility.getProperty("rec_submit_eval"),"Recruiter_e2e_Action",testCaseId);
         
         su.ProcessingRE2E();
         
         System.out.println("Test Process");
         
         su.SwitchFrames("ptifrmtgtframe");
         
         System.out.println("Test Process1");
         
         su.ProcessingRE2E();
         
         //Click Find Element 
         su.clickElement(test,putility.getProperty("rec_prepare_find"),"rec_prepare_find", testCaseId);
         
         su.alert(Applicant_Id);
         
         //Get Disposition Status after interview evaluation 
         String select_disposition = su.getText(putility.getProperty("rec_inter_disposition"));
         
         System.out.println("Disposition is "+select_disposition);
         
         //check the disposition status is selected or not
         if (select_disposition.contains("Selected")){
                         
         //Select Prepare Job Offer Option from Take Action Drop Down
         su.SelectDropDown(test,putility.getProperty("rec_prepare_action"),Take_Action_2,"Recruiter_e2e_Action",testCaseId);
         
      // checking comp_plan_id if drop down is available it will  select the 1st item from drop down list

         if(su.existsElement(putility.getProperty("comp_plan_id"))){
        	 su.SelectDropDownByIndex(test,putility.getProperty("comp_plan_id"),1,"Recruiter_e2e_Action",testCaseId);
         } 
         
         //Check if the applicant is External
         if (Appln_Type.equals("External")){
          
             //Check If the Applicant is an Associate External
             if(JobOpening_Type.contains("Associate")){
                 System.out.println("External Associate Employee");
                 //Set Effective Date as Next Sunday date
                 su.SetData(test,putility.getProperty("rec_effective_new"), su.get_sunday(2)); 
                 //Select Hire option for Action and Select Hire No Previous for Action Reason
                 su.SelectDropDown(test,putility.getProperty("action_ext"),Action_Job,"Recruiter_e2e_Action",testCaseId);
               //checking Pop up for Effective Date Field
                 String get_effective_pop1 = su.chk_popup(test,putility.getProperty("rec_link_popup"),putility.getProperty("rec_ok_popup"), testCaseId);
 				if (get_effective_pop1!=null){
 			    	su.SwitchFrames("ptifrmtgtframe");
 			    	su.EnterData(putility.getProperty("rec_effective_new"), su.get_sunday(3));
 			    	//su.clickElement(test,putility.getProperty("action_res"),"action_res");
 			    	su.clickElement(test,"//input[@id='B_RS_OFFER_WRK_STEP$169$']","action_res", testCaseId);
 					su.ProcessingRE2E();
 				}
 				else{
 					su.SwitchFrames("ptifrmtgtframe");
 				}
 				su.SelectDropDown(test,putility.getProperty("action_ext"),Action_Job,"Recruiter_e2e_Action",testCaseId);
	             su.SelectDropDown(test,putility.getProperty("action_res_ext"),Action_Rs,"Recruiter_e2e_Action",testCaseId);
	             su.SelectDropDown(test,putility.getProperty("action_ext"),Action_Job,"Recruiter_e2e_Action",testCaseId);
	             su.SelectDropDown(test,putility.getProperty("action_res_ext"),Action_Rs,"Recruiter_e2e_Action",testCaseId);
	             //First Total Wage option is enabled, If it is set value for Total Wage Credits given.
	             su.rec_check_total_wage(test,putility.getProperty("rec_totalwage_label"),putility.getProperty("rec_totalwage_data"),Total_Wages);
	             //Click Save button.
	             su.clickElement(test,putility.getProperty("rec_save_offer"),"rec_save_offer", testCaseId);
	             su.ProcessingRE2E();
             }
             else if(JobOpening_Type.contains("VDSI")){
                 System.out.println("VDSI Employee");
                 //Enter New Base Salary
                 su.SetData(test,putility.getProperty("rec_new_base"), Cost_Company);
                 //click Submit Button
                 su.clickElement(test,putility.getProperty("rec_submit_offer"),"rec_submit_offer", testCaseId);
                 su.ProcessingRE2E();
             }             
             
             else{
                 su.SetData(test,putility.getProperty("rec_new_base"), New_salary);
                 try {
	                    String con_rel_value = putility.getProperty("rec_select_reloc")+Reloc+"')]";
	                    
	                    //check Relocation Field is exists or not
	                    if(su.existsElement(putility.getProperty("rec_check_drop_down")) ==true)
	                    { 
	                        su.clickElement(test,putility.getProperty("rec_clk_reloc"),"rec_clk_reloc", testCaseId);
	                        su.ProcessingRE2E();
	                        System.out.println("inside the loop");
	                        su.clickElement(test,con_rel_value,"con_rel_value", testCaseId);
	                    }
                 }
                 catch (Exception e){
                      System.out.println("No Relocation field");
                 }
                 su.clickElement(test,putility.getProperty("rec_submit_offer"),"rec_submit_offer", testCaseId);
                 su.ProcessingRE2E();
             }
                         
         }
         
         //For Internal Applicants
         if (Appln_Type.equals("Internal")){
        	 if (!JobOpening_Type.contains("Associate")){
                 System.out.println("Not Internal Associate Employee");
                 su.SelectDropDown(test,putility.getProperty("rec_adj_reason"),Adjustment,"Recruiter_e2e_Action",testCaseId);
                 
                 if (su.existsElement(putility.getProperty("rec_chgin_sal")))
                 su.SetData(test,putility.getProperty("rec_chgin_sal"), Change_Sal);
                 
                 try {
                  String con_rel_value = putility.getProperty("rec_select_reloc")+Reloc+"')]";
                //check Relocation Field is exists or not
                  if(su.existsElement(putility.getProperty("rec_check_drop_down")) ==true)
                         {              
                         su.clickElement(test,putility.getProperty("rec_clk_reloc"),"rec_clk_reloc", testCaseId);
                         su.ProcessingRE2E();
                         System.out.println("inside the loop");
                         su.clickElement(test,con_rel_value,"con_rel_value", testCaseId);
                         }
	              }
	              catch (Exception e){
	                   System.out.println("No Relocation field");
	              }
	                 su.clickElement(test,putility.getProperty("rec_submit_offer"),"rec_submit_offer", testCaseId);
	                 su.ProcessingRE2E();
		      }
	          else if(JobOpening_Type.contains("Associate")){
	          	 System.out.println("Internal Associate Employee");
	               su.SetData(test,putility.getProperty("rec_effective_new"), su.get_sunday(2));
	               su.SelectDropDown(test,putility.getProperty("action"),Action_Job,"Recruiter_e2e_Action",testCaseId);
	               //checking Pop up for Effective Date Field
	               String get_effective_pop = su.chk_popup(test,putility.getProperty("rec_link_popup"),putility.getProperty("rec_ok_popup"), testCaseId);
					if (get_effective_pop!=null){
				    	su.SwitchFrames("ptifrmtgtframe");
				    	su.EnterData(putility.getProperty("rec_effective_new"), su.get_sunday(3));
				    	//su.clickElement(test,putility.getProperty("action_res"),"action_res");
				    	su.clickElement(test,"//input[@id='B_RS_OFFER_WRK_STEP$169$']","action_res", testCaseId);
						su.ProcessingRE2E();
					}
					else{
						su.SwitchFrames("ptifrmtgtframe");
					}
					
				   su.SelectDropDown(test,putility.getProperty("action"),Action_Job,"Recruiter_e2e_Action",testCaseId);
				   su.ProcessingRE2E();
	               if(su.SelectDropDown(test,putility.getProperty("action_res"),Action_Rs,"Recruiter_e2e_Action",testCaseId)){
	            	   
	               }
	               else{
	            	   su.SelectDropDownByIndex(test,putility.getProperty("action_res"),1,"Recruiter_e2e_Action",testCaseId); 
	               }
	               /*su.sleep(1000);
	               su.SelectDropDown(test,putility.getProperty("action"),Action_Job,"Recruiter_e2e_Action",testCaseId);
	               su.sleep(1000);
	               su.SelectDropDown(test,putility.getProperty("action_res"),Action_Rs,"Recruiter_e2e_Action",testCaseId);*/
	               
	               
	               su.rec_check_total_wage(test,putility.getProperty("rec_totalwage_label"),putility.getProperty("rec_totalwage_data"),Total_Wages);
	               String get_date = su.GetCurrentSystemDate();
	               String year[] = get_date.split("/");
	               System.out.println(year[2]);
	               int a = Integer.parseInt(year[2]);
	               int b = 1;
	               int res = a + b;
	               System.out.println(res);
	               String year_in = year[0].toString()+"/"+year[1].toString()+"/"+res;
	               System.out.println(year_in);
	               su.SetData(test,putility.getProperty("rec_npid"),year_in);
	               su.clickElement(test,putility.getProperty("rec_save_offer"),"rec_save_offer", testCaseId);
	               su.ProcessingRE2E();
	          }              
         }       
         
         if (Appln_Type.equals("External")){
        	 //if (!TestCase_Desc.contains("Associate External")){
        	 if (!JobOpening_Type.contains("Associate")){
                 su.rec_check_status(test,putility.getProperty("rec_chk_job_status"),putility.getProperty("rec_check_approval"), "009 Approved",putility.getProperty("rec_submit_offer"),putility.getProperty("rec_new_base"),"Recruiter_e2e_Action",testCaseId);
             }
         }
         
         if (Appln_Type.equals("Internal")){
             if (!JobOpening_Type.contains("Associate")){
                 su.rec_check_status(test,putility.getProperty("rec_chk_job_status"),putility.getProperty("rec_check_approval"), "009 Approved",putility.getProperty("rec_submit_offer"),putility.getProperty("rec_chgin_sal"),"Recruiter_e2e_Action",testCaseId);
             }
         }
         
         su.SelectDropDown(test,putility.getProperty("rec_chk_job_status"),"020 Accept","Recruiter_e2e_Action",testCaseId);
         
         if (Save_Offer.equals("Y")){
             su.clickElement(test,putility.getProperty("rec_save_offer"),"rec_save_offer", testCaseId);
             su.ProcessingRE2E();
         }
         else if (Submit_Offer_2.equals("Y")){
	         su.clickElement(test,putility.getProperty("rec_submit_offer"),"rec_submit_offer", testCaseId);
	         su.ProcessingRE2E();
         }
         
         String get_pop = su.chk_popup(test,putility.getProperty("rec_link_popup"),putility.getProperty("rec_ok_popup"), testCaseId);
         
         if (get_pop!=null){
	         System.out.println(get_pop);
	         su.SwitchFrames("ptifrmtgtframe");
	         su.clickElement(test,putility.getProperty("rec_save_offer"),"rec_save_offer", testCaseId);
	         su.ProcessingRE2E();
         }
         else{
         su.SwitchFrames("ptifrmtgtframe");
         }
         
         su.clickElement(test,putility.getProperty("rec_prv_link"),"rec_prv_link", testCaseId);
         
         su.ProcessingRE2E();
         
         su.clickElement(test,putility.getProperty("rec_prepare_find"),"rec_prepare_find", testCaseId);
                     
         su.alert(Applicant_Id);
                     
         String prepare_disposition = su.getText(putility.getProperty("rec_inter_disposition"));
         
         System.out.println("Disposition is "+prepare_disposition);
         
         //check the Disposition status is Accepted or not.
         if (prepare_disposition.equalsIgnoreCase("Accepted") ){
        	 excelUtils.setCellData("Recruiter_e2e_Action", "PASS", testCaseId, "Result_Status");
          	excelUtils.setCellData("Recruiter_e2e_Action", "Disposition status is Accepted", testCaseId, "Result_Errors");
  			test.log(LogStatus.INFO, "RecruiterE2E_Action", "Usage: <span style='font-weight:bold;'>RecruiterE2E_Action completed successfully</span>");
  			test.log(LogStatus.PASS,"RecruiterE2E_Action should be3 completed ","RecruiterE2E_Action completed successfully for the applicant  - '"+Applicant_Id+"'");
  			Log.info("RecruiterE2E_Action completed successfully for the applicant  - '"+Applicant_Id+"'");
         }	
 		 else{
			excelUtils.setCellData("Recruiter_e2e_Action", "FAIL", testCaseId, "Result_Status");
			excelUtils.setCellData("Recruiter_e2e_Action", "Disposition status is selected. It should be Accepted.", testCaseId, "Result_Errors");
			test.log(LogStatus.INFO, "RecruiterE2E_Action", "Usage: <span style='font-weight:bold;'>RecruiterE2E_Action failed</span>");
			test.log(LogStatus.FAIL,"RecruiterE2E_Action should be3 completed ","RecruiterE2E_Action could not be completed ");
			Log.error("RecruiterE2E_Action could not be completed for the applicant  - '"+Applicant_Id+"'");	
			Reporter.log("Applicant - "+Applicant_Id+" status did not change from Selected to Accepted even after performing all the steps");
			throw new Exception("Applicant - "+Applicant_Id+" status did not change from Selected to Accepted even after performing all the steps");
 		  }
         
        }  
    }


	@BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
	    Log.startTestCase("Start Execution");
	    Log.info("Staffing :: beforeClass() method invoked...");
	    extent.config().documentTitle("Staffing Automation");
	    extent.config().reportName("RecruiterE2E_Action");
	    extent.config().reportHeadline("-Staffing");    
	}              

	@AfterMethod
	  public void afterMethod() {
		  Log.info("Staffing :: afterClass() method invoked...");
		  try{
		  	 //Handling the windows
			 su.WindowHandles();
			 //App log out
			 su.AppLogout(test);
			 su.Driverquit();
			 //Ending the Extent test
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
