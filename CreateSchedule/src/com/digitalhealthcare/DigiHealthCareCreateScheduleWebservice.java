
package com.digitalhealthcare;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import com.cis.CISResults;


public class DigiHealthCareCreateScheduleWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareCreateScheduleWebservice.class);
	
	DigiHealthCareCreateScheduleBL createScheduleBL=new DigiHealthCareCreateScheduleBL();

<<<<<<< HEAD
	public CISResults createSchedule( DigiHealthCareCreateScheduleModel createSchedule) throws ParseException{
=======
	public CISResults createSchedule( DigiHealthCareCreateScheduleModel createSchedule) throws Throwable{
>>>>>>> origin/master
	CISResults cisResult = createScheduleBL.createSchedule(createSchedule);
	logger.info(" DigitalHealthCare:create schedule WebService :"+cisResult);
   
	
	
	/*  
	 // convert stringt to date
	 String startDateString = "Sat Apr 22 2017 12:27:00";
	 DateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
	 Date date = (Date) sdf.parse(startDateString);
	 
	 System.out.println(sdf.format(date));
	 
	 
	 
	 
	 // convert String to Calander
	 Calendar cal = Calendar.getInstance();
	 SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
	 cal.setTime(sdf1.parse("Sat Apr 22 2017 12:27:00"));// all done
	 
	 System.out.println(sdf1.getCalendar());
	 
	 
	 
	 
		SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
		int minutesToAdd = 5;
		System.out.println("Initial Time: " + df.format(date.getTime()));
		Calendar startTime =sdf1.getCalendar();
		startTime.add(Calendar.MINUTE, minutesToAdd);
		String dateStr = df.format(startTime.getTime());
		System.out.println("After Time : " + dateStr + "\n");*/
	 
	
	
	
	
	
	
	
	
	return cisResult;
	}
}