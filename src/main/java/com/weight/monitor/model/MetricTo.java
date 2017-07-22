package com.weight.monitor.model;

public class MetricTo {
	
	
	private long timeStamp;
	private int value;
	
	public MetricTo()
	{
		
	}
	public MetricTo(long timeStamp, int value) {
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
