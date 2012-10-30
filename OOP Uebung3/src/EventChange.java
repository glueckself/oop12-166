
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
    	//creates a new EventChange [postcondition]
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
    	//returns the place, will be null if this is no EventChangePlace [postcondition]
        return this.place;
    }

    /**
     * Get method for date
     *
     * @return Date change of the date
     */
    public Date getDate() {
    	//returns the date, will be null if this is no EventChangeDate [postcondition]
        return this.date;
    }

    /**
     * Get method for duration
     *
     * @return Date change of the duration
     */
    public Date getDuration() {
    	//returns the duration, will be null if this is no EventChangeDuration [postcondition]
        return this.duration;
    }

    /**
     * Format output for showing in change history
     *
     * @return String output
     */
    public abstract String toString(); //returns the EventChange as String to be shown in a history

}
