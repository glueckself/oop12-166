import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * GOOD: We're using two seperate objects for income and spending, instead of
 * defining income as a Finance object with a positive value and defining a
 * spending as a Finace object with a negative value, because that's better for
 * reusability.
 *
 * @author Julian Grosshauser
 */

public abstract class Finance implements Serializable {
    private static final long serialVersionUID = 1L;
    private String identifier;
    private BigDecimal value;
    private Date date;
    private Event event;

    /**
     * @param value > 0 [preconditon]
     * ERROR: value > 0 isn't checked.
     * @return A new Finance object. [postcondition]
     */
    public Finance(String identifier, BigDecimal value, Date date) {
        this.identifier = identifier;
        this.value = value;
        this.date = date;
    }

    /**
     * @param value > 0 [precondition]
     * ERROR: value > 0 isn't checked.
     * @return A new Finance object, with a event attribute != null.
     * [postconditon]
     */
    public Finance(String identifier, BigDecimal value, Date date,
                   Event event) {

        this.identifier = identifier;
        this.value = value;
        this.date = date;
        this.event = event;
    }

    /**
     * @return identifier [postcondition]
     */
    public String getIdentifier() {
        return this.identifier;
    }

    /**
     * @return value [postcondition]
     */
    public BigDecimal getValue() {
        return this.value;
    }

    /**
     * @return event [postcondition]
     */
    public Event getEvent() {
        return this.event;
    }

    /**
     * @return date [postcondition]
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * @return true if every attribute of the finance objects are equal,
     * otherwise false [postcondition]
     * If both event attributes are null, then they are equal (this avoids
     * NullPointerExceptions) [postcondition]
     */
    public boolean equals(Finance finance) {
        if(this.identifier != finance.getIdentifier()) {
            return false;
        }

        if(this.value != finance.getValue()) {
            return false;
        }

        if(this.date.compareTo(finance.getDate()) != 0) {
            return false;
        }

        if(this.event == null && finance.getEvent() == null) {
            return true;
        }

        if(!this.event.equals(finance.getEvent())) {
            return false;
        }

        return true;
    }
}
