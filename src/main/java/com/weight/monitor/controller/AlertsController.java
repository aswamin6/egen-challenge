package com.weight.monitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weight.monitor.manager.AlertsManager;
import com.weight.monitor.manager.MetricsManager;
import com.weight.monitor.model.AlertTo;
import com.weight.monitor.model.MetricTo;
import com.weight.monitor.model.TimeRange;

@RestController
public class AlertsController {
	@Autowired
	private AlertsManager alertsManager;
	
	@RequestMapping("/alert/read")
	public List<AlertTo> readAlerts() {
		//read all documents from MongoDB
		return alertsManager.readAllAlerts();
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/alert/readbytimerange")
	public List<AlertTo> readAlertsByTime(@RequestBody TimeRange tr) {
		//read documents from MongoDB with constraint
		return alertsManager.readByTimeRange(tr.getStartTime(), tr.getEndTime());
	}
}
