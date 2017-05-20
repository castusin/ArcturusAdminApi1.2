package com.digitalhealthcare;

public class DigiHealthCareCreateScheduleQuery {
	
	public static String SQL_CREATESCHEDULE = "insert into Appointments_table(Apt_id,Apt_series_id, Apt_starttime,Apt_endtime,Patient_id,Type,Apt_with,Create_date,Series_status)"+"values(?,?,?,?,?,?,?,?,?)"; 
	

}
//aptId,aptseriesId,staffId,startDateTime,endDateTime,patientId,type,aptWith,seriesStatus,recurenceTime