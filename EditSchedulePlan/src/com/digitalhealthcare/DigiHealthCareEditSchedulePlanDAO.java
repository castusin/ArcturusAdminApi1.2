
package com.digitalhealthcare;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigiHealthCareEditSchedulePlanDAO extends JdbcDaoSupport {

	public CISResults editSchedulePlan(String patientId, int aptPersonId,
			String startTime, String endTime, int allDay, String aptWith) {
		
		CISResults cisResults=new CISResults();
	
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanDAO.class);
		Object[] inputs = new Object[]{aptPersonId,startTime,endTime,allDay,aptWith,patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigiHealthCareEditSchedulePlanQuery.SQL_EDITRESCHEDULEPLAN,inputs);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("edit scheludle plan query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}


}
