package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.SMSCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareCreateScheduleBL {

     ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
     DigiHealthCareCreateScheduleDAO createScheduleDAO=(DigiHealthCareCreateScheduleDAO)ctx.getBean("createSchedule");
    
     private static final AtomicInteger counts = new AtomicInteger(11000001);
     
     public CISResults createSchedule( DigiHealthCareCreateScheduleModel createSchedule) throws Throwable{
        
        final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
        
        EmailCommunication sendMail=new EmailCommunication();
        SMSCommunication smsCommunicaiton=new SMSCommunication();
        
        String directorMail=CISConstants.DIRECTOREMAILID;// for testing purpose
        // Capture service Start time
        
         CISResults cisResults=new CISResults();
         Appointments aptList=new Appointments();
         
         TimeCheck time=new TimeCheck();
         testServiceTime seriveTimeCheck=new testServiceTime();
         String serviceStartTime=time.getTimeZone();
         
         // generating aptid
         
         String sessionId = UUID.randomUUID().toString();
         String aptId=DigestUtils.sha1Hex(sessionId);
         String upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
         aptId=upToNCharacters;
          
          //messageID
          
          sessionId = UUID.randomUUID().toString();
          String messageId=DigestUtils.sha1Hex(sessionId);
          upToNCharacters = messageId.substring(0, Math.min(messageId.length(), 6));
          messageId=upToNCharacters;
          int aptSeriesId = counts.incrementAndGet();
          Calendar currentdate = Calendar.getInstance();
          DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
          TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
          formatter.setTimeZone(obj);
          String createDate=time.getTimeZone();
          int recurrenceTime=createSchedule.getRecurenceTime();
          String seriesStatus=CISConstants.seriesStatus2;
          int totalDay=CISConstants.totalDay;
          String patientId=createSchedule.getPatientId();
          int aptListSize=createSchedule.getAptList().size();
        
          String startTime="";
          String endTime="";
          String appwith="";
          int staffid=0;
          String phoneNumber="";
          
          String type= createSchedule.getType();
         
        // If startTimeListSize equal to > 1 need to series id=Y or series id=N no need else blcok
          if(recurrenceTime>0){
        	  
        	  if(aptListSize>=1){
             
        		  for (int i = 0; i< aptListSize; i++)
        		  {
        			  startTime= createSchedule.getAptList().get(i).startDateTime;
        			  endTime =  createSchedule.getAptList().get(i).endDateTime;
        			  staffid =  createSchedule.getAptList().get(i).staffId;
        			  appwith =  createSchedule.getAptList().get(i).aptWith;
            
        			  	// Now start logic
        			  seriesStatus=CISConstants.seriesStatus1;
        			  String startDateTime=startTime;
        			  String enddateTime=endTime;
        			  String endDateTime = "";
        			  String startdateTime = "";
           
             
        			  // Logic to split Enddate time 
        			  String[] allStrings = enddateTime.split("\\s");
        			  for (int j = 4; j < allStrings.length; j++){
        				  endDateTime = endDateTime + " " + allStrings[j];
               
        			  }
        			  // Logic to split Startdate time 
        			  String[] allStrings2 = startDateTime.split("\\s");
        			  for (int p = 4; p < allStrings2.length; p++){
        				  startdateTime = startdateTime + " " + allStrings2[p];
               
        			  }
             
        			  // Logic to Get recursive next week datetime
              
        			  for (int k=1; k<=recurrenceTime; k++) {
        				  sessionId = UUID.randomUUID().toString();
        				  aptId=DigestUtils.sha1Hex(sessionId);
        				  upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
        				  aptId=upToNCharacters;
              
        				  SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
        				  Date d1 = sdf.parse(startDateTime);
        				  Calendar c = Calendar.getInstance();
        				  c.setTime(d1); // Now use today date.
        				  if(k==1){
        					  // Concat Enddate with end time Lodic
        					  String[] allStrings1 = startDateTime.split("\\s");
        					  StringBuilder strBuilder = new StringBuilder();

        					  for (int l = 0; l < allStrings1.length-1; l++) {
        						  strBuilder.append(allStrings1[l]);
        						  strBuilder.append(" ");
        					  }
        					  String endDatetime= strBuilder.toString();
        					  endDatetime=endDatetime+endDateTime;
                               
        					  cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDateTime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus);
        					  cisResults = createScheduleDAO.createSchedules(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDateTime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus,recurrenceTime);
                 
                  
                  
        					  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
        					  {
        						  cisResults=createScheduleDAO.getStaffEmail(staffid);
                      
        						  DigiHealthCareSaveStaffMemberModel  staffEmailId=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
        						  String staffEmail=staffEmailId.getEmailId();
                     
        						  DigiHealthCareSaveStaffMemberModel  stafffname=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
        						  String Stfname=stafffname.getfName();
                    
        						  DigiHealthCareSaveStaffMemberModel  stafflname=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
        						  String Stlname=stafflname.getlName();
                      
        						  DigiHealthCareSaveStaffMemberModel  stphone=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
        						  String StaffPhoneNumber=stphone.getPhone1();
                      
        						  cisResults=createScheduleDAO.getPatientEmail(patientId);
                    
        						  DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResults.getResultObject();
        						  String  patientEmail=patientEmailId.getEmailId();
                     
        						  DigiHealthCarePatientModel  firstname=(DigiHealthCarePatientModel)cisResults.getResultObject();
        						  String patientname=firstname.getFirstName();
                    
        						  DigiHealthCarePatientModel  lastName=(DigiHealthCarePatientModel)cisResults.getResultObject();
        						  String  patientlastname=lastName.getLastName();
        						  DigiHealthCarePatientModel  phone=(DigiHealthCarePatientModel)cisResults.getResultObject();
                     
        						  phoneNumber=phone.getPhone();
        						  //phoneNumber="17325800762";
        						  // StaffPhoneNumber="17325800762";
                      
        						  String cc= staffEmail ;
        						  String bcc= CISConstants.ADMINEMAILID ;
                      
        						  String subject= "Your care plan schedule has been created";

        						  String messageType=CISConstants.RECIEVED;     
        						  String dirPhone=CISConstants.DIRPHONE;
        						  String adminPhone=CISConstants.ADMINPHONENUMBER;
        						  String messageCategory=CISConstants.APPOINTMENT_CREATED;
                     
                      
                      
        						  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
        						  {
        							  cisResults=sendMail.sendPatientMail(patientEmail,appwith,startTime,endTime,type,Stfname,Stlname,recurrenceTime,cc,bcc,directorMail,patientname,patientlastname);
                        
        							  cisResults=createScheduleDAO.messageText(messageId,aptId,patientId,phoneNumber,patientEmail,subject,createDate,messageType,messageCategory);
                       
        							  ArrayList<String> phoneNumberList=new ArrayList<String>();
        							  phoneNumberList.add(phoneNumber);
        							  phoneNumberList.add(dirPhone);
        							  phoneNumberList.add(adminPhone);
        							  phoneNumberList.add(StaffPhoneNumber);
                          
        							  Iterator<String> itr=phoneNumberList.iterator();  
        							  while(itr.hasNext()){  
        								  String messageNumber = itr.next(); 
                          
        								  cisResults=smsCommunicaiton.sendRegistrationSMS(patientEmail,appwith,startTime,endTime,type,Stfname,Stlname,recurrenceTime,cc,bcc,directorMail,messageNumber,patientname,patientlastname);
                           
                          }        
                        }
                     
                  }
                  
                                    
         }else{
       
                 c.add(Calendar.DATE, 7);
                 startDateTime=sdf.format(c.getTime());
                 
                 String[] allStrings1 = startDateTime.split("\\s");
                 StringBuilder strBuilder1 = new StringBuilder();

                 for (int s = 0; s < allStrings1.length-1; s++) {
            	 strBuilder1.append(allStrings1[s]);
                 strBuilder1.append(" ");
                 }
                 
                 String startDatetime = strBuilder1.toString();
             	 startDatetime=startDatetime+startdateTime;
             
             
                 // Concat Enddate with end time Lodic
                 String[] allStrings3 = startDateTime.split("\\s");
                 StringBuilder strBuilder3 = new StringBuilder();

                 for (int l = 0; l < allStrings3.length-1; l++) {
                     strBuilder3.append(allStrings3[l]);
                     strBuilder3.append(" ");
               }
                 String endDatetime= strBuilder3.toString();
                 endDatetime=endDatetime+endDateTime;
               // cisResults.setParkDetails(parkDetailslist);   
                 cisResults=createScheduleDAO.getPatientEmail(patientId);
                 
                 DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResults.getResultObject();
                 String  patientEmail=patientEmailId.getEmailId();
                
                 DigiHealthCarePatientModel  firstname=(DigiHealthCarePatientModel)cisResults.getResultObject();
                 String name=firstname.getFirstName();
               
                 DigiHealthCarePatientModel  lastName=(DigiHealthCarePatientModel)cisResults.getResultObject();
                 String  lastname=lastName.getLastName();
                 DigiHealthCarePatientModel  phone=(DigiHealthCarePatientModel)cisResults.getResultObject();
                 String subject= "Your care plan schedule has been created";

                 String messageType=CISConstants.RECIEVED; 
                 String messageCategory=CISConstants.APPOINTMENT_CREATED;
                 cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDatetime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus);
                 cisResults=createScheduleDAO.messageText(messageId,aptId,patientId,phoneNumber,patientEmail,subject,createDate,messageType,messageCategory);
                  
         		}
             }
           }
         }
         }
           
        // Capture Service End time
          String serviceEndTime=time.getTimeZone();
          long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
          logger.info("Database time for create schedule service:: " +result );
         
        return cisResults;
         }

	public CISResults createMonthlySchedule(DigiHealthCareCreateScheduleModel createSchedule) throws Throwable{
		// TODO Auto-generated method stub
		
	        
	        final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
	        
	        EmailCommunication sendMail=new EmailCommunication();
	        SMSCommunication smsCommunicaiton=new SMSCommunication();
	        // Capture service Start time
	        
	         CISResults cisResults=new CISResults();
	         Appointments aptList=new Appointments();
	         
	         TimeCheck time=new TimeCheck();
	         testServiceTime seriveTimeCheck=new testServiceTime();
	         String serviceStartTime=time.getTimeZone();
	         
	         // generating aptid
	         
	         String sessionId = UUID.randomUUID().toString();
	         String aptId=DigestUtils.sha1Hex(sessionId);
	         String upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
	         aptId=upToNCharacters;
	          
	          //messageID
	          
	          sessionId = UUID.randomUUID().toString();
	          String messageId=DigestUtils.sha1Hex(sessionId);
	          upToNCharacters = messageId.substring(0, Math.min(messageId.length(), 6));
	          messageId=upToNCharacters;
	          int aptSeriesId = counts.incrementAndGet();
	          Calendar currentdate = Calendar.getInstance();
	          DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	          TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	          formatter.setTimeZone(obj);
	          String createDate=time.getTimeZone();
	          int recurrenceTime=createSchedule.getRecurenceTime();
	          String seriesStatus=CISConstants.seriesStatus2;
	          int totalDay=CISConstants.totalDay;
	          String patientId=createSchedule.getPatientId();
	          int aptListSize=createSchedule.getAptList().size();
	        
	          String startTime="";
	          String endTime="";
	          String appwith="";
	          int staffid=0;
	          String phoneNumber="";
	          String type= createSchedule.getType();
	         
	        // If startTimeListSize equal to > 1 need to series id=Y or series id=N no need else blcok
	          if(recurrenceTime>0){
	        	  if(aptListSize>=1){
	             
	        		  for (int i = 0; i< aptListSize; i++)
	        		  {
	        			  startTime= createSchedule.getAptList().get(i).startDateTime;
	        			  endTime =  createSchedule.getAptList().get(i).endDateTime;
	        			  staffid =  createSchedule.getAptList().get(i).staffId;
	        			  appwith =  createSchedule.getAptList().get(i).aptWith;
	            
	         // Now start logic
	             seriesStatus=CISConstants.seriesStatus1;
	             String startDateTime=startTime;
	             String enddateTime=endTime;
	             String endDateTime = "";
	             String startdateTime = "";
	           
	             
	             // Logic to split Enddate time 
	             String[] allStrings = enddateTime.split("\\s");
	             for (int j = 4; j < allStrings.length; j++){
	                 endDateTime = endDateTime + " " + allStrings[j];
	               
	             }
	             // Logic to split Startdate time 
	             String[] allStrings2 = startDateTime.split("\\s");
	             for (int p = 4; p < allStrings2.length; p++){
	                 startdateTime = startdateTime + " " + allStrings2[p];
	               
	             }
	             
	             // Logic to Get recursive next week datetime
	              
	             for (int k=1; k<=recurrenceTime; k++) {
	            	 sessionId = UUID.randomUUID().toString();
	            	 aptId=DigestUtils.sha1Hex(sessionId);
	            	 upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
	            	 aptId=upToNCharacters;
	              
	            	 SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
	            	 Date d1 = sdf.parse(startDateTime);
	            	 Calendar c = Calendar.getInstance();
	            	 c.setTime(d1); // Now use today date.
	            	 if(k==1){
	                  // Concat Enddate with end time Lodic
	            		 String[] allStrings1 = startDateTime.split("\\s");
	            		 StringBuilder strBuilder = new StringBuilder();

	            		 for (int l = 0; l < allStrings1.length-1; l++) {
	            			 strBuilder.append(allStrings1[l]);
	            			 strBuilder.append(" ");
	            		 }
	            		 String endDatetime= strBuilder.toString();
	            		 endDatetime=endDatetime+endDateTime;
	                               
	                  cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDateTime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus);
	                  cisResults = createScheduleDAO.createSchedules(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDateTime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus,recurrenceTime);
	                 
	                  
	                  
	                  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	                  {
	                      cisResults=createScheduleDAO.getStaffEmail(staffid);
	                      
	                      DigiHealthCareSaveStaffMemberModel  staffEmailId=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
	                      String staffEmail=staffEmailId.getEmailId();
	                     
	                      DigiHealthCareSaveStaffMemberModel  stafffname=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
	                      String Stfname=stafffname.getfName();
	                    
	                      DigiHealthCareSaveStaffMemberModel  stafflname=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
	                      String Stlname=stafflname.getlName();
	                      
	                      DigiHealthCareSaveStaffMemberModel  stphone=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
	                      String StaffPhoneNumber=stphone.getPhone1();
	                     
	                      cisResults=createScheduleDAO.getPatientEmail(patientId);
	                    
	                      DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                      String  patientEmail=patientEmailId.getEmailId();
	                     
	                      DigiHealthCarePatientModel  firstname=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                      String name=firstname.getFirstName();
	                    
	                      DigiHealthCarePatientModel  lastName=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                      String  lastname=lastName.getLastName();
	                      DigiHealthCarePatientModel  phone=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                     
	                      phoneNumber=phone.getPhone();
	                      
	                      String cc= staffEmail ;
	                      String bcc= CISConstants.ADMINEMAILID ;
	                      
	                      String subject= "Your care plan schedule has been created";

	                      String messageType=CISConstants.RECIEVED;     
	                      
	                      String directorMail=CISConstants.DIRECTOREMAILID;
	                      String dirPhone=CISConstants.DIRPHONE;
	                      String adminPhone=CISConstants.ADMINPHONENUMBER;
	                      String messageCategory=CISConstants.APPOINTMENT_CREATED;
	                      if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	                       {
	                          cisResults=sendMail.sendPatientMail(patientEmail,appwith,startTime,endTime,type,Stfname,Stlname,recurrenceTime,cc,bcc,directorMail,name,lastname);
	                        
	                          cisResults=createScheduleDAO.messageText(messageId,aptId,patientId,phoneNumber,patientEmail,subject,createDate,messageType,messageCategory);
	                          
	                          System.out.println("RECURENCE BLOCK ");
	                          ArrayList<String> phoneNumberList=new ArrayList<String>();
	                          phoneNumberList.add(phoneNumber);
	                          phoneNumberList.add(dirPhone);
	                          phoneNumberList.add(adminPhone);
	                          phoneNumberList.add(StaffPhoneNumber);
	                          
	                          Iterator<String> itr=phoneNumberList.iterator();  
	                          while(itr.hasNext()){  
	                           String messageNumber = itr.next(); 
	                          
	                           cisResults=smsCommunicaiton.sendRegistrationSMS(patientEmail,appwith,startTime,endTime,type,Stfname,Stlname,recurrenceTime,cc,bcc,directorMail,messageNumber,name,lastname);
	                           
	                          }
	                          
	                          
	                          
	                        //  cisResults=smsCommunicaiton.sendRegistrationSMS(patientEmail,appwith,startTime,endTime,type,Stfname,Stlname,recurrenceTime,cc,bcc,directorMail,phoneNumber,dirPhone,adminPhone,StaffPhoneNumber);
	                            
	                       }
	                     
	                  }
	                  
	                                    
	         }else{
	       
	                 c.add(Calendar.MONTH,1 );
	                 startDateTime=sdf.format(c.getTime());
	                 
	                 String[] allStrings1 = startDateTime.split("\\s");
	                 StringBuilder strBuilder1 = new StringBuilder();

	                 for (int s = 0; s < allStrings1.length-1; s++) {
	            	 strBuilder1.append(allStrings1[s]);
	                 strBuilder1.append(" ");
	                 }
	                 
	                 String startDatetime = strBuilder1.toString();
	             	 startDatetime=startDatetime+startdateTime;
	             
	             
	                 // Concat Enddate with end time Lodic
	                 String[] allStrings3 = startDateTime.split("\\s");
	                 StringBuilder strBuilder3 = new StringBuilder();

	                 for (int l = 0; l < allStrings3.length-1; l++) {
	                     strBuilder3.append(allStrings3[l]);
	                     strBuilder3.append(" ");
	               }
	                 String endDatetime= strBuilder3.toString();
	                 endDatetime=endDatetime+endDateTime;
	               // cisResults.setParkDetails(parkDetailslist);   
	                 cisResults=createScheduleDAO.getPatientEmail(patientId);
	                 
	                 DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                 String  patientEmail=patientEmailId.getEmailId();
	                
	                 DigiHealthCarePatientModel  firstname=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                 String name=firstname.getFirstName();
	               
	                 DigiHealthCarePatientModel  lastName=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                 String  lastname=lastName.getLastName();
	                 DigiHealthCarePatientModel  phone=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                 String subject= "Your care plan schedule has been created";

	                 String messageType=CISConstants.RECIEVED; 
	                 String messageCategory=CISConstants.APPOINTMENT_CREATED;
	                 cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDatetime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus);
	                 cisResults=createScheduleDAO.messageText(messageId,aptId,patientId,phoneNumber,patientEmail,subject,createDate,messageType,messageCategory);
	                         
	         }
	             }
	           }
	         }
	         }
	        // Capture Service End time
	          String serviceEndTime=time.getTimeZone();
	          long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
	          logger.info("Database time for create schedule service:: " +result );
	         
	        return cisResults;
	         }

	public CISResults createByWeeksSchedule(DigiHealthCareCreateScheduleModel createSchedule) throws Throwable{
        
        final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
        
        EmailCommunication sendMail=new EmailCommunication();
        SMSCommunication smsCommunicaiton=new SMSCommunication();
        // Capture service Start time
        
         CISResults cisResults=new CISResults();
         Appointments aptList=new Appointments();
         
         TimeCheck time=new TimeCheck();
         testServiceTime seriveTimeCheck=new testServiceTime();
         String serviceStartTime=time.getTimeZone();
         
         // generating aptid
         
         String sessionId = UUID.randomUUID().toString();
         String aptId=DigestUtils.sha1Hex(sessionId);
         String upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
         aptId=upToNCharacters;
          
          //messageID
          
          sessionId = UUID.randomUUID().toString();
          String messageId=DigestUtils.sha1Hex(sessionId);
          upToNCharacters = messageId.substring(0, Math.min(messageId.length(), 6));
          messageId=upToNCharacters;
          int aptSeriesId = counts.incrementAndGet();
          Calendar currentdate = Calendar.getInstance();
          DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
          TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
          formatter.setTimeZone(obj);
          String createDate=time.getTimeZone();
          int recurrenceTime=createSchedule.getRecurenceTime();
          String seriesStatus=CISConstants.seriesStatus2;
          int totalDay=CISConstants.totalDay;
          String patientId=createSchedule.getPatientId();
          int aptListSize=createSchedule.getAptList().size();
        
          String startTime="";
          String endTime="";
          String appwith="";
          int staffid=0;
          String phoneNumber="";
          String type= createSchedule.getType();
         
        // If startTimeListSize equal to > 1 need to series id=Y or series id=N no need else blcok
          if(recurrenceTime>0){
        	  if(aptListSize>=1){
             
        		  for (int i = 0; i< aptListSize; i++)
        		  {
        			  startTime= createSchedule.getAptList().get(i).startDateTime;
        			  endTime =  createSchedule.getAptList().get(i).endDateTime;
        			  staffid =  createSchedule.getAptList().get(i).staffId;
        			  appwith =  createSchedule.getAptList().get(i).aptWith;
            
         // Now start logic
             seriesStatus=CISConstants.seriesStatus1;
             String startDateTime=startTime;
             String enddateTime=endTime;
             String endDateTime = "";
             String startdateTime = "";
           
             
             // Logic to split Enddate time 
             String[] allStrings = enddateTime.split("\\s");
             for (int j = 4; j < allStrings.length; j++){
                 endDateTime = endDateTime + " " + allStrings[j];
               
             }
             // Logic to split Startdate time 
             String[] allStrings2 = startDateTime.split("\\s");
             for (int p = 4; p < allStrings2.length; p++){
                 startdateTime = startdateTime + " " + allStrings2[p];
               
             }
             
             // Logic to Get recursive next week datetime
              
             for (int k=1; k<=recurrenceTime; k++) {
            	 sessionId = UUID.randomUUID().toString();
            	 aptId=DigestUtils.sha1Hex(sessionId);
            	 upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
            	 aptId=upToNCharacters;
              
            	 SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
            	 Date d1 = sdf.parse(startDateTime);
            	 Calendar c = Calendar.getInstance();
            	 c.setTime(d1); // Now use today date.
            	 if(k==1){
                  // Concat Enddate with end time Lodic
            		 String[] allStrings1 = startDateTime.split("\\s");
            		 StringBuilder strBuilder = new StringBuilder();

            		 for (int l = 0; l < allStrings1.length-1; l++) {
            			 strBuilder.append(allStrings1[l]);
            			 strBuilder.append(" ");
            		 }
            		 String endDatetime= strBuilder.toString();
            		 endDatetime=endDatetime+endDateTime;
                               
                  cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDateTime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus);
                  cisResults = createScheduleDAO.createSchedules(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDateTime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus,recurrenceTime);
                
                  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
                  {
                      cisResults=createScheduleDAO.getStaffEmail(staffid);
                      
                      DigiHealthCareSaveStaffMemberModel  staffEmailId=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
                      String staffEmail=staffEmailId.getEmailId();
                     
                      DigiHealthCareSaveStaffMemberModel  stafffname=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
                      String Stfname=stafffname.getfName();
                    
                      DigiHealthCareSaveStaffMemberModel  stafflname=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
                      String Stlname=stafflname.getlName();
                      
                      DigiHealthCareSaveStaffMemberModel  stphone=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
                      String StaffPhoneNumber=stphone.getPhone1();
                     
                      
                      cisResults=createScheduleDAO.getPatientEmail(patientId);
                    
                      DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResults.getResultObject();
                      String  patientEmail=patientEmailId.getEmailId();
                     
                      DigiHealthCarePatientModel  firstname=(DigiHealthCarePatientModel)cisResults.getResultObject();
                      String name=firstname.getFirstName();
                    
                      DigiHealthCarePatientModel  lastName=(DigiHealthCarePatientModel)cisResults.getResultObject();
                      String  lastname=lastName.getLastName();
                      DigiHealthCarePatientModel  phone=(DigiHealthCarePatientModel)cisResults.getResultObject();
                     
                      phoneNumber=phone.getPhone();
                      
                      String cc= staffEmail ;
                      String bcc= CISConstants.ADMINEMAILID ;
                      
                      String subject= "Your care plan schedule has been created";

                      String messageType=CISConstants.RECIEVED;     
                      String directorMail=CISConstants.DIRECTOREMAILID;
                      String dirPhone=CISConstants.DIRPHONE;
                      String adminPhone=CISConstants.ADMINPHONENUMBER;
                      String messageCategory=CISConstants.APPOINTMENT_CREATED;
                      if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
                       {
                          cisResults=sendMail.sendPatientMail(patientEmail,appwith,startTime,endTime,type,Stfname,Stlname,recurrenceTime,cc,bcc,directorMail,name,lastname);
                        
                          cisResults=createScheduleDAO.messageText(messageId,aptId,patientId,phoneNumber,patientEmail,subject,createDate,messageType,messageCategory);
                         
                          ArrayList<String> phoneNumberList=new ArrayList<String>();
                          phoneNumberList.add(phoneNumber);
                          phoneNumberList.add(dirPhone);
                          phoneNumberList.add(adminPhone);
                          phoneNumberList.add(StaffPhoneNumber);
                          
                          Iterator<String> itr=phoneNumberList.iterator();  
                          while(itr.hasNext()){  
                           String messageNumber = itr.next(); 
                          
                           cisResults=smsCommunicaiton.sendRegistrationSMS(patientEmail,appwith,startTime,endTime,type,Stfname,Stlname,recurrenceTime,cc,bcc,directorMail,messageNumber,name,lastname);
                           
                          }
                          
                          
                          //cisResults=smsCommunicaiton.sendRegistrationSMS(patientEmail,appwith,startTime,endTime,type,Stfname,Stlname,recurrenceTime,cc,bcc,directorMail,phoneNumber,dirPhone,adminPhone,StaffPhoneNumber);
                              
                       }
                    }
         }else{
       
                 c.add(Calendar.DATE, 14);
                 startDateTime=sdf.format(c.getTime());
                 
                 String[] allStrings1 = startDateTime.split("\\s");
                 StringBuilder strBuilder1 = new StringBuilder();

                 for (int s = 0; s < allStrings1.length-1; s++) {
            	 strBuilder1.append(allStrings1[s]);
                 strBuilder1.append(" ");
                 }
                 
                 String startDatetime = strBuilder1.toString();
             	 startDatetime=startDatetime+startdateTime;
             
             
                 // Concat Enddate with end time Lodic
                 String[] allStrings3 = startDateTime.split("\\s");
                 StringBuilder strBuilder3 = new StringBuilder();

                 for (int l = 0; l < allStrings3.length-1; l++) {
                     strBuilder3.append(allStrings3[l]);
                     strBuilder3.append(" ");
               }
                 String endDatetime= strBuilder3.toString();
                 endDatetime=endDatetime+endDateTime;
               // cisResults.setParkDetails(parkDetailslist);   
                 cisResults=createScheduleDAO.getPatientEmail(patientId);
                 
                 DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResults.getResultObject();
                 String  patientEmail=patientEmailId.getEmailId();
                
                 DigiHealthCarePatientModel  firstname=(DigiHealthCarePatientModel)cisResults.getResultObject();
                 String name=firstname.getFirstName();
               
                 DigiHealthCarePatientModel  lastName=(DigiHealthCarePatientModel)cisResults.getResultObject();
                 String  lastname=lastName.getLastName();
                 DigiHealthCarePatientModel  phone=(DigiHealthCarePatientModel)cisResults.getResultObject();
                 String subject= "Your care plan schedule has been created";

                 String messageType=CISConstants.RECIEVED; 
                 String messageCategory=CISConstants.APPOINTMENT_CREATED;
                 cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDatetime,endDatetime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus);
                 cisResults=createScheduleDAO.messageText(messageId,aptId,patientId,phoneNumber,patientEmail,subject,createDate,messageType,messageCategory);
                       
         }
             }
           }
         }
       }
           
        // Capture Service End time
          String serviceEndTime=time.getTimeZone();
          long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
          logger.info("Database time for create schedule service:: " +result );
         
        return cisResults;
         }

	public CISResults createSingleSchedule(
			DigiHealthCareCreateScheduleModel createSchedule) throws Throwable {


		 final Logger logger = Logger.getLogger(DigiHealthCareEditSchedulePlanBL.class);
	        
	        EmailCommunication sendMail=new EmailCommunication();
	        SMSCommunication smsCommunicaiton=new SMSCommunication();
	        String directorMail=CISConstants.DIRECTOREMAILID;
	        // Capture service Start time
	        
	         CISResults cisResults=new CISResults();
	         Appointments aptList=new Appointments();
	         
	         TimeCheck time=new TimeCheck();
	         testServiceTime seriveTimeCheck=new testServiceTime();
	         String serviceStartTime=time.getTimeZone();
	         
	         // generating aptid
	         
	         String sessionId = UUID.randomUUID().toString();
	         String aptId=DigestUtils.sha1Hex(sessionId);
	         String upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
	         aptId=upToNCharacters;
	          
	          //messageID
	          
	          sessionId = UUID.randomUUID().toString();
	          String messageId=DigestUtils.sha1Hex(sessionId);
	          upToNCharacters = messageId.substring(0, Math.min(messageId.length(), 6));
	          messageId=upToNCharacters;
	          int aptSeriesId = counts.incrementAndGet();
	          Calendar currentdate = Calendar.getInstance();
	          DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	          TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	          formatter.setTimeZone(obj);
	          String createDate=time.getTimeZone();
	          int recurrenceTime=createSchedule.getRecurenceTime();
	          String seriesStatus=CISConstants.seriesStatus2;
	          int totalDay=CISConstants.totalDay;
	          String patientId=createSchedule.getPatientId();
	          int aptListSize=createSchedule.getAptList().size();
	        
	          String startTime="";
	          String endTime="";
	          String appwith="";
	          int staffid=0;
	          String type= createSchedule.getType();
	          for (int i = 0; i < aptListSize; i++)
	             {
	                  startTime= createSchedule.getAptList().get(i).startDateTime;
	                  endTime =  createSchedule.getAptList().get(i).endDateTime;
	                  staffid =  createSchedule.getAptList().get(i).staffId;
	                  appwith =  createSchedule.getAptList().get(i).aptWith;
	             
	                  // Now start logic
	                  seriesStatus=CISConstants.seriesStatus2;
	                  String startDateTime=startTime;
	                  String enddateTime=endTime;
	                  String endDateTime = "";
	             
	                  sessionId = UUID.randomUUID().toString();
	                  aptId=DigestUtils.sha1Hex(sessionId);
	                  upToNCharacters = aptId.substring(0, Math.min(aptId.length(), 8));
	                  aptId=upToNCharacters;
	              
	                // Logic to split Enddate time 
	                  String[] allStrings = enddateTime.split("\\s");
	                  for (int j = 4; j < allStrings.length; j++){
	                    endDateTime = endDateTime + " " + allStrings[j];
	                    cisResults = createScheduleDAO.createSchedule(aptId,aptSeriesId,staffid,createSchedule.getPatientId(),startDateTime,endTime,totalDay,createSchedule.getType(),appwith,createDate,seriesStatus);
	                  
	                    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	                    {
	                        cisResults=createScheduleDAO.getStaffEmail(staffid);
	                        
	                        DigiHealthCareSaveStaffMemberModel  staffEmailId=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
	                        String staffEmail=staffEmailId.getEmailId();
	                       
	                        DigiHealthCareSaveStaffMemberModel  stafffname=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
	                        String fname=stafffname.getfName();
	                      
	                        DigiHealthCareSaveStaffMemberModel  stafflname=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
	                        String lname=stafflname.getlName();
	                        
	                        DigiHealthCareSaveStaffMemberModel  stphone=(DigiHealthCareSaveStaffMemberModel)cisResults.getResultObject();
	                        String StaffPhoneNumber=stphone.getPhone1();
	                       
	                        
	                        cisResults=createScheduleDAO.getPatientEmail(patientId);
	                      
	                        DigiHealthCarePatientModel  patientEmailId=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                        String  patientEmail=patientEmailId.getEmailId();
	                       
	                        DigiHealthCarePatientModel  firstname=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                        String name=firstname.getFirstName();
	                      
	                        DigiHealthCarePatientModel  lastName=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                        String  lastname=lastName.getLastName();
	                        DigiHealthCarePatientModel  phone=(DigiHealthCarePatientModel)cisResults.getResultObject();
	                        
	                        String phoneNumber=phone.getPhone();
	                        
	                        String cc= staffEmail ;
	                        String bcc= CISConstants.ADMINEMAILID ;
	                        
	                        // Hard coded will change later
	                        
	                        String subject= "Your care plan schedule has been created";
	                        
	                        String messageType=CISConstants.RECIEVED;     
	                        String dirPhone=CISConstants.DIRPHONE;
	                        String adminPhone=CISConstants.ADMINPHONENUMBER;
	                        String messageCategory=CISConstants.APPOINTMENT_CREATED;
	                        if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	                         {
	                             cisResults=sendMail.sendPatientMail(patientEmail,appwith,startTime,endTime,type,fname,lname,recurrenceTime,cc,bcc,directorMail,name,lastname);
	                        
	                             cisResults=createScheduleDAO.messageText(messageId,aptId,patientId,phoneNumber,patientEmail,subject,createDate,messageType,messageCategory);
	                          
	                             ArrayList<String> phoneNumberList=new ArrayList<String>();
	                             phoneNumberList.add(phoneNumber);
	                             phoneNumberList.add(dirPhone);
	                             phoneNumberList.add(adminPhone);
	                             phoneNumberList.add(StaffPhoneNumber);
	                             
	                             Iterator<String> itr=phoneNumberList.iterator();  
	                             while(itr.hasNext()){  
	                              String messageNumber = itr.next(); 
	                             
	                              cisResults=smsCommunicaiton.sendRegistrationSMS(patientEmail,appwith,startTime,endTime,type,recurrenceTime,cc,bcc,directorMail,messageNumber,name,lastname);
	                              
	                             }  
	                             
	                             //  cisResults=smsCommunicaiton.sendRegistrationSMSworecurrence(patientEmail,appwith,startTime,endTime,type,recurrenceTime,cc,bcc,directorMail,phoneNumber,dirPhone,adminPhone,StaffPhoneNumber);
	                            
	                         }
	                       
	                 }
	                    
	             }
	                  
	                  
	         }
	   
	           
	        // Capture Service End time
	          String serviceEndTime=time.getTimeZone();
	          long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
	          logger.info("Database time for create schedule service:: " +result );
	         
	          return cisResults;
	         }

}