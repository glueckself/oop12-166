import java.util.Stack;

/**
 * Uses System.out as destination for output.
 * 
 * @author Srdjan Markovic
 */
class ConsoleLogger implements Logger{
  private String sender="";
  private Stack<String> levels;

  /**
   * Constructor for ConsoleLogger.
   * Creates an unnamed logger.
   */
  public ConsoleLogger() {
    this.levels = new Stack<String>();
  }

  /**
   * Proper constuctor for ConsoleLogger
   *
   * @param sender name of the sender
   */
  public ConsoleLogger(String sender) {
    this();
    this.sender=sender;
  }

  /**
   * Adds {@see name} to stack.
   *
   * @param name Name of the level.
   */
  public void pushLevel(String name) {
    levels.push(name);
  }

  /**
   * Pops the last item from stack and discards it.
   */
  public void popLevel() {
    levels.pop();
  }

  /**
   * Displays the sender's name, all items of the level stack and the message.
   * Format: sender: Level1->Level2->...->Leveln: Message
   *
   * @param message Message to be shown.
   */
  public void addMessage(String message) {
    System.out.print(sender+": ");
    for(int i=0;i<levels.size();i++) {
      System.out.print(levels.elementAt(i));
      if(i==levels.size()-1)
        System.out.print(": ");
      else
        System.out.print("->");
    }
    System.out.println(message);
  }
}
