package com.digitalhealthcare;


import java.sql.Date;
import java.util.List;

public class DigiHealthCareCreateScheduleModel {
	
	int aptId;
	int aptseriesId;
	int aptpersonId;
	int totalDay;
	String status;
	int staffId;
	//String startDateTime;
	//String endDateTime;
	String patientId;
	String type;
	String aptWith;
	String seriesStatus;
	int recurenceTime;
	public List<StartDateTime> startTimeList;
	public List<EndDateTime> endTimeList;
    public DigiHealthCareCreateScheduleModel(int staffId, int aptId, int aptseriesId, List<StartDateTime> startDateTime, List<EndDateTime> endDateTime, String patientId, String type, String aptWith, String seriesStatus, int recurenceTime, int aptpersonId, int totalDay, String status, List<StartDateTime> startTimeList, List<EndDateTime> endTimeList) {
		super();
		this.aptpersonId=aptpersonId;
		this.totalDay=totalDay;
		this.status=status;
		this.staffId=staffId;
		this.aptId=aptId;
		this.aptseriesId=aptseriesId;
		this.startTimeList=startTimeList;
		this.endTimeList=endTimeList;
		this.patientId=patientId;
		this.type=type;
		this.aptWith=aptWith;
		this.seriesStatus=seriesStatus;
		this.recurenceTime=recurenceTime;
		

	}


	public List<StartDateTime> getStartTimeList() {
		return startTimeList;
	}


	public void setStartTimeList(List<StartDateTime> startTimeList) {
		this.startTimeList = startTimeList;
	}


	public List<EndDateTime> getEndTimeList() {
		return endTimeList;
	}


	public void setEndTimeList(List<EndDateTime> endTimeList) {
		this.endTimeList = endTimeList;
	}


	public int getAptpersonId() {
		return aptpersonId;
	}


	public void setAptpersonId(int aptpersonId) {
		this.aptpersonId = aptpersonId;
	}



	public int getTotalDay() {
		return totalDay;
	}


	public void setTotalDay(int totalDay) {
		this.totalDay = totalDay;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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



	public int getRecurenceTime() {
		return recurenceTime;
	}


	public void setRecurenceTime(int recurenceTime) {
		this.recurenceTime = recurenceTime;
	}


	public DigiHealthCareCreateScheduleModel(){
		
	}

}
