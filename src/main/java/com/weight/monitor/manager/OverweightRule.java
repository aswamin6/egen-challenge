package com.weight.monitor.manager;

import java.lang.annotation.Annotation;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.api.Rule;
import org.easyrules.core.BasicRule;

import com.weight.monitor.commons.Constants;

public class OverweightRule extends BasicRule{

	private int currentValue;
	private long timestamp;
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	@Override
	public boolean evaluate() {
		if(currentValue > Constants.BASE_VALUE * (1+Constants.ALERT_PERCENT/100))
			return true;
		return false;
	}
	
	@Override
	public void execute() {
	// trigger alert
		
	}
	
	@Override
	public String getName()
	{
		return Constants.OVERWEIGHT_RULENAME;
	}
}
