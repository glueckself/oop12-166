import java.math.BigDecimal;

/**
 * This filter returns only finances that belong to a event.
 *
 * @author Julian Grosshauser
 */


public class EventFilter implements Filter {
    /**
     * Returns the sum of all finance values that belong to a event.
     * If its a spending, it will be subtracted.
     *
     * @param events Contains all finances to filter.
     * @return BigDecimal Sum.
     */
    @Override public BigDecimal filter(Finance[] finances) {
	BigDecimal sum = new BigDecimal("0");

	for(Finance finance : finances) {
	    /* Incomes are Income objects */
	    if(finance.getEvent() != null) {
		if(finance instanceof Spending) {
		    sum = sum.subtract(finance.getValue());
		} else {
		    sum = sum.add(finance.getValue());
		}
	    }
	}

	return sum;
    }
}

