import java.io.Serializable;
import java.util.Date;

/**
 * Represents a change of the place in an event
 *
 * @author Alexander Huber
 */
public class EventChangePlace extends EventChange implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 *
	 * @param place if place has changed
	 * @param date if date has changed (ignored)
	 * @param duration if duration has changed (ignored)
	 * @param value if value has changed (ignored)
	 */
	public EventChangePlace(String place, Date date, Date duration, double value) {
		super(place, null, null, 0);
	}
	
	/**
	 * Format output for showing in change history
	 *
	 * @return String output
	 */
	public String toString() {
		return ("Place " + this.place);
	}
}
