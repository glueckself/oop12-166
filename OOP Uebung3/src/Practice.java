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
     * creates an event as Practice [postcondition]
     * @param place != null [precondition]
     * @param date != null [precondition]
     * @param duration != null [precondition]
     */
    public Practice(String place, Date date, Date duration) {
        super(place,date,duration);
        Serializer.get().serialize();
    }
}
