package com.digitalhealthcare;

public class DigiHealthCareAdminViewPlansQuery {
	
	public static String SQL_ADMINVIEWPLANS = " select Apt_id,Apt_series_id, Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Type,Apt_with,Create_date,Status,Series_status  from Appointments_table where Patient_id= ? "; 
	

}
