package com.weight.monitor.manager;

import java.lang.annotation.Annotation;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.easyrules.core.BasicRule;

import com.weight.monitor.commons.Constants;

@Rule (name = Constants.UNDERWEIGHT_RULENAME)
public class UnderweightRule extends BasicRule {
	
	private long currentValue;
	private long timestamp;
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public long getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(long currentValue) {
		this.currentValue = currentValue;
	}

	@Override
	public boolean evaluate() {
		if(currentValue < Constants.BASE_VALUE*(1-Constants.ALERT_PERCENT/100))
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
		return Constants.UNDERWEIGHT_RULENAME;
	}

}
