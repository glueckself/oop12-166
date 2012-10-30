/**
 * Logging interface
 * Designed to be used as output and/or logging system.
 *
 * @author Srdjan Markovic
 */
interface Logger {
    /**
     * Increase depth.
     *
     * Logger object notices that messages come from name [postcondition]
     *
     * @param name Name of the level.
     */
    public void pushLevel(String name);

    /**
     * Decreases depth by one (=pops the last level).
     *
     * Logger returns to previous level [postcondition]
     */
    public void popLevel();

    /**
     * Displays/logs/sends the message.
     *
     * Logger processes message [postcondition]
     *
     * @param message Message to process, message != null [precondition]
     */
    public void addMessage(String message);
}
