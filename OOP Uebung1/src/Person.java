/**
 * Represents a Person
 *
 * @author Alexander Huber
 */
public class Person {
    private String name;
    private String phone;

    /**
     * Constructor
     *
     * @param name Name of the person
     * @param phone Phone number of the person
     */
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    /**
     * Get method for name
     *
     * @return String Name of the person
     */
    public String getName() {
        return this.name;
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
