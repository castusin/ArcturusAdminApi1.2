package com.cis;

import java.util.List;

public class CISResults {
	public static final String GS_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	String responseCode; // 0 - success, any positive number error
	String errorMessage; // error message if any
	String warningMessage; // if any
	String dateFormat;
	Object resultObject;
	//public List<DigiHealthCareViewPatientsService> patientDetails;
	/*public List<StartDateTime> startTimeList;
	public List<EndDateTime> endTimeList;
	
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
*/
	public String getDateErrorFormat() {
		return dateFormat;
	}

	public void setDateErrorFormat(String dateErrorFormat) {
		this.dateFormat = dateErrorFormat;
	}
	
	

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}

	public CISResults() {
		// TODO Auto-generated constructor stub
		responseCode = "0"; // 0 - success, any positive number error
		errorMessage = ""; // error message if any
		warningMessage = ""; // if any

	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getWarningMessage() {
		return warningMessage;
	}

	public void setWarningMessage(String warningMessage) {
		this.warningMessage = warningMessage;
	}

	/*public List<DigiHealthCareViewPatientsService> getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(
			List<DigiHealthCareViewPatientsService> patientDetails) {
		this.patientDetails = patientDetails;
	}
*/
	

	

}
