package com.weight.monitor.commons;

import org.easyrules.api.Rule;
import org.easyrules.api.RuleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.weight.monitor.Main;
import com.weight.monitor.manager.AlertsManager;
import com.weight.monitor.manager.OverweightRule;
import com.weight.monitor.manager.UnderweightRule;
import com.weight.monitor.model.AlertDao;
import com.weight.monitor.service.AlertService;
import com.weight.monitor.service.MetricService;

@Configuration
public class AlertsRuleListener implements RuleListener {
	
	
	public AlertsRuleListener()
	{
	}

	@Override
	public boolean beforeEvaluate(Rule arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void beforeExecute(Rule arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFailure(Rule arg0, Exception arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSuccess(Rule rule) {		
		AlertDao alertDao ;
				
		if(rule instanceof OverweightRule)
		{
			OverweightRule owRule = (OverweightRule)rule;
			alertDao = new AlertDao(owRule.getName(), owRule.getTimestamp());
		}
		else if(rule instanceof UnderweightRule)
		{
			UnderweightRule uwRule = (UnderweightRule)rule;
			 alertDao = new AlertDao(uwRule.getName(), uwRule.getTimestamp());
		}
		else
		{
			return;
		}
		
		Main.ctx.getBean(AlertService.class).add(alertDao);
		
	}

}
