
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigiHealthCareEditSchedulePlanMapper implements RowMapper{
	
	@SuppressWarnings("unchecked")
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareEditSchedulePlanModel editSchedulePlan = new DigiHealthCareEditSchedulePlanModel();
		editSchedulePlan.setPatientId(rs.getString("Patient_id"));
		editSchedulePlan.setAptPersonId(rs.getInt("Apt_person_id"));
		editSchedulePlan.setEndTimeList((List<EndDateTime>) rs.getArray("Apt_endtime"));
		editSchedulePlan.setStartTimeList((List<StartDateTime>) rs.getArray("Apt_starttime"));
		editSchedulePlan.setAptWith(rs.getString("Apt_with"));
		editSchedulePlan.setAllDay(rs.getInt("Total_day"));

		return editSchedulePlan;
	}

}
