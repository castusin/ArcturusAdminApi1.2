
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
public class DigiHealthCareAdminViewPlansRest {

	
	
	@RequestMapping(value="/adminViewPlans",method=RequestMethod.GET,produces={"application/json"})
	
		public String adminViewPlans(@RequestParam ("patientId") String patientId,HttpServletRequest request){	 
		 Logger logger = Logger.getLogger(DigiHealthCareAdminViewPlansRest.class);
		 /*String requestParameters = "firstName=" + firstName + "&lastName=" +lastName + "&phoneNumber="+phoneNumber+ "&emailId="+emailId+ "&gender="+gender;*/
		  //logger.info("Digital HealthCare view patients Request Parameters :"+requestParameters);
		 
		// Capture service Start time
		  TimeCheck time=new TimeCheck();
		  testServiceTime sessionTimeCheck=new testServiceTime();
		  String serviceStartTime=time.getTimeZone();
 
		 
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		// CISResults cisResults=CommonCISValidation.adminViewPlansValidation(patientId,request);
		//if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 // {
			DigiHealthCareAdminViewPlansWebservice adminViewPlansWebservice= new DigiHealthCareAdminViewPlansWebservice();
			CISResults  cisResults  = adminViewPlansWebservice.adminViewPlans(patientId);
		  logger.info(" DigitalHealthCare: admin view Plans :"+cisResults);
		//}
		
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
