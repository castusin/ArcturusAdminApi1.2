
package com.digitalhealthcare;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareGetStaffMemberDAO extends JdbcDaoSupport {


	public CISResults getStaffList(String staffId) {
		Logger logger = Logger.getLogger(DigiHealthCareAdminViewPlansDAO.class);
		DigiHealthCareSaveStaffMemberModel getStafflist=new DigiHealthCareSaveStaffMemberModel();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		//accountType="P";
		Object[] inputs = new Object[]{staffId};
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 List result=getJdbcTemplate().query(DigiHealthCareGetStaffMemberQuery.SQL_GETSTAFFLIST,inputs,new DigiHealthCareGetStaffMemberMapper());
			 String serviceEndTime=time.getTimeZone();
			 long results=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("admin view plans query time:: " +results);
			cisResults.setResultObject(result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}

   		return cisResults;  
	}


}