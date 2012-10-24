import java.io.Serializable;
import java.util.Date;

/**
 * Represents an Event as Practice
 *
 * @author Alexander Huber
 */
public class Practice extends Event implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     *
     * @param place Place of the practice
     * @param date Date of the practice
     * @param duration Duration of the practice
     */
    public Practice(String place, Date date, Date duration) {
        super(place,date,duration);
        Serializer.get().serialize();
    }

    /**
     * Change rent for the practice and save old one in history
     *
     * @param double new rent for the event
     */
    /*
    public void changeValue(double newValue) {
    	this.history.add(new EventChangeValue(null,null,null,this.rent));
    	this.rent = newValue;
    	Serializer.get().serialize();
    }
    */
}
