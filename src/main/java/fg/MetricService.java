package fg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.MorphiaIterator;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


//stereotype spring framework business service
@Service
public class MetricService {
	private static Datastore datastore;
	
	static
	{
		 String dbName = new String("local");
	     Morphia morphia = new Morphia();
	     datastore = morphia.createDatastore(new MongoClient(), dbName);      
	     datastore.ensureIndexes();
	     morphia.mapPackage("com.city81.mongodb.morphia.entity");	         
	}
	
	public List<MetricDao> retrieveAll() {
		return datastore.createQuery(MetricDao.class)
                            .asList();
	}
	
	public List<MetricDao> getByRange(long startTime, long endTime) {
		Query<MetricDao> q = datastore.createQuery(MetricDao.class);
		q.and( 
				q.criteria("timestamp").greaterThanOrEq(startTime), 
				q.criteria("timestamp").lessThanOrEq(endTime)
			);
		return q.asList();
	}
	
	public void add(MetricDao newMetric) {
		datastore.save(newMetric);
	}

	
}
