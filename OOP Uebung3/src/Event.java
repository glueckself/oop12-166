import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
/**
 * Abstract class for storing an Event
 * GOOD: We can add new forms of events with only small effort
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
     * creates a new, non-deleted, Event with an empty history [postcondition]
     * @param place != null [precondition]
     * @param date != null [precondition]
     * @param duration != null [precondition]
     */
    protected Event(String place, Date date, Date duration) {
        this.place = place;
        this.date = date;
        this.duration = duration;
        this.deleted = false;
        history = new ArrayList<EventChange>();
    }

    /**
     * @return String Place of the event [postcondition]
     */
    public String getPlace() {
        return this.place;
    }

    /**
     * @return Date Date of the event [postcondition]
     */
    public Date getDate() {
        return (Date)this.date.clone();
    }

    /**
     * @return Date Duration of the event[postcondition]
     */
    public Date getDuration() {
        return (Date)this.duration.clone();
    }

    /**
     * @param event != null [precondition]
     * @return boolean true if place, date and duration are equal, else false [postcondition]
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

    /**
     * marks this event as deleted if parameter is true, else as non-deleted [postcondition]
     */
    public void delete(boolean del) {
        this.deleted = del;
        Serializer.get().serialize();
    }

    /**
     * @return true if this event is marked as deleted, else false [postcondition]
     */
    public boolean isDeleted() {
        return this.deleted;
    }

    /**
     * stores old place in history and changes the actual place of this event [postcondition]
     * @param newPlace != null [precondition]
     */
    public void changePlace(String newPlace) {
        this.history.add(new EventChangePlace(this.place,null,null));
        this.place = newPlace;
        Serializer.get().serialize();
    }

    /**
     * stores old date in history and changes the actual date of this event [postcondition]
     * @param newDate != null [precondition]
     */
    public void changeDate(Date newDate) {
        this.history.add(new EventChangeDate(null,this.date,null));
        this.date = newDate;
        Serializer.get().serialize();
    }

    /**
     * stores old duration in history and changes the actual duration of this event [postcondition]
     * @param newDuration != null [precondition]
     */
    public void changeDuration(Date newDuration) {
        this.history.add(new EventChangeDuration(null,null,this.duration));
        this.duration = newDuration;
        Serializer.get().serialize();
    }

    /**
     * @return the history of this event [postcondition]
     */
    public ArrayList<EventChange> getHistory() {
        return this.history;
    }

    /**
     * index in bounds of the history size, else no action performed [precondition]
     * restores the desired entry from the history and removes it [postcondition]
     * BAD: should return boolean to indicate success or failure
     */
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

        this.history.remove(index);
    }
}
