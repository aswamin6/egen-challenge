package com.weight.monitor.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.weight.monitor.commons.AlertRulesEngine;
import com.weight.monitor.commons.AlertsRuleListener;
import com.weight.monitor.model.MetricDao;
import com.weight.monitor.model.MetricTo;
import com.weight.monitor.service.MetricService;

@Configuration
public class MetricsManager {
	
	@Autowired
	private MetricService metricService;
	
	@Autowired
	private AlertRulesEngine ruleEngine;
	
	
	public MetricsManager()
	{
	
	}
		
	public void createMetric(MetricTo metric)
	{
		MetricDao metricDao = new MetricDao(metric.getTimeStamp(),metric.getValue());
		metricService.add(metricDao);
		
		ruleEngine.getUnderWeightRule().setCurrentValue(metric.getValue());
		ruleEngine.getUnderWeightRule().setTimestamp(metric.getTimeStamp());

		ruleEngine.getOverWeightRule().setCurrentValue(metric.getValue());
		ruleEngine.getOverWeightRule().setTimestamp(metric.getTimeStamp());

		ruleEngine.fireRules();
		
		
		// do rules logic here
	}
	
	public List<MetricTo> readAllMetrics()
	{
		List<MetricTo> metricList = new ArrayList<MetricTo>();
		List<MetricDao> metricDaoList = metricService.retrieveAll();
		
		for(MetricDao metricDao: metricDaoList)
		{
			metricList.add(new MetricTo(metricDao.getTimeStamp(),metricDao.getValue()));
		}
		return metricList;
	}
	
	public List<MetricTo> readByTimeRange(long startTime, long endTime){
		List<MetricTo> metricList = new ArrayList<MetricTo>();
		List<MetricDao> metricDaoList = metricService.retrieveByRange(startTime, endTime);
	
		for(MetricDao metricDao: metricDaoList)
		{
			metricList.add(new MetricTo(metricDao.getTimeStamp(),metricDao.getValue()));
		}
		return metricList;
	}

}
