package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		// int staffId=createSchedule.getStaffId();
		 int totalDay=CISConstants.totalDay2;
		 String patientId=createSchedule.getPatientId();
		 
		 
		
		 int startTimeListSize = createSchedule.getStartTimeList().size();
		 int endTimeListSize = createSchedule.getEndTimeList().size();

		 
		 
		 
		 
		// If startTimeListSize equal to > 1 need to series id=Y or series id=N no need else blcok
		 if(startTimeListSize>1){
		 for (int i = 0; i < startTimeListSize; i++)
		 {
			 String x= createSchedule.getStartTimeList().get(i).startDateTime;
		     
		     System.out.println("Starttime"+x);
		  
		     String y =  createSchedule.getEndTimeList().get(i).endDateTime;
		     System.out.println("Endtime"+y);
		     
		     String z =  createSchedule.getStaffIdList().get(i).staffId;
		     System.out.println("Endtime"+z);
		     
		     String p =  createSchedule.getAptWithList().get(i).aptWith;
		     System.out.println("Endtime"+p);
		 
		 // Now start logic
		     seriesStatus=CISConstants.seriesStatus1;
	         String startDateTime=x;
	         String enddateTime=y;
	         String endDateTime = "";
		 
	         // Logic to split Enddate time 
	         String[] allStrings = enddateTime.split("\\s");
	            for (int j = 4; j < allStrings.length; j++){
	                endDateTime = endDateTime + " " + allStrings[j];
	           
	        }
	            // Logic to Get recursive next week datetime
	         
	          for (int k=1; k<=recurrenceTime; k++) {
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

	           for (int l = 0; l < allStrings1.length-1; l++) {
	           strBuilder.append(allStrings1[l]);
	           strBuilder.append(" ");
	           }
	          String endDatetime= strBuilder.toString();
	          endDatetime=endDatetime+endDateTime;
	         // cisResults.setParkDetails(parkDetailslist);   
	         
	           cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,z,createSchedule.getPatientId(),startDateTime,endDatetime,totalDay,createSchedule.getType(),p,createDate,seriesStatus,recurrenceTime);
	           //cisResults.setStartTimeList(startDatetimelist);
	          
	          // cisResults.setEndTimeList(endDatetimelist);
	           }
		 
		 }
		 
		 }else{
			 
			 
			 for (int i = 0; i < startTimeListSize; i++)
			 {
				 String x= createSchedule.getStartTimeList().get(i).startDateTime;
			     
			     System.out.println("Starttime"+x);
			  
			     String y =  createSchedule.getEndTimeList().get(i).endDateTime;
			     System.out.println("Endtime"+y);
			 
			     String z =  createSchedule.getStaffIdList().get(i).staffId;
			     System.out.println("Endtime"+z);
			     
			     String p =  createSchedule.getAptWithList().get(i).aptWith;
			     System.out.println("Endtime"+p);
			 
			 cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,z,createSchedule.getPatientId(),x,y,totalDay,createSchedule.getType(),p,createDate,seriesStatus,recurrenceTime);
		 } 
		 }
		 if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	      {
			  /*cisResults=createScheduleDAO.getStaffEmail(staffId);
			  String staffEmail="";
			  DigiHealthCareSaveStaffMemberModel  staffEmailId=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
			  staffEmail=staffEmailId.getEmailId();*/
			  cisResults=createScheduleDAO.getPatientEmail(patientId);
			  String patientEmail="";
			  DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResults.getResultObject();
			  patientEmail=patientEmailId.getEmailId();
			  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			   {
				 // cisResults=sendMail.sendStaffMail(staffEmail);
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
		
	   