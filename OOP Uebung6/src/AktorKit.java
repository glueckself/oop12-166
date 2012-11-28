/**
 * AktorKit
 */

abstract class AktorKit {
    protected String name;
    protected int serialnumber;
    protected Aktor[] aktoren;
    
    /**
     * Check if android with an specific zertifikat is allowed to use this
     * aktorKit
     * @param android Android to check
     * @return AktorKit If allowed the aktorKit that this android requested, 
     * otherwise null
     */
    public abstract AktorKit allowed(Android android);

    /**
     * AktorKit name
     * @return String name
     */
    public String toString() {
	return name;
    }
}
