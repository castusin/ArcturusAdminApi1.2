package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareCreateScheduleBL {

	 ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	 DigiHealthCareCreateScheduleDAO createScheduleDAO=(DigiHealthCareCreateScheduleDAO)ctx.getBean("createSchedule");
	
	 private static final AtomicInteger count = new AtomicInteger(1001);
	
	 private static final AtomicInteger counts = new AtomicInteger(11101);
	 
	 public CISResults createSchedule( DigiHealthCareCreateScheduleModel createSchedule){
		
		final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
		// Capture service Start time
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
	  
		CISResults cisResult = createScheduleDAO.createSchedule(aptId,aptSeriesId,createSchedule.getPatientId(),createSchedule.getStartDateTime(),createSchedule.getEndDateTime(),createSchedule.getType(),createSchedule.getAptWith(),createDate,createSchedule.getSeriesStatus(),createSchedule.getRecurenceTime());
		
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for create schedule service:: " +result );
		  
		return cisResult;
	}


}