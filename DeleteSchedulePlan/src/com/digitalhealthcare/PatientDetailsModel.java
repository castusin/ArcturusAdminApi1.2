
package com.digitalhealthcare;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class PatientDetailsModel {
	
	public String type;
	public String startTime;
	
	public PatientDetailsModel(String type, String startTime ) {
		super();
		this.type = type;
		this.startTime=startTime;
		
		}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public PatientDetailsModel(){
		
	}

}
