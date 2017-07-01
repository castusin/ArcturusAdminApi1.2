
package com.digitalhealthcare;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareAdminViewPlansBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareAdminViewPlansDAO adminViewPlansDAO=(DigiHealthCareAdminViewPlansDAO)ctx.getBean("adminViewPlans");

	@SuppressWarnings("null")
	public CISResults adminViewPlans(String patientId){
		
		final Logger logger = Logger.getLogger(DigiHealthCareAdminViewPlansBL.class);
		// Capture service Start time
		
		TimeCheck time=new TimeCheck();
		
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 CISResults cisResult = new CISResults();
		//CISResults cisResult = adminViewPlansDAO.adminViewPlans(patientId);
		List<DigiHealthCareAdminViewPlansModel> adminViewPlans = adminViewPlansDAO.adminDigitalViewPlans(patientId);
		
		
		ArrayList<Object> appointments = new ArrayList<Object>();
		 
		for (int i = 0; i < adminViewPlans.size(); i++) {
			
		DigiHealthCareAdminViewPlansModel digiAdminViewPlanModel = new DigiHealthCareAdminViewPlansModel();
		Color color = new Color();
			
			String serviceType= adminViewPlans.get(i).title;
			String aptId=adminViewPlans.get(i).aptId;
			int aptPersonId=adminViewPlans.get(i).aptPersonId;
			String aptWith=adminViewPlans.get(i).aptWith;
			Date createDate=adminViewPlans.get(i).createDate;
			String startsAt=adminViewPlans.get(i).startsAt;
			String endsAt=adminViewPlans.get(i).endsAt;
			int aptseriesId=adminViewPlans.get(i).aptseriesId;
			String patiendId=adminViewPlans.get(i).patiendId;
			String seriesStatus=adminViewPlans.get(i).seriesStatus;
			boolean val=adminViewPlans.get(i).val;
			
			
			
			 digiAdminViewPlanModel.setTitle(serviceType);
			 digiAdminViewPlanModel.setAptId(aptId);
			 digiAdminViewPlanModel.setAptPersonId(aptPersonId);
			 digiAdminViewPlanModel.setAptWith(aptWith);
			 digiAdminViewPlanModel.setCreateDate(createDate);
			 digiAdminViewPlanModel.setStartsAt(startsAt);
			 digiAdminViewPlanModel.setEndsAt(endsAt);
			 digiAdminViewPlanModel.setAptseriesId(aptseriesId);
			 digiAdminViewPlanModel.setPatiendId(patiendId);
			 digiAdminViewPlanModel.setSeriesStatus(seriesStatus);
			 digiAdminViewPlanModel.setVal(val);
			 
			
			
			
			 
			 
			 if(serviceType.equalsIgnoreCase("Chaplain"))
		      {
				 color.setPrimary("#0C61AB");
		    	  color.setSecondary("#0C61AB");
		    	 digiAdminViewPlanModel.setColor(color);
		      }
			
			 if(serviceType.equalsIgnoreCase("Social Worker"))
		      {
				
		    	  color.setPrimary("#8B1B32");
		    	  color.setSecondary("#8B1B32");
		    	  digiAdminViewPlanModel.setColor(color);
		      }
			 
			 if(serviceType.equalsIgnoreCase("CNA"))
		      {
		    	  color.setPrimary("#BD21BF");
		    	  color.setSecondary("#BD21BF");
		    	 digiAdminViewPlanModel.setColor(color);
		      }
			 
			 if(serviceType.equalsIgnoreCase("Nurse"))
		      {
		    	  color.setPrimary("#17BA2A");
		    	  color.setSecondary("#17BA2A");
		    	 digiAdminViewPlanModel.setColor(color);
		      }
			 if(serviceType.equalsIgnoreCase("Doctor"))
		       {
		    	  color.setPrimary("#F60529");
		    	  color.setSecondary("#F60529");
		    	  digiAdminViewPlanModel.setColor(color);
		    	 
		       }
		      
			
			 appointments.add(digiAdminViewPlanModel);
			
		}
		
		
		 

		 cisResult.setResultObject(appointments);
		
		
		
		
		
		
		
		logger.info("DigitalHealthCare:admin view plansBL  service" +cisResult );
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for admin view plans service:: " +result );
		  
		return cisResult;
	}


}