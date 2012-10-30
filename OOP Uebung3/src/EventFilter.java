import java.math.BigDecimal;

/**
 * @author Julian Grosshauser
 */


public class EventFilter implements Filter {
    /**
     * @return The sum of all finance object values in finances,
     * if their event attribute isn't null. [postcondition]
     * If it's a spending object, it's value will be subtracted from sum.
     * [postcondition]
     */
    @Override public BigDecimal filter(Finance[] finances) {
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

