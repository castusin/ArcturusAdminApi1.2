
package com.digitalhealthcare;


public class Appointments {
	
	
	String aptWith;
	int staffId;
	String startDateTime;
	String endDateTime;
	

	public Appointments(String aptWith, int staffId, String startDateTime, String endDateTime) {
		super();
		this.aptWith = aptWith;
		this.staffId=staffId;
		this.startDateTime=startDateTime;
		this.endDateTime=endDateTime;
	
	}


	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public String getStartDateTime() {
		return startDateTime;
	}


	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}


	public String getEndDateTime() {
		return endDateTime;
	}


	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}


	public String getAptWith() {
		return aptWith;
	}


	public void setAptWith(String aptWith) {
		this.aptWith = aptWith;
	}


	public Appointments(){
		
	}
	

}
