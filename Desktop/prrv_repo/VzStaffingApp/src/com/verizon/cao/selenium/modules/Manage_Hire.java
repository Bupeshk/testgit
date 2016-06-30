package com.verizon.cao.selenium.modules;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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




public class Manage_Hire implements ApplicationConstants{
	
	PropertyUtility putility = new PropertyUtility(OBJECT_REPO_FILEPATH);
	StaffingUtil su = new StaffingUtil();
	ExcelUtils excelUtils = new ExcelUtils();
	public static ExtentReports extent = new ExtentReports(REPORT_PATH+"/ManageHire.html", true,DisplayOrder.OLDEST_FIRST);
	 private ExtentTest test ;
	
	@Test
	@Parameters("testCaseId")
	
	public void MHR (String testCaseId) throws Exception {
		//Starting the extent report
		test = extent.startTest("Manage Hire for testcase - '"+testCaseId);
		/*if (! MyConstants.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
			throw new SkipException("Skipping the test case as application is not available.");			
		}*/

		 if (! su.executeTestCase("Manage_Hire", testCaseId)){
             test.log(LogStatus.SKIP, "Skipping the test case as there is no data available for test case in DB.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
             throw new SkipException("Skipping the test case as there is no data available for test case in DB.");                                                
		}
		System.out.println("Going to start Manage Hire");
		//Initiating log4j

		Log.startTestCase(testCaseId);
		String TC_Desc,Applicant_Type,Applicant_Type_Desc,navigate,URL,Login,Pwd,JO,JO_Desc,APPLID,Emplid,Result_Status,Result_Errors,Desired_Start_Dt,Add_Person,Add_Job,Job_Data_OK;
		String DOB,Gender,Marital_Status,Add_Relationship,Job_ID;
		try{
			ExcelUtils.setExcelFile(DATA_FILEPATH,"Manage_Hire");
			TC_Desc = ExcelUtils.getExcelData("TC_Desc",testCaseId);
			Applicant_Type = ExcelUtils.getExcelData("Applicant_Type",testCaseId);
			//Applicant_Type_Desc = ExcelUtils.getExcelData("Applicant_Type_Desc",testCaseId);
			JO = ExcelUtils.getExcelData("JO",testCaseId);
			//JO_Desc = ExcelUtils.getExcelData("JO_Desc",testCaseId);
			navigate = ExcelUtils.getExcelData("Navigation",testCaseId);
			URL = ExcelUtils.getExcelData("URL",testCaseId);
			Login = ExcelUtils.getExcelData("Login",testCaseId);
			Pwd = ExcelUtils.getExcelData("Pwd",testCaseId);
			APPLID = ExcelUtils.getExcelData("APPLID",testCaseId);
			Emplid = ExcelUtils.getExcelData("Emplid",testCaseId);
			Result_Status = ExcelUtils.getExcelData("Result_Status",testCaseId);
			Result_Errors = ExcelUtils.getExcelData("Result_Errors",testCaseId);
			Desired_Start_Dt = ExcelUtils.getExcelData("Desired_Start_Dt",testCaseId);
			Add_Person = ExcelUtils.getExcelData("Add_Person",testCaseId);
			Add_Job = ExcelUtils.getExcelData("Add_Job",testCaseId);
			Job_Data_OK = ExcelUtils.getExcelData("Job_Data_OK",testCaseId);
			DOB = ExcelUtils.getExcelDate("DOB",testCaseId);
			Gender = ExcelUtils.getExcelData("Gender",testCaseId);
			Marital_Status = ExcelUtils.getExcelData("Marital_Status",testCaseId);
			Add_Relationship = ExcelUtils.getExcelData("Add_Relationship",testCaseId);
			Job_ID = ExcelUtils.getExcelData("Job_ID",testCaseId);
		}
		catch (Exception e){
			System.out.println("Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e);
			Reporter.log("Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exception : "+ e);
			test.log(LogStatus.FAIL,"Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e);
			excelUtils.setCellData("Manage_Hire", "FAIL", testCaseId, "Result_Status");
			excelUtils.setCellData("Manage_Hire", "Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e, testCaseId, "Result_Errors");
			throw new Exception("Error occured while trying to login to the application  -  " +e);
		}		
		
		test.log(LogStatus.INFO, "App Launch and Login", "Usage: <span style='font-weight:bold;'>Going To launch URL and Login in the application</span>");
		//Launching the application
		su.LaunchUrl(extent,test,URL,"Manage_Hire",testCaseId);
		//Logging into the application
		su.Staffing_Login(extent,test,Login,Pwd,"Manage_Hire",testCaseId);
		Log.info("Executing Test Case "+testCaseId+" "+TC_Desc );
		System.out.println("Executing Test Case "+testCaseId+" "+TC_Desc );
				
		//Navigating to Create Job Opening page
		su.Navigate_To_Menu(extent,test, navigate,"Manage_Hire",testCaseId);
		
		//Switching to a different frame to identify the objects on page
		su.SwitchFrames("ptifrmtgtframe");
		su.Processing();
		
		//Condition to check if new job is to created or to be cloned from existing job
		 if (Applicant_Type.equalsIgnoreCase("Internal") || Applicant_Type.equalsIgnoreCase("External") ){
			 
			 test.log(LogStatus.INFO, "Manage Hire", "Usage: <span style='font-weight:bold;'>Going to start manage Hire for "+Applicant_Type+" candidate</span>");
			 //Searching applicant and clicking on it
			 if(su.searchApplicant_ManageHire(extent,test,APPLID,"Manage_Hire",testCaseId)){
					test.log(LogStatus.PASS, "Applicant search Page of Manage Hire","Usage: <span style='font-weight:bold;'>Applicant -"+APPLID+"- found and clicked sucessfully for Manage Hire</span>");
             }else{
                test.log(LogStatus.FAIL,"Applicant search Page of Manage Hire","Usage: <span style='font-weight:bold;'>Applicant -"+APPLID+"- not found and test case has failed</span>");
                Log.info("Applicant not found, so exiting the test cases");
                excelUtils.setCellData("Manage_Hire", "FAIL", testCaseId, "Result_Status");
                excelUtils.setCellData("Manage_Hire", "Applicant Search Failed", testCaseId,"Result_Errors");
                su.takeScreenShot(test, "Manage_Hire", testCaseId, "Error occured while searching the applicant -"+APPLID+"- for Manage Hire");
                throw new Exception("Error occured while searching the applicant -"+APPLID+"- for Manage Hire");
	         }
			
			 //Storing current window in a variable
			 String currWinName = su.getCurrWindowName();
			 
			 
			 if(Desired_Start_Dt.equalsIgnoreCase("Current_Dt"))
			 su.SetData(test, putility.getProperty("desired_start_date"), su.GetCurrentSystemDate());
			 	
			 if (Applicant_Type.equalsIgnoreCase("Internal"))
				 su.clickElement(test, putility.getProperty("add_job_btn"), "add_job_btn", testCaseId);
			 else if (Applicant_Type.equalsIgnoreCase("External"))
				 su.clickElement(test, putility.getProperty("add_person_btn"), "add_person_btn", testCaseId);
			
			//Changing from parent to new window
			su.newWindowHandles();
			
			su.SwitchFrames("ptifrmtgtframe");
			su.ProcessingRE2E();			 
			 
			
			if (Applicant_Type.equalsIgnoreCase("External")){
				if(DOB!= null){
					System.out.println("Date in excel is "+DOB);
					String appDOB = su.getText(putility.getProperty("dob"));
					if(appDOB!= null){
						System.out.println("Date is already present");
					}
					else{
						su.SetData(test, putility.getProperty("dob"), DOB);
						su.ProcessingRE2E();
					}
						
				}
				
				if(Gender != null)
					su.SelectDropDown(test, putility.getProperty("emp_gender"), Gender, "Manage_Hire", testCaseId);
				su.ProcessingRE2E();	
						
				if(Marital_Status != null)
					su.SelectDropDown(test, putility.getProperty("emp_marital_status"), Marital_Status, "Manage_Hire", testCaseId);
				
				su.ProcessingRE2E();
				
				su.clickElement(test, putility.getProperty("contact_info_tab"), "contact_info_tab", testCaseId);
				su.ProcessingRE2E();
				
				if(su.existsElement(putility.getProperty("telephone_no"))){
					String tele_no =su.getText(putility.getProperty("telephone_no"));
					if(tele_no != null && tele_no.trim().length()>0){
						System.out.println("Telephone number is already there");
						System.out.println("telephone number is "+tele_no);
					}
					else{
						su.SetData(test, putility.getProperty("telephone_no"), "4697730233");
						su.ProcessingRE2E();
					}
				}
				
				su.clickElement(test, putility.getProperty("regional_tab"), "regional_tab", testCaseId);
				su.ProcessingRE2E();
				
				su.clickElement(test, putility.getProperty("organizational_relationship_tab"), "organizational_relationship_tab", testCaseId);
				su.ProcessingRE2E();
				
				su.waitForElement(putility.getProperty("add_relationship_btn"));
				
				if(Add_Relationship.equalsIgnoreCase("Y")){
					if(su.existsElement(putility.getProperty("add_relationship_btn"))){
						su.clickElement(test, putility.getProperty("add_relationship_btn"), "add_relationship_btn", testCaseId);
						su.ProcessingRE2E();
					}
				}
				
			}
			boolean val=true;
			//Clicking on save btn to submit the TC
			 if(su.waitForElement(putility.getProperty("save_btn"))){
				 test.log(LogStatus.PASS,"New Window should opened for "+Applicant_Type+" Candidate","Usage: <span style='font-weight:bold;'>New Window opened for "+Applicant_Type+" Candidate sucesssfully after clicking Add Job link</span>");
				 su.clickElement(test, putility.getProperty("save_btn"), "save_btn", testCaseId);
				 su.Processing();
				 //Checking for success image
				 if (Applicant_Type.equalsIgnoreCase("Internal")){
					 su.waitForElement(putility.getProperty("sucess_saved_img"));
					 if(su.existsElement(putility.getProperty("sucess_saved_img"))){
						 System.out.println("Done sucessfully");
						 test.log(LogStatus.PASS,"Manage Hire for "+Applicant_Type+" Candidate sould get complete","Usage: <span style='font-weight:bold;'>Manage Hire for "+Applicant_Type+" Candidate completed sucesssfully</span>");
						 Log.info("Manage Hire for Internal Candidate completed sucesssfully");
			             excelUtils.setCellData("Manage_Hire", "PASS", testCaseId, "Result_Status");
			             excelUtils.setCellData("Manage_Hire", "Manage Hire for "+Applicant_Type+" Candidate completed sucessfully", testCaseId,"Result_Errors");
			             val=false;
					 }
					 else{
						 test.log(LogStatus.FAIL,"Manage Hire for "+Applicant_Type+" Candidate sould get complete","Usage: <span style='font-weight:bold;'>Manage Hire for "+Applicant_Type+" Candidate failed</span>"); 
			             Log.error("Manage Hire for "+Applicant_Type+" Candidate could not be completed");
			             excelUtils.setCellData("Manage_Hire", "FAIL", testCaseId, "Result_Status");
			             excelUtils.setCellData("Manage_Hire", "Manage Hire for "+Applicant_Type+" Candidate failed", testCaseId,"Result_Errors");
			             val=true;
					 }
				 }
				 
				 
				//Checking for Com plan ID error
				 su.WindowHandles();
				 if(su.existsElement(putility.getProperty("error_popup_okbtn"))){
	    				String PopUp_Name = su.getText(putility.getProperty("pop_up_confirmation_txt"));
	    				if(PopUp_Name.contains("Comp Plan ID not valid")){
	    					su.takeScreenShot(test, "Manage_Hire", testCaseId, "After_submitting_manage_hire");
	    					su.clickElement(test, putility.getProperty("error_popup_okbtn"), "PopUp_Btn", testCaseId);
	    					su.default_content();	
	    					su.SwitchFrames("ptifrmtgtframe");
	    					su.clickElement(test, putility.getProperty("incentive_plan_tab"), "incentive_plan_tab", testCaseId);
	    					su.Processing();
	    					su.SelectDropDownByIndex(test,putility.getProperty("plan_id"),2,"Manage_Hire",testCaseId);
	    					su.Processing();
	    					su.clickElement(test, putility.getProperty("save_btn"), "save_btn", testCaseId);
	    					excelUtils.setCellData("Manage_Hire", "PASS", testCaseId, "Result_Status");
				            excelUtils.setCellData("Manage_Hire", "Manage Hire for "+Applicant_Type+" Candidate completed sucessfully", testCaseId,"Result_Errors");
				            test.log(LogStatus.PASS,"Manage Hire for "+Applicant_Type+" Candidate sould get complete","Usage: <span style='font-weight:bold;'>Manage Hire for "+Applicant_Type+" Candidate completed sucesssfully</span>");
	    				}
	    				else if(su.existsElement(putility.getProperty("error_popup_okbtn"))){
	    					su.default_content();
		                    su.checkPopUp(extent,test, "Manage_Hire", testCaseId, "Error after submitting employee for "+Applicant_Type+"");
		                    su.default_content();
	    				}
	              }
				 else if(Applicant_Type.equalsIgnoreCase("External")){
					 su.default_content();
					//For external candidiate going back to the previos screen
					su.switchToWindow(currWinName);
					su.SwitchFrames("ptifrmtgtframe");
					if (su.existsElement(putility.getProperty("applicant_id"))){
						excelUtils.setCellData("Manage_Hire", "PASS", testCaseId, "Result_Status");
			            excelUtils.setCellData("Manage_Hire", "Manage Hire for "+Applicant_Type+" Candidate completed sucessfully", testCaseId,"Result_Errors");
			            test.log(LogStatus.PASS,"Manage Hire for "+Applicant_Type+" Candidate sould get complete","Usage: <span style='font-weight:bold;'>Manage Hire for "+Applicant_Type+" Candidate completed sucesssfully</span>");
					}
					else{
						excelUtils.setCellData("Manage_Hire", "FAIL", testCaseId, "Result_Status");
			            excelUtils.setCellData("Manage_Hire", "Manage Hire for "+Applicant_Type+" Candidate could not be completed ", testCaseId,"Result_Errors");
			            test.log(LogStatus.FAIL,"Manage Hire for "+Applicant_Type+" Candidate could not be completed","Usage: <span style='font-weight:bold;'>Manage Hire for "+Applicant_Type+" Candidate  could not be completed</span>");
			            throw new Exception("Manage Hire for "+Applicant_Type+" Candidate failed");
					}
					
				 }
				 
				 if(val){
					 throw new Exception("Manage Hire for "+Applicant_Type+" Candidate failed");  
				 }
				 su.default_content();	
			 }
			 else{
				 test.log(LogStatus.FAIL,"New Window should opened for "+Applicant_Type+" Candidate","Usage: <span style='font-weight:bold;'>New Window did not open for "+Applicant_Type+" Candidate after clicking Add Job link</span>"); 
	             Log.info("New Window did not open for "+Applicant_Type+" Candidate after clicking Add Job link");
	             excelUtils.setCellData("Manage_Hire", "FAIL", testCaseId, "Result_Status");
	             excelUtils.setCellData("Manage_Hire", "New Window did not open for "+Applicant_Type+" Candidate", testCaseId,"Result_Errors");
	             throw new Exception("New Window did not open for "+Applicant_Type+" Candidate after clicking Add Job link");
			 }
			
			
			
			
		}				
	}
	
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  
		  DOMConfigurator.configure("log4j.xml");
		  Log.startTestCase("Start Execution");
		  Log.info("Staffing :: beforeClass() method invoked...");
		  extent.config().documentTitle("Staffing Automation");
		  extent.config().reportName("Manage Hire");
		  extent.config().reportHeadline("-Staffing");
		  extent.addSystemInfo("Selenium Version", "2.46");
		  extent.addSystemInfo("Environment", "Staging");
				
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
