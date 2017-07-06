package com.digitalhealthcare;

public class DigiHealthCareEditSchedulePlanQuery {
	
	 public static String SQL_EDITRESCHEDULEPLAN="UPDATE Appointments_table  set Apt_person_id =?, Apt_starttime =?,Apt_endtime =?,Total_day =?,Apt_with=?,Type=?, Series_status=? where Patient_id=? and Apt_id=?" ;
	

	 public static String SQL_CREATESCHEDULE = "insert into Appointments_table(Apt_id,Apt_series_id,Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Total_day,Type,Apt_with,Create_date,Series_status)"+"values(?,?,?,?,?,?,?,?,?,?,?)"; 

	 public static String SQL_DELETESTAFFMEMBER = " delete  from Appointments_table where Apt_series_id=? "; 

	 public static String SQL_EDITMESSAGE="UPDATE Messages_table set Message_text =? where Patient_id=? and Apt_id=?" ;
		

}
//aptPersonId,startTime,endTime,allDay,aptWith,patientId