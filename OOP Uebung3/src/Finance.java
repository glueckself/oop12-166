import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents income or spending.
 * GOOD: I'm using two seperate objects for income and spending, instead of
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
     * Default constructor.
     * You have to set an identifier, a value and a date.
     *
     * @param identifier Identifies this income/spending.
     * @param value Value of this income/spending.
     * @param date Date of this income/spending.
     */
    public Finance(String identifier, BigDecimal value, Date date) {
	// value > 0 [precondition]
        this.identifier = identifier;
        this.value = value;
        this.date = date;
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
    public Finance(String identifier, BigDecimal value, Date date,
                   Event event) {

	// value > 0 [precondition]
        this.identifier = identifier;
        this.value = value;
        this.date = date;
        this.event = event;
    }

    /**
     * identifier getter.
     *
     * @return String identifier of this income/spending.
     */
    public String getIdentifier() {
        return this.identifier;
    }

    /**
     * value getter.
     *
     * @return BigDecimal value of this income/spending.
     */
    public BigDecimal getValue() {
	//returns value [postcondition]
        return this.value;
    }

    /**
     * event getter.
     *
     * @return Event event to which this income/spending belongs.
     */
    public Event getEvent() {
	//returns event [postcondition]
        return this.event;
    }

    /**
     * date getter.
     *
     * @return Date date of this income/spending.
     */
    public Date getDate() {
	//return date [postcondition]
        return this.date;
    }

    /**
     * Compare to Finance objects.
     *
     * @param finance Finance object to compare to.
     * @return boolean True if objects are equal, or false if objects are not
     * equal.
     */
    public boolean equals(Finance finance) {
	// returns true if every attribute of the finance objects are equal,
	// otherwise false [postcondition]
	// if both event attributes are null, then they are equal (this avoids
	// NullPointerExceptions) [postcondition]
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