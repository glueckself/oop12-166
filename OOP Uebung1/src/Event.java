import java.util.Date;
import java.math.BigDecimal;

/**
 * Abstract class for storing an Event
 *
 * @author Alexander Huber
 */
public abstract class Event {
    private String place;
    private Date date;
    private Date duration;
    /**
     * Constructor
     *
     * @param place Place of the event
     * @param date Date of the event
     * @param duration Duration of the event
     */
    protected Event(String place, Date date, Date duration) {
        this.place = place;
        this.date = date;
        this.duration = duration;
    }

    /**
     * Get method for place
     *
     * @return String Place of the event
     */
    public String getPlace() {
        return this.place;
    }

    /**
     * Get method for date
     *
     * @return Date Date of the event
     */
    public Date getDate() {
        return (Date)this.date.clone();
    }

    /**
     * Get method for duration
     *
     * @return Date Duration of the event
     */
    public Date getDuration() {
        return (Date)this.duration.clone();
    }

    /**
     * abstract Get method for Value (in our case rent/salary)
     *
     * @return BigDecimal Value of the event
     */
    abstract BigDecimal getValue();

    /**
     * Compare two Event objects.
     *
     * @param event Event object to compare to.
     * @return boolean True if objects are equal, or false if objects are not
     * equal.
     */
     public boolean equals(Event event) {
	if(this.place != event.getPlace()) {
	    return false;
	}

	if(this.date.compareTo(event.getDate()) != 0) {
	    return false;
	}

	if(this.duration.compareTo(event.getDuration()) != 0) {
	    return false;
	}

	return true;
     }
}
