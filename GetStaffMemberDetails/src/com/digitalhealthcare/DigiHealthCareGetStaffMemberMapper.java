
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigiHealthCareGetStaffMemberMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareSaveStaffMemberModel getStafflist = new DigiHealthCareSaveStaffMemberModel();
		getStafflist.setStaffId(rs.getInt("Staff_id"));
		getStafflist.setfName(rs.getString("Fname"));
		getStafflist.setlName(rs.getString("Lname"));
		getStafflist.setServiceType(rs.getString("Servicetype"));
		getStafflist.setEmailId(rs.getString("Emailid"));
		getStafflist.setPhone1(rs.getString("Phone1"));
		getStafflist.setPhone2(rs.getString("Phone2"));
		getStafflist.setAddress1(rs.getString("Address1"));
		getStafflist.setAddress2(rs.getString("Address2"));
		getStafflist.setCity(rs.getString("City"));
		getStafflist.setCounty(rs.getString("county"));
		getStafflist.setState(rs.getString("State"));
		getStafflist.setZipcode(rs.getInt("Zipcode"));
		getStafflist.setActiveInd(rs.getString("Activeind"));
		getStafflist.setCreateDate(rs.getDate("Createdate"));
		return getStafflist;
	}

}
