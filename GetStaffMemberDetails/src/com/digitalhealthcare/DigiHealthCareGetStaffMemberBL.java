
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


public class DigiHealthCareGetStaffMemberBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareGetStaffMemberDAO getStaffMemberDAO=(DigiHealthCareGetStaffMemberDAO)ctx.getBean("getStaffMember");

	public CISResults getStaffList(String staffId){
		
		final Logger logger = Logger.getLogger(DigiHealthCareAdminViewPlansBL.class);
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		  
		
		 
		CISResults cisResult = getStaffMemberDAO.getStaffList( staffId);
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for get staff member service:: " +result );
		  
		return cisResult;
	}


}