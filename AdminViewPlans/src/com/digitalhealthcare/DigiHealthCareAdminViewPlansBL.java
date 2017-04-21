
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


public class DigiHealthCareAdminViewPlansBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareAdminViewPlansDAO adminViewPlansDAO=(DigiHealthCareAdminViewPlansDAO)ctx.getBean("adminViewPlans");

	public CISResults adminViewPlans(String patientId){
		
		final Logger logger = Logger.getLogger(DigiHealthCareAdminViewPlansBL.class);
		// Capture service Start time
		TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		  
		
		 
		CISResults cisResult = adminViewPlansDAO.adminViewPlans(patientId);
		logger.info("DigitalHealthCare:admin view plansBL  service" +cisResult );
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for admin view plans service:: " +result );
		  
		return cisResult;
	}


}