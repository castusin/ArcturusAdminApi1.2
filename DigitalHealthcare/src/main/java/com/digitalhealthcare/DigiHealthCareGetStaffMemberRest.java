
package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
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
public class DigiHealthCareGetStaffMemberRest {

	
	
	@RequestMapping(value="/getStaffList",method=RequestMethod.GET,produces={"application/json"})
	
		public String getStaffList(HttpServletRequest request,DigiHealthCareSaveStaffMemberModel viewStaffmember){	 
		 Logger logger = Logger.getLogger(DigiHealthCareGetStaffMemberRest.class);
		 
		// Capture service Start time
		  TimeCheck time=new TimeCheck();
		  testServiceTime sessionTimeCheck=new testServiceTime();
		  String serviceStartTime=time.getTimeZone();
 
		 
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 CISResults cisResults=CommonCISValidation.getStaffListValidation(request,viewStaffmember);
		 if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
			 DigiHealthCareGetStaffMemberWebservice staffMemberWebservice= new DigiHealthCareGetStaffMemberWebservice();
			 cisResults  = staffMemberWebservice.getStaffList(viewStaffmember);
			 logger.info(" DigitalHealthCare: get staff list rest service :"+cisResults);
		}
		
		// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		 logger.info("Total service time for get staff members service in milli seconds :: " +result );
		  return returnJsonData(cisResults);
	 }
	 	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
