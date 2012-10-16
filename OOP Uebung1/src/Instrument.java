/**
 * Represents an Instrument
 *
 * @author Srdjan Markovic
 */
public class Instrument {
    private String _name;
    /**
     * Constructor
     *
     * @param name Name of the Instrument
     */
    public Instrument(String name) {
        _name=name;
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

