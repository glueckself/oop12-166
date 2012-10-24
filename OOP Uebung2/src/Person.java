import java.io.Serializable;
/**
 * Represents a Person
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
     * Constructor
     *
     * @param name Name of the person
     * @param phone Phone number of the person
     */
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
        Serializer.get().serialize();
        log = Test.getLogger(name);
    }

    /**
     * Get method for name
     *
     * @return String Name of the person
     */
    public String getName() {
        return this.name;
    }

    public boolean notifyEvent(Event event) {
      log.addMessage("notified for Event: " +event.getPlace());
      return true;
    }

    public final String getMessage() {
      return message;
    }

    /**
     * Get method for name
     *
     * @return String Phone number of the person
     */
    public String getPhone() {
        return this.phone;
    }
}
