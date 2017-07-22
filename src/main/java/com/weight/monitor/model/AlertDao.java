package com.weight.monitor.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("Alerts")
public class AlertDao {

	@Id
	private ObjectId objectId;
	private String alertType;
	private long timeStamp;
	
	public AlertDao()
	{
		
	}
	
	public AlertDao(String type, long timestamp) {
		this.alertType = type;
		this.timeStamp = timestamp;
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
