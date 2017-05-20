package com.digitalhealthcare;


import java.sql.Date;

public class DigiHealthCareCreateScheduleModel {
	
	int aptId;
	int aptseriesId;
	int staffId;
	String startDateTime;
	String endDateTime;
	String patientId;
	String type;
	String aptWith;
	String seriesStatus;
	String recurenceTime;
	
    public DigiHealthCareCreateScheduleModel(int staffId, int aptId, int aptseriesId, String startDateTime, String endDateTime, String patientId, String type, String aptWith, String seriesStatus, String recurenceTime) {
		super();
		this.staffId=staffId;
		this.aptId=aptId;
		this.aptseriesId=aptseriesId;
		this.startDateTime=startDateTime;
		this.endDateTime=endDateTime;
		this.patientId=patientId;
		this.type=type;
		this.aptWith=aptWith;
		this.seriesStatus=seriesStatus;
		this.recurenceTime=recurenceTime;
		

	}


	public int getAptId() {
		return aptId;
	}


	public void setAptId(int aptId) {
		this.aptId = aptId;
	}


	public int getAptseriesId() {
		return aptseriesId;
	}


	public void setAptseriesId(int aptseriesId) {
		this.aptseriesId = aptseriesId;
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


	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAptWith() {
		return aptWith;
	}


	public void setAptWith(String aptWith) {
		this.aptWith = aptWith;
	}


	public String getSeriesStatus() {
		return seriesStatus;
	}


	public void setSeriesStatus(String seriesStatus) {
		this.seriesStatus = seriesStatus;
	}


	public String getRecurenceTime() {
		return recurenceTime;
	}


	public void setRecurenceTime(String recurenceTime) {
		this.recurenceTime = recurenceTime;
	}


	public DigiHealthCareCreateScheduleModel(){
		
	}

}
