
package com.digitalhealthcare;

import java.sql.Date;

public class DigiHealthCareAdminViewPlansModel {
	//public String patientId;
    public String aptId;
    public String aptPersonId;
    public String userId;
    public Date dateTime;
    public String type;
    public String aptWith;
    public Date createDate;
    public String status;
    
    public DigiHealthCareAdminViewPlansModel( String aptId, String aptPersonId, String userId, Date dateTime, String type, String aptWith, Date createDate, String status) {
		super();
		//this.patientId = patientId;
		this.aptId=aptId;
		this.aptPersonId=aptPersonId;
		this.userId=userId;
		this.dateTime=dateTime;
		this.type=type;
		this.aptWith=aptWith;
		this.createDate=createDate;
		this.status=status;
		
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



	public String getAptPersonId() {
		return aptPersonId;
	}

	public void setAptPersonId(String aptPersonId) {
		this.aptPersonId = aptPersonId;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
/*
	


	public String getPatientId() {
		return patientId;
	}



	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


*/
	public DigiHealthCareAdminViewPlansModel(){
		
	}

}
