package com.verizon.cao.selenium.modules;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
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



public class Prepare_For_Hire implements ApplicationConstants{

	PropertyUtility putility = new PropertyUtility(OBJECT_REPO_FILEPATH);
	StaffingUtil su = new StaffingUtil();
	ExcelUtils excelUtils = new ExcelUtils();
	public static ExtentReports extent = new ExtentReports(REPORT_PATH+"/PrepareForHire.html", true,DisplayOrder.OLDEST_FIRST);
	private ExtentTest test ;
	Alert alert;

	@Test
	@Parameters("testCaseId")
	public void PFH(String testCaseId) throws Exception  {
		test = extent.startTest("Prepare For Hire - '"+testCaseId );
		
		/*if (! MyConstants.executeTestCase){
			test.log(LogStatus.SKIP, "Skipping the test case as application is not available.", "Usage: <span style='font-weight:bold;'>Skipped test cases.</span> "+ testCaseId);
			throw new SkipException("Skipping the test case as application is not available.");			
		}*/
		
		if (! su.executeTestCase("Prepare_for_Hire", testCaseId)){
			System.out.println("Skipping the test case - "+testCaseId+" - as there is no data available for test case in DB.");
			test.log(LogStatus.SKIP, "Skipping the test case  - "+testCaseId+" -as there is no data available for test case in DB.", "Usage: <span style='font-weight:bold;'>NO Data Found in DB for TC -</span> "+ testCaseId);
			throw new SkipException("Skipping the test case  - "+testCaseId+" -as there is no data available for test case in DB.");			
		}
		
		//System.out.println("inside PFH_Main");
		ExcelUtils.setExcelFile(DATA_FILEPATH,"Prepare_for_Hire");
		String URL = ExcelUtils.getExcelData("URL",testCaseId);
		String Login = ExcelUtils.getExcelData("Login",testCaseId);
		String Pwd = ExcelUtils.getExcelData("Pwd",testCaseId);	
		String TestCase_Desc = ExcelUtils.getExcelData("TC_Desc",testCaseId);
		String	navigate = ExcelUtils.getExcelData("Navigation",testCaseId);
		String jobOpeningID = ExcelUtils.getExcelData("JobOpening_ID",testCaseId);
		String applicantID = ExcelUtils.getExcelData("ApplicantID",testCaseId);
		String applicantType = ExcelUtils.getExcelData("Applicant_Type",testCaseId);
		String takeAction = ExcelUtils.getExcelData("Take_Action",testCaseId);
		String anticipatedDate = ExcelUtils.getExcelData("Anticipated_Date",testCaseId);
		String transactionType = ExcelUtils.getExcelData("Transaction_Type",testCaseId);
		String nationalIDCountry = ExcelUtils.getExcelData("National_ID_Country",testCaseId);
		String nationalIDType = ExcelUtils.getExcelData("National_ID_Type",testCaseId);
		String nationalID = ExcelUtils.getExcelData("National_ID",testCaseId);
		String DOBHire = ExcelUtils.getExcelDate("DOB_Hire",testCaseId);
		String dlCountry = ExcelUtils.getExcelData("DL_Country",testCaseId);
		String dlState = ExcelUtils.getExcelData("DL_State",testCaseId);
		String dlNumber = ExcelUtils.getExcelData("DL_Number",testCaseId);
		String dlExpDate = ExcelUtils.getExcelDate	("DL_Exp_Date",testCaseId);
		String byPassPreEmplCheck = ExcelUtils.getExcelData("Bypass_PreEmplCheck",testCaseId);
		String verifyCreateEmpID = ExcelUtils.getExcelData("VerifyCreateEmployeeID",testCaseId);
		String emplIDGenerated = ExcelUtils.getExcelData("Emplid_Generated",testCaseId);
		String initiatePreEmpCheck = ExcelUtils.getExcelData("Initiate_PreEmpCheck",testCaseId);
		String initiatePreBoarding = ExcelUtils.getExcelData("Initiate_PreBoarding",testCaseId);
		String emailTo = ExcelUtils.getExcelData("Email_To",testCaseId);
		String viewOfferLetter = ExcelUtils.getExcelData("View_Offer_Letter",testCaseId);
		String editOfferLetter = ExcelUtils.getExcelData("Edit_Offer_Letter",testCaseId);
		String sendEmail = ExcelUtils.getExcelData("Send_Email",testCaseId);
		String submitForHire = ExcelUtils.getExcelData("Submit_for_Hire",testCaseId);
		String SFHConfirm = ExcelUtils.getExcelData("SFH_Confirm",testCaseId);
	
		
		//Starting the extent report
		
		
		//Initiating log4j
		Log.startTestCase(testCaseId);
		System.out.println("Execution started for TestCase -"+testCaseId);
		test.log(LogStatus.INFO, "App Launch and Login", "Usage: <span style='font-weight:bold;'>Going To launch URL and Login in the application</span>");

		//Launching the application
		su.LaunchUrl(extent,test,URL,"Prepare_for_Hire",testCaseId);
		
		//Logging into the application
		su.Staffing_Login(extent,test,Login,Pwd,"Prepare_for_Hire",testCaseId);
		
		 test.log(LogStatus.INFO, "Prepare for Hire", "Usage: <span style='font-weight:bold;'>Preparing for Candidate's hirining</span>");
		
		
		if(!navigate.equals(""))
		{
			//Navigating to Create Job Opening page
			su.Navigate_To_Menu(extent,test, navigate,"Prepare_for_Hire",testCaseId);

			//Switiching to a different frame to identify the objects on page
			su.SwitchFrames("ptifrmtgtframe");
			su.Processing();
		}

		
		if(!jobOpeningID.equals(""))
		{
			//Search with job opening ID
			su.SetData(test,putility.getProperty("job_opening_id_txtBox"),jobOpeningID);
			su.Processing();
			//Thread.sleep(4000);
			su.clickElement(test,putility.getProperty("search_button"),"search_button", testCaseId);
			su.Processing();
		}


		//Click on results
		su.clickElement(test,putility.getProperty("search_results_job_opening"),"search_results_job_opening", testCaseId);
		su.Processing();

		//Search with ApplicantID
		if(!applicantID.equals(""))
		{	
			su.clickElement(test,putility.getProperty("find_applicants_link"),"find_applicants_link", testCaseId);
			//su.Processing();
			Thread.sleep(1500);
			su.HandleAlert(applicantID);
			su.ConfirmAlert();	
			su.Processing();
			//Thread.sleep(5000);
		}
		
		//take action
		if(!takeAction.equals(""))
		{	
			su.SelectDropDown(test,putility.getProperty("take_action_dropdown"), takeAction,"Prepare_for_Hire",testCaseId);
			su.Processing();
		}

		su.ProcessingRE2E();
		if(su.existsElement(putility.getProperty("error_msg"))){
			String error_msg = su.getText(putility.getProperty("error_msg"));
			System.out.println("Error after loading the candidate as - "+error_msg);
			if (!error_msg.isEmpty()){
				Log.error("Error after loading the candidate as - "+error_msg);
				su.takeScreenShot(test, "Prepare_for_Hire", testCaseId, "Error after loading the candidate");
				excelUtils.setCellData("Prepare_for_Hire", "FAIL", testCaseId, "Result_Status");
				excelUtils.setCellData("Prepare_for_Hire", error_msg, testCaseId, "Result_Errors");
				test.log(LogStatus.FAIL,"Employeee data should get loaded", "Employeee data loaded with error - "+error_msg);
				Reporter.log("Error after loading the candidate as - "+error_msg);
				throw new Exception("Error after loading the candidate as - "+error_msg);
			}		
			
		}
		//Verify Applicant type
		if(!applicantType.equals(""))
		{
			String objectPath = putility.getProperty("applicant_type")+applicantType+"')]";
			su.existsElement(objectPath);
		}
		
		//Setting up anticipated date
		if(!anticipatedDate.equals(""))
		{	
			
			if(anticipatedDate.equalsIgnoreCase("Current_Date"))	
			{	
				if(su.existsElement(putility.getProperty("anticipated_start_date_editbox"))){
					su.SetData(test,putility.getProperty("anticipated_start_date_editbox"),su.GetCurrentSystemDate());
					su.Processing();
					Log.info("AnticipatedDate is entered as  Current date -" +su.GetCurrentSystemDate());
				}
				else if (su.existsElement(putility.getProperty("anticipated_start_date_dropdown"))){
					su.selectClosestDate(test, putility.getProperty("anticipated_start_date_dropdown"), "Prepare_for_Hire", testCaseId);
					Log.info("AnticipatedDate is selected as  nearest Past date as -" +su.GetPreviousDate());
					su.Processing();
					
				}
			}
		} else{
			System.out.println("User has not entered any value for anticipated date");
			Log.info("AnticipatedDate could not be entered as the user has not provided any value in Test Data sheet");
		}
			
			
		
		//Select Country from lookup		
		if(!nationalIDCountry.equals(""))
		{
			String objPath = putility.getProperty("pfh_country_textbox");
			String obj = su.getValue(objPath);
			if(!obj.equals(nationalIDCountry))
			{
			su.SetLookUpValue(extent,test,putility.getProperty("country_look_up_icon"),putility.getProperty("lookup_country_txtbox"),nationalIDCountry,"Prepare_for_Hire",testCaseId);
			su.Processing();
			su.SwitchFrames("ptifrmtgtframe");
			}
		}
		else
		{
			System.out.println("there is no value");
		} 
		
		//Checking whether national Id is auto poulated for Internal candidates
		if(!nationalID.equals(""))
		{	
			String objPath = putility.getProperty("national_id_txtbox");
			String objValue = su.getValue(objPath);
			if(!objValue.equals(""))
			{
				System.out.println("National Id is autopopulated and it is "+objValue);
			}
			else{
				//Entering national Id country,type and id from test data
				su.SetLookUpValue(extent,test,putility.getProperty("country_look_up_icon"),putility.getProperty("lookup_country_txtbox"),nationalIDCountry,"Prepare_for_Hire",testCaseId);
				su.Processing();
				su.SwitchFrames("ptifrmtgtframe");
				su.SelectDropDown(test,putility.getProperty("national_id_type_drop_down"), nationalIDType,"Prepare_for_Hire",testCaseId);
				su.Processing();
				System.out.println("Entering National Id");
				su.SetData(test,putility.getProperty("national_id_txtbox"),nationalID);
			}
		}
		
		
		if(!transactionType.equals(""))
		{
			System.out.println("inside trans type");
			String elementValue = su.ElementSelected(putility.getProperty("transaction_type_drop_down"));
			if(!elementValue.equalsIgnoreCase(transactionType))
			{	
				su.SelectDropDown(test,putility.getProperty("transaction_type_drop_down"), transactionType,"Prepare_for_Hire",testCaseId);
				su.Processing();
				su.Processing();
			}
		}	
		
		//Below steps are only for External Candidates
		if (applicantType.equalsIgnoreCase("External")){
			if(DOBHire == null)
			{
				System.out.println("No value in DOB hire");
			}
			else{
				su.SetData(test, putility.getProperty("hire_DOB"),DOBHire);
				su.Processing();
			}

			//Selecting national id type
			if(!dlCountry.equals(""))
			{
				String value = putility.getProperty("dl_country");
				String obj = su.getValue(value);
				//String value = staffingUtil.ElementSelected(putility.getProperty("dl_country"));
				if(!obj.equalsIgnoreCase(dlCountry))
				{	
					su.SetData(test,putility.getProperty("dl_country"),dlCountry);
					su.Processing();
				}
			}
			else{
				System.out.println("there is no value for Dl Country");
			}

			if(!dlState.equals(""))
			{
				String value = putility.getProperty("dl_state");
				String obj = su.getValue(value);
				System.out.println("dl_state******" +obj);
				if(!obj.equalsIgnoreCase(dlState))
				{			
					su.SetData(test,putility.getProperty("dl_state"),dlState);
					su.Processing();
				}
			}

			if(!dlNumber.equals("")){
				System.out.println("GOING TO ENTER DL NUMBER");		
				su.SetData(test,putility.getProperty("dl_number"),dlNumber);
				su.Processing();
			}
			else{
				System.out.println("dl number is empty");
			}

			if(dlExpDate== null){
				System.out.println("dl Exp date  is no value");
			}
			else{
				System.out.println("dlExpDate"  +dlExpDate);
				su.clearTextBox(putility.getProperty("dl_exp_date"));
				su.SetData(test, putility.getProperty("dl_exp_date"),dlExpDate);
				su.Processing();
			} 

			//Selecting national id type
			if(!nationalIDType.equals("")){
				String value = su.ElementSelected(putility.getProperty("national_id_type_drop_down"));
				if(!value.equalsIgnoreCase(nationalIDType))
				{			
					su.SelectDropDown(test,putility.getProperty("national_id_type_drop_down"), nationalIDType,"Prepare_for_Hire",testCaseId);
					su.Processing();
				}
			}
			
			//Enter National ID 
			if(!nationalID.equals(""))
			{	System.out.println("INSIDE NATIOANL ID");
				su.SetData(test,putility.getProperty("national_id_txtbox"),nationalID);
			}
			
			
			//By Pass Pre Employment Check
			if(!byPassPreEmplCheck.equals(""))
			{
				if (byPassPreEmplCheck.equalsIgnoreCase("Y"))
				{	System.out.println("Selecting chkbox byPassPreEmplCheck");
					su.selectCheckBox(putility.getProperty("pre_emp_check"));
					su.SwitchFrames("ptifrmtgtframe");
				}
				else if(byPassPreEmplCheck.equalsIgnoreCase("N"))
				{
				}
			}


			if(verifyCreateEmpID.equalsIgnoreCase("Y"))
			{
				String obj = putility.getProperty("To_Do_Items")+"Verify/Create Employee ID']"	;
				System.out.println("Going to click on Verify/Create Employee ID obj   "+obj);
				su.clickElement(test,obj,"Verify/Create Employee ID", testCaseId);
				su.Processing();
				if(su.existsElement(obj))
				{
					su.doubleClick(obj);
					su.Processing();
				}
				
				su.checkPopUp(extent, test, "Prepare_for_Hire", testCaseId, "Aftr clicking Verify/Cretae Emp ID");
				su.SwitchFrames("ptifrmtgtframe");
				su.ProcessingRE2E();
				if(su.existsElement(putility.getProperty("employee_ID"))){
					emplIDGenerated = su.getText(putility.getProperty("employee_ID"));
					if (emplIDGenerated.isEmpty()){
						Log.info("Emp iD could not be generated for job Id - "+jobOpeningID);
						excelUtils.setCellData("Prepare_for_Hire", "Emp ID could not be generated", testCaseId, "Emplid_Generated");
						test.log(LogStatus.FAIL,"Employee ID should get generated", "Emp iD could not be generated successfuly  for job Id - "+jobOpeningID);
						Reporter.log("Emp iD could not be generated for job Id - "+jobOpeningID);
					} else {
						System.out.println("EMP ID GENERATED SUCCESSFULLY    "+emplIDGenerated);
						Log.info("Emp iD '"+emplIDGenerated+"' successfuly generated for job Id - "+jobOpeningID);
						excelUtils.setCellData("Prepare_for_Hire", emplIDGenerated, testCaseId, "Emplid_Generated");
						test.log(LogStatus.PASS,"Employee ID should get generated", " Employee ID generated successfully as -" +emplIDGenerated+"'  for job id  - '"+jobOpeningID+"' " );
						Reporter.log("Emp iD '"+emplIDGenerated+"' successfuly generated for job Id - "+jobOpeningID);	
					}		
				}
				else
				{	
					su.checkPopUp(extent, test, "Prepare_for_Hire", testCaseId, "Submit For Hire Link");
					Log.info("Emp iD could not be generated for job Id - "+jobOpeningID);
					System.out.println("EMP ID GENERATion FAILED");
					excelUtils.setCellData("Prepare_for_Hire", "Emp ID could not be generated", testCaseId, "Emplid_Generated");
					test.log(LogStatus.FAIL,"Employee ID should get generated", "Emp iD could not be generated successfuly  for job Id - "+jobOpeningID);
					Reporter.log("Emp iD could not be generated for job Id - "+jobOpeningID);
				}
			}
					

			if(!initiatePreBoarding.equals(""))
			{			
				if(initiatePreBoarding.equalsIgnoreCase("Y"))
				{
					String obj = putility.getProperty("To_Do_Items")+"Initiate Pre-Boarding Process']"	;
					System.out.println("obj   "+obj);
					su.clickElement(test,obj,"Initiate Pre-Boarding Process", testCaseId);
					if(su.existsElement(putility.getProperty("To_Do_Items")+"Initiate Pre-Boarding Process']"))
					{
						su.doubleClick(obj);
						su.Processing();
						Thread.sleep(2000);
					}
				}

				if(!emailTo.isEmpty())
				{
					su.clearTextBox(putility.getProperty("email_to_txtbox"));
					su.SetData(test,putility.getProperty("email_to_txtbox"),emailTo);
					su.Processing();
				}
				
				if(!viewOfferLetter.equals(""))
				{
					if(viewOfferLetter.equalsIgnoreCase("Y"))
					{
						su.doubleClick(putility.getProperty("view_offer_letter_button"));
						su.Processing();
						su.WindowHandles();
						if(editOfferLetter.equalsIgnoreCase("N"))
							su.clickElement(test,putility.getProperty("message_window_no_btn"),"message_window_no_btn", testCaseId);
						else if(editOfferLetter.equalsIgnoreCase("Y"))	
							su.clickElement(test,putility.getProperty("message_window_yes_btn"),"message_window_yes_btn", testCaseId);
					}
				}
				
				su.SwitchFrames("ptifrmtgtframe");
				if(su.existsElement(putility.getProperty("offer_letter_error"))){
					su.clickElement(test,putility.getProperty("cancel_temp"),"cancel_temp", testCaseId);
					System.out.println("CANCEl btn found");
					su.Processing();
				}
				else{
					//Storing the value of current Window
					String currWinName = su.getCurrWindowName();
					
					//Switching to new WIndow
					su.newWindowHandles();
					su.DriverClose();
					
					//After closing the offer letter now switching back to previous window
					su.switchToWindow(currWinName);
					su.SwitchFrames("ptifrmtgtframe");
				}
				
				
				
				
				if(!sendEmail.equals(""))
				{
					if(sendEmail.equalsIgnoreCase("Y"))
						su.clickElement(test,putility.getProperty("send_mail"),"send_mail", testCaseId);
						System.out.println("Clicked on Send Email");
				}

			}
			else
			{
				System.out.println("there is no value for initiatePreBoarding " );
			}
			
			
			//Returning back to Prepare For hire Page
			if(applicantType.equalsIgnoreCase("External"))
			{
				su.clickElement(test,putility.getProperty("return_to_previous_page"),"return_to_previous_page", testCaseId);
				su.Processing();
			}
	
		}

		//Common for both Internal/External
		if(submitForHire.equalsIgnoreCase("Y"))
		{	System.out.println("INSIDE SUBMIT FOR HIRE");
			try{
				String obj = putility.getProperty("To_Do_Items")+"Submit for Hire']";
				if(su.existsElement(obj)){
					System.out.println("SUBMIT FOR HIRE LINK exist");
					if ((su.clickElement(test,obj,"Submit for Hire", testCaseId))){
						if(su.existsElement(obj))
						{	System.out.println("Perform Double click");
							su.doubleClick(obj);
							su.Processing();
						}
						su.Processing();
						Log.info("Submit for Hire Link is clicked successfully");
						Reporter.log("Submit for Hire Link is clicked successfully");
						//Now checking for the Pop up window
						su.WindowHandles();	
						if(SFHConfirm.equalsIgnoreCase("Y")){
								if(su.existsElement(putility.getProperty("SFH_confirm_message_yes_button"))){
									if ((su.clickElement(test,putility.getProperty("SFH_confirm_message_yes_button"),"SFH_confirm_message_yes_button", testCaseId))){
										test.log(LogStatus.PASS,"Prepare For Hire -Yes btn should be clicked", " Prepare For Hire -Yes btn should be clicked successfully" );
										su.SwitchFrames("ptifrmtgtframe");
										//Checking for the success messgae
										su.ProcessingRE2E();
										su.ProcessingRE2E();
										if(su.existsElement(putility.getProperty("success_message"))){
											String  success_message = su.getText(putility.getProperty("success_message"));
											if (success_message.contains("You have successfully submitted this request.")){
												System.out.println(success_message);
												excelUtils.setCellData("Prepare_for_Hire", "PASS", testCaseId, "Result_Status");
												test.log(LogStatus.PASS,"Prepare For Hire should get completed with success message", " Prepare For Hire completed  successfully for applicant -" +applicantID+"'  for job id  - '"+jobOpeningID+"' with success msg as -  "+success_message );
												Log.info(" Prepare For Hire completed  successfully for applicant -" +applicantID+"'  for job id  - '"+jobOpeningID+"' with success msg as -  "+success_message );
												Reporter.log(" Prepare For Hire completed  successfully for applicant -" +applicantID+"'  for job id  - '"+jobOpeningID+"' with success msg as -  "+success_message );		
											} else {
												excelUtils.setCellData("Prepare_for_Hire", "FAIL", testCaseId, "Result_Status");
												test.log(LogStatus.FAIL,"Prepare For Hire should get completed with success message", " Prepare For Hire could not be completed  successfully for applicant -" +applicantID+"'  for job id  - '"+jobOpeningID+"' " );
												Log.info(" Prepare For Hire could not be completed   for applicant - '" +applicantID+"'  for job id  - '"+jobOpeningID+"' " );
												Reporter.log(" Prepare For Hire could not be completed   for applicant - '" +applicantID+"'  for job id  - '"+jobOpeningID+"' " );
												throw new Exception(" Prepare For Hire could not be completed   for applicant - '" +applicantID+"'  for job id  - '"+jobOpeningID+"' " );
											}	
										}
									else {
										System.out.println("BEFORE Check Pop Up methods");
										su.checkPopUp(extent, test, "Prepare_for_Hire", testCaseId, "Submit For Hire Link");
										System.out.println("AFTER Check Pop Up methods");
										excelUtils.setCellData("Prepare_for_Hire", "SFH Confirm pop could not be clicked because YES button was not found", testCaseId, "Result_Errors");
										excelUtils.setCellData("Prepare_for_Hire", "FAIL", testCaseId, "Result_Status");
										test.log(LogStatus.FAIL,"Prepare For Hire -Yes- btn should be clicked", "SFH confirm pop up could not be clicked because YES button was not found" );
										Log.error(" SFH confirm could not be clicked because YES button was not found");
										Reporter.log(" SFH confirm could not be clicked because YES button was not found");
										throw new Exception("SFH confirm could not be clicked because YES button was not found");
									}
								}
							}
							else {
								System.out.println("BEFORE Check Pop Up methods");
								su.checkPopUp(extent, test, "Prepare_for_Hire", testCaseId, "Submit For Hire Link");
								System.out.println("AFTER Check Pop Up methods");
								excelUtils.setCellData("Prepare_for_Hire", "SFH Confirm pop could not be clicked as YES", testCaseId, "Result_Errors");
								excelUtils.setCellData("Prepare_for_Hire", "FAIL", testCaseId, "Result_Status");
								test.log(LogStatus.FAIL,"Prepare For Hire -Yes- btn should be clicked", "SFH confirm pop up could not be clicked because YES button was not found" );
								Log.error(" SFH confirm could not be clicked because YES button was not found");
								Reporter.log(" SFH confirm could not be clicked because YES button was not found");
								throw new Exception("SFH confirm could not be clicked because YES button was not found");
							}
						}
						else if(SFHConfirm.equalsIgnoreCase("N")){
							su.clickElement(test,putility.getProperty("SFH_confirm_message_no_button"),"SFH_confirm_message_no_button", testCaseId);
							test.log(LogStatus.WARNING,"Prepare For Hire -Yes btn should be clicked", " Prepare For Hire -NO-  btn has clicked" );	
						}
								
					} 
				}
			}catch (Exception e){
				Log.error("Submit for Hire Link could not be clicked  - "+e);
				Reporter.log("Submit for Hire Link could not be clicked  - "+e);
				excelUtils.setCellData("Prepare_for_Hire", "FAIL", testCaseId, "Result_Status");
				excelUtils.setCellData("Prepare_for_Hire", ""+e, testCaseId, "Result_Errors");
				test.log(LogStatus.FAIL,"Click Submit For Hire Link", " Submit For Hire Link could not be clicked " );
				throw new Exception("Submit for Hire Link could not be clicked  - "+e);
			}			
		}
		else
		{
			Log.info("There is no value for submitForHire in the test data sheet");
			test.log(LogStatus.INFO,"Click Submit For Hire Link", " Submit For Hire Link could not be clicked because the excel has no value to take action" );
			excelUtils.setCellData("Prepare_for_Hire", "Value missing in excel for Submit for Hire", testCaseId, "Result_Status");
		}
		

	}


	@BeforeMethod
	public void beforeMethod() throws Exception {
		  DOMConfigurator.configure("log4j.xml");
		  Log.startTestCase("Start Execution");
		  Log.info("Staffing :: beforeClass() method invoked...");
		  extent.config().documentTitle("Staffing Automation");
		  extent.config().reportName("Prepare For Hire");
		  extent.config().reportHeadline("-Staffing");
		  extent.addSystemInfo("Selenium Version", "2.46");
		  extent.addSystemInfo("Environment", "Staging");
	}	

	@AfterMethod
	  @Parameters("testCaseId")
	  public void afterMethod(String testCaseId) {
		  Log.info("Staffing :: afterClass() method invoked...");
		  try{
			  if (su.executeTestCase("Prepare_for_Hire", testCaseId)){
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



