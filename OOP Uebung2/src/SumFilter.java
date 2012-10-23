import java.math.BigDecimal;

/**
 * Interface for filters of the getSum method of GroupMgmt.
 *
 * @author Julian Grosshauser
 */

interface SumFilter {
    /**
     * This filter method will be used different by all the different filter
     * classes.
     *
     * @return BigDecimal Filtered sum
     */
    BigDecimal filter();
}
