
package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import com.cis.CISResults;


public class DigiHealthCareSaveStaffMemberWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareSaveStaffMemberWebservice.class);
	
	DigiHealthCareSaveStaffMemberBL saveStaffMemberBL=new DigiHealthCareSaveStaffMemberBL();

	public CISResults saveStaffMember( DigiHealthCareSaveStaffMemberModel saveStaffmember){
	CISResults cisResult = saveStaffMemberBL.saveStaffMember(saveStaffmember);
	logger.info(" DigitalHealthCare:save staff member WebService :"+cisResult);
    return cisResult;
	}
}