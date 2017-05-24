
package com.digitalhealthcare;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class DigiHealthCarePatientModel {
	
	public String emailId;
	
	public DigiHealthCarePatientModel(String emailId ) {
		super();
		this.emailId = emailId;
		}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public DigiHealthCarePatientModel(){
		
	}

}
