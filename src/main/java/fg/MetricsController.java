package fg;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsController {
	
	@Autowired
	private MetricsManager metricsManager;
	
	@RequestMapping(method=RequestMethod.POST, value = "/createmetric")
	public void createMetric(@RequestBody Metric newMetric) {
		metricsManager.createMetric(newMetric);
	}
	
	@RequestMapping("/readmetrics")
	public List<Metric> readMetrics() {
		//read all documents from MongoDB
		return metricsManager.readAllMetrics();
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/readmetricbytime")
	public List<Metric> readMetricByTime(@RequestBody TimeRange tr) {
		//read documents from MongoDB with constraint
		return metricsManager.readByTimeRange(tr.getStartTime(), tr.getEndTime());
	}
		
}
