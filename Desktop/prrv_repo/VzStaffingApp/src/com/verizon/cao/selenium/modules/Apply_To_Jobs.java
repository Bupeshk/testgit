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




public class Apply_To_Jobs implements ApplicationConstants{
	PropertyUtility putility = new PropertyUtility(OBJECT_REPO_FILEPATH);
    StaffingUtil su = new StaffingUtil();
    ExcelUtils excelUtils = new ExcelUtils();
    public static ExtentReports extent = new ExtentReports(REPORT_PATH+"/ApplyToJobs.html", true,DisplayOrder.OLDEST_FIRST);
     private ExtentTest test ;
    
    @Test
    @Parameters("testCaseId")
    
    public void ATJO (String testCaseId) throws Exception {
    	//Starting the extent report
        test = extent.startTest("Applying to New Job for TestCase - '"+testCaseId);
        /*if (! MyConstants.executeTestCase){
                        test.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
                        throw new SkipException("Skipping the test case as application is not available.");                                           
        }*/
        
        if (! su.executeTestCase("Apply_to_JO", testCaseId)){
                        test.log(LogStatus.SKIP, "Skipping the test case as there is no data available for test case in DB.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
                        throw new SkipException("Skipping the test case as there is no data available for test case in DB.");                                                
        }
        System.out.println("Going to start Applying for New Jobs");
        //Initiating log4j
        Log.startTestCase(testCaseId);
        String TestCase_Desc,Applicant_type,Applicant_Type_Desc,URL,Login,Pwd,Result_Status,Result_Errors,navigate,Register_without_Apply,Register_and_Apply,Wireless_Assessment,JO,JO_Desc,Username,uPWD,ConfirmPWD,SecurityQuestion;
        String SecurityAnswer,EmailAddress,FirstName,LastName,TimeatCurrentAddress,Country,Address1,Street_address,ZipCode,Postal,City,State,PhoneType,Telephone,BestContact,Work_History,Current_Employer;
        String May_We_Contact,Start_Date,Supv_Name,Supv_Tele,Employer,Job_Title,Responsibilities,Last_Salary,Sal_Per,Sal_Currency,Last_Commission,Comm_Per,Comm_Currency,Work_Country,Work_Address1;
        String Work_Street_and,Work_Zipcode,Work_Postal,Work_City,Work_State,Education,Edu_Country,Edu_State,Edu_City,Edu_Degree,Edu_Major,Edu_School,Edu_Graduated,Edu_Grad_Dt,Referrals_Source;
        String Referrals_SubSource,View_Disclosure,Form1,Form2,Form3_Gender,Form3_Hispanic,Form3_Race,Form3_Veteran,Form3_Disability_Link,Disability_Question,Form4,Take_Retail_Assessment;
        
        try{
        	ExcelUtils.setExcelFile(DATA_FILEPATH,"Apply_to_JO");
            TestCase_Desc = ExcelUtils.getExcelData("TC_Desc",testCaseId);
            Applicant_type = ExcelUtils.getExcelData("Applicant_Type",testCaseId);
            Applicant_Type_Desc= ExcelUtils.getExcelData("Applicant_Type_Desc",testCaseId);
            URL = ExcelUtils.getExcelData("URL",testCaseId);
            Login = ExcelUtils.getExcelData("Login",testCaseId);
            Pwd = ExcelUtils.getExcelData("Pwd",testCaseId);
            Result_Status = ExcelUtils.getExcelData("Result_Status",testCaseId);
            Result_Errors = ExcelUtils.getExcelData("Result_Errors",testCaseId);
            navigate = ExcelUtils.getExcelData("Navigation",testCaseId);
            Register_without_Apply = ExcelUtils.getExcelData("Register_without_Apply",testCaseId);
            Register_and_Apply = ExcelUtils.getExcelData("Register_and_Apply",testCaseId);
            Wireless_Assessment = ExcelUtils.getExcelData("Wireless_Assessment",testCaseId);
            JO = ExcelUtils.getExcelData("JO",testCaseId);
            JO_Desc = ExcelUtils.getExcelData("JO_Desc",testCaseId);
            Username = ExcelUtils.getExcelData("Username",testCaseId);
            uPWD = ExcelUtils.getExcelData("uPWD",testCaseId);
            ConfirmPWD = ExcelUtils.getExcelData("ConfirmPWD",testCaseId);
            SecurityQuestion = ExcelUtils.getExcelData("SecurityQuestion",testCaseId);
            SecurityAnswer = ExcelUtils.getExcelData("SecurityAnswer",testCaseId);
            EmailAddress = ExcelUtils.getExcelData("EmailAddress",testCaseId);
            FirstName = ExcelUtils.getExcelData("FirstName",testCaseId);
            LastName = ExcelUtils.getExcelData("LastName",testCaseId);
            TimeatCurrentAddress = ExcelUtils.getExcelData("TimeatCurrentAddress",testCaseId);
            Country = ExcelUtils.getExcelData("Country",testCaseId);
            Address1 = ExcelUtils.getExcelData("Address1",testCaseId);
            Street_address = ExcelUtils.getExcelData("Street_address",testCaseId);
            ZipCode = ExcelUtils.getExcelData("ZipCode",testCaseId);
            Postal = ExcelUtils.getExcelData("Postal",testCaseId);
            City = ExcelUtils.getExcelData("City",testCaseId);
            State = ExcelUtils.getExcelData("State",testCaseId);
            PhoneType = ExcelUtils.getExcelData("PhoneType",testCaseId);
            Telephone = ExcelUtils.getExcelData("Telephone",testCaseId);
            BestContact = ExcelUtils.getExcelData("BestContact",testCaseId);
            Work_History = ExcelUtils.getExcelData("Work_History",testCaseId);
            Current_Employer = ExcelUtils.getExcelData("Current_Employer",testCaseId);
            May_We_Contact = ExcelUtils.getExcelData("May_We_Contact",testCaseId);
            Start_Date = ExcelUtils.getExcelDate("Start_Date",testCaseId);
            Supv_Name = ExcelUtils.getExcelData("Supv_Name",testCaseId);
            Supv_Tele = ExcelUtils.getExcelData("Supv_Tele",testCaseId);
            Employer = ExcelUtils.getExcelData("Employer",testCaseId);
            Job_Title = ExcelUtils.getExcelData("Job_Title",testCaseId);
            Responsibilities = ExcelUtils.getExcelData("Responsibilities",testCaseId);
            Last_Salary = ExcelUtils.getExcelData("Last_Salary",testCaseId);
            Sal_Per = ExcelUtils.getExcelData("Sal_Per",testCaseId);
            Sal_Currency = ExcelUtils.getExcelData("Sal_Currency",testCaseId);
            Last_Commission = ExcelUtils.getExcelData("Last_Commission",testCaseId);
            Comm_Per = ExcelUtils.getExcelData("Comm_Per",testCaseId);
            Comm_Currency = ExcelUtils.getExcelData("Comm_Currency",testCaseId);
            Work_Country = ExcelUtils.getExcelData("Work_Country",testCaseId);
            Work_Address1 = ExcelUtils.getExcelData("Work_Address1",testCaseId);
            Work_Street_and = ExcelUtils.getExcelData("Work_Street_and",testCaseId);
            Work_Zipcode = ExcelUtils.getExcelData("Work_Zipcode",testCaseId);
            Work_Postal = ExcelUtils.getExcelData("Work_Postal",testCaseId);
            Work_City = ExcelUtils.getExcelData("Work_City",testCaseId);
            Work_State = ExcelUtils.getExcelData("Work_State",testCaseId);
            Education = ExcelUtils.getExcelData("Education",testCaseId);
            Edu_Country = ExcelUtils.getExcelData("Edu_Country",testCaseId);
            Edu_State = ExcelUtils.getExcelData("Edu_State",testCaseId);
            Edu_City = ExcelUtils.getExcelData("Edu_City",testCaseId);
            Edu_Degree = ExcelUtils.getExcelData("Edu_Degree",testCaseId);
            Edu_Major = ExcelUtils.getExcelData("Edu_Major",testCaseId);
            Edu_School = ExcelUtils.getExcelData("Edu_School",testCaseId);
            Edu_Graduated = ExcelUtils.getExcelData("Edu_Graduated",testCaseId);
            Edu_Grad_Dt = ExcelUtils.getExcelDate("Edu_Grad_Dt",testCaseId);
            Referrals_Source = ExcelUtils.getExcelData("Referrals_Source",testCaseId);
            Referrals_SubSource = ExcelUtils.getExcelData("Referrals_SubSource",testCaseId);
            View_Disclosure = ExcelUtils.getExcelData("View_Disclosure",testCaseId);
            Form1 = ExcelUtils.getExcelData("Form1",testCaseId);
            Form2 = ExcelUtils.getExcelData("Form2",testCaseId);
            Form3_Gender = ExcelUtils.getExcelData("Form3_Gender",testCaseId);
            Form3_Hispanic = ExcelUtils.getExcelData("Form3_Hispanic",testCaseId);
            Form3_Race = ExcelUtils.getExcelData("Form3_Race",testCaseId);
            Form3_Veteran = ExcelUtils.getExcelData("Form3_Veteran",testCaseId);
            Form3_Disability_Link = ExcelUtils.getExcelData("Form3_Disability_Link",testCaseId);
            Disability_Question = ExcelUtils.getExcelData("Disability_Question",testCaseId);
            Form4 = ExcelUtils.getExcelData("Form4",testCaseId);
            Take_Retail_Assessment = ExcelUtils.getExcelData("Take_Retail_Assessment",testCaseId);
			}
			catch (Exception e){
	            System.out.println("Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e);
	            Reporter.log("Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exception : "+ e);
	            test.log(LogStatus.FAIL,"Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e);
	            excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
	            excelUtils.setCellData("Apply_to_JO", "Exception while reading data from EXCEL file for test case : "+ testCaseId+" Exceptions : "+ e, testCaseId, "Result_Errors");
	            throw new Exception("Error occured while trying to login to the application  -  " +e);
			}                              
        

        test.log(LogStatus.INFO, "App Launch and Login", "Usage: <span style='font-weight:bold;'>Going To launch URL and Login in the application</span>");
        //Launching the application
        su.LaunchUrl(extent,test,URL,"Apply_to_JO",testCaseId);
        //Logging into the application
        su.Staffing_Login(extent,test,Login,Pwd,"Apply_to_JO",testCaseId);
        
        Log.info("Executing Test Case "+testCaseId+" "+TestCase_Desc );
        System.out.println("Executing Test Case "+testCaseId+" "+TestCase_Desc );
        
        su.Navigate_To_Menu(extent,test, navigate,"Apply_to_JO",testCaseId);
		//Switching to a different frame to identify the objects on page
		su.SwitchFrames("ptifrmtgtframe");
		su.Processing();
		
		if (Applicant_type.equalsIgnoreCase("Internal")){
			System.out.println("Going to apply jobs for Internal candidate");
			if(su.ApplyForInternalCandidate(extent, test, JO, Take_Retail_Assessment,"Apply_to_JO", testCaseId)){
				String  applied_status = su.getText(putility.getProperty("internal_application_status"));
				if (applied_status.equalsIgnoreCase("Applied")){
					test.log(LogStatus.PASS, "Internal Candidate Job Search Details Page","Usage: <span style='font-weight:bold;'>Internal Candidate Job Search Details Page found and candidate sucessfuly applied for the Job</span>");
					Log.info("Internal Candidate Job Search Details Page found and candidate sucessfuly applied for the Job "+JO);
					Reporter.log("Internal Candidate Job Search Details Page found and candidate sucessfuly applied for the Job "+JO);
	                excelUtils.setCellData("Apply_to_JO", "PASS", testCaseId, "Result_Status");
	                excelUtils.setCellData("Apply_to_JO", "Sucessfully Applied", testCaseId,"Result_Errors");
					test.log(LogStatus.PASS, "Internal Candidate Job Search Details Page","Internal Candidate Job Search Details Page found and candidate sucessfuly applied for the Job "+JO);
				} 
				else {
					test.log(LogStatus.FAIL, "Internal Candidate Job Search Details Page","Usage: <span style='font-weight:bold;'>Internal Candidate Job Search Details Page found but could not apply sucessfully to the job</span>");
					Log.error("Internal Candidate Job Search Details Page found and candidate sucessfuly applied for the Job "+JO);
					Reporter.log("Internal Candidate Job Search Details Page found and candidate sucessfuly applied for the Job "+JO);
	                excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
	                excelUtils.setCellData("Apply_to_JO", "Could  not apply", testCaseId,"Result_Errors");
					test.log(LogStatus.FAIL,"Internal Candidate Job Search Details Page", "Internal Candidate Job Search Details Page found and candidate could not apply for the job  - "+JO);	
				}	
				
			}
			else{
				Log.error("Internal Candidate Job Search Details Page found and candidate sucessfuly applied for the Job "+JO);
				Reporter.log("Internal Candidate Job Search Details Page found and candidate sucessfuly applied for the Job "+JO);
                excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
                excelUtils.setCellData("Apply_to_JO", "Could  not apply", testCaseId,"Result_Errors");
                test.log(LogStatus.FAIL, "Internal Candidate Job Search Details Page","Internal Candidate Job Search Details Page found and candidate could not apply for the job  - "+JO);	
                throw new Exception("Error occured while applying for the job for Internal candidate"); 
           }
		}
		
		
        
        //Condition to check if the candidate is Internal employee or External
        if (Applicant_type.equalsIgnoreCase("External")){
        	System.out.println("Going to apply jobs for External candidate");
            //Checking the job code text box to enter value
            if (su.existsElement(putility.getProperty("job_code_srch_box"))){
                test.log(LogStatus.INFO, "Search Job Details Page","Usage: <span style='font-weight:bold;'>Search job details page found and starting Job Search</span>");
                Log.info("Search Job Details Page found and going to search for Job");
                if(su.SearchJob(extent, test, JO, "Apply_to_JO", testCaseId)){
                    test.log(LogStatus.INFO, "Search Job Details Page","Usage: <span style='font-weight:bold;'>Job found and applied, now going to register user</span>");
                }else{
                    test.log(LogStatus.FAIL, "Search Job Details Page","Usage: <span style='font-weight:bold;'>Job not found, so exiting the test cases</span>");
                    Log.info("Job not found, so exiting the test cases");
                    excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
                    excelUtils.setCellData("Apply_to_JO", "Job Search Failed", testCaseId,"Result_Errors");
                    throw new Exception("Error occured while searching for the job");
                }
                                            
            }
            
            su.ProcessingRE2E();
            if(su.existsElement(putility.getProperty("register_now_btn"))){
                su.clickElement(test, putility.getProperty("register_now_btn"),"register_now_btn",testCaseId);
                test.log(LogStatus.INFO, "UserRegistration Page", "Usage: <span style='font-weight:bold;'>User should register sucessfully</span>");
               if (su.Register_Now_Page(extent,test,Username,uPWD,ConfirmPWD,SecurityQuestion,SecurityAnswer,EmailAddress,"Apply_to_JO",testCaseId)){
            	   Log.info("User registration process sucessfull");
                   Reporter.log("User registration process sucessfull");
                   test.log(LogStatus.PASS, "UserRegistration Page", "Usage: <span style='font-weight:bold;'>User Registration done successfully</span>");                            
                }
                else{
                	Log.error("User registration process failed");
                    Reporter.log("User registration process failed");
                    test.log(LogStatus.FAIL, "UserRegistration Page", "Usage: <span style='font-weight:bold;'>User Registration failed</span>");
                    //excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
                   // excelUtils.setCellData("Apply_to_JO", "User registration failed because page was not found.", testCaseId,"Result_Errors");
                    throw new Exception("Error occured while trying to register the user as page was not found.");                 
                }
            }

            su.ProcessingRE2E();
            su.sleep(10000);
            su.clickElement(test, putility.getProperty("select_apply_without_resume"), "select_apply_without_resume", testCaseId);
            
            su.Processing();
            
            su.clickElement(test, putility.getProperty("continue_btn"), "continue_btn", testCaseId);
            
            su.ProcessingRE2E();
            
            //Confirming whether My Profile page opened or not
            if (su.existsElement(putility.getProperty("my_profile_page"))){
            	 Log.info("Profile page is displayed");
                 test.log(LogStatus.INFO, "My Profile Page", "Usage: <span style='font-weight:bold;'>Entering details on My PROFILE PAGE</span>");
                 if(su.My_Profiles_Page(extent, test, FirstName, LastName, TimeatCurrentAddress, Country, Address1, Street_address, ZipCode, Postal, City, State, PhoneType, Telephone, BestContact, "Apply_to_JO", testCaseId)){
                	 test.log(LogStatus.INFO, "My Profile Page", "Usage: <span style='font-weight:bold;'>User entered all detail successfully in My Profile pagey</span>");
                 }
                 else{
             		Log.error("My Profile page details could not be entered");
             		System.out.println("My Profile page details could not be entered");
             		test.log(LogStatus.FAIL, "My Profile details page", "Usage: <span style='font-weight:bold;'>All details could not be entered in My Profile page</span>");
             		//excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
                    //excelUtils.setCellData("Apply_to_JO", "Data not entered in My Profile", testCaseId,"Result_Errors");
             		throw new Exception("Error occured in My Profile page"); 
             	}
                 
            }
            else{
            	 System.out.println("My Profile page is not displayed");
                 test.log(LogStatus.FAIL, "My Profile Page", "Usage: <span style='font-weight:bold;'>My Profile page not found so exiting the TC</span>");        
                 excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
                 excelUtils.setCellData("Apply_to_JO", "My Profile Page not displayed so exiting the TC", testCaseId,"Result_Errors");
                 throw new Exception("Error occured becaus eMY Profile page was not found"); 
            }
            
            
            //Entering Work details
            if(Work_History.equalsIgnoreCase("Y")){
            	if(su.workDetailsPage(extent,test, Current_Employer, May_We_Contact, Start_Date, Supv_Name, Supv_Tele, Employer, Job_Title, Responsibilities, Last_Salary, Sal_Per, Sal_Currency, 
            			Last_Commission, Comm_Per, Comm_Currency, Work_Country, Work_Address1, Work_Street_and, Work_Zipcode, Work_Postal, Work_City, Work_State, "Apply_to_JO", testCaseId)){
            		System.out.println("Work History details entered successfully");
            		test.log(LogStatus.PASS, "Work History details page", "Usage: <span style='font-weight:bold;'>All details entered sucessfully in the page</span>");
            	}
            	else{
            		Log.error("Work History details could not be entered");
            		System.out.println("Work History details could not be entered");
            		test.log(LogStatus.FAIL, "Work History details page", "Usage: <span style='font-weight:bold;'>All details could not be entered in Work details page</span>");
            		//excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
                    //excelUtils.setCellData("Apply_to_JO", "Data not entered in Work History", testCaseId,"Result_Errors");
            		throw new Exception("Error occured in Work details page"); 
            	}
            	
            }
            else {
            	test.log(LogStatus.PASS, "Work History details page", "Usage: <span style='font-weight:bold;'>Data not entered in Work History details page as the excel value is given as NO</span>");
            	System.out.println("Work History details not entered as it is not mentioned in the excel");
            	excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
                excelUtils.setCellData("Apply_to_JO", "Data not entered in Work History details page as the excel value is given as NO", testCaseId,"Result_Errors");
                throw new Exception("Data not entered in Work History details page as the excel value is given as NO"); 
            	
            }
            
            
              
            //Entering education details
            if(Education.equalsIgnoreCase("Y")){
            	 if(su.educationDetailsPage(extent,test, Edu_Country, Edu_State, Edu_City, Edu_Degree, Edu_Major, Edu_School,Edu_Graduated, Edu_Grad_Dt, "Apply_to_JO", testCaseId)){
              	   System.out.println("Work History details entered successfully");
             		test.log(LogStatus.PASS, "Work History details page", "Usage: <span style='font-weight:bold;'>All details entered sucessfully in the page</span>"); 
                 }
                 else{
             		Log.error("Education details could not be entered");
             		System.out.println("Education details entered successfully");
             		test.log(LogStatus.FAIL, "Education details page", "Usage: <span style='font-weight:bold;'>All details could not be entered in Education details page</span>");
             		//excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
                   // excelUtils.setCellData("Apply_to_JO", "Data not entered in Education details page", testCaseId,"Result_Errors");
             		throw new Exception("Error occured in Education details page"); 
             	}
              
            }
            else {
            	test.log(LogStatus.FAIL, "Education details page", "Usage: <span style='font-weight:bold;'>Data not entered in Education details page as the excel value is given as NO</span>");
            	System.out.println("Education details not entered as it is not mentioned in the excel");
            	excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
                excelUtils.setCellData("Apply_to_JO", "Data not entered in Education details page as the excel value is given as NO", testCaseId,"Result_Errors");
                throw new Exception("Data not entered in Education details page as the excel value is given as NO"); 
            }
            
            
            //Navigating to referral Source page now
            su.ProcessingRE2E();
            su.clickElement(test, putility.getProperty("continue_to_step5_btn"), "continue_to_step5_btn", testCaseId);
            su.ProcessingRE2E();
            su.clickElement(test, putility.getProperty("continue_to_step6_btn"), "continue_to_step6_btn", testCaseId);
            su.ProcessingRE2E();
            
            su.SelectDropDown(test, putility.getProperty("ref_how_u_know_abt_vzw"), Referrals_Source, "Apply_to_JO", testCaseId);
            su.ProcessingRE2E();
            su.SelectDropDown(test, putility.getProperty("ref_subsource"), Referrals_SubSource, "Apply_to_JO", testCaseId);
            su.ProcessingRE2E();
            su.clickElement(test, putility.getProperty("continue_to_step7_btn"), "continue_to_step7_btn", testCaseId);
            su.ProcessingRE2E();
            su.answerQATab(test);
            su.clickElement(test, putility.getProperty("continue_to_step8_btn"), "continue_to_step8_btn", testCaseId);
            su.ProcessingRE2E();
            su.clickElement(test, putility.getProperty("continue_to_step9_btn"), "continue_to_step9_btn", testCaseId);
            su.ProcessingRE2E();
            
            if(View_Disclosure.equalsIgnoreCase("Y")){
            	if(su.existsElement(putility.getProperty("view_disclosure_btn"))){
	            	su.clickElement(test, putility.getProperty("view_disclosure_btn"), "view_disclosure_btn", testCaseId);
	            	su.ProcessingRE2E();
	            	su.WindowHandles();
	                 if(su.existsElement(putility.getProperty("error_popup_okbtn"))){
	                 	 su.default_content();
	                     su.checkPopUp(extent,test, "Apply_to_JO", testCaseId, "Error after clicking the View Disclosure btn");
	                 }
                 su.default_content();
            	}
            }
            
            if(Form1.equalsIgnoreCase("Y")){
            	if(su.existsElement(putility.getProperty("form1_chkbox"))){
                	su.clickElement(test, putility.getProperty("form1_chkbox"), "form1_chkbox", testCaseId);
                	su.Processing();
                	if(su.existsElement(putility.getProperty("form4_agree_to_terms_chkbox")))
                		su.clickElement(test, putility.getProperty("form4_agree_to_terms_chkbox"), "form4_agree_to_terms_chkbox", testCaseId);
                	
                	su.Processing();
                	su.clickElement(test, putility.getProperty("view_nxt_form_btn"), "view_nxt_form_btn", testCaseId);
                	su.Processing();
                	su.WindowHandles();
	                 if(su.existsElement(putility.getProperty("error_popup_okbtn"))){
	                 	 su.default_content();
	                     su.checkPopUp(extent,test, "Apply_to_JO", testCaseId, "Error after clicking the View Next form btn on Form1 Page");
	                 }
	                 su.default_content();
                }
            }
            
            if(Form2.equalsIgnoreCase("Y")){
            	if(su.existsElement(putility.getProperty("form2_chkbox"))){
                	su.clickElement(test, putility.getProperty("form2_chkbox"), "form2_chkbox", testCaseId);
                	su.Processing();
                	
                	if(su.existsElement(putility.getProperty("form4_agree_to_terms_chkbox"))){
                		su.clickElement(test, putility.getProperty("form4_agree_to_terms_chkbox"), "form4_agree_to_terms_chkbox", testCaseId);
                		su.Processing();
                    	su.clickElement(test, putility.getProperty("form4_submit_btn"), "form4_submit_btn", testCaseId);
                    	su.Processing();
                	}
                	else{
	                	su.Processing();
	                	su.clickElement(test, putility.getProperty("continue_eeo_btn"), "continue_eeo_btn", testCaseId);
	                	su.Processing();
	                	su.WindowHandles();
		                 if(su.existsElement("//input[@id='#ICOK']")){
		                 	 su.default_content();
		                     su.checkPopUp(extent,test, "Apply_to_JO", testCaseId, "Error after clicking the View Next form btn on Form2 Page");
		                 }
		                 su.default_content();
                	}
                }
            }
            
            
            if(Form3_Gender != null && Form3_Gender.trim().length() >0){
            	test.log(LogStatus.INFO, "Form 3 page of Aplly to JO", "Usage: <span style='font-weight:bold;'>Form 3 page of Apply to JO details will be entered now</span>");
            	if(su.applyToJobForm3(extent, test, Form3_Gender, Form3_Hispanic, Form3_Race, Form3_Veteran, Form3_Disability_Link, Disability_Question, "Apply_to_JO", testCaseId)){
            	test.log(LogStatus.PASS, "Form 3 page of Aplly to JO", "Usage: <span style='font-weight:bold;'>Form 3 page of Apply to JO details entered sucessfully</span>");
            	}
            	else{
            		test.log(LogStatus.FAIL, "Form 3 page of Aplly to JO", "Usage: <span style='font-weight:bold;'>Form 3 page of Apply to JO could not be entered</span>");
            		excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
                    excelUtils.setCellData("Apply_to_JO", "Error occured in Form 3 page of Apply to JO", testCaseId,"Result_Errors");
                    throw new Exception("Error occured in Form 3 page of Apply to JO"); 
            	}
            }
            else{
            	System.out.println("Form 3 value is not entered as the excel has no value for that");
            }
            
            

            if(Form4.equalsIgnoreCase("Y")){
            	if(su.existsElement(putility.getProperty("form4_employmnt_terms_chkbox"))){
                	su.clickElement(test, putility.getProperty("form4_employmnt_terms_chkbox"), "form4_employmnt_terms_chkbox", testCaseId);
                	su.Processing();
                	su.clickElement(test, putility.getProperty("form4_agree_to_terms_chkbox"), "form4_agree_to_terms_chkbox", testCaseId);
                	su.Processing();
                	su.clickElement(test, putility.getProperty("form4_submit_btn"), "form4_submit_btn", testCaseId);
                	su.Processing();
                	/*su.WindowHandles();
	                 if(su.existsElement("//input[@id='#ICOK']")){
	                 	 su.default_content();
	                     su.checkPopUp(extent,test, "Apply_to_JO", testCaseId, "Error after clicking the View Next form btn on Form2 Page");
	                 }
	                 else{
	                	 su.default_content(); 
	                 }*/
	                
                }
            }
            
            if(Take_Retail_Assessment.equalsIgnoreCase("Y")){
            	su.WindowHandles();
            	if(su.existsElement(putility.getProperty("error_popup_okbtn"))){
               	 	su.clickElement(test, putility.getProperty("error_popup_okbtn"), "Retail Assessment Ok Button", testCaseId);
                    su.default_content();	  
               }
            	su.default_content();
            }
            su.ProcessingRE2E();
            if(su.existsElement(putility.getProperty("sucess_msg"))){
            	String sucess_msg_content = su.getText(putility.getProperty("sucess_msg_content"));
            	System.out.println("Applied for job sucessfully and sucess msg printed as  - "+sucess_msg_content);
            	test.log(LogStatus.PASS, "Apply to JO", "Usage: <span style='font-weight:bold;'>User sucessfully applied for the job</span>");
        		excelUtils.setCellData("Apply_to_JO", "PASS", testCaseId, "Result_Status");
                excelUtils.setCellData("Apply_to_JO", sucess_msg_content, testCaseId,"Result_Errors");	
                su.clickElement(test, putility.getProperty("sucess_Ok_btn"), "sucess_Ok_btn", testCaseId);
                su.ProcessingRE2E();  
            }
            else{
            	System.out.println("Apply to JOb Test Case failed ");
            	test.log(LogStatus.FAIL, "Apply to JO", "Usage: <span style='font-weight:bold;'>User could not apply for the job</span>");
        		excelUtils.setCellData("Apply_to_JO", "FAIL", testCaseId, "Result_Status");
                excelUtils.setCellData("Apply_to_JO", "User could not apply for the job", testCaseId,"Result_Errors");	
                throw new Exception("User could not apply for the job"); 
            } 
            
            
            //Code for Retail assessment 
            if(Take_Retail_Assessment.equalsIgnoreCase("Y")){
            	su.checkRetailAssessment(test, testCaseId);
            }
            
        }       
                    
    }
    
      @BeforeMethod
      public void beforeMethod() throws Exception {
    	  DOMConfigurator.configure("log4j.xml");
          Log.startTestCase("Start Execution");
          Log.info("Staffing :: beforeClass() method invoked...");
          extent.config().documentTitle("Staffing Automation");
          extent.config().reportName("Applying To Jobs");
          extent.config().reportHeadline("-Staffing");                                               
      }            
    
      @AfterMethod
      @Parameters("testCaseId")
      public void afterMethod(String testCaseId) {
                      Log.info("Staffing :: afterClass() method invoked...");
                      try{
                          if (su.executeTestCase("Apply_to_JO", testCaseId)){
                        	  //Handling the windows
                              //su.WindowHandles();
                              //App log out
                            // su.AppLogout(test);
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
