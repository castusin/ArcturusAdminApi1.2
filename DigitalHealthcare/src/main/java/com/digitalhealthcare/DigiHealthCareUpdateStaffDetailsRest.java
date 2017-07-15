
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
 * Rest Controller : update staff details Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareUpdateStaffDetailsRest {
	
	
	@RequestMapping(value="/updateStaffDetails",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String updateStaffDetails(HttpServletRequest request,@RequestBody DigiHealthCareSaveStaffMemberModel updateStaff){
		 
		Logger logger = Logger.getLogger(DigiHealthCareUpdateStaffDetailsRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.updateStaffDetailsValidation(request,updateStaff);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
            	DigiHealthCareUpdateStaffDetailsWebservice updateStaffDetailsWebservice= new DigiHealthCareUpdateStaffDetailsWebservice();
		    	 cisResults  = updateStaffDetailsWebservice.updateStaffDetails(updateStaff);
		       logger.info(" DigitalHealthCare: update staff details rest service :"+cisResults);
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
