package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

@RestController
public class DigiHealthCareAdminViewRecurrencePlansRest {

	
	
	@RequestMapping(value="/adminViewRecurrencePlans",method=RequestMethod.GET,produces={"application/json"})
	
		public String adminViewPlans(@RequestParam ("patientId") String patientId,HttpServletRequest request) throws Throwable{	 
		 Logger logger = Logger.getLogger(DigiHealthCareAdminViewPlansRest.class);
		 String requestParameters = "patientId=" + patientId;
		 logger.info("Digital HealthCare admin view recurrence plans Request Parameters :"+requestParameters);
		 
		// Capture service Start time
		  TimeCheck time=new TimeCheck();
		  testServiceTime sessionTimeCheck=new testServiceTime();
		  String serviceStartTime=time.getTimeZone();
  
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 CISResults cisResults=CommonCISValidation.adminViewPlansValidation(patientId,request);
		 if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
			 	DigiHealthCareAdminViewRecurrencePlansWebservice adminViewRecPlansWebservice= new DigiHealthCareAdminViewRecurrencePlansWebservice();
			 	cisResults  = adminViewRecPlansWebservice.adminViewPlans(patientId);
		  logger.info(" DigitalHealthCare: admin view recurrence Plans :"+cisResults);
		}
		
		// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		 logger.info("Total service time for view patients service in milli seconds :: " +result );
		  return returnJsonData(cisResults);
	 }
	 	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
