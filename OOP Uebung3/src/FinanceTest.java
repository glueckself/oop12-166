import java.math.BigDecimal;

/**
 * Tests the getFinances and addFinance methods of Group and the getSum method
 * of GroupMgmt, plus all the filters.
 *
 * @author Julian Grosshauser
 */

public class FinanceTest implements ModuleTest {
    private final String name = "FinanceTest";
    private String message;
    private Group group;

    /**
     * Constructor.
     *
     * @param group Group to test.
     */
    public FinanceTest(Group group) {
        this.group = group;
    }

    /**
    * Returns the name of the test (for logs/UI/...)
    *
    * @return Name of the test
    */
    public String getName() {
        return this.name;
    }

    /**
    * Returns a info message for a failed test.
    *
    * @return Message
    */
    public String getMessage() {
        return this.message;
    }

    /**
    * Executes the test.
    *
    * @return True if test was successful, false if test failed.
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

        /**
         * First test:
         *
         * Testing addFinance and getFinances functionality.
         */
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

        /**
         * Second test:
         *
         * Return the sum of all finances.
         * The returned value should be -900.
         */
        returnValue = GroupMgmt.getSum(group,
                                       DateFormatter.toDate("25.10.2012 10:00", DateType.DateTime),
                                       DateFormatter.toDate("12.11.2012 00:00", DateType.DateTime));

        if(returnValue.compareTo(new BigDecimal("-900")) != 0) {
            this.message = "returned value is wrong";
            return false;
        }

        /**
         * Third test:
         *
         * Return the IncomeFilter filtered sum.
         * The returned value should be 1100.
         */
        returnValue = GroupMgmt.getSum(group,
                                       DateFormatter.toDate("25.10.2012 10:00", DateType.DateTime),
                                       DateFormatter.toDate("12.11.2012 00:00", DateType.DateTime),
                                       new IncomeFilter());

        if(returnValue.compareTo(new BigDecimal("1100")) != 0) {
            this.message = "returned value is wrong";
            return false;
        }

        /**
         * Forth test:
         *
         * Return the SpendingFilter filtered sum.
         * The returned value should be 2000.
         */
        returnValue = GroupMgmt.getSum(group,
                                       DateFormatter.toDate("25.10.2012 10:00", DateType.DateTime),
                                       DateFormatter.toDate("12.11.2012 00:00", DateType.DateTime),
                                       new SpendingFilter());

        if(returnValue.compareTo(new BigDecimal("2000")) != 0) {
            this.message = "returned value is wrong";
            return false;
        }

        /**
         * Fifth test:
         *
         * Return the EventFilter filtered sum.
         * The returned value should be -1400.
         */
        returnValue = GroupMgmt.getSum(group,
                                       DateFormatter.toDate("25.10.2012 10:00", DateType.DateTime),
                                       DateFormatter.toDate("12.11.2012 00:00", DateType.DateTime),
                                       new EventFilter());

        if(returnValue.compareTo(new BigDecimal("-1400")) != 0) {
            this.message = "returned value is wrong";
            return false;
        }

        /**
         * Fifth test:
         *
         * Return the EventFilter filtered sum.
         * Like the forth test, but the period of time is different.
         * The returned value should be 100.
         */
        returnValue = GroupMgmt.getSum(group,
                                       DateFormatter.toDate("10.11.2012 10:00", DateType.DateTime),
                                       DateFormatter.toDate("11.11.2012 00:00", DateType.DateTime),
                                       new EventFilter());

        if(returnValue.compareTo(new BigDecimal("100")) != 0) {
            this.message = "returned value is wrong";
            return false;
        }

        /**
         * Sixth test:
         *
         * Return the IncomeFilter filtered sum.
         * Like the third test, but the period of time is different.
         * The returned value should be 0, because there are no finances in
         * this period of time.
         */
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
