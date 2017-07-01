
package com.digitalhealthcare;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class StaffDetailsMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		StaffDetails profileModel = new StaffDetails();
		profileModel.setStaffname(rs.getString("Fname"));
		profileModel.setStaflname(rs.getString("Lname"));
		profileModel.setStaffmail(rs.getString("Emailid"));
		return profileModel;
	}
}