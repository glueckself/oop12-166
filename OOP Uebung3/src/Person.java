import java.io.Serializable;
/**
 * Represents a Person.
 *
 * @author Alexander Huber
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String phone;
    private String message;
    Logger log;

    /**
     * creates a new Person [postcondition]
     * @param name != null [precondition]
     * @param phone != null [precondition]
     */
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
        Serializer.get().serialize();
        log = Test.getLogger(name);
    }

    /**
     * @return name [postcondition]
     */
    public String getName() {
        return this.name;
    }

    /**
     * NOTE: As this is only a simple implementation of a person, there are no invariants nor preconditions.
     * Advanced implementations could check for conflicts etc.
     * 
     * @param event != null [precondition]
     * @return true if person can attend the event, false if not. [postcondition]
     * @author Srdjan Markovic
     */
    public boolean notifyEvent(Event event) {
        log.addMessage("notified for Event: " +event.getPlace());
        message="";
        return true;
    }

    /**
     * notifyEvent failed [precondition]
     *
     * @return if notifyEvent was false, the messange, otherwise an empty string [postcondition]
     * @author Srdjan Markovic
     */
    public final String getMessage() {
        return message;
    }

    /**
     * @return phone number [postcondition]
     */
    public String getPhone() {
        return this.phone;
    }
}
