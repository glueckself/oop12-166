/**
 * Interface for super mega ModuleTest 5000 pseudo unit test system.
 * Class that uses this interface can use the constructor to get the object to
 * test (and store it private/...)
 *
 * @author Srdjan Markovic
 */
interface ModuleTest {
  /**
   * Returns the name of the test (for logs/UI/...)
   *
   * @return Name of the test
   */
  public String getName();

  /**
   * Returns a info message for a failed test.
   *
   * @return Message
   */
  public String getMessage();

  /**
   * Executes the test.
   *
   * @return true if test was successful, false if test failed.
   */
  public boolean runTest();
}
