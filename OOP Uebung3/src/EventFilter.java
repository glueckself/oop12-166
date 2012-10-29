import java.math.BigDecimal;

/**
 * This filter returns only finances that belong to a event.
 *
 * @author Julian Grosshauser
 */


public class EventFilter implements Filter {
    /**
     * Returns the sum of all finance values that belong to a event.
     *
     * @param events Contains all finances to filter.
     * @return BigDecimal Sum.
     */
    @Override public BigDecimal filter(Finance[] finances) {
	//returns the sum of all finance object values in finances, if their
	//event attribute isn't null [postcondition]
	//if it's a spending object, it's value will be subtracted from sum
	//[postcondition]
        BigDecimal sum = new BigDecimal("0");

        for(Finance finance : finances) {
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

