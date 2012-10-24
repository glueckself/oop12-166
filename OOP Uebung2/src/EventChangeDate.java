import java.io.Serializable;
import java.util.Date;

/**
 * Represents a change of the date in an event
 *
 * @author Alexander Huber
 */
public class EventChangeDate extends EventChange implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 *
	 * @param place if place has changed (ignored)
	 * @param date if date has changed
	 * @param duration if duration has changed (ignored)
	 * @param value if value has changed (ignored)
	 */
	public EventChangeDate(String place, Date date, Date duration) {
		super(null, date, null);
	}
	
	/**
	 * Format output for showing in change history
	 *
	 * @return String output
	 */
	public String toString() {
		return ("Date " + DateFormatter.toString(this.date,DateType.Date));
	}
}
