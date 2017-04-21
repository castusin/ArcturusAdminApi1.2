package com.digitalhealthcare;

public class DigiHealthCareAdminViewPlansQuery {
	
	public static String SQL_ADMINVIEWPLANS = " select Apt_id,Apt_person_id,Type,Date_time,Apt_with,Create_date,Status from Appointments_table where User_id= ? "; 
	

}
