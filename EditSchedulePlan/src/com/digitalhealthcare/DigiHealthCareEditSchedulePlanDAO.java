
package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigiHealthCareEditSchedulePlanDAO extends JdbcDaoSupport {

	
	public CISResults createSchedule(String aptId, int aptSeriesId, int staffid,
			String patientId, String startDateTime, String endDatetime,
			int totalDay, String type, String appwith, String createDate,
			String seriesStatus) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareCreateScheduleDAO.class);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareEditSchedulePlanQuery.SQL_CREATESCHEDULE,aptId,aptSeriesId,staffid,patientId,startDateTime,endDatetime,totalDay,type,appwith,createDate,seriesStatus);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("create schedule query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}


	public CISResults deleteSchedulePlan(int aptSeriesId) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareDeleteStaffMemberDAO.class);
		Object[] inputs = new Object[]{aptSeriesId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareEditSchedulePlanQuery.SQL_DELETESTAFFMEMBER,inputs);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("delete staff member query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}


	public CISResults editSchedulePlan(int staffid, String startTime,
			String endTime, int allDay, String appwith, String type,String seriesStatus,
			String patientId, String aptId) {
		
		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanDAO.class);
		Object[] inputs = new Object[]{staffid,startTime,endTime,allDay,appwith,type,seriesStatus,patientId,aptId};
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
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}


	public CISResults getStaffEmail(int staffid) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		DigiHealthCareSaveStaffMemberModel getstaffEmail=new DigiHealthCareSaveStaffMemberModel();
		Object[] inputs = new Object[]{staffid};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 DigiHealthCareSaveStaffMemberModel res=(DigiHealthCareSaveStaffMemberModel)getJdbcTemplate().queryForObject(DigiHealthCareCreateScheduleQuery.SQL_GETSTAFFEMAIL,inputs,new DigiHealthCareSaveStaffMemberMapper());
			 cisResults.setResultObject(res);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("staff email query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
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
		     cisResults.setResultObject(res);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("patient email query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}


	public CISResults messageText(String messageId, String aptId, String patientId,String phoneNumber, String patientEmail,  String subject, String createDate, String messageType,String messageCategory) {
			// TODO Auto-generated method stub

		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanDAO.class);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String userId="";
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareCreateScheduleQuery.SQL_MESSAGETEXT,messageId,aptId,patientId,userId,phoneNumber,patientEmail,subject,createDate,messageType,messageCategory);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("message query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}
}
