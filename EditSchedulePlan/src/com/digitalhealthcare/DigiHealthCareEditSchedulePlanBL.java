
package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareEditSchedulePlanBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareEditSchedulePlanDAO editSchedulePlanDAO=(DigiHealthCareEditSchedulePlanDAO)ctx.getBean("editSchedulePlanDAO");

	public CISResults editSchedulePlan(DigiHealthCareEditSchedulePlanModel editSchedulePlan){
		
		CISResults cisResult=new CISResults();
		
		final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
		// Capture service Start time
		TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 
		 
		 int startTimeListSize = editSchedulePlan.getStartTimeList().size();
		 int endTimeListSize = editSchedulePlan.getEndTimeList().size();
		 
		 
		 
		 
		 
		 // for single recurrence
		 
		 for (int i = 0; i < startTimeListSize; i++)
		 {
			 String x= editSchedulePlan.getStartTimeList().get(i).startDateTime;
		     
		     System.out.println("Starttime"+x);
		  
		     String y =  editSchedulePlan.getEndTimeList().get(i).endDateTime;
		     System.out.println("Endtime"+y);
		 
		 cisResult = editSchedulePlanDAO.editSchedulePlan(editSchedulePlan.getPatientId(),editSchedulePlan.getAptPersonId(),x,y,editSchedulePlan.getAllDay(),editSchedulePlan.getAptWith());
		 }
		 
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for edit schedule plan service:: " +result );
		  
		return cisResult;
	}
	 

}