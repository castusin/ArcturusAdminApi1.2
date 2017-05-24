
package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cis.CISResults;


public class DigiHealthCareDeleteStaffMemberWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareDeleteStaffMemberWebservice.class);
	DigiHealthCareDeleteStaffMemberBL deleteStaffMemberBL=new DigiHealthCareDeleteStaffMemberBL();
		public CISResults deleteStaffMember(int staffId){
		 CISResults cisResult = deleteStaffMemberBL.deleteStaffMember(staffId);
		 logger.info(" DigitalHealthCare: delete schedule plan WebService :"+cisResult);
		return cisResult;
	}
}