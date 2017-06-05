
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
		adminViewPlans.setAptseriesId(rs.getInt("Apt_series_id"));
		adminViewPlans.setAptPersonId(rs.getInt("Apt_person_id"));
		adminViewPlans.setPatiendId(rs.getString("Patient_id"));
		//adminViewPlans.setUserId(rs.getString("User_id"));
		adminViewPlans.setTitle(rs.getString("Type"));
		//adminViewPlans.setDateTime(rs.getDate("Date_time"));
		adminViewPlans.setAptWith(rs.getString("Apt_with"));
		adminViewPlans.setCreateDate(rs.getDate("Create_date"));
		adminViewPlans.setStatus(rs.getString("Status"));
		
		adminViewPlans.setStartsAt(rs.getString("Apt_starttime"));
		adminViewPlans.setEndsAt(rs.getString("Apt_endtime"));
		adminViewPlans.setSeriesStatus(rs.getString("Series_status"));
		return adminViewPlans;
	}

}
