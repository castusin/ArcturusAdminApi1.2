
package com.digitalhealthcare;

import java.util.List;

public class DigiHealthCareEditSchedulePlanModel {
	
	String patientId;
	int allDay;
	int recurrenceTime;
	String aptId;
	int aptseriesId;
	int aptpersonId;
	String type;
	String seriesStatus;
	
	public List<Appointments> aptList;
	
    public DigiHealthCareEditSchedulePlanModel(String patientId, int aptPersonId, String startTime, String endTime, int allDay, String appWith, String aptWith, List<StartDateTime> startTimeList, List<EndDateTime> endTimeList, int recurrenceTime, List<StaffId> staffIdList, List<AptWith> aptWithList, List<Appointments> aptList, String aptId, int aptseriesId, int aptpersonId, String seriesStatus ) {
		super();
		this.patientId=patientId;
		this.allDay=allDay;
		this.aptList=aptList;
		this.recurrenceTime=recurrenceTime;
		this.aptId=aptId;
		this.aptseriesId=aptseriesId;
		this.aptpersonId=aptpersonId;
		this.seriesStatus=seriesStatus;
		
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



	public int getAptpersonId() {
		return aptpersonId;
	}



	public void setAptpersonId(int aptpersonId) {
		this.aptpersonId = aptpersonId;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getSeriesStatus() {
		return seriesStatus;
	}



	public void setSeriesStatus(String seriesStatus) {
		this.seriesStatus = seriesStatus;
	}



	public int getRecurrenceTime() {
		return recurrenceTime;
	}



	public void setRecurrenceTime(int recurrenceTime) {
		this.recurrenceTime = recurrenceTime;
	}



	public String getPatientId() {
		return patientId;
	}



	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	
	

	public int getAllDay() {
		return allDay;
	}



	public void setAllDay(int allDay) {
		this.allDay = allDay;
	}


	
	public List<Appointments> getAptList() {
		return aptList;
	}



	public void setAptList(List<Appointments> aptList) {
		this.aptList = aptList;
	}



	public DigiHealthCareEditSchedulePlanModel(){
		
	}

}
