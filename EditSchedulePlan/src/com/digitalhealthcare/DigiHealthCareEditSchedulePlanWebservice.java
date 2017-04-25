
package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigiHealthCareEditSchedulePlanWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareAdminViewPlansWebservice.class);
	
	DigiHealthCareEditSchedulePlanBL editSchedulePlanBL=new DigiHealthCareEditSchedulePlanBL();

		public CISResults editSchedulePlan(DigiHealthCareEditSchedulePlanModel editSchedulePlan){
		 CISResults cisResult = editSchedulePlanBL.editSchedulePlan(editSchedulePlan);
		 logger.info(" DigitalHealthCare:edit schedule plan WebService :"+cisResult);
		return cisResult;
	}
}