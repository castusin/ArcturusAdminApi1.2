
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


public class DigiHealthCareSaveStaffMemberBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareSaveStaffMemberDAO saveStaffMemberDAO=(DigiHealthCareSaveStaffMemberDAO)ctx.getBean("saveStaffMember");
	// private static final AtomicInteger count = new AtomicInteger(111101);
	public CISResults saveStaffMember( DigiHealthCareSaveStaffMemberModel saveStaffmember){
		
		final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		// int staffId = count.incrementAndGet();
		 Calendar currentdate = Calendar.getInstance();
	     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	     formatter.setTimeZone(obj);
	     String createDate=time.getTimeZone();
		CISResults cisResult = saveStaffMemberDAO.saveStaffMember(saveStaffmember.getfName(),saveStaffmember.getlName(),saveStaffmember.getServiceType(),saveStaffmember.getEmailId(),saveStaffmember.getPhone1(),saveStaffmember.getPhone2(),saveStaffmember.getAddress1(),saveStaffmember.getAddress2(),saveStaffmember.getCity(),saveStaffmember.getCounty(),saveStaffmember.getState(),saveStaffmember.getZipcode(),saveStaffmember.getActiveInd(),createDate);
		
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for edit schedule plan service:: " +result );
		  
		return cisResult;
	}


}