package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cis.CISResults;


public class DigiHealthCareDeleteSchedulePlanWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareDeleteSchedulePlanWebservice.class);
	DigiHealthCareDeleteSchedulePlanBL deleteSchedulePlanBL=new DigiHealthCareDeleteSchedulePlanBL();
	
		public CISResults deleteSchedule(int aptId){
		 CISResults cisResult = deleteSchedulePlanBL.deleteSchedule(aptId);
		 logger.info(" DigitalHealthCare: delete schedule plan WebService :"+cisResult);
		return cisResult;
	}
}