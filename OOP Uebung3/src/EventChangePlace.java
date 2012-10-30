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
     */
    public EventChangePlace(String place, Date date, Date duration) {
    	//place should not be null, date and duration are ignored [precondition]
    	//creates a new EventChangePlace [postcondition]
        super(place, null, null);
    }

    /**
     * Format output for showing in change history
     *
     * @return String output
     */
    public String toString() {
    	//returns the EventChangePlace as String to be shown in a history
        return ("Place " + this.place);
    }
}
