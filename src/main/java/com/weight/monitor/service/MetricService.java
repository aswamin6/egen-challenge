package com.weight.monitor.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.MorphiaIterator;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.weight.monitor.commons.MongoUtil;
import com.weight.monitor.model.MetricDao;


//stereotype spring framework business service
@Service
public class MetricService {
	@Autowired
	MongoUtil util;
	
	public List<MetricDao> retrieveAll() {
		return util.getDatastore().createQuery(MetricDao.class)
                            .asList();
	}
	
	public List<MetricDao> retrieveByRange(long startTime, long endTime) {
		Query<MetricDao> q = util.getDatastore().createQuery(MetricDao.class);
		q.and( 
				q.criteria("timestamp").greaterThanOrEq(startTime), 
				q.criteria("timestamp").lessThanOrEq(endTime)
			);
		return q.asList();
	}
	
	public void add(MetricDao newMetric) {
		util.getDatastore().save(newMetric);
	}
}
