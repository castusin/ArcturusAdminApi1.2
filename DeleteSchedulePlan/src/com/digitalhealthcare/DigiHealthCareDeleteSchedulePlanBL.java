package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.SMSCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareDeleteSchedulePlanBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareDeleteSchedulePlanDAO deleteSchedulePlanDAO=(DigiHealthCareDeleteSchedulePlanDAO)ctx.getBean("deleteSchedulePlan");

	public CISResults deleteSchedule(String aptId, String patientId, int seriesId) throws Throwable{
		
		final Logger logger = Logger.getLogger(DigiHealthCareDeleteSchedulePlanBL.class);
		CISResults cisResult=new CISResults();
		EmailCommunication sendMail=new EmailCommunication();
		SMSCommunication smsCommunicaiton=new SMSCommunication();
		DigiHealthCareAdminViewRecurrencePlansModel deleteRecur=new DigiHealthCareAdminViewRecurrencePlansModel();
	    String sessionId = UUID.randomUUID().toString();
        String messageId=DigestUtils.sha1Hex(sessionId);
        String  upToNCharacters = messageId.substring(0, Math.min(aptId.length(), 6));
        messageId=upToNCharacters;
        
         TimeCheck time=new TimeCheck();
         Calendar currentdate = Calendar.getInstance();
	     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	     formatter.setTimeZone(obj);
	     String createDate=time.getTimeZone();
	     
		// Capture service Start time
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
			  DigiHealthCarePatientModel  phone=(DigiHealthCarePatientModel)cisResult.getResultObject();
              
              String phoneNumber=phone.getPhone();
			 
			  
			  String cc= StaffemailId ;
              String bcc= CISConstants.ADMINEMAILID ;
              
              String subject="Your care plan schedule has been deleted.";
              String messageType=CISConstants.RECIEVED;;
              String directorMail="udaykatikala@gmail.com";
              String dirPhone=CISConstants.DIRPHONE;
			  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			   {
				  cisResult=sendMail.sendPatientDelMail(patientEmail,type,startTime,firstName,Lastname,cc,bcc,directorMail);
				  cisResult=deleteSchedulePlanDAO.messageText(messageId,aptId,patientId,phoneNumber,patientEmail,subject,createDate,messageType);
				  cisResult=smsCommunicaiton.sendDeleteSMS(patientEmail,type,startTime,firstName,Lastname,cc,bcc,directorMail,phoneNumber,dirPhone);
                  
			   }
	      }
		 
		 
		// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
	     logger.info("Database time for delete schedule service:: " +result );
	  
		return cisResult;
	}


}