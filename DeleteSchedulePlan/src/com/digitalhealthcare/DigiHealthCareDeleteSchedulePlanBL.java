package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareDeleteSchedulePlanBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareDeleteSchedulePlanDAO deleteSchedulePlanDAO=(DigiHealthCareDeleteSchedulePlanDAO)ctx.getBean("deleteSchedulePlan");

	public CISResults deleteSchedule(int aptId){
		
		final Logger logger = Logger.getLogger(DigiHealthCareDeleteSchedulePlanBL.class);
		// Capture service Start time
	  	 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 CISResults cisResult = deleteSchedulePlanDAO.deleteSchedule(aptId);
		// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
	     logger.info("Database time for delete schedule service:: " +result );
		  
		return cisResult;
	}


}