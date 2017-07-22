package com.weight.monitor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weight.monitor.commons.AlertRulesEngine;
import com.weight.monitor.manager.MetricsManager;
import com.weight.monitor.model.MetricTo;
import com.weight.monitor.model.TimeRange;

@RestController
public class MetricsController {
	
	@Autowired
	private MetricsManager metricsManager;
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/metric/create")
	public void createMetric(@RequestBody MetricTo newMetric) {
		metricsManager.createMetric(newMetric);
		
	}
	
	@RequestMapping("/metric/read")
	public List<MetricTo> readMetrics() {
		return metricsManager.readAllMetrics();
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/metric/readbyrange")
	public List<MetricTo> readMetricByTime(@RequestBody TimeRange tr) {
		return metricsManager.readByTimeRange(tr.getStartTime(), tr.getEndTime());
	}
		
}
