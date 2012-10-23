import java.util.Date;

/**
 * Represents an Event as Practice
 *
 * @author Alexander Huber
 */
public class Practice extends Event {
    /**
     * Constructor
     *
     * @param place Place of the practice
     * @param date Date of the practice
     * @param duration Duration of the practice
     */
    public Practice(String place, Date date, Date duration) {
        super(place,date,duration);
    }
}
