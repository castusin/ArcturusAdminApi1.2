
package com.digitalhealthcare;

import java.sql.Date;
import java.util.List;

public class DigiHealthCareEditSchedulePlanModel {
	
	String patientId;
	int aptPersonId;
	//String startTime;
	//String endTime;
	int allDay;
	String aptWith;
	int recurrenceTime;
	public List<StartDateTime> startTimeList;
	public List<EndDateTime> endTimeList;
    public DigiHealthCareEditSchedulePlanModel(String patientId, int aptPersonId, String startTime, String endTime, int allDay, String appWith, String aptWith, List<StartDateTime> startTimeList, List<EndDateTime> endTimeList, int recurrenceTime ) {
		super();
		this.patientId=patientId;
		this.aptPersonId=aptPersonId;
		this.startTimeList=startTimeList;
		this.endTimeList=endTimeList;
		this.allDay=allDay;
		this.aptWith=aptWith;
		this.recurrenceTime=recurrenceTime;
		
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
