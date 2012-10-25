import java.math.BigDecimal;

/**
 * This filter returns the sum of only the spendings.
 *
 * @author Julian Grosshauser
 */


public class SpendingFilter implements Filter {
    /**
     * Returns the sum of all spending values.
     *
     * @param events Contains all finances to filter.
     * @return BigDecimal Sum.
     */
    @Override public BigDecimal filter(Finance[] finances) {
        BigDecimal sum = new BigDecimal("0");

        for(Finance finance : finances) {
            /* Incomes are Income objects */
            if(finance instanceof Spending) {
                sum = sum.add(finance.getValue());
            }
        }

        return sum;
    }
}
