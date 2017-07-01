package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareDeleteSchedulePlanBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareDeleteSchedulePlanDAO deleteSchedulePlanDAO=(DigiHealthCareDeleteSchedulePlanDAO)ctx.getBean("deleteSchedulePlan");

	public CISResults deleteSchedule(String aptId, String patientId, int seriesId){
		
		final Logger logger = Logger.getLogger(DigiHealthCareDeleteSchedulePlanBL.class);
		CISResults cisResult=new CISResults();
		EmailCommunication sendMail=new EmailCommunication();
		DigiHealthCareAdminViewRecurrencePlansModel deleteRecur=new DigiHealthCareAdminViewRecurrencePlansModel();
		// int recur=deleteRecur.getRecurrence();
		// int seriesId=deleteRecur.getAptseriesId();
		 
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 
		 
		  cisResult=deleteSchedulePlanDAO.getPatientDetails(patientId,aptId);
		  PatientDetailsModel  patientDetails=(PatientDetailsModel)cisResult.getResultObject();
		  String type=patientDetails.getType();
		  String startTime=patientDetails.getStartTime();
		 
		  cisResult=deleteSchedulePlanDAO.getStaffDetails(patientId,aptId);
		  StaffDetails  staffDetails=(StaffDetails)cisResult.getResultObject();
		  String firstName=staffDetails.getStaffname();
		  String Lastname=staffDetails.getStaflname();
		  String StaffemailId=staffDetails.getStaffmail();
		  
		 if(seriesId==0){
			 cisResult = deleteSchedulePlanDAO.deleteSchedule(aptId,patientId);
			
		}else{
			 cisResult = deleteSchedulePlanDAO.deleteRecurSchedule(patientId,seriesId);
			 cisResult = deleteSchedulePlanDAO.deleteRecurSeriesSchedules(patientId,seriesId);
		
		}
			
		 
		 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	      {
			 			  
			  cisResult=deleteSchedulePlanDAO.getPatientEmail(patientId);
			
			  DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResult.getResultObject();
			  String  patientEmail=patientEmailId.getEmailId();
			 
			  DigiHealthCarePatientModel  firstname=(DigiHealthCarePatientModel)cisResult.getResultObject();
			  String name=firstname.getFirstName();
			
			  DigiHealthCarePatientModel  lastName=(DigiHealthCarePatientModel)cisResult.getResultObject();
			  String  lastname=lastName.getLastName();
			  
			 
			  
			  String cc= StaffemailId ;
              String bcc= CISConstants.ADMINEMAILID ;
			  
			  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			   {
				  cisResult=sendMail.sendPatientDelMail(patientEmail,type,startTime,firstName,Lastname,cc,bcc);
				 //cisResult=sendMail.sendAdminDelMail(name,lastname,cc,bcc);
			   }
	      }
		 
		 
		// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
	     logger.info("Database time for delete schedule service:: " +result );
	  
		return cisResult;
	}


}