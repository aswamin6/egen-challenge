package fg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsManager {
	
	@Autowired
	private MetricService metricService;
	
	
	
	public void createMetric(Metric metric)
	{
		
		MetricDao metricDao = new MetricDao(metric.getTimestamp(),metric.getValue());
		metricService.add(metricDao);
		
		// do rules logic here

	}
	
	public List<Metric> readAllMetrics()
	{
		List<Metric> metricList = new ArrayList<Metric>();
		List<MetricDao> metricDaoList = metricService.retrieveAll();
		
		for(MetricDao metricDao: metricDaoList)
		{
			metricList.add(new Metric(metricDao.getTimestamp(),metricDao.getValue()));
		}
		return metricList;
	}
	
	public List<Metric> readByTimeRange(long startTime, long endTime){
		List<Metric> metricList = new ArrayList<Metric>();
		List<MetricDao> metricDaoList = metricService.getByRange(startTime, endTime);
	
		for(MetricDao metricDao: metricDaoList)
		{
			metricList.add(new Metric(metricDao.getTimestamp(),metricDao.getValue()));
		}
		return metricList;
	}

}
