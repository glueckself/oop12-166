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
     * Constructor.
     *
     * @param name Name of the person
     * @param phone Phone number of the person
     */
    public Person(String name, String phone) {
    	//name != null, phone != null [precondition]
    	//creates a new Person [postcondition]
        this.name = name;
        this.phone = phone;
        Serializer.get().serialize();
        log = Test.getLogger(name);
    }

    /**
     * Get method for name.
     *
     * @return String Name of the person
     */
    public String getName() {
    	//returns name [postcondition]
        return this.name;
    }

    /**
     * Notifies about new events.
     *
     * NOTE: As this is only a simple implementation of a person, there are no invariants nor preconditions.
     * Advanced implementations could check for conflicts etc.
     * 
     * @param event Event that the Person should attend.
     * @return true if person can attend the event, false if not. [postcondition]
     * @author Srdjan Markovic
     */
    public boolean notifyEvent(Event event) {
        log.addMessage("notified for Event: " +event.getPlace());
        message="";
        return true;
    }

    /**
     * Returns a message explaining why a Person can't attend a event.
     *
     * notifyEvent failed [precondition]
     *
     * @return if notifyEvent was false, the messange, otherwise an empty string [postcondition]
     * @author Srdjan Markovic
     */
    public final String getMessage() {
        return message;
    }

    /**
     * Get method for name.
     *
     * @return String Phone number of the person
     */
    public String getPhone() {
    	//returns phone number [postcondition]
        return this.phone;
    }
}
