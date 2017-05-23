package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigiHealthCareCreateScheduleDAO extends JdbcDaoSupport {

	public CISResults createSchedule(int aptId, int aptSeriesId,
			int staffId, String patientId, String startDateTime, String endDateTime,int totalDay,String type, String aptWith, String createDate,String seriesStatus,
			
			 int recurenceTime ) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareCreateScheduleDAO.class);
		//Object[] inputs = new Object[]{aptPersonId,startTime,endTime,allDay,aptWith,patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareCreateScheduleQuery.SQL_CREATESCHEDULE,aptId,aptSeriesId,staffId,patientId,startDateTime,endDateTime,totalDay,type,aptWith,createDate,seriesStatus);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("save staff member query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}

	public CISResults getStaffEmail(int staffId) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		DigiHealthCareSaveStaffMemberModel getstaffEmail=new DigiHealthCareSaveStaffMemberModel();
		Object[] inputs = new Object[]{staffId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getstaffEmail=(DigiHealthCareSaveStaffMemberModel)getJdbcTemplate().queryForObject(DigiHealthCareCreateScheduleQuery.SQL_GETSTAFFEMAIL,inputs,new DigiHealthCareSaveStaffMemberMapper());
			 String emailId=getstaffEmail.getEmailId();
			 cisResults.setResultObject(getstaffEmail);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("save staff member query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}

	public CISResults getPatientEmail(String patientId) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		DigiHealthCarePatientModel getPatientEmail=new DigiHealthCarePatientModel();
		Object[] inputs = new Object[]{patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getPatientEmail=(DigiHealthCarePatientModel)getJdbcTemplate().queryForObject(DigiHealthCareCreateScheduleQuery.SQL_GETPATIENTEMAIL,inputs,new DigiHealthCarePatientMapper());
		   	 String emailId=getPatientEmail.getEmailId();
			 cisResults.setResultObject(getPatientEmail);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("save staff member query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}


}
