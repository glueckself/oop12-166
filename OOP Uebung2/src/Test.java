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
