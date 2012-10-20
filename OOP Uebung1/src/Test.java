import java.util.Date;

/**
 * Test program for the group managment system.
 *
 * @author Alexander Huber
 * @author Julian Grosshauser
 * @author Srdjan Markovic
 */
public class Test {
    public static void main(String[] args) {
        Group group = new Group("Hansi Hinterseer","Death Metal");
        ModuleTest tests[] = new ModuleTest[4];

        if(group == null) {
            System.err.println("Could not create group");
            return;
        }

        /* Initialize tests here (and give them the right objects) */
        tests[0]=null; //event add/remove tests
        tests[1]=null; //event list/sum tests
        tests[2]=null; //member tests;
        tests[3]=null; //song tests;

        for(int i=0; i<tests.length; i++) {
          if(tests[i] == null) {
            System.out.println("Missing test info for test #"+i+", skipping.");
            continue;
          }

          System.out.print("Running test: " + tests[i].getName()+"...");
          if(tests[i].runTest()) {
            System.out.println("OK");
          } else {
            System.out.println("Fehler");
          }
        }
    }
}
