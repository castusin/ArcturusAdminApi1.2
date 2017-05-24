
package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import com.cis.CISResults;


public class DigiHealthCareCreateScheduleWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareCreateScheduleWebservice.class);
	
	DigiHealthCareCreateScheduleBL createScheduleBL=new DigiHealthCareCreateScheduleBL();
	public CISResults createSchedule( DigiHealthCareCreateScheduleModel createSchedule) throws Throwable{
	CISResults cisResult = createScheduleBL.createSchedule(createSchedule);
	logger.info(" DigitalHealthCare:create schedule WebService :"+cisResult);
    return cisResult;
	}
}