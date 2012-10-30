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
    	//place != null, date != null, duration != null [precondition]
    	//creates an event as Performance [postcondition]
        super(place,date,duration);
        Serializer.get().serialize();
    }
}
