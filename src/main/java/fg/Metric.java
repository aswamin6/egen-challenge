package fg;

public class Metric {
	
	
	private long timestamp;
	private int value;
	
	public Metric()
	{
		
	}
	public Metric(long timestamp, int value) {
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
