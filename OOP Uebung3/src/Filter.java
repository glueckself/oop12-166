import java.math.BigDecimal;

/**
 * GOOD: By using a Filter interface that all different Filter classes use,
 * we can later use dynamic binding to improve the code maintainability.
 *
 * @author Julian Grosshauser
 */

interface Filter {
    BigDecimal filter(Finance[] finances);
}
