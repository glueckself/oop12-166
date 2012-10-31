/**
 * Test program for the group managment system.
 *
 * @author Srdjan Markovic
 */
public class Test {
    public static void main(String[] args) {
        Logger output = new ConsoleLogger("main"); //we wan't to use the console

        Group group = new Group("Hansi Hinterseer","Death Metal");
        String errorMsg;
        ModuleTest tests[] = new ModuleTest[6];

        /* NOTE: Initialize tests here (and give them the right objects)
         * BAD: because EventTest needs Members to add notify about added
         * events, Membertest must run and succed before EventTest. */
        tests[0]=new Membertest(group); //member tests;
        tests[1]=new Songtest(group); //song tests;
        tests[2]=new EventTest(group); //event add/remove tests
        tests[3]=new EventListTest(group); //event list tests
        tests[4]=new FinanceTest(group); //finance tests
        tests[5]=new EventPlanerTest(group); // Event Planer Test

        //GOOD: Tests are processed with the same code, whatever test it is.
        for(int i=0; i<tests.length; i++) {
            if(tests[i] == null) {
                output.addMessage("Missing test object for test #"+i+", skipping.");
                continue;
            }

            output.pushLevel(tests[i].getName());
            try {
                if(tests[i].runTest()) {
                    output.addMessage("successful");
                } else {
                    output.addMessage("FAILED");

                    //message handling in old style
                    errorMsg=tests[i].getMessage();
                    if(errorMsg == null) continue;
                    if(errorMsg.equals("")) continue;

                    output.pushLevel("Message");
                    output.addMessage(errorMsg);
                    output.popLevel();
                }
            } catch (Exception e) {
                System.err.println("CRITICAL ERROR: " +e.getMessage());
            }
            output.popLevel();
        }
    }

    /**
     * Factory-method for Logger objects.
     * This method is used to choose/configure logger before it's returned.
     * GOOD: This class decides what output is used throughout the program.
     *
     * @param sender Name of the sender, sender != null [precondition]
     * @return Initialized object of type Logger [postcondition]
     */
    public static Logger getLogger(String sender) {
        return new ConsoleLogger(sender);
    }

    /**
     * Factory method for Loggers used by Test objects.
     *
     * @param sender Name of the sender, sender != null [precondition]
     * @return Initialized object of type Logger [postcondition]
     */
    public static Logger getTestLogger(String sender) {
        return new ConsoleLogger(sender);
    }

}
