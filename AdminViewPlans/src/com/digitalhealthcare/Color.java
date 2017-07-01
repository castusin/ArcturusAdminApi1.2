package com.digitalhealthcare;


public class Color {
	
	public String primary;
	public String secondary;
	
	 public Color(String primary, String secondary ) {
			super();
			//this.patientId = patientId;
			this.primary=primary;
			this.secondary=secondary;
			
		}
	
	
public String getPrimary() {
		return primary;
	}


	public void setPrimary(String primary) {
		this.primary = primary;
	}


	public String getSecondary() {
		return secondary;
	}


	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}


public Color(){
		
	}

}
