
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigiHealthCareAdminViewPlansMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareAdminViewPlansModel adminViewPlans = new DigiHealthCareAdminViewPlansModel();
		adminViewPlans.setAptId(rs.getString("Apt_id"));
		adminViewPlans.setAptPersonId(rs.getString("Apt_person_id"));
		//adminViewPlans.setUserId(rs.getString("User_id"));
		adminViewPlans.setType(rs.getString("Type"));
		adminViewPlans.setDateTime(rs.getDate("Date_time"));
		adminViewPlans.setAptWith(rs.getString("Apt_with"));
		adminViewPlans.setCreateDate(rs.getDate("Create_date"));
		adminViewPlans.setStatus(rs.getString("Status"));
		
		return adminViewPlans;
	}

}
