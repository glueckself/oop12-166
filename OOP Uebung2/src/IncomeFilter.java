import java.math.BigDecimal;

public class IncomeFilter implements SumFilter {
  public BigDecimal filter() {
    return new BigDecimal(0);
  }

}
