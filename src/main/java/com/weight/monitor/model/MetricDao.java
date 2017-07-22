package com.weight.monitor.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value="Metrics")
public class MetricDao  {
	
	@Id
	private ObjectId objectId;
	private long timeStamp;
	private int value;
	
	public MetricDao()
	{
		
	}
	public MetricDao(long timeStamp, int value) {
		this.timeStamp = timeStamp;
		this.value = value;
	}
	
	public int  getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimestamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
