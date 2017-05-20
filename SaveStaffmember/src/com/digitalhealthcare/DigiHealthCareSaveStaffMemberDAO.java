package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigiHealthCareSaveStaffMemberDAO extends JdbcDaoSupport {

	public CISResults saveStaffMember(int staffId, String getfName,
			String getlName, String serviceType, String emailId, String phone1,
			String phone2, String address1, String address2, String city,
			String country, String state, int zipcode, String activeInd,
			String createDate) {
		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareSaveStaffMemberDAO.class);
		//Object[] inputs = new Object[]{aptPersonId,startTime,endTime,allDay,aptWith,patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareSaveStaffMemberQuery.SQL_SAVESTAFFMEMBER,staffId,getfName,getlName,serviceType,emailId,phone1,phone2,address1,address2,city,country,state,zipcode,activeInd,createDate);
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

