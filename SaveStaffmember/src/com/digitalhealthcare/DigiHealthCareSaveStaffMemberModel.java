
package com.digitalhealthcare;

import java.sql.Date;

public class DigiHealthCareSaveStaffMemberModel {
	
	int staffId;
	String fName;
	String lName;
	String emailId;
	String serviceType;
	String phone1;
	String phone2;
	String address1;
	String address2;
	String city;
	String county;
	String state;
	int zipcode;
	String activeInd;
	Date createDate;
	
	String lattitude;
	String longitude;
    public DigiHealthCareSaveStaffMemberModel(int staffId, String fName, String lName, String emailId, String serviceType, String phone1, String phone2, String address1, String address2, String city, String country, String state, int zipcode, String activeInd, Date createDate, String county, String lattitude, String longitude ) {
		super();
		this.staffId=staffId;
		this.fName=fName;
		this.lName=lName;
		this.emailId=emailId;
		this.serviceType=serviceType;
		this.phone1=phone1;
		this.phone2=phone2;
		this.address1=address1;
		this.address2=address2;
		this.city=city;
		this.county=county;
		this.state=state;
		this.zipcode=zipcode;
		this.activeInd=activeInd;
		this.createDate=createDate;
		
		this.lattitude=lattitude;
		this.longitude=longitude;
		
	}



	public String getLattitude() {
		return lattitude;
	}



	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}



	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	public int getStaffId() {
		return staffId;
	}



	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}



	public String getfName() {
		return fName;
	}



	public void setfName(String fName) {
		this.fName = fName;
	}



	public String getlName() {
		return lName;
	}



	public void setlName(String lName) {
		this.lName = lName;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getServiceType() {
		return serviceType;
	}



	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	public String getPhone1() {
		return phone1;
	}



	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}



	public String getPhone2() {
		return phone2;
	}



	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}



	public String getAddress1() {
		return address1;
	}



	public void setAddress1(String address1) {
		this.address1 = address1;
	}



	public String getAddress2() {
		return address2;
	}



	public void setAddress2(String address2) {
		this.address2 = address2;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	


	public String getCounty() {
		return county;
	}



	public void setCounty(String county) {
		this.county = county;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public int getZipcode() {
		return zipcode;
	}



	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}



	public String getActiveInd() {
		return activeInd;
	}



	public void setActiveInd(String activeInd) {
		this.activeInd = activeInd;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public DigiHealthCareSaveStaffMemberModel(){
		
	}

}
