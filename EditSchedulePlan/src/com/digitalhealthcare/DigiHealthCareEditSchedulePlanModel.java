
package com.digitalhealthcare;

import java.sql.Date;

public class DigiHealthCareEditSchedulePlanModel {
	
	String patientId;
	int aptPersonId;
	String startTime;
	String endTime;
	int allDay;
	String aptWith;
	
    public DigiHealthCareEditSchedulePlanModel(String patientId, int aptPersonId, String startTime, String endTime, int allDay, String appWith, String aptWith ) {
		super();
		this.patientId=patientId;
		this.aptPersonId=aptPersonId;
		this.startTime=startTime;
		this.endTime=endTime;
		this.allDay=allDay;
		this.aptWith=aptWith;
		
	}



	public String getPatientId() {
		return patientId;
	}



	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getEndTime() {
		return endTime;
	}



	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getAptPersonId() {
		return aptPersonId;
	}



	public void setAptPersonId(int aptPersonId) {
		this.aptPersonId = aptPersonId;
	}



	public int getAllDay() {
		return allDay;
	}



	public void setAllDay(int allDay) {
		this.allDay = allDay;
	}

	public String getAptWith() {
		return aptWith;
	}



	public void setAptWith(String aptWith) {
		this.aptWith = aptWith;
	}



	public DigiHealthCareEditSchedulePlanModel(){
		
	}

}
