import java.io.Serializable;
import java.util.Date;


public class EventChangeDuration extends EventChange implements Serializable {
	private static final long serialVersionUID = 1L;
	public EventChangeDuration(String place, Date date, Date duration, double value) {
		super(place, date, duration, value);
	}
	
	public String toString() {
		return ("Duration " + DateFormatter.toString(this.duration,DateType.Time));
	}
}