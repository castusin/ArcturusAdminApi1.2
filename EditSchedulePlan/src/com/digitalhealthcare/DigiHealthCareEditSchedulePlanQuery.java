package com.digitalhealthcare;

public class DigiHealthCareEditSchedulePlanQuery {
	
	 public static String SQL_EDITRESCHEDULEPLAN="UPDATE Appointments_table  set Apt_person_id =?, Apt_starttime =?,Apt_endtime =?,Total_day =?,Apt_with=? where Patient_id=?" ;
	}
//aptPersonId,startTime,endTime,allDay,aptWith,patientId