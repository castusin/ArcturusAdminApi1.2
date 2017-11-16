
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
		 Calendar currentdate = Calendar.getInstance();
	     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	     formatter.setTimeZone(obj);
	     String createDate=time.getTimeZone();
	     String phone1=saveStaffmember.getPhone1();
	     String phone2=saveStaffmember.getPhone2();
	     String contact2="";
	     String contact1=CISConstants.USA_COUNTRY_CODE+phone1;
	    	
	    	if(phone2==null){
	    		  contact2=phone2;
	    	}else{
	    		  contact2=CISConstants.USA_COUNTRY_CODE+phone2;
	    	}
	    	
	    	
	    
		 CISResults cisResult = saveStaffMemberDAO.saveStaffMember(saveStaffmember.getfName(),saveStaffmember.getlName(),saveStaffmember.getServiceType(),saveStaffmember.getEmailId(),contact1,contact2,saveStaffmember.getAddress1(),saveStaffmember.getAddress2(),saveStaffmember.getCity(),saveStaffmember.getCounty(),saveStaffmember.getState(),saveStaffmember.getZipcode(),saveStaffmember.getActiveInd(),createDate,saveStaffmember.getLattitude(),saveStaffmember.getLongitude(),saveStaffmember.getFax());
		
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for save staff member service:: " +result );
		  
		return cisResult;
	}


}