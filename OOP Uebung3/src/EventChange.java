
import java.io.Serializable;
import java.util.Date;
/**
 * Abstract class for the type of the Change of an Event
 * GOOD: the string shown to the user in the history is defined by each type of
 * EventChange itself, no need for a big if/else or switch distinction to
 * show the history of all the different changes properly.
 * GOOD: New types of EventChanges can be added with only small effort.
 *
 * @author Alexander Huber
 */
public abstract class EventChange implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String place = null;
    protected Date date = null;
    protected Date duration = null;


    /**
     * creates a new EventChange [postcondition]
     */
    protected EventChange(String place, Date date, Date duration) {
        this.place = place;
        this.date = date;
        this.duration = duration;
    }


    /**
     * @return the place, will be null if this is no EventChangePlace [postcondition]
     */
    public String getPlace() {
        return this.place;
    }

    /**
     * @return the date, will be null if this is no EventChangeDate [postcondition]
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * @return the duration, will be null if this is no EventChangeDuration [postcondition]
     */
    public Date getDuration() {
        return this.duration;
    }

    /**
     * @return the EventChange as String to be shown in a history
     */
    public abstract String toString();

}
