package com.digitalhealthcare;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigiHealthCareCreateScheduleDAO extends JdbcDaoSupport {

	public CISResults createSchedule(String aptId, int aptSeriesId,
			int staffId, String patientId, String startDateTime, String endDateTime,int totalDay,String type, String aptWith, String createDate,String seriesStatus
			
			 ) {
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
			 logger.info("create schedule query time:: " +result);
			
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
			 DigiHealthCareSaveStaffMemberModel res=(DigiHealthCareSaveStaffMemberModel)getJdbcTemplate().queryForObject(DigiHealthCareCreateScheduleQuery.SQL_GETSTAFFEMAIL,inputs,new DigiHealthCareSaveStaffMemberMapper());
			 //String emailId=getstaffEmail.getEmailId();
			 cisResults.setResultObject(res);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("staff email query time:: " +result);
			
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
			 DigiHealthCarePatientModel res=(DigiHealthCarePatientModel)getJdbcTemplate().queryForObject(DigiHealthCareCreateScheduleQuery.SQL_GETPATIENTEMAIL,inputs,new DigiHealthCarePatientMapper());
		   	 //String emailId=getPatientEmail.getEmailId();
			 cisResults.setResultObject(res);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("patient email query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}

	public CISResults createSchedules(String aptId, int aptSeriesId, int staffid,
			String patientId, String startDateTime, String endDatetime,
			int totalDay, String type, String appwith, String createDate,
			String seriesStatus, int recurrenceTime) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareCreateScheduleDAO.class);
		//Object[] inputs = new Object[]{aptPersonId,startTime,endTime,allDay,aptWith,patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareCreateScheduleQuery.SQL_CREATESCHEDULES,aptId,aptSeriesId,staffid,patientId,startDateTime,endDatetime,type,appwith,createDate,seriesStatus,recurrenceTime);
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

	/*public CISResults createSchedule2(String aptId, int aptSeriesId,
			int staffid, String patientId, String startdatetime,
			String endDatetime, int totalDay, String type, String appwith,
			String createDate, String seriesStatus, int recurrenceTime) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareCreateScheduleDAO.class);
		//Object[] inputs = new Object[]{aptPersonId,startTime,endTime,allDay,aptWith,patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareCreateScheduleQuery.SQL_CREATESCHEDULE,aptId,aptSeriesId,staffid,patientId,startdatetime,endDatetime,totalDay,type,appwith,createDate,seriesStatus);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("create schedule query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}*/
}
