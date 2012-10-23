import java.util.Date;

/**
 * Represents an Event as Performance
 *
 * @author Alexander Huber
 */
public class Performance extends Event {
    /**
     * Constructor
     *
     * @param place Place of the performance
     * @param date Date of the performance
     * @param duration Duration of the performance
     */
    public Performance(String place, Date date, Date duration) {
        super(place,date,duration);
    }
}
