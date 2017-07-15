
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


public class DigiHealthCareAdminViewPlansDAO extends JdbcDaoSupport {


	
	public List<DigiHealthCareAdminViewPlansModel> adminViewplans(
			String patientId) {
		
		Logger logger = Logger.getLogger(DigiHealthCareAdminViewPlansDAO.class);
		DigiHealthCareAdminViewPlansModel adminViewPlans=new DigiHealthCareAdminViewPlansModel();
		List<DigiHealthCareAdminViewPlansModel> adminViewplans=null;
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		Object[] inputs = new Object[]{patientId};
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 adminViewplans = getJdbcTemplate().query(DigiHealthCareAdminViewPlansQuery.SQL_ADMINVIEWPLANS,inputs,new DigiHealthCareAdminViewPlansMapper());
			 String serviceEndTime=time.getTimeZone();
			 long results=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("admin view plans query time:: " +results);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get data");
		}

   		return adminViewplans;  
	}


}