import java.util.Stack;

/**
 * Relays output to System.out
 *
 * @author Srdjan Markovic
 */
class ConsoleLogger implements Logger {
    private String sender="";
    private Stack<String> levels;

    /**
     * creates stack [postcondition]
     * sender has default value "" [postcondition]
     */
    public ConsoleLogger() {
        this.levels = new Stack<String>();
    }

    /**
     * creates stack [postcondition]
     * sender is saved to this.sender [postcondition]
     *
     * @param sender Name of the sender. sender != null [precondition]
     */
    public ConsoleLogger(String sender) {
        this();
        this.sender=sender;
    }

    /**
     * name added to stack [postcondition]
     *
     * @param name Name of the level. name != null [precondition]. name != "" [precondition]
     */
    public void pushLevel(String name) {
      // ERROR: does not check if name is valid
        levels.push(name);
    }

    /**
     * removed last element from stack [postcondition]
     * throws EmptyStackException if stack was empty [postcondition]
     */
    public void popLevel() {
        levels.pop();
    }

    /**
     * sender, levels and message (in this order) printed to System.out [postcondition]
     *
     * NOTE: Format: sender: Level1->Level2->...->Leveln: Message
     *
     * @param message Message to be shown. message != "" [precondition]
     */
    public void addMessage(String message) {
      //ERROR: does not check if message is valid.
        System.out.print(sender+": ");
        for(int i=0; i<levels.size(); i++) {
            System.out.print(levels.elementAt(i));
            if(i==levels.size()-1)
                System.out.print(": ");
            else
                System.out.print("->");
        }
        System.out.println(message);
    }
}
