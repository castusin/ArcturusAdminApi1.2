package com.digitalhealthcare;

public class DigiHealthCareGetStaffMemberQuery {
	
	public static String SQL_GETSTAFFLIST = " select Staff_id,Fname,Lname,Servicetype,Emailid,Phone1,Phone2,Address1,Address2,City,county,State,Zipcode,Activeind,Createdate from Staff_table order by Lname "; 


}
