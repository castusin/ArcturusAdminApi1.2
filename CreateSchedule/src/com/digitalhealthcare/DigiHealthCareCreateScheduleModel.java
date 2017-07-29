package com.digitalhealthcare;


import java.util.List;

public class DigiHealthCareCreateScheduleModel {
	
	String aptId;
	int aptseriesId;
	int aptpersonId;
	int totalDay;
	String status;
	String patientId;
	String type;
	String seriesStatus;
	int recurenceTime;
	String day;
	boolean val;
	String messageType;
	String scheduleType;
	public List<Appointments> aptList;
    public DigiHealthCareCreateScheduleModel(int staffId, String aptId, int aptseriesId, List<StartDateTime> startDateTime, List<EndDateTime> endDateTime, String patientId, String type, String aptWith, String seriesStatus, int recurenceTime, int aptpersonId, int totalDay, String status, List<StartDateTime> startTimeList, List<EndDateTime> endTimeList, List<StaffId> staffIdList, List<AptWith> aptWithList, List<Appointments> aptList, String day, boolean val, String messageType, String scheduleType) {
		super();
		this.aptpersonId=aptpersonId;
		this.totalDay=totalDay;
		this.status=status;
		this.aptId=aptId;
		this.aptseriesId=aptseriesId;
		this.patientId=patientId;
		this.type=type;
		this.seriesStatus=seriesStatus;
		this.recurenceTime=recurenceTime;
		this.aptList=aptList;
		this.day=day;
		this.val=val;
		this.messageType=messageType;
		this.scheduleType=scheduleType;
		}


	

	public String getScheduleType() {
		return scheduleType;
	}




	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}




	public String getMessageType() {
		return messageType;
	}




	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}




	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public boolean isVal() {
		return val;
	}

	public void setVal(boolean val) {
		this.val = val;
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

	

	public String getAptId() {
		return aptId;
	}




	public void setAptId(String aptId) {
		this.aptId = aptId;
	}




	public int getAptseriesId() {
		return aptseriesId;
	}

	public void setAptseriesId(int aptseriesId) {
		this.aptseriesId = aptseriesId;
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
	

	public List<Appointments> getAptList() {
		return aptList;
	}

	public void setAptList(List<Appointments> aptList) {
		this.aptList = aptList;
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
