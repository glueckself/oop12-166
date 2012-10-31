/**
 * Interface for super mega ModuleTest 5000 pseudo unit test system.
 *
 * NOTE: Precondition/invariant cannot be asserted because the interface
 * does not specify if/how the test will get its test object.
 *
 * @author Srdjan Markovic
 */
interface ModuleTest {
    /**
     * Returns the name of the test (for logs/UI/...).
     *
     * @return Name of the test [postcondition]
     */
    public String getName();

    /**
     * [DEPRICATED] Returns a info message for a failed test.
     * While it is still supported, it shouldn't be used anymore and
     * should return an empty String or null.
     *
     * @return Last message or null [postcondition]
     */
    public String getMessage();

    /**
     * Executes the test.
     *
     * NOTE: preconditions cannot be asserted because the interface does not
     * know anything about the test it will do.
     *
     * @return true if test was successful, false if test failed. [postcondition]
     */
    public boolean runTest();
}
