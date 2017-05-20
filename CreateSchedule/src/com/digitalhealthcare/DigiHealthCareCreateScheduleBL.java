package com.digitalhealthcare;

import java.sql.Date;
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
		final long ONE_MINUTE_IN_MILLIS=60000;
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
		 int totalDay=0;
		 String startDateTime=createSchedule.getStartDateTime();
	   	if(recurrenceTime >=1){
	   		    seriesStatus=CISConstants.seriesStatus1;
	   		  // Calendar today =createSchedule.getStartDateTime();
			  Calendar today = Calendar.getInstance();
			 
		        Calendar newDate = Calendar.getInstance();
		        newDate.add(Calendar.WEEK_OF_MONTH, recurrenceTime);
		        System.out.println("Fetching Dates between ::"+today.getTime()+" and "+newDate.getTime());
		        while (newDate.compareTo(today) > 0) {
		        	aptId = count.incrementAndGet();
		            System.out.println("day:" + today.getTime());
		            today.add(Calendar.WEEK_OF_MONTH, 1);
		           
		            
		            Calendar date = Calendar.getInstance();
		            long t= date.getTimeInMillis();
		            Date endDateTime=new Date(t + (30 * ONE_MINUTE_IN_MILLIS));
		            
		            cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffId,createSchedule.getPatientId(),createSchedule.getStartDateTime(),endDateTime,totalDay,createSchedule.getType(),createSchedule.getAptWith(),createDate,seriesStatus,recurrenceTime);
		    		
		        }
		       
		}else{
			    Calendar date = Calendar.getInstance();
	            long t= date.getTimeInMillis();
	            Date endDateTime=new Date(t + (30 * ONE_MINUTE_IN_MILLIS));
	            
	            cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffId,createSchedule.getPatientId(),createSchedule.getStartDateTime(),endDateTime,totalDay,createSchedule.getType(),createSchedule.getAptWith(),createDate,seriesStatus,recurrenceTime);
	    		
		}
	   
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for create schedule service:: " +result );
		  
		return cisResults;
	}


}