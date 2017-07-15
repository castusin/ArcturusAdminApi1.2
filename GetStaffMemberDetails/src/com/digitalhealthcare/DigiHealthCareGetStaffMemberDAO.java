
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


	public CISResults getStaffList(int staffId, String getfName, String getlName,
			String serviceType, String emailId, String phone1, String phone2,
			String address1, String address2, String city, String country,
			String state, int zipcode, String activeInd, Date createDate) {
		Logger logger = Logger.getLogger(DigiHealthCareAdminViewPlansDAO.class);
		DigiHealthCareSaveStaffMemberModel getStafflist=new DigiHealthCareSaveStaffMemberModel();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 List result=getJdbcTemplate().query(DigiHealthCareGetStaffMemberQuery.SQL_GETSTAFFLIST,new DigiHealthCareGetStaffMemberMapper());
			 String serviceEndTime=time.getTimeZone();
			 long results=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("get staff list query time:: " +results);
			cisResults.setResultObject(result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get data");
		}

   		return cisResults;  
	}


}