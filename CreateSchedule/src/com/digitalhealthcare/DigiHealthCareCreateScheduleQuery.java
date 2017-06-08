package com.digitalhealthcare;

public class DigiHealthCareCreateScheduleQuery {
	
	public static String SQL_CREATESCHEDULE = "insert into Appointments_table(Apt_id,Apt_series_id,Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Total_day,Type,Apt_with,Create_date,Series_status)"+"values(?,?,?,?,?,?,?,?,?,?,?)"; 
	
	public static String SQL_GETSTAFFEMAIL = " select Fname,Lname, Emailid from Staff_table where Staff_id= ? "; 
	
	public static String SQL_GETPATIENTEMAIL = " select First_name,Last_name,Email_id from Profile_table where User_id= ? "; 
	
	public static String SQL_CREATESCHEDULES = "insert into Appointment_series(Apt_id,Apt_series_id,Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Type,Apt_with,Create_date,Series_status,Recurrence)"+"values(?,?,?,?,?,?,?,?,?,?,?)"; 

}
