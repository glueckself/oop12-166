import java.io.Serializable;
import java.util.Date;

/**
 * Represents an Event as Performance
 *
 * @author Alexander Huber
 */
public class Performance extends Event implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     *
     * @param place Place of the performance
     * @param date Date of the performance
     * @param duration Duration of the performance
     */
    public Performance(String place, Date date, Date duration) {
        super(place,date,duration);
        Serializer.get().serialize();
    }

    /**
     * Change salary for the performance and save old one in history
     *
     * @param double new salary for the event
     */
    /*
    public void changeValue(double newValue) {
    	this.history.add(new EventChangeValue(null,null,null,this.salary));
    	this.salary = newValue;
    	Serializer.get().serialize();
    }
    */
}