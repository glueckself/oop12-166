import java.io.Serializable;
import java.util.Date;

/**
 * Represents a change of the duration in an event
 *
 * @author Alexander Huber
 */
public class EventChangeDuration extends EventChange implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 *
	 * @param place if place has changed (ignored)
	 * @param date if date has changed (ignored)
	 * @param duration if duration has changed
	 * @param value if value has changed (ignored)
	 */
	public EventChangeDuration(String place, Date date, Date duration) {
		super(null, null, duration);
	}
	
	/**
	 * Format output for showing in change history
	 *
	 * @return String output
	 */
	public String toString() {
		return ("Duration " + DateFormatter.toString(this.duration,DateType.Time));
	}
}