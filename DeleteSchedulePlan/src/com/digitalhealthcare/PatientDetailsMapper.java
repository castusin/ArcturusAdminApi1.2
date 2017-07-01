
package com.digitalhealthcare;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class PatientDetailsMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PatientDetailsModel profileModel = new PatientDetailsModel();
		profileModel.setType(rs.getString("Type"));
		profileModel.setStartTime(rs.getString("Apt_starttime"));
		
		return profileModel;
	}
}