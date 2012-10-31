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
     * creates a new EventChangePlace [postcondition]
     * @param place != null, date and duration are ignored [precondition]
     */
    public EventChangePlace(String place, Date date, Date duration) {
        super(place, null, null);
    }

    /**
     * @return the EventChangePlace as String to be shown in a history
     */
    public String toString() {
        return ("Place " + this.place);
    }
}
