package com.weight.monitor.model;

public class AlertTo {
	private String alertType;
	private long timeStamp;
	
	public AlertTo(String type, long ts) {
		this.alertType = type;
		this.timeStamp = ts;
	}
	
	public String getAlertType() {
		return alertType;
	}
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
