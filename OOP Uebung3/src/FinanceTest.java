import java.math.BigDecimal;

/**
 * BAD: This object tests both the finance and filter objects. It would be
 * better to to divide these two tests into seperate objects, this would
 * improve the class coherence.
 *
 * @author Julian Grosshauser
 */

public class FinanceTest implements ModuleTest {
    private final String name = "FinanceTest";
    private String message;
    private Group group;

    /**
     * @return New FinanceTest object [postcondition]
     */
    public FinanceTest(Group group) {
        this.group = group;
    }

    /**
    * @return name [postcondition]
    */
    public String getName() {
        return this.name;
    }

    /**
    * @return message [postcondition]
    */
    public String getMessage() {
        return this.message;
    }

    /**
     * @return true if all tests were successfull,
     * otherwise false. [postcondition]
     * If an error occurred,
     * message will be set according to the error. [postcondition]
    */
    public boolean runTest() {
        Finance[] returnedFinances;
        BigDecimal returnValue;

        Income income1= new Income("TestIncome1", new BigDecimal("1000"),
                                   DateFormatter.toDate("10.11.2012 17:00", DateType.DateTime));
        Income income2= new Income("TestIncome2", new BigDecimal("100"),
                                   DateFormatter.toDate("10.11.2012 18:00", DateType.DateTime),
                                   new Performance("TestPerformance",
                                           DateFormatter.toDate("10.11.2012 18:00", DateType.DateTime),
                                           DateFormatter.toDate("02:00", DateType.Time)));
        Spending spending1 = new Spending("TestSpending1", new BigDecimal("500"),
                                          DateFormatter.toDate("25.10.2012 15:00", DateType.DateTime));
        Spending spending2 = new Spending("TestSpending2", new BigDecimal("1500"),
                                          DateFormatter.toDate("25.10.2012 16:00", DateType.DateTime),
                                          new Practice("TestPractice",
                                                  DateFormatter.toDate("25.10.2012 16:00", DateType.DateTime),
                                                  DateFormatter.toDate("01:00", DateType.Time)));

        if(this.group == null) {
            this.message = "group is null";
            return false;
        }

        group.addFinance(income1);
        group.addFinance(income2);
        group.addFinance(spending1);
        group.addFinance(spending2);

        returnedFinances = group.getFinances();

        if(returnedFinances.length != 4) {
            this.message = "Number of returned finances is wrong";
            return false;
        }

        if(!returnedFinances[0].equals(income1)) {
            this.message = "Returned finance is wrong";
            return false;
        }

        if(!returnedFinances[1].equals(income2)) {
            this.message = "Returned finance is wrong";
            return false;
        }

        if(!returnedFinances[2].equals(spending1)) {
            this.message = "Returned finance is wrong";
            return false;
        }

        if(!returnedFinances[3].equals(spending2)) {
            this.message = "Returned finance is wrong";
            return false;
        }

        returnValue = GroupMgmt.getSum(group,
                                       DateFormatter.toDate("25.10.2012 10:00", DateType.DateTime),
                                       DateFormatter.toDate("12.11.2012 00:00", DateType.DateTime));

        if(returnValue.compareTo(new BigDecimal("-900")) != 0) {
            this.message = "returned value is wrong";
            return false;
        }

        returnValue = GroupMgmt.getSum(group,
                                       DateFormatter.toDate("25.10.2012 10:00", DateType.DateTime),
                                       DateFormatter.toDate("12.11.2012 00:00", DateType.DateTime),
                                       new IncomeFilter());

        if(returnValue.compareTo(new BigDecimal("1100")) != 0) {
            this.message = "returned value is wrong";
            return false;
        }

        returnValue = GroupMgmt.getSum(group,
                                       DateFormatter.toDate("25.10.2012 10:00", DateType.DateTime),
                                       DateFormatter.toDate("12.11.2012 00:00", DateType.DateTime),
                                       new SpendingFilter());

        if(returnValue.compareTo(new BigDecimal("2000")) != 0) {
            this.message = "returned value is wrong";
            return false;
        }

        returnValue = GroupMgmt.getSum(group,
                                       DateFormatter.toDate("25.10.2012 10:00", DateType.DateTime),
                                       DateFormatter.toDate("12.11.2012 00:00", DateType.DateTime),
                                       new EventFilter());

        if(returnValue.compareTo(new BigDecimal("-1400")) != 0) {
            this.message = "returned value is wrong";
            return false;
        }

        returnValue = GroupMgmt.getSum(group,
                                       DateFormatter.toDate("10.11.2012 10:00", DateType.DateTime),
                                       DateFormatter.toDate("11.11.2012 00:00", DateType.DateTime),
                                       new EventFilter());

        if(returnValue.compareTo(new BigDecimal("100")) != 0) {
            this.message = "returned value is wrong";
            return false;
        }

        returnValue = GroupMgmt.getSum(group,
                                       DateFormatter.toDate("10.11.2013 10:00", DateType.DateTime),
                                       DateFormatter.toDate("11.11.2013 00:00", DateType.DateTime),
                                       new IncomeFilter());

        if(returnValue.compareTo(new BigDecimal("0")) != 0) {
            this.message = "returned value is wrong";
            return false;
        }

        return true;
    }
}
