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
     * creates a new EventChangeDuration [postcondition]
     * @param duration != null, place and date are ignored [precondition]
     */
    public EventChangeDuration(String place, Date date, Date duration) {
        super(null, null, duration);
    }

    /**
     * @return the EventChangeDuration as String to be shown in a history
     */
    public String toString() {
        return ("Duration " + DateFormatter.toString(this.duration,DateType.Time));
    }
}
