package com.weight.monitor.commons;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;

@Configuration
public class MongoUtil {
	
	private Datastore datastore;
	
	public Datastore getDatastore() {
		return datastore;
	}

	public MongoUtil()
	{
		 String dbName = new String("local");
	     Morphia morphia = new Morphia();
	     datastore = morphia.createDatastore(new MongoClient(), dbName);      
	     datastore.ensureIndexes();
	     morphia.mapPackage("com.city81.mongodb.morphia.entity");	         
	}	
}
