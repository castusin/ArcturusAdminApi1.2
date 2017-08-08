package com.digitalhealthcare;

public class ViewMessagesQuery {
	
	public static final String SQL_VIEWMESSAGES ="SELECT A.Message_id,A.Apt_id,A.Patient_id,A.phoneNumber,A.emailId,A.Message_text,A.Create_date,A.Message_type,B.User_id,B.First_name,B.Last_name,B.Photo FROM Messages_table A  JOIN Profile_table B ON A.Patient_id = B.User_id ";
	//public static final String SQL_VIEWMESSAGES ="SELECT * FROM Messages_table ";

}
