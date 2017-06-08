package com.digitalhealthcare;

import java.sql.Date;

public class DigiHealthCareAdminViewRecurrencePlansModel {
	//public String patientId;
    public String aptId;
    public int aptPersonId;
    //public String userId;
    public Date dateTime;
    public String title;
    public String aptWith;
    public Date createDate;
    public String status;
    public String startsAt;
    public String endsAt;
    public int aptseriesId;
    public String patiendId;
    public String seriesStatus;
   // public String day;
    public boolean val;
    public int recurrence;
    public DigiHealthCareAdminViewRecurrencePlansModel( String aptId, int aptPersonId, String userId, Date dateTime, String type, String aptWith, Date createDate, String status, String patiendId, String title, String startsAt, String endsAt, String seriesStatus, int aptseriesId, String day, boolean val, int recurrence) {
		super();
		//this.patientId = patientId;
		this.aptId=aptId;
		this.aptPersonId=aptPersonId;
		this.patiendId=patiendId;
		this.dateTime=dateTime;
		this.title=title;
		this.aptWith=aptWith;
		this.createDate=createDate;
		this.status=status;
		this.startsAt=startsAt;
		this.endsAt=endsAt;
		this.seriesStatus=seriesStatus;
		this.aptseriesId=aptseriesId;
		//this.day=day;
		this.val=val;
		this.recurrence=recurrence;
	}

    
	
	public int getRecurrence() {
		return recurrence;
	}



	public void setRecurrence(int recurrence) {
		this.recurrence = recurrence;
	}



	public boolean isVal() {
		return val;
	}


	public void setVal(boolean val) {
		this.val = val;
	}


	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	

	public String getAptId() {
		return aptId;
	}


	public void setAptId(String aptId) {
		this.aptId = aptId;
	}


	public int getAptPersonId() {
		return aptPersonId;
	}

	public void setAptPersonId(int aptPersonId) {
		this.aptPersonId = aptPersonId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getStartsAt() {
		return startsAt;
	}

	public void setStartsAt(String startsAt) {
		this.startsAt = startsAt;
	}

	public String getEndsAt() {
		return endsAt;
	}

	public void setEndsAt(String endsAt) {
		this.endsAt = endsAt;
	}

	public int getAptseriesId() {
		return aptseriesId;
	}

	public void setAptseriesId(int aptseriesId) {
		this.aptseriesId = aptseriesId;
	}

	public String getPatiendId() {
		return patiendId;
	}

	public void setPatiendId(String patiendId) {
		this.patiendId = patiendId;
	}

	public String getSeriesStatus() {
		return seriesStatus;
	}

	public void setSeriesStatus(String seriesStatus) {
		this.seriesStatus = seriesStatus;
	}

	public String getAptWith() {
		return aptWith;
	}

	public void setAptWith(String aptWith) {
		this.aptWith = aptWith;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public DigiHealthCareAdminViewRecurrencePlansModel(){
		
	}

}
