/**
 * Software.
 * Has to use the right Zertifikat
 */

abstract class Software {
    protected Zertifikat zertifikat;
    protected String name;
    protected int serialnumber;

    /**
     * Check if android is allowed to use this software
     * @param android Android to check
     */
    public abstract void allowed(Hilfskraft hilfskraft);
    public abstract void allowed(Gesellschafter gesellschafter);
    public abstract void allowed(Bauarbeiter bauarbeiter);
    public abstract void allowed(ServiceTechniker serviceTechniker);
    public abstract void allowed(Transportarbeiter transportarbeiter);
    public abstract void allowed(Objektbewacher objektbewacher);
    public abstract void allowed(Leibwaechter leibwaechter);
    public abstract void allowed(Kaempfer kaempfer);
    
    /**
     * Software name
     * @return String name
     */
    public String toString() {
    	return name;
    }
}
