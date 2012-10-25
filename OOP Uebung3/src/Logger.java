/**
 * Logging interface
 * Designed to be used as output and/or logging system.
 *
 * This interface does not require to supply information about the sender.
 * If your implementation requires it, feel free to get it somehow.
 *
 * @author Srdjan Markovic
 */
interface Logger {
    /**
     * Can be used to increase depth of messages
     * (e.g. method1:method2:method3:place1:message)
     *
     * @param name Name of the level.
     */
    public void pushLevel(String name);

    /**
     * Decreases depth by one (=pops the last level)
     */
    public void popLevel();

    /**
     * Displays/logs/sends/... the message.
     *
     * @param message Message to process.
     */
    public void addMessage(String message);
}
