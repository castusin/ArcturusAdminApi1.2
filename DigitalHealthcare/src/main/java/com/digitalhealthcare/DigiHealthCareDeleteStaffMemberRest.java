
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
 * Rest Controller : Delete staff member plan Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareDeleteStaffMemberRest {
	
	@RequestMapping(value="/deleteStaffMember",method=RequestMethod.GET,produces={"application/json"})
	
	public String deleteStaffMember(@RequestParam ("staffId") int staffId,HttpServletRequest request){
		 
		Logger logger = Logger.getLogger(DigiHealthCareDeleteStaffMemberRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.deleteStaffMemberValidation(staffId,request);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
		    	DigiHealthCareDeleteStaffMemberWebservice deleteStaffMemberWebservice= new DigiHealthCareDeleteStaffMemberWebservice();
		    	cisResults  = deleteStaffMemberWebservice.deleteStaffMember(staffId);
		        logger.info(" DigitalHealthCare: delete staff member rest service :"+cisResults);
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
