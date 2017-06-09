package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareDeleteSchedulePlanBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareDeleteSchedulePlanDAO deleteSchedulePlanDAO=(DigiHealthCareDeleteSchedulePlanDAO)ctx.getBean("deleteSchedulePlan");

	public CISResults deleteSchedule(String aptId, String patientId, int seriesId){
		
		final Logger logger = Logger.getLogger(DigiHealthCareDeleteSchedulePlanBL.class);
		CISResults cisResult=new CISResults();
		DigiHealthCareAdminViewRecurrencePlansModel deleteRecur=new DigiHealthCareAdminViewRecurrencePlansModel();
		// int recur=deleteRecur.getRecurrence();
		// int seriesId=deleteRecur.getAptseriesId();
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 if(seriesId==0){
			 cisResult = deleteSchedulePlanDAO.deleteSchedule(aptId,patientId);
			
		}else{
			 cisResult = deleteSchedulePlanDAO.deleteRecurSchedule(patientId,seriesId);
		
		}
			
		// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
	     logger.info("Database time for delete schedule service:: " +result );
	  
		return cisResult;
	}


}