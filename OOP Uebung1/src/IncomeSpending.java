import java.math.BigDecimal;

/**
 * Represents income if value is positiv or spending if value is negative.
 *
 * @author Julian Grosshauser
 */

public class IncomeSpending {
    private String identifier;
    private BigDecimal value;
    private Event event;

    /**
     * Default constructor.
     * You have to set an identifier and a value.
     * 
     * @param identifier Identifies this income/spending.
     * @param value Value of this income/spending.
     */
    public Finance(String identifier, BigDecimal value) {
	this.identifier = Identifier;
	this.value = value;
    }

    /**
     * With this constructor you can specify a certain event to which this
     * income/outcome belongs.
     * 
     * @param identifier Identifies this income/spending.
     * @param value Value of this income/spending.
     * @param event Income/Spending belongs to this event.
     */
    public Finance(String identifier, BigDecimal value, Event event) {
	this.identifier = identifier;
	this.value = value;

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
	return this.value;
    }

    /**
     * event getter.
     *
     * @return Event event to which this income/spending belongs.
     */
    public Event getEvent() {
	return this.event;
    }
}
