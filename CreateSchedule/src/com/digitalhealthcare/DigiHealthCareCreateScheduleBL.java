package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ParseException;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareCreateScheduleBL {

	 ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	 DigiHealthCareCreateScheduleDAO createScheduleDAO=(DigiHealthCareCreateScheduleDAO)ctx.getBean("createSchedule");
	
	 private static final AtomicInteger count = new AtomicInteger(1001);
	
	 private static final AtomicInteger counts = new AtomicInteger(11101);
	 
	 public CISResults createSchedule( DigiHealthCareCreateScheduleModel createSchedule) throws Throwable{
		
		final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
		
		EmailCommunication sendMail=new EmailCommunication();
		//DigiHealthCareSaveStaffMemberModel staffEmailId=new DigiHealthCareSaveStaffMemberModel();
		// Capture service Start time
		
		 CISResults cisResults=new CISResults();
		 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 int aptId = count.incrementAndGet();
		 int aptSeriesId = counts.incrementAndGet();
		 Calendar currentdate = Calendar.getInstance();
	     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	     formatter.setTimeZone(obj);
	     String createDate=time.getTimeZone();
	     int recurrenceTime=createSchedule.getRecurenceTime();
		 String seriesStatus=CISConstants.seriesStatus2;
		 int staffId=createSchedule.getStaffId();
		 int totalDay=CISConstants.totalDay2;
		 String patientId=createSchedule.getPatientId();
		
		
		 // recurrence code
		 
		 if(recurrenceTime>=1){
			 seriesStatus=CISConstants.seriesStatus1;
	         String startDateTime=createSchedule.getStartDateTime();
	         String enddateTime=createSchedule.getEndDateTime();
	         String endDateTime = "";
	        
	         // Logic to split Enddate time 
	         String[] allStrings = enddateTime.split("\\s");
	            for (int i = 4; i < allStrings.length; i++){
	                endDateTime = endDateTime + " " + allStrings[i];
	           
	        }
	            // Logic to Get recursive next week datetime
	         
	          for (int i=1; i<=recurrenceTime; i++) {
	          aptId = count.incrementAndGet();
	          SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
	          Date d1 = sdf.parse(startDateTime);
	          Calendar c = Calendar.getInstance();
	          c.setTime(d1); // Now use today date.
	          c.add(Calendar.DATE, 7); // Adding 5 days
	          String output = sdf.format(c.getTime());
	          startDateTime=output;

	          // Concat Enddate with end time Lodic
	          String[] allStrings1 = startDateTime.split("\\s");
	          StringBuilder strBuilder = new StringBuilder();

	           for (int k = 0; k < allStrings1.length-1; k++) {
	           strBuilder.append(allStrings1[k]);
	           strBuilder.append(" ");
	           }
	          String endDatetime= strBuilder.toString();
	          endDatetime=endDatetime+endDateTime;
	                
	           cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffId,createSchedule.getPatientId(),startDateTime,endDatetime,totalDay,createSchedule.getType(),createSchedule.getAptWith(),createDate,seriesStatus,recurrenceTime);
	          		
	           }
	         }
		         //single insertion
	           else{
	        	   cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffId,createSchedule.getPatientId(),createSchedule.getStartDateTime(),createSchedule.getEndDateTime(),totalDay,createSchedule.getType(),createSchedule.getAptWith(),createDate,seriesStatus,recurrenceTime);
	       		
	               }
		          // mail code
		      if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		      {
				  cisResults=createScheduleDAO.getStaffEmail(staffId);
				  String staffEmail="";
				  DigiHealthCareSaveStaffMemberModel  staffEmailId=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
				  staffEmail=staffEmailId.getEmailId();
				  cisResults=createScheduleDAO.getPatientEmail(patientId);
				  String patientEmail="";
				  DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResults.getResultObject();
				  patientEmail=patientEmailId.getEmailId();
				  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
				   {
					  cisResults=sendMail.sendStaffMail(staffEmail);
					  cisResults=sendMail.sendPatientMail(patientEmail);
					  cisResults=sendMail.sendAdminMail();
				   }
		      }
			// Capture Service End time
			  String serviceEndTime=time.getTimeZone();
			  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			  logger.info("Database time for create schedule service:: " +result );
		  
		return cisResults;
	}

	
}