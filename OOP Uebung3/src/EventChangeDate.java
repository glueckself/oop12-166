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
     * creates a new EventChangeDate [postcondition]
     * @param date != null, place and duration are ignored [precondition]
     */
    public EventChangeDate(String place, Date date, Date duration) {
        super(null, date, null);
    }

    /**
     * @return the EventChangeDate as String to be shown in a history
     */
    public String toString() {
        return ("Date " + DateFormatter.toString(this.date,DateType.Date));
    }
}
