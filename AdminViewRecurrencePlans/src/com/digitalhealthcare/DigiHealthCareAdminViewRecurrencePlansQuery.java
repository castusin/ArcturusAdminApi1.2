package com.digitalhealthcare;

public class DigiHealthCareAdminViewRecurrencePlansQuery {
	
	//public static String SQL_ADMINVIEWRECURRENCEPLANS = " select Apt_id,Apt_series_id, Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Type,Apt_with,Create_date,Status,Series_status,Recurrence  from Appointment_series where Patient_id= ? and Apt_starttime >=? "; 

	public static String SQL_ADMINVIEWRECURRENCEPLANS = " select Apt_id,Apt_series_id, Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Type,Apt_with,Create_date,Status,Series_status,Recurrence  from Appointment_series where Patient_id= ?"; 


}
