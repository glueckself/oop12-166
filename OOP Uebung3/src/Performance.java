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
     * creates an event as Performance [postcondition]
     * @param place != null [precondition]
     * @param date != null [precondition]
     * @param duration != null [precondition]
     */
    public Performance(String place, Date date, Date duration) {
        super(place,date,duration);
        Serializer.get().serialize();
    }
}
