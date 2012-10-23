import java.io.Serializable;
import java.util.Date;


public class EventChangeValue extends EventChange implements Serializable {
	private static final long serialVersionUID = 1L;
	public EventChangeValue(String place, Date date, Date duration, double value) {
		super(place, date, duration, value);
	}
	
	public String toString() {
		return ("Value " + value);
	}
}
