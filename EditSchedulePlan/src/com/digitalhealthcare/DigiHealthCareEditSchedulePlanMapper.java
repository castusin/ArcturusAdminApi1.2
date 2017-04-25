
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigiHealthCareEditSchedulePlanMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareEditSchedulePlanModel editSchedulePlan = new DigiHealthCareEditSchedulePlanModel();
		editSchedulePlan.setPatientId(rs.getString("Patient_id"));
		editSchedulePlan.setAptPersonId(rs.getInt("Apt_person_id"));
		editSchedulePlan.setEndTime(rs.getString("Apt_endtime"));
		editSchedulePlan.setStartTime(rs.getString("Apt_starttime"));
		editSchedulePlan.setAptWith(rs.getString("Apt_with"));
		editSchedulePlan.setAllDay(rs.getInt("Total_day"));

		return editSchedulePlan;
	}

}
