import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Represents income.
 *
 * @author Julian Grosshauser
 */

public class Income extends Finance implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Default constructor.
     * You have to set an identifier, a value and a date.
     *
     * @param identifier Identifies this income/spending.
     * @param value Value of this income/spending.
     * @param date Date of this income/spending.
     */
    public Income(String identifier, BigDecimal value, Date date) {
        super(identifier, value, date);
    }

    /**
     * With this constructor you can specify a certain event to which this
     * income/outcome belongs.
     *
     * @param identifier Identifies this income/spending.
     * @param value Value of this income/spending.
     * @param date Date of this income/spending.
     * @param event Income/Spending belongs to this event.
     */
    public Income(String identifier, BigDecimal value, Date date,
                  Event event) {

        super(identifier, value, date, event);
    }
}
