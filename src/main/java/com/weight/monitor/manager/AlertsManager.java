package com.weight.monitor.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.weight.monitor.model.AlertDao;
import com.weight.monitor.model.AlertTo;
import com.weight.monitor.service.AlertService;

@Configuration
public class AlertsManager {
	
	@Autowired
	private AlertService alertService;
		
	public void createAlert(AlertTo alert)
	{
		// do rules logic here

	}
	
	public List<AlertTo> readAllAlerts()
	{
		List<AlertTo> alertList = new ArrayList<AlertTo>();
		List<AlertDao> alertDaoList = alertService.retrieveAll();
		
		for(AlertDao alertDao: alertDaoList)
		{
			alertList.add(new AlertTo(alertDao.getAlertType(), alertDao.getTimeStamp()));
		}
		return alertList;
	}
	
	public List<AlertTo> readByTimeRange(long startTime, long endTime){
		List<AlertTo> alertList = new ArrayList<AlertTo>();
		List<AlertDao> alertDaoList = alertService.retrieveByRange(startTime, endTime);
	
		for(AlertDao alertDao: alertDaoList)
		{
			alertList.add(new AlertTo(alertDao.getAlertType(), alertDao.getTimeStamp()));
		}
		return alertList;
	}
}
