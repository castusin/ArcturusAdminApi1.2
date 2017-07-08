package com.digitalhealthcare;

public class DigiHealthCareCreateScheduleQuery {
	
	public static String SQL_CREATESCHEDULE = "insert into Appointments_table(Apt_id,Apt_series_id,Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Total_day,Type,Apt_with,Create_date,Series_status)"+"values(?,?,?,?,?,?,?,?,?,?,?)"; 
	
	public static String SQL_GETSTAFFEMAIL = " select Fname,Lname, Emailid from Staff_table where Staff_id= ? "; 
	
	public static String SQL_GETPATIENTEMAIL = " select First_name,Last_name,Phone_no,Email_id from Profile_table where User_id= ? "; 
	
	//public static String SQL_GETPATIENTEMAILS = " select First_name,Last_name,Email_id from Profile_table where User_id= ? "; 
	
	
	public static String SQL_CREATESCHEDULES = "insert into Appointment_series(Apt_id,Apt_series_id,Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Type,Apt_with,Create_date,Series_status,Recurrence)"+"values(?,?,?,?,?,?,?,?,?,?,?)"; 

	
	public static String SQL_GETPATIENTDETAILS = " select Type,Apt_starttime from Appointments_table where Patient_id= ? and Apt_id=? "; 

	public static String SQL_GETSTAFFDETAILS="select A.Fname,A.Lname,A.Emailid from Staff_table A join Appointments_table B on A.Staff_id=B.Apt_person_id where B.Patient_id=? and B.Apt_id=?";

	public static String SQL_MESSAGETEXT = "insert into Messages_table(Message_id,Apt_id,Patient_id,User_id,phoneNumber,emailId,Message_text,Create_date)"+"values(?,?,?,?,?,?,?,?)"; 
	
}
