
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigiHealthCareSaveStaffMemberMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareSaveStaffMemberModel getStafflist = new DigiHealthCareSaveStaffMemberModel();
		getStafflist.setEmailId(rs.getString("Emailid"));
		return getStafflist;
	}

}
