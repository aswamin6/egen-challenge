package com.weight.monitor.commons;

import org.easyrules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.weight.monitor.manager.OverweightRule;
import com.weight.monitor.manager.UnderweightRule;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

@Configuration
public class AlertRulesEngine {
	
	private OverweightRule overWeightRule;
	private UnderweightRule underWeightRule;
	private AlertsRuleListener listener = new AlertsRuleListener();
	private RulesEngine rulesEngine;	
	
	public AlertRulesEngine()
	{
		rulesEngine = aNewRulesEngine().withRuleListener(listener).build();
		overWeightRule = new OverweightRule();
		underWeightRule = new UnderweightRule();
		rulesEngine.registerRule(overWeightRule);
		rulesEngine.registerRule(underWeightRule);
	}

	public void fireRules()
	{
		rulesEngine.fireRules();
	}

	public OverweightRule getOverWeightRule() {
		return overWeightRule;
	}

	public void setOverWeightRule(OverweightRule overWeightRule) {
		this.overWeightRule = overWeightRule;
	}

	public UnderweightRule getUnderWeightRule() {
		return underWeightRule;
	}

	public void setUnderWeightRule(UnderweightRule underWeightRule) {
		this.underWeightRule = underWeightRule;
	}
	
}
