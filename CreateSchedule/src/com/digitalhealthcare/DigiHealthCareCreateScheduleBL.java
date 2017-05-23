package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;




import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareCreateScheduleBL {

	 ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	 DigiHealthCareCreateScheduleDAO createScheduleDAO=(DigiHealthCareCreateScheduleDAO)ctx.getBean("createSchedule");
	
	 private static final AtomicInteger count = new AtomicInteger(1001);
	
	 private static final AtomicInteger counts = new AtomicInteger(11101);

	 public CISResults createSchedule( DigiHealthCareCreateScheduleModel createSchedule) throws Throwable{

		
		final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
		// Capture service Start time
		final long ONE_HOUR_IN_MS = 3600000;
		CISResults cisResults=new CISResults();
		 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 int aptId = count.incrementAndGet();
		 int aptSeriesId = counts.incrementAndGet();
		 Calendar currentdate = Calendar.getInstance();
	     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	     formatter.setTimeZone(obj);
	     String createDate=time.getTimeZone();
	     int recurrenceTime=createSchedule.getRecurenceTime();
		 String seriesStatus=CISConstants.seriesStatus2;
		 int staffId=createSchedule.getStaffId();
		 int totalDay=0;
		 String startDateTime=createSchedule.getStartDateTime();

		 
		 
		 int n=4;
		 String startDateTime1="Tue May 23 2017 10:10:00";
		 String endDateTime1="Tue May 23 2017 11:30:00";
		 String endDateTime = "";
		
		 // Logic to split Enddate time 
		 String[] allStrings = endDateTime1.split("\\s");
	        for (int i = 4; i < allStrings.length; i++){
	        	endDateTime = endDateTime + " " + allStrings[i];
	       // System.out.println(endDateTime);
	    }
		 
	        // Logic to Get recursive next week datetime
		 
		   for (int i=1; i<=n; i++) {
                  SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
                   Date d1 = sdf.parse(startDateTime1);
                    Calendar c = Calendar.getInstance();
                   c.setTime(d1); // Now use today date.
                    c.add(Calendar.DATE, 7); // Adding 5 days
                    String output = sdf.format(c.getTime());
                    startDateTime1=output;

                    // Concat Enddate with end time Lodic
                      String[] allStrings1 = startDateTime1.split("\\s");
                       StringBuilder strBuilder = new StringBuilder();

                  for (int k = 0; k < allStrings1.length-1; k++) {
                     strBuilder.append(allStrings1[k]);
                      strBuilder.append(" ");
                        }
                   String endDatetime= strBuilder.toString();
                  endDatetime=endDatetime+endDateTime;
                System.out.println(startDateTime1);
                  System.out.println(endDatetime);





// DAO Call



		 }
		 
		 
		 
		 
		 
		 
		
//	        String oldString = "Sat May 20 2017 10:10:00";
//	        String[] allStrings = oldString.split("\\s");
//	        String newString = "";
//	        for (int i = 4; i < allStrings.length; i++){
//	            newString = newString + " " + allStrings[i];
//	        System.out.println(newString);
//	    }
//	        
//	        
		 
	        
//	        String oldString1 = "Mon May 20 2017 12:10:00";
//	        String[] allStrings1 = oldString1.split("\\s");
//	        StringBuilder strBuilder = new StringBuilder();
//	        for (int i = 0; i < allStrings1.length-1; i++) {
//	           strBuilder.append(allStrings1[i]);
//	           strBuilder.append(" ");
//	        }
//	        
//	        String newString1 = strBuilder.toString();
//	        
//	        System.out.println(newString1+newString );
//	        
		 
		 
		 
		 
		 // String startDateTime=createSchedule.getStartDateTime();
		 
		 
//		 SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
//		 Date d1 = df.parse("Sat May 20 2017 10:10:00");
//		 Calendar cal = Calendar.getInstance();
//	     cal.setTime(cal.setTime(new Date()));
//		 cal.add(Calendar.MINUTE,30);
//		 String newTime = df.format(cal.getTime());
//		 
		 
		 
		 
		 // convert stringt to date
	   //  String startDateString = "Sat Apr 22 2017 12:27:00";
	     //DateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
	    // Date date = (Date) sdf.parse(startDateString);
	     
	 //    System.out.println(sdf.format(date));
	     
	     
	     
	     
	     // convert String to Calander
	    // Calendar cal1 = Calendar.getInstance();
	   //  SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
	    // cal1.setTime(sdf1.parse("Sat Apr 22 2017 12:27:00"));// all done
	     
	   //  System.out.println(sdf1.getCalendar());
	     
	     
	     // calander logic
	     
	     
	    // Calendar calendar = Calendar.getInstance();
	    // cal.setTime(sdf1.parse("Sat Apr 22 2017 12:27:00"));
	 //    cal.setTime(sdf1.parse("Sat Apr 22 2017 12:27:00"));
	  //   System.out.println(sdf1.getCalendar());
	   //  calendar.add(Calendar.MINUTE, 5);
	  //   System.out.println(calendar.getTime());
	     
	     
	     

//			SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
//			int minutesToAdd = 5;
//			System.out.println("Initial Time: " + df.format(date.getTime()));
//			Calendar startTime =sdf1.getCalendar();
//			startTime.add(Calendar.MINUTE, minutesToAdd);
//			String dateStr = df1.format(startTime.getTime());
//			System.out.println("After Time : " + dateStr + "\n");
//		 

		 
		 
		 
		 
		 
	 
		// Capture Service End time
		// String serviceEndTime=time.getTimeZone();
		//  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		//  logger.info("Database time for create schedule service:: " +result );
		  
		return cisResults;
	}


}