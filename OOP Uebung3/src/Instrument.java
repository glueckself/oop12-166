import java.io.Serializable;

/**
 * Represents an Instrument
 *
 * @author Srdjan Markovic
 */
public class Instrument implements Serializable {
    private static final long serialVersionUID = 1L;
    private String _name;
    /**
     * Constructor
     *
     * @param name Name of the Instrument
     */
    public Instrument(String name) {
        _name=name;
        Serializer.get().serialize();
    }

    /**
     * Get method for name
     *
     * @return String Name of the Instrument
     */
    public String getName() {
        return _name;
    }
}

