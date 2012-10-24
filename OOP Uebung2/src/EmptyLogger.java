/**
 * This logger is used to disable output.
 * 
 * @author Srdjan Markovic
 */
class EmptyLogger implements Logger {
  /**
   * Does nothing.
   *
   * @param name not used.
   */
  public void pushLevel(String name) {
    return;
  }
  
  /**
   * Does nothing.
   */
  public void popLevel() {
    return;
  }

  /**
   * Does nothing.
   * 
   * @param message not used.
   */
  public void addMessage(String message) {
    return;
  }
}
