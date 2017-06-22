
package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareEditSchedulePlanBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareEditSchedulePlanDAO editSchedulePlanDAO=(DigiHealthCareEditSchedulePlanDAO)ctx.getBean("editSchedulePlanDAO");

	public CISResults editSchedulePlan(DigiHealthCareEditSchedulePlanModel editSchedulePlan) throws Throwable{
		
		CISResults cisResult=new CISResults();
		EmailCommunication sendMail=new EmailCommunication();
		final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 int recurrenceTime=editSchedulePlan.getRecurrenceTime();
		 int aptSeriesId=editSchedulePlan.getAptseriesId();
		 int aptListSize=editSchedulePlan.getAptList().size();
	 	 String aptId=editSchedulePlan.getAptId();
	 	 Calendar currentdate = Calendar.getInstance();
	     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	     formatter.setTimeZone(obj);
	     String createDate=time.getTimeZone();
	     int totalDay=CISConstants.totalDay;
	     String patientId=editSchedulePlan.getPatientId();
	     String type= editSchedulePlan.getType();
	     int staffid=0;
	     String startTime="";
		 String endTime="";
		 String appwith="";
		 
		 if(recurrenceTime>=1){
			 
			 cisResult = editSchedulePlanDAO.deleteSchedulePlan(aptSeriesId);
				 
			 for (int i = 0; i < aptListSize; i++)
			 {
				  startTime= editSchedulePlan.getAptList().get(i).startDateTime;
			     
			      endTime =  editSchedulePlan.getAptList().get(i).endDateTime;
			  
			      staffid =  editSchedulePlan.getAptList().get(i).staffId;
			    
			      appwith =  editSchedulePlan.getAptList().get(i).aptWith;
			    
			 // Now start logic
			    String seriesStatus=CISConstants.seriesStatus1;
		         String startDateTime=startTime;
		         String enddateTime=endTime;
		         String endDateTime = "";
			 
		         // Logic to split Enddate time 
		         String[] allStrings = enddateTime.split("\\s");
		            for (int j = 4; j < allStrings.length; j++){
		                endDateTime = endDateTime + " " + allStrings[j];
		           
		        }
		            // Logic to Get recursive next week datetime
		          
		      for (int k=1; k<=recurrenceTime; k++) {
		          //aptId = aptId+1;
		    	  String sessionId = UUID.randomUUID().toString();
			       aptId=DigestUtils.sha1Hex(sessionId);
			      String upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
			      aptId=upToNCharacters;
			      
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
		         
		           cisResult = editSchedulePlanDAO.createSchedule(aptId,aptSeriesId,staffid,editSchedulePlan.getPatientId(),startDateTime,endDatetime,totalDay,editSchedulePlan.getType(),appwith,createDate,seriesStatus);
		          // cisResult = editSchedulePlanDAO.deleteSchedule(aptId);
		           
		           cisResult=editSchedulePlanDAO.getStaffEmail(staffid);
					  
					DigiHealthCareSaveStaffMemberModel  staffEmailId=(DigiHealthCareSaveStaffMemberModel)cisResult.getResultObject();
					String staffEmail=staffEmailId.getEmailId();
					
					cisResult=sendMail.sendStaffMail(staffEmail,startTime,endTime,recurrenceTime);
			        
		           }
			 }
			
		 }else{
			 
			 
			  // for single recurrence
			 
			 for (int i = 0; i < aptListSize; i++)
			 {
				  startTime= editSchedulePlan.getAptList().get(i).startDateTime;
			     
			      endTime =  editSchedulePlan.getAptList().get(i).endDateTime;
			  
			      staffid =  editSchedulePlan.getAptList().get(i).staffId;
			    
			      appwith =  editSchedulePlan.getAptList().get(i).aptWith;
			 
			 cisResult = editSchedulePlanDAO.editSchedulePlan(staffid,startTime,endTime,editSchedulePlan.getAllDay(),appwith,editSchedulePlan.getSeriesStatus(),editSchedulePlan.getPatientId(),editSchedulePlan.getAptId());
			 }
			 
			 
			 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		      {
				  cisResult=editSchedulePlanDAO.getStaffEmail(staffid);
				  
				  DigiHealthCareSaveStaffMemberModel  staffEmailId=(DigiHealthCareSaveStaffMemberModel)cisResult.getResultObject();
				  String staffEmail=staffEmailId.getEmailId();
				 
				  DigiHealthCareSaveStaffMemberModel  stafffname=(DigiHealthCareSaveStaffMemberModel)cisResult.getResultObject();
				  String fname=stafffname.getfName();
				
				  DigiHealthCareSaveStaffMemberModel  stafflname=(DigiHealthCareSaveStaffMemberModel)cisResult.getResultObject();
				  String lname=stafflname.getlName();
				  
				  cisResult=editSchedulePlanDAO.getPatientEmail(patientId);
				
				  DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResult.getResultObject();
				  String  patientEmail=patientEmailId.getEmailId();
				 
				  DigiHealthCarePatientModel  firstname=(DigiHealthCarePatientModel)cisResult.getResultObject();
				  String name=firstname.getFirstName();
				
				  DigiHealthCarePatientModel  lastName=(DigiHealthCarePatientModel)cisResult.getResultObject();
				  String  lastname=lastName.getLastName();
				  
				  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
				   {
					  //cisResult=sendMail.sendStaffMail(staffEmail,startTime,endTime,recurrenceTime);
					  cisResult=sendMail.sendPatientMail(patientEmail,appwith,startTime,endTime,type,name,lastname,fname,lname,recurrenceTime);
					  cisResult=sendMail.sendAdminMail(appwith,startTime,endTime,type,name,lastname,fname,lname,recurrenceTime);
				   }
		      }
		 }
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for edit schedule plan service:: " +result );
		  
		return cisResult;
	}
	 

}