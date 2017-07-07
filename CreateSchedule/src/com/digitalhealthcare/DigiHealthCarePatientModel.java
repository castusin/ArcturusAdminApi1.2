
package com.digitalhealthcare;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class DigiHealthCarePatientModel {
	
	public String emailId;
	public String firstName;
	public String lastName;
	public String phone;
	public DigiHealthCarePatientModel(String emailId, String firstName, String lastName, String phone ) {
		super();
		this.emailId = emailId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.phone=phone;
		}

	



	public String getPhone() {
		return phone;
	}





	public void setPhone(String phone) {
		this.phone = phone;
	}





	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
