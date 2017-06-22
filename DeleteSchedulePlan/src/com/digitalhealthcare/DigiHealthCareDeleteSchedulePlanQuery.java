package com.digitalhealthcare;

public class DigiHealthCareDeleteSchedulePlanQuery {
	
	public static String SQL_DELETESCHEDULE = " delete  from Appointments_table where Apt_id=? and Patient_id=?"; 

	public static String SQL_DELETERECURSCHEDULE = " delete  from Appointments_table where  Patient_id=? and Apt_series_id=?"; 

	public static String SQL_DELETERECURSCHEDULES = " delete  from Appointment_series where  Patient_id=? and Apt_series_id=?"; 


}
