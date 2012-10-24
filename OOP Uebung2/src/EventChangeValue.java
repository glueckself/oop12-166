import java.io.Serializable;
import java.util.Date;

/**
 * Represents a change of the value in an event
 *
 * @author Alexander Huber
 */
public class EventChangeValue extends EventChange implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 *
	 * @param place if place has changed (ignored)
	 * @param date if date has changed (ignored)
	 * @param duration if duration has changed (ignored)
	 * @param value if value has changed
	 */
	public EventChangeValue(String place, Date date, Date duration, double value) {
		super(null, null, null, value);
	}
	
	/**
	 * Format output for showing in change history
	 *
	 * @return String output
	 */
	public String toString() {
		return ("Value " + value);
	}
}
