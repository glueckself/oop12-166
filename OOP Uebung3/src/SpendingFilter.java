import java.math.BigDecimal;

/**
 * @author Julian Grosshauser
 */

public class SpendingFilter implements Filter {
    /**
     * @return The sum of all spending object values in finances.
     * [postcondition]
     */
    @Override public BigDecimal filter(Finance[] finances) {
        BigDecimal sum = new BigDecimal("0");

        for(Finance finance : finances) {
            if(finance instanceof Spending) {
                sum = sum.add(finance.getValue());
            }
        }

        return sum;
    }
}
