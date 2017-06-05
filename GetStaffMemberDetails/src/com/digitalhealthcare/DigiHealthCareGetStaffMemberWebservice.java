
package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigiHealthCareGetStaffMemberWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareGetStaffMemberWebservice.class);
	
	DigiHealthCareGetStaffMemberBL getStaffMemberBL=new DigiHealthCareGetStaffMemberBL();

		public CISResults getStaffList(DigiHealthCareSaveStaffMemberModel viewStaffmember) {
		 CISResults cisResult = getStaffMemberBL.getStaffList(viewStaffmember);
		 logger.info(" DigitalHealthCare:get staff members WebService :"+cisResult);
		return cisResult;
	}
}