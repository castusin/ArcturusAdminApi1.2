
package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : create schedule Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareCreateScheduleRest {
	
	
	@RequestMapping(value="/createSchedule",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String createSchedule(@RequestBody DigiHealthCareCreateScheduleModel createSchedule){
		 
		Logger logger = Logger.getLogger(DigiHealthCareCreateScheduleRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		   // CISResults cisResults=CommonCISValidation.editSchedulePlanValidation(request,editSchedulePlan);
		   // if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    // {
            DigiHealthCareCreateScheduleWebservice createScheduleWebservice= new DigiHealthCareCreateScheduleWebservice();
		    	CISResults cisResults  = createScheduleWebservice.createSchedule(createSchedule);
		       logger.info(" DigitalHealthCare: create schedule rest service :"+cisResults);
		    // }
		       return returnJsonData(cisResults);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
}
