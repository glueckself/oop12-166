/**
 * Skin
 */

abstract class Skin {
    protected String name;
    protected int serialnumber;
	
    /**
     * Check if android is allowed to use this skin
     * @param android Android to check
     */
    public abstract void allowed(Bediener bediener);
    public abstract void allowed(Schwerarbeiter schwerarbeiter);
    public abstract void allowed(Beschuetzer beschuetzer);
    
    /**
     * Name of skin
     * @return String name
     */
    public String toString() {
    	return name;
    }
}
