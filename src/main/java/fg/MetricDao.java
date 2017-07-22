package fg;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value="Metric")
public class MetricDao  {
	
	@Id
	private ObjectId objectId;
	private long timestamp;
	private int value;
	
	public MetricDao()
	{
		
	}
	public MetricDao(long timestamp, int value) {
		this.timestamp = timestamp;
		this.value = value;
	}
	
	public int  getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
