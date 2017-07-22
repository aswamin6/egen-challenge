package com.weight.monitor.model;

public class TimeRange {
	private long startTime;
	private long endTime;
	
	public TimeRange() {
		
	}
	
	public TimeRange(long st, long et) {
		this.startTime =st;
		this.endTime = et;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	
}
