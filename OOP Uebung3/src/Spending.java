import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Julian Grosshauser
 */

public class Spending extends Finance implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * @param value > 0 [precondition]
     * ERROR: value > 0 isn't checked.
     * @return A new Finance object. [postconditon]
     */
    public Spending(String identifier, BigDecimal value, Date date) {
        super(identifier, value, date);
    }

    /**
     * @param value > 0 [precondition]
     * ERROR: value > 0 isn't checked.
     * @return A new Finance object, with a defined event attribute.
     * [postconditon]
     */
    public Spending(String identifier, BigDecimal value, Date date,
                    Event event) {

        super(identifier, value, date, event);
    }
}
