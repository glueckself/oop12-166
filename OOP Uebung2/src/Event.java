import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
/**
 * Abstract class for storing an Event
 *
 * @author Alexander Huber
 */
public abstract class Event implements Serializable {
	private static final long serialVersionUID = 1L;
    private String place;
    private Date date;
    private Date duration;
    private boolean deleted;
    protected ArrayList<EventChange> history = null;
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
        this.deleted = false;
        history = new ArrayList<EventChange>();
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
     * @return double Value of the event
     */
    abstract double getValue();
    
    /**
     * Mark event as deleted
     */
    public void delete(boolean del) {
    	this.deleted = del;
    	Serializer.get().serialize();
    }
    
    /**
     * check if event is deleted
     *
     * @return boolean status of the event
     */
    public boolean isDeleted() {
    	return this.deleted;
    }
    
    /**
     * Change Place for the event and save old one in history
     *
     * @param String new Place for the event 
     */
    public void changePlace(String newPlace) {
    	this.history.add(new EventChangePlace(this.place,null,null,0));
    	this.place = newPlace;
    	Serializer.get().serialize();
    }
    
    /**
     * Change Date for the event and save old one in history
     *
     * @param Date new Date for the event 
     */
    public void changeDate(Date newDate) {
    	this.history.add(new EventChangeDate(null,this.date,null,0));
    	this.date = newDate;
    	Serializer.get().serialize();
    }
    
    /**
     * Change Duration for the event and save old one in history
     *
     * @param Date new Duration for the event 
     */
    public void changeDuration(Date newDuration) {
    	this.history.add(new EventChangeDuration(null,null,this.duration,0));
    	this.duration = newDuration;
    	Serializer.get().serialize();
    }
    
    /**
     * abstract Change value for the event and save old one in history
     *
     * @param double new value for the event 
     */
    abstract void changeValue(double newValue);
    
    /**
     * get change history
     *
     * @return ArrayList<EventChange> change history
     */
    public ArrayList<EventChange> getHistory() {
    	return this.history;
    }
    
    public void revert(int index) {
    	if(index >= this.history.size()) return;
    	EventChange change = this.history.get(index);
    	if(change.getPlace() !=  null) {
    		this.changePlace(change.getPlace());
    	}
    	else if(change.getDate() !=  null) {
    		this.changeDate(change.getDate());
    	}
    	else if(change.getDuration() !=  null) {
    		this.changeDuration(change.getDuration());
    	}
    	else {
    		this.changeValue(change.getValue());
    	}
    	this.history.remove(index);
    }
}
