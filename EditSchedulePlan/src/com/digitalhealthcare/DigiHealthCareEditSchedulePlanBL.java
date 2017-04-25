
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


public class DigiHealthCareEditSchedulePlanBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareEditSchedulePlanDAO editSchedulePlanDAO=(DigiHealthCareEditSchedulePlanDAO)ctx.getBean("editSchedulePlanDAO");

	public CISResults editSchedulePlan(DigiHealthCareEditSchedulePlanModel editSchedulePlan){
		
		final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
		// Capture service Start time
		TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 
		CISResults cisResult = editSchedulePlanDAO.editSchedulePlan(editSchedulePlan.getPatientId(),editSchedulePlan.getAptPersonId(),editSchedulePlan.getStartTime(),editSchedulePlan.getEndTime(),editSchedulePlan.getAllDay(),editSchedulePlan.getAptWith());
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for edit schedule plan service:: " +result );
		  
		return cisResult;
	}


}