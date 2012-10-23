import java.util.Date;
import java.math.BigDecimal;

/**
 * Represents an Event as Practice
 *
 * @author Alexander Huber
 */
public class Practice extends Event {
    private BigDecimal rent;
    /**
     * Constructor
     *
     * @param place Place of the practice
     * @param date Date of the practice
     * @param duration Duration of the practice
     * @param rent Rent of the room for practice
     */
    public Practice(String place, Date date, Date duration, BigDecimal rent) {
        super(place,date,duration);
        this.rent = rent;
    }

    /**
     * Get method for rent
     *
     * @return BigDecimal Rent of the room for practice
     */
    public BigDecimal getValue() {
        return this.rent;
    }
}
