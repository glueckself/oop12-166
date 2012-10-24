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
	protected double value = 0;
	
	
	/**
	 * Constructor
	 *
	 * @param place if place has changed (null if not changed)
	 * @param date if date has changed (null if not changed)
	 * @param duration if duration has changed (null if not changed)
	 * @param value if value has changed
	 */
    protected EventChange(String place, Date date, Date duration, double value) {
    	this.place = place;
    	this.date = date;
    	this.duration = duration;
    	this.value = value;
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
	 * Get method for value
	 *
	 * @return double change of the value
	 */
    public double getValue() {
    	return this.value;
    }
    
    /**
	 * Format output for showing in change history
	 *
	 * @return String output
	 */
    public abstract String toString();

}
