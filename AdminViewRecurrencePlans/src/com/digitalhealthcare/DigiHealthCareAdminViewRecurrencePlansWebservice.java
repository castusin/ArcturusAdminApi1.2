package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigiHealthCareAdminViewRecurrencePlansWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareAdminViewRecurrencePlansWebservice.class);
	
	DigiHealthCareAdminViewRecurrencePlansBL adminViewRecPlansBL=new DigiHealthCareAdminViewRecurrencePlansBL();

		public CISResults adminViewPlans(String patientId) {
		 CISResults cisResult = adminViewRecPlansBL.adminViewPlans(patientId);
		 logger.info(" DigitalHealthCare:Admin view recursive plans WebService :"+cisResult);
		return cisResult;
	}
}