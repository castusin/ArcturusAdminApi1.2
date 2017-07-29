
package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISConstants;
import com.cis.CISResults;


public class DigiHealthCareCreateScheduleWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareCreateScheduleWebservice.class);
	
	DigiHealthCareCreateScheduleBL createScheduleBL=new DigiHealthCareCreateScheduleBL();
	public CISResults createSchedule( DigiHealthCareCreateScheduleModel createSchedule) throws Throwable{
		
		CISResults cisResult=new CISResults();
		
		if(createSchedule.scheduleType.equalsIgnoreCase(CISConstants.WEEK)){
			cisResult = createScheduleBL.createSchedule(createSchedule);
		}else if(createSchedule.scheduleType.equalsIgnoreCase(CISConstants.MONTH)){
			cisResult = createScheduleBL.createMonthlySchedule(createSchedule);
		}else if(createSchedule.scheduleType.equalsIgnoreCase(CISConstants.BYWEEK)){
			cisResult = createScheduleBL.createByWeeksSchedule(createSchedule);
		}
		logger.info(" DigitalHealthCare:create schedule WebService :"+cisResult);
		return cisResult;
	}
}