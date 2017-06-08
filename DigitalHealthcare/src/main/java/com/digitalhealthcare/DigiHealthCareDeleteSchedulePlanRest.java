package com.digitalhealthcare;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : Delete schedule plan Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareDeleteSchedulePlanRest {
	
	@RequestMapping(value="/deleteSchedule",method=RequestMethod.GET,produces={"application/json"})
	
	public String deleteSchedule(@RequestParam ("aptId") String aptId,@RequestParam ("patientId") String patientId,@RequestParam ("seriesId") int seriesId){
		 
		Logger logger = Logger.getLogger(DigiHealthCareDeleteSchedulePlanRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		   // CISResults cisResults=CommonCISValidation.editSchedulePlanValidation(request,editSchedulePlan);
		   // if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    // {
            DigiHealthCareDeleteSchedulePlanWebservice deleteSchedulePlanWebservice= new DigiHealthCareDeleteSchedulePlanWebservice();
		    	CISResults cisResults  = deleteSchedulePlanWebservice.deleteSchedule(aptId,patientId,seriesId);
		       logger.info(" DigitalHealthCare: delete staff member rest service :"+cisResults);
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
