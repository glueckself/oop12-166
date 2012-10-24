import java.math.BigDecimal;

/**
 * Interface for filters of the getSum method of GroupMgmt.
 *
 * @author Julian Grosshauser
 */

interface Filter {
    /**
     * This filter method will be used different by all the different filter
     * classes.
     *
     * @param finances Contains all finances to filter.
     * @return BigDecimal Filtered sum.
     */
    BigDecimal filter(Finance[] finances);
}
