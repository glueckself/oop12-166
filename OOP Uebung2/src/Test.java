/**
 * Test program for the group managment system.
 *
 * @author Srdjan Markovic
 */
public class Test {
    public static void main(String[] args) {
        Logger output = new ConsoleLogger("main");
        Group group = new Group("Hansi Hinterseer","Death Metal");
        ModuleTest tests[] = new ModuleTest[4];

        /* Initialize tests here (and give them the right objects) */
        tests[0]=new EventTest(group); //event add/remove tests
        tests[1]=null; //event list/sum tests
        tests[2]=new Membertest(group); //member tests;
        tests[3]=new Songtest(group); //song tests;

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
            }
          } catch (Exception e) {
            System.err.println("CRITICAL ERROR: " +e.getMessage());
          }
          output.popLevel();
        }
    }

    public static Logger getLogger(String sender) {
      return new ConsoleLogger(sender);
    }
}
