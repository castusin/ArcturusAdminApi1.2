
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


public class DigiHealthCareUpdateStaffDetailsBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareUpdateStaffDetailsDAO updateStaffDetailsDAO=(DigiHealthCareUpdateStaffDetailsDAO)ctx.getBean("updateStaffDetails");

	public CISResults updateStaffDetails(DigiHealthCareSaveStaffMemberModel updateStaff){
		
		final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
		// Capture service Start time
		TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 
		CISResults cisResult = updateStaffDetailsDAO.updateStaffDetails(updateStaff.getStaffId(),updateStaff.getfName(),updateStaff.getlName(),updateStaff.getServiceType(),updateStaff.getEmailId(),updateStaff.getPhone1(),updateStaff.getPhone2(),updateStaff.getAddress1(),updateStaff.getAddress2(),updateStaff.getCity(),updateStaff.getCounty(),updateStaff.getState(),updateStaff.getZipcode(),updateStaff.getActiveInd());
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for update staff service:: " +result );
		  
		return cisResult;
	}


}