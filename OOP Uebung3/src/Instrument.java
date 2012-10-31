import java.io.Serializable;

/**
 * Represents an Instrument.
 *
 * A object representing an instrument [postcondition]
 *
 * @author Srdjan Markovic
 */
public class Instrument implements Serializable {
    private static final long serialVersionUID = 1L;
    private String _name;
    /**
     * Constructor
     *
     * @param name Name of the Instrument, name != null, name != "" [precondition]
     */
    public Instrument(String name) {
        _name=name;
        Serializer.get().serialize();
    }

    /**
     * Get method for name
     *
     * @return String Name of the Instrument [postcondition]
     */
    public String getName() {
        return _name;
    }
}

