package com.digitalhealthcare;

public class DigiHealthCareCreateScheduleQuery {
	
	public static String SQL_CREATESCHEDULE = "insert into Appointments_table(Apt_id,Apt_series_id,Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Total_day,Type,Apt_with,Create_date,Series_status)"+"values(?,?,?,?,?,?,?,?,?,?,?)"; 
	
	public static String SQL_GETSTAFFEMAIL = " select Emailid from Staff_table where Staff_id= ? "; 

}
//aptId,aptseriesId,staffId,startDateTime,endDateTime,patientId,type,aptWith,seriesStatus,recurenceTime