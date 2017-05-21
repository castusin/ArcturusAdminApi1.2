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
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareCreateScheduleBL {

	 ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	 DigiHealthCareCreateScheduleDAO createScheduleDAO=(DigiHealthCareCreateScheduleDAO)ctx.getBean("createSchedule");
	
	 private static final AtomicInteger count = new AtomicInteger(1001);
	
	 private static final AtomicInteger counts = new AtomicInteger(11101);
	 
	 public CISResults createSchedule( DigiHealthCareCreateScheduleModel createSchedule) throws Throwable{
		
		final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
		// Capture service Start time
		final long ONE_HOUR_IN_MS = 3600000;
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
		// String startDateTime=createSchedule.getStartDateTime();
		 
		 
		 
		  // convert stringt to date
	     String startDateString = "Sat Apr 22 2017 12:27:00";
	     DateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
	     Date date = (Date) sdf.parse(startDateString);
	     
	     System.out.println(sdf.format(date));
	     
	     
	     
	     
	     // convert String to Calander
	     Calendar cal = Calendar.getInstance();
	     SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
	     cal.setTime(sdf1.parse("Sat Apr 22 2017 12:27:00"));// all done
	     
	     System.out.println(sdf1.getCalendar());
	     
	     
	     
	     
	        SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
	        int minutesToAdd = 30;
	        System.out.println("Initial Time: " + df.format(date.getTime()));
	        Calendar startTime =sdf1.getCalendar();
	        startTime.add(Calendar.MINUTE, minutesToAdd);
	        String dateStr = df.format(startTime.getTime());
	        System.out.println("After Time : " + dateStr + "\n");
		 
		 
		 
		 
		 
		 
		 
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
		           
		            
		           /* Calendar date = Calendar.getInstance();
		            long t= date.getTimeInMillis();
		            Date endDateTime=new Date(t + (30 * ONE_MINUTE_IN_MILLIS));*/
		            
		            //cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffId,createSchedule.getPatientId(),createSchedule.getStartDateTime(),endDateTime,totalDay,createSchedule.getType(),createSchedule.getAptWith(),createDate,seriesStatus,recurrenceTime);
		    		
		        }
		       
		}else{
			/*String startDateTime=createSchedule.getStartDateTime();
			DateFormat df = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss"); 
			java.util.Date startDate;
			try {
			    startDate = df.parse(startDateTime);
			    String t= startDateTime;
			    String endDateTime=(t + (30 * ONE_HOUR_IN_MS));
			    //String newDateString = df.format(endDateTime);
			    //System.out.println(newDateString);
			    cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffId,createSchedule.getPatientId(),createSchedule.getStartDateTime(),endDateTime,totalDay,createSchedule.getType(),createSchedule.getAptWith(),createDate,seriesStatus,recurrenceTime);
	    		
			} catch (ParseException e) {
			    e.printStackTrace();
			}
	           */
			
	           
		}
	   
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for create schedule service:: " +result );
		  
		return cisResults;
	}


}