
import java.io.Serializable;
import java.util.Date;
/**
 * Abstract class for the type of the Change of an Event
 *
 * @author Alexander Huber
 */
public abstract class EventChange implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String place = null;
    protected Date date = null;
    protected Date duration = null;


    /**
     * Constructor
     *
     * @param place if place has changed (null if not changed)
     * @param date if date has changed (null if not changed)
     * @param duration if duration has changed (null if not changed)
     */
    protected EventChange(String place, Date date, Date duration) {
        this.place = place;
        this.date = date;
        this.duration = duration;
    }


    /**
     * Get method for place
     *
     * @return String change of the place
     */
    public String getPlace() {
        return this.place;
    }

    /**
     * Get method for date
     *
     * @return Date change of the date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Get method for duration
     *
     * @return Date change of the duration
     */
    public Date getDuration() {
        return this.duration;
    }

    /**
     * Format output for showing in change history
     *
     * @return String output
     */
    public abstract String toString();

}
