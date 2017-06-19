package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.codec.digest.DigestUtils;
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
	
	// private static final AtomicInteger count = new AtomicInteger(100000036);
	
	 private static final AtomicInteger counts = new AtomicInteger(11000001);
	 
	 public CISResults createSchedule( DigiHealthCareCreateScheduleModel createSchedule) throws Throwable{
		
		final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
		
		EmailCommunication sendMail=new EmailCommunication();
		
		// Capture service Start time
		
		 CISResults cisResults=new CISResults();
		 Appointments aptList=new Appointments();
		 
		 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 
		 // generating aptid
		 
		  String sessionId = UUID.randomUUID().toString();
	      String aptId=DigestUtils.sha1Hex(sessionId);
	      String upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
	      aptId=upToNCharacters;
	      
		 int aptSeriesId = counts.incrementAndGet();
		 Calendar currentdate = Calendar.getInstance();
	     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	     formatter.setTimeZone(obj);
	     String createDate=time.getTimeZone();
	     int recurrenceTime=createSchedule.getRecurenceTime();
		 String seriesStatus=CISConstants.seriesStatus2;
		// int staffId=createSchedule.getStaffId();
		 int totalDay=CISConstants.totalDay;
		 String patientId=createSchedule.getPatientId();
		 
		 /*int startTimeListSize = createSchedule.getStartTimeList().size();
		 int endTimeListSize = createSchedule.getEndTimeList().size();*/

		 int aptListSize=createSchedule.getAptList().size();
		 
		 
		 String startTime="";
		 String endTime="";
		 String appwith="";
		 int staffid=0;
		 String type= createSchedule.getType();
		 
		// If startTimeListSize equal to > 1 need to series id=Y or series id=N no need else blcok
		 if(recurrenceTime>0){
		 if(aptListSize>=1){
			 
		 for (int i = 0; i < aptListSize; i++)
		 {
			  startTime= createSchedule.getAptList().get(i).startDateTime;
		      endTime =  createSchedule.getAptList().get(i).endDateTime;
		      staffid =  createSchedule.getAptList().get(i).staffId;
		      appwith =  createSchedule.getAptList().get(i).aptWith;
		    
		 // Now start logic
		     seriesStatus=CISConstants.seriesStatus1;
	         String startDateTime=startTime;
	         String enddateTime=endTime;
	         String endDateTime = "";
	         String startdateTime = "";
	         // Logic to split Enddate time 
	         String[] allStrings = enddateTime.split("\\s");
	         for (int j = 4; j < allStrings.length; j++){
	        	 endDateTime = endDateTime + " " + allStrings[j];
	           
	     }
	            // Logic to Get recursive next week datetime
	          
	      for (int k=1; k<=recurrenceTime; k++) {
	         // aptId = count.incrementAndGet();
	    	  sessionId = UUID.randomUUID().toString();
		      aptId=DigestUtils.sha1Hex(sessionId);
		      upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
		      aptId=upToNCharacters;
		      
		      SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
	          Date d1 = sdf.parse(startDateTime);
	          Calendar c = Calendar.getInstance();
	          c.setTime(d1); // Now use today date.
	          if(k==1){
	        	 // startDateTime=sdf.format(c.getTime());
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
		         	          
		          cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDateTime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus);
		          cisResults = createScheduleDAO.createSchedules(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDateTime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus,recurrenceTime);
		          
		         /* cisResults=createScheduleDAO.getStaffEmail(staffid);
				  
				  DigiHealthCareSaveStaffMemberModel  staffEmailId=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
				  String staffEmail=staffEmailId.getEmailId();
				
				  cisResults=sendMail.sendStaffMail(staffEmail,startTime,endTime);*/
		          
		          
	     }else{
	    	 
	    	 // Logic to split Startdate time 
	         String[] allStrings2 = startDateTime.split("\\s");
	         for (int p = 4; p < allStrings2.length; p++){
	        	 startdateTime = startdateTime + " " + allStrings2[p];
	           
	     }
	    	 
	    	 /*String[] allStrings1 = startDateTime.split("\\s");
             StringBuilder strBuilder = new StringBuilder();

             for (int l = 0; l < allStrings1.length-1; l++) {
            	 strBuilder.append(allStrings1[l]);
            	 strBuilder.append(" ");
           }*/
             //String startDatetime= strBuilder.toString();
	    	     c.add(Calendar.DATE, 7);
	    	     startDateTime=sdf.format(c.getTime());
	    	     
	    	 String[] allStrings1 = startDateTime.split("\\s");
             StringBuilder strBuilder = new StringBuilder();

             for (int l = 0; l < allStrings1.length-1; l++) {
            	 strBuilder.append(allStrings1[l]);
            	 strBuilder.append(" ");
           }
             String startDatetime= strBuilder.toString();
             startDatetime=startDatetime+startdateTime;
	    	 
	    	 
	    	 
	        	 //c.setTime(d1);
	        	// c.add(Calendar.DATE, 7);
	        	// d1.setTime(c.getTime().getTime());
	        	    
	        	// Date startDtime = d1;
	        	 //startDateTime=sdf.format(c.getTime());
	             // Concat Enddate with end time Lodic
	             String[] allStrings3 = startDatetime.split("\\s");
	             StringBuilder strBuilder3 = new StringBuilder();

	             for (int l = 0; l < allStrings3.length-1; l++) {
	            	 strBuilder3.append(allStrings3[l]);
	            	 strBuilder3.append(" ");
	           }
	             String endDatetime= strBuilder.toString();
	             endDatetime=endDatetime+endDateTime;
	           // cisResults.setParkDetails(parkDetailslist);   
	         
	             cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDatetime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus);
	        
	           }
	         }
		   }
		 }
		 }else{
			 
			 for (int i = 0; i < aptListSize; i++)
			 {
				  startTime= createSchedule.getAptList().get(i).startDateTime;
			      endTime =  createSchedule.getAptList().get(i).endDateTime;
			      staffid =  createSchedule.getAptList().get(i).staffId;
			      appwith =  createSchedule.getAptList().get(i).aptWith;
			 
			 // Now start logic
		     seriesStatus=CISConstants.seriesStatus2;
	         String startDateTime=startTime;
	         String enddateTime=endTime;
	         String endDateTime = "";
	         
	         sessionId = UUID.randomUUID().toString();
		     aptId=DigestUtils.sha1Hex(sessionId);
		     upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
		     aptId=upToNCharacters;
	         
	         // Logic to split Enddate time 
	         String[] allStrings = enddateTime.split("\\s");
	         for (int j = 4; j < allStrings.length; j++){
	                endDateTime = endDateTime + " " + allStrings[j];
	                cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDateTime,endTime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus);
			  			        
	         }
	         
		 }
	 }
			     
			
		 if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	      {
			  cisResults=createScheduleDAO.getStaffEmail(staffid);
			  
			  DigiHealthCareSaveStaffMemberModel  staffEmailId=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
			  String staffEmail=staffEmailId.getEmailId();
			 
			  DigiHealthCareSaveStaffMemberModel  stafffname=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
			  String fname=stafffname.getfName();
			
			  DigiHealthCareSaveStaffMemberModel  stafflname=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
			  String lname=stafflname.getlName();
			  
			  cisResults=createScheduleDAO.getPatientEmail(patientId);
			
			  DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResults.getResultObject();
			  String  patientEmail=patientEmailId.getEmailId();
			 
			  DigiHealthCarePatientModel  firstname=(DigiHealthCarePatientModel)cisResults.getResultObject();
			  String name=firstname.getFirstName();
			
			  DigiHealthCarePatientModel  lastName=(DigiHealthCarePatientModel)cisResults.getResultObject();
			  String  lastname=lastName.getLastName();
			  
			  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			   {
				 /* cisResults=sendMail.sendStaffMail(staffEmail,startTime,endTime);*/
				  cisResults=sendMail.sendPatientMail(patientEmail,appwith,startTime,endTime,type,name,lastname,fname,lname);
				  cisResults=sendMail.sendAdminMail(appwith,startTime,endTime,type,name,lastname,fname,lname);
			   }
	      }
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for create schedule service:: " +result );
			
	  
	 

		return cisResults;
		 }

}
		
	   