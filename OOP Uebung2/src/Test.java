<<<<<<< HEAD
/**
 * Test program for the group managment system.
 *
 * @author Srdjan Markovic
 */
public class Test {
    public static void main(String[] args) {
        Group group = new Group("Hansi Hinterseer","Death Metal");
        ModuleTest tests[] = new ModuleTest[5];

        /* Initialize tests here (and give them the right objects) */
        tests[0]=new EventTest(group); //event add/remove tests
        tests[1]=new EventListTest(group); //event list tests
        tests[2]=new Membertest(group); //member tests;
        tests[3]=new Songtest(group); //song tests;
	tests[4]=new FinanceTest(group); //finance test

        for(int i=0; i<tests.length; i++) {
          if(tests[i] == null) {
            System.out.println("Missing test object for test #"+i+", skipping.");
            continue;
          }

          System.out.print("Running test: " + tests[i].getName()+"...");
          try {
            if(tests[i].runTest()) {
              System.out.println("passed.");
            } else {
              System.out.println("FAILED.");
              System.out.println(">> Error message: "+tests[i].getMessage());
            }
          } catch (Exception e) {
            System.out.println("CRITICAL ERROR: " +e.getMessage());
          }
        }
    }
}
=======
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
        ModuleTest tests[] = new ModuleTest[4];

        /* Initialize tests here (and give them the right objects)
         * WARNING: because EventTest needs Members to add notify about added
         * events, Membertest must run and succed before EventTest. */
        tests[0]=new Membertest(group); //member tests;
        tests[1]=new Songtest(group); //song tests;
        tests[2]=new EventTest(group); //event add/remove tests
        tests[3]=null; //event list/sum tests

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
     *
     * @param sender Name of the sender.
     * @return Object of type Logger
     */
    public static Logger getLogger(String sender) {
      return new ConsoleLogger(sender);
    }
}
>>>>>>> e2673fd32339372689a1bebd6325b6fd5767e638
