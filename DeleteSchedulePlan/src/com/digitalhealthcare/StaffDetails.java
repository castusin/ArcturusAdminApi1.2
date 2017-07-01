
package com.digitalhealthcare;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class StaffDetails {
	
	public String staffname;
	public String staflname;
	public String staffmail;;
	public StaffDetails(String staffname, String staflname, String staffmail ) {
		super();
		this.staffname = staffname;
		this.staflname = staflname;
		this.staffmail=staffmail;
		
		}



	public String getStaffmail() {
		return staffmail;
	}



	public void setStaffmail(String staffmail) {
		this.staffmail = staffmail;
	}



	public String getStaflname() {
		return staflname;
	}



	public void setStaflname(String staflname) {
		this.staflname = staflname;
	}



	public String getStaffname() {
		return staffname;
	}



	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}



	public StaffDetails(){
		
	}

}
