
package com.digitalhealthcare;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigiHealthCarePatientMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DigiHealthCarePatientModel profileModel = new DigiHealthCarePatientModel();
		profileModel.setEmailId(rs.getString("Email_id"));
		profileModel.setFirstName(rs.getString("First_name"));
		profileModel.setLastName(rs.getString("Last_name"));
		return profileModel;
	}
}