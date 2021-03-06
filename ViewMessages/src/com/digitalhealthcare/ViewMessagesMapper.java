
package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author 
 *
 */
@SuppressWarnings("rawtypes")
public class ViewMessagesMapper implements RowMapper{
public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	ViewMessagesModel viewMessages = new ViewMessagesModel();
	   
	  
	   viewMessages.setPatientId(rs.getString("Patient_id"));
	   viewMessages.setMessageId(rs.getString("Message_id"));
	   viewMessages.setAptId(rs.getString("Apt_id"));
	   viewMessages.setMessageText(rs.getString("Message_text"));
	   viewMessages.setPhoneNumber(rs.getString("phoneNumber"));
	   viewMessages.setEmailId(rs.getString("emailId"));
	   viewMessages.setCreateDate(rs.getDate("Create_date"));
	   //viewMessages.setAptStarttime(rs.getString("Apt_starttime"));
	   //viewMessages.setAptEndtime(rs.getString("Apt_endtime"));
	  // viewMessages.setType(rs.getString("type"));
	  // viewMessages.setAptWith(rs.getString("Apt_with"));
	   viewMessages.setMessageType(rs.getString("Message_type"));
	  // viewMessages.setTitle(rs.getString("Type"));
	   viewMessages.setUserId(rs.getString("User_id"));
	   viewMessages.setFirstName(rs.getString("First_name"));
	   viewMessages.setLastName(rs.getString("Last_name"));
	   viewMessages.setPhotoUrl(rs.getString("Photo"));
	   return viewMessages;
	}
}
