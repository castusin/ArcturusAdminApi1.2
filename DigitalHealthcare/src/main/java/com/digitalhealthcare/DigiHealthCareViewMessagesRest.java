package com.digitalhealthcare;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : view messages Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareViewMessagesRest {
	
	@RequestMapping(value="/viewMessages",method=RequestMethod.GET,produces={"application/json"})

	 public String viewMessages(HttpServletRequest request,ViewMessagesModel viewMessages){
		    Logger logger = Logger.getLogger(DigiHealthCareViewMessagesRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		   // CISResults cisResults=CommonCISValidation.viewMessagesValidation(request,viewMessages);
		   // if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    // {
		    	ViewMessagesWebservice viewMessagesWebservice= new ViewMessagesWebservice();
		    	CISResults cisResults  = viewMessagesWebservice.viewMessages(viewMessages);
		       logger.info(" DigitalHealthCare: view message service :"+cisResults);
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
