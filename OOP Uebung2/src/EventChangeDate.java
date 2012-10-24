import java.io.Serializable;
import java.util.Date;

/**
 * EventChangeDate
 * 
 * @author Alexander Huber
 */
public class EventChangeDate extends EventChange implements Serializable {
	private static final long serialVersionUID = 1L;
	public EventChangeDate(String place, Date date, Date duration, double value) {
		super(place, date, duration, value);
	}
	
	public String toString() {
		return ("Date " + DateFormatter.toString(this.date,DateType.Date));
	}
}
