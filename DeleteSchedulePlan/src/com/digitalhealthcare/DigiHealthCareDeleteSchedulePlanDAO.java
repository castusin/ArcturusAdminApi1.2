package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigiHealthCareDeleteSchedulePlanDAO extends JdbcDaoSupport {

	public CISResults deleteSchedule(String aptId, String patientId) {
		
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareDeleteSchedulePlanDAO.class);
		Object[] inputs = new Object[]{aptId,patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareDeleteSchedulePlanQuery.SQL_DELETESCHEDULE,inputs);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("delete schedule query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}

	public CISResults deleteRecurSchedule( String patientId, int seriesId) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareDeleteSchedulePlanDAO.class);
		Object[] inputs = new Object[]{patientId,seriesId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareDeleteSchedulePlanQuery.SQL_DELETERECURSCHEDULE,inputs);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("delete schedule query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}

	public CISResults deleteRecurSchedules(String patientId, int seriesId) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareDeleteSchedulePlanDAO.class);
		Object[] inputs = new Object[]{patientId,seriesId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareDeleteSchedulePlanQuery.SQL_DELETERECURSCHEDULES,inputs);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("delete schedule query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}
}
