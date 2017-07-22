package com.weight.monitor.service;

import java.util.List;

import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weight.monitor.commons.MongoUtil;
import com.weight.monitor.model.AlertDao;

@Service
public class AlertService {
	
	@Autowired
	MongoUtil util;
	
	public AlertService()
	{
		
	}
	
	public List<AlertDao> retrieveAll() {
		return util.getDatastore().createQuery(AlertDao.class)
                            .asList();
	}
	
	public List<AlertDao> retrieveByRange(long startTime, long endTime) {
		Query<AlertDao> q = util.getDatastore().createQuery(AlertDao.class);
		q.and( 
				q.criteria("timestamp").greaterThanOrEq(startTime), 
				q.criteria("timestamp").lessThanOrEq(endTime)
			);
		return q.asList();
	}
	
	public void add(AlertDao newAlert) {
		util.getDatastore().save(newAlert);
	}
}




