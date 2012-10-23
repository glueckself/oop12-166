import java.util.Date;
import java.math.BigDecimal;

/**
 * Represents an Event as Performance
 *
 * @author Alexander Huber
 */
public class Performance extends Event {
    private BigDecimal salary;
    /**
     * Constructor
     *
     * @param place Place of the performance
     * @param date Date of the performance
     * @param duration Duration of the performance
     * @param salary Salary of the performance
     */
    public Performance(String place, Date date, Date duration, BigDecimal salary) {
        super(place,date,duration);
        this.salary = salary;
    }

    /**
     * Get method for salary
     *
     * @return BigDecimal Salary of the performance
     */
    public BigDecimal getValue() {
        return this.salary;
    }
}
