
package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigiHealthCareAdminViewPlansWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareAdminViewPlansWebservice.class);
	
	DigiHealthCareAdminViewPlansBL adminViewPlansBL=new DigiHealthCareAdminViewPlansBL();

		public CISResults adminViewPlans(String patientId) {
		 CISResults cisResult = adminViewPlansBL.adminViewPlans(patientId);
		 logger.info(" DigitalHealthCare:Admin view plans WebService :"+cisResult);
		return cisResult;
	}
}