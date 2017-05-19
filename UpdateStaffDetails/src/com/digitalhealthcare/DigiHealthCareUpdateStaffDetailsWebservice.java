
package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import com.cis.CISResults;


public class DigiHealthCareUpdateStaffDetailsWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareUpdateStaffDetailsWebservice.class);
	
	DigiHealthCareUpdateStaffDetailsBL updateStaffDetailsBL=new DigiHealthCareUpdateStaffDetailsBL();

		public CISResults updateStaffDetails( DigiHealthCareSaveStaffMemberModel updateStaff){
		 CISResults cisResult = updateStaffDetailsBL.updateStaffDetails(updateStaff);
		 logger.info(" DigitalHealthCare:edit schedule plan WebService :"+cisResult);
		return cisResult;
	}
}