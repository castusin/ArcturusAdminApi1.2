
package com.digitalhealthcare;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : Edit schedule plan Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareEditSchedulePlanRest {
	
	
	@RequestMapping(value="/editSchedulePlan",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String editSchedulePlan(HttpServletRequest request,@RequestBody DigiHealthCareEditSchedulePlanModel editSchedulePlan){
		 
		Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.editSchedulePlanValidation(request,editSchedulePlan);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigiHealthCareEditSchedulePlanWebservice editSchedulePlanWebservice= new DigiHealthCareEditSchedulePlanWebservice();
		       cisResults  = editSchedulePlanWebservice.editSchedulePlan(editSchedulePlan);
		       logger.info(" DigitalHealthCare: edit schedule plan rest service :"+cisResults);
		     }
		       return returnJsonData(cisResults);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
}
